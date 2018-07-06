package com.techec.service.mall.shoppingcart;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.shoppingcart.ShoppingCart;
import com.techec.entity.mall.shoppingcart.ShoppingCartDetailVO;
import com.techec.entity.mall.shoppingcart.ShoppingCartVo;
import com.techec.entity.personal.User;
import com.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;



/**
 * 购物车条目接口
 */
public interface IShoppingCartService extends IBaseService<ShoppingCart> {
	/**
	 * 依据用户id和规格id，查询购物条目
	 * 
	 * @param shoppingCart
	 * @return
	 */
    ShoppingCart queryShoppingCartByUserIdAndPriceId(ShoppingCart shoppingCart);

	/**
	 * 依据用户id和商品id，查询用户买了多少种类商品
	 * 
	 * @param shoppingCart
	 * @return
	 */
    int queryCountGoodsByUserIdAndGoodsId(ShoppingCart shoppingCart);

	/**
	 * 依据用户id，查询所有准备购买的购物条目
	 * 
	 * @param
	 * @return
	 */
    List<ShoppingCart> queryAllBuyShoppingCartByUserId(int userId);

	/**
	 * 依据用户id，查询购物车中的所有购物条目
	 * 
	 * @param
	 * @return
	 */
    List<ShoppingCart> queryAllShoppingCartByUserId(int userId);

	/**
	 * 依据用户id，删除所有准备购买的购物条目
	 * 
	 * @param
	 * @return
	 */
    int delAllBuyShoppingCartByUserId(int userId);
	
	/**
	 * 依据用户id，删除所有购物条目
	 * 
	 * @param
	 * @return
	 */
    int delAllShoppingCartByUserId(int userId);
	
	/**
	 * 依据用户id,规格id，删除购物条目
	 * 
	 * @param
	 * @return
	 */

    int delAllShoppingCartByUserIdAndPriceIds(int userId, String priceIds);
	

	/**
	 * 查询当前用户的购买的商品信息
	 * 
	 * @param user
	 * @return
	 */
	ShoppingCartVo queryShoppingCartInfo(User user);

	
	/**
	 * 依据用户id，查询购物车勾选VO
	 * @param userId 用户id
	 * @return
	 */
    PageResult<ShoppingCartDetailVO> queryShoppingCartDetailVOByUserId(@Param("t") PageResult<ShoppingCartDetailVO> t, @Param("userId") int userId);

	/**
	 * 依据shoppingCart.userId,将该用户的所有购物规格条目状态置为shoppingCart.isBuy
	 * @param shoppingCart 有用的参数是userId和isBuy
	 * @return
	 */
    int updateAllIsBuyStateByUserIdAndisBuyValue(ShoppingCart shoppingCart);
}
