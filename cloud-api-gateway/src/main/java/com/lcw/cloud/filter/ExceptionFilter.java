package com.lcw.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/23 10:27
 */
@Component
public class ExceptionFilter extends ZuulFilter {
    Logger log = LoggerFactory.getLogger(ExceptionFilter.class);
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        log.error("this is a ErrorFilter : {}", throwable.getCause().getMessage());

        String ret = "{\"code\""+HttpServletResponse.SC_INTERNAL_SERVER_ERROR +",\"message\":\"系统异常\"}";
        ctx.remove("throwable");
        ctx.setResponseStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.setResponseBody(ret);
        ctx.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        return null;
    }

}
