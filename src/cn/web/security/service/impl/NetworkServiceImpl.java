package cn.web.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.web.security.mapper.NetworkmetricsMapper;
import cn.web.security.mapper.NodemetricsMapper;
import cn.web.security.pojo.Networkmetrics;
import cn.web.security.pojo.NetworkmetricsExample;
import cn.web.security.pojo.Nodemetrics;
import cn.web.security.pojo.NodemetricsExample;
import cn.web.security.service.NetworkService;

@Service
public class NetworkServiceImpl implements NetworkService {

	
	@Autowired
	private NodemetricsMapper nodemetricsMapper;
	@Autowired
	private NetworkmetricsMapper networkmetricsMapper;
	
	@Override
	public void addNodemetrics(Nodemetrics nodemetrics) {
		
		nodemetricsMapper.insert(nodemetrics);

	}

	@Override
	public void addNetworkmetrics(Networkmetrics networkmetrics) {
		
		networkmetricsMapper.insert(networkmetrics);

	}

	@Override
	public List<Nodemetrics> getNodemetrics(int id) {
		
		NodemetricsExample example=new NodemetricsExample();
		NodemetricsExample.Criteria criteria=example.createCriteria();
		criteria.andProjectidEqualTo(id);
		List<Nodemetrics> list=nodemetricsMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Networkmetrics> getNetworkmetrics(int id) {
		
		NetworkmetricsExample example=new NetworkmetricsExample();
		NetworkmetricsExample.Criteria criteria=example.createCriteria();
		criteria.andProjectidEqualTo(id);
		List<Networkmetrics> list=networkmetricsMapper.selectByExample(example);
		return list;
	}

}
