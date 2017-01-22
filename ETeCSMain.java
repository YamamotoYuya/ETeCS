import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

//"image\\ETeCSIcon.png"
public class ETeCSMain extends JPanel{
	private JTextArea txtA = new JTextArea();
	private JLabel notice = new JLabel();
	public JTabbedPane tab;
	private static ArrayList<MyTextArea> areaList = new ArrayList<MyTextArea>();
	private static Image img;

	ETeCSMain(){
		try{
			img = getToolkit().getImage("image\\ETeCSIcon2.png");
		}catch(Exception e){

		}


		tab = new JTabbedPane();
		setNotice("ETeCS.ver1.0");
		notice.setMaximumSize(new Dimension(10000, 70));//最大サイズの設定
		notice.setPreferredSize(new Dimension(2000, 50));//サイズの設定
		notice.setFont(new Font("", Font.BOLD, 20));
		setLayout(new BorderLayout());
		add(tab, BorderLayout.CENTER);
		add(notice,BorderLayout.SOUTH);



	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,100,100,this);
	}


	public JTextArea getTxtA() {
		return txtA;
	}

	public String getTxtAString(){
		return txtA.getText();
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

	public void getArrayList(int in){
		areaList.get(in);
	}

	public void setArrayList(int in,MyTextArea area){
		areaList.set(in,area);
	}

}
