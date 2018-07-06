package com.techec.dao.mall.order;


import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.order.JoinOrder;

public interface JoinOrderMapper extends IBaseDao<JoinOrder> {
	JoinOrder selectByJoinOrderNumber(JoinOrder joinOrder);
}