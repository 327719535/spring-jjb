package com.techec.dao.mall.shortMsg;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.shortMsg.ShortMessageModel;
import org.apache.ibatis.annotations.Param;


public interface IShortMessageDao extends IBaseDao<ShortMessageModel> {
	ShortMessageModel getCodeByPhone(@Param("phone") String phone);
}