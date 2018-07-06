package com.techec.dao.mall.admin;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.admin.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface AdminMapper extends IBaseDao<Admin> {
	Admin login(Admin admin);
	int forgetPassword(Admin admin);
	int getCountByAdminName(String name);
	//测试导出数据到excel
    List<Admin> getAdminByCondition(@Param("state") Byte state);
}