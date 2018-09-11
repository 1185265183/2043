package cn.web.security.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.tools.ant.taskdefs.Length;

public class FlawFinder {
	
	private String exe = "python";
	private String command = "E:/untitled/test/testff.py";           //�ű�·��
	
	public FlawFinder(){
		
	}
	/*
	 * doit()����ִ��flawfinder�ű���filedirΪ������ļ�·����resultΪ���д���ļ�·��,orderΪָ���������-h,���������Ϣ��
	 */
	public Set<String> doit(String filedirc,String orderc1,String orderc2) throws IOException,InterruptedException{                               
		String filedir=filedirc;
		String order1=orderc1;
		String order2=orderc2;
		String[] cmdArr = new String[] {exe,command,order1,order2,filedir};
        Process process = Runtime.getRuntime().exec(cmdArr);  //����һ���µĽ���ִ��ָ���ű����ɴ�������������ͨ����������ֵprocess��ȡ������̵����н��
        //System.out.println(process.exitValue());
        InputStream fis=process.getInputStream();    //ȡ���������������                      �����Ƿ��صĽ��    �Խ�����д���ϸ���Ȼ���
        InputStreamReader isr=new InputStreamReader(fis);    //��һ�����������ȥ��    
        BufferedReader br=new BufferedReader(isr);    //�û��������� 
        
        
        
        Set<String> firstset = new HashSet<String>();    //���ڴ洢���ʼ�� һ���� �����
        String line=null;
        int i=1;
        System.out.println(1111111);
        //�����ͷ����   �����л�ȡ������Ŀ��
        for(;i<7;i++) {
        	line=br.readLine();
        	if(i==2) {
        		String[] lin1=line.split(" ");
        		System.out.println("������ĿΪ��"+lin1[lin1.length-1]);           //��ȡ���μ��ʱ�Ĺ�����Ŀ
        	}
        }
        System.out.println(22222);
        //�����ڲ���Ϣ����ȡ��ÿһ������
        i=1;
        String oneline="";
        String linef="";
        line=br.readLine();
        while(line!=null&&linef!=null)    
        {   
        	linef=br.readLine();
        	
        	if(!line.endsWith(".")) {                     //���в���"."����
        		oneline+=line;
        	}else {
        		
        		if(linef==null) {                      //lineΪ�������ݵ����һ��       ��Ҫ
        			
        			oneline+=line;                           //��ʱ���������һ��
        			//�Ը�����Ϣ���в�����ϸ���Ȼ��������л�ȡ��Ҫ����Ϣ
            		//System.out.println("��"+i+"�������"+oneline);
            		oneline="";
            		i++;
        			
        			
        		}else {
        			if(linef.startsWith("  ")) {          //˵�����в��Ǹ�����������һ��
            			oneline+=line;
            		}else {
            			
            			oneline+=line;                           //��ʱ���������һ��
            			//�Ը�����Ϣ���в�����ϸ���Ȼ��������л�ȡ��Ҫ����Ϣ
                		//System.out.println("��"+i+"�������"+oneline);
            			if(oneline.startsWith("ANALYSIS SUMMARY")) {               //���������һ�д�����̲�������Ϣ
            				//firstset.add(oneline);
            			}else {
            				firstset.add(oneline);
            			}
                		
                		oneline="";
                		i++;
                		
            		}
        			
        		}
        		
        	}
        	
        	if(linef!=null) {
        		line=linef;
        	}
        	
        	
        } 
        
       // System.out.println(firstset.size());         //���ո���
        
		
		
        process.waitFor();
        process.destroy();
        
        return firstset;
        
	}
	
	
	
    public ArrayList<Result> analysis(Set<String> set) {
		
		ArrayList<Result> resultlist = new ArrayList<Result>();
		
		Iterator<String> iter = set.iterator();
        int i=1;
        
        
    	while(iter.hasNext()){
    		String str = iter.next();
    		//System.out.println(i+":  "+str);		//����������
    		
            String[] ll = str.split(":",5);
    		
    		/*
    		for(String ii:ll) {
    			System.out.println(ii);
    		}
    		*/
    		
    		//System.out.println("����������"+ll[2]);         //���պ������ڵ�����
    		
    		String[] er = ll[3].trim().split(" ");        //���а��� �� ���յȼ��� ���ࡢ������     (ǰ�����ַ��ǿո�)
    	
    		String fx=er[0].substring(1, 2);
    		//System.out.println("���յȼ�:"+fx);
    		
    		String zl=er[1].substring(1, er[1].length()-1);
    		//System.out.println("����:"+zl);
    		
    		//System.out.println("������:"+er[2]);
    		
    		//System.out.println(ll[4].trim());             //���а��� �� ���桢����
    		
    		String[] jj =  ll[4].trim().split("\\)\\.",2);            //���д�Ĳ�����   �� �����뽨��  �ķֽ�    ������ȷ����    �涨������Ϣ������')'��β   ��������ָ���ض��ָ���
    		jj[0]+=")";                                      //������Ϣ
    		//System.out.println("����:"+jj[0]);
    		/*
    		if(jj.length==1) {
    			//������ϢΪ��
    		}
    		if(jj.length!=1){
    			System.out.println("����:"+jj[1]);            //������Ϣ
    		}
    		*/
    		Result res = new Result();
    		res.setResultid(i);
    		res.setLine(Integer.valueOf(ll[2]));
    		res.setRisklevel(Integer.valueOf(fx));
    		res.setCatagory(zl);
    		res.setRkey(er[2]);
    		res.setWarning(jj[0]);
    		if(jj.length==1) {
    			//System.out.println("ִ�й�������������������");                                    //������ϢΪ��
    		}
    		if(jj.length!=1){
    			res.setSuggestion(jj[1]);            //������Ϣ           ����Ϊ�յ�ʱ��jj[1].isEmpty()Ϊ�棬��ʱjj[1].length()=0
      		}
    		
    		resultlist.add(res);
    		
    		i++;
    	}
		
    	return resultlist;
	}
	
    
    public void printresultlist(ArrayList<Result> resultlist) {
		
		Iterator iter = resultlist.iterator();
		while(iter.hasNext()) {
		    //System.out.println(iter.next());
			Result res = (Result) iter.next();
			
			System.out.print("[id:"+res.getResultid()+"]");
			System.out.print("[λ��:"+res.getLine()+"��]");
			System.out.print("[���յȼ�:"+res.getRisklevel()+"]");
			System.out.print("[��������:"+res.getCatagory()+"]");
			System.out.print("[���պ���:"+res.getRkey()+"]");
			System.out.print("[����:"+res.getWarning()+"]");
			if(res.getSuggestion()!=null&&res.getSuggestion()!=" ") {
				System.out.print("[����:"+res.getSuggestion()+"]");
			}
			System.out.println();
		}
	}
}
