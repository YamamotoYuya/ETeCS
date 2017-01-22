import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.undo.CannotRedoException;


public class RedoListener implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		try{
			MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
			myTxt.getUndoManager().redo();
		}catch(ArrayIndexOutOfBoundsException ex){

		}catch(CannotRedoException e){

		}
	}

}
