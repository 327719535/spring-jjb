package com.techec.controller.mall.admin.logistics;

import com.constant.SystemCode;
import com.techec.controller.mall.AbstractController;
import com.techec.entity.mall.admin.Admin;
import com.techec.entity.mall.logistics.Logistics;
import com.techec.service.mall.logistics.ILogisticsService;
import com.util.JsonResponse;
import com.util.PageResult;
import com.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *
 *  配送管理模块 后台
 */
@Controller
@RequestMapping("/admin/logistics/logisticsAdmin")
public class LogisticsAdminController extends AbstractController {
	
	@Resource
	private ILogisticsService logisticsService;
	
	/**
	 * 添加配送
	 */
	@ResponseBody
	@RequestMapping("/addLogistics")
	public JsonResponse<Logistics> addLogistics(Logistics logistics, HttpServletRequest request) {
		JsonResponse<Logistics> result = new JsonResponse<Logistics>(SystemCode.FAILURE);
		Admin admin = SessionUtil.getAdminUser(request);
		logistics.setAdminId(admin.getAdminId());
		logistics.setCreateTime(new Date());
		logistics.setUpdateTime(new Date());
		
		try {
			logisticsService.insertSelective(logistics);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request,"[admin:"+admin.getAdminName()+",新增配送异常]", e);
		}
		return result;
	}
	
	/**
	 * 编辑配送
	 */
	@ResponseBody
	@RequestMapping("/editLogistics")
	public JsonResponse<Logistics> editLogistics(Logistics logistics,HttpServletRequest request) {
		JsonResponse<Logistics> result = new JsonResponse<Logistics>(SystemCode.FAILURE);
		Admin admin = SessionUtil.getAdminUser(request);
		logistics.setAdminId(admin.getAdminId());
		logistics.setUpdateTime(new Date());
		
		try {
			logisticsService.updateByPrimaryKeySelective(logistics);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request,"[admin:"+admin.getAdminName()+",编辑配送异常]", e);
		}
		
		return result;
	}
	
	
	/**
	 * 配送列表
	 */
	@ResponseBody
	@RequestMapping("/getLogisticsByPage")
	public JsonResponse<PageResult<Logistics>> getLogisticsByPage(PageResult<Logistics> page, Logistics logistics, HttpServletRequest request) {
		JsonResponse<PageResult<Logistics>> result = new JsonResponse<PageResult<Logistics>> (SystemCode.FAILURE);
		logisticsService.queryByPage(page, logistics);
		if(page.getTotal()!=0){
			result.setRes(SystemCode.SUCCESS);
			result.setObj(page);
		}
		return result;
	}
	
	/**
	 * 删除配送
	 */
	@ResponseBody
	@RequestMapping("/delLogisticsById")
	public JsonResponse<Logistics> delLogisticsById(Logistics logistics,HttpServletRequest request) {
		JsonResponse<Logistics> result = new JsonResponse<Logistics>(SystemCode.FAILURE);
		Admin admin = SessionUtil.getAdminUser(request);
		logistics.setAdminId(admin.getAdminId());
		logistics.setDelState((byte)1);
		logistics.setUpdateTime(new Date());
		try {
			logisticsService.updateByPrimaryKeySelective(logistics);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {
			logError(request,"[admin:"+admin.getAdminName()+",删除配送异常]", e);
		}
		
		return result;
	}
	
	/**
	 * 查找配送
	 */
	@ResponseBody
	@RequestMapping("/getLogisticsById")
	public JsonResponse<Logistics> getLogisticsById(Integer logisticsId,HttpServletRequest request) {
		JsonResponse<Logistics> result = new JsonResponse<Logistics>(SystemCode.FAILURE);
		Logistics logistics  = logisticsService.selectByPrimaryKey(logisticsId);
		if(logistics != null) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(logistics);
		}
		return result;
	}

}
