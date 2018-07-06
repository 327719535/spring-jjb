package com.techec.dao.personal;

import com.techec.common.model.IBaseDao;
import com.techec.entity.personal.Permission;

import java.util.List;

public interface PermissionMapper extends IBaseDao<Permission> {
    int deleteByPrimaryKey(String id);

    Permission selectByPrimaryKey(String id);

    List<Permission> selectByIdKey(String id);
}