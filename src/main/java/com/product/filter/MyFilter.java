//package com.product.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletRequestWrapper;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//@Component
//public class MyFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpSession session = req.getSession();
//        String username = (String) session.getAttribute("username");
//        if (username== null)
//        {
//            request = new HttpServletRequestWrapper(req){
//                @Override
//                public String getRequestURI() {
//                    return "/login";
//                }
//            };
//
//
//        }
//        chain.doFilter(request,response);
//
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
