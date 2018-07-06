package com.techec.service.mall.storegoods;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.storegoods.StoreGoods;

import java.util.List;



public interface IStoreGoodsService extends IBaseService<StoreGoods> {
	/**
	 * 依据用户id，查询用户所有收藏的条目
	 * @param storeGoods
	 * @return
	 */
    List<StoreGoods> queryAllStoreGoodsByUserId(StoreGoods storeGoods);
	
	/**
	 * 依据用户id和商品id，查询收藏条目
	 * @param storeGoods
	 * @return
	 */
    StoreGoods queryStoreGoodsByUserIdAndGoodsId(StoreGoods storeGoods);
	
}
