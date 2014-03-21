/* Generated By:JJTree: Do not edit this line. ASTValueDouble.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
/*
 * © Copyright FOCONIS AG, 2014
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
package org.openntf.domino.formula.ast;

import org.openntf.domino.formula.AtFormulaParser;
import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.ValueHolder;

public class ASTValueDouble extends SimpleNode {
	private ValueHolder value;

	public ASTValueDouble(final int id) {
		super(id);
	}

	public ASTValueDouble(final AtFormulaParser p, final int id) {
		super(p, id);
	}

	public void parseDouble(final String image, final char decSep) {
		double d = Double.valueOf(image.replace(decSep, '.'));
		value = ValueHolder.valueOf(d);
	}

	@Override
	public String toString() {
		return super.toString() + ": " + value;
	}

	@Override
	public ValueHolder evaluate(final FormulaContext ctx) {
		return value;
	}

	@Override
	public void toFormula(final StringBuilder sb) {
		sb.append(String.format("%f", value.getDouble(0)));
	}
}
/* JavaCC - OriginalChecksum=9b835a55bffc1c99424d097a944b0fac (do not edit this line) */
