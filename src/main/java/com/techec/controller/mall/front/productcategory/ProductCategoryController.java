package com.techec.controller.mall.front.productcategory;

import com.constant.SystemCode;
import com.techec.entity.mall.productcategory.ProductCategory;
import com.techec.service.mall.productcategory.IProductCategoryService;
import com.util.JsonResponse;
import com.util.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;



/**
 * 商品分类前台controller
 */
@Controller
@RequestMapping("/front/productCategory/productCategory")
public class ProductCategoryController {

	@Resource
	private IProductCategoryService productCategoryService;

	/**
	 * 获取首页的一级商品分类，按照更新时间倒序取前9个推荐的一级分类
	 */
	@ResponseBody
	@RequestMapping("/getHomePageCategory")
	public JsonResponse<PageResult<ProductCategory>> getHomePageCategory(
			PageResult<ProductCategory> page, ProductCategory productCategory,
			HttpServletRequest request) {
		JsonResponse<PageResult<ProductCategory>> result = new JsonResponse<PageResult<ProductCategory>>();
//		 List<ProductCategory> firstLevelList =
//		 productCategoryService.getHomePageCategory();
//		 User User = SessionUtil.getUser(request);
//		 if(null == User){
//		 result.setRes(SystemCode.NO_LOGIN);
//		 return result;
//		 }
		page.setPageNo(1);
		page.setPageSize(9);
		productCategoryService.queryByPageFront(page, productCategory);
		if (page.getTotal() != 0) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(page);
		} else {
			result.setRes(SystemCode.FAILURE);
		}
		return result;
	}

	/**
	 * 获取二次分类列表
	 */
	@ResponseBody
	@RequestMapping("/querySecondCategoryListByFirstCategoryId")
	public JsonResponse<List<ProductCategory>> querySecondCategoryListByFirstCategoryId(
			Integer categoryId, HttpServletRequest request) {
		JsonResponse<List<ProductCategory>> result = new JsonResponse<List<ProductCategory>>();
		List<ProductCategory> productCategoryList = productCategoryService
				.getAllNormalChildCategoryByCategoryId(categoryId);
		if (productCategoryList != null) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(productCategoryList);
		}
		return result;
	}

	/**
	 * 获取一次分类列表
	 */
	@ResponseBody
	@RequestMapping("/getAllNormalFirstLevelCategory")
	public JsonResponse<List<ProductCategory>> getAllNormalFirstLevelCategory(
			HttpServletRequest request) {
		JsonResponse<List<ProductCategory>> result = new JsonResponse<List<ProductCategory>>();
		List<ProductCategory> productCategoryList = productCategoryService
				.getAllNormalFirstLevelCategory();
		if (productCategoryList != null) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(productCategoryList);
		}
		return result;
	}

}
