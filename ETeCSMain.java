import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ETeCSMain extends JPanel{
	private JTextArea txtA = new JTextArea();
	private JLabel notice = new JLabel();
	static Container cont;
	static JFrame fr = new JFrame();
	ETeCSMain(){
		setNotice("ETeCS.ver1.0");
		setLayout(new BorderLayout());
		add(notice,BorderLayout.SOUTH);
		//add(txtA,BorderLayout.CENTER);
	}

	void addMain(){
		setTxtA(new JTextArea("txtA"));
		add(getTxtA(),BorderLayout.CENTER);
		revalidate();


	}

	 void removeMain(){
		 remove(txtA);
		 repaint();

	}






	public JTextArea getTxtA() {
		return txtA;
	}

	public void setTxtA(JTextArea txtA) {
		this.txtA = txtA;
	}

	public String getNotice() {
		return notice.getName();
	}

	public void setNotice(String st) {
		notice.setText(st);
	}

}
