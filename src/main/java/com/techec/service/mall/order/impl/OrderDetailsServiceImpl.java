package com.techec.service.mall.order.impl;

import com.github.pagehelper.PageHelper;
import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.order.OrderDetailsMapper;
import com.techec.entity.mall.order.OrderDetails;
import com.techec.entity.mall.order.OrderDetailsAdminSearchVO;
import com.techec.service.mall.order.IOrderDetailsService;
import com.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  TODO
 */
@Service
public class OrderDetailsServiceImpl extends BaseServiceImpl<OrderDetails> implements IOrderDetailsService {
	@Resource
	private OrderDetailsMapper orderDetailsMapper;
	@Override
	protected IBaseDao<OrderDetails> getMapper() {
		return orderDetailsMapper;
	}
	
	@Override
	public long getTotalDetailsAmountByOrderDetailsAdminSearchVO(
			OrderDetailsAdminSearchVO entity) {
		
		return orderDetailsMapper.getTotalDetailsAmountByOrderDetailsAdminSearchVO(entity);
	}
	@Override
	public long getTotalNumAmountByOrderDetailsAdminSearchVO(
			OrderDetailsAdminSearchVO entity) {
		
		return orderDetailsMapper.getTotalNumAmountByOrderDetailsAdminSearchVO(entity);
	}
	@Override
	public PageResult<OrderDetails> getPageByOrderDetailsAdminSearchVO(
			PageResult<OrderDetails> t, OrderDetailsAdminSearchVO entity) {
		int pageNo=t.getPageNo();
    	int pageSize=t.getPageSize();
		pageNo = pageNo == 0?1:pageNo;
		pageSize = pageSize == 0?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); 
		return PageResult.toPageResult(orderDetailsMapper.getPageByOrderDetailsAdminSearchVO(entity),t);
	}

	@Override
	public List<OrderDetails> getDetailReportByOrderDetailsAdminSearchVO(
			OrderDetailsAdminSearchVO entity) {
		return orderDetailsMapper.getDetailReportByOrderDetailsAdminSearchVO(entity);
	}

}
