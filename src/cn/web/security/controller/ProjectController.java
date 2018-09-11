package cn.web.security.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
import cn.web.security.pojo.Project;
import cn.web.security.pojo.Results;
import cn.web.security.service.ProjectService;
import cn.web.security.service.ProjectanalysisService;
import cn.web.security.service.ResultsService;
import cn.web.security.utils.DirAndFile;
import cn.web.security.utils.FlawFinder;
import cn.web.security.utils.Result;
import cn.web.security.utils.TestDemo;
import cn.web.security.utils.ZipUtil;



@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ResultsService resultsService;
	@Autowired
	private ProjectanalysisService projectanalysisService;
	
	public static final int PAGE_SIZE=10;
	public static final int PAGE_SIZEC=20;
	/*
	@RequestMapping("/test")
	public String test() throws Exception{
		
		TestDemo.printtest("123456789");
		
		ZipUtil.deCompress("e:/javazip/aa.zip", "e:/javazip/aa2014/aa");
		
		return "index";
		
	}
	*/
	
	
	@RequestMapping("/addProject")
	public String addProject(Project project,MultipartFile pic,HttpSession session){
		try {
			//pic---> tomcat的目录中
			//指定文件的保存的路径（在服务器端的一个绝对路径）
			String path = session.getServletContext().getRealPath("upload");
			
			String zippath = path+"\\"+pic.getOriginalFilename();  //压缩包存放的路径
			//path应该是压缩包解压后，得到的项目存放的路径
			String projectrealpath = "e:/Software_security/uploadspace/"+project.getName();
			//判断是否有文件提交  pic不会为null
			if(pic.getSize()>0){
				
				File targetFile = new File(path, pic.getOriginalFilename());
				
				//另存文件到目录中
				pic.transferTo(targetFile);
				//把文件名和文件类型设置到pojo
				//System.out.println("上传文件名："+pic.getOriginalFilename());
				//System.out.println("类型："+pic.getContentType());
			}	
			
			projectService.myzip(zippath, projectrealpath);//这块需要判断一下是否成功解压到指定路径
			
			project.setPath(projectrealpath);
			
			projectService.addProject(project);
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/project/queryProjects";       
	}
	
	@RequestMapping("/queryProjects")
	public ModelAndView queryProjects(@ModelAttribute("condition")Project project,
			@RequestParam(value="pageNum",
			required=false,defaultValue="1")int pageNum){
		
		ModelAndView mv = new ModelAndView();
		//先设置分页的拦截参数
		PageHelper.startPage(pageNum, PAGE_SIZE);
		
		List<Project> list = projectService.findProjects(project);
		mv.addObject("projectList", list);
		
		//获取PageInfo分页bean
		PageInfo pageInfo = new PageInfo<>(list);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("projectList");
		
		return mv;
	}
	@RequestMapping("/queryProjects1")
	public ModelAndView queryProjects1(@ModelAttribute("condition")Project project,
			@RequestParam(value="pageNum",
			required=false,defaultValue="1")int pageNum){
		
		ModelAndView mv = new ModelAndView();
		//先设置分页的拦截参数
		PageHelper.startPage(pageNum, PAGE_SIZE);
		
		List<Project> list = projectService.findProjects(project);
		mv.addObject("projectList", list);
		
		//获取PageInfo分页bean
		PageInfo pageInfo = new PageInfo<>(list);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("project");
		
		return mv;
	}
	
	@RequestMapping("/toUpdate/{projectid}")
	public ModelAndView toUpdate(@PathVariable int projectid){
		
		Project project = projectService.getProjectById(projectid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("project", project);
		mv.setViewName("updateProject");
		return mv;
	}
	
	@RequestMapping("/updateProjectSubmit")
	public String updateProjectSubmit(Project project,MultipartFile pic,HttpSession session){
		try {
			//pic---> tomcat的目录中
			//指定文件的保存的路径（在服务器端的一个绝对路径）
			String path = session.getServletContext().getRealPath("upload");
			
			String zippath = path+"\\"+pic.getOriginalFilename();  //压缩包存放的路径
			//path应该是压缩包解压后，得到的项目存放的路径
			String projectrealpath = "e:/Software_security/uploadspace/"+project.getName();
			//判断是否有文件提交  pic不会为null
			if(pic.getSize()>0){
				
				File targetFile = new File(path, pic.getOriginalFilename());
				
				//另存文件到目录中
				pic.transferTo(targetFile);
				//把文件名和文件类型设置到pojo
				//System.out.println("上传文件名："+pic.getOriginalFilename());
				//System.out.println("类型："+pic.getContentType());
				projectService.myzip(zippath, projectrealpath);//这块需要判断一下是否成功解压到指定路径
				
				project.setPath(projectrealpath);
			}	
			
			
		     projectService.updateProject(project);
		 	
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/project/queryProjects";
	}
	
	@RequestMapping("/removeProject/{projectid}")
	public String removeProject(@PathVariable int projectid){
		
		projectService.removeProject(projectid);
		return "redirect:/project/queryProjects";
	}
	
	@RequestMapping("/detectProject/{projectid}")
	public String detectProject(@PathVariable int projectid){
		
		
		
		//首先根据projectid 获取到对应的project对象，找到它的projectpath（解压路径）
		Project project = projectService.getProjectById(projectid);
		String nowpath = project.getPath();
		//根据解压路径，遍历，找到该路径下需要检测的文件，将其路径存到List<String>结构中
		DirAndFile daf = new DirAndFile(); 
		daf.iteratorPath(nowpath);
		List<String> pathList = new ArrayList<>();
		for(String npath:daf.pathName){
			if(npath.endsWith(".c")||npath.endsWith(".cpp")){
				pathList.add(npath);
			}
		}
		
		String orderc1="";
		String orderc2=""; 
		FlawFinder ff=new FlawFinder();
		Set<String> myset = null;
		ArrayList<Result> mylist=null;
		//遍历路径list集合，依次对相应路径下的文件进行检测
		for(String filedir:pathList){
			
			try {
				myset = ff.doit(filedir,orderc1,orderc2);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
			
			mylist=ff.analysis(myset);
			//遍历mylist，将其中的Result封装成底层的Results,并将每个Results逐条存到数据库中
			
			for(Result r:mylist){
				Results R = new Results();
				R.setProjectid(projectid);
				R.setProjectname(project.getName());
				R.setFilepath(filedir.substring(33));
				R.setResultid(r.getResultid());
				R.setLine(r.getLine());
				R.setRisklevel(r.getRisklevel());
				R.setCategory(r.getCatagory());
				R.setRkey(r.getRkey());
				R.setWarning(r.getWarning());
				R.setSuggestion(r.getSuggestion());
				resultsService.addResults(R);
			}
			mylist.clear();
			myset.clear();
		}
		
		return "redirect:/project/queryResults/{projectid}";        //跳转到检测结果显示页面，改为返回ModelAndView,将检测的项目id，传到显示界面，只显示该项目的结果
	}
	/**
	 * 根据projectid 显示对应的检测结果
	 * @param results
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/queryResults/{projectid}")
	public ModelAndView queryResults(@PathVariable int projectid,
			@ModelAttribute("condition")Results results,
			@RequestParam(value="pageNum",
			required=false,defaultValue="1")int pageNum){
		
		ModelAndView mv = new ModelAndView();
		//先设置分页的拦截参数
		PageHelper.startPage(pageNum, PAGE_SIZEC);
		
		List<Results> list = resultsService.findResults(projectid);
		mv.addObject("resultsList", list);
		
		//获取PageInfo分页bean
		PageInfo pageInfo = new PageInfo<>(list);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("projectid", projectid);
		mv.setViewName("resultsList");
		
		return mv;
	}
	
	//根据指定ID，解析对应项目
	@RequestMapping("/analysisProject/{projectid}")
	public void analysisProject(@PathVariable int projectid){
			
		//根据项目ID，获得项目的所在路径
		Project project = projectService.getProjectById(projectid);
		String nowpath = project.getPath();
			
		//遍历项目路径，获得其中的.cpp/.h源码文件路径列表
		DirAndFile daf = new DirAndFile(); 
			
		daf.iteratorPath(nowpath);
			
		List<String> pathList = new ArrayList<String>();
		for(String npath:daf.pathName){
			if(npath.endsWith(".cpp")||npath.endsWith(".h")){
				pathList.add(npath);
			}
		}
		//遍历源码文件路径，逐一进行解析，并将解析结果存储到数据库中
		for(String path:pathList){
			
			
			System.out.println("当前输入文件的路径:"+path);
			//App.jiexi(path,100);
				
			//获得解析结果，存入数据库（  或者修改App.jiexi()方法，在该方法中将解析结果存入数据库  ）
			CppFile cpp = App.jiexi(path,101);   //需要传入每个表当前的起始id
			
			System.out.println("*************************************解析结束*******************************************");
			
			//int projectid = 123;
			//处理类对象的格式，将其封装到对应的表中
			//System.out.println(cpp.classlist.size());
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
				
			}
			//将类列表保存到数据库中
			projectanalysisService.addClassment(classlist);
			
			
			
			
			
			
			
			System.out.println("*******************************打印类表*********************************");
			for(cn.web.security.pojo.Classment classment:classlist) {
				System.out.println(classment.getId()+"|"+classment.getName()+"|"+classment.getFather()+"|"+classment.getProjectid()+"|"+classment.getType());
			}
			

			//处理方法对象的格式，将其封装到对应的表中
			//System.out.println(cpp.filefunclist.size());
			
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
			//System.out.println(cpp.filevarlist.size());
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
			//System.out.println(cpp.nodelist.size());
			
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
			//System.out.println(cpp.assignlist.size());
			
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
			//System.out.println(cpp.funccalllist.size());
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
			
		}	
	}
	
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
	
	
}
