package com.techec.controller.mall.front.logistics;

import com.constant.SystemCode;
import com.techec.controller.mall.AbstractController;
import com.techec.entity.mall.logistics.Logistics;
import com.techec.service.mall.logistics.ILogisticsService;
import com.util.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 *
 *
 *
 *  配送管理模块  前端
 */
@Controller
@RequestMapping("/front/logistics/logistic")
public class LogisticsController extends AbstractController {
	
	@Resource
	private ILogisticsService logisticsService;
	
	/**
	 * @param request
	 * @return 查看配送列表
	 */
	@ResponseBody 
	@RequestMapping("/getListLogistics")
	public JsonResponse<Logistics> getListLogistics(HttpServletRequest request) {
		JsonResponse<Logistics> result = new JsonResponse<Logistics> (SystemCode.FAILURE);
		List<Logistics> listLogistics = logisticsService.getListLogistics();
		if(!listLogistics.isEmpty()) {
			result.setList(listLogistics);
			result.setRes(SystemCode.SUCCESS);
		}
		return result;
	}

}
