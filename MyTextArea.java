import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.undo.UndoManager;
public class MyTextArea extends JPanel{
	private JTextPane txt;
	private UndoManager undoManager;
	private StyleContext sc;
	private DefaultStyledDocument doc;
	public static String initial;
	private  MutableAttributeSet attr = new SimpleAttributeSet();
	MyTextArea(String st){
		StyleConstants.setForeground(attr,Color.red);
		sc = new StyleContext();
		doc = new DefaultStyledDocument(sc);
		txt = new JTextPane();
		txt.setDocument(doc);
		try{
			doc.insertString(0, st, null);
		}catch(BadLocationException e){

		}

		setLayout(new GridLayout());

		undoManager = new UndoManager();
		txt.getDocument().addUndoableEditListener(undoManager);
		JScrollPane scrollpane = new JScrollPane(getArea(),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollpane);

		//txt.addKeyListener(new StringConvertListener());
		txt.addKeyListener(new ShortCutListener());



	}
	MyTextArea(){
		StyleConstants.setForeground(attr,Color.red);
		sc = new StyleContext();
		doc = new DefaultStyledDocument(sc);
		txt = new JTextPane();
		txt.setDocument(doc);
		try{
			doc.insertString(0, initial, null);
		}catch(BadLocationException e){

		}

		setLayout(new GridLayout());

		undoManager = new UndoManager();
		txt.getDocument().addUndoableEditListener(undoManager);
		JScrollPane scrollpane = new JScrollPane(getArea(),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollpane);

		//txt.addKeyListener(new StringConvertListener());
		txt.addKeyListener(new ShortCutListener());

	}
	public JTextPane getArea() {
		return txt;
	}

	public void insertString(String str) {
	    try{
	        this.doc.insertString(txt.getCaretPosition(),str,null);
	      }catch (BadLocationException ble){
	    	  ETeCS.main.setNotice("挿入に失敗しました");
	      }
	}

	public void insertStringRed(String str){
		try{
			this.doc.insertString(txt.getCaretPosition(),str,attr);
		}catch(BadLocationException ble){
			ETeCS.main.setNotice("挿入に失敗しました");
		}
	}

	public void removeString(){
		try{
			this.doc.remove(0, doc.getLength());
		}catch(BadLocationException e){
			return;
		}
	}


	public void settxt(JTextPane area){
		this.txt = area;
	}
	public JTextPane getTxt(){
		return this.txt;
	}

	public UndoManager getUndoManager(){
		return undoManager;
	}
}
