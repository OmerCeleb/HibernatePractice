package com.tpe.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {


        Developer01 dev1 = new Developer01();


        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer01.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        dev1 = session.get(Developer01.class, 1); //id si 1 numarali devi bana getir
        System.out.println(dev1.toString());


        //1- sql ile tum datayi cekin

        String sqlSeklinde = "SELECT * FROM t_developer01";
        List<Object[]> resultList1 = session.createSQLQuery(sqlSeklinde).getResultList();
        System.out.println("-----------SQL-------------");

        //Array oldugu icin foreach ve arrays.tostring
        for (Object[] object : resultList1) {
            System.out.println(Arrays.toString(object));

            //2-HQL ile yapin
            String hqlSorgu = "FROM Developer01";
            List<Developer01> resultList2 = session.createQuery(hqlSorgu, Developer01.class).getResultList();
            for (Developer01 developer : resultList2) {
                System.out.println(developer);
            }


            ////hql ile ismi 'Shrek' olan datayı çekiniz.
            String hqlQuery2 = "FROM Developer01 WHERE name = 'Shrek'";
            List<Developer01> resultList3 = session.createQuery(hqlSorgu, Developer01.class).getResultList();
            for (Developer01 developer : resultList3) {
                System.out.println(developer);
            }


            ////hql ile emaili 'jack@mail.com' olan datayı çekiniz.


            String hqlQuery3 = "FROM Developer01 WHERE email = 'jack@gmail.com'";
            Developer01 result = session.createQuery(hqlQuery3, Developer01.class).uniqueResult();
            System.out.println("**********HQL***********");
            System.out.println(result.toString());

            //5-hql ile branch i backend olan datanın ismini getiriniz. ***ÖDEV***



            tx.commit();//transaction sonu
            session.close();//session sonu
            sf.close();//sessionfactory sonu
        }
    }
}
