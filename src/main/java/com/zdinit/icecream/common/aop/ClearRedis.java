package com.zdinit.icecream.common.aop;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface ClearRedis {
    String name() default "";
}
