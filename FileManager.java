import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileManager {
	public static String fileLoader(File address){
		String st="";
		String str="";
		try{
			FileReader filereader = new FileReader(address);
			BufferedReader br = new BufferedReader(filereader);
			  while((str = br.readLine()) != null){
				  st+=str;
				  st+='\n';
			  }
			  br.close();
			  return st;
		}catch(IOException e){
			//JFrame frame = new JFrame();
			//JOptionPane.showMessageDialog(frame, "ファイルの読み込みに失敗しました", "エラー",JOptionPane.ERROR_MESSAGE);
			return st;
		}
	}

	public static boolean fileWriter(File address,String str){

		try{
			FileWriter fileWirter = new FileWriter(address);
			fileWirter.write(str);
			//System.out.println(str);
			fileWirter.close();
			return true;

		}catch(IOException e){
			try{
				System.out.println(e+" "+address.getPath());
				address.createNewFile();
				FileWriter fileWirter = new FileWriter(address);
				fileWirter.write(str);
				fileWirter.close();
				return true;
			}catch(Exception ex){
				//JFrame frame = new JFrame();
				//JOptionPane.showMessageDialog(frame, "ファイルの書き込みに失敗しました", "エラー",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex+"filewiter");
				return false;
			}
		}

	}


}
