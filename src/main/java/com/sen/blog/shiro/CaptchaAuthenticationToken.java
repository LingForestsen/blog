package com.sen.blog.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 扩展Shiro登录表单Token,增加验证码字段
 */
public class CaptchaAuthenticationToken extends UsernamePasswordToken {

    private static final long serialVersionUID = -2398729751909840213L;

    private String kaptcha;

    public CaptchaAuthenticationToken (){}

    public CaptchaAuthenticationToken (String username, String password,
                                       boolean rememberMe, String host, String kaptcha) {
        super(username, password, rememberMe, host);
        this.kaptcha = kaptcha;
    }

    public void setKaptcha(String kaptcha){
        this.kaptcha= kaptcha;
    }

    public String getKaptcha(){
        return this.kaptcha;
    }
}
