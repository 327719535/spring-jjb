package com.techec.dao.mall.roleModule;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.roleModule.RoleModule;

import java.util.List;

/**
 * 管理员角色模块Mapper
 */
public interface RoleModuleMapper extends IBaseDao<RoleModule> {
	/**
	 * 删除所有roleId的记录
	 * 
	 * @param roleId
	 */
	void deleteByRoleModuleId(int roleModuleId);
	/**
	 * 根据roleId查询记录
	 * @param roleId
	 */
	List<RoleModule>  selectByRoleId(int roleId);
}
