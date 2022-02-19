package com.st.sp.service;

import com.st.sp.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
//初始化数据
//    update account set balance = 10000;
//    update book set price = 100;
//    update book_stock set stock = 1000;
    //@Transactional(timeout = 3)   //验证超时属性  秒
//@Transactional(readOnly = true )
// 默认为false ，当方法中的操作全部都是 查询的时候 可以设置为true  加快查询速度
// @Transactional 默认 运行异常回滚
// 默认 编译时异常 不回滚

//rollbackFor 哪些异常回滚
//rollbackForClassName哪些异常回滚  使用全类名
//noRollbackFor哪些异常不回滚
//noRollbackForClassName() 哪些异常不回滚  使用全类名
//  例如 : @Transactional(rollbackFor = {ArithmeticException.class})

// Propagation.REQUIRED;  传播+行为 的可选值(多个事务进行嵌套的时候使用)
                          // 内部事务是否会和外部事物公用
//    控制这种事务是否需要回滚当其中的某一个方法失败的时候
//    AService{
//        tx_1(){
//            tx_2(){} ;
//            tx_3(){} ;
//        }
//    }


//    REQUIRED(0),   //如果已经存在事务,当前方法就在这个事务内执行，不存在已有的事务
                     //则新建一个事务，并在自己的事务内部运行

//    REQUIRES_NEW(3),  //当前方法必须启动新事物,并在自己的事务内部执行,如果有事务在运行，需要被挂起

//    SUPPORTS(1),    //如果有事务在运行，当前方法就在这个事务中运行，否则它就可以不运行在事务中
//    NOT_SUPPORTED(4),// 当前方法不应该运行在事务中，如果有运行的事务 将它挂起
//    MANDATORY(2),   //当前方法必须运行在事务内部，如果没有正在运行的事务，抛出异常
//    NEVER(5),       //当前方法不能运行在事务中，如果有运行的事务，会报异常
//    NESTED(6);       //如果有事务运行，当前方法在这个事务嵌套的事务内部运行，否则启动一个新得
    //事务，在新的事物内部运行

    //  隔离级别    根据业务特性设置
//    DEFAULT(-1),
//    READ_UNCOMMITTED(1),   读取到未提交的数据  脏读
//    READ_COMMITTED(2),     读取到别人已提交的数据 不可重复读 ，读取完第一次 ，
//    结果 另外一个会话提交了新的数据 但是当前会话有重复读了，但是数据和第一次不一致·  避免脏读
//    REPEATABLE_READ(4),    可重复读  mysql 默认 ,  避免不可重复读 和幻读
//    SERIALIZABLE(8);       串行化

//    oracle  只支持 READ_COMMITTED  SERIALIZABLE
//  不同的数据库厂商 的数据库隔离界别不一致

@Transactional
public void checkout(String userName,String number)  {
        bookDao.updateStock(number);
        int price = bookDao.getPrice(number);
        //int i = 100/0;
//        try {
//            Thread.sleep(3000);  //毫秒
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        bookDao.updateBalance(userName,price);

    }
}
