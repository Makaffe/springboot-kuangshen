package com.example.demo.config;

import org.apache.tomcat.jni.Local;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


//
public class MyLocaleResolver implements LocaleResolver {


    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {

        //获取请求中的参数链接
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();//如果没有就是用默认

        //如果请求的链接携带了地区化参数
        if(!StringUtils.isEmpty(language)){
            //zh_CN
            String[] split = language.split("_");
            //国家地区
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
