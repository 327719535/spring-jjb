package com.techec.dao.mall.user;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.user.UserPrivilege;

/**
 * 用户优惠
 *
 */
public interface UserPrivilegeMapper extends IBaseDao<UserPrivilege> {
	/**
	 * 查询用户优惠
	 * 
	 * @param userId 用户id
	 * @return
	 */
	UserPrivilege selectByUserId(int userId);
	
	UserPrivilege selectAllByUserId(int userId);
}
