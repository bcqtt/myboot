package com.lz.myboot.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiwen
 * @since 2019-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WxAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sessionKey;

    private String openid;

    /**
     * 最近登录时间
     */
    private LocalDateTime lastTime;


}
