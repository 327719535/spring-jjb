package com.techec.service.mall.shortMsg;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.shortMsg.ShortMessageModel;
import com.util.JsonResponse;

import javax.servlet.http.HttpServletRequest;


public interface IShortMessageService extends IBaseService<ShortMessageModel> {
	ShortMessageModel getCodeByPhone(String phone);
	
	JsonResponse<String> sendMessage(HttpServletRequest request, String phone);
	JsonResponse<String> checkCode(String phone, Integer code);
}