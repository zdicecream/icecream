package com.zdinit.icecream.common.aop.aspect;

import com.zdinit.icecream.common.TheadPoolExecutor;
import com.zdinit.icecream.common.aop.ClearRedis;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class ClearRedisAspect {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TheadPoolExecutor theadPoolExecutor;

    @Pointcut("@annotation(com.zdinit.icecream.common.aop.ClearRedis)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Signature signature1 = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature1;
        Method targetMethod = methodSignature.getMethod();//方法对象
        ClearRedis annotation = targetMethod.getAnnotation(ClearRedis.class);//反射得到自定义注解的方法对象
        String name = annotation.name();//获取自定义注解的方法对象的参数即name

        //删除缓存
        redisTemplate.opsForHash().delete(name);
        log.info("第一次删除{}！",name);

        //执行加入双删注解的改动数据库的业务 即controller中的方法业务
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // 在线程中延迟删除  同时将业务代码的结果返回 这样不影响业务代码的执行
        theadPoolExecutor.getThreadPoolTaskExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                redisTemplate.opsForHash().delete(name);
                log.info("异步删除{}！",name);
            }
        });
        return proceed;//返回业务代码的值
    }
}
