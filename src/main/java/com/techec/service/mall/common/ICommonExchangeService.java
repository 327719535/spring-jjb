package com.techec.service.mall.common;

import com.techec.entity.mall.goodsprice.GoodsPrice;
import com.techec.entity.mall.shoppingcart.ShoppingCart;
import com.techec.entity.mall.shoppingcart.ShoppingCartDetailVO;
import com.techec.entity.personal.User;
import com.techec.vo.common.TotalPriveAndCategory;

import java.util.List;

public interface ICommonExchangeService {
	/**
	 * 依据用户权限，获取换算后的销售价格和购物车中的条目数； 显示的实际价放在零售价字段里（依据用户不同价格不一样），购物车中的数量放在批发价字段里
	 * 如果用户不存在，则不改变销售价，购物车中数量改为0
	 * 
	 * @param user
	 *            当前用户，
	 * @param listGoodsPrice
	 *            规格列表
	 * @return
	 */
    List<GoodsPrice> getCurrentUserGoodsprice(User user,
                                              List<GoodsPrice> listGoodsPrice);

	/**
	 * 依据用户id和购物车条目，获取换算后的总金额; 如果用户不存在，则返回0; 该方法不要频繁调用
	 * 
	 * @param user
	 *            当前用户
	 * @param listShoppingCart
	 *            购物条目
	 * @return
	 */
    TotalPriveAndCategory getCurrentUserTotalPrice(User user,
                                                   List<ShoppingCart> listShoppingCart);
	
	/**
	 * 依据用户权限，获取换算后的销售价格； 显示的实际价放在零售价字段里（依据用户不同价格不一样）
	 * 如果用户不存在，则不改变销售价
	 * 
	 * @param user
	 *            当前用户，
	 * @param listShoppingCartDetailVO
	 *            购物车条目VO，用于勾选
	 * @return
	 */
    List<ShoppingCartDetailVO> getCurrentUserGoodspriceForShoppingCartDetailVO(User user,
                                                                               List<ShoppingCartDetailVO> listShoppingCartDetailVO);

}
