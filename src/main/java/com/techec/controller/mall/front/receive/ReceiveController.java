package com.techec.controller.mall.front.receive;


import com.constant.SystemCode;
import com.techec.controller.mall.AbstractController;
import com.techec.entity.mall.receive.Receive;
import com.techec.entity.personal.User;
import com.techec.service.mall.receive.IReceiveService;
import com.util.JsonResponse;
import com.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/front/receive/receive")
public class ReceiveController extends AbstractController {
	@Resource
	private IReceiveService receiveService;
	/**
	 * 添加送货地址
	 */
	@ResponseBody
	@RequestMapping("/addReceive")
	public JsonResponse<Receive> addReceive(Receive receive,
											HttpServletRequest request) {
		JsonResponse<Receive> result = new JsonResponse<Receive>(
				SystemCode.FAILURE);
		User user = SessionUtil.getUser(request);
		receive.setCreateTime(new Date());
		receive.setUpdateTime(new Date());
		receive.setUserId(user.getUserId());
		receive.setIsDefault((byte) 1);
		try {
			receiveService.addReceive(receive, user);
			result.setObj(receive);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request, "[User:" + user.getNickname() + ",新增送货地址异常]", e);
		}
		return result;
	}

	/**
	 * 编辑送货地址
	 */
	@ResponseBody
	@RequestMapping("/editReceive")
	public JsonResponse<Receive> editReceive(Receive receive,
			HttpServletRequest request) {
		JsonResponse<Receive> result = new JsonResponse<Receive>(
				SystemCode.FAILURE);
		User user = SessionUtil.getUser(request);
		receive.setUpdateTime(new Date());
		receive.setUserId(user.getUserId());
		try {
			receiveService.updateByPrimaryKeySelective(receive);
			result.setObj(receive);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request, "[User:" + user.getNickname() + ",编辑送货地址异常]", e);
		}

		return result;
	}

	/**
	 * 收货地址列表
	 */
	@ResponseBody
	@RequestMapping("/getReceiveByPage")
	public JsonResponse<List<Receive>> getReceiveByPage(
			HttpServletRequest request) {
		JsonResponse<List<Receive>> result = new JsonResponse<List<Receive>>(
				SystemCode.FAILURE);
		User user = SessionUtil.getUser(request);
		// receive.setOpenid(User.getOpenid());
		List<Receive> receive=receiveService.queryReceive(user);
		result.setRes(SystemCode.SUCCESS);
		result.setObj(receive);
		return result;
	}

	/**
	 * 设置默认收货地址
	 */
	@ResponseBody
	@RequestMapping("/setDefaultReceive")
	public JsonResponse<String> setDefaultReceive(Integer receiveId,
												  HttpServletRequest request) {
		JsonResponse<String> result = new JsonResponse<String>(
				SystemCode.SET_DEFAULTRECEIVE_FAILURE);
		User user = SessionUtil.getUser(request);
		try {
			Receive receive = receiveService.queryDefaultReceive(user);
			receiveService.setDefaultReceive(receive, receiveId);	
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request, "[User:" + user.getNickname() + ",用户修改默认地址异常]", e);
		}
		return result;
	}

	/**
	 * 获取默认收货地址
	 */
	@ResponseBody
	@RequestMapping("/queryDefaultReceive")
	public JsonResponse<Receive> queryDefaultReceive(
			HttpServletRequest request, Integer receiveId) {
		JsonResponse<Receive> result = new JsonResponse<Receive>(
				SystemCode.FAILURE);
		User user = SessionUtil.getUser(request);
		if (null == user) {
			result.setRes(SystemCode.FAILURE);
			return result;
		}
		Receive receive = receiveService.queryDefaultReceive(user);
		result.setRes(SystemCode.SUCCESS);
		result.setObj(receive);
		return result;
	}

	/**
	 * 查看收货地址
	 */
	@ResponseBody
	@RequestMapping("/getReceiveById")
	public JsonResponse<Receive> getReceiveById(HttpServletRequest request,
			Integer receiveId) {
		JsonResponse<Receive> result = new JsonResponse<Receive>(
				SystemCode.FAILURE);
		Receive receive = receiveService.selectByPrimaryKey(receiveId);
		result.setRes(SystemCode.SUCCESS);
		result.setObj(receive);
		return result;
	}

	/**
	 * 删除收货地址
	 */
	@ResponseBody
	@RequestMapping("/delReceiveById")
	public JsonResponse<Receive> delReceiveById(Receive receive,
			HttpServletRequest request) {
		JsonResponse<Receive> result = new JsonResponse<Receive>(
				SystemCode.FAILURE);
		User user = SessionUtil.getUser(request);
		// receive.setOpenid(User.getOpenid());
		receive.setDelState((byte) 1);
		receive.setUpdateTime(new Date());
		try {
			receiveService.updateByPrimaryKeySelective(receive);
			// 删除收货地址时，判断用户有没有默认地址，如果有要删除的收货地址，则要关联删除用户表的收货地址
			// if(User.getDefaultReceiveId() == receive.getReceiveId()) {
			// User.setDefaultReceiveId(null);
			// User.setUpdateTime(new Date());
			// System.out.println(User.getOpenid()+":"+User.getUserId());
			// UserMapper.updateByPrimaryKeySelective(User);
			// }
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request, "[User:" + user.getNickname() + ",删除收货地址]", e);
		}

		return result;
	}
}
