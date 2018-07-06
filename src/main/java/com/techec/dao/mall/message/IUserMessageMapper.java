package com.techec.dao.mall.message;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.message.UserMessage;

import java.util.List;
import java.util.Map;


public interface IUserMessageMapper  extends IBaseDao<UserMessage> {
    int deleteByPrimaryKey(Integer userMessageId);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    UserMessage selectByPrimaryKey(Integer userMessageId);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
    
    int addMessageRecord(List<UserMessage> list);
	int getNoReadCount(int userId);
	/**
	 * 
	 * @param userId
	 * @return 获取消息已读数和未读数
	 */
    List<Integer> getMessageCount(int userId);
	List<Map<String,Object>> getUserListByMessageId(Integer messageId);
	
	UserMessage getOneById(Integer userMessageId);
}