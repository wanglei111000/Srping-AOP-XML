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

// Propagation.REQUIRED;  传播行为 的可选值
//    REQUIRED(0),
//    SUPPORTS(1),
//    MANDATORY(2),
//    REQUIRES_NEW(3),
//    NOT_SUPPORTED(4),
//    NEVER(5),
//    NESTED(6);

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
