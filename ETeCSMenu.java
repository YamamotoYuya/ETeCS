import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ETeCSMenu extends JMenuBar{
	private JMenuItem save,undo,redo;
	private static JMenu encode;
	private static JMenuItem shiftJIS;
	private static JMenuItem utf8;
	private static JMenuItem mS932;


	ETeCSMenu(){
		JMenu file = new JMenu("ファイル");

		JMenuItem newFile = new JMenuItem("新規");
		newFile.addActionListener(new AddTabListener());

		JMenuItem close = new JMenuItem("閉じる");
		close.addActionListener(new RemoveTabListener());

		JMenuItem open = new JMenuItem("開く");
		open.addActionListener(new FileOpenListener());

		JMenuItem saveAs = new JMenuItem("名前を付けて保存");
		saveAs.addActionListener(new FileSaveAsListener());

		save = new JMenuItem("上書き保存");
		save.addActionListener(new FileSaveListener());
		save.setEnabled(false);

		JMenuItem exit = new JMenuItem("終了");
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});


		file.add(newFile);
		file.add(close);
		file.add(open);
		file.add(saveAs);
		file.add(save);
		file.add(exit);
		add(file);
		//ファイルメニュー



		JMenu edit = new JMenu("編集");

		undo = new JMenuItem("戻る");
		undo.addActionListener(new UndoListener());
		undo.setEnabled(false);

		redo = new JMenuItem("やり直す");
		redo.addActionListener(new RedoListener());
		redo.setEnabled(false);

		edit.add(undo);
		edit.add(redo);
		add(edit);
		//編集メニュー


		JMenu tool = new JMenu("ツール");

		encode = new JMenu("文字コード変換");
		encode.setEnabled(false);

		setShiftJIS(new JMenuItem("Shift_JIS"));
		getShiftJIS().addActionListener(new EncodeListener());

		setUtf8(new JMenuItem("utf-8"));
		getUtf8().addActionListener(new EncodeListener());

		setMS932(new JMenuItem("MS932"));
		getMS932().addActionListener(new EncodeListener());

		encode.add(getMS932());
		encode.add(getShiftJIS());
		encode.add(getUtf8());

		JMenuItem check = new JMenuItem("チェック");
		check.addActionListener(new StringCheckListener());

		JMenuItem resetString = new JMenuItem("カラーのリセット");
		resetString.addActionListener(new ColorResetListener());

		JMenuItem convert = new JMenuItem("大文字へ変換");
		convert.addActionListener(new StringConvertListener());



		tool.add(encode);
		tool.add(check);
		tool.add(resetString);
		tool.add(convert);
		add(tool);
		//ツール


		JMenu function = new JMenu("機能");

		JMenuItem reset = new JMenuItem("設定リセット");
		reset.addActionListener(new ResetListener());

		JMenu setting = new JMenu("プリセットソースの設定");

		JMenuItem preset = new JMenuItem("プリセットソースの追加");
		preset.addActionListener(new SetPresetListener());

		JMenuItem removePreset = new JMenuItem("プリセットソースの削除");
		removePreset.addActionListener(new RemovePresetListener());

		JMenuItem setSub = new JMenuItem("サブルーチンを参照するディレクトリの設定");
		setSub.addActionListener(new SubRoutinDirListener());

		setting.add(preset);
		setting.add(removePreset);

		function.add(setting);
		function.add(reset);
		function.add(setSub);
		add(function);


	}
	public void canUndo(boolean b){
		undo.setEnabled(b);
	}
	public void canRedo(boolean b){
		redo.setEnabled(b);
	}
	public void canSave(boolean b){
		save.setEnabled(b);
	}
	public void canEncode(boolean b){
		encode.setEnabled(b);
	}
	public static JMenuItem getShiftJIS() {
		return shiftJIS;
	}
	public static void setShiftJIS(JMenuItem shiftJIS) {
		ETeCSMenu.shiftJIS = shiftJIS;
	}
	public static JMenuItem getUtf8() {
		return utf8;
	}
	public static void setUtf8(JMenuItem utf8) {
		ETeCSMenu.utf8 = utf8;
	}
	public static JMenuItem getMS932() {
		return mS932;
	}
	public static void setMS932(JMenuItem mS932) {
		ETeCSMenu.mS932 = mS932;
	}



}
