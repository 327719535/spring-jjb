package com.techec.dao.mall.receive;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.receive.Receive;

import java.util.List;


public interface ReceiveMapper extends IBaseDao<Receive> {
	Receive selectUserReceive(String openid);
	
	Receive selectDefaultReceive(int userId);
	List<Receive> selectReceive(int userId);
}