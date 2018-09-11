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
	private String command = "E:/untitled/test/testff.py";           //脚本路径
	
	public FlawFinder(){
		
	}
	/*
	 * doit()函数执行flawfinder脚本，filedir为待检测文件路径，result为结果写入文件路径,order为指令参数（如-h,输出帮助信息）
	 */
	public Set<String> doit(String filedirc,String orderc1,String orderc2) throws IOException,InterruptedException{                               
		String filedir=filedirc;
		String order1=orderc1;
		String order2=orderc2;
		String[] cmdArr = new String[] {exe,command,order1,order2,filedir};
        Process process = Runtime.getRuntime().exec(cmdArr);  //生成一个新的进程执行指定脚本（可带参数），可以通过函数返回值process获取这个进程的运行结果
        //System.out.println(process.exitValue());
        InputStream fis=process.getInputStream();    //取得命令结果的输出流                      这里是返回的结果    对结果进行处理（细粒度化）
        InputStreamReader isr=new InputStreamReader(fis);    //用一个读输出流类去读    
        BufferedReader br=new BufferedReader(isr);    //用缓冲器读行 
        
        
        
        Set<String> firstset = new HashSet<String>();    //用于存储最初始的 一条条 检测结果
        String line=null;
        int i=1;
        System.out.println(1111111);
        //处理表头内容   （从中获取规则数目）
        for(;i<7;i++) {
        	line=br.readLine();
        	if(i==2) {
        		String[] lin1=line.split(" ");
        		System.out.println("规则数目为："+lin1[lin1.length-1]);           //获取本次检测时的规则数目
        	}
        }
        System.out.println(22222);
        //处理内部信息，获取到每一条内容
        i=1;
        String oneline="";
        String linef="";
        line=br.readLine();
        while(line!=null&&linef!=null)    
        {   
        	linef=br.readLine();
        	
        	if(!line.endsWith(".")) {                     //本行不以"."结束
        		oneline+=line;
        	}else {
        		
        		if(linef==null) {                      //line为所有内容的最后一行       不要
        			
        			oneline+=line;                           //此时获得完整的一行
        			//对该条消息进行操作（细粒度化），从中获取想要的消息
            		//System.out.println("第"+i+"条结果："+oneline);
            		oneline="";
            		i++;
        			
        			
        		}else {
        			if(linef.startsWith("  ")) {          //说明本行不是该条结果的最后一行
            			oneline+=line;
            		}else {
            			
            			oneline+=line;                           //此时获得完整的一行
            			//对该条消息进行操作（细粒度化），从中获取想要的消息
                		//System.out.println("第"+i+"条结果："+oneline);
            			if(oneline.startsWith("ANALYSIS SUMMARY")) {               //舍弃了最后一行处理过程参数的信息
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
        
       // System.out.println(firstset.size());         //风险个数
        
		
		
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
    		//System.out.println(i+":  "+str);		//输出是无序的
    		
            String[] ll = str.split(":",5);
    		
    		/*
    		for(String ii:ll) {
    			System.out.println(ii);
    		}
    		*/
    		
    		//System.out.println("所在行数："+ll[2]);         //风险函数所在的行数
    		
    		String[] er = ll[3].trim().split(" ");        //其中包含 ： 风险等级、 种类、函数名     (前两个字符是空格)
    	
    		String fx=er[0].substring(1, 2);
    		//System.out.println("风险等级:"+fx);
    		
    		String zl=er[1].substring(1, er[1].length()-1);
    		//System.out.println("种类:"+zl);
    		
    		//System.out.println("函数名:"+er[2]);
    		
    		//System.out.println(ll[4].trim());             //其中包含 ： 警告、建议
    		
    		String[] jj =  ll[4].trim().split("\\)\\.",2);            //这块写的不合理   ， 警告与建议  的分界    不容易确定。    规定警告消息必须以')'结尾   ，后期需指定特定分隔符
    		jj[0]+=")";                                      //警告信息
    		//System.out.println("警告:"+jj[0]);
    		/*
    		if(jj.length==1) {
    			//建议信息为空
    		}
    		if(jj.length!=1){
    			System.out.println("建议:"+jj[1]);            //建议信息
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
    			//System.out.println("执行过！！！！！！！！！");                                    //建议信息为空
    		}
    		if(jj.length!=1){
    			res.setSuggestion(jj[1]);            //建议信息           建议为空的时候jj[1].isEmpty()为真，此时jj[1].length()=0
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
			System.out.print("[位置:"+res.getLine()+"行]");
			System.out.print("[风险等级:"+res.getRisklevel()+"]");
			System.out.print("[风险种类:"+res.getCatagory()+"]");
			System.out.print("[风险函数:"+res.getRkey()+"]");
			System.out.print("[警告:"+res.getWarning()+"]");
			if(res.getSuggestion()!=null&&res.getSuggestion()!=" ") {
				System.out.print("[建议:"+res.getSuggestion()+"]");
			}
			System.out.println();
		}
	}
}
