package com.techec.service.mall.logistics.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.logistics.LogisticsMapper;
import com.techec.entity.mall.logistics.Logistics;
import com.techec.service.mall.logistics.ILogisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LogisticsServiceImpl extends BaseServiceImpl<Logistics> implements ILogisticsService {

	@Resource
	LogisticsMapper logisticsMapper;
	@Override
	protected IBaseDao<Logistics> getMapper() {
		return logisticsMapper;
	}
	@Override
	public List<Logistics> getListLogistics() {
		return logisticsMapper.getListLogistics();
	}

}
