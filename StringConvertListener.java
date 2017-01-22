import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringConvertListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
			try{
				MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
				int caret = myTxt.getArea().getCaretPosition();
				String str = myTxt.getArea().getText();
				//System.out.println(str);
				//System.out.println("-------------------------------------------------------");
				myTxt.removeString();
				myTxt.insertString(str.toUpperCase());
				myTxt.getArea().setCaretPosition(caret);
			}catch(Exception ex){
				System.out.println(ex);
				return;
			}

		}
}
