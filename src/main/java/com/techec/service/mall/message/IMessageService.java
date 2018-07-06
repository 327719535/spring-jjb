package com.techec.service.mall.message;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.message.Message;

import java.util.List;


public interface IMessageService extends IBaseService<Message> {

	/**
	 * @param limit 获取最新limit条数据
	 * @param integer 
	 * @return 获取最新动态的消息
	 */
    List<Message> getMessageLevel(Integer integer);
}
