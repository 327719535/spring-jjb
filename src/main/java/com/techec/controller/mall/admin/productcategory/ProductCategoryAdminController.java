package com.techec.controller.mall.admin.productcategory;

import com.constant.SystemCode;
import com.techec.controller.mall.AbstractController;
import com.techec.entity.mall.admin.Admin;
import com.techec.entity.mall.goods.Goods;
import com.techec.entity.mall.goods.QueryGoodsAdminVO;
import com.techec.entity.mall.productcategory.ProductCategory;
import com.techec.service.mall.goods.IGoodsService;
import com.techec.service.mall.productcategory.IProductCategoryService;
import com.util.JsonResponse;
import com.util.PageResult;
import com.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 *  管理员 商品种类模块 后台
 */
@Controller
@RequestMapping("/admin/productcategory/productcategory")
public class ProductCategoryAdminController extends AbstractController {
	@Resource
	private IProductCategoryService productCategoryService;

	@Resource
	private IGoodsService goodsService;
	/**
	 * 商品种类列表
	 */
	@ResponseBody
	@RequestMapping("/getProductcategoryByPage")
	public JsonResponse<PageResult<ProductCategory>> getAdminByPage(
			PageResult<ProductCategory> page, ProductCategory productCategory,
			HttpServletRequest request) {
		JsonResponse<PageResult<ProductCategory>> result = new JsonResponse<PageResult<ProductCategory>>();
		productCategoryService.queryByPage(page, productCategory);
		if (page.getTotal() != 0) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(page);
		} else {
			result.setRes(SystemCode.FAILURE);
		}
		return result;
	}
	
	
	
	/**
	 * 依据商品分类id获取所有可用的子级商品种类列表
	 */
	@ResponseBody
	@RequestMapping("/getAllNormalChildCategoryByCategoryId")
	public JsonResponse<List<ProductCategory>> getAllNormalChildCategoryByCategoryId(
			PageResult<ProductCategory> page, ProductCategory productCategory,
			HttpServletRequest request) {
		JsonResponse<List<ProductCategory>> result = new JsonResponse<List<ProductCategory>>();
		List<ProductCategory> tempList=productCategoryService.getAllChildCategoryByCategoryId(productCategory.getCategoryId());
		if (tempList != null &&tempList.size()>0) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(tempList);
		} else {
			result.setRes(SystemCode.FAILURE);
		}
		return result;
	}

	/**
	 * 添加商品种类
	 */
	@ResponseBody
	@RequestMapping("/addProductcategory")
	public JsonResponse<String> addProductcategory(
			ProductCategory productcategory, HttpServletRequest request) {
		JsonResponse<String> result = new JsonResponse<String>();
		try {
			if (productcategory.getCategoryId() != 0) {
				if (productCategoryService.getOne(productcategory) != null) {
					result.setRes(SystemCode.USER_EXISTS);
					return result;
				}
			}
			productcategory.setCreateTime(new Date());
			productcategory.setUpdateTime(new Date());
			Admin admin = SessionUtil.getAdminUser(request);
			productcategory.setAdminId(admin.getAdminId());
			productCategoryService.insertSelective(productcategory);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request, "[添加商品种类异常]", e);
			result.setRes(SystemCode.FAILURE);
		}
		return result;
	}

	/**
	 * 编辑管理员
	 */
	@ResponseBody
	@RequestMapping("/editProductCategory")
	public JsonResponse<ProductCategory> editAdmin(HttpServletRequest request,
			ProductCategory productCategory) {
		JsonResponse<ProductCategory> result = new JsonResponse<ProductCategory>(
				SystemCode.FAILURE);
		try {
			productCategory.setUpdateTime(new Date());
			Admin admin =SessionUtil.getAdminUser(request);
			productCategory.setAdminId(admin.getAdminId());
			productCategoryService.updateByPrimaryKeySelective(productCategory);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request, "[商品种类信息编辑失败]", e);
			result.setRes(SystemCode.OBJ_EXISTS);
		}
		return result;
	}

	/**
	 * 
	 * @param request
	 * @return 获取管理员信息
	 */
	@ResponseBody
	@RequestMapping("/getProductCategoryInfo")
	public JsonResponse<ProductCategory> getAdminInfo(Integer categoryId,
			HttpServletRequest request) {
		JsonResponse<ProductCategory> result = new JsonResponse<ProductCategory>();
		ProductCategory productCategory = productCategoryService
				.selectByPrimaryKey(categoryId);
		result.setRes(SystemCode.SUCCESS);
		result.setObj(productCategory);
		return result;
	}
	
	/**
	 * 删除商品
	 */
	@ResponseBody
	@RequestMapping("/delProductcategoryById")
	public JsonResponse<ProductCategory> delProductcategoryById(ProductCategory productcategory,HttpServletRequest request) {
		JsonResponse<ProductCategory> result = new JsonResponse<ProductCategory>();
		Admin admin =SessionUtil.getAdminUser(request);
		productcategory.setAdminId(admin.getAdminId());
		productcategory.setState((byte)3);
		productcategory.setUpdateTime(new Date());
		
		PageResult<Goods> tempquery=new PageResult<Goods>();
		tempquery.setPageNo(1);
		tempquery.setPageSize(1);
		QueryGoodsAdminVO tempqueryVo=new QueryGoodsAdminVO();
		tempqueryVo.setCategoryId(Integer.toString(productcategory.getCategoryId()));
		goodsService.getPageByQueryGoodsAdminVO(tempquery,tempqueryVo);
		if(tempquery.getTotal()>0){
			result.setRes(SystemCode.FAILURE);
			result.setMsg("商品分类下有商品，无法删除");
			return result;
		}
		
		try {
			productCategoryService.updateByPrimaryKeySelective(productcategory);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request,"[admin:"+admin.getAdminName()+",删除商品分类异常]", e);
			result.setRes(SystemCode.FAILURE);
			result.setMsg("删除商品分类异常");
		}
		
		return result;
	}

}
