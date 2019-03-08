package com.isoftstone.bi.feignserver.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: leo
 * @Date: 2019/2/12 15:49
 * @Version 0.0.1
 * @Desc 用来跳过token的注解
 * Target:注解的作用目标
 * Target(ElementType.TYPE)——接口、类、枚举、注解
 * Target(ElementType.METHOD)——方法
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {

    boolean required() default true;
}
