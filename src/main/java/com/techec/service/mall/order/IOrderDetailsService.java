package com.techec.service.mall.order;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.order.OrderDetails;
import com.techec.entity.mall.order.OrderDetailsAdminSearchVO;
import com.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  订单详情
 */
public interface IOrderDetailsService extends IBaseService<OrderDetails> {
	/**
	 * 依据商品订单统计查询类，查询商品订单详细列表
	 * @param entity
	 * @return
	 */
    PageResult<OrderDetails> getPageByOrderDetailsAdminSearchVO(@Param("t") PageResult<OrderDetails> t, @Param("entity") OrderDetailsAdminSearchVO entity);
	
	/**
	 * 依据商品订单统计查询类，查询商品订单详细报表
	 * @param entity
	 * @return
	 */
    List<OrderDetails> getDetailReportByOrderDetailsAdminSearchVO(OrderDetailsAdminSearchVO entity);
	
	
	/**
	 * 依据商品订单统计查询类，获取商品销售总额
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


