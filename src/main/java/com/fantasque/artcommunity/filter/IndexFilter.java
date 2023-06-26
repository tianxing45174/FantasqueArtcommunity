package com.fantasque.artcommunity.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Component
@Order(1)
@WebFilter(urlPatterns = {"/jsp/index.jsp", "/"}, filterName = "indexFilter")
public class IndexFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        // init logic
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // doFilter logic
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        if (!requestURI.startsWith("/static/")) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("/user/toIndex");
        }
//        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // destroy logic
    }
}