import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ETeCSMenu extends JMenuBar{
	ETeCSMenu(){
		JMenu file = new JMenu("ファイル");

		JMenuItem newFile = new JMenuItem("新規");
		newFile.addActionListener(new AddTextAreaListener());
		JMenuItem close = new JMenuItem("閉じる");
		close.addActionListener(new RemoveTextAreaListener());
		JMenuItem open = new JMenuItem("開く");
		JMenuItem sava = new JMenuItem("上書き保存");

		file.add(newFile);
		file.add(close);
		file.add(open);
		file.add(sava);
		add(file);
		//ファイルメニュー

		JMenu edit = new JMenu("編集");

		add(edit);
		//編集メニュー

	}

}
