package com.techec.controller.mall.admin.admin;


import com.constant.SystemCode;
import com.techec.controller.mall.AbstractController;
import com.techec.entity.mall.admin.Admin;
import com.techec.service.mall.admin.IAdminService;
import com.util.Encryp.MD5Util;
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
 *
 *
 *  管理员 管理模块 后台
 */
@Controller
@RequestMapping("/admin/admin/adminUser")
public class AdminUserAdminController extends AbstractController {
	@Resource
	private IAdminService adminService;

	/**
	 * 管理员列表
	 */
	@ResponseBody
	@RequestMapping("/getAdminByPage")
	public JsonResponse<PageResult<Admin>> getAdminByPage(PageResult<Admin> page, Admin admin,
                                                          HttpServletRequest request) {
		JsonResponse<PageResult<Admin>> result = new JsonResponse<PageResult<Admin>>();
		adminService.queryByPage(page, admin);
		if (page.getTotal() != 0) {
			result.setRes(SystemCode.SUCCESS);
			result.setObj(page);
		} else {
			result.setRes(SystemCode.FAILURE);
		}
		return result;
	}

	/**
	 * 添加管理员
	 */
	@ResponseBody
	@RequestMapping("/addAdmin")
	public JsonResponse<String> addAdmin(Admin admin, HttpServletRequest request) {
		JsonResponse<String> result = new JsonResponse<String>();
		try {
			String rand = MD5Util.getRand();
			String password = MD5Util.encoder(admin.getPassword(), rand);
			admin.setRand(rand);
			admin.setPassword(password);
			Date now = new Date();
			admin.setCreateTime(now);
			admin.setUpdateTime(now);
			int count = adminService.getCountByAdminName(admin.getAdminName());
			if (count != 0) {
				result.setRes(SystemCode.USER_EXISTS);
				return result;
			}
			adminService.insertSelective(admin);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {

			result.setRes(SystemCode.FAILURE);
		}
		return result;
	}

	/**
	 * 用户名是否存在
	 */
	@ResponseBody
	@RequestMapping("/adminNameIsExit")
	public JsonResponse<String> adminNameIsExit(HttpServletRequest request, Admin admin) {
		JsonResponse<String> result = new JsonResponse<String>(SystemCode.FAILURE);
		int count = adminService.getCountByAdminName(admin.getAdminName());
		if (count != 0) {
			result.setRes(SystemCode.USER_EXISTS);
			return result;
		}
		return result;
	}

	/**
	 * 编辑管理员
	 */
	@ResponseBody
	@RequestMapping("/editAdmin")
	public JsonResponse<Admin> editAdmin(HttpServletRequest request, Admin admin) {
		JsonResponse<Admin> result = new JsonResponse<Admin>(SystemCode.FAILURE);
		try {
			adminService.updateByPrimaryKeySelective(admin);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {

			result.setRes(SystemCode.OBJ_EXISTS);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/delAdminById")
	public JsonResponse<Admin> delAdminById(Admin admin, HttpServletRequest request) {
		JsonResponse<Admin> result = new JsonResponse<Admin>();
		Admin loginAdmin = SessionUtil.getAdminUser(request);
		try {
			admin.setDelState((byte) 1);
			admin.setUpdateTime(new Date());
			adminService.updateByPrimaryKeySelective(admin);
			
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {

			result.setRes(SystemCode.FAILURE);
		}

		return result;
	}

	/**
	 * 
	 * @param request
	 * @return 获取管理员信息
	 */
	@ResponseBody
	@RequestMapping("/getAdminInfo")
	public JsonResponse<Admin> getAdminInfo(Integer adminId, HttpServletRequest request) {
		JsonResponse<Admin> result = new JsonResponse<Admin>();
		Admin admin = adminService.selectByPrimaryKey(adminId);
		result.setRes(SystemCode.SUCCESS);
		result.setObj(admin);
		return result;
	}

	/**
	 * 
	 * @param newPassword
	 * @param
	 * @return 管理员 修改密码
	 */
	@ResponseBody
	@RequestMapping("/resetPasswordByAdminId")
	public JsonResponse<String> resetPasswordByAdminId(String newPassword, Integer adminId) {
		JsonResponse<String> result = new JsonResponse<String>();
		Admin admin = new Admin();
		String rand = MD5Util.getRand();
		String password = MD5Util.encoder(newPassword, rand);
		admin.setRand(rand);
		admin.setPassword(password);
		admin.setUpdateTime(new Date());
		admin.setAdminId(adminId);
		try {
			adminService.updateByPrimaryKeySelective(admin);
			result.setRes(SystemCode.SUCCESS);
		} catch (Exception e) {

			result.setRes(SystemCode.FAILURE);
		}

		return result;
	}

}
