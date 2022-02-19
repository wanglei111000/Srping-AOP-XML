package com.st.sp.test;

import com.st.sp.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.ResourceTransactionManager;

import java.io.FileNotFoundException;
import java.lang.annotation.*;

public class Tester02 {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:/conf/applicationContext.xml");
//编程式事务
//    Connection conn = null;
//    UserTransaction tx = null;
//try {
//        tx = getUserTransaction();                       //1.获取事务
//        tx.begin();                                    //2.开启JTA事务
//        conn = getDataSource().getConnection();           //3.获取JDBC
//        //4.声明SQL
//        String sql = "select * from INFORMATION_SCHEMA.SYSTEM_TABLES";
//        PreparedStatement pstmt = conn.prepareStatement(sql);//5.预编译SQL
//        ResultSet rs = pstmt.executeQuery();               //6.执行SQL
//        process(rs);                                   //7.处理结果集
//        closeResultSet(rs);                             //8.释放结果集
//        tx.commit();                                  //7.提交事务
//    } catch (Exception e) {
//        tx.rollback();                                 //8.回滚事务
//        throw e;
//    } finally {
//        conn.close();                                //关闭连接
//    }

    //事务的特性
    // 原子性  操作不可分割
    //一致性 事务之前的状态 和 事务之后 的状态是和业务的数据一致
    //隔离性  数据在 并发执行过程中不会互相干扰
    //持久性  事务执行完成后的数据应该要持久化到容器中

    // spring  通过AOP 来实现声明式事务  环绕通知  线程通知
    //就是在事务 执行的 过程中添加横切关注点,
    // spring  提供了  PlatformTransactionManager
    // ResourceTransactionManager
    // DataSourceTransactionManager
    // 根据 不同的平台 的子接口的实现来 处理 声明式事务

//    @Target({ElementType.METHOD, ElementType.TYPE})
//    @Retention(RetentionPolicy.RUNTIME)
//    @Inherited
//    @Documented
//    public @interface Transactional {
//        String value() default "";
//
//        Propagation propagation() default Propagation.REQUIRED;  传播行为
//
//        Isolation isolation() default Isolation.DEFAULT;  隔离级别
//
//        int timeout() default -1;   超时时间
//
//        boolean readOnly() default false;  是否只读
//
//        Class<? extends Throwable>[] rollbackFor() default {};  哪些异常回滚
//
//        String[] rollbackForClassName() default {};哪些异常回滚  使用全类名
//
//        Class<? extends Throwable>[] noRollbackFor() default {};哪些异常不回滚
//
//        String[] noRollbackForClassName() default {};哪些异常不回滚  使用全类名
//    }


// Propagation.REQUIRED;  传播行为 的可选值
//    REQUIRED(0),
//    SUPPORTS(1),
//    MANDATORY(2),
//    REQUIRES_NEW(3),
//    NOT_SUPPORTED(4),
//    NEVER(5),
//    NESTED(6);

//  隔离级别
//    DEFAULT(-1),
//    READ_UNCOMMITTED(1),
//    READ_COMMITTED(2),
//    REPEATABLE_READ(4),
//    SERIALIZABLE(8);


    @Test
    public void test() {
        BookService bookService = ioc.getBean(BookService.class);
        bookService.checkout("Jerry","ISBN-001");

    }


}
