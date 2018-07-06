package com.techec.dao.mall.productcategory;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.productcategory.ProductCategory;

import java.util.List;


public interface ProductCategoryMapper extends IBaseDao<ProductCategory> {
	/**
	 * 通过商品种类id，查询所有一级子种类
	 * 
	 * @param categoryId
	 *            商品种类id
	 * @param notState
	 *            不包含的状态
	 * @return 一级子商品种类列表
	 */
    List<ProductCategory> getChildCategoryByCategoryId(int categoryId, int notState);
	
	/**
	 * 通过商品种类id，商品种类状态 查询所有一级子种类
	 * @param categoryId
	 * 			商品种类id
	 * @param state
	 * 			包含的状态
	 * @return
	 */
    List<ProductCategory> getChildCategoryByCategoryIdAndState(int categoryId, int state);

	/**
	 * 获取所有有效的一级商品分类
	 * @param notState
	 *          不包含的状态
	 * @return
	 */
    List<ProductCategory> getFirstLevelCategory(int notState);
	/**
	 * 获取所有有效的一级商品分类
	 * @param State
	 *        包含的状态
	 * @return
	 */
    List<ProductCategory> getFirstLevelCategoryByState(int State);

	/**
	 * 获取首页的一级商品分类，按照更新时间倒序取前9个推荐的一级分类
	 * 
	 * @return
	 */
    List<ProductCategory> getHomePageCategory();
}