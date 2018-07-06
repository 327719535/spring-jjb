package com.techec.dao.mall.user;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.user.UserPayment;

import java.util.List;

/**
 * 用户优惠
 */
public interface UserPaymentMapper extends IBaseDao<UserPayment> {
	List<UserPayment> selectByUserId(int userId);
}
