package com.techec.dao.mall.order;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.order.OrderDetails;
import com.techec.entity.mall.order.OrderDetailsAdminSearchVO;

import java.util.List;


public interface OrderDetailsMapper extends IBaseDao<OrderDetails> {
	Integer insertBatch(List<OrderDetails> list);
	
	/**
	 * 依据商品订单查询类，查询商品订单详细列表
	 * @param entity
	 * @return
	 */
    List<OrderDetails> getPageByOrderDetailsAdminSearchVO(OrderDetailsAdminSearchVO entity);
	
	
	/**
	 * 依据商品订单查询类，查询商品订单详细报表
	 * @param entity
	 * @return
	 */
    List<OrderDetails> getDetailReportByOrderDetailsAdminSearchVO(OrderDetailsAdminSearchVO entity);
	
	/**
	 * 依据商品订单查询类，获取商品销售总额
	 * @param entity
	 * @return
	 */
    long getTotalDetailsAmountByOrderDetailsAdminSearchVO(OrderDetailsAdminSearchVO entity);
	
	/**
	 * 依据商品订单查询类，获取商品销售总数
	 * @param entity
	 * @return
	 */
    long getTotalNumAmountByOrderDetailsAdminSearchVO(OrderDetailsAdminSearchVO entity);

}