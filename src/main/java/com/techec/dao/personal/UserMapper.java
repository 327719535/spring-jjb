package com.techec.dao.personal;

import com.techec.common.model.IBaseDao;
import com.techec.entity.mall.user.UserVo;
import com.techec.entity.personal.User;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface UserMapper extends IBaseDao<User> {

    User selectByPrimaryKey(Integer userId);

    User getOneByOpenid(String openid);

    User getOneByPhone(String phone);

    int updatePhone(@Param("phone") String phone, @Param("openid") String openid);

    int getCountByPhone(String phone);

    String getAllFrontUser();

    List<User> getUsersByPage(String userIds);

    List <User> queryUserByPage(UserVo entity);

    User selectByUsername(String username);
}