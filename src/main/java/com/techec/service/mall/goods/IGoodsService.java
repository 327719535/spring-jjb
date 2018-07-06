package com.techec.service.mall.goods;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.goods.Goods;
import com.techec.entity.mall.goods.QueryGoodsAdminVO;
import com.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsService extends IBaseService<Goods> {
	List<Goods> getAllSelectGoods(String goodsIds);
	/**
	 * 依据对象除goodsid外的所有属性作为查询条件
	 */
    Goods getOne(Goods goods);
	
	/**
	 * 依据商品种类，获取所有有效商品，供前台调用
	 * @param entity
	 * @return
	 */
    List<Goods> getPageFrontByGoodsCategory(Goods entity);
	
	/**
	 * 依据商品分类id，获取分页查询结果，供前端调用，去掉了下架的商品
	 * @param t
	 * @param entity
	 * @return
	 */
    PageResult<Goods> getPageFrontByGoodsCategory(@Param("t") PageResult<Goods> t, @Param("entity") Goods entity);
	
	/**
	 * 依据商品名称模糊查询，获取分页查询结果，供前端调用，去掉了下架的商品
	 * @param t
	 * @param entity
	 * @return
	 */
    PageResult<Goods> getPageFrontByGoodsName(@Param("t") PageResult<Goods> t, @Param("entity") Goods entity);
	
	
	/**
	 * 依据用户id查询收藏的商品，获取分页查询结果，供前端调用，去掉了下架的商品
	 * @param t
	 * @param userId 当前用户id
	 * @return
	 */
    PageResult<Goods> getPageFrontByMyStoreGoods(@Param("t") PageResult<Goods> t, @Param("userId") int userId);
	
	
	
	/**
	 * 依据商品查询类，查询商品列表，不含删除状态
	 * @param entity
	 * @return
	 */
    PageResult<Goods> getPageByQueryGoodsAdminVO(@Param("t") PageResult<Goods> t, @Param("entity") QueryGoodsAdminVO entity);
	
	/**
	 * 分页获取推荐的上架商品，依据更新时间倒序取商品,不含删除状态，供前端调用
	 * @param t
	 * @return
	 */
    PageResult<Goods> getPageFrontRecommendAndIsMarketableGoods(@Param("t") PageResult<Goods> t);
	
}
