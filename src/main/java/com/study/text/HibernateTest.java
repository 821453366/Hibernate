package com.study.text;


import com.study.entity.User;
import com.study.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 *
 * @author 马欢欢
 * @date 2017/12/5
 */
public class HibernateTest {

    @Test

    public void testAdd(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        //    开启事务
        Transaction tx = session.beginTransaction();
        User user = new User();
        user.setUsername("小明");
        user.setPassword("456789");
        user.setAddress("西安");
        session.save(user);
        //    提交事务
        tx.commit();
        //    关闭资源
        session.close();
        sessionFactory.close();
    }
    @Test
    public void testGet(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class,1);
        System.out.println(user);
        System.out.println(User.class);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    public void textUpdate(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class,2);
        user.setUsername("改名成");
        session.update(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    public void testDelete(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class,2);
        session.delete(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    public void testCasch(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class,3);
        System.out.println(user);
        User user2 = session.get(User.class,3);
        System.out.println(user2);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testupdate(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class,3);
        user.setUsername("修改名称");
        //session.update(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    public void testselect(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction=null;
        try{
//            sessionFactory = HibernateUtils.getSessionFactory();
            session = HibernateUtils.getSessionObject();
            transaction = session.beginTransaction();
            User user = new User();
            user.setUsername("小马");
            user.setPassword("45465");
            user.setAddress("陕西");
            session.save(user);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
            //项目中不需要关闭
//            sessionFactory.close();
        }
    }


}
