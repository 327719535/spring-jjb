package com.techec.service.mall.message.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.message.IUserMessageMapper;
import com.techec.dao.personal.UserMapper;
import com.techec.entity.mall.message.UserMessage;
import com.techec.service.mall.message.IUserMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserMessageServiceImpl extends BaseServiceImpl<UserMessage> implements IUserMessageService {
@Resource
private IUserMessageMapper userMessageMapper;
@Resource
private UserMapper frontUserMapper;
	@Override
	protected IBaseDao<UserMessage> getMapper() {
		return userMessageMapper;
	}
	@Override
	public int addMessageRecord(Integer messageId,String userIds){
		//List<Integer> userIdList=usserDao.getAllFrontUser();
		String[] userIdList=userIds.split(",");
		List<UserMessage> list=new ArrayList<UserMessage>();
		for(String userId:userIdList){
			UserMessage userMessageModel=new UserMessage();
			userMessageModel.setUserId(Integer.valueOf(userId));
			userMessageModel.setMessageId(messageId);
			userMessageModel.setCreateTime(new Date());
			userMessageModel.setUpdateTime(new Date());
			list.add(userMessageModel);
		}
		return userMessageMapper.addMessageRecord(list);
	}
	@Override
	public int getNoReadCount(int userId) {
		return userMessageMapper.getNoReadCount(userId);
	}
	@Override
	public List<Integer> getMessageCount(int userId) {
		return userMessageMapper.getMessageCount(userId);
	}
	@Override
	public UserMessage getOneById(Integer userMessageId) {
		return userMessageMapper.getOneById(userMessageId);
	}
	
	
}
