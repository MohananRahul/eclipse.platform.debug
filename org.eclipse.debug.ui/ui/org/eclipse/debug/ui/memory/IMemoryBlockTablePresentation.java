/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/


package org.eclipse.debug.ui.memory;

import java.math.BigInteger;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.ui.IDebugModelPresentation;


/**
 * Allows debug models to customize the rendering of addresses for its memory blocks
 * in table and text based renderings provided by the debug platform.
 * 
 * To contribute a memory block table presentation, implement your debug model
 * presentaion as documented in <code>org.eclipse.debug.ui.IDebugModelPresentation.</code>
 * In addition, implement this interface in your debug model presentation.  Your model
 * presentation will be called when <code>org.eclipse.debug.ui.memory.AbstractTableRendering</code>
 * contructs its column and row labels. 
 * 
 * Clients may implement this interface.
 * 
 * @since 3.1
 */
public interface IMemoryBlockTablePresentation extends IDebugModelPresentation
{
	
	/**
     * Returns a collection of labels to head columns in a <code>AbstractTableRendering</code>
     * rendering, or <code>null</code> if default labels should be used.
     *  
	 * @param blk memory block
	 * @param bytesPerLine the number if bytes to be displayed
	 * @param numColumns the number of columns the bytes are divided into 
	 * @return a collection of labels to head columns in a <code>AbstractTableRendering</code>
     * rendering, or <code>null</code> if default labels should be used
	 */
	public String[] getColumnLabels(IMemoryBlock blk, int bytesPerLine, int numColumns);
	
	
	/**
     * Renders and returns a label for a row starting at the given address within the given
     * memory block, or <code>null</code> if default rendering should be used.
     * 
	 * @param blk memory block
	 * @param address an address in the memory block
	 * @return a label for a row starting at the given address within the given
     * memory block, or <code>null</code> if default rendering should be used
	 */
	public String getRowLabel(IMemoryBlock blk, BigInteger address);
	
}
