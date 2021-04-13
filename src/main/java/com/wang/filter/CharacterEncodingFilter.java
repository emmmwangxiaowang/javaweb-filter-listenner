package com.wang.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 王航
 * @QQ 954544828
 * @since 2021/4/13 0013
 */
//实现filter接口,实现对应方法(步骤和servlet差不多)
public class CharacterEncodingFilter implements Filter {

    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter初始化...");
    }

    //Chain: 链
    /*
    1.过滤器中的所有代码，在过滤特定请求的时候都会执行
    2.必须要让过滤器继续通行(转交)
        chain.doFilter(request,response)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        System.out.println("CharacterEncodingFilter执行前...");
        filterChain.doFilter(request,response);
        System.out.println("CharacterEncodingFilter执行后...");

    }

    //销毁
    public void destroy() {
        System.out.println("CharacterEncodingFilter已销毁");
    }
}
