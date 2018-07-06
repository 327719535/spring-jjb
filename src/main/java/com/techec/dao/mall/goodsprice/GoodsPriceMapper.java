package com.techec.dao.mall.goodsprice;


import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.goodsprice.GoodsPrice;

import java.util.List;

/**
 *
 * 商品规格价格dao
 */
public interface GoodsPriceMapper extends IBaseDao<GoodsPrice> {
	/**
	 * 依据价格id及状态查询相关记录
	 * @param priceId 价格id
	 * @param State 记录状态
	 * @return
	 */
    GoodsPrice findGoodsPriceByPriceIdAndState(int priceId, Byte state);
	/**
	 * 根据商品id，查询所有规格（去除不包含的状态）
	 * @param goodsId 商品id
	 * @param notState 不包含的状态
	 * @return
	 */
    List<GoodsPrice> findAllByGoodsIdAndNotState(int goodsId, Byte notState);
}
