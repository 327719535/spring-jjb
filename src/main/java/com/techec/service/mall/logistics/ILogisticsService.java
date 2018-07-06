package com.techec.service.mall.logistics;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.logistics.Logistics;

import java.util.List;

public interface ILogisticsService extends IBaseService<Logistics> {
	List<Logistics> getListLogistics();
}
