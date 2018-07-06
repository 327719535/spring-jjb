package com.techec.service.mall.module.impl;

import com.techec.common.base.impl.BaseServiceImpl;
import com.techec.common.model.IBaseDao;
import com.techec.dao.mall.module.ModuleMapper;
import com.techec.entity.mall.module.Module;
import com.techec.service.mall.module.IModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统模块服务接口实现
 */
@Service
public class ModuleServiceImpl extends BaseServiceImpl<Module> implements IModuleService {
	@Resource
	private ModuleMapper moduleMapper;

	@Override
	protected IBaseDao<Module> getMapper() {
		return this.moduleMapper;
	}

	@Override
	public List<Module> queryAllValidModule() {
		Module module = new Module();
		module.setState((byte) 1);
		return moduleMapper.getAllBySelect(module);
	}

	@Override
	public List<Module> queryRoleModule(int roleId) {
		return moduleMapper.selectByRoleId(roleId);

	}

	@Override
	public List<Module> queryModulesByAdminId(int adminId) {
		return moduleMapper.queryModulesByAdminId(adminId);
	}

}
