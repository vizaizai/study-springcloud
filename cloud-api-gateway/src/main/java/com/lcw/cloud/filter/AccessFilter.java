package com.lcw.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/12 17:08
 */
@Component
public class AccessFilter extends ZuulFilter {

    // pre：可以在请求被路由之前调用。
    // routing：在路由请求时候被调用。
    // post：在routing和error过滤器之后被调用。
    // error：处理请求时发生错误时被调用。

    // 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。这里定义为pre，代表会在请求被路由之前执行。
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。 越小越高
    @Override
    public int filterOrder() {
        return 0;
    }

    // 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器的具体逻辑。这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，然后通过
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        System.out.println("-----------" + ctx.getRequest().getMethod());
        return null;
    }
}
