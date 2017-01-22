import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;



public class RemovePresetListener implements ActionListener{
	private static JFrame frame;
	static ArrayList<String> pre = new ArrayList<String>();//ボタンの名前を管理する
	static HashMap <String,String> preset = new HashMap <String,String>();//連想配列の宣言。ボタンで挿入したい文字列を管理し、引数はボタンの名前である。
	static ArrayList<JButton> button = new ArrayList<JButton>();//JButtonインスタンスを管理する

	public void actionPerformed(ActionEvent ev){
		java.awt.GraphicsEnvironment env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.DisplayMode displayMode = env.getDefaultScreenDevice().getDisplayMode();
		int width = displayMode.getWidth();
		int height = displayMode.getHeight();

		setFrame(new JFrame());
		getFrame().setTitle("プリセットソースの削除");
		getFrame().setSize(600,400);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		getFrame().setBounds(d.width/2-width/2,d.height/2-height/2,600,400);
		//フレームを画面の中心に表示

		frame.setLayout(new FlowLayout());

		try{
			for(int i=0;i<ETeCS.getInsertString().size()/2-1;i++){
				pre.add(ETeCS.getInsertString().get(i*2+1));//ボタンの名前の設定
				button.add(new JButton(pre.get(i)));//buttonにJButtonインスタンスを設定
				button.get(i).setAlignmentX(0.5f);//ボタンを中心に配置
				preset.put(pre.get(i),ETeCS.getInsertString().get(i*2+2));//連想配列presetにボタンの名前を引数に挿入したい文字列を格納
				button.get(i).addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev){
						int j;
						for(j=0;j<button.size();j++){
							if(button.get(j)==ev.getSource()) break;
						}
						preset.remove(pre.get(j));
						pre.remove(j);
						StringBuffer stb = new StringBuffer();
						stb.append(ETeCS.getInsertString().get(0)+"\r\n*\r\n");
						for(int n=0;n<pre.size();n++){
							stb.append(pre.get(n)+"\r\n*\r\n");
							stb.append(preset.get(pre.get(n))+"\r\n");
							//System.out.println(pre.get(n)+"\n"+preset.get(pre.get(n)));
							stb.append("*\r\n");
						}

						FileManager.fileWriter(new File("setting\\preset"),new String(stb));
						RemovePresetListener.getFrame().setVisible(false);
						ETeCS.set();
						ETeCS.setIntial(ETeCS.getInsertString());
						ETeCS.getInsert().removeButton();
						ETeCS.getInsert().setButton();
						ETeCS.main.setNotice("削除しました");
					}
				});
				frame.add(button.get(i));
				frame.add(Box.createRigidArea(new Dimension(0,30)));//空白コンポーネントの挿入
			}
		}catch(Exception e){
			ETeCS.main.setNotice("設定の読み込みに失敗しました。設定の初期化を行ってください。");
			System.out.println(e);
		}

		frame.add(Box.createRigidArea(new Dimension(0,30)));
		frame.add(Box.createRigidArea(new Dimension(0,30)));
		frame.add(Box.createRigidArea(new Dimension(0,30)));
		frame.add(Box.createRigidArea(new Dimension(0,30)));
		JButton cansel = new JButton("キャンセル");
		cansel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
			}
		});
		frame.add(cansel);

		frame.setVisible(true);

	}
	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		RemovePresetListener.frame = frame;
	}

}
