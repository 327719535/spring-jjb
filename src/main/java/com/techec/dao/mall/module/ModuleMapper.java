package com.techec.dao.mall.module;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.module.Module;

import java.util.List;


/**
 * 系统模块Mapper

 */
public interface ModuleMapper extends IBaseDao<Module> {
	/**
	 * 查询该角色拥有的系统模块
	 */
	List<Module> selectByRoleId(int roleId);

	List<Module> queryModulesByAdminId(int adminId);
}
