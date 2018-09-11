package cn.web.security.test;

import java.util.ArrayList;
import java.util.List;

import cn.web.security.cpputil.App;
import cn.web.security.cpputil.NodeCPP14Listener.Assignstate;
import cn.web.security.cpputil.NodeCPP14Listener.ClassFunc;
import cn.web.security.cpputil.NodeCPP14Listener.ClassVar;
import cn.web.security.cpputil.NodeCPP14Listener.Classment;
import cn.web.security.cpputil.NodeCPP14Listener.ConNode;
import cn.web.security.cpputil.NodeCPP14Listener.CppFile;
import cn.web.security.cpputil.NodeCPP14Listener.Func;
import cn.web.security.cpputil.NodeCPP14Listener.Funccallstate;
import cn.web.security.cpputil.NodeCPP14Listener.Var;
import cn.web.security.pojo.Assign;
import cn.web.security.pojo.Callfunction;
import cn.web.security.pojo.Function;
import cn.web.security.pojo.Node;


//用于测试C++程序解析功能
public class CPP14test {
	
	//用于将复杂的类名结构，转换成单一的类名
	static String getclassname(String ofclass) {
		String classname= new String();
		String father = new String();
		if(ofclass.contains("(")) {
			//先拿出类名
			classname = ofclass.split("\\(")[0];
			//判断是结构还是类
			if(ofclass.contains("(class")) {
				//判断是否有父类
				if(ofclass.split("class\\)")[1].equals(" ")) {
					//没有父类
				}else {
					//有父类
					father = ofclass.split("\\) ")[1];
				}
			}else if(ofclass.contains("(struct)")) {
				
			}else {
				
			}
		}else {
			//直接就是类名，不需要处理
			classname = ofclass;
		}
		return classname;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CppFile cpp = App.jiexi("E:\\Software_security\\uploadspace\\项目1.0\\plane.cpp",101);   //需要传入每个表当前的起始id
		
		System.out.println("*************************************解析结束*******************************************");
		
		int projectid = 123;
		//处理类对象的格式，将其封装到对应的表中
		System.out.println(cpp.classlist.size());
		//这里弄一个临时类表，一次性存入数据库效果好，还是逐条插入到数据库效果好？思考一下（先使用临时表实现）
		
		List<cn.web.security.pojo.Classment> classlist = new ArrayList<cn.web.security.pojo.Classment>();
		for(Classment classment:cpp.classlist) {
			cn.web.security.pojo.Classment classment2 = new cn.web.security.pojo.Classment();
			classment2.setId(classment.getClassid());
			classment2.setName(classment.getClassname());
			classment2.setFather(classment.getFather());
			classment2.setType(classment.getType());
			classment2.setProjectid(projectid);
			classlist.add(classment2);
			//把该类 插入到  类表中
		}
		
		System.out.println("*******************************打印类表*********************************");
		for(cn.web.security.pojo.Classment classment:classlist) {
			System.out.println(classment.getId()+"|"+classment.getName()+"|"+classment.getFather()+"|"+classment.getProjectid()+"|"+classment.getType());
		}
		

		//处理方法对象的格式，将其封装到对应的表中
		System.out.println(cpp.filefunclist.size());
		
		List<Function> functionlist = new ArrayList<Function>();
		for(Func func:cpp.filefunclist) {
			
			cn.web.security.pojo.Function function = new cn.web.security.pojo.Function();
			function.setId(func.getFuncid());
			function.setName(func.getFuncname());                //只是函数名
			function.setModifier(func.getPrefunc());
			function.setReturntype(func.getReturntype());
			function.setParameter(func.getParams());
			function.setProjectid(projectid);
			
			if(func instanceof ClassFunc) {
				ClassFunc classFunc = (ClassFunc)func;
				function.setPermission(classFunc.getOflimit());
				
				String ofclass = classFunc.getOfclass();
				String classname = getclassname(ofclass);       //获得函数所属的类名
				
				//根据所属类名和项目id，查询类表，查到该类对应的id   （去临时类表查的效果好，还是去数据库查的效果好）
				for(cn.web.security.pojo.Classment classment:classlist) {
					if(classname.equals(classment.getName())) {
						function.setClassid(classment.getId());
						break;
					}
				}
			}
			functionlist.add(function);
			
			//把该函数插入到数据库函数表中
			
		}
		
		System.out.println("*******************************打印函数表*********************************");
		for(Function function:functionlist) {
			System.out.println(function.getId()+"|"+function.getName()+"|"+function.getModifier()+"|"+function.getReturntype()+"|"+function.getParameter()+"|"+function.getClassid()+"|"+function.getProjectid()+"|"+function.getPermission());
		}
		
		//处理变量对象的格式，将其封装到对应的表中
		System.out.println(cpp.filevarlist.size());
		List<cn.web.security.pojo.Var> varlist = new ArrayList<cn.web.security.pojo.Var>();
		for(Var var:cpp.filevarlist) {
			
			cn.web.security.pojo.Var var2 = new cn.web.security.pojo.Var();
			var2.setId(var.getVarid());
			var2.setName(var.getVarname());
			
			//这块还需要处理一下
			var2.setModifier(var.getPrevar());
			var2.setType(var.getPrevar());
			
			var2.setValue(var.getInitvalue());
			var2.setProjectid(projectid);
			
			String funcname = var.getOffunc();                  // 1 \ 2 \ 函数名
			//根据函数名(带形参)和项目id，找到该函数的id
			for(Function function:functionlist) {
				/*
				System.out.println("**********************************");
				System.out.println(funcname);     //可能是    1   2   main()   Game::GameOver()    main(void)
				System.out.println(function.getName()+function.getParameter());        //单纯的 函数名  + 形参列表  （不带括号）
				System.out.println("**********************************");
				*/
				if(funcname.equals("1")||funcname.equals("2")) {
					var2.setFunctionid(0);
					break;
				}
				if(funcname.contains("::")) {
					funcname = funcname.split("::")[1];
				}
				String parameter = "";
				if(function.getParameter()==null) {
					parameter = "";
				}else {
					parameter = function.getParameter();
				}
				if(funcname.equals(function.getName()+"("+parameter+")")) {
					var2.setFunctionid(function.getId());
					break;
				}
			}
			
			if(var instanceof ClassVar) {
				ClassVar classVar = (ClassVar)var;
				var2.setPermission(classVar.getOflimit());
				
				String ofclass = classVar.getOfclass();
				String classname = getclassname(ofclass);
				//根据所属类名和项目id，查询类表，查到该类对应的id
				for(cn.web.security.pojo.Classment classment:classlist) {
					if(classname.equals(classment.getName())) {
						var2.setClassid(classment.getId());
						break;
					}
				}
			}
			varlist.add(var2);
			//将该变量插入到数据库的变量表中
		}
		System.out.println("*******************************打印变量表*********************************");
		for(cn.web.security.pojo.Var var:varlist) {
			System.out.println(var.getId()+"|"+var.getName()+"|"+var.getModifier()+"|"+var.getType()+"|"+var.getValue()+"|"+var.getFunctionid()+"|"+var.getClassid()+"|"+var.getProjectid());
		}
		
		
		
		
		
		//处理控制节点对象的格式，将其封装到对应的表中
		System.out.println(cpp.nodelist.size());
		
		List<Node> nodelist = new ArrayList<Node>();
		for(ConNode node:cpp.nodelist) {
			
			cn.web.security.pojo.Node node2 = new cn.web.security.pojo.Node();
			node2.setId(node.getNodeid());
			node2.setName(node.getControlname());
			node2.setFatherid(node.getFatherid());
			node2.setCondition(node.getCondition());
			node2.setCasecondition(node.getCasecondition());
			node2.setPosition(node.getPosition());
			node2.setProjectid(projectid);
			
			String funcname = node.getOffunc();
			//根据函数名(带形参)和项目id，找到该函数的id
			for(Function function:functionlist) {
				if(funcname.equals("1")||funcname.equals("2")) {
					node2.setFunctionid(0);
					break;
				}
				if(funcname.contains("::")) {
					funcname = funcname.split("::")[1];
				}
				String parameter = "";
				if(function.getParameter()==null) {
					parameter = "";
				}else {
					parameter = function.getParameter();
				}
				if(funcname.equals(function.getName()+"("+parameter+")")) {
					node2.setFunctionid(function.getId());
					break;
				}
			}
			
			nodelist.add(node2);
			//把该节点插入到数据库中的节点表中
		}
		System.out.println("*******************************打印节点表*********************************");
		for(Node node:nodelist) {
			System.out.println(node.getId()+"|"+node.getFatherid()+"|"+node.getName()+"|"+node.getCondition()+"|"+node.getFunctionid()+"|"+node.getPosition()+"|"+node.getCasecondition()+"|"+node.getProjectid());
		}
		
		
		
		//处理赋值语句对象的格式，将其封装到对应的表中
		System.out.println(cpp.assignlist.size());
		
		List<Assign> assignlist = new ArrayList<Assign>();
		for(Assignstate assignstate:cpp.assignlist) {
			
			cn.web.security.pojo.Assign assign = new cn.web.security.pojo.Assign();
			assign.setId(assignstate.getAssignid());
			assign.setStatement(assignstate.getAssign());
			assign.setPosition(assignstate.getPosition());
			assign.setCasecondition(assignstate.getCasecondition());
			assign.setProjectid(projectid);
			
			//根据被赋值的变量名，确定对应的Id
			String varname = assignstate.getAssignedvar();
			for(cn.web.security.pojo.Var var:varlist) {                                //变量重名问题，不容易解决
				if(varname.equals(var.getName())) {
					assign.setBevarid(var.getId());
					break;
				}
			}

			//确定所属节点的id
			assign.setNodeid(assignstate.getFatherid());
			
			
			//根据函数名(带形参)和项目id，找到该函数的id
			String funcname = assignstate.getOffunc();
			for(Function function:functionlist) {
				if(funcname.equals("1")||funcname.equals("2")) {
					assign.setFunctionid(0);
					break;
				}
				if(funcname.contains("::")) {
					funcname = funcname.split("::")[1];
				}
				String parameter = "";
				if(function.getParameter()==null) {
					parameter = "";
				}else {
					parameter = function.getParameter();
				}
				if(funcname.equals(function.getName()+"("+parameter+")")) {
					assign.setFunctionid(function.getId());
					break;
				}
			}
			assignlist.add(assign);
			//把该赋值语句插入到数据库中的赋值语句表中
			
		}
		

		
		//处理函数调用语句对象的格式，将其封装到对应的表中
		System.out.println(cpp.funccalllist.size());
		List<Callfunction> callfunctionlist = new ArrayList<Callfunction>();
		for(Funccallstate funccallstate:cpp.funccalllist) {
			
			cn.web.security.pojo.Callfunction callfunction = new cn.web.security.pojo.Callfunction();
			callfunction.setId(funccallstate.getFunccallid());
			callfunction.setStatement(funccallstate.getFunccall());
			callfunction.setPosition(funccallstate.getPosition());
			callfunction.setCasecondition(funccallstate.getCasecondition());
			callfunction.setProjectid(projectid);
			
			//确定被调用函数的id
			String funcname1 = funccallstate.getFuncname();       //只是单纯的函数名
			for(Function function:functionlist) {                   //重名问题不容易解决（必须解决 ，+形参列表进行解决）
				if(funcname1.equals(function.getName()+function.getParameter())) {
					callfunction.setBefunctionid(function.getId());
					break;
				}
			}
			//确定所属节点的id
			callfunction.setNodeid(funccallstate.getFatherid());
			
			//根据函数名(带形参)和项目id，找到该函数的id
			String funcname2 = funccallstate.getOffunc();
			for(Function function:functionlist) {
				if(funcname2.equals("1")||funcname2.equals("2")) {
					callfunction.setFunctionid(0);
					break;
				}
				if(funcname2.contains("::")) {
					funcname2 = funcname2.split("::")[1];
				}
				String parameter = "";
				if(function.getParameter()==null) {
					parameter = "";
				}else {
					parameter = function.getParameter();
				}
				if(funcname2.equals(function.getName()+"("+parameter+")")) {
					callfunction.setFunctionid(function.getId());
					break;
				}
			}
			callfunctionlist.add(callfunction);
			//将该函数调用语句对象存储到数据库中的函数调用表
		}
		
		/*
		//扫描指定项目的解压路径，得到需要解析的项目列表
		String nowpath = "E:\\Software_security\\uploadspace\\项目1.0";
		DirAndFile daf = new DirAndFile(); 
		daf.iteratorPath(nowpath);
		List<String> pathList = new ArrayList<>();
		int cppcount=0,hcount=0;
		for(String npath:daf.pathName){
			
			if(npath.endsWith(".cpp")) {
				pathList.add(npath);
				cppcount++;
			}
			if(npath.endsWith(".h")) {
				pathList.add(npath);
				hcount++;
			}
		}
		System.out.println("该项目中包含"+cppcount+"个cpp源文件，"+hcount+"个h头文件！");
		
		for(String path:pathList) {
			System.out.println(path);
			System.out.println(path.replaceAll("E:\\\\Software_security\\\\uploadspace\\\\", "")+"的解析结果如下：");
			//App.jiexi(path);
			System.out.println();
		
		}
		*/
		
		
		
		
	}

}
