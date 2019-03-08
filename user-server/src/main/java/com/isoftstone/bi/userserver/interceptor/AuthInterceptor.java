package com.isoftstone.bi.userserver.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.isoftstone.bi.userserver.annotation.PassToken;
import com.isoftstone.bi.userserver.annotation.UserLoginToken;
import com.isoftstone.bi.userserver.entity.BiUser;
import com.isoftstone.bi.userserver.service.RedisHelper;
import com.isoftstone.bi.userserver.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Author: leo
 * @Date: 2019/2/12 16:39
 * @Version 0.0.1
 * @Desc  拦截器，验证token
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    @Autowired
    RedisHelper redisHelper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        //如果请求不是映射到方法，直接通过
        if(!(handler instanceof HandlerMethod)){
           return true;
        }
        HandlerMethod handlerMethod= (HandlerMethod) handler;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken=method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if(method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken=method.getAnnotation(UserLoginToken.class);
            if(userLoginToken.required()){
                if(token==null){
                    throw new RuntimeException("您还没有登录,请登录");
                }
                String userId;
                String strToken;
                String[] strs=token.split(":");
                try {
                    strToken= (String) redisHelper.getValue(strs[0]);
                    if(StringUtils.isEmpty(strToken)){
                        throw new RuntimeException("登录过期，请重新登录");
                    }else if(!strToken.equals(strs[1])){
                        throw new RuntimeException("登录过期，请重新登录");
                    }
                    userId = JWT.decode(strs[1]).getAudience().get(0);
                }catch (JWTDecodeException decodeException){
                    throw new RuntimeException("401");
                }
                BiUser biUser=userService.findById(Long.parseLong(userId));
                if(biUser==null){
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                try {
                    JWTVerifier verifier=JWT.require(Algorithm.HMAC256(biUser.getUserPassword())).build();
                    verifier.verify(strs[1]);
                    redisHelper.expirse(strs[0],30, TimeUnit.MINUTES);
                }catch (JWTVerificationException verificationException){
                    throw new RuntimeException("验证错误，请重新登录");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
