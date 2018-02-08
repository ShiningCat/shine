package com.shine.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shine.common.vo.ResultDO;
import com.shine.web.util.JwtHelper;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class AuthorizeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        if(httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())){
            chain.doFilter(request, response);
            return;
        }
        if("GET".equalsIgnoreCase(httpRequest.getMethod())){
            chain.doFilter(request, response);
            return;
        }
        String auth = httpRequest.getHeader("Authorization");
        if ((auth != null) && (auth.length() > 7)) {
            String HeadStr = auth.substring(0, 6).toLowerCase();
            if (HeadStr.compareTo("bearer") == 0) {
                auth = auth.substring(7, auth.length());
                if (JwtHelper.parseJWT(auth) != null) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ObjectMapper mapper = new ObjectMapper();
        ResultDO<Object> resultMsg = new ResultDO(false,"您的登录信息已过期,请重新登录!");
        httpResponse.getWriter().write(mapper.writeValueAsString(resultMsg));
        return;
    }

    @Override
    public void destroy() {
    }
}
