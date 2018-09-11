package cn.web.security.utils;


import java.io.File;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
 
/**
 * 压缩文件工具类
 * 其中的deCompress()方法可以用来解压zip,rar压缩包
 */
public class ZipUtil {
	
    /**
     * 解压缩 
     * @param sourceFile 要解压缩的文件的路径
     * @param destDir 解压缩后的目录路径
     * @throws Exception
     */
    public static void deCompress(String sourceFile,String destDir) throws Exception{  
    	//创建需要解压缩的文件对象
    	File file = new File(sourceFile);
        if (!file.exists()){
        	throw new RuntimeException(sourceFile + "不存在！");
        }
        //创建解压缩的文件目录对象
    	File destDiretory  = new File(destDir);
        if(!destDiretory.exists()){
        	destDiretory.mkdirs();
        }
    	/*
         * 保证文件夹路径最后是"/"或者"\"
         * charAt()返回指定索引位置的char值
         */
        char lastChar = destDir.charAt(destDir.length()-1);
        
        if(lastChar!='/'&&lastChar!='\\'){
        	//在最后加上分隔符
            destDir += File.separator;
        }
        
        unzip(sourceFile, destDir);
    }
    
    /**
     * 解压方法
     * 需要ant.jar
     */
    private static void unzip(String sourceZip,String destDir) throws Exception{
        try{
        	Project p = new Project();
        	Expand e = new Expand();
            e.setProject(p);
            e.setSrc(new File(sourceZip));
            e.setOverwrite(false);
            e.setDest(new File(destDir));
            e.execute();
        }catch(Exception e){
            throw e;
        }
    }
    
}


