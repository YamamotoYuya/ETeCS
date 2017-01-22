import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveTabListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			try{
				ETeCS.main.tab.remove(ETeCS.main.tab.getSelectedIndex());
				ETeCS.main.setNotice(ETeCS.fileAddress.getName()+"を閉じました");
			}catch(Exception e){

			}
		}


}
