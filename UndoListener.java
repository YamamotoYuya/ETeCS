import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.undo.CannotUndoException;


public class UndoListener implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		try{
			MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
			myTxt.getUndoManager().undo();
		}catch(ArrayIndexOutOfBoundsException ex){

		}catch(CannotUndoException e){

		}
	}

}
