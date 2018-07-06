package com.techec.service.mall.payment.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.payment.PaymentMapper;
import com.techec.entity.mall.payment.Payment;
import com.techec.entity.personal.User;
import com.techec.service.mall.payment.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 付款方式接口实现类
 */
@Service
public class PaymentServiceImpl extends BaseServiceImpl<Payment> implements IPaymentService {
	@Resource
	private PaymentMapper paymentMapper;

	@Override
	protected IBaseDao<Payment> getMapper() {
		return this.paymentMapper;
	}

	@Override
	public List<Payment> queryUserPayment(User user) {
		return paymentMapper.queryUserPayment(user.getUserId());
	}
}
