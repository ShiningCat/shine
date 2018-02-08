package com.shine.user.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.UrlPathHelper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

@ComponentScan
public class UrlPathXssFilter extends UrlPathHelper {

    @Override
    public String getOriginatingQueryString(HttpServletRequest request){
        System.out.println("重写过滤get请求参数");
        System.out.println("重写过滤get请求参数");
        if ((request.getAttribute(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE) != null) ||
                (request.getAttribute(WebUtils.ERROR_REQUEST_URI_ATTRIBUTE) != null)) {
            return (String) request.getAttribute(HtmlUtils.htmlEscape(WebUtils.FORWARD_QUERY_STRING_ATTRIBUTE));
        }
        else {
            return request.getQueryString();
        }
    }
}
