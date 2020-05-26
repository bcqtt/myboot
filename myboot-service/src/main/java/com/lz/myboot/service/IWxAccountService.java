package com.lz.myboot.service;

import com.alibaba.fastjson.JSONObject;
import com.lz.myboot.entity.WxAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laizhiwen
 * @since 2019-07-19
 */
public interface IWxAccountService extends IService<WxAccount> {

    void saveWxAccount(JSONObject jsonObject);
}
