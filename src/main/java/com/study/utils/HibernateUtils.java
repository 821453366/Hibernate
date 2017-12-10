package com.study.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author 马欢欢
 * @date 2017/12/7
 */
public class HibernateUtils {
    private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;

    static {
        configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }
    public static Session getSessionObject(){
        return sessionFactory.getCurrentSession();
    }
    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    public static void main(String[] args) {

    }
}
