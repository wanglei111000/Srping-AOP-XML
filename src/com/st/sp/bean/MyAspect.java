package com.st.sp.bean;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
public class MyAspect {

   // @Before("execution(public int com.st.sp.impl.MyCaculater.*(..))")
    public static void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();  //通过连接点获取方法名称
        Object[] parateters = joinPoint.getArgs();  //通过连接点获取参数列表
        System.out.println(methodName + "方法开始运行,参数是" + Arrays.asList(parateters));
    }


    public static void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();  //通过连接点获取方法名称
        System.out.println(methodName + "方法结束");
    }


    public static void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();  //通过连接点获取方法名称
        System.out.println(methodName + "方法运行异常,异常信息:" + e);
    }

    public static void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();  //通过连接点获取方法名称
        Object[] parateters = joinPoint.getArgs();  //通过连接点获取参数列表
        System.out.println(methodName + "方法正常运行完成,参数是" + Arrays.asList(parateters) + ",结果是:" + result);
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object[] args = proceedingJoinPoint.getArgs();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object result  = null;
        try {
            // 通过反射执行方法proceedingJoinPoint.proceed(args);
            System.out.println("环绕前置通知,"+methodName+" 方法开始执行"+" 参数是:"+Arrays.asList(args));
            result = proceedingJoinPoint.proceed(args);
            System.out.println("环绕返回通知,"+methodName+" 方法执行完成得到结果："+ result);
        }catch (Exception e){
            System.out.println("环绕异常通知,"+methodName+" 方法执行出现异常："+ e);
        }finally {
            System.out.println("环绕后置通知,"+methodName+" 方法执行结束");
        }
        return result;  //不能随意串改
    }

}
