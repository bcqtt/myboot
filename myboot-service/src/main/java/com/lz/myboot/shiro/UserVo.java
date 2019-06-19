package com.lz.myboot.shiro;

import com.lz.myboot.common.model.Account;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserVo extends Account {

    private Set<String> roles = new HashSet<>();    //用户所有角色值，用于shiro做角色权限的判断
    private Set<String> perms = new HashSet<>();    //用户所有权限值，用于shiro做资源权限的判断
}
