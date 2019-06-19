package com.lz.myboot.service;

import com.lz.myboot.common.model.Account;
import com.lz.myboot.common.model.Role;

import java.util.List;

public interface ILoginService {
    public Account findByName(String name) ;

    List<Role> findRolesByAccountId(Integer id);
}
