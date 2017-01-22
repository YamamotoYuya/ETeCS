import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class ResetListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		ETeCS.fileAddress2 = new File(System.getProperty("user.dir")+"\\setting\\subroutinDir");
		FileManager.fileWriter(ETeCS.fileAddress2,System.getProperty("user.dir")+"\\");
		ETeCS.fileAddress2 = new File(System.getProperty("user.dir")+"\\");
		ETeCS.getInsert().resetSubRoutine();
		ETeCS.makeIntial();
		ETeCS.set();
		ETeCS.setIntial(ETeCS.getInsertString());
		ETeCS.getInsert().removeButton();
		ETeCS.getInsert().setButton();
		ETeCS.main.setNotice("設定の初期化をしました");

	}

}
