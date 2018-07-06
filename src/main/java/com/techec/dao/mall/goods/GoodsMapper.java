package com.techec.dao.mall.goods;


import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.goods.Goods;
import com.techec.entity.mall.goods.QueryGoodsAdminVO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface GoodsMapper extends IBaseDao<Goods> {
	List<Goods> getAllSelectGoods(@Param("goodsIds") String goodsIds);
	/**
	 * 依据商品种类，获取所有有效商品，供前台调用,支持分页查询
	 * @param entity
	 * @return
	 */
    List<Goods> getPageFrontByGoodsCategory(Goods entity);
	
	/**
	 * 依据商品名称模糊查询，获取分页查询结果，供前端调用，去掉了下架的商品
	 * @param entity
	 * @return
	 */
    List<Goods> getPageFrontByGoodsName(Goods entity);
	
	/**
	 * 依据用户id查询收藏的商品，获取分页查询结果，供前端调用，去掉了下架的商品
	* @param userId 当前用户id
	 * @return
	 */
    List<Goods> getPageFrontByMyStoreGoods(int userId);
	
	/**
	 * 依据商品查询类，查询商品列表，不含删除状态
	 * @param entity
	 * @return
	 */
    List<Goods> getPageByQueryGoodsAdminVO(QueryGoodsAdminVO entity);
	
	/**
	 * 分页获取推荐的上架商品，依据更新时间倒序取商品,不含删除状态，供前端调用
	 * @return
	 */
    List<Goods> getPageFrontRecommendAndIsMarketableGoods();
}