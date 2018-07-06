package com.techec.service.mall.goodsprice.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.goodsprice.GoodsPriceMapper;
import com.techec.entity.mall.goodsprice.GoodsPrice;
import com.techec.service.mall.goodsprice.IGoodsPriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 商品规格服务实现类
 */
@Service
public class GoodsPriceServiceImpl extends BaseServiceImpl<GoodsPrice>
		implements IGoodsPriceService {
	@Resource
	private GoodsPriceMapper goodsPriceMapper;

	@Override
	public GoodsPrice findGoodsPriceByPriceIdAndState(int priceId, Byte state) {
		return goodsPriceMapper.findGoodsPriceByPriceIdAndState(priceId, state);
	}

	@Override
	public List<GoodsPrice> findAllByGoodsIdAndNotState(int goodsId,
			Byte notState) {
		return goodsPriceMapper.findAllByGoodsIdAndNotState(goodsId, notState);
	}

	@Override
	public List<GoodsPrice> findAllNormalGoodsPriceByGoodsId(int goodsId) {
		return goodsPriceMapper.findAllByGoodsIdAndNotState(goodsId, (byte) 2);
	}

	@Override
	public GoodsPrice findNormalGoodsPriceByPriceId(int priceId) {
		return goodsPriceMapper.findGoodsPriceByPriceIdAndState(priceId,
				(byte) 1);
	}

	@Override
	protected IBaseDao<GoodsPrice> getMapper() {
		return goodsPriceMapper;
	}

}
