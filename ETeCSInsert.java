import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class ETeCSInsert extends JPanel{
	private static ArrayList<String> pre = new ArrayList<String>();//ボタンの名前を管理する


	private static HashMap <String,String> preset = new HashMap <String,String>();//連想配列の宣言。ボタンで挿入したい文字列を管理し、引数はボタンの名前である。
	private static ArrayList<JButton> button = new ArrayList<JButton>();//JButtonインスタンスを管理する

	private static JTabbedPane tab;
	private static JPanel presetPanel;

	ETeCSInsert(){
		presetPanel = new JPanel();
		presetPanel.setLayout(new BoxLayout(presetPanel, BoxLayout.Y_AXIS));

		java.awt.GraphicsEnvironment env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.DisplayMode displayMode = env.getDefaultScreenDevice().getDisplayMode();
		int width = displayMode.getWidth()/10*9;
		int height = displayMode.getHeight()/10*9;
		setPreferredSize(new Dimension(width/6, height));//サイズ設定

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		setButton();

		tab = new JTabbedPane();
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);


		tab.addTab("プリセットソース",presetPanel);

		//addSubRoutine();
		resetSubRoutine();

		add(tab);

	}

	public void setButton(){
		try{
			for(int i=0;i<ETeCS.getInsertString().size()/2-1;i++){
				getPre().add(ETeCS.getInsertString().get(i*2+1));//ボタンの名前の設定
				getButton().add(new JButton(getPre().get(i)));//buttonにJButtonインスタンスを設定
				getButton().get(i).setAlignmentX(0.5f);//ボタンを中心に配置
				getButton().get(i).setMargin(new Insets(15, 30, 15, 30));
				getPreset().put(getPre().get(i),ETeCS.getInsertString().get(i*2+2));//連想配列presetにボタンの名前を引数に挿入したい文字列を格納
				getButton().get(i).addActionListener(new InsertStringListener());//アクションリスナーの設定
				presetPanel.add(getButton().get(i));

			}
		}catch(Exception e){
			ETeCS.main.setNotice("設定の読み込みに失敗しました。設定の初期化を行ってください。");
			System.out.println(e);
		}
	}

	public void removeButton(){
		for(int i=0;i<getButton().size();i++){
		presetPanel.remove(getButton().get(i));
		}
		setButton(new ArrayList<JButton>());
		setPre(new ArrayList<String>());
		setPreset(new HashMap <String,String>());

		repaint();
	}

	/*public void addSubRoutine(){

		int selected=0;
		try{
			selected=tab.getSelectedIndex();
			tab.remove(1);
		}catch(IndexOutOfBoundsException e){

		}try{
			SubRoutine subRoutine = new SubRoutine();
			tab.addTab("サブルーチン",subRoutine);
			tab.setSelectedIndex(selected);
		}catch(Exception e){
			resetSubRoutine();
		}
	}*/

	public void resetSubRoutine(){
		int selected=0;
		try{
			selected=tab.getSelectedIndex();
			tab.remove(1);
		}catch(IndexOutOfBoundsException e){
			//System.out.println(e);
		}
		tab.addTab("サブルーチン",new SubRoutine());
		tab.setSelectedIndex(selected);
	}
	public static ArrayList<String> getPre() {
		return pre;
	}

	public static void setPre(ArrayList<String> pre) {
		ETeCSInsert.pre = pre;
	}

	public static HashMap <String,String> getPreset() {
		return preset;
	}

	public static void setPreset(HashMap <String,String> preset) {
		ETeCSInsert.preset = preset;
	}

	public static ArrayList<JButton> getButton() {
		return button;
	}

	public static void setButton(ArrayList<JButton> button) {
		ETeCSInsert.button = button;
	}
}
