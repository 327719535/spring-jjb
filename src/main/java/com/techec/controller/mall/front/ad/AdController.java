package com.techec.controller.mall.front.ad;

import com.constant.SystemCode;
import com.techec.controller.mall.AbstractController;
import com.techec.entity.mall.ad.Ad;
import com.techec.service.mall.ad.IAdService;
import com.util.JsonResponse;
import com.util.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/front/ad/ad")
public class AdController extends AbstractController {
	@Resource
	private IAdService adService;

	@ResponseBody
	@RequestMapping("/getAdByPage")
	public JsonResponse<PageResult<Ad>> getAdByPage(PageResult<Ad> page, Ad ad,
													HttpServletRequest request) {
		JsonResponse<PageResult<Ad>> result = new JsonResponse<PageResult<Ad>>();
		adService.queryByPageFront(page, ad);
		if (page.getTotal() != 0) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(page);
		} else {
			result.setRes(SystemCode.FAILURE);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/queryAdByAdId")
	public JsonResponse<Ad> queryAdByAdId(Integer adId, HttpServletRequest request) {
		JsonResponse<Ad> result = new JsonResponse<Ad>();
		try {
			Ad ad = adService.selectByPrimaryKey(adId);
			result.setRes(SystemCode.SUCCESS);
			result.setObj(ad);
		} catch (Exception e) {
			result.setRes(SystemCode.FAILURE);
		}
		
		return result;
	}
}
