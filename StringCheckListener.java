import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class StringCheckListener implements ActionListener{
	public void actionPerformed(ActionEvent ev){
		try{

			MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
			int caret = myTxt.getTxt().getCaretPosition();
			String check = myTxt.getTxt().getText();
			String[] check1 = check.split("\n");

			ArrayList<String[]> check2 = new ArrayList<String[]>();
			for(int i=0;i<check1.length;i++){
				check2.add(check1[i].split("\t"));
				//System.out.println(check2.get(i).length);
				//for(int j=0;j<check2.get(i).length;j++)System.out.println(i+" "+j+" "+check2.get(i)[j]);//i行目のj段
			}
			/*for(int i=0;i<check2.size();i++){
				for(int j=0;j<check2.get(i).length;j++){
					System.out.println(check2.get(i)[j]);
				}
			}*/
			try{
				myTxt.removeString();
				for(int i=0;i<check2.size();i++){
					for(int j=0;j<check2.get(i).length;j++){
						if(checkString(check2.get(i)[j])&& j==1){
							myTxt.insertStringRed(check2.get(i)[j]);
							//System.out.print(check2.get(i)[j]+"\t");
						}
						else{
							myTxt.insertString(check2.get(i)[j]);
							//System.out.print(check2.get(i)[j]+"\t");
						}
						//System.out.println(String.valueOf(i)+" "+String.valueOf(j)+" "+check2.get(i)[j]);
						myTxt.insertString("\t");
					}
					myTxt.insertString("\n");
				}
			}catch(Exception e){
				//System.out.println(e);
			}
			//System.out.println(myTxt.getTxt().getText());
			myTxt.getTxt().setCaretPosition(caret);


		}catch(Exception e){
			return;
		}
	}

	public boolean checkString(String str){
		String[] com = {"LD","ST"};
		str=str.toUpperCase();
		for(int i=0;i<com.length;i++){
			if(str.equals(com[i]))return false;
		}
		return true;
	}


}
