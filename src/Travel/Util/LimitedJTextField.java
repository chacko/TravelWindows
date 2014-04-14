/**
 * 
 */
package Travel.Util;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * @author from forum.codecall.net
 * modified by 	:	George 
 * modification	:	removed modifier static for member variable limit
 *				:	removed modifer static for class	LimitedLengthDocument
 *				: 	so that it can be used for multiple text fields
 *modified date	:	15th Mar 2014	 
 */

public class LimitedJTextField extends JTextField
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static int limit;
	private int limit;

	public LimitedJTextField(int limit) 
	{
		super();
		setLimit(limit);
	}

	public int getLimit() {
		return this.limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	protected Document createDefaultModel() {
		return new LimitedLengthDocument();
	}

	class LimitedLengthDocument extends PlainDocument 
	{
		
		public void insertString(int offs, String str, AttributeSet a)
				throws BadLocationException {
			if( str == null )
				return;
			
			if( (getLength() + str.length()) <= limit )
				super.insertString(offs, str, a);
				
		}
	}
}
