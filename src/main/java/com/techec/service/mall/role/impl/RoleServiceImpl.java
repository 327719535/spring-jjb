package com.techec.service.mall.role.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.role.RoleMapper;
import com.techec.dao.mall.roleModule.RoleModuleMapper;
import com.techec.entity.mall.role.Role;
import com.techec.entity.mall.roleModule.RoleModule;
import com.techec.service.mall.role.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 管理员角色服务接口实现
 *
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RoleModuleMapper roleModuleMapper;

	@Override
	protected IBaseDao<Role> getMapper() {
		return this.roleMapper;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, noRollbackFor = { Exception.class })
	public void grantPowerToRole(Role role, List<RoleModule> moduleList) throws Exception {
		if (null != moduleList) {
			List<RoleModule> roleModuleFromDBs = roleModuleMapper.selectByRoleId(role.getRoleId());
			List<RoleModule> roleModuleInDBs = moduleList;

			List<RoleModule> roleModuleOutDBs = new ArrayList<RoleModule>();
			//boolean flag = false;
			if (null != roleModuleFromDBs && roleModuleFromDBs.size() > 0) {
				for (RoleModule roleModule : roleModuleFromDBs) {
					boolean flag = false;
					for (RoleModule module : moduleList) {
						if (roleModule.getModuleId() == module.getModuleId()) {
							flag = true;
						}
					}
					if (!flag) {
						roleModuleOutDBs.add(roleModule);
					}
				}
			}

			if (null != roleModuleOutDBs) {
				for (RoleModule roleModule : roleModuleOutDBs) {
					if (null != roleModule) {
						roleModuleMapper.delete(roleModule);
					}
				}
			}

			if (null != roleModuleInDBs && roleModuleInDBs.size() > 0) {
				Iterator<RoleModule> iterator = roleModuleInDBs.iterator();
				while (iterator.hasNext()) {
					RoleModule module = iterator.next();
					for (RoleModule roleModule : roleModuleFromDBs) {
						if (module.getModuleId() == roleModule.getModuleId()) {
							iterator.remove();
						}
					}
				}
			}

			if (null != roleModuleInDBs) {
				for (RoleModule roleModule : roleModuleInDBs) {
					if (null != roleModule) {
						roleModuleMapper.insertSelective(roleModule);
					}
				}
			}
		}
	}
}
