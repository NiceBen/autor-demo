package com.ofben.autordemo.spring.aop.demo10;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;
 
/**
 * @ClassName WebUtil
 * @Author Administrator
 * @Describe  日志帮助类 用来获取session中的用户信息来存入数据库
 */
public class WebUtil  {
 
 
    /**
     * 从session中获取到用户对象
     * @return
     */
    public Map<String, Object>   getUser(HttpServletRequest request){
        Map<String, Object> attribute=null;
        if(request!=null){
        Object user = request.getSession().getAttribute(Constans.USER_KEY);
      attribute = (Map<String, Object>) user;}
    return attribute;
}
    
}