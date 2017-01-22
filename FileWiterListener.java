import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FileWiterListener implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
		FileManager.fileWriter(ETeCS.fileAddress,myTxt.getArea().getText());
		ETeCS.main.setNotice(ETeCS.fileAddress.getName()+"に上書きしました");

	}

}
