import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SubRoutinDirListener  implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		File file = new File("setting\\subroutinDir");
		frame.setTitle("サブルーチンを参照するディレクトリの設定");
		frame.setSize(600,200);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		frame.add(panel);

		JTextField txt = new JTextField(ETeCS.fileAddress2.getPath());
		JButton enter = new JButton("決定");
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FileManager.fileWriter(file,txt.getText());
				//System.out.println(FileManager.fileLoader(file));
				frame.setVisible(false);
				ETeCS.setSubRoutine();
				ETeCS.getInsert().resetSubRoutine();
			}
		});

		panel.add(txt);
		panel.add(enter);

		frame.setVisible(true);
	}

}
