import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AddTabListener extends JPanel implements ActionListener{
	static JScrollPane scroll = new JScrollPane();
	public void actionPerformed(ActionEvent ev){
		MyTextArea myArea = new MyTextArea();
		ETeCS.main.tab.addTab("新規ファイル",myArea);
		ETeCS.main.setNotice("新規ファイルを作成しました");
		ETeCS.fileAddress=new File("newFile");
        ETeCS.main.tab.setSelectedIndex(ETeCS.main.tab.getTabCount()-1);
        ETeCS.getInsert().resetSubRoutine();
	}

}
