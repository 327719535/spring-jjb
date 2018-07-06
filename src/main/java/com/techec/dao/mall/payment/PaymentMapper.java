package com.techec.dao.mall.payment;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.payment.Payment;

import java.util.List;


/**
 * 付款方式
 */
public interface PaymentMapper extends IBaseDao<Payment> {
	/**根据用户id查询用户的付款方式
	 * @param userId 用户id
	 * @return
	 */
	List<Payment> queryUserPayment(int userId);
	/**
	 * 查询不通用的付款方式
	 * @return
	 */
	List<Payment> queryPayment();
}
