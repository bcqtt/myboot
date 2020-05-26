package com.lz.myboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.myboot.entity.WxAccount;
import com.lz.myboot.mapper.WxAccountMapper;
import com.lz.myboot.service.IWxAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laizhiwen
 * @since 2019-07-19
 */
@Service
public class WxAccountServiceImpl extends ServiceImpl<WxAccountMapper, WxAccount> implements IWxAccountService {

    @Override
    public void saveWxAccount(JSONObject jsonObject) {
        QueryWrapper<WxAccount> qw = new QueryWrapper<>();
        qw.eq("openid",jsonObject.getString("openid"));
        WxAccount account = getOne(qw);
        if(account == null){
            account = new WxAccount();
            account.setOpenid(jsonObject.getString("openid"));
            account.setSessionKey(jsonObject.getString("session_key"));
            account.setLastTime(LocalDateTime.now());
            save(account);
        }
    }
}
