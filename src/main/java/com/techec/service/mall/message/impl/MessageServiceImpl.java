package com.techec.service.mall.message.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.message.IMessageMapper;
import com.techec.entity.mall.message.Message;
import com.techec.service.mall.message.IMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements IMessageService {
	@Resource
	private IMessageMapper messageMapper;
	@Override
	protected IBaseDao<Message> getMapper() {
		return messageMapper;
	}
	@Override
	public List<Message> getMessageLevel(Integer userId) {
		return messageMapper.getMessageLevel(userId);
	}

}
