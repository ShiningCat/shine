package com.shine.user.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shine.common.vo.ResultDO;
import com.shine.user.util.JwtHelper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class AuthorizeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                filterConfig.getServletContext());
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String servletPath = httpRequest.getServletPath();
        String path = servletPath.substring(1);
        if(httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())){
            chain.doFilter(request, response);
            return;
        }
        if("tokens".equals(path) || "users".equals(path) || path.contains("confirm_verification") || path.contains("update_password") || path.contains("verification")){
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
