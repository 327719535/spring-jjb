package com.techec.dao.mall.logistics;


import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.logistics.Logistics;

import java.util.List;

public interface LogisticsMapper extends IBaseDao<Logistics> {
	//搜索物流列表
    List<Logistics> getListLogistics();
	Logistics getFirstLogistics();
}