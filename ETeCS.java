import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;


public class ETeCS extends JFrame {
	static ETeCSMain main = new ETeCSMain();
	static Container mainPane;


	public static void main (String args[]){
		new ETeCS();
	}


	ETeCS(){
		mainPane = getContentPane();
		
		ETeCSMenu  menu = new ETeCSMenu();
		ETeCSInsert insert = new ETeCSInsert();

		setSize(900,600);
		setTitle("ETeCS");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);//準備

		add(main,BorderLayout.CENTER);
		add(menu,BorderLayout.NORTH);
		add(insert,BorderLayout.EAST);
		//コンポーネントを乗せる

		setVisible(true);

	}




}

