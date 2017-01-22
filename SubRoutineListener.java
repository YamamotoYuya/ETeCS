import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class SubRoutineListener implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		String str="";
		for(int i=0;i<SubRoutine.getButtonList().size();i++){
			if(ev.getSource()==SubRoutine.getButtonList().get(i)){
				str=SubRoutine.getButtonList().get(i).getText();
			}
		}
		System.out.println(ETeCS.fileAddress.getParent()+"\\"+str);
		File file = new File(ETeCS.fileAddress.getParent()+"\\"+str);
		FileManager.fileLoader(file);
	}

}
