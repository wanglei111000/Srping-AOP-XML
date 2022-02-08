package com.st.sp.test;

import com.st.sp.api.Caculater;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext.xml");
    @Test
    public void test(){

        Caculater caculater = (Caculater)ioc.getBean(Caculater.class);
        caculater.add(1,2);
        caculater.min(10,6);
        caculater.multi(10,6);
        caculater.div(2,1);
        caculater.div(2,0);

//        执行结果如下:
//        add方法开始运行,参数是[1, 2]
//        环绕前置通知,add 方法开始执行 参数是:[1, 2]
//        环绕返回通知,add 方法执行完成得到结果：3
//        环绕后置通知,add 方法执行结束
//                add方法结束
//        add方法正常运行完成,参数是[1, 2],结果是:3
//        min方法开始运行,参数是[10, 6]
//        环绕前置通知,min 方法开始执行 参数是:[10, 6]
//        环绕返回通知,min 方法执行完成得到结果：4
//        环绕后置通知,min 方法执行结束
//                min方法结束
//        min方法正常运行完成,参数是[10, 6],结果是:4
//        multi方法开始运行,参数是[10, 6]
//        环绕前置通知,multi 方法开始执行 参数是:[10, 6]
//        环绕返回通知,multi 方法执行完成得到结果：60
//        环绕后置通知,multi 方法执行结束
//                multi方法结束
//        multi方法正常运行完成,参数是[10, 6],结果是:60
//        div方法开始运行,参数是[2, 1]
//        环绕前置通知,div 方法开始执行 参数是:[2, 1]
//        环绕返回通知,div 方法执行完成得到结果：2
//        环绕后置通知,div 方法执行结束
//                div方法结束
//        div方法正常运行完成,参数是[2, 1],结果是:2
//        div方法开始运行,参数是[2, 0]
//        环绕前置通知,div 方法开始执行 参数是:[2, 0]
//        环绕异常通知,div 方法执行出现异常：java.lang.ArithmeticException: / by zero
//        环绕后置通知,div 方法执行结束
//                div方法结束
//        div方法正常运行完成,参数是[2, 0],结果是:null    这里为null 是因为 异常被捕获了

    }
}
