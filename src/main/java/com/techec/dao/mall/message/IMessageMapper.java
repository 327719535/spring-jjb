package com.techec.dao.mall.message;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.message.Message;

import java.util.List;

public interface IMessageMapper  extends IBaseDao<Message> {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> getMessageLevel(Integer userId);
}