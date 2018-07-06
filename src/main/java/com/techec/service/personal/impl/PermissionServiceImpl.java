package com.techec.service.personal.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.personal.PermissionMapper;
import com.techec.entity.personal.Permission;
import com.techec.service.personal.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {
    @Resource
    PermissionMapper permissionMapper;
    @Override
    protected IBaseDao<Permission> getMapper() {
        return null;
    }

    @Override
    public List<Permission> selectByIdKey(String id) {
        return permissionMapper.selectByIdKey(id);
    }
}
