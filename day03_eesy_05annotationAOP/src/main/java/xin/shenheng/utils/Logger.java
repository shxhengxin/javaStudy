package xin.shenheng.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.runtime.internal.AroundClosure;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志工具类，里面提供了公共的代码
 */
@Component("logger")
@Aspect
public class Logger {

    @Pointcut("execution(* xin.shenheng.service.impl.*.*(..))")
    private void  pt1(){}


    @Before("pt1()")
    public  void  beforePrintLog(){
        System.out.println("前置通知logger类中的before方法记录日志了");
    }

    @AfterReturning("pt1()")
    public  void  afterReturningPrintLog(){
        System.out.println("后置通知logger类中的afterReturning方法记录日志了");
    }

    @AfterThrowing("pt1()")
    public  void  afterThrowingPrintLog(){
        System.out.println("异常通知logger类中的afterThrowing方法记录日志了");
    }

    @After("pt1()")
    public  void  afterPrintLog(){
        System.out.println("最终通知logger类中的after方法记录日志了");
    }

    
    //@Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {

            Object[] args = pjp.getArgs();
            System.out.println("logger类中的aroundPringLog方法记录日志了 前置通知");
            rtValue = pjp.proceed(args);
            System.out.println("logger类中的aroundPringLog方法记录日志了 后置通知");
            return rtValue;
        } catch (Throwable e) {
            System.out.println("logger类中的aroundPringLog方法记录日志了 异常通知");
            throw  new RuntimeException(e);
        }finally {
            System.out.println("logger类中的aroundPringLog方法记录日志了 最终通知");
        }
    }
}
