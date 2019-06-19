package com.lz.myboot.service.impl;

import com.lz.myboot.common.dao.AccountMapper;
import com.lz.myboot.common.dao.RoleMapper;
import com.lz.myboot.common.model.Account;
import com.lz.myboot.common.model.Role;
import com.lz.myboot.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RoleMapper roleMapper;

/*    //添加用户
    @Override
    public User addUser(Map<String, Object> map) {
        User user = new User();
        user.setName(map.get("username").toString());
        user.setPassword(Integer.valueOf(map.get("password").toString()));
        userRepository.save(user);
        return user;
    }*/

   /* //添加角色
    @Override
    public Role addRole(Map<String, Object> map) {
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
    }*/

    //查询用户通过用户名
    @Override
    public Account findByName(String name) {
        return accountMapper.findByName(name);
    }

    @Override
    public List<Role> findRolesByAccountId(Integer id) {
        return roleMapper.findRolesByAccountId(id);
    }
}