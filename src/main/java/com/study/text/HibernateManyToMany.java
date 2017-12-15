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
            r2.setRo_name("保安");
            r2.setRo_memo("保安描述");
            Role r3 = new Role();
            r3.setRo_name("司机");
            r3.setRo_memo("司机描述");
            //给用户1创建r1和r2的角色
            user1.getRoles().add(r1);
            user1.getRoles().add(r2);
            //给user2创建r2和r3的角色
            user2.getRoles().add(r2);
            user2.getRoles().add(r3);
            //保存用户
            session.save(user1);
            session.save(user2);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Test
    public void manyToManyTableTest(){
        Session session = null;
        Transaction transaction=null;
        try{
            session = HibernateUtils.getSessionObject();
            transaction = session.beginTransaction();
            User user =  session.get(User.class,3);
            Role role = session.get(Role.class,2);
            user.getRoles().add(role);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Test
    public void manyToManyDeleteTest(){
        Session session = null;
        Transaction transaction=null;
        try{
            session = HibernateUtils.getSessionObject();
            transaction = session.beginTransaction();
            User user =  session.get(User.class,2);
            Role role = session.get(Role.class,3)       ;
            //让用户移除某个操作
            user.getRoles().remove(role);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
