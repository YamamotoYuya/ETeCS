import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;


public class FileSaveAsListener implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		try{
			//MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
		}catch(Exception e){
			ETeCS.main.setNotice("ファイルが開かれているか確認して下さい");
			return;
		}
		JFileChooser filechooser = new JFileChooser();
		int selected = filechooser.showSaveDialog(ETeCS.main);

	    if (selected == JFileChooser.APPROVE_OPTION){
	    		File newFile = filechooser.getSelectedFile();
	    		try{
	    			newFile.createNewFile();
					ETeCS.fileAddress=newFile;
					//ETeCS.getInsert().addSubRoutine();
	    			ETeCS.main.tab.setTitleAt(ETeCS.main.tab.getSelectedIndex(),newFile.getName());
	    			ETeCS.main.setNotice(ETeCS.fileAddress.getName()+"に上書きしました");
	    		}catch(IOException e){

	    		}
	      }else if (selected == JFileChooser.CANCEL_OPTION){

	      }else if (selected == JFileChooser.ERROR_OPTION){

	      }

	}

}
