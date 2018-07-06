package com.techec.service.mall.article.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.article.ArticleMapper;
import com.techec.entity.mall.article.Article;
import com.techec.service.mall.article.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements IArticleService {

	@Resource
	private ArticleMapper articleMapper;

	@Override
	protected IBaseDao<Article> getMapper() {
		return articleMapper;
	}

	@Override
	public int writeArticle(Article article) throws Exception {
		return articleMapper.insertSelective(article);
	}

	@Override
	public int editArticle(Article article) throws Exception {
		articleMapper.updateByPrimaryKey(article);
		return 0;
	}

}
