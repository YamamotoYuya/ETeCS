import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ColorResetListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
		String str = myTxt.getTxt().getText();
		myTxt.removeString();
		myTxt.insertString(str);
	}

}
