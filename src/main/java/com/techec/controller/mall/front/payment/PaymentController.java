package com.techec.controller.mall.front.payment;

import com.constant.SystemCode;
import com.techec.controller.mall.AbstractController;
import com.techec.entity.mall.payment.Payment;
import com.techec.entity.personal.User;
import com.techec.service.mall.payment.IPaymentService;
import com.util.JsonResponse;
import com.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;



/**
 * 获取付款方式控制器
 *
 */
@Controller
@RequestMapping("/front/payment/payment")
public class PaymentController extends AbstractController {
	@Resource
	private IPaymentService paymentService;

	@ResponseBody
	@RequestMapping("/queryUserPayment")
	public JsonResponse<List<Payment>> queryUserPayment(HttpServletRequest request) {
		JsonResponse<List<Payment>> result = new JsonResponse<List<Payment>>(SystemCode.FAILURE);
		User user = SessionUtil.getUser(request);
		if(null == user){
			return result;
		} 
		List<Payment> paymentList = paymentService.queryUserPayment(user);
		if(null != paymentList){
			result.setRes(SystemCode.SUCCESS);
			result.setObj(paymentList);
		}
		return result;
	}
}
