package com.shiro.service;

import com.shiro.domain.Permission;
import com.shiro.domain.Role;
import com.shiro.domain.User;
import com.shiro.repository.RoleRepository;
import com.shiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: jiangyong
 * @date: 2019/1/10 14:23
 * @version:
 * @Copyright:
 * @modifier:
 */
@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //添加用户
    @Override
    public User addUser(HashMap<String, Object> map) {
        User user = new User();
        user.setName(map.get("username").toString());
        user.setPassword(Integer.valueOf(map.get("password").toString()));
        userRepository.save(user);
        return user;
    }

    //添加角色
    @Override
    public Role addRole(HashMap<String, Object> map) {
        User user = userRepository.findOne(Long.valueOf(map.get("userId").toString()));
        Role role = new Role();
        role.setRoleName(map.get("roleName").toString());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setPermission("create");
        permission1.setRole(role);
        Permission permission2 = new Permission();
        permission2.setPermission("update");
        permission2.setRole(role);
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
        roleRepository.save(role);
        return role;
    }

    //查询用户通过用户名
    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
