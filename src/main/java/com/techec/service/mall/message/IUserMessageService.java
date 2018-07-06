package com.techec.service.mall.message;

import com.techec.common.base.IBaseService;
import com.techec.entity.mall.message.UserMessage;

import java.util.List;

public interface IUserMessageService extends IBaseService<UserMessage> {
	int addMessageRecord(Integer messageId, String userIdList);

	/**
	 * 
	 * @param userId
	 *            前端用户id
	 * @return 获取用户 消息未读数
	 */
    int getNoReadCount(int userId);

	/**
	 * 
	 * @param userId
	 * @return 获取消息已读数和未读数
	 */
    List<Integer> getMessageCount(int userId);

	UserMessage getOneById(Integer userMessageId);
}
