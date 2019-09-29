package com.sen.blog.exception_handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: Sen
 * @Date: 2019/9/29 17:14
 * @Description: 500异常处理
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

    public static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (request.getHeader("X-Requested-With") != null) {
            try {
                response.getWriter().print("服务器异常");
            } catch (IOException e) {
                logger.error("服务器发送异常信息失败", e);
            }
            return null;
        }
        logger.error("服务器异常信信息", ex);
        return new ModelAndView("/home/error/500");
    }
}
