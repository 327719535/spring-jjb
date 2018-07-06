package com.techec.dao.mall.storegoods;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.storegoods.StoreGoods;

import java.util.List;


/**
 * 收藏dao
 */
public interface StoreGoodsMapper extends IBaseDao<StoreGoods> {
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