package com.techec.service.mall.goodsprice;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.goodsprice.GoodsPrice;

import java.util.List;

public interface IGoodsPriceService extends IBaseService<GoodsPrice> {
	/**
	 * 依据价格id及状态查询相关记录
	 * 
	 * @param priceId
	 *            价格id
	 * @param
	 *
	 * @return
	 */
    GoodsPrice findGoodsPriceByPriceIdAndState(int priceId, Byte state);

	/**
	 * 根据商品id，查询所有规格（去除不包含的状态）
	 * 
	 * @param goodsId
	 *            商品id
	 * @param notState
	 *            不包含的状态
	 * @return
	 */
    List<GoodsPrice> findAllByGoodsIdAndNotState(int goodsId,
                                                 Byte notState);

	/**
	 * 通过商品id查询所有正常使用的规格
	 * 
	 * @param goodsId
	 *            商品id
	 * @return
	 */
    List<GoodsPrice> findAllNormalGoodsPriceByGoodsId(int goodsId);

	/**
	 * 通过规格id查询正常状态的记录
	 * 
	 * @param priceId
	 *            规格id
	 * @return
	 */
    GoodsPrice findNormalGoodsPriceByPriceId(int priceId);
}
