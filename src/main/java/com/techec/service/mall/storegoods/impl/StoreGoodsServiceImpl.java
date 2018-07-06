package com.techec.service.mall.storegoods.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.storegoods.StoreGoodsMapper;
import com.techec.entity.mall.storegoods.StoreGoods;
import com.techec.service.mall.storegoods.IStoreGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreGoodsServiceImpl extends BaseServiceImpl<StoreGoods>
		implements IStoreGoodsService {

	@Resource
	private StoreGoodsMapper storeGoodsMapper;

	@Override
	protected IBaseDao<StoreGoods> getMapper() {
		return storeGoodsMapper;
	}

	@Override
	public List<StoreGoods> queryAllStoreGoodsByUserId(StoreGoods storeGoods) {
		return storeGoodsMapper.queryAllStoreGoodsByUserId(storeGoods);
	}

	@Override
	public StoreGoods queryStoreGoodsByUserIdAndGoodsId(StoreGoods storeGoods) {
		return storeGoodsMapper.queryStoreGoodsByUserIdAndGoodsId(storeGoods);
	}

}
