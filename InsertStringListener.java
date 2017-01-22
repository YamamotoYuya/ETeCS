import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InsertStringListener implements ActionListener{
    public void actionPerformed(ActionEvent ev){
    	int i=0;
    	while(i<ETeCSInsert.getButton().size()){
    		if(ev.getSource()==ETeCSInsert.getButton().get(i))break;
    		i++;
    	}
    	if(ETeCS.main.getTxtA()!=null){
    		if(i<ETeCSInsert.getButton().size()){
    			try{
    				MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
    				myTxt.insertString(ETeCSInsert.getPreset().get(ETeCSInsert.getPre().get(i)));
    			}catch(Exception e){
    				ETeCS.main.setNotice("挿入エラー:ファイルが開かれているか確認して下さい");
    			}

    		}
    	}
    	else System.out.println("a");

    }

}
