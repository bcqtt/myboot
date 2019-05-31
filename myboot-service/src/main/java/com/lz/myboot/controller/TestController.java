package com.lz.myboot.controller;

import com.lz.myboot.common.model.Account;
import com.lz.myboot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    IAccountService accountService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "test success";
    }

    @RequestMapping(value = "getAccount",method = RequestMethod.GET)
    @ResponseBody
    public Account getAccountList(){
        return accountService.getAccount();
    }
}
