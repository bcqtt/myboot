package com.lz.myboot.service.impl;

import com.lz.myboot.common.dao.AccountMapper;
import com.lz.myboot.common.model.Account;
import com.lz.myboot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccount() {
        Account account = accountMapper.selectByPrimaryKey(1);
        return account;
    }
}
