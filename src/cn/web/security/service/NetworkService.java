package cn.web.security.service;


import java.util.List;
import cn.web.security.pojo.Networkmetrics;
import cn.web.security.pojo.Nodemetrics;



public interface NetworkService {
	public void addNodemetrics(Nodemetrics nodemetrics);
	
	public void addNetworkmetrics(Networkmetrics networkmetrics);
    
	public List<Nodemetrics> getNodemetrics(int id);    //project's id
	
	public List<Networkmetrics> getNetworkmetrics(int id);   //project's id
}
