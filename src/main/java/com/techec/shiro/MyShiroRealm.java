package com.techec.shiro;

import com.techec.entity.personal.Permission;
import com.techec.entity.personal.User;
import com.techec.service.mall.user.impl.UserServiceImpl;
import com.techec.service.personal.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private PermissionService permissionService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();//User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
        List<Permission> resourcesList = permissionService.selectByIdKey(user.getUserId().toString());
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Permission resources: resourcesList) {
            info.addStringPermission(resources.getUrl());
        }
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        //-------------------------------------------------需要修改
        User user = userService.getOneByOpenid(username);//selectByUsername(username);
        if (user == null) throw new UnknownAccountException();
        /*if (0 == User.getEnable()) {
            throw new LockedAccountException(); // 帐号锁定
        }*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户
                user.getPswd(), //密码
                ByteSource.Util.bytes(username),
                getName()  //realm name
        );
        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", user);
        session.setAttribute("userSessionId", user.getUserId());
        return authenticationInfo;
    }

}