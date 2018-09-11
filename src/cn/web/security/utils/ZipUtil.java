package cn.web.security.utils;


import java.io.File;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
 
/**
 * ѹ���ļ�������
 * ���е�deCompress()��������������ѹzip,rarѹ����
 */
public class ZipUtil {
	
    /**
     * ��ѹ�� 
     * @param sourceFile Ҫ��ѹ�����ļ���·��
     * @param destDir ��ѹ�����Ŀ¼·��
     * @throws Exception
     */
    public static void deCompress(String sourceFile,String destDir) throws Exception{  
    	//������Ҫ��ѹ�����ļ�����
    	File file = new File(sourceFile);
        if (!file.exists()){
        	throw new RuntimeException(sourceFile + "�����ڣ�");
        }
        //������ѹ�����ļ�Ŀ¼����
    	File destDiretory  = new File(destDir);
        if(!destDiretory.exists()){
        	destDiretory.mkdirs();
        }
    	/*
         * ��֤�ļ���·�������"/"����"\"
         * charAt()����ָ������λ�õ�charֵ
         */
        char lastChar = destDir.charAt(destDir.length()-1);
        
        if(lastChar!='/'&&lastChar!='\\'){
        	//�������Ϸָ���
            destDir += File.separator;
        }
        
        unzip(sourceFile, destDir);
    }
    
    /**
     * ��ѹ����
     * ��Ҫant.jar
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


