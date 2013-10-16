package xuzhenzhen.com.factory;

import java.io.File;
import javax.swing.JFileChooser;

public class OpenFile {
	private String btnStr;
	public OpenFile(String s){
		this.btnStr=s;
	}
	public File openFile(){
		File file=null;
		JFileChooser fileChooser=new JFileChooser("D:\\");
		fileChooser.addChoosableFileFilter(new MyFileFilter("txt"));
		int result=fileChooser.showDialog(null,btnStr);
		if(result==JFileChooser.APPROVE_OPTION){
			file=fileChooser.getSelectedFile();
		}
		return file;
	}
}
