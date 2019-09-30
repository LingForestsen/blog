package com.sen.blog.exception_handler;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @Auther: Sen
 * @Date: 2019/9/30 17:43
 * @Description:
 */
public class IncorrectCaptchaException   extends AuthenticationException {
    private static final long serialVersionUID = 7043239273491030170L;

    public IncorrectCaptchaException() {
        super();
    }

    public IncorrectCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCaptchaException(String message) {
        super(message);
    }

    public IncorrectCaptchaException(Throwable cause) {
        super(cause);
    }

}