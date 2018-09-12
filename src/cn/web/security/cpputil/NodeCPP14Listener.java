package cn.web.security.cpputil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.RuleContext;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.stringtemplate.v4.compiler.CodeGenerator.list_return;

import  cn.web.security.cpputil.CPP14Parser.AccessspecifierContext;
import  cn.web.security.cpputil.CPP14Parser.AssignmentexpressionContext;
import  cn.web.security.cpputil.CPP14Parser.ClassspecifierContext;
import  cn.web.security.cpputil.CPP14Parser.DeclspecifierseqContext;
import  cn.web.security.cpputil.CPP14Parser.FunctiondefinitionContext;
import  cn.web.security.cpputil.CPP14Parser.IterationstatementContext;
import  cn.web.security.cpputil.CPP14Parser.LabeledstatementContext;
import  cn.web.security.cpputil.CPP14Parser.MemberdeclarationContext;
import  cn.web.security.cpputil.CPP14Parser.PostfixexpressionContext;
import  cn.web.security.cpputil.CPP14Parser.SelectionstatementContext;
import  cn.web.security.cpputil.CPP14Parser.SimpledeclarationContext;
import cn.web.security.cpputil.CPP14Parser.StatementseqContext;
import cn.web.security.cpputil.CPP14Parser.Static_assertdeclarationContext;
import cn.web.security.cpputil.CPP14Parser.TranslationunitContext;


/*获得当前扫描文件的信�?*/
public class NodeCPP14Listener extends CPP14BaseListener{
	public static int id;      //控制节点编号
	public static int funccid;        
	public static int assid;       
	public static int varsize;   
	public static int funcsize;   
	public static int classmentcount; 
	
	
	
	
	
	public static CppFile cpp;       //用来记录当前输入文件的记录结�?
	//public static List<ConNode> nodelist;  //记录文件中所有节点，函数从这里找属于自己的节点（目前是按照函数名）
	
	/*文件*/  //目前没设计类层次
	public static class CppFile{
		public List<Var> filevarlist;             //文件变量列表
		public List<Func> filefunclist;                 //文件函数列表
		public List<Func> helpList;                 //辅助函数列表（用于补全函数的权限修饰信息）      这里边的函数可以是虚函数，在外边没有被实现（需要进一步处理）
		public List<Assignstate> assignlist;        //赋值语句列表
		public List<Funccallstate> funccalllist;       //函数调用列表
		public List<Classment> classlist;              //文件中类的列表
		public List<ConNode> nodelist;  //记录文件中所有节点，函数从这里找属于自己的节点（目前是按照函数名）
		
		
		public CppFile(){
			this.filefunclist = new ArrayList<Func>();
			this.filevarlist = new ArrayList<Var>();
			this.helpList = new ArrayList<Func>();
			this.assignlist = new ArrayList<Assignstate>();
			this.funccalllist = new ArrayList<Funccallstate>();
			this.classlist = new ArrayList<Classment>();
			this.nodelist = new ArrayList<ConNode>();
		}
		
	}
	
	/*变量*/
	public static class Var{
		protected Integer varid;
		protected String varname;
		protected String prevar;    //变量修饰�?
		protected String initvalue;
		protected String offunc;  //若是全局变量，该值为“1”，若为类属性变量，该值为“2”;否则为函数名（或函数id）
		public Var(){};
		public Var(Integer varid,String varname,String prevar,String initvalue,String offunc){
			this.varid = varid;
			this.varname = varname;
			this.prevar = prevar;
			this.initvalue = initvalue;
			this.offunc = offunc;
		}
		@Override
		public String toString(){
			return this.varid+" "+this.varname+" "+this.prevar+" "+this.initvalue+" "+this.offunc;
		}
		
		public Integer getVarid() {
			return varid;
		}
		public void setVarid(Integer varid) {
			this.varid = varid;
		}
		public String getVarname() {
			return varname;
		}
		public void setVarname(String varname) {
			this.varname = varname;
		}
		public String getPrevar() {
			return prevar;
		}
		public void setPrevar(String prevar) {
			this.prevar = prevar;
		}
		public String getInitvalue() {
			return initvalue;
		}
		public void setInitvalue(String initvalue) {
			this.initvalue = initvalue;
		}
		public String getOffunc() {
			return offunc;
		}
		public void setOffunc(String offunc) {
			this.offunc = offunc;
		}
		
	}
	/*类中属�?�变�?*/
	public static class ClassVar extends Var{
		private String ofclass;   //该属性变量属于的�?
		private String oflimit;   //该属性变量的权限修饰�?
		public ClassVar(){};
		public ClassVar(Integer varid,String varname,String prevar,String initvalue,String offunc,String ofclass,String oflimit){
			this.varid = varid;
			this.varname = varname;
			this.prevar = prevar;
			this.initvalue = initvalue;
			this.offunc = offunc;
			this.ofclass = ofclass;
			this.oflimit = oflimit;
		}
		@Override
		public String toString(){
			return this.varid+" "+this.varname+" "+this.prevar+" "+this.initvalue+" "+this.offunc+" "+this.ofclass+" "+this.oflimit;
		}
		
		public String getOfclass() {
			return ofclass;
		}
		public void setOfclass(String ofclass) {
			this.ofclass = ofclass;
		}
		public String getOflimit() {
			return oflimit;
		}
		public void setOflimit(String oflimit) {
			this.oflimit = oflimit;
		}
		
	}
	
	/*函数*/
	public static class Func{
		protected Integer funcid;
		protected String funcname;
		protected String prefunc;   //方法的修饰符
		protected String returntype;  //方法返回类型
		protected String params;       //形参列表 （之后可以�?�虑改成List<String>�?
		protected List<Var> varlist;    //方法中的变量
		protected List<ConNode> funcnodeList;  //控制节点列表
		
		public Func(){};
		public Func(Integer funcid,String funcname,String prefunc,String returntype,String params){
			this.funcid = funcid;
			this.funcname = funcname;
			this.prefunc = prefunc;
			this.returntype = returntype;
			this.params = params;
			this.varlist = new ArrayList<Var>();
			this.funcnodeList = new ArrayList<ConNode>();
		}
		
		public Integer getFuncid() {
			return funcid;
		}
		public String getFuncname() {
			return funcname;
		}
		public String getPrefunc() {
			return prefunc;
		}
		public String getReturntype() {
			return returntype;
		}
		public String getParams() {
			return params;
		}
		@Override
		public String toString(){
			return funcid+" "+funcname+" "+returntype+" "+params;
		}
		
		//根据函数的节点列表得到函数的控制流图（树形，父亲表示法） 
		public int[][] getcontrol(){
			int hang = funcnodeList.size();
			int[][] control = new int[hang][2];
			for(int i=0;i<hang;i++){
				control[i][0] = funcnodeList.get(i).nodeid;
				control[i][1] = funcnodeList.get(i).fatherid;
			}
			return control;
		}
		
		
	}
	/*类中的函�?*/
	public static class ClassFunc extends Func{
		private String ofclass;   //该属性变量属于的�?
		private String oflimit;   //该属性变量的权限修饰�?
		
		public ClassFunc(Integer funcid,String funcname,String prefunc,String returntype,String params,String ofclass,String oflimit){
			this.funcid = funcid;
			this.funcname = funcname;
			this.prefunc = prefunc;
			this.returntype = returntype;
			this.params = params;
			this.ofclass = ofclass;
			this.oflimit = oflimit;
			this.varlist = new ArrayList<Var>();
			this.funcnodeList = new ArrayList<ConNode>();
		}
		
		public String getOfclass() {
			return ofclass;
		}

		public String getOflimit() {
			return oflimit;
		}

		@Override
		public String toString(){
			return funcid+" "+funcname+" "+returntype+" "+params+" "+ofclass+" "+oflimit;
		}
		
	}
	
	
	/*文件中的�?*/
	public static class Classment{
		private Integer classid;
		private String classname;
		private String father;
		private Integer type;
		private List<ClassVar> varlist;
		private List<ClassFunc> funclist;
		
		public Classment(){
			this.varlist = new ArrayList<ClassVar>();
			this.funclist = new ArrayList<ClassFunc>();
		}
		public Classment(Integer classid,String classname){
			this.classid = classid;
			this.classname = classname;
			this.varlist = new ArrayList<ClassVar>();
			this.funclist = new ArrayList<ClassFunc>();
		}
		
		public Integer getType() {
			return type;
		}
		public void setType(Integer type) {
			this.type = type;
		}
		public Integer getClassid() {
			return classid;
		}
		public String getClassname() {
			return classname;
		}
		
		public void setFather(String father) {
			this.father = father;
		}
		public String getFather() {
			return father;
		}
		@Override
		public String toString(){
			return classid+" "+classname+" "+varlist.size()+" "+funclist.size()+" |"+father;
		}
		
	}
	
	/*控制节点信息*/	
	public static class ConNode{
		private Integer nodeid;
		private Integer fatherid;
		private String controlname;   //控制结构名称
		private String condition;  //节点本身条件信息
		private String offunc;
		private Integer position;   //用于记录该节点在父节�?(if-else)中的位置
		private String casecondition;  //如果该节点属于switch结构，用于记录所属的case条件（或default）；否则为null
		
		
		
		public ConNode(){};
		public ConNode(Integer nodeid,Integer fatherid,String controlname,String condition,String offunc,Integer position,String casecondition){
			this.nodeid = nodeid;
			this.fatherid = fatherid;
			this.controlname = controlname;
			this.condition = condition;
			this.offunc = offunc;
			this.position = position;
			this.casecondition = casecondition;
			
		}
		public Integer getNodeid() {
			return nodeid;
		}
		public Integer getFatherid() {
			return fatherid;
		}
		public String getControlname() {
			return controlname;
		}
		public String getCondition() {
			return condition;
		}
		public String getOffunc() {
			return offunc;
		}
		public Integer getPosition() {
			return position;
		}
		public String getCasecondition() {
			return casecondition;
		}
		@Override
		public String toString(){
			return this.nodeid+" "+this.fatherid+" "+this.controlname+" "+this.condition+" "+this.offunc;//" "+position+" "+casecondition;
		}
	}
	
	public static class IfConNode extends ConNode{
		
	}
	public static class IfEConNode extends ConNode{
		private String elsecondition;  //condition取反
		//private Integer position;   //0表示在if{}中，1表示在else{}�?
	}
	public static class SwConNode extends ConNode{
		//关于case怎么处理�?要进�?步�?�虑
		private Integer count; //case和default的数�?
		private String[] content;  //记录每个case的条件内�? 
		
	}
	public static class ForConNode extends ConNode{
		
	}
	public static class WhileConNode extends ConNode{
		
	}
	public static class DoWConNode extends ConNode{
		
	}
	
	/*赋�?�语句对�?*/
	public static class Assignstate{
		private Integer assignid;          
		private String assign;             //赋�?�语�?
		private Integer fatherid;         //赋�?�语句所属节点；不属于控制节点的话，�?0
		private String offunc;             //赋�?�语句所属函�?
		private String assignedvar;    //被赋值的变量�?
		private Integer position;		//用于记录该节点在父节�?(if-else)中的位置
		private String casecondition;   //如果该节点属于switch结构，用于记录所属的case条件（或default）；否则为null
		
		public Assignstate(){};
		public Assignstate(Integer assignid,String assign,Integer fatherid,String offunc,String assignedvar,Integer position,String casecondition){
			this.assignid = assignid;
			this.assign = assign;
			this.fatherid = fatherid;
			this.offunc = offunc;
			this.assignedvar = assignedvar;
			this.position = position;
			this.casecondition = casecondition;
		}
		public Integer getAssignid() {
			return assignid;
		}
		public String getAssign() {
			return assign;
		}
		public Integer getFatherid() {
			return fatherid;
		}
		public String getOffunc() {
			return offunc;
		}
		public String getAssignedvar() {
			return assignedvar;
		}
		public Integer getPosition() {
			return position;
		}
		public String getCasecondition() {
			return casecondition;
		}
		@Override
		public String toString(){
			return assignid+" "+fatherid+" "+offunc+" "+assignedvar;
		}
		
	} 
	
	/*函数调用语句对象*/
	public static class Funccallstate{
		
		private Integer funccallid;          //该语句的Id
		private String funccall;             //语句内容
		private String funcname;             //被调用的函数名
		private Integer fatherid;            //所属的节点ID
		private String offunc;               //所属的函数名
		private Integer position;		     //用于记录该节点在父节点(if-else)中的位置
		private String casecondition;        //如果该节点属于switch结构，用于记录所属的case条件（或default）；否则为null
		
		public Funccallstate(){};
		public Funccallstate(Integer funccallid,String funccall,String funcname,Integer fatherid,String offunc,Integer position,String casecondition){
			this.funccallid = funccallid;
			this.funccall = funccall;
			this.funcname = funcname;
			this.fatherid = fatherid;
			this.offunc = offunc;
			this.position = position;
			this.casecondition = casecondition;
		}
		
		public Integer getFunccallid() {
			return funccallid;
		}
		public String getFunccall() {
			return funccall;
		}
		public String getFuncname() {
			return funcname;
		}
		public Integer getFatherid() {
			return fatherid;
		}
		public String getOffunc() {
			return offunc;
		}
		public Integer getPosition() {
			return position;
		}
		public String getCasecondition() {
			return casecondition;
		}
		@Override
		public String toString(){
			return funccallid+" "+fatherid+" "+funcname+" "+offunc; 
		}
		
	}
	
	/*用来提取变量信息*/
	@Override
  	public void enterSimpledeclaration(SimpledeclarationContext ctx){
		super.enterSimpledeclaration(ctx);
		int count=ctx.getChildCount();
		if(count==2){
			if(ctx.getChild(0).getClass().toString().endsWith("CPP14Parser$DeclspecifierseqContext")){
				//System.out.println("定义类：");
				//System.out.println(ctx.getText());
				//这里�?要对类做处理  ，找出类里边的变�?   �? 方法；类中方法和变量均在memberdeclaration节点下定�?
				//在这里找到类名就行了（或者什么都不做也OK�?
			}
		}else if(ctx.getChild(1).getChild(0).getChildCount()==1&&ctx.getChild(0).getText().contains("{")) {
			
			
		}
		else if(count==3){
			
			String varString = ctx.getText();
			String prevar = ctx.getChild(0).getText();
			varString = varString.replaceFirst(prevar, "");
			//提取前缀信息
			String nowpre="";
			if(prevar.contains("const")){
				//声明的是常量
				prevar = prevar.replaceFirst("const", "");
				nowpre += "const ";
				//System.out.print("const ");
			}
			if(prevar.contains("static")){
				//声明的是静�?�变�?
				prevar = prevar.replaceFirst("static", "");
				nowpre += "static ";
				//System.out.print("static ");
			}
			if(prevar.contains("extern")){
				//引用的是其他文件中的变量
				prevar = prevar.replaceFirst("extern", "");
				nowpre += "extern ";
				//System.out.print("extern ");
			}
			
			//提取变量类型信息
			if(prevar.contains("unsigned")){
				//无符号变�?
				prevar = prevar.replaceFirst("unsigned", "");
				nowpre += "unsigned ";
				//System.out.print("unsigned ");
			}
			if(prevar.contains("short")){
				//short类型变量
				prevar = prevar.replaceFirst("short", "");
				nowpre += "short ";
				//System.out.print("short ");
			}
			if(prevar.contains("int")){
				//int类型变量
				prevar = prevar.replaceFirst("int", "");
				nowpre += "int ";
				//System.out.print("int ");
			}
			if(prevar.contains("char")){
				//char类型变量
				prevar = prevar.replaceFirst("char", "");
				nowpre += "char ";
				//System.out.print("char ");
			}
			if(prevar.contains("longlong")){
				//longlong类型变量
				prevar = prevar.replaceFirst("longlong", "");
				nowpre += "long long ";
				//System.out.print("long long ");
			}
			if(prevar.contains("longdouble")){
				//longdouble类型变量
				prevar = prevar.replaceFirst("longdouble", "");
				nowpre += "longdouble ";
				//System.out.print("longdouble ");
			}
			if(prevar.contains("long")){
				//long类型变量
				prevar = prevar.replaceFirst("long", "");
				nowpre += "long ";
				//System.out.print("long ");
			}
			if(prevar.contains("double")){
				//double类型变量
				prevar = prevar.replaceFirst("double", "");
				nowpre += "double ";
				//System.out.print("double ");
			}
			if(prevar.contains("float")){
				//float类型变量
				prevar = prevar.replaceFirst("float", "");
				nowpre += "float ";
				//System.out.print("float ");
			}
			
			if(prevar.contains("wchar_t")){
				//wchar_t类型变量
				prevar = prevar.replaceFirst("wchar_t", "");
				nowpre += "wchar_t ";
				//System.out.print("wchar_t ");
			}
			if(prevar.contains("char16_t")){
				//char16_t类型变量
				prevar = prevar.replaceFirst("char16_t", "");
				nowpre += "char16_t ";
				//System.out.print("char16_t ");
			}
			if(prevar.contains("char32_t")){
				//char32_t类型变量
				prevar = prevar.replaceFirst("char32_t", "");
				nowpre += "char32_t ";
				//System.out.print("char32_t ");
			}
			//System.out.println();
			
			String offunc = findfunc(ctx);  //获取�?属函数信�?
			
			//提取变量信息和初�?
			if(varString.contains("(")) {
				String varname = varString.split("=")[0];
				String varinit = varString.split("=")[1];
				//varsize++;
				Var var = new Var(varsize, varname, nowpre, varinit, offunc);
				cpp.filevarlist.add(var);
				varsize++;
				
			}else if(varString.contains("{")) {
				//判断含有几个数组	
				if(varString.contains("},")) {
					//至少含有两个数组
					String[] liStrings = varString.split("},");
					int size = liStrings.length;    
					for(int i=0;i<size;i++) {
						if(i==size-1) {
							String varname = liStrings[i].split("=")[0];
							String varinit = liStrings[i].split("=")[1].replaceAll(";","");
							//varsize++;
							Var var = new Var(varsize, varname, nowpre, varinit, offunc);
							cpp.filevarlist.add(var);
							varsize++;
						}else {
						String varname = liStrings[i].split("=")[0];
						String varinit = liStrings[i].split("=")[1]+"}";
						//varsize++;
						Var var = new Var(varsize, varname, nowpre, varinit, offunc);
						cpp.filevarlist.add(var);
						varsize++;
						}
					}	
				}else{
					//只含有一个数�?
					String varname  = varString.split("=")[0];
					String varinit =varString.split("=")[1];
					//varsize++;
					Var var = new Var(varsize, varname, nowpre, varinit, offunc);
					cpp.filevarlist.add(var);
					varsize++;
				}
			}else{
				
				String[] vars = varString.split(",");
				for(int i=0;i<vars.length;i++){
					if(i==vars.length-1){
						vars[i]=vars[i].replaceAll(";", "");
					}
					if(vars[i].contains("=")){
						String[] temvar = vars[i].split("=");					
						String varname = temvar[0];
						String varinit = temvar[1];
						//System.out.println("变量名："+varname + "初�?�："+varinit);
						//varsize++;
						Var var = new Var(varsize, varname, nowpre, varinit, offunc);
						cpp.filevarlist.add(var);
						varsize++;
					}else{
						
						String varname = vars[i];
						//System.out.println("变量名："+varname);
						//varsize++;
						Var var = new Var(varsize, varname, nowpre, null, offunc);
						cpp.filevarlist.add(var);
						varsize++;
					}
				}
			}
		}
	}
	
	/*通过该节点可以获得函数相关的信息*/
	@Override
	public void enterFunctiondefinition(FunctiondefinitionContext ctx){
		super.enterFunctiondefinition(ctx);
		//funcsize++;    //函数数目+1
		Integer funcid = funcsize;
		//获取函数的修饰符 和返回�?�类型（后续�?要进�?步完善，多种修饰符）
		String prefunction = ctx.declspecifierseq().getText();
		String prefunc = "";
		String returntype = "";
		if(prefunction.startsWith("static")){
			//System.out.print("static ");
			prefunc+="static ";
			prefunction=prefunction.substring(6);
			//System.out.print(prefunction+" ");
			returntype = prefunction;
		}else{
			//System.out.print(prefunction+" ");
			returntype = prefunction;
		}
		
		String funcname = "";
		String params = "";
		//获取函数的函数名、形参列�?    
		String functioninfor = ctx.declarator().getText();  //在这里判断是否是实现了某类中声明的方�?
		if(functioninfor.contains("::")){                //说明是实现了某些�?
			    //System.out.print(functioninfor);
			    String ofclass = functioninfor.split("::")[0];
			    if(ofclass.equals("")) {
			    	ofclass=ctx.getChild(0).getText();
			    }
			
			    //在这里得不到权限信息
			    String str = functioninfor.split("::")[1];
			    funcname = str.split("\\(")[0];
			    if(str.split("\\(")[1].equals(")")){
					params = null;
				}else{
					params = (str.split("\\(")[1]).split("\\)")[0];
				}
			    //params = str.split("\\(")[1].split("\\)")[0];
			    ClassFunc classFunc = new ClassFunc(funcid, funcname, prefunc, returntype, params, ofclass, null);
			    cpp.filefunclist.add(classFunc);
			}
		else{
				//System.out.println(functioninfor);
				funcname = functioninfor.split("\\(")[0];
				if(functioninfor.split("\\(")[1].equals(")")){
					params = null;
				}else{
					params = (functioninfor.split("\\(")[1]).split("\\)")[0];
				}
				String ofclass = findclass(ctx);
				if(!ofclass.equals("1")){
					//在类里边定义的函数，�?要寻找对应权限属�?
					String oflimit = findlimit(ctx);
					ClassFunc classFunc = new ClassFunc(funcid, funcname, prefunc, returntype, params, ofclass, oflimit);
				    cpp.filefunclist.add(classFunc);
					
				}else{
					//全局函数
					Func func = new Func(funcid, funcname, prefunc, returntype, params);
					cpp.filefunclist.add(func);
				}
				
			}
		
		funcsize++;    //函数数目+1
		
		
		
		
		
		//System.out.println(ctx.getClass().toString());
		//class me.huding.grammar.cpp14.CPP14Parser$FunctiondefinitionContext
		
		/*
		 * 通常Functiondefinition节点下有3个分支，1返回值类�?   2 函数名（形参�? 3函数�?
		 * 思路：进入Functiondefinition节点后，只对前两个节点进行操作，提取函数相关信息
		 * 思�?�（C++中关于函数的声明    定义方式的多样�?�，可能不只�?3个分�?  �?
		 * 
		 * */
	}
	
	/*处理选择控制结构*/
	@Override
	public void enterSelectionstatement(SelectionstatementContext ctx) {
		super.enterSelectionstatement(ctx);	
		//该节点下边可以有3种结构，if(){}、if(){}else{}、Switch(){}
		//首先判断是上述的哪种结构�?
		//if(){}       设置全局变量作为if节点的id（每个if节点有自己的id），为每个节点找到所属的函数，以及最近一层的父嵌套（逻辑信息�?
			//拿出条件信息；找到{}中的函数调用，以及关键赋值语�?
		//if(){}else{}
			//拿出条件信息；找到两个{}中的函数调用，以及关键赋值语�?
		//Switch(){}
			//()中信息，以及每个case信息
		//关于条件信息可能�?要后续处理，如提取出条件中出现的变量******
		
		//System.out.println(ctx.getClass().toString());
		//class me.huding.grammar.cpp14.CPP14Parser$SelectionstatementContext
		if(ctx.getChildCount()==5&&ctx.getChild(0).getText().equals("if")){
			//当前是if(){}结构
			String condition = null;
			if(isswitch(ctx)){
				if(isLabeled(ctx)){
					condition = findfatherLabeled(ctx);
				}else{
					condition = findfatherStatsmentseq(ctx);
				}
				//System.out.println(condition);
			}
			ctx.contextid=id;
			//System.out.println("当前是if(){}结构,该if节点id为："+ctx.contextid);
			//先解决�?�辑信息，找到其父�?�择结构节点（嵌套在哪一层中），�?要给每个SelectionstatementContext节点增加�?个id的信�?
			int[] positions = new int[2];
			positions = findfathercontext(ctx);
			ctx.fathercontextid=positions[0];
			
			/*
			if(ctx.fathercontextid!=0){
				System.out.println("父�?�择结构节点id�?"+ctx.fathercontextid);
			}else{
				System.out.println("当前节点处于�?外层�?");
			*/
			//解析内含的具体信息，拿出条件信息；找到{}中的函数调用，以及关键赋值语�?
			//System.out.println("条件信息�?"+ctx.condition().getText()); //条件信息
			//findfunc(ctx);  //输出该节点所属的函数
			ConNode node = new ConNode(ctx.contextid, positions[0], "if", ctx.condition().getText(), findfunc(ctx), positions[1], condition);
			cpp.nodelist.add(node);
			id++;
		}
		if(ctx.getChildCount()==5&&ctx.getChild(0).getText().equals("switch")){
			//当前是switch(){}结构
			String condition = null;
			if(isswitch(ctx)){
				if(isLabeled(ctx)){
					condition = findfatherLabeled(ctx);
				}else{
					condition = findfatherStatsmentseq(ctx);
				}
				//System.out.println(condition);
			}
			ctx.contextid=id;
			//System.out.println("当前是switch(){}结构,该if节点id为："+ctx.contextid);
			//先解决�?�辑信息，找到其父�?�择结构节点（嵌套在哪一层中），�?要给每个SelectionstatementContext节点增加�?个id的信�?
			int[] positions = new int[2];
			positions = findfathercontext(ctx);
			ctx.fathercontextid=positions[0];
			/*
			if(ctx.fathercontextid!=0){
				System.out.println("父�?�择结构节点id�?"+ctx.fathercontextid);
			}else{
				System.out.println("当前节点处于�?外层�?");
			}
			*/
			//解析内含的具体信息，拿出条件信息；找到{}中的函数调用，以及关键赋值语�?
			//System.out.println("条件信息�?"+ctx.condition().getText()); //条件信息
			//findfunc(ctx);
			ConNode node = new ConNode(ctx.contextid, positions[0], "switch", ctx.condition().getText(), findfunc(ctx), positions[1], condition);
			cpp.nodelist.add(node);
			id++;
		}
		if(ctx.getChildCount()==7){
			//当前是if(){}else{}结构
			String condition =null;
			if(isswitch(ctx)){
				if(isLabeled(ctx)){
					condition = findfatherLabeled(ctx);
				}else{
					condition = findfatherStatsmentseq(ctx);
				}
				//System.out.println(condition);
			}
			ctx.contextid=id;
			//System.out.println("当前是if(){}else{}结构,该if节点id为："+ctx.contextid);
			//先解决�?�辑信息，找到其父�?�择结构节点（嵌套在哪一层中），�?要给每个SelectionstatementContext节点增加�?个id的信�?
			int[] positions = new int[2];
			positions = findfathercontext(ctx);
			ctx.fathercontextid=positions[0];
			/*
			if(ctx.fathercontextid!=0){
				System.out.println("父�?�择结构节点id�?"+ctx.fathercontextid);
			}else{
				System.out.println("当前节点处于�?外层�?");
			}
			*/
			//解析内含的具体信息，拿出条件信息；找到{}中的函数调用，以及关键赋值语�?
			//System.out.println("条件信息�?"+ctx.condition().getText()); //条件信息
			//findfunc(ctx);
			ConNode node = new ConNode(ctx.contextid, positions[0], "if-else", ctx.condition().getText(), findfunc(ctx), positions[1], condition);
			cpp.nodelist.add(node);
			id++;
		}
		
	}
	
	/*处理switch中case的函�?*/
	@Override
	public void enterLabeledstatement(LabeledstatementContext ctx){
		super.enterLabeledstatement(ctx);
		//判断是否为case或default
		if(ctx.getChild(0).getText().equals("case")){
			//System.out.println("case父节�?");
			//System.out.println(ctx.getClass().toString());
			//class me.huding.grammar.cpp14.CPP14Parser$LabeledstatementContext
			
		}
		if(ctx.getChild(0).getText().equals("default")){
			//System.out.println("default父节�?");
			//System.out.println(ctx.getClass().toString());
			
		}
		
	}
	
	/*处理赋�?�语句的函数*/
	@Override
	public void enterAssignmentexpression(AssignmentexpressionContext ctx){
		super.enterAssignmentexpression(ctx);
		//首先判断是否为赋值语�?
		if(ctx.getChildCount()==3){
			//是赋值语�?,  后续可能�?要对赋�?�语句进�?步处理，如提取其中出现的变量，或函数调用
			//System.out.print("赋�?�语句："+ctx.getText());
			String condition = null;
			if(isswitch(ctx)){
				if(isLabeled(ctx)){
					condition = findfatherLabeled(ctx);
				}else{
					condition = findfatherStatsmentseq(ctx);
				}
				//System.out.println(condition);
			}
			
			Integer assignid = assid;
			String assign = ctx.getText();
			//�?要寻找其�?属的选择节点/循环节点，或者直接属于哪个函�?
			int[] positions = new int[2];
			positions = findfathercontext(ctx);
			String offunc = findfunc(ctx);
			String assignedvar = assign.split("=")[0];
			Assignstate assignstate = new Assignstate(assignid, assign, positions[0], offunc, assignedvar ,positions[1], condition);
			cpp.assignlist.add(assignstate);
			assid++;
		}
	}
	
	/*处理函数调用语句*/
	@Override
	public void enterPostfixexpression(PostfixexpressionContext ctx){
		super.enterPostfixexpression(ctx);
		//判断是否为函数调用节�?
		if((ctx.getChildCount()==3||ctx.getChildCount()==4)&&ctx.getChild(1).getText().contains("(")){
			//函数调用节点
			//System.out.println("函数调用语句�?"+ctx.getText());
			String condition = null;
			if(isswitch(ctx)){
				if(isLabeled(ctx)){
					condition = findfatherLabeled(ctx);
				}else{
					condition = findfatherStatsmentseq(ctx);
				}
				//System.out.println(condition);
			}
			
			Integer funccallid = funccid;
			String funccall = ctx.getText();
			String funcname = ctx.getText().split("\\(")[0];
			int[] positions = new int[2];
			positions = findfathercontext(ctx);
			String offunc = findfunc(ctx);
			Funccallstate funccallstate = new Funccallstate(funccallid, funccall, funcname, positions[0], offunc, positions[1], condition);
			cpp.funccalllist.add(funccallstate);
			funccid++;
		}
		
		
	}
	
	/*用于寻找父嵌套层*/ //返回两个数，position[0]表示父节点id，position[1]表示在父节点中的位置（if-else、switch结构�?,位置�?0�?�?
	public int[] findfathercontext(RuleContext ctx){
		int[] position = new int[2];      //默认�?0    
		if(!(ctx.parent.getClass().toString().endsWith("CPP14Parser$SelectionstatementContext")||ctx.parent.getClass().toString().endsWith("CPP14Parser$IterationstatementContext"))){
			if(ctx.getParent().getClass().toString().endsWith("CPP14Parser$TranslationunitContext")){
				return position;   //返回0表示当前结构是最外层，没有被嵌套到其他结构中
			}
			//nowid=findfathercontext(ctx.parent);
			position=findfathercontext(ctx.parent);
		}else{
			//这里�?要进�?步判断，如果其父节点是if(){}else{}结构,�?要判断该节点具体是属于if还是else
			if(ctx.parent.getChildCount()==7&&ctx.parent.getChild(0).getText().equals("if")){
				//其父节点是if(){}else{}结构
				if(ctx==ctx.parent.getChild(4)){      //这块应该返回点什么，作为标记信息
					//在if(){}�?
					//System.out.println("该节点在if{}�?");
					position[1]=0;
				}else{
					//在else{}�?
					//System.out.println("该节点在else{}�?");
					position[1]=1;
				}
			}
			//如果父节点在Labeledstatement中，�?要记录所在的case 信息，用于确定具体属于哪个case或default
			//只能解决紧跟case、default的第�?条语句（除非将后面的用大括号括起来）
			/*
			if(ctx.parent.getClass().toString().equals("class me.huding.grammar.cpp14.CPP14Parser$LabeledstatementContext")){
				if(ctx.parent.getChild(0).getText().equals("case")){
					String condition = ctx.parent.getChild(1).getText();
				}
				if(ctx.parent.getChild(0).getText().equals("default")){
					String condition = "default";
				}
			}
			*/
			if(ctx.parent.getChild(0).getText().equals("if")||ctx.parent.getChild(0).getText().equals("switch")){
				position[0] = ((SelectionstatementContext)ctx.parent).contextid;
				return position;
			}else{
				position[0] = ((IterationstatementContext)ctx.parent).contextid;
				return position;
			}	
		}
		return position;
	}
	
	/*用于寻找父亲Labeled节点，拿到该节点下的条件*/
	public String findfatherLabeled(RuleContext ctx){
		String condition = "";
		if(!ctx.parent.getClass().toString().endsWith("CPP14Parser$LabeledstatementContext")){
			condition = findfatherLabeled(ctx.parent);
		}else{
			if(ctx.parent.getChild(0).getText().equals("case")){
				condition = ctx.parent.getChild(1).getText();
				return condition;
			}
			if(ctx.parent.getChild(0).getText().equals("default")){
				condition = "default";
				return condition;
			}
		}
		return condition;
	}
	
	/*用于找到第一个statementseq父亲节点*/ 
	public String findfatherStatsmentseq(RuleContext ctx){
		String condition = "";
		if(!ctx.parent.getClass().toString().endsWith("CPP14Parser$StatementseqContext")){
			condition = findfatherStatsmentseq(ctx.parent);
		}else{
			RuleContext context = ctx.parent;
			return findsonLabeled(context);
		}
		return condition;
	}
	
	/*用于寻找该节点的直系单传孩子节点中是否有labeled节点,拿到其中的条件信�?*/
	public String findcondition(RuleContext ctx){
		String condition="";
		if(!ctx.getChild(0).getClass().toString().endsWith("CPP14Parser$LabeledstatementContext")){
			condition = findcondition((RuleContext)ctx.getChild(0));
		}else{
			
			RuleContext context = (RuleContext) ctx.getChild(0);
			if(context.getChild(0).getText().equals("case")){
				condition = context.getChild(1).getText();
				return condition;  //返回case�?对应的条�? 
			}
			if(context.getChild(0).getText().equals("default")){
				condition = "default";
				return condition;
			}	
		}
		return condition;
	}
	
	/*用于判断当前节点的孩子节点中是否有Labeled节点*/
	public boolean ishavelabeled(RuleContext ctx){
		boolean result;
		if(ctx.getChildCount()==1){
			if(ctx.getChild(0).getClass().toString().endsWith("CPP14Parser$LabeledstatementContext")){
				return true;
			}
			result = ishavelabeled((RuleContext)ctx.getChild(0));
		}else{
			return false;
		}
		return result;
	}
	
	/*用于找到该statementseq节点下最右边�? labeled节点中的条件信息*/
	public String findsonLabeled(RuleContext ctx){
		String condition = "";
		//statementseq节点下，�?种是只有statement节点,�?种是有statementseq、statement两个节点
		//首先进行判断
		if(ctx.getChildCount()==1){
			//该节点下边含有labeled节点，拿出其中的条件信息
			condition = findcondition(ctx);
			return condition;
		}else if(ctx.getChildCount()==2){
			//首先判断有右节点中是否含有labeled节点
			if(ishavelabeled((RuleContext)ctx.getChild(1))){
				//如果有，拿出其中的条件信�?
				condition = findcondition((RuleContext)ctx.getChild(1));
				return condition;
			}else{
				//如果没有，将左节点�?�归调用函数
				condition = findsonLabeled((RuleContext)ctx.getChild(0));
			}
		}
		
		
		
		/*
		if(!ctx.getChild(0).getClass().toString().equals("class me.huding.grammar.cpp14.CPP14Parser$LabeledstatementContext")){
			RuleContext context = (RuleContext) ctx.getChild(0);
			condition=findsonLabeled(context);
		}else{
			RuleContext context = (RuleContext) ctx.getChild(0);
			if(context.getChild(0).getText().equals("case")){
				condition = context.getChild(1).getText();
				return condition;  //返回case�?对应的条�? 
			}
			if(context.getChild(0).getText().equals("default")){
				condition = "default";
				return condition;
			}	
		}
		*/
		return condition;
	}
	
	/*判断父节点中是否有switch节点*/
	public Boolean isswitch(RuleContext ctx){
		boolean result;
		if(!(ctx.parent.getClass().toString().endsWith("CPP14Parser$SelectionstatementContext")||ctx.parent.getClass().toString().endsWith("CPP14Parser$IterationstatementContext"))){
			//目前没找到父节点
			if(ctx.getParent().getClass().toString().endsWith("CPP14Parser$TranslationunitContext")){
				return false;   //返回0表示当前结构是最外层，没有被嵌套到其他结构中
			}
			result = isswitch(ctx.parent);
		}else{
			if(ctx.parent.getChild(0).getText().equals("switch")){
				return true;
			}else{
				return false;
			}
		}
		return result;
	}
	
	/*判断父亲节点中是否有 labeled节点*/
	public Boolean isLabeled(RuleContext ctx){
		boolean result;
		if(!ctx.parent.getClass().toString().endsWith("CPP14Parser$LabeledstatementContext")){
			//目前没找到父节点
			if(ctx.getParent().getClass().toString().endsWith("CPP14Parser$TranslationunitContext")){
				return false;   //返回0表示当前结构是最外层，没有被嵌套到其他结构中
			}
			result = isLabeled(ctx.parent);
		}else{
			return true;
		}
		return result;
	}
	
	@Override
	public void enterStatementseq(StatementseqContext ctx){
		super.enterStatementseq(ctx);
		//System.out.println(ctx.getClass().toString());
		//class me.huding.grammar.cpp14.CPP14Parser$StatementseqContext
	}
	
	@Override
	public void enterDeclspecifierseq(DeclspecifierseqContext ctx){
		super.enterDeclspecifierseq(ctx);
		/*
		if (ctx.getParent().getClass().toString().endsWith("class me.huding.grammar.cpp14.CPP14Parser$SimpledeclarationContext")) {
			System.out.println("123"+ctx.getText()+"456");
		}
		*/
        //System.out.println(ctx.getClass().toString());
		//class me.huding.grammar.cpp14.CPP14Parser$DeclspecifierseqContext
	}
	
	/*递归方法用于寻找变量�?属的函数*/   //返回函数名（带形参）
	public String findfunc(RuleContext ctx){
		String string;
		if(!ctx.getParent().getClass().toString().endsWith("CPP14Parser$FunctiondefinitionContext")){
			if(ctx.getParent().getClass().toString().endsWith("CPP14Parser$TranslationunitContext")){
				return "1"; 
			}
			string=findfunc(ctx.parent);
		}else{
			String str = ctx.parent.getChild(1).getText();
			//System.out.println("�?属函�?:"+str);
			return str;
		}
		return string;
	}
	
	/*进入语法树的根节点，可以在这里初始化�?些统计信�?*/
	@Override
	public void enterTranslationunit(TranslationunitContext ctx){
		super.enterTranslationunit(ctx);
		//System.out.println("�?始解�?!");	
		//varsize = 0;
		//funcsize = 0;
		cpp=new CppFile();
		//nodelist = new ArrayList<ConNode>();
		//System.out.println(ctx.getClass().toString());
		//class me.huding.grammar.cpp14.CPP14Parser$TranslationunitContext
	}
	
	/*�?出语法树的根节点，可以在这里展示�?些统计信�?*/
	@Override
	public void exitTranslationunit(TranslationunitContext ctx){
		//补全函数的权限信息
		for(Func classfunc:cpp.helpList){
			boolean sw=false;
			for(Func func:cpp.filefunclist){
				//&&func.params.equals(classfunc.params)
				String classname1="",classname2="";
				if(func instanceof ClassFunc) {
					String ofclass1 = ((ClassFunc)func).ofclass;
					classname1= new String();
					String father1 = new String();
					if(ofclass1.contains("(")) {
						//先拿出类名
						classname1 = ofclass1.split("\\(")[0];
						//System.out.println(classname);
						
						//判断是结构还是类
						if(ofclass1.contains("(class")) {
							//判断是否有父类
							if(ofclass1.split("class\\)")[1].equals(" ")) {
								//没有父类
								//System.out.println("(class)  no  father !");
							}else {
								//有父类
								//System.out.println("(class)  have father !");
								father1 = ofclass1.split("\\) ")[1];
							}
							
						}else if(ofclass1.contains("(struct)")) {
							
						}else {
							
						}
					}else {
						//直接就是类名，不需要处理
						classname1 = ofclass1;
					}
					String ofclass2 = ((ClassFunc)classfunc).ofclass;
					classname2= new String();
					String father2 = new String();
					if(ofclass2.contains("(")) {
						//先拿出类名
						classname2 = ofclass2.split("\\(")[0];
						//System.out.println(classname);
						
						//判断是结构还是类
						if(ofclass2.contains("(class")) {
							//判断是否有父类
							if(ofclass2.split("class\\)")[1].equals(" ")) {
								//没有父类
								//System.out.println("(class)  no  father !");
							}else {
								//有父类
								//System.out.println("(class)  have father !");
								father2 = ofclass2.split("\\) ")[1];
							}
							
						}else if(ofclass2.contains("(struct)")) {
							
						}else {
							
						}
					}else {
						//直接就是类名，不需要处理
						classname2 = ofclass2;
					}
				}
				if(func.funcname.equals(classfunc.funcname)&&classname1.equals(classname2)){
					  ((ClassFunc)func).oflimit=((ClassFunc)classfunc).oflimit;
					  sw = true;
					  break;
				}
			}
			if(!sw){
				cpp.filefunclist.add(classfunc);
			}
		}
		
		
		//将结构节点添加到所属函数的节点列表中
		for(ConNode node:cpp.nodelist){
			for(Func func:cpp.filefunclist){
				if(node.offunc.equals(func.funcname+"("+func.params+")")){
					func.funcnodeList.add(node);
					break;
				}
			}	
		}
		
		
		
		//System.out.print("该程序中声明了"+varsize+"个变量，");
		//System.out.print(cpp.filefunclist.size()+"个函数，");
		//System.out.println(cpp.nodelist.size()+"个控制节点！");
		
		//System.out.println("变量信息：编号|变量名|修饰符|类型|初值|所属函数");
		/*
		for(Var var:cpp.filevarlist){
			System.out.println(var.toString());
		}
		
		System.out.println("函数信息：函数名|返回值类型|形参列表");
		for(Func func:cpp.filefunclist){
			System.out.println(func.toString());
			//System.out.println(func.funcnodeList.size());
		}
		*/
		//根据函数的节点列表，生成控制图树
		
		
		
		//封装类（从变量列表、函数列表中寻找）
		Set<String> nameSet = new HashSet<String>();  //用于存储文件中的所有类名
		for(Var var:cpp.filevarlist){
			if(var instanceof ClassVar){
				ClassVar classvar = (ClassVar)var;	
				String ofclass = classvar.ofclass;
				String classname= new String();
				String father = new String();
				if(ofclass.contains("(")) {
					//先拿出类名
					classname = ofclass.split("\\(")[0];
					//System.out.println(classname);
					
					//判断是结构还是类
					if(ofclass.contains("(class")) {
						//判断是否有父类
						if(ofclass.split("class\\)")[1].equals(" ")) {
							//没有父类
							//System.out.println("(class)  no  father !");
						}else {
							//有父类
							//System.out.println("(class)  have father !");
							father = ofclass.split("\\) ")[1];
						}
						
					}else if(ofclass.contains("(struct)")) {
						
					}else {
						
					}
				}else {
					//直接就是类名，不需要处理
					classname = ofclass;
				}
				//System.out.println(classname+"|"+father);
				nameSet.add(classname);
			}
		}
		for(Func func:cpp.filefunclist){
			if(func instanceof ClassFunc){
				ClassFunc classFunc = (ClassFunc)func;
				String ofclass = classFunc.ofclass;
				String classname= new String();
				String father = new String();
				if(ofclass.contains("(")) {
					//先拿出类名
					classname = ofclass.split("\\(")[0];
					//System.out.println(classname);
					//判断是结构还是类
					if(ofclass.contains("(class")) {
						//判断是否有父类
						if(ofclass.split("class\\)")[1].equals(" ")) {
							//没有父类
							//System.out.println("(class)  no  father !");
						}else {
							//有父类
							//System.out.println("(class)  have father !");
							father = ofclass.split("\\) ")[1];
						}
						
					}else if(ofclass.contains("(struct)")) {
						
					}else {
						
					}
				}else {
					//直接就是类名，不需要处理
					classname = ofclass;
				}
				//System.out.println(classname+"|"+father);
				
				nameSet.add(classname);
			}
		}
		
		
		
		
		//根据方法和变量所属的类，将其回填到类中
		
		for(String name:nameSet){
			Classment classment = new Classment(classmentcount,name);
			for(Var var:cpp.filevarlist){
				if(var instanceof ClassVar){
					ClassVar classvar = (ClassVar)var;
					String ofclass = classvar.ofclass;
					String classname= new String();
					String father = new String();
					int type=0;
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
							type=1;
						}else {
							
						}
					}else {
						//直接就是类名，不需要处理
						classname = ofclass;
					}
					if(classname.equals(name)){
						classment.varlist.add(classvar);
						classment.setFather(father);
						classment.setType(type);
					}
				}
			}
			
			for(Func func:cpp.filefunclist){
				if(func instanceof ClassFunc){
					ClassFunc classFunc = (ClassFunc)func;
					
					String ofclass = classFunc.ofclass;
					String classname= new String();
					String father = new String();
					if(ofclass.contains("(")) {
						//先拿出类名
						classname = ofclass.split("\\(")[0];
						//System.out.println(classname);
						
						//判断是结构还是类
						if(ofclass.contains("(class")) {
							//判断是否有父类
							if(ofclass.split("class\\)")[1].equals(" ")) {
								//没有父类
								//System.out.println("(class)  no  father !");
							}else {
								//有父类
								//System.out.println("(class)  have father !");
								father = ofclass.split("\\) ")[1];
							}
							
						}else if(ofclass.contains("(struct)")) {
							
						}else {
							
						}
					}else {
						//直接就是类名，不需要处理
						classname = ofclass;
					}
					if(classname.equals(name)){
						classment.funclist.add(classFunc);
						classment.setType(0);
						if(classment.father==null) {
							classment.setFather(father);
						}
						
					}
				}
			}
			cpp.classlist.add(classment);
		    classmentcount++;
		}
		/*
		System.out.println("类信息：类ID|类名|属性数|方法数");
		for(Classment classment:cpp.classlist){
			System.out.println(classment.toString());
		}
		
		
		
		System.out.println("节点信息：节点ID|父节点ID|节点名|条件信息|所属函数");
		for(ConNode node:cpp.nodelist){
			System.out.println(node.toString());
		}
		*/
		
		
		/*
		System.out.println("关于赋值语句：");
		for(Assignstate assignstate:cpp.assignlist){
			System.out.println(assignstate.toString());
		}*/
		/*
		System.out.println("关于函数调用语句：");
		for(Funccallstate funccallstate:cpp.funccalllist){
			System.out.println(funccallstate.toString());
		}
		*/
		//System.out.println("解析结束!");
		super.exitTranslationunit(ctx);
		
		
		
	}
	
	/*获取类中变量信息  �?  方法信息*/
	@Override
	public void enterMemberdeclaration(MemberdeclarationContext ctx){
		
		super.enterMemberdeclaration(ctx);
		//System.out.println(ctx.getClass().toString());
		//class me.huding.grammar.cpp14.CPP14Parser$MemberdeclarationContext
		if(ctx.getChild(0).getClass().toString().endsWith("CPP14Parser$FunctiondefinitionContext")){ 
			//此时当前节点下定义的是一个函数（�?要�?�归找所属类�?(函数节点会解决函数的问题，所以这�?么也不做)
		}else{
			//此时当前节点下定义或声明的是�?个变量或者是声明了一个函数（�?要�?�归找所属类�?
			//进一步判�? 到底�? 变量  还是  函数
			if(ctx.getChild(0).getText().contains("(")) {
				//声明构�?�函�?
				String returntype = null;//ctx.getChild(0).getText();//包括修饰符和返回值类�?
				String prefunc = "";
				String name = ctx.getChild(0).getText().split("\\(")[0];
				String param;
				if(ctx.getChild(0).getText().split("\\(")[1].equals(")")) {
					param = null;
				}else {
					param = ctx.getChild(0).getText().split("\\(")[1].split("\\)")[0];
				}

				String ofclass = findclass(ctx);
				String oflimit = findlimit(ctx);
				
				ClassFunc classFunc = new ClassFunc(1, name, prefunc, returntype, param, ofclass, oflimit);
				cpp.helpList.add(classFunc);
				//funcsize++;
				
			}else if(ctx.getChild(1).getText().contains("(")){
				//声明的函�?(拿到函数名，和对应权�?)
				String returntype = ctx.getChild(0).getText();//包括修饰符和返回值类�?
				String prefunc = "";
				if(returntype.contains("static")){
					prefunc = "static";
					returntype=returntype.replaceAll("static", "");
				}
				if(returntype.contains("virtual")){
					if(prefunc==""){
						prefunc = "virtual";
					}else{
						prefunc+="virtual";
					}
					returntype=returntype.replaceAll("virtual", "");
				}
				
				String name = ctx.getChild(1).getText().split("\\(")[0];
				String param;
				if(ctx.getChild(1).getText().split("\\(")[1].equals(")")) {
					param = null;
				}else {
					param = ctx.getChild(1).getText().split("\\(")[1].split("\\)")[0];
				}

				String ofclass = findclass(ctx);
				String oflimit = findlimit(ctx);
				
				ClassFunc classFunc = new ClassFunc(1, name, prefunc, returntype, param, ofclass, oflimit);
				cpp.helpList.add(classFunc);
				//funcsize++;
			}else{
				String varString = ctx.getText();
				String prevar = ctx.getChild(0).getText();
				varString = varString.replaceFirst(prevar, "");
				//提取前缀信息
				String nowpre="";
				if(prevar.contains("const")){
					//声明的是常量
					prevar = prevar.replaceFirst("const", "");
					nowpre += "const ";
					//System.out.print("const ");
				}
				if(prevar.contains("static")){
					//声明的是静�?�变�?
					prevar = prevar.replaceFirst("static", "");
					nowpre += "static ";
					//System.out.print("static ");
				}
				if(prevar.contains("extern")){
					//引用的是其他文件中的变量
					prevar = prevar.replaceFirst("extern", "");
					nowpre += "extern ";
					//System.out.print("extern ");
				}
				
				//提取变量类型信息
				if(prevar.contains("unsigned")){
					//无符号变�?
					prevar = prevar.replaceFirst("unsigned", "");
					nowpre += "unsigned ";
					//System.out.print("unsigned ");
				}
				if(prevar.contains("short")){
					//short类型变量
					prevar = prevar.replaceFirst("short", "");
					nowpre += "short ";
					//System.out.print("short ");
				}
				if(prevar.contains("int")){
					//int类型变量
					prevar = prevar.replaceFirst("int", "");
					nowpre += "int ";
					//System.out.print("int ");
				}
				if(prevar.contains("char")){
					//char类型变量
					prevar = prevar.replaceFirst("char", "");
					nowpre += "char ";
					//System.out.print("char ");
				}
				if(prevar.contains("longlong")){
					//longlong类型变量
					prevar = prevar.replaceFirst("longlong", "");
					nowpre += "long long ";
					//System.out.print("long long ");
				}
				if(prevar.contains("longdouble")){
					//longdouble类型变量
					prevar = prevar.replaceFirst("longdouble", "");
					nowpre += "longdouble ";
					//System.out.print("longdouble ");
				}
				if(prevar.contains("long")){
					//long类型变量
					prevar = prevar.replaceFirst("long", "");
					nowpre += "long ";
					//System.out.print("long ");
				}
				if(prevar.contains("double")){
					//double类型变量
					prevar = prevar.replaceFirst("double", "");
					nowpre += "double ";
					//System.out.print("double ");
				}
				if(prevar.contains("float")){
					//float类型变量
					prevar = prevar.replaceFirst("float", "");
					nowpre += "float ";
					//System.out.print("float ");
				}
				
				if(prevar.contains("wchar_t")){
					//wchar_t类型变量
					prevar = prevar.replaceFirst("wchar_t", "");
					nowpre += "wchar_t ";
					//System.out.print("wchar_t ");
				}
				if(prevar.contains("char16_t")){
					//char16_t类型变量
					prevar = prevar.replaceFirst("char16_t", "");
					nowpre += "char16_t ";
					//System.out.print("char16_t ");
				}
				if(prevar.contains("char32_t")){
					//char32_t类型变量
					prevar = prevar.replaceFirst("char32_t", "");
					nowpre += "char32_t ";
					//System.out.print("char32_t ");
				}
				//System.out.println();
				
				String offunc = "2";  //获取�?属函数信�?
				
				String ofclass = findclass(ctx);
				String oflimit = findlimit(ctx);
				
				//提取变量信息和初�?
				String[] vars = varString.split(",");
				
				for(int i=0;i<vars.length;i++){
					if(i==vars.length-1){
						vars[i]=vars[i].replaceAll(";", "");
					}
					if(vars[i].contains("=")){
						String[] temvar = vars[i].split("=");					
						String varname = temvar[0];
						String varinit = temvar[1];
						//System.out.println("变量名："+varname + "初�?�："+varinit);
						//varsize++;
						ClassVar classVar = new ClassVar(varsize, varname, nowpre, varinit, offunc, ofclass, oflimit);
						cpp.filevarlist.add(classVar);
						varsize++;
					}else{
						String varname = vars[i];
						//System.out.println("变量名："+varname);
						//varsize++;
						ClassVar classVar = new ClassVar(varsize, varname, nowpre, null, offunc, ofclass, oflimit);
						cpp.filevarlist.add(classVar);
						varsize++;
					}
				}
				
				
				
				
				
				
				
			}
		}
	}
	
	/*用来寻找变量和函数所属的�?*/  //返回类名  + 修饰�? + 父类    + 权限修饰�?
	public String findclass(RuleContext ctx){
		String string;
		if(!ctx.parent.getClass().toString().endsWith("CPP14Parser$ClassspecifierContext")){
			if(ctx.getParent().getClass().toString().endsWith("CPP14Parser$TranslationunitContext")){
				return "1";                            //不属于某个类
			}
			string=findclass(ctx.parent);
		}else{
			
			String  str1,str2="";    //str1表示�?属的类或结构,str2表示�?属类的父类们
			
			//首先判断该类是否继承了某些类
			//没继承任何类
			if(ctx.parent.getChild(0).getChildCount()==2){
				//System.out.println("no father!");
				str2 = "";
				
			}
			//继承了某些类
			if(ctx.parent.getChild(0).getChildCount()==3){
				//System.out.println("father:   "+ctx.parent.getChild(0).getChild(2).getText());
				//�?要处理上边的字符串，将其中的类名 以及权限修饰提取出来
				String str = ctx.parent.getChild(0).getChild(2).getText().replaceAll(":", "");
				String[] strings = str.split(",");
				for(String str3:strings){
					//判断是否是虚继承
					if(str3.contains("virtual")){
						str3=str3.replaceAll("virtual", "virtual ");
					}
					if(str3.contains("public")){
						str3=str3.replaceAll("public", "public ");
					}else if(str3.contains("protected")){
						str3=str3.replaceAll("protected", "protected ");
					}else if(str3.contains("private")){
						str3=str3.replaceAll("private", "private ");
					}else{
						str3="private "+str3; 
					}
					//System.out.println(str3);
					str2+=str3+" ";
				}
				//System.out.println(str2);
			}
			
			if(ctx.parent.getChild(0).getChild(0).getText().equals("class")){
				str1 = ctx.parent.getChild(0).getChild(1).getText();
				return str1+"(class)"+" "+str2;
			}else if(ctx.parent.getChild(0).getChild(0).getText().equals("struct")){
				str1 = ctx.parent.getChild(0).getChild(1).getText();
				return str1+"(struct)";
			}else{
				return "noknown";
			}
			
		}
		return string;
	}
	
	@Override
	public void enterClassspecifier(ClassspecifierContext ctx){
		super.enterClassspecifier(ctx);
		//System.out.println(ctx.getClass().toString());
		//class me.huding.grammar.cpp14.CPP14Parser$ClassspecifierContext
	}
	
	@Override
	public void enterAccessspecifier(AccessspecifierContext ctx){
		super.enterAccessspecifier(ctx);
		//System.out.println(ctx.getClass().toString());
		//class me.huding.grammar.cpp14.CPP14Parser$AccessspecifierContext
	}
	
	/*用于寻找类中变量，和函数的权限  public*/
	public String findlimit(RuleContext ctx){
		String string;
		if(!ctx.parent.getChild(0).getClass().toString().endsWith("CPP14Parser$AccessspecifierContext")){
			if(ctx.getParent().getClass().toString().endsWith("CPP14Parser$TranslationunitContext")){
				return "";
			}
			string=findlimit(ctx.parent);
		}else{
			String str = ctx.parent.getChild(0).getText();
			//System.out.println("权限�?"+str);
			return str;
		}
		return string;          
	}
	
	/*处理循环结构*/
	@Override
	public void enterIterationstatement(IterationstatementContext ctx){
		super.enterIterationstatement(ctx);
		//System.out.println(ctx.getClass().toString());
		//class me.huding.grammar.cpp14.CPP14Parser$IterationstatementContext
		//首先判断是哪个结构for(){}、while(){}、do{}while()
		if(ctx.getChild(0).getText().equals("for")){
			//当前是for(){}结构
			String condition = null;
			if(isswitch(ctx)){
				if(isLabeled(ctx)){
					condition = findfatherLabeled(ctx);
				}else{
					condition = findfatherStatsmentseq(ctx);
				}
				//System.out.println(condition);
			}
			ctx.contextid=id;
			//System.out.println("当前是for(){}结构,该for节点id为："+ctx.contextid);
			int[] positions = new int[2];
			positions = findfathercontext(ctx);
			ctx.fathercontextid=positions[0];
			/*
			if(ctx.fathercontextid!=0){
				System.out.println("父�?�择结构节点id�?"+ctx.fathercontextid);
			}else{
				System.out.println("当前节点处于�?外层�?");
			}
			*/
			//拿出for()中的条件信息
			//System.out.println("该for的条件是�?"+ctx.condition().getText());
			//findfunc(ctx);
			ConNode node = new ConNode(ctx.contextid, positions[0], "for", ctx.condition().getText(), findfunc(ctx), positions[1], condition);
			cpp.nodelist.add(node);
			id++;
		}else if(ctx.getChild(0).getText().equals("while")){
			//当前是while(){}结构
			String condition = null;
			if(isswitch(ctx)){
				if(isLabeled(ctx)){
					condition = findfatherLabeled(ctx);
				}else{
					condition = findfatherStatsmentseq(ctx);
				}
				//System.out.println(condition);
			}
			ctx.contextid=id;
			//System.out.println("当前是while(){}结构,该while节点id为："+ctx.contextid);
			int[] positions = new int[2];
			positions = findfathercontext(ctx);
			ctx.fathercontextid=positions[0];
			/*
			if(ctx.fathercontextid!=0){
				System.out.println("父�?�择结构节点id�?"+ctx.fathercontextid);
			}else{
				System.out.println("当前节点处于�?外层�?");
			}*/
			//拿出while()中的条件信息
			//System.out.println("该while的条件是�?"+ctx.condition().getText());
			//findfunc(ctx);
			ConNode node = new ConNode(ctx.contextid, positions[0], "while", ctx.condition().getText(), findfunc(ctx), positions[1], condition);
			cpp.nodelist.add(node);
			id++;
		}else if(ctx.getChild(0).getText().equals("do")){
			//当前是do{}whlile()结构
			String condition = null;
			if(isswitch(ctx)){
				if(isLabeled(ctx)){
					condition = findfatherLabeled(ctx);
				}else{
					condition = findfatherStatsmentseq(ctx);
				}
				//System.out.println(condition);
			}
			ctx.contextid=id;
			//System.out.println("当前是do{}whlile()结构,该dowhile节点id为："+ctx.contextid);
			int[] positions = new int[2];
			positions = findfathercontext(ctx);
			ctx.fathercontextid=positions[0];
			/*
			if(ctx.fathercontextid!=0){
				System.out.println("父�?�择结构节点id�?"+ctx.fathercontextid);
			}else{
				System.out.println("当前节点处于�?外层�?");
			}*/
			//拿出dowhile()中的条件信息
			//System.out.println("该dowhile的条件是�?"+ctx.getChild(4).getText());
			//findfunc(ctx);
			ConNode node = new ConNode(ctx.contextid, positions[0], "do-while", ctx.getChild(4).getText(), findfunc(ctx), positions[1], condition);
			cpp.nodelist.add(node);
			id++;
		}	
	}
	
}