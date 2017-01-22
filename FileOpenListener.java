import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;


public class FileOpenListener implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		JFileChooser fileChooser = new JFileChooser(ETeCS.fileAddress.getPath());
	    int selected = fileChooser.showOpenDialog(null);
	    if (selected == JFileChooser.APPROVE_OPTION){
	    	File file = fileChooser.getSelectedFile();
	    	ETeCS.fileAddress=file;
	        String st=FileManager.fileLoader((file));
	        //System.out.println(st);
	        MyTextArea myArea=new MyTextArea(st);
			ETeCS.main.tab.addTab(file.getName(),myArea);
	        ETeCS.main.setNotice(file.getName()+"を開きました");
	        ETeCS.fileAddress=file;
			//ETeCS.getInsert().addSubRoutine();
	        ETeCS.main.tab.setSelectedIndex(ETeCS.main.tab.getTabCount()-1);
	        MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
	        myTxt.getTxt().setCaretPosition(0);
	    }


	}

}
