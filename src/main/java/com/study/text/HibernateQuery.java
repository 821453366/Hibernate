package com.study.text;

import com.study.entity.User;
import com.study.utils.HibernateUtils;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.*;

/**
 *
 * @author 马欢欢
 * @date 2017/12/8
 */
public class HibernateQuery {

    @Test
    public void testQuery(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction=null;
        try{
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
           Query query = session.createQuery("from User");
            List <User> list = query.list();
            for(User user:list){
                System.out.println(user);
            }
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
            //项目中不需要关闭
            sessionFactory.close();
        }
    }
    @Test
    public void testCriteria(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction=null;
        try{
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
           Criteria criteria = session.createCriteria(User.class);
            List <User> list = criteria.list();
            for(User user:list){
                System.out.println(user);
            }
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
            //项目中不需要关闭
            sessionFactory.close();
        }
    }
    @Test
    public void testSQLQuery(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction=null;
        try{
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            SQLQuery sqlQuery = session.createSQLQuery("select * from h_user");
            //查询出来的是数组,转为实体类
            sqlQuery.addEntity(User.class);
            List <User> list = sqlQuery.list();
            for(User user:list){
                System.out.println(user);
            }
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
            //项目中不需要关闭
            sessionFactory.close();
        }
    }
}
