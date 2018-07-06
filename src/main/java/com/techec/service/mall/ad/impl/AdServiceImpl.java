package com.techec.service.mall.ad.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.ad.AdMapper;
import com.techec.entity.mall.ad.Ad;
import com.techec.service.mall.ad.IAdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 广告服务接口实现
 */
@Service
public class AdServiceImpl extends BaseServiceImpl<Ad> implements IAdService {
	@Resource
	private AdMapper adMapper;

	@Override
	protected IBaseDao<Ad> getMapper() {
		return this.adMapper;
	}
}
