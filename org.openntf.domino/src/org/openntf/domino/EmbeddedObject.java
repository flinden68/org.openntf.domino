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
package org.openntf.domino;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Vector;

import lotus.domino.RichTextItem;
import lotus.domino.XSLTResultTarget;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmbeddedObject.
 */
public interface EmbeddedObject extends Base<lotus.domino.EmbeddedObject>, lotus.domino.EmbeddedObject {

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#activate(boolean)
	 */
	@Override
	public int activate(boolean flag);

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#doVerb(java.lang.String)
	 */
	@Override
	public void doVerb(String verb);

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#extractFile(java.lang.String)
	 */
	@Override
	public void extractFile(String path);

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getClassName()
	 */
	@Override
	public String getClassName();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getFileSize()
	 */
	@Override
	public int getFileSize();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getInputSource()
	 */
	@Override
	public InputSource getInputSource();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getInputStream()
	 */
	@Override
	public InputStream getInputStream();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getName()
	 */
	@Override
	public String getName();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getObject()
	 */
	@Override
	public int getObject();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getParent()
	 */
	@Override
	public RichTextItem getParent();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getReader()
	 */
	@Override
	public Reader getReader();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getSource()
	 */
	@Override
	public String getSource();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getType()
	 */
	@Override
	public int getType();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#getVerbs()
	 */
	@Override
	public Vector<String> getVerbs();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#parseXML(boolean)
	 */
	@Override
	public Document parseXML(boolean validate) throws IOException;

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#remove()
	 */
	@Override
	public void remove();

	/* (non-Javadoc)
	 * @see lotus.domino.EmbeddedObject#transformXML(java.lang.Object, lotus.domino.XSLTResultTarget)
	 */
	@Override
	public void transformXML(Object style, XSLTResultTarget result);

}