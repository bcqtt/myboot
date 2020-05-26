package com.lz.myboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lz.myboot.entity.WxAccount;
import com.lz.myboot.service.IWxAccountService;
import com.lz.myboot.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/wx")
public class WeixinController {

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private IWxAccountService wxAccountService;

    @Value("${weixin.appid}")
    public String appid;

    @Value("${weixin.appSecret}")
    public String appSecret;

    @PostMapping("/login")
    public String wxLogin(String jsCode, HttpServletRequest request){
        String code2SessionUrl = "https://api.weixin.qq.com/sns/jscode2session";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("appid", appid);
        params.add("secret", appSecret);
        params.add("js_code", jsCode);
        params.add("grant_type", "authorization_code");
        URI code2Session = HttpUtil.getURIwithParams(code2SessionUrl, params);
        String result = restTemplate.exchange(code2Session, HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), String.class).getBody();
        log.info("登录结果：{}",result);
        HttpSession session = request.getSession();
        session.setAttribute("result", result);
        JSONObject jsonObject = JSON.parseObject(result);
        wxAccountService.saveWxAccount(jsonObject);
        return result;
    }

}
