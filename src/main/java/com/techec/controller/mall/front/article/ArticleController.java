package com.techec.controller.mall.front.article;


import com.constant.SystemCode;
import com.techec.controller.mall.AbstractController;
import com.techec.entity.mall.article.Article;
import com.techec.service.mall.article.IArticleService;
import com.util.JsonResponse;
import com.util.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/front/article/article")
public class ArticleController extends AbstractController {
	@Resource
	private IArticleService articleService;
	/**
	 * 文章列表
	 */
	/**
	 * @param page
	 * @param article
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getArticleByPage")
	public JsonResponse<PageResult<Article>> getGoodsByPage(
			PageResult<Article> page, Article article, HttpServletRequest request) {
		JsonResponse<PageResult<Article>> result = new JsonResponse<PageResult<Article>>();
		articleService.queryByPageFront(page, article);
		if (page.getTotal() != 0) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(page);
		} else {
			result.setRes(SystemCode.FAILURE);
		}
		return result;
	}
	/**
	 * 文章详情
	 */
	/**
	 * @param articleId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getArticleById")
	public JsonResponse<Article> getGoodsById(Integer articleId,
											  HttpServletRequest request) {
		JsonResponse<Article> result = new JsonResponse<Article>();
		Article article = articleService.selectByPrimaryKey(articleId);
		if (article != null) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(article);
		}
		return result;
	}
}
