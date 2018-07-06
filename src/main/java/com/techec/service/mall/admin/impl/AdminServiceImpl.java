package com.techec.service.mall.admin.impl;


import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.admin.AdminMapper;
import com.techec.entity.mall.admin.Admin;
import com.techec.service.mall.admin.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements IAdminService {

	@Resource
	private AdminMapper adminMapper;

	@Override
	protected IBaseDao<Admin> getMapper() {
		return adminMapper;
	}

	@Override
	public Admin login(Admin user) {
		return adminMapper.login(user);
	}

	@Override
	public int forgetPassword(Admin user) {
		return adminMapper.forgetPassword(user);
	}

	@Override
	public int getCountByAdminName(String name) {
		return adminMapper.getCountByAdminName(name);
	}
	
}
