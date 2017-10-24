package com.xingyun.smartsite.common.filter;


import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class UrlFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

     /*   HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");
        if(user==null){
            String contextPath=request.getContextPath();
            response.sendRedirect(contextPath+"/login.html");
            return;
        }
        */
        filterChain.doFilter(request,response);

    }

    private void noAuthority(HttpServletResponse response){
        try {
            PrintWriter writer=response.getWriter();
            writer.write("没有权限访问此路径");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
