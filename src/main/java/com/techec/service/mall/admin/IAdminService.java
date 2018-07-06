package com.techec.service.mall.admin;


import com.techec.common.base.IBaseService;
import com.techec.entity.mall.admin.Admin;

public interface IAdminService extends IBaseService<Admin> {
	Admin login(Admin admin);
	int forgetPassword(Admin admin);
	int getCountByAdminName(String name);
}
