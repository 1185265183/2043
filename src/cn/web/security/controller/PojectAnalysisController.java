package cn.web.security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.web.security.common.MyUtil;
import cn.web.security.common.StringUtil;
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
import cn.web.security.pojo.ClassmentInfoView;
import cn.web.security.pojo.Functions;
import cn.web.security.pojo.FunctionsInfoView;
import cn.web.security.pojo.Node;
import cn.web.security.pojo.Project;
import cn.web.security.pojo.Results;
import cn.web.security.pojo.VarInfoView;
import cn.web.security.service.ProjectService;
import cn.web.security.service.ProjectanalysisService;
import cn.web.security.service.ResultsService;
import cn.web.security.utils.DirAndFile;


@Controller
@RequestMapping("/projectAnalysis")
public class PojectAnalysisController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ResultsService resultsService;
	
	@Autowired
	private ProjectanalysisService projectanalysisService;
	
	public static final int PAGE_SIZE=4;
	public static final int PAGE_SIZEC=20;
	//根据指定ID，解析对应项目
		@RequestMapping("/analysisProject")
		@ResponseBody
		public ModelAndView analysisProject( @RequestParam int projectid,ModelMap model){
			//先进行判断该项目是否已经解析
			List<VarInfoView> list = resultsService.findAnalysisVarResults(projectid);
			List<FunctionsInfoView> list1 = resultsService.findAnalysisFunctionResults(projectid);
			List<ClassmentInfoView> list2 = resultsService.findAnalysisClassResults(projectid);
			if (list.size()>0||list1.size()>0||list2.size()>0) {
				ModelAndView mvAndView=new ModelAndView();
				mvAndView.addObject("projectid", projectid);
				mvAndView.addObject("analysis", "1");
				mvAndView.setViewName("analysisResult");
				return mvAndView;
			}
			//根据项目ID，获得项目的所在路径
			Project project = projectService.getProjectById(projectid);
			String nowpath = project.getPath();
				
			//遍历项目路径，获得其中的.cpp/.h源码文件路径列表
			DirAndFile daf = new DirAndFile(); 
				
			daf.iteratorPath(nowpath);
				
			List<String> pathList = new ArrayList<String>();
		for (String npath : daf.pathName) {
			if (npath.endsWith(".cpp") || npath.endsWith(".h")) {
				pathList.add(npath);
			}
		}
		// 遍历源码文件路径，逐一进行解析，并将解析结果存储到数据库中
		for (String path : pathList) {
			int classmentcount = projectanalysisService.getClassmentcount() + 1;
			int functioncount = projectanalysisService.getFunctioncount() + 1;
			int varcount = projectanalysisService.getVarcount() + 1;
			int nodecount = projectanalysisService.getNodecount() + 1;
			int assigncount = projectanalysisService.getAssigncount() + 1;
			int callfunctioncount = projectanalysisService
					.getCallfunctioncount() + 1;

			System.out.println("当前起始id：" + classmentcount + "|" + functioncount
					+ "|" + varcount + "|" + nodecount + "|" + assigncount
					+ "|" + callfunctioncount);
			System.out.println("当前输入文件的路径:" + path);
			// App.jiexi(path,100);

			// 获得解析结果，存入数据库（ 或者修改App.jiexi()方法，在该方法中将解析结果存入数据库 ）
			CppFile cpp = App.jiexi(path, classmentcount, functioncount,
					varcount, nodecount, assigncount, callfunctioncount); // 需要传入每个表当前的起始id

			System.out
					.println("*************************************解析结束*******************************************");

			// int projectid = 123;
			// 处理类对象的格式，将其封装到对应的表中
			// System.out.println(cpp.classlist.size());
			// 这里弄一个临时类表，一次性存入数据库效果好，还是逐条插入到数据库效果好？思考一下（先使用临时表实现）

			List<cn.web.security.pojo.Classment> classlist = new ArrayList<cn.web.security.pojo.Classment>();
			for (Classment classment : cpp.classlist) {
				cn.web.security.pojo.Classment classment2 = new cn.web.security.pojo.Classment();
				classment2.setId(classment.getClassid());
				classment2.setName(classment.getClassname());
				classment2.setFather(classment.getFather());
				classment2.setType(classment.getType());
				classment2.setProjectid(projectid);
				classlist.add(classment2);

			}
			// 将类列表保存到数据库中
			projectanalysisService.addClassment(classlist);

			System.out
					.println("*******************************打印类表*********************************");
			for (cn.web.security.pojo.Classment classment : classlist) {
				System.out.println(classment.getId() + "|"
						+ classment.getName() + "|" + classment.getFather()
						+ "|" + classment.getProjectid() + "|"
						+ classment.getType());
			}

			// 处理方法对象的格式，将其封装到对应的表中
			// System.out.println(cpp.filefunclist.size());

			List<Functions> functionlist = new ArrayList<Functions>();
			for (Func func : cpp.filefunclist) {

				cn.web.security.pojo.Functions function = new cn.web.security.pojo.Functions();
				function.setId(func.getFuncid());
				function.setName(func.getFuncname()); // 只是函数名
				function.setModifier(func.getPrefunc());
				function.setReturntype(func.getReturntype());
				function.setParameter(func.getParams());
				function.setProjectid(projectid);

				if (func instanceof ClassFunc) {
					ClassFunc classFunc = (ClassFunc) func;
					function.setPermission(classFunc.getOflimit());

					String ofclass = classFunc.getOfclass();
					String classname = MyUtil.getclassname(ofclass); // 获得函数所属的类名

					// 根据所属类名和项目id，查询类表，查到该类对应的id （去临时类表查的效果好，还是去数据库查的效果好）
					for (cn.web.security.pojo.Classment classment : classlist) {
						if (classname.equals(classment.getName())) {
							function.setClassid(classment.getId());
							break;
						}
					}
				}
				functionlist.add(function);

				// 把该函数插入到数据库函数表中
			}
			projectanalysisService.addFunction(functionlist);

			System.out
					.println("*******************************打印函数表*********************************");
			for (Functions function : functionlist) {
				System.out.println(function.getId() + "|" + function.getName()
						+ "|" + function.getModifier() + "|"
						+ function.getReturntype() + "|"
						+ function.getParameter() + "|" + function.getClassid()
						+ "|" + function.getProjectid() + "|"
						+ function.getPermission());
			}

			// 处理变量对象的格式，将其封装到对应的表中
			// System.out.println(cpp.filevarlist.size());
			List<cn.web.security.pojo.Var> varlist = new ArrayList<cn.web.security.pojo.Var>();
			for (Var var : cpp.filevarlist) {

				cn.web.security.pojo.Var var2 = new cn.web.security.pojo.Var();
				var2.setId(var.getVarid());
				var2.setName(var.getVarname());

				// 这块还需要处理一下
				var2.setModifier(var.getPrevar());
				var2.setType(var.getPrevar());

				var2.setValue(var.getInitvalue());
				var2.setProjectid(projectid);

				String funcname = var.getOffunc(); // 1 \ 2 \ 函数名
				// 根据函数名(带形参)和项目id，找到该函数的id
				for (Functions function : functionlist) {

					// System.out.println("**********************************");
					// System.out.println(funcname); //可能是 1 2 main()
					// Game::GameOver() main(void)
					// System.out.println(function.getName()+function.getParameter());
					// //单纯的 函数名 + 形参列表 （不带括号）
					// System.out.println("**********************************");

					if (funcname.equals("1") || funcname.equals("2")) {
						var2.setFunctionid(0);
						break;
					}
					if (funcname.contains("::")) {
						funcname = funcname.split("::")[1];
					}
					String parameter = "";
					if (function.getParameter() == null) {
						parameter = "";
					} else {
						parameter = function.getParameter();
					}
					if (funcname.equals(function.getName() + "(" + parameter
							+ ")")) {
						var2.setFunctionid(function.getId());
						break;
					}
				}

				if (var instanceof ClassVar) {
					ClassVar classVar = (ClassVar) var;
					var2.setPermission(classVar.getOflimit());

					String ofclass = classVar.getOfclass();
					String classname = MyUtil.getclassname(ofclass);
					// 根据所属类名和项目id，查询类表，查到该类对应的id
					for (cn.web.security.pojo.Classment classment : classlist) {
						if (classname.equals(classment.getName())) {
							var2.setClassid(classment.getId());
							break;
						}
					}
				}
				varlist.add(var2);
				// 将该变量插入到数据库的变量表中
			}
			projectanalysisService.addVar(varlist);

			System.out
					.println("*******************************打印变量表*********************************");
			for (cn.web.security.pojo.Var var : varlist) {
				System.out.println(var.getId() + "|" + var.getName() + "|"
						+ var.getModifier() + "|" + var.getType() + "|"
						+ var.getValue() + "|" + var.getFunctionid() + "|"
						+ var.getClassid() + "|" + var.getProjectid());
			}

			// 处理控制节点对象的格式，将其封装到对应的表中
			// System.out.println(cpp.nodelist.size());

			List<Node> nodelist = new ArrayList<Node>();
			for (ConNode node : cpp.nodelist) {

				cn.web.security.pojo.Node node2 = new cn.web.security.pojo.Node();
				node2.setId(node.getNodeid());
				node2.setName(node.getControlname());
				node2.setFatherid(node.getFatherid());
				node2.setNodecondition(node.getCondition());
				node2.setCasecondition(node.getCasecondition());
				node2.setPosition(node.getPosition());
				node2.setProjectid(projectid);

				String funcname = node.getOffunc();
				// 根据函数名(带形参)和项目id，找到该函数的id
				for (Functions function : functionlist) {
					if (funcname.equals("1") || funcname.equals("2")) {
						node2.setFunctionid(0);
						break;
					}
					if (funcname.contains("::")) {
						funcname = funcname.split("::")[1];
					}
					String parameter = "";
					if (function.getParameter() == null) {
						parameter = "";
					} else {
						parameter = function.getParameter();
					}
					if (funcname.equals(function.getName() + "(" + parameter
							+ ")")) {
						node2.setFunctionid(function.getId());
						break;
					}
				}

				nodelist.add(node2);
				// 把该节点插入到数据库中的节点表中
			}
			projectanalysisService.addNode(nodelist);

			System.out
					.println("*******************************打印节点表*********************************");
			for (Node node : nodelist) {
				System.out.println(node.getId() + "|" + node.getFatherid()
						+ "|" + node.getName() + "|" + node.getNodecondition()
						+ "|" + node.getFunctionid() + "|" + node.getPosition()
						+ "|" + node.getCasecondition() + "|"
						+ node.getProjectid());
			}

			// 处理赋值语句对象的格式，将其封装到对应的表中
			// System.out.println(cpp.assignlist.size());

			List<Assign> assignlist = new ArrayList<Assign>();
			for (Assignstate assignstate : cpp.assignlist) {

				cn.web.security.pojo.Assign assign = new cn.web.security.pojo.Assign();
				assign.setId(assignstate.getAssignid());
				assign.setStatement(assignstate.getAssign());
				assign.setPosition(assignstate.getPosition());
				assign.setCasecondition(assignstate.getCasecondition());
				assign.setProjectid(projectid);

				// 根据被赋值的变量名，确定对应的Id
				String varname = assignstate.getAssignedvar();
				for (cn.web.security.pojo.Var var : varlist) { // 变量重名问题，不容易解决
					if (varname.equals(var.getName())) {
						assign.setBevarid(var.getId());
						break;
					}
				}

				// 确定所属节点的id
				assign.setNodeid(assignstate.getFatherid());

				// 根据函数名(带形参)和项目id，找到该函数的id
				String funcname = assignstate.getOffunc();
				for (Functions function : functionlist) {
					if (funcname.equals("1") || funcname.equals("2")) {
						assign.setFunctionid(0);
						break;
					}
					if (funcname.contains("::")) {
						funcname = funcname.split("::")[1];
					}
					String parameter = "";
					if (function.getParameter() == null) {
						parameter = "";
					} else {
						parameter = function.getParameter();
					}
					if (funcname.equals(function.getName() + "(" + parameter
							+ ")")) {
						assign.setFunctionid(function.getId());
						break;
					}
				}
				assignlist.add(assign);
				// 把该赋值语句插入到数据库中的赋值语句表中

			}
			projectanalysisService.addAssign(assignlist);

			// 处理函数调用语句对象的格式，将其封装到对应的表中
			// System.out.println(cpp.funccalllist.size());
			List<Callfunction> callfunctionlist = new ArrayList<Callfunction>();
			for (Funccallstate funccallstate : cpp.funccalllist) {

				cn.web.security.pojo.Callfunction callfunction = new cn.web.security.pojo.Callfunction();
				callfunction.setId(funccallstate.getFunccallid());
				callfunction.setStatement(funccallstate.getFunccall());
				callfunction.setPosition(funccallstate.getPosition());
				callfunction.setCasecondition(funccallstate.getCasecondition());
				callfunction.setProjectid(projectid);

				// 确定被调用函数的id
				String funcname1 = funccallstate.getFuncname(); // 只是单纯的函数名
				for (Functions function : functionlist) { // 重名问题不容易解决（必须解决
															// ，+形参列表进行解决）
					// if(funcname1.equals(function.getName()+function.getParameter()))
					// {
					if (funcname1.equals(function.getName())) {
						callfunction.setBefunctionid(function.getId());
						break;
					}
				}
				// 确定所属节点的id
				callfunction.setNodeid(funccallstate.getFatherid());

				// 根据函数名(带形参)和项目id，找到该函数的id
				String funcname2 = funccallstate.getOffunc();
				for (Functions function : functionlist) {
					if (funcname2.equals("1") || funcname2.equals("2")) {
						callfunction.setFunctionid(0);
						break;
					}
					if (funcname2.contains("::")) {
						funcname2 = funcname2.split("::")[1];
					}
					String parameter = "";
					if (function.getParameter() == null) {
						parameter = "";
					} else {
						parameter = function.getParameter();
					}
					if (funcname2.equals(function.getName() + "(" + parameter
							+ ")")) {
						callfunction.setFunctionid(function.getId());
						break;
					}
				}
				callfunctionlist.add(callfunction);
				// 将该函数调用语句对象存储到数据库中的函数调用表
			}

			projectanalysisService.addCallfunction(callfunctionlist);
		}
		// -----------------------以上的部分已将解析得到的结果存入数据库中--------------------------
		ModelAndView mv=new ModelAndView();
		mv.addObject("projectid", projectid);
		mv.addObject("analysis", "0");
		mv.setViewName("analysisResult");
		return mv;

	}

	/**
	 * 根据项目id查询解析结果中的变量列表
	 * 
	 * @param projectid
	 * @param results
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/analysisProject1")
	@ResponseBody
	public JSONObject analysisProject1(@RequestParam Map map) throws Exception {

		JSONObject result = new JSONObject();
		if (StringUtil.isNULLOREmpty((String) map.get("projectid"))) {
			map.put("projectid", "0");
		}
		Integer projectid = Integer.valueOf((String) map.get("projectid"));
		System.out.println(111111);
		System.out.println(projectid);
		result.put("type", "var");
		result.put("projectid", projectid);
		return result;
	}

	/**
	 * 根据项目id查询解析结果中的变量列表
	 * 
	 * @param projectid
	 * @param results
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/queryVarResults")
	@ResponseBody
	public JSONObject queryVarResults(@RequestParam Map map) throws Exception {

		JSONObject result = new JSONObject();
		if (StringUtil.isNULLOREmpty((String) map.get("pn"))) {
			map.put("pn", "1");
		}
		Integer pn = Integer.valueOf((String) map.get("pn"));
		Integer projectid = Integer.valueOf((String) map.get("projectid"));
		PageHelper.startPage(pn, 10);

		List<VarInfoView> list = resultsService
				.findAnalysisVarResults(projectid);
		System.out.println(list.toString());

		// 获取PageInfo分页bean
		PageInfo pageInfo = new PageInfo<>(list);
		result.put("type", "var");
		result.put("pageInfo", pageInfo);
		return result;
	}

	/**
	 * 根据项目id查询解析结果中的函数列表
	 * 
	 * @param projectid
	 * @param results
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/queryFunctionsResults")
	@ResponseBody
	public JSONObject queryFunctionsResults(@RequestParam Map map)
			throws Exception {

		JSONObject result = new JSONObject();
		// 先设置分页的拦截参数
		if (StringUtil.isNULLOREmpty((String) map.get("pn"))) {
			map.put("pn", "1");
		}
		Integer pn = Integer.valueOf((String) map.get("pn"));
		Integer projectid = Integer.valueOf((String) map.get("projectid"));
		PageHelper.startPage(pn, 10);
		// 获取PageInfo分页bean
		List<FunctionsInfoView> list = resultsService
				.findAnalysisFunctionResults(projectid);
		PageInfo pageInfo = new PageInfo<>(list);
		result.put("type", "function");
		result.put("pageInfo", pageInfo);

		return result;
	}

	/**
	 * 根据项目id查询解析结果中的类与对象列表
	 * 
	 * @param projectid
	 * @param results
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/queryClassmentResults")
	@ResponseBody
	public JSONObject queryClassmentResults(@RequestParam Map map)
			throws Exception {
		if (StringUtil.isNULLOREmpty((String) map.get("pn"))) {
			map.put("pn", "1");
		}
		JSONObject result = new JSONObject();
		Integer pn = Integer.valueOf((String) map.get("pn"));

		// 先设置分页的拦截参数
		PageHelper.startPage(pn, 10);

		List<ClassmentInfoView> list = resultsService
				.findAnalysisClassResults(pn);

		// 获取PageInfo分页bean
		PageInfo pageInfo = new PageInfo<>(list);
		result.put("type", "classment");
		result.put("pageInfo", pageInfo);

		return result;
	}

}
