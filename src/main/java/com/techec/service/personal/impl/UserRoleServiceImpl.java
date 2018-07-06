package com.techec.service.personal.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.entity.personal.UserRole;
import com.techec.service.personal.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {
    @Override
    protected IBaseDao<UserRole> getMapper() {
        return null;
    }
}
