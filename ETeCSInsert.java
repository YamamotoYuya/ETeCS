import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;



public class ETeCSInsert extends JPanel{
	static ArrayList<String> pre = new ArrayList<String>();//ボタンの名前を管理する


	static HashMap <String,String> preset = new HashMap <String,String>();//連想配列の宣言

	static ArrayList<JButton> button = new ArrayList<JButton>();//JButtonインスタンスを管理する

	ETeCSInsert(){
		pre.add("button1");//ボタンの名前の設定
		button.add(new JButton(pre.get(0)));//buttonにJButtonインスタンスを設定
		preset.put(pre.get(0),"button1");//連想配列presetにボタンの名前を引数に挿入したい文字列を格納
		button.get(0).addActionListener(new InsertStringListener());//アクションリスナーの設定

		pre.add("button2");
		button.add(new JButton(pre.get(1)));
		preset.put(pre.get(1),"button2");
		button.get(1).addActionListener(new InsertStringListener());

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(button.get(0));
		add(Box.createRigidArea(new Dimension(0,30)));//空白コンポーネントの挿入
		add(button.get(1));
	}
}
