import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EncodeListener implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		String en="";
		if(ev.getSource()==ETeCSMenu.getShiftJIS()){
			en="Shift_JIS";
		}
		else if (ev.getSource()==ETeCSMenu.getUtf8()){
			en="UTF-8";
		}
		else if (ev.getSource()==ETeCSMenu.getMS932()){
			en="MS932";
		}
			MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
			int caret = myTxt.getTxt().getCaretPosition();
			//System.out.println(caret);
			String str =  myTxt.getTxt().getText();
			myTxt.removeString();
			try{
				str = new String(str.getBytes(en),en);

			}catch(Exception e){
				JOptionPane.showMessageDialog(new JFrame(),"文字列の変換に失敗しました");
			}
		myTxt.insertString(str);
		myTxt.getTxt().setCaretPosition(caret);
		ETeCS.main.setNotice("文字コードを"+en+"にしました");
		}

}
