import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;


public class ShortCutListener implements KeyListener{
	public void keyPressed(KeyEvent e){
		if((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK)!=0 && e.getKeyCode()==KeyEvent.VK_S){
			if((e.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK)!=0){
				try{
					//MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
				}catch(Exception ex){
					ETeCS.main.setNotice("ファイルが開かれているか確認して下さい");
					return;
				}
				JFileChooser filechooser = new JFileChooser();
				int selected = filechooser.showSaveDialog(ETeCS.main);

			    if (selected == JFileChooser.APPROVE_OPTION){
			    		File newFile = filechooser.getSelectedFile();
			    		try{
			    			newFile.createNewFile();
			    		}catch(IOException IOE){

			    		}
			      }else if (selected == JFileChooser.CANCEL_OPTION){

			      }else if (selected == JFileChooser.ERROR_OPTION){

			      }
			}
			else{
				try{
					MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
					FileManager.fileWriter(ETeCS.fileAddress,myTxt.getArea().getText());
				}catch(Exception ex){
					ETeCS.main.setNotice("ファイルが開かれているか確認して下さい");
					return;
				}
			}

		}
		if((e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK)!=0){
			if(e.getKeyCode()==KeyEvent.VK_Z){
				try{
					MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
					myTxt.getUndoManager().undo();
				}catch(ArrayIndexOutOfBoundsException ex){

				}catch(CannotUndoException CantE){

				}
			}
			if(e.getKeyCode()==KeyEvent.VK_Y){
				try{
					MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
					myTxt.getUndoManager().redo();
				}catch(ArrayIndexOutOfBoundsException ex){

				}catch(CannotRedoException Cante){

				}
			}
		}

	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
