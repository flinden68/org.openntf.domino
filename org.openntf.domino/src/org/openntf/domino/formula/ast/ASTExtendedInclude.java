/* Generated By:JJTree: Do not edit this line. ASTExtendedInclude.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.openntf.domino.formula.ast;

import org.openntf.domino.formula.AtFormulaParserImpl;
import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.FormulaReturnException;
import org.openntf.domino.formula.ValueHolder;

public class ASTExtendedInclude extends SimpleNode {
	public ASTExtendedInclude(final int id) {
		super(id);
	}

	public ASTExtendedInclude(final AtFormulaParserImpl p, final int id) {
		super(p, id);
	}

	public void toFormula(final StringBuilder sb) {
		// TODO Auto-generated method stub

	}

	@Override
	public ValueHolder evaluate(final FormulaContext ctx) throws FormulaReturnException {
		// TODO Auto-generated method stub
		return null;
	}

}
/* JavaCC - OriginalChecksum=d670e08997af3d9648b02f9aca5ac561 (do not edit this line) */
