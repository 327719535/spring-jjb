package com.techec.service.mall.user;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.user.UserPayment;
import com.techec.entity.mall.user.UserPrivilege;
import com.techec.entity.mall.user.UserVo;
import com.techec.entity.personal.User;
import com.util.PageResult;

import java.util.List;


public interface IUserService extends IBaseService<User> {
	User getOneByOpenid(String openid);

	User getOneByPhone(String phone);

	int updatePhone(String tel, String openid);

	int getCountByPhone(String phone);

	void grantPrivilege(UserPrivilege userPrivilege, List <UserPayment> userPayments) throws Exception;

	String getAllFrontUser();

	PageResult<User> getUsersByUserIds(PageResult <User> page, String userIds);

	PageResult<User> queryUserByPage(PageResult <User> page, UserVo userVo);

}
