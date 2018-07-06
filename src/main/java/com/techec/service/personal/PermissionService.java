package com.techec.service.personal;

import com.techec.common.base.IBaseService;
import com.techec.entity.personal.Permission;

import java.util.List;

public interface PermissionService extends IBaseService<Permission> {

    List<Permission> selectByIdKey(String id);
}
