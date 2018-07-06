package com.techec.service.mall.adPosition.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.adPosition.AdPositionMapper;
import com.techec.entity.mall.adPosition.AdPosition;
import com.techec.service.mall.adPosition.IAdPositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 广告位置服务接口实现
 *
 */
@Service
public class AdPositionServiceImpl extends BaseServiceImpl<AdPosition> implements IAdPositionService {
	@Resource
	private AdPositionMapper adPositionMapper;
	
	@Override
	protected IBaseDao<AdPosition> getMapper() {
		return this.adPositionMapper;
	}

}
