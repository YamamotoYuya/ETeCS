import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ETeCS extends JFrame {
	static boolean convertFlag = true;
	static String str = "G:\\";
	static File fileAddress=new File(str);
	static File fileAddress2= new File(System.getProperty("user.dir")+"\\");
	static ETeCSMain main;
	static private ETeCSMenu menu;
	static private ArrayList<String> insertString = new ArrayList<String>();//挿入したいソースを管理
	private static ETeCSInsert insert;



	public static void main (String args[]){
		/*PerformancePanel start = new PerformancePanel();
	    try{
	    Thread.sleep(1500);
	    }catch(InterruptedException e){}
	    start.exit();*/

		new ETeCS();



	}


	ETeCS(){
		java.awt.GraphicsEnvironment env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.DisplayMode displayMode = env.getDefaultScreenDevice().getDisplayMode();
		int width = displayMode.getWidth()/10*6;
		int height = displayMode.getHeight()/10*6;
		main = new ETeCSMain();
		menu = new ETeCSMenu();

		set();
		//初期設定

		setSubRoutine();

		setInsert(new ETeCSInsert());

		try{
			ImageIcon icon = new ImageIcon("image\\ETeCSIconSmall.png");
			setIconImage(icon.getImage());

		}catch(Exception e){

		}


		setTitle("ETeCS");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);//準備


		add(main,BorderLayout.CENTER);
		add(menu,BorderLayout.NORTH);
		add(getInsert(), BorderLayout.EAST);
		//コンポーネントを乗せる

		Timer timer = new Timer();
		timer.schedule(new MyTimer(),0,320);
		//タイマー


		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(d.width/2-width/2,d.height/2-height/2,width,height);
		//画面の中心に表示
		setVisible(true);

	}

	public static ETeCSMenu getETeCSMenu(){
		return menu;
	}

	public static void set(){
		ArrayList<String> presetList = new ArrayList<String>();
		insertString = new ArrayList<String>();
		//ArrayList<Integer> preset = new ArrayList<Integer>();

		File newDir = new File("setting");
		newDir.mkdir();
		File presetFile = new File("setting\\preset");
		try{
			  FileReader filereader = new FileReader(presetFile);
			  BufferedReader br = new BufferedReader(filereader);
			  String str = br.readLine();
			  while(str != null){
			    presetList.add(str);
			    str = br.readLine();
			  }
			  br.close();
			  ETeCS.setIntial(presetList);
			try{
				MyTextArea.initial =getInsertString().get(0);
			}catch(Exception e){
				MyTextArea.initial ="";
				main.setNotice("初期設定にエラーが発生しました。設定の初期化を行ってください");
			}

		}catch(FileNotFoundException FileE){
				makeIntial();
				try{
					  FileReader filereader = new FileReader(presetFile);
					  BufferedReader br = new BufferedReader(filereader);
					  String str = br.readLine();
					  while(str != null){
					    presetList.add(str);
					    str = br.readLine();
					  }
					  br.close();
					  ETeCS.setIntial(presetList);
					try{
						MyTextArea.initial =getInsertString().get(0);
					}catch(Exception e){
						MyTextArea.initial ="";
						main.setNotice("初期設定にエラーが発生しました。設定の初期化を行ってください");
					}
				}catch(Exception IOE){
					JOptionPane.showMessageDialog(new JFrame(),"設定エラー2.1,終了します");
					System.exit(0);
				}

			}catch(IOException IOE){
				JOptionPane.showMessageDialog(new JFrame(),"設定エラー2,終了します");
				System.exit(0);
			}

/*		try{

		}catch(NumberFormatException number){
			int i=0;
			while(i<presetList.size()){
				preset.add(Integer.parseInt(presetList.get(i)));
				i++;
			}
		}*/


	}

	static public void makeIntial(){
		String intialStr = "\tLD\tSP,#0DCH\r\n"//0
				+ "*\r\n"
				+ "for(add)\r\n"//1
				+ "*\r\n"
				+ "\tLD\tG0,# \r\n"
				+ "LOOP\r\n"
				+ "\tADD\tG0,#\r\n"
				+ "\tCMP\t\r\n"
				+ "\tJNZ\tLOOP\r\n"//2
				+ "*\r\n"
				+ "for(sub)\r\n"//3
				+ "*\r\n"
				+ "\tLD\tG0,# \r\n"
				+ "LOOP\r\n"
				+ "\tSUB\tG0,#\r\n"
				+ "\tJNZ\tLOOP\r\n"
				+ "*\r\n";
		File presetFile = new File("setting\\preset");
		try{
			presetFile.createNewFile();
			FileWriter fileWriter = new FileWriter(presetFile);
			fileWriter.write(intialStr);
			//System.out.println(intialStr);
			fileWriter.close();
		}catch(IOException IOE){
			JOptionPane.showMessageDialog(new JFrame(),"設定エラー1");

		}
	}

	public static void setIntial(ArrayList<String> presetList){
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<presetList.size();i++){
			if(presetList.get(i).equals("*")!=true){
				buffer.append(presetList.get(i));
				buffer.append("\n");
				//System.out.println(presetList.get(i));
			}
			else{
				getInsertString().add(buffer.toString());
				buffer = new StringBuffer();
			}
		}
		getInsertString().add(buffer.toString());

	}

	public static void setSubRoutine(){
		File dir = new File("setting\\subroutinDir");
		fileAddress2= new File(FileManager.fileLoader(dir));
		/*System.out.println(fileAddress2.getName());
		try{
		System.out.println(fileAddress.list()[0]);}catch(Exception e){}*/
		if(fileAddress2.getPath().equals("")){
			try{
				dir.createNewFile();
				FileManager.fileWriter(dir,System.getProperty("user.dir")+"\\");
			}catch(Exception e){}
		}

	}


	public static ArrayList<String> getInsertString() {
		return insertString;
	}


	public static void setInsertString(ArrayList<String> insertString) {
		ETeCS.insertString = insertString;
	}


	public static ETeCSInsert getInsert() {
		return insert;
	}


	public static void setInsert(ETeCSInsert insert) {
		ETeCS.insert = insert;
	}





}

