/*
 *******************************************************************************
 * Copyright (C) 2009-2012, International Business Machines Corporation and    *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 */
package com.ibm.icu.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.text.LocaleDisplayNames;
import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;

@SuppressWarnings("deprecation")
public class LocaleDisplayNamesImpl extends LocaleDisplayNames {
	private final ULocale locale;
	private final DialectHandling dialectHandling;
	private final DisplayContext capitalization;
	private final DataTable langData;
	private final DataTable regionData;
	private final Appender appender;
	private final MessageFormat format;
	private final MessageFormat keyTypeFormat;

	private static final Cache cache = new Cache();

	/**
	 * Capitalization context usage types for locale display names
	 */
	private enum CapitalizationContextUsage {
		LANGUAGE, SCRIPT, TERRITORY, VARIANT, KEY, TYPE
	}

	/**
	 * Capitalization transforms. For each usage type, the first array element indicates whether to titlecase for uiListOrMenu context, the
	 * second indicates whether to titlecase for stand-alone context.
	 */
	private Map<CapitalizationContextUsage, boolean[]> capitalizationUsage = null;
	/**
	 * Map from resource key to CapitalizationContextUsage value
	 */
	private static final Map<String, CapitalizationContextUsage> contextUsageTypeMap;
	static {
		contextUsageTypeMap = new HashMap<String, CapitalizationContextUsage>();
		contextUsageTypeMap.put("languages", CapitalizationContextUsage.LANGUAGE);
		contextUsageTypeMap.put("script", CapitalizationContextUsage.SCRIPT);
		contextUsageTypeMap.put("territory", CapitalizationContextUsage.TERRITORY);
		contextUsageTypeMap.put("variant", CapitalizationContextUsage.VARIANT);
		contextUsageTypeMap.put("key", CapitalizationContextUsage.KEY);
		contextUsageTypeMap.put("type", CapitalizationContextUsage.TYPE);
	}

	public static LocaleDisplayNames getInstance(final ULocale locale, final DialectHandling dialectHandling) {
		synchronized (cache) {
			return cache.get(locale, dialectHandling);
		}
	}

	public static LocaleDisplayNames getInstance(final ULocale locale, final DisplayContext... contexts) {
		synchronized (cache) {
			return cache.get(locale, contexts);
		}
	}

	public LocaleDisplayNamesImpl(final ULocale locale, final DialectHandling dialectHandling) {
		this(locale, (dialectHandling == DialectHandling.STANDARD_NAMES) ? DisplayContext.STANDARD_NAMES : DisplayContext.DIALECT_NAMES,
				DisplayContext.CAPITALIZATION_NONE);
	}

	public LocaleDisplayNamesImpl(final ULocale locale, final DisplayContext... contexts) {
		DialectHandling dialectHandling = DialectHandling.STANDARD_NAMES;
		DisplayContext capitalization = DisplayContext.CAPITALIZATION_NONE;
		for (DisplayContext contextItem : contexts) {
			switch (contextItem.type()) {
			case DIALECT_HANDLING:
				dialectHandling = (contextItem.value() == DisplayContext.STANDARD_NAMES.value()) ? DialectHandling.STANDARD_NAMES
						: DialectHandling.DIALECT_NAMES;
				break;
			case CAPITALIZATION:
				capitalization = contextItem;
				break;
			default:
				break;
			}
		}

		this.dialectHandling = dialectHandling;
		this.capitalization = capitalization;
		this.langData = LangDataTables.impl.get(locale);
		this.regionData = RegionDataTables.impl.get(locale);
		this.locale = ULocale.ROOT.equals(langData.getLocale()) ? regionData.getLocale() : langData.getLocale();

		// Note, by going through DataTable, this uses table lookup rather than straight lookup.
		// That should get us the same data, I think.  This way we don't have to explicitly
		// load the bundle again.  Using direct lookup didn't seem to make an appreciable
		// difference in performance.
		String sep = langData.get("localeDisplayPattern", "separator");
		if ("separator".equals(sep)) {
			sep = ", ";
		}
		this.appender = new Appender(sep);

		String pattern = langData.get("localeDisplayPattern", "pattern");
		if ("pattern".equals(pattern)) {
			pattern = "{0} ({1})";
		}
		this.format = new MessageFormat(pattern);

		String keyTypePattern = langData.get("localeDisplayPattern", "keyTypePattern");
		if ("keyTypePattern".equals(keyTypePattern)) {
			keyTypePattern = "{0}={1}";
		}
		this.keyTypeFormat = new MessageFormat(keyTypePattern);

		// Get values from the contextTransforms data
		// (copied from DateFormatSymbols)
		if (capitalization == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU
				|| capitalization == DisplayContext.CAPITALIZATION_FOR_STANDALONE) {
			capitalizationUsage = new HashMap<CapitalizationContextUsage, boolean[]>();
			boolean[] noTransforms = new boolean[2];
			noTransforms[0] = false;
			noTransforms[1] = false;
			CapitalizationContextUsage allUsages[] = CapitalizationContextUsage.values();
			for (CapitalizationContextUsage usage : allUsages) {
				capitalizationUsage.put(usage, noTransforms);
			}
			ICUResourceBundle rb = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUResourceBundle.ICU_BASE_NAME, locale);
			UResourceBundle contextTransformsBundle = null;
			try {
				contextTransformsBundle = (UResourceBundle) rb.getWithFallback("contextTransforms");
			} catch (MissingResourceException e) {
				contextTransformsBundle = null; // probably redundant
			}
			if (contextTransformsBundle != null) {
				UResourceBundleIterator ctIterator = contextTransformsBundle.getIterator();
				while (ctIterator.hasNext()) {
					UResourceBundle contextTransformUsage = ctIterator.next();
					int[] intVector = contextTransformUsage.getIntVector();
					if (intVector.length >= 2) {
						String usageKey = contextTransformUsage.getKey();
						CapitalizationContextUsage usage = contextUsageTypeMap.get(usageKey);
						if (usage != null) {
							boolean[] transforms = new boolean[2];
							transforms[0] = (intVector[0] != 0);
							transforms[1] = (intVector[1] != 0);
							capitalizationUsage.put(usage, transforms);
						}
					}
				}
			}
		}
	}

	@Override
	public ULocale getLocale() {
		return locale;
	}

	@Override
	public DialectHandling getDialectHandling() {
		return dialectHandling;
	}

	@Override
	public DisplayContext getContext(final DisplayContext.Type type) {
		DisplayContext result;
		switch (type) {
		case DIALECT_HANDLING:
			result = (dialectHandling == DialectHandling.STANDARD_NAMES) ? DisplayContext.STANDARD_NAMES : DisplayContext.DIALECT_NAMES;
			break;
		case CAPITALIZATION:
			result = capitalization;
			break;
		default:
			result = DisplayContext.STANDARD_NAMES; // hmm, we should do something else here
			break;
		}
		return result;
	}

	private String adjustForUsageAndContext(final CapitalizationContextUsage usage, final String name) {
		String result = name;
		boolean titlecase = false;
		switch (capitalization) {
		case CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE:
			titlecase = true;
			break;
		case CAPITALIZATION_FOR_UI_LIST_OR_MENU:
		case CAPITALIZATION_FOR_STANDALONE:
			if (capitalizationUsage != null) {
				boolean[] transforms = capitalizationUsage.get(usage);
				titlecase = (capitalization == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU) ? transforms[0] : transforms[1];
			}
			break;
		default:
			break;
		}
		if (titlecase) {
			// TODO: Fix this titlecase hack when we figure out something better to do.
			// We don't want to titlecase the whole text, only something like the first word,
			// of the first segment long enough to have a complete cluster, whichever is
			// shorter. We could have keep a word break iterator around, but I am not sure
			// that will do the ight thing for the purposes here. For now we assume that in
			// languages for which titlecasing makes a difference, we can stop at non-letter
			// characters in 0x0000-0x00FF and only titlecase up to the first occurrence of
			// any of those, or to a small number of chars, whichever comes first.
			int stopPos, stopPosLimit = 8, len = name.length();
			if (stopPosLimit > len) {
				stopPosLimit = len;
			}
			for (stopPos = 0; stopPos < stopPosLimit; stopPos++) {
				int ch = name.codePointAt(stopPos);
				if ((ch < 0x41) || (ch > 0x5A && ch < 0x61) || (ch > 0x7A && ch < 0xC0)) {
					break;
				}
				if (ch >= 0x10000) {
					stopPos++;
				}
			}
			if (stopPos > 0 && stopPos < len) {
				String firstWord = name.substring(0, stopPos);
				String firstWordTitleCase = UCharacter.toTitleCase(locale, firstWord, null, UCharacter.TITLECASE_NO_LOWERCASE
						| UCharacter.TITLECASE_NO_BREAK_ADJUSTMENT);
				result = firstWordTitleCase.concat(name.substring(stopPos));
			} else {
				// no stopPos, titlecase the whole text
				result = UCharacter.toTitleCase(locale, name, null, UCharacter.TITLECASE_NO_LOWERCASE
						| UCharacter.TITLECASE_NO_BREAK_ADJUSTMENT);
			}
		}
		return result;
	}

	@Override
	public String localeDisplayName(final ULocale locale) {
		return localeDisplayNameInternal(locale);
	}

	@Override
	public String localeDisplayName(final Locale locale) {
		return localeDisplayNameInternal(ULocale.forLocale(locale));
	}

	@Override
	public String localeDisplayName(final String localeId) {
		return localeDisplayNameInternal(new ULocale(localeId));
	}

	// TOTO: implement use of capitalization
	private String localeDisplayNameInternal(final ULocale locale) {
		// lang
		// lang (script, country, variant, keyword=value, ...)
		// script, country, variant, keyword=value, ...

		String resultName = null;

		String lang = locale.getLanguage();

		// Empty basename indicates root locale (keywords are ignored for this).
		// Our data uses 'root' to access display names for the root locale in the
		// "Languages" table.
		if (locale.getBaseName().length() == 0) {
			lang = "root";
		}
		String script = locale.getScript();
		String country = locale.getCountry();
		String variant = locale.getVariant();

		boolean hasScript = script.length() > 0;
		boolean hasCountry = country.length() > 0;
		boolean hasVariant = variant.length() > 0;

		// always have a value for lang
		if (dialectHandling == DialectHandling.DIALECT_NAMES) {
			do { // loop construct is so we can break early out of search
				if (hasScript && hasCountry) {
					String langScriptCountry = lang + '_' + script + '_' + country;
					String result = localeIdName(langScriptCountry);
					if (!result.equals(langScriptCountry)) {
						resultName = result;
						hasScript = false;
						hasCountry = false;
						break;
					}
				}
				if (hasScript) {
					String langScript = lang + '_' + script;
					String result = localeIdName(langScript);
					if (!result.equals(langScript)) {
						resultName = result;
						hasScript = false;
						break;
					}
				}
				if (hasCountry) {
					String langCountry = lang + '_' + country;
					String result = localeIdName(langCountry);
					if (!result.equals(langCountry)) {
						resultName = result;
						hasCountry = false;
						break;
					}
				}
			} while (false);
		}

		if (resultName == null) {
			resultName = localeIdName(lang);
		}

		StringBuilder buf = new StringBuilder();
		if (hasScript) {
			// first element, don't need appender
			buf.append(scriptDisplayNameInContext(script));
		}
		if (hasCountry) {
			appender.append(regionDisplayName(country), buf);
		}
		if (hasVariant) {
			appender.append(variantDisplayName(variant), buf);
		}

		Iterator<String> keys = locale.getKeywords();
		if (keys != null) {
			while (keys.hasNext()) {
				String key = keys.next();
				String value = locale.getKeywordValue(key);
				String keyDisplayName = keyDisplayName(key);
				String valueDisplayName = keyValueDisplayName(key, value);
				if (!valueDisplayName.equals(value)) {
					appender.append(valueDisplayName, buf);
				} else if (!key.equals(keyDisplayName)) {
					String keyValue = keyTypeFormat.format(new String[] { keyDisplayName, valueDisplayName });
					appender.append(keyValue, buf);
				} else {
					appender.append(keyDisplayName, buf).append("=").append(valueDisplayName);
				}
			}
		}

		String resultRemainder = null;
		if (buf.length() > 0) {
			resultRemainder = buf.toString();
		}

		if (resultRemainder != null) {
			resultName = format.format(new Object[] { resultName, resultRemainder });
		}

		return adjustForUsageAndContext(CapitalizationContextUsage.LANGUAGE, resultName);
	}

	private String localeIdName(final String localeId) {
		return langData.get("Languages", localeId);
	}

	@Override
	public String languageDisplayName(final String lang) {
		// Special case to eliminate non-languages, which pollute our data.
		if (lang.equals("root") || lang.indexOf('_') != -1) {
			return lang;
		}
		return adjustForUsageAndContext(CapitalizationContextUsage.LANGUAGE, langData.get("Languages", lang));
	}

	@Override
	public String scriptDisplayName(final String script) {
		String str = langData.get("Scripts%stand-alone", script);
		if (str.equals(script)) {
			str = langData.get("Scripts", script);
		}
		return adjustForUsageAndContext(CapitalizationContextUsage.SCRIPT, str);
	}

	@Override
	public String scriptDisplayNameInContext(final String script) {
		return adjustForUsageAndContext(CapitalizationContextUsage.SCRIPT, langData.get("Scripts", script));
	}

	@Override
	public String scriptDisplayName(final int scriptCode) {
		return adjustForUsageAndContext(CapitalizationContextUsage.SCRIPT, scriptDisplayName(UScript.getShortName(scriptCode)));
	}

	@Override
	public String regionDisplayName(final String region) {
		return adjustForUsageAndContext(CapitalizationContextUsage.TERRITORY, regionData.get("Countries", region));
	}

	@Override
	public String variantDisplayName(final String variant) {
		return adjustForUsageAndContext(CapitalizationContextUsage.VARIANT, langData.get("Variants", variant));
	}

	@Override
	public String keyDisplayName(final String key) {
		return adjustForUsageAndContext(CapitalizationContextUsage.KEY, langData.get("Keys", key));
	}

	@Override
	public String keyValueDisplayName(final String key, final String value) {
		return adjustForUsageAndContext(CapitalizationContextUsage.TYPE, langData.get("Types", key, value));
	}

	public static class DataTable {
		ULocale getLocale() {
			return ULocale.ROOT;
		}

		String get(final String tableName, final String code) {
			return get(tableName, null, code);
		}

		String get(final String tableName, final String subTableName, final String code) {
			return code;
		}
	}

	static class ICUDataTable extends DataTable {
		private final ICUResourceBundle bundle;

		public ICUDataTable(final String path, final ULocale locale) {
			this.bundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(path, locale.getBaseName());
		}

		@Override
		public ULocale getLocale() {
			return bundle.getULocale();
		}

		@Override
		public String get(final String tableName, final String subTableName, final String code) {
			return ICUResourceTableAccess.getTableString(bundle, tableName, subTableName, code);
		}
	}

	static abstract class DataTables {
		public abstract DataTable get(ULocale locale);

		public static DataTables load(final String className) {
			try {
				return (DataTables) Class.forName(className).newInstance();
			} catch (Throwable t) {
				final DataTable NO_OP = new DataTable();
				return new DataTables() {
					@Override
					public DataTable get(final ULocale locale) {
						return NO_OP;
					}
				};
			}
		}
	}

	static abstract class ICUDataTables extends DataTables {
		private final String path;

		protected ICUDataTables(final String path) {
			this.path = path;
		}

		@Override
		public DataTable get(final ULocale locale) {
			return new ICUDataTable(path, locale);
		}
	}

	static class LangDataTables {
		static final DataTables impl = DataTables.load("com.ibm.icu.impl.ICULangDataTables");
	}

	static class RegionDataTables {
		static final DataTables impl = DataTables.load("com.ibm.icu.impl.ICURegionDataTables");
	}

	public static enum DataTableType {
		LANG, REGION;
	}

	public static boolean haveData(final DataTableType type) {
		switch (type) {
		case LANG:
			return LangDataTables.impl instanceof ICUDataTables;
		case REGION:
			return RegionDataTables.impl instanceof ICUDataTables;
		default:
			throw new IllegalArgumentException("unknown type: " + type);
		}
	}

	static class Appender {
		private final String sep;

		Appender(final String sep) {
			this.sep = sep;
		}

		StringBuilder append(final String s, final StringBuilder b) {
			if (b.length() > 0) {
				b.append(sep);
			}
			b.append(s);
			return b;
		}
	}

	private static class Cache {
		private ULocale locale;
		private DialectHandling dialectHandling;
		private DisplayContext capitalization;
		private LocaleDisplayNames cache;

		public LocaleDisplayNames get(final ULocale locale, final DialectHandling dialectHandling) {
			if (!(dialectHandling == this.dialectHandling && DisplayContext.CAPITALIZATION_NONE == this.capitalization && locale
					.equals(this.locale))) {
				this.locale = locale;
				this.dialectHandling = dialectHandling;
				this.capitalization = DisplayContext.CAPITALIZATION_NONE;
				this.cache = new LocaleDisplayNamesImpl(locale, dialectHandling);
			}
			return cache;
		}

		public LocaleDisplayNames get(final ULocale locale, final DisplayContext... contexts) {
			DialectHandling dialectHandlingIn = DialectHandling.STANDARD_NAMES;
			DisplayContext capitalizationIn = DisplayContext.CAPITALIZATION_NONE;
			for (DisplayContext contextItem : contexts) {
				switch (contextItem.type()) {
				case DIALECT_HANDLING:
					dialectHandlingIn = (contextItem.value() == DisplayContext.STANDARD_NAMES.value()) ? DialectHandling.STANDARD_NAMES
							: DialectHandling.DIALECT_NAMES;
					break;
				case CAPITALIZATION:
					capitalizationIn = contextItem;
					break;
				default:
					break;
				}
			}
			if (!(dialectHandlingIn == this.dialectHandling && capitalizationIn == this.capitalization && locale.equals(this.locale))) {
				this.locale = locale;
				this.dialectHandling = dialectHandlingIn;
				this.capitalization = capitalizationIn;
				this.cache = new LocaleDisplayNamesImpl(locale, contexts);
			}
			return cache;
		}
	}
}
