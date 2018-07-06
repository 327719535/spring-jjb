package com.techec.service.mall.order.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.order.OrderCertifyMapper;
import com.techec.entity.mall.order.OrderCertify;
import com.techec.service.mall.order.IOrderCertifyService;

import javax.annotation.Resource;

/**
 * 订单收款凭证服务实现类
 */
public class OrderCertifyServiceImpl extends BaseServiceImpl<OrderCertify> implements IOrderCertifyService {

	@Resource
	private OrderCertifyMapper orderCertifyMapper;

	@Override
	protected IBaseDao<OrderCertify> getMapper() {
		return orderCertifyMapper;
	}

}
