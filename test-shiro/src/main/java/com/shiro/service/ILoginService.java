package com.shiro.service;

import com.shiro.domain.Role;
import com.shiro.domain.User;

import java.util.HashMap;

/**
 * @author: jiangyong
 * @date: 2019/1/10 14:32
 * @version:
 * @Copyright:
 * @modifier:
 */
public interface ILoginService {
    //添加用户
    User addUser(HashMap<String, Object> map);

    //添加角色
    Role addRole(HashMap<String, Object> map);

    //查询用户通过用户名
    User findByName(String name);
}
