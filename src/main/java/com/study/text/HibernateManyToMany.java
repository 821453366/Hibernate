package com.study.text;

import com.study.entity.Customer;
import com.study.entity.Role;
import com.study.entity.Salesperson;
import com.study.entity.User;
import com.study.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 *
 * @author 马欢欢
 * @date 2017/12/10
 */
public class HibernateManyToMany {
    @Test
    public void TestMany_to_Many_add(){
        Session session = null;
        Transaction transaction=null;
        try{
            session = HibernateUtils.getSessionObject();
            transaction = session.beginTransaction();
            User user1 = new User();
            user1.setUsername("张用户");
            user1.setPassword("12345");
            user1.setAddress("西安");

            User user2 = new User();
            user2.setUsername("王用户");
            user2.setPassword("789456");
            user2.setAddress("广东");

            Role r1 = new Role();
            r1.setRo_name("总经理");
            r1.setRo_memo("总经理描述");
            Role r2 = new Role();
            r2.setRo_name("总经理");
            r2.setRo_memo("总经理描述");
            Role r3 = new Role();
            r3.setRo_name("总经理");
            r3.setRo_memo("总经理描述");
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
