package xuzhenzhen.com.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import xuzhenzhen.com.model.CustomEntity;

public class EntityFactory {
	public ArrayList<CustomEntity> getEntity(){
		ArrayList<CustomEntity> list=new ArrayList<CustomEntity>();
		OpenFile open=new OpenFile("打开");
		File file=open.openFile();
		BufferedReader input=null;
		if(file==null)return null;
		try {
			input=new BufferedReader(
					new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("读取文件失败！");
			e.printStackTrace();
		}
		try {
			String value;
			while((value=input.readLine())!=null){
				String[] temp=value.split("[ \t]");//拆分字符串按空格和制表符
				if(temp.length!=3)return null;
				String id=temp[0];
				float cT=Float.parseFloat(temp[1]);
				float sT=Float.parseFloat(temp[2]);
				CustomEntity cus=new CustomEntity(id, cT, sT);
				list.add(cus);
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}
}