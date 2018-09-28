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
import cn.web.security.pojo.Functions;
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
	
	@RequestMapping("/queryProjects2")
	public ModelAndView queryProjects2(@ModelAttribute("condition")Project project,
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
		mv.setViewName("networkProject");
		
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
	
	
}
