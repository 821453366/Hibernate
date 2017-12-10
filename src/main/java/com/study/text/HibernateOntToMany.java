package com.study.text;

import com.study.entity.Customer;
import com.study.entity.Salesperson;
import com.study.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 *
 * @author 马欢欢
 * @date 2017/12/10
 */
public class HibernateOntToMany {
    @Test
    public void TestOne_to_Many(){
        Session session = null;
        Transaction transaction=null;
        try{
            session = HibernateUtils.getSessionObject();
            transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setC_name("李客户");
            customer.setC_phone("13654521363");
            customer.setC_source("西安");

            Salesperson salesperson = new Salesperson();
            salesperson.setS_name("张销售");
            salesperson.setS_phone("15632653623");
            salesperson.setS_sex("女");
            Salesperson salesperson2 = new Salesperson();
            salesperson2.setS_name("赵销售");
            salesperson2.setS_phone("17845632154");
            salesperson2.setS_sex("男");


            //建立客户和销售联系人的关系
            //把销售联系人放在客户set集合里面
            customer.getSalespersonSet().add(salesperson);
            customer.getSalespersonSet().add(salesperson2);
            //把客户放到销售联系人里面
            salesperson.setCustomer(customer);
            salesperson2.setCustomer(customer);
            session.save(customer);
            session.save(salesperson);
            session.save(salesperson2);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Test
    public void TestOne_to_Many2(){
        Session session = null;
        Transaction transaction=null;
        try{
            session = HibernateUtils.getSessionObject();
            transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setC_name("孙客户");
            customer.setC_phone("111111111");
            customer.setC_source("广东");

            Salesperson salesperson = new Salesperson();
            salesperson.setS_name("马销售");
            salesperson.setS_phone("15632653623");
            salesperson.setS_sex("女");
            Salesperson salesperson2 = new Salesperson();
            salesperson2.setS_name("周销售");
            salesperson2.setS_phone("145263253");
            salesperson2.setS_sex("男");
            //把联系人放到客户里面
            customer.getSalespersonSet().add(salesperson);
            customer.getSalespersonSet().add(salesperson2);
            session.save(customer);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Test
    public void TestOne_to_Many_Delete(){
        Session session = null;
        Transaction transaction=null;
        try{
            session = HibernateUtils.getSessionObject();
            transaction = session.beginTransaction();
            //根据ID查询用户
            Customer customer = session.get(Customer.class,3);
            //调用删除
            session.delete(customer);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Test
    public void TestOne_to_Many_Update(){
        Session session = null;
        Transaction transaction=null;
        try{
            session = HibernateUtils.getSessionObject();
            transaction = session.beginTransaction();
            //根据ID查询用户
            Customer customer = session.get(Customer.class,1);
            Salesperson salesperson = session.get(Salesperson.class,7);
            //虽然在这个事物中并没有调用session的save()方法来保存user对象，但是usr处于持久太，
            //  所以对user对象所做的任何修改都持久化到数据库中   ---------持久态自动更新
            //把联系人放到客户里
            customer.getSalespersonSet().add(salesperson);
            //把客户放到联系人中
            salesperson.setCustomer(customer);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
