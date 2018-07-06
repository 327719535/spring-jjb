package com.techec.dao.mall.shoppingcart;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.shoppingcart.ShoppingCart;
import com.techec.entity.mall.shoppingcart.ShoppingCartDetailVO;
import com.techec.entity.mall.shoppingcart.ShoppingCartItem;

import java.util.List;

/**
 *
 * 购物车条目dao
 */
public interface ShoppingCartMapper extends IBaseDao<ShoppingCart> {
	/**
	 * 依据用户id和规格id，查询购物条目
	 * 
	 * @param shoppingCart
	 * @return
	 */
    ShoppingCart queryShoppingCartByUserIdAndPriceId(
            ShoppingCart shoppingCart);

	/**
	 * 依据用户id和商品id，查询用户买了多少种类商品
	 * 
	 * @param shoppingCart
	 * @return
	 */
    int queryCountGoodsByUserIdAndGoodsId(ShoppingCart shoppingCart);

	/**
	 * 依据用户id和非购买标志，查询所有购物条目
	 * 
	 * @param shoppingCart
	 * @return
	 */
    List<ShoppingCart> queryAllNotIsBuyShoppingCartByUserId(
            ShoppingCart shoppingCart);

	/**
	 * 依据用户id和非购买标志，删除所有相关数据
	 * 
	 * @param shoppingCart
	 * @return
	 */
    int delAllNotIsBuyShoppingCartByUserId(ShoppingCart shoppingCart);

	/**
	 * 依据用户id和规格id，删除所有相关数据
	 * 
	 * @param shoppingCart
	 * @return
	 */
    int delAllShoppingCartByUserIdAndPriceIds(int userId, String pricesId);

	/**
	 * 根据用户id查询所购买的购物车Item列表
	 * 
	 * @param userId
	 * @return
	 */
	List<ShoppingCartItem> queryBuyShopCartItemByUserId(int userId);

	/**
	 * 依据用户id，查询购物车勾选VO
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
    List<ShoppingCartDetailVO> queryShoppingCartDetailVOByUserId(
            int userId);

	/**
	 * 依据shoppingCart.userId,将该用户的所有购物规格条目状态置为shoppingCart.isBuy
	 * 
	 * @param shoppingCart
	 *            有用的参数是userId和isBuy
	 * @return
	 */
    int updateAllIsBuyStateByUserIdAndisBuyValue(
            ShoppingCart shoppingCart);
}