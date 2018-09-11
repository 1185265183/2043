package cn.web.security.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirAndFile {
	
	public File or;
	public File[] files;
	public List<String> pathName = new ArrayList<String>();

	// 用于遍历文件夹
	public void iteratorPath(String dir){
		or = new File(dir);
		
		//System.out.println(or);
		
		files = or.listFiles();
	
		if(files!=null) {

			for(File file:files) {
				
				if(file.isFile()) {                         //如果此时的file是一个标准文件
					
					pathName.add(file.getAbsolutePath());   //+file.getName());
					
				}else if(file.isDirectory()) {               //如果此时的file是一个目录（文件夹）
					
					
					iteratorPath(file.getAbsolutePath());
					
				}
			}
		}
     }
}
