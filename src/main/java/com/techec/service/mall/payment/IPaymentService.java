package com.techec.service.mall.payment;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.payment.Payment;
import com.techec.entity.personal.User;

import java.util.List;

/**
 * 付款方式接口定义
 */
public interface IPaymentService extends IBaseService<Payment> {
	
	/**查询用户所拥有的付款方式，包括通用的和拥有的高级付款方式
	 * @param user 用户对象
	 * @return
	 */
	List<Payment> queryUserPayment(User user);
	
}
