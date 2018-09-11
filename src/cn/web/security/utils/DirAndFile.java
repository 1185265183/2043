package cn.web.security.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirAndFile {
	
	public File or;
	public File[] files;
	public List<String> pathName = new ArrayList<String>();

	// ���ڱ����ļ���
	public void iteratorPath(String dir){
		or = new File(dir);
		
		//System.out.println(or);
		
		files = or.listFiles();
	
		if(files!=null) {

			for(File file:files) {
				
				if(file.isFile()) {                         //�����ʱ��file��һ����׼�ļ�
					
					pathName.add(file.getAbsolutePath());   //+file.getName());
					
				}else if(file.isDirectory()) {               //�����ʱ��file��һ��Ŀ¼���ļ��У�
					
					
					iteratorPath(file.getAbsolutePath());
					
				}
			}
		}
     }
}
