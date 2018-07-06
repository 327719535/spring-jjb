package com.techec.dao.mall.order;


import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.order.Order;
import com.techec.entity.mall.order.OrderAdminSearchVO;

import java.util.List;

public interface OrderMapper extends IBaseDao<Order> {
	Order getOne(String orderNumber);

	/**
	 * @param orderNumber
	 * @return
	 */
    Order getOrderByNumber(String orderNumber);

	/**
	 * 获取订单支付，未支付金额
	 * 
	 * @return
	 */
    Integer getAmountByPaystate(Integer payState);
	
	
	/**
	 * 获取订单数
	 */
    Integer getCountByPaystate(Integer payState);
	
	/**
	 * 依据商品订单查询类，查询商品订单列表
	 * @param entity
	 * @return
	 */
    List<Order> getPageByOrderAdminSearchVO(OrderAdminSearchVO entity);
	
	/**
	 * 依据商品订单查询类，查询商品订单导出列表
	 * @param entity
	 * @return
	 */
    List<Order> getPageExportByOrderAdminSearchVO(OrderAdminSearchVO entity);
}