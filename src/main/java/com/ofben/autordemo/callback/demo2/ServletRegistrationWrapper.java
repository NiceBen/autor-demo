package com.ofben.autordemo.callback.demo2;

import javax.servlet.MultipartConfigElement;
import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletSecurityElement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ServletRegistrationWrapper implements ServletRegistration.Dynamic{

    private final String servletName;

    private final Servlet servlet;

    public ServletRegistrationWrapper(String servletName, Servlet servlet) {
        this.servletName = servletName;
        this.servlet = servlet;
    }

    @Override
    public void setLoadOnStartup(int i) {

    }

    @Override
    public Set<String> setServletSecurity(ServletSecurityElement servletSecurityElement) {
        return null;
    }

    @Override
    public void setMultipartConfig(MultipartConfigElement multipartConfigElement) {

    }

    @Override
    public void setRunAsRole(String s) {

    }

    @Override
    public void setAsyncSupported(boolean b) {

    }

    @Override
    public Set<String> addMapping(String... strings) {
        return null;
    }

    @Override
    public Collection<String> getMappings() {
        return null;
    }

    @Override
    public String getRunAsRole() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getClassName() {
        return null;
    }

    @Override
    public boolean setInitParameter(String s, String s1) {
        return false;
    }

    @Override
    public String getInitParameter(String s) {
        return null;
    }

    @Override
    public Set<String> setInitParameters(Map<String, String> map) {
        return null;
    }

    @Override
    public Map<String, String> getInitParameters() {
        return null;
    }
}
