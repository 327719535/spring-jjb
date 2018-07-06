package com.techec.service.mall.article;


import com.techec.common.base.IBaseService;
import com.techec.entity.mall.article.Article;

public interface IArticleService  extends IBaseService<Article> {
	int writeArticle(Article article) throws Exception;
	int editArticle(Article article) throws Exception;
}
