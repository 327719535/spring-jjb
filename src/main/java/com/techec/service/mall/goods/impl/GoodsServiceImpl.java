package com.techec.service.mall.goods.impl;

import com.github.pagehelper.PageHelper;
import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.goods.GoodsMapper;
import com.techec.entity.mall.goods.Goods;
import com.techec.entity.mall.goods.QueryGoodsAdminVO;
import com.techec.service.mall.goods.IGoodsService;
import com.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements IGoodsService {

	@Resource  
	private GoodsMapper goodsMapper;
	
	@Override
	protected IBaseDao<Goods> getMapper() {
		return goodsMapper;
	}

	@Override
	public List<Goods> getAllSelectGoods(String goodsIds) {
		return goodsMapper.getAllSelectGoods(goodsIds);
	}
	
	@Override
	public  Goods getOne(Goods goods){
		return goodsMapper.getOne(goods);
	}

	@Override
	public List<Goods> getPageFrontByGoodsCategory(Goods entity) {
		
		return goodsMapper.getPageFrontByGoodsCategory(entity);
	}

	@Override
	public PageResult<Goods> getPageFrontByGoodsCategory(PageResult<Goods> t,
														 Goods entity) {
		int pageNo=t.getPageNo();
    	int pageSize=t.getPageSize();
		pageNo = pageNo == 0?1:pageNo;
		pageSize = pageSize == 0?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); 
		return PageResult.toPageResult(goodsMapper.getPageFrontByGoodsCategory(entity),t);
	}
	
	@Override
	public PageResult<Goods> getPageFrontByGoodsName(PageResult<Goods> t,
			Goods entity) {
		int pageNo=t.getPageNo();
    	int pageSize=t.getPageSize();
		pageNo = pageNo == 0?1:pageNo;
		pageSize = pageSize == 0?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); 
		if(entity.getGoodsName()==null){
			entity.setGoodsName("");
		}
		entity.setGoodsName("%"+entity.getGoodsName()+"%");
		return PageResult.toPageResult(goodsMapper.getPageFrontByGoodsName(entity),t);
	}

	@Override
	public PageResult<Goods> getPageFrontByMyStoreGoods(PageResult<Goods> t,
			int userId) {
		int pageNo=t.getPageNo();
    	int pageSize=t.getPageSize();
		pageNo = pageNo == 0?1:pageNo;
		pageSize = pageSize == 0?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); 
		
		return PageResult.toPageResult(goodsMapper.getPageFrontByMyStoreGoods(userId),t);
	}

	@Override
	public PageResult<Goods> getPageByQueryGoodsAdminVO(PageResult<Goods> t,
			QueryGoodsAdminVO entity) {
		int pageNo=t.getPageNo();
    	int pageSize=t.getPageSize();
		pageNo = pageNo == 0?1:pageNo;
		pageSize = pageSize == 0?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); 
		if(entity !=null && entity.getGoodsName() !=null){
			entity.setGoodsName("%"+entity.getGoodsName()+"%");
		}		
		return PageResult.toPageResult(goodsMapper.getPageByQueryGoodsAdminVO(entity),t);
	}

	@Override
	public PageResult<Goods> getPageFrontRecommendAndIsMarketableGoods(
			PageResult<Goods> t) {
		int pageNo=t.getPageNo();
    	int pageSize=t.getPageSize();
		pageNo = pageNo == 0?1:pageNo;
		pageSize = pageSize == 0?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); 
		return PageResult.toPageResult(goodsMapper.getPageFrontRecommendAndIsMarketableGoods(),t);
	}
}
