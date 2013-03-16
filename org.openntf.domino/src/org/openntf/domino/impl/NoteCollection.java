/*
 * Copyright OpenNTF 2013
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package org.openntf.domino.impl;

import java.util.Vector;

import lotus.domino.Agent;
import lotus.domino.Document;
import lotus.domino.DocumentCollection;
import lotus.domino.Form;
import lotus.domino.NotesException;
import lotus.domino.View;

import org.openntf.domino.DateTime;
import org.openntf.domino.utils.DominoUtils;
import org.openntf.domino.utils.Factory;

// TODO: Auto-generated Javadoc
/**
 * The Class NoteCollection.
 */
public class NoteCollection extends org.openntf.domino.impl.Base<org.openntf.domino.NoteCollection, lotus.domino.NoteCollection> implements
		org.openntf.domino.NoteCollection {
	
	/**
	 * Instantiates a new note collection.
	 * 
	 * @param delegate
	 *            the delegate
	 * @param parent
	 *            the parent
	 */
	public NoteCollection(lotus.domino.NoteCollection delegate, org.openntf.domino.Base<?> parent) {
		super(delegate, Factory.getParentDatabase(parent));
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#add(int)
	 */
	@Override
	public void add(int additionSpecifier) {
		try {
			getDelegate().add(additionSpecifier);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#add(int[])
	 */
	@Override
	public void add(int[] additionSpecifier) {
		try {
			getDelegate().add(additionSpecifier);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#add(lotus.domino.Agent)
	 */
	@Override
	public void add(lotus.domino.Agent additionSpecifier) {
		try {
			getDelegate().add(additionSpecifier);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#add(lotus.domino.Document)
	 */
	@Override
	public void add(lotus.domino.Document additionSpecifier) {
		try {
			getDelegate().add(additionSpecifier);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#add(lotus.domino.DocumentCollection)
	 */
	@Override
	public void add(lotus.domino.DocumentCollection additionSpecifier) {
		try {
			getDelegate().add(additionSpecifier);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#add(lotus.domino.Form)
	 */
	@Override
	public void add(lotus.domino.Form additionSpecifier) {
		try {
			getDelegate().add(additionSpecifier);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#add(lotus.domino.NoteCollection)
	 */
	@Override
	public void add(lotus.domino.NoteCollection additionSpecifier) {
		try {
			getDelegate().add(additionSpecifier);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#add(lotus.domino.View)
	 */
	@Override
	public void add(lotus.domino.View additionSpecifier) {
		try {
			getDelegate().add(additionSpecifier);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#add(java.lang.String)
	 */
	@Override
	public void add(String additionSpecifier) {
		try {
			getDelegate().add(additionSpecifier);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#buildCollection()
	 */
	@Override
	public void buildCollection() {
		try {
			getDelegate().buildCollection();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#clearCollection()
	 */
	@Override
	public void clearCollection() {
		try {
			getDelegate().clearCollection();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getCount()
	 */
	@Override
	public int getCount() {
		try {
			return getDelegate().getCount();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getFirstNoteID()
	 */
	@Override
	public String getFirstNoteID() {
		try {
			return getDelegate().getFirstNoteID();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getLastBuildTime()
	 */
	@Override
	public DateTime getLastBuildTime() {
		try {
			return Factory.fromLotus(getDelegate().getLastBuildTime(), DateTime.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getLastNoteID()
	 */
	@Override
	public String getLastNoteID() {
		try {
			return getDelegate().getLastNoteID();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getNextNoteID(java.lang.String)
	 */
	@Override
	public String getNextNoteID(String noteId) {
		try {
			return getDelegate().getNextNoteID(noteId);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getNoteIDs()
	 */
	@Override
	public int[] getNoteIDs() {
		try {
			return getDelegate().getNoteIDs();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.impl.Base#getParent()
	 */
	@Override
	public org.openntf.domino.Database getParent() {
		return (org.openntf.domino.Database) super.getParent();
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getPrevNoteID(java.lang.String)
	 */
	@Override
	public String getPrevNoteID(String noteId) {
		try {
			return getDelegate().getPrevNoteID(noteId);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectAcl()
	 */
	@Override
	public boolean getSelectAcl() {
		try {
			return getDelegate().getSelectAcl();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectActions()
	 */
	@Override
	public boolean getSelectActions() {
		try {
			return getDelegate().getSelectActions();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectAgents()
	 */
	@Override
	public boolean getSelectAgents() {
		try {
			return getDelegate().getSelectAgents();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectDatabaseScript()
	 */
	@Override
	public boolean getSelectDatabaseScript() {
		try {
			return getDelegate().getSelectDatabaseScript();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectDataConnections()
	 */
	@Override
	public boolean getSelectDataConnections() {
		try {
			return getDelegate().getSelectDataConnections();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectDocuments()
	 */
	@Override
	public boolean getSelectDocuments() {
		try {
			return getDelegate().getSelectDocuments();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectFolders()
	 */
	@Override
	public boolean getSelectFolders() {
		try {
			return getDelegate().getSelectFolders();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectForms()
	 */
	@Override
	public boolean getSelectForms() {
		try {
			return getDelegate().getSelectForms();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectFramesets()
	 */
	@Override
	public boolean getSelectFramesets() {
		try {
			return getDelegate().getSelectFramesets();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectHelpAbout()
	 */
	@Override
	public boolean getSelectHelpAbout() {
		try {
			return getDelegate().getSelectHelpAbout();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectHelpIndex()
	 */
	@Override
	public boolean getSelectHelpIndex() {
		try {
			return getDelegate().getSelectHelpIndex();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectHelpUsing()
	 */
	@Override
	public boolean getSelectHelpUsing() {
		try {
			return getDelegate().getSelectHelpUsing();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectIcon()
	 */
	@Override
	public boolean getSelectIcon() {
		try {
			return getDelegate().getSelectIcon();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectImageResources()
	 */
	@Override
	public boolean getSelectImageResources() {
		try {
			return getDelegate().getSelectImageResources();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectionFormula()
	 */
	@Override
	public String getSelectionFormula() {
		try {
			return getDelegate().getSelectionFormula();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectJavaResources()
	 */
	@Override
	public boolean getSelectJavaResources() {
		try {
			return getDelegate().getSelectJavaResources();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectMiscCodeElements()
	 */
	@Override
	public boolean getSelectMiscCodeElements() {
		try {
			return getDelegate().getSelectMiscCodeElements();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectMiscFormatElements()
	 */
	@Override
	public boolean getSelectMiscFormatElements() {
		try {
			return getDelegate().getSelectMiscFormatElements();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectMiscIndexElements()
	 */
	@Override
	public boolean getSelectMiscIndexElements() {
		try {
			return getDelegate().getSelectMiscIndexElements();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectNavigators()
	 */
	@Override
	public boolean getSelectNavigators() {
		try {
			return getDelegate().getSelectNavigators();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectOutlines()
	 */
	@Override
	public boolean getSelectOutlines() {
		try {
			return getDelegate().getSelectOutlines();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectPages()
	 */
	@Override
	public boolean getSelectPages() {
		try {
			return getDelegate().getSelectPages();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectProfiles()
	 */
	@Override
	public boolean getSelectProfiles() {
		try {
			return getDelegate().getSelectProfiles();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectReplicationFormulas()
	 */
	@Override
	public boolean getSelectReplicationFormulas() {
		try {
			return getDelegate().getSelectReplicationFormulas();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectScriptLibraries()
	 */
	@Override
	public boolean getSelectScriptLibraries() {
		try {
			return getDelegate().getSelectScriptLibraries();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectSharedFields()
	 */
	public boolean getSelectSharedFields() {
		try {
			return getDelegate().getSelectSharedFields();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectStylesheetResources()
	 */
	public boolean getSelectStylesheetResources() {
		try {
			return getDelegate().getSelectStylesheetResources();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectSubforms()
	 */
	public boolean getSelectSubforms() {
		try {
			return getDelegate().getSelectSubforms();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSelectViews()
	 */
	public boolean getSelectViews() {
		try {
			return getDelegate().getSelectViews();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getSinceTime()
	 */
	public DateTime getSinceTime() {
		try {
			return Factory.fromLotus(getDelegate().getSinceTime(), DateTime.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getUNID(java.lang.String)
	 */
	public String getUNID(String unid) {
		try {
			return getDelegate().getUNID(unid);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#getUntilTime()
	 */
	public DateTime getUntilTime() {
		try {
			return Factory.fromLotus(getDelegate().getUntilTime(), DateTime.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#intersect(lotus.domino.Agent)
	 */
	public void intersect(Agent agent) {
		try {
			getDelegate().intersect(agent);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#intersect(lotus.domino.Document)
	 */
	public void intersect(Document document) {
		try {
			getDelegate().intersect(document);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#intersect(lotus.domino.DocumentCollection)
	 */
	public void intersect(DocumentCollection collection) {
		try {
			getDelegate().intersect(collection);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#intersect(lotus.domino.Form)
	 */
	public void intersect(Form form) {
		try {
			getDelegate().intersect(form);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#intersect(int)
	 */
	public void intersect(int noteId) {
		try {
			getDelegate().intersect(noteId);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#intersect(lotus.domino.NoteCollection)
	 */
	public void intersect(lotus.domino.NoteCollection collection) {
		try {
			getDelegate().intersect(collection);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#intersect(java.lang.String)
	 */
	public void intersect(String noteId) {
		try {
			getDelegate().intersect(noteId);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#intersect(lotus.domino.View)
	 */
	public void intersect(View view) {
		try {
			getDelegate().intersect(view);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.impl.Base#recycle()
	 */
	@Override
	public void recycle() {
		try {
			getDelegate().recycle();
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.impl.Base#recycle(java.util.Vector)
	 */
	@Override
	public void recycle(Vector objects) {
		try {
			getDelegate().recycle(objects);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#remove(lotus.domino.Agent)
	 */
	public void remove(Agent agent) {
		try {
			getDelegate().remove(agent);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#remove(lotus.domino.Document)
	 */
	public void remove(Document document) {
		try {
			getDelegate().remove(document);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#remove(lotus.domino.DocumentCollection)
	 */
	public void remove(DocumentCollection collection) {
		try {
			getDelegate().remove(collection);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#remove(lotus.domino.Form)
	 */
	public void remove(Form form) {
		try {
			getDelegate().remove(form);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#remove(int)
	 */
	public void remove(int noteId) {
		try {
			getDelegate().remove(noteId);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#remove(lotus.domino.NoteCollection)
	 */
	public void remove(lotus.domino.NoteCollection collection) {
		try {
			getDelegate().remove(collection);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#remove(java.lang.String)
	 */
	public void remove(String noteId) {
		try {
			getDelegate().remove(noteId);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#remove(lotus.domino.View)
	 */
	public void remove(View view) {
		try {
			getDelegate().remove(view);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#selectAllAdminNotes(boolean)
	 */
	public void selectAllAdminNotes(boolean flag) {
		try {
			getDelegate().selectAllAdminNotes(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#selectAllCodeElements(boolean)
	 */
	public void selectAllCodeElements(boolean flag) {
		try {
			getDelegate().selectAllCodeElements(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#selectAllDataNotes(boolean)
	 */
	public void selectAllDataNotes(boolean flag) {
		try {
			getDelegate().selectAllDataNotes(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#selectAllDesignElements(boolean)
	 */
	public void selectAllDesignElements(boolean flag) {
		try {
			getDelegate().selectAllDesignElements(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#selectAllFormatElements(boolean)
	 */
	public void selectAllFormatElements(boolean flag) {
		try {
			getDelegate().selectAllFormatElements(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#selectAllIndexElements(boolean)
	 */
	public void selectAllIndexElements(boolean flag) {
		try {
			getDelegate().selectAllIndexElements(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#selectAllNotes(boolean)
	 */
	public void selectAllNotes(boolean flag) {
		try {
			getDelegate().selectAllNotes(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectAcl(boolean)
	 */
	public void setSelectAcl(boolean flag) {
		try {
			getDelegate().setSelectAcl(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectActions(boolean)
	 */
	public void setSelectActions(boolean flag) {
		try {
			getDelegate().setSelectActions(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectAgents(boolean)
	 */
	public void setSelectAgents(boolean flag) {
		try {
			getDelegate().setSelectAgents(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectDatabaseScript(boolean)
	 */
	public void setSelectDatabaseScript(boolean flag) {
		try {
			getDelegate().setSelectDatabaseScript(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see lotus.domino.NoteCollection#setSelectDataConnections(boolean)
	 */
	public void setSelectDataConnections(boolean flag) {
		try {
			getDelegate().setSelectDataConnections(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectDocuments(boolean)
	 */
	public void setSelectDocuments(boolean flag) {
		try {
			getDelegate().setSelectDocuments(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectFolders(boolean)
	 */
	public void setSelectFolders(boolean flag) {
		try {
			getDelegate().setSelectFolders(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectForms(boolean)
	 */
	public void setSelectForms(boolean flag) {
		try {
			getDelegate().setSelectForms(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectFramesets(boolean)
	 */
	public void setSelectFramesets(boolean flag) {
		try {
			getDelegate().setSelectFramesets(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectHelpAbout(boolean)
	 */
	public void setSelectHelpAbout(boolean flag) {
		try {
			getDelegate().setSelectHelpAbout(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectHelpIndex(boolean)
	 */
	public void setSelectHelpIndex(boolean flag) {
		try {
			getDelegate().setSelectHelpIndex(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectHelpUsing(boolean)
	 */
	public void setSelectHelpUsing(boolean flag) {
		try {
			getDelegate().setSelectHelpUsing(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectIcon(boolean)
	 */
	public void setSelectIcon(boolean flag) {
		try {
			getDelegate().setSelectIcon(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectImageResources(boolean)
	 */
	public void setSelectImageResources(boolean flag) {
		try {
			getDelegate().setSelectImageResources(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectionFormula(java.lang.String)
	 */
	public void setSelectionFormula(String flag) {
		try {
			getDelegate().setSelectionFormula(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectJavaResources(boolean)
	 */
	public void setSelectJavaResources(boolean flag) {
		try {
			getDelegate().setSelectJavaResources(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectMiscCodeElements(boolean)
	 */
	public void setSelectMiscCodeElements(boolean flag) {
		try {
			getDelegate().setSelectMiscCodeElements(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectMiscFormatElements(boolean)
	 */
	public void setSelectMiscFormatElements(boolean flag) {
		try {
			getDelegate().setSelectMiscFormatElements(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectMiscIndexElements(boolean)
	 */
	public void setSelectMiscIndexElements(boolean flag) {
		try {
			getDelegate().setSelectMiscIndexElements(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectNavigators(boolean)
	 */
	public void setSelectNavigators(boolean flag) {
		try {
			getDelegate().setSelectNavigators(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectOutlines(boolean)
	 */
	public void setSelectOutlines(boolean flag) {
		try {
			getDelegate().setSelectOutlines(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectPages(boolean)
	 */
	public void setSelectPages(boolean flag) {
		try {
			getDelegate().setSelectPages(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectProfiles(boolean)
	 */
	public void setSelectProfiles(boolean flag) {
		try {
			getDelegate().setSelectProfiles(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectReplicationFormulas(boolean)
	 */
	public void setSelectReplicationFormulas(boolean flag) {
		try {
			getDelegate().setSelectReplicationFormulas(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectScriptLibraries(boolean)
	 */
	public void setSelectScriptLibraries(boolean flag) {
		try {
			getDelegate().setSelectScriptLibraries(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectSharedFields(boolean)
	 */
	public void setSelectSharedFields(boolean flag) {
		try {
			getDelegate().setSelectSharedFields(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectStylesheetResources(boolean)
	 */
	public void setSelectStylesheetResources(boolean flag) {
		try {
			getDelegate().setSelectStylesheetResources(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectSubforms(boolean)
	 */
	public void setSelectSubforms(boolean flag) {
		try {
			getDelegate().setSelectSubforms(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSelectViews(boolean)
	 */
	public void setSelectViews(boolean flag) {
		try {
			getDelegate().setSelectViews(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.NoteCollection#setSinceTime(lotus.domino.DateTime)
	 */
	public void setSinceTime(lotus.domino.DateTime date) {
		try {
			getDelegate().setSinceTime(date);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

}