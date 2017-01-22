import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SetPresetListener implements ActionListener{
	private static JTextField title;
	private static JTextArea body;
	private static JFrame frame;

	public void actionPerformed(ActionEvent e){
		java.awt.GraphicsEnvironment env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.DisplayMode displayMode = env.getDefaultScreenDevice().getDisplayMode();
		int width = displayMode.getWidth();
		int height = displayMode.getHeight();

		setFrame(new JFrame());
		getFrame().setLayout(new BorderLayout());
		getFrame().setTitle("プリセットソースの追加");
		getFrame().setSize(600,400);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		getFrame().setBounds(d.width/2-width/2,d.height/2-height/2,600,400);
		//画面の中心に表示

		setTitle(new JTextField("タイトル"));

		setBody(new JTextArea("本文"));

		JButton enter = new JButton("決定");
		JButton cansel = new JButton("キャンセル");
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String str=FileManager.fileLoader(new File("setting\\preset"));
				try{
					FileWriter fileWirter = new FileWriter("setting\\preset");
					fileWirter.write(str+SetPresetListener.getTitle().getText()+"\r\n"+"*\r\n"+SetPresetListener.getBody().getText()+"\r\n"+"*\r\n");
					fileWirter.close();
				}catch(IOException ev){
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "ファイルの書き込みに失敗しました", "エラー",JOptionPane.ERROR_MESSAGE);
				}
				SetPresetListener.getFrame().setVisible(false);

				ETeCS.set();
				ETeCS.setIntial(ETeCS.getInsertString());
				ETeCS.getInsert().removeButton();
				ETeCS.getInsert().setButton();
				ETeCS.main.setNotice("追加しました");
			}
		});
		cansel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.add(enter);
		panel.add(cansel);

		getFrame().add(getTitle(),BorderLayout.NORTH);
		getFrame().add(getBody(),BorderLayout.CENTER);
		getFrame().add(panel,BorderLayout.SOUTH);

		getFrame().setVisible(true);
	}

	public static JTextArea getBody() {
		return body;
	}

	public static void setBody(JTextArea body) {
		SetPresetListener.body = body;
	}

	public static JTextField getTitle() {
		return title;
	}

	public static void setTitle(JTextField title) {
		SetPresetListener.title = title;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		SetPresetListener.frame = frame;
	}
}

