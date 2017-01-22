import java.util.TimerTask;



public class MyTimer extends TimerTask{
	public void run(){
		redoCheck();
		saveCheck();
	}

	public void redoCheck(){
		try{
			MyTextArea myTxt = (MyTextArea)ETeCS.main.tab.getComponentAt(ETeCS.main.tab.getSelectedIndex());
			ETeCS.getETeCSMenu().canUndo(myTxt.getUndoManager().canUndo());
			ETeCS.getETeCSMenu().canRedo(myTxt.getUndoManager().canRedo());
			ETeCS.getETeCSMenu().canEncode(true);
		}catch(ArrayIndexOutOfBoundsException e){
			ETeCS.getETeCSMenu().canEncode(false);
		}
	}

	public void saveCheck(){
		try{
			ETeCS.getETeCSMenu().canSave(true);
		}catch(ArrayIndexOutOfBoundsException e){
			ETeCS.getETeCSMenu().canSave(false);
		}
	}


}
