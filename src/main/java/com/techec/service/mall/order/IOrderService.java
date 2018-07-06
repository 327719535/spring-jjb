package com.techec.service.mall.order;


import com.techec.common.base.IBaseService;
import com.techec.entity.mall.order.JoinOrder;
import com.techec.entity.mall.order.Order;
import com.techec.entity.mall.order.OrderAdminSearchVO;
import com.techec.entity.mall.order.OrderCertify;
import com.techec.entity.personal.User;
import com.util.PageResult;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface IOrderService extends IBaseService<Order> {
	Order getOne(String orderNumber);

	String addBatch(Order order) throws Exception;

	/**
	 * @param orderNumber
	 */
    Order getOrderByNumber(String orderNumber);

	Integer updateAndAddCertify(Order order, OrderCertify orderCertify)
			throws Exception;

	/**
	 * 根据支付状态查询总金额
	 * 
	 * @return
	 * @throws Exception
	 */
    Integer getTotalAmountByPaystate(Integer payState) throws Exception;

	/**
	 * 根据支付状态查询订单数
	 */
    Integer getCountByPaystate(Integer payState) throws Exception;

	String joinOrder(JoinOrder joinOrder) throws Exception;

	JoinOrder getJoinOrderByNumber(String orderNumber);

	void notifyAll(String orderNumbers, String paymentSeq) throws Exception;

	void buyGoodsAgain(Order order, User user) throws Exception;
	
	/**
	 * 依据商品订单查询类，查询商品订单列表
	 * @param entity
	 * @return
	 */
    PageResult<Order> getPageByOrderAdminSearchVO(@Param("t") PageResult<Order> t, @Param("entity") OrderAdminSearchVO entity) throws Exception;
	
	/**
	 * 依据商品订单查询类，查询导出商品订单列表
	 * @param entity
	 * @return
	 * @throws Exception
	 */
    List<Order> getPageExportByOrderAdminSearchVO(OrderAdminSearchVO entity) throws Exception;
	
}
