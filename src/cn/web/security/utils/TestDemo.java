package cn.web.security.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

//测试使用
public class TestDemo {
	
	public static void printtest(String string){
		
		System.out.println("传入的参数为："+string);
		/*
		String filedirc="D:/mytest/test.c";              //测试文件路径          
		String orderc1="";                         //参数1，该参数为空，或者是一些辅助性参数，就检测filedirc路径下的文件
		String orderc2="";                               //参数2（可与参数1组合使用）
		FlawFinder ff=new FlawFinder();                   
		Set<String> myset = null;
		try {
			myset = ff.doit(filedirc,orderc1,orderc2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         //调用脚本，将结果存到Set<String>中
		ArrayList<Result> mylist=ff.analysis(myset);                 //ArrayList<Result>中存的是一个个Result结果对象
		ff.printresultlist(mylist);
		*/
		System.out.println("传入的参数为："+string);
		
	}
}
