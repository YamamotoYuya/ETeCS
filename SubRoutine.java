import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
public class SubRoutine extends JPanel{
	private static ArrayList<JButton> buttonList;
	SubRoutine(){
		ArrayList<String> list = new ArrayList<String>();
		setButtonList(new ArrayList<JButton>());
		File[] files = new File[0];
		File file=ETeCS.fileAddress2;

		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


		try{
			files = file.listFiles();
			System.out.println(file.listFiles());
		}catch(SecurityException e){
			//System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}

		try{

			for(int i=0;i<files.length;i++){
				if(files[i].isFile()){
					list.add(files[i].getName());
					//System.out.println(list.get(i));
				}
			}

			for(int i=0;i<list.size();i++){
				getButtonList().add(new JButton(list.get(i)));
				getButtonList().get(i).setAlignmentX(0.5f);
				getButtonList().get(i).addActionListener(new SubRoutineListener());
				add(getButtonList().get(i));
			}
		}catch(Exception e){
			//System.out.println(e);
		}

	}
	public static ArrayList<JButton> getButtonList() {
		return buttonList;
	}
	public static void setButtonList(ArrayList<JButton> buttonList) {
		SubRoutine.buttonList = buttonList;
	}



	class DirOrFileFilter implements FilenameFilter{
		@Override
		public boolean accept(File dir,String str) {
		    if (dir.isFile()){
		        return false;
		      }
			else return true;
		}
	}




}
