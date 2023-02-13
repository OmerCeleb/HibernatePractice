package com.tpe.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);//Bir tane daha addannotated classina ihtiyacim var
        //compter klasiminda tablosunu da olusturdugum icin

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //id = 1 olan developerin tum bilgilerini getiriniz.

        Developer03 dev = session.get(Developer03.class, 1L);
        System.out.println("*********************");
        System.out.println(dev);
        System.out.println("*********************");

        //id = 33 olan computerin tum bilgilerini getiriniz

        Computer com = session.get(Computer.class, 33L);
        System.out.println("*********************");
        System.out.println(com);
        System.out.println("*********************");

        //id = 22 olan computeri kullanan dev bilgilerini getiriniz

        Computer com2 = session.get(Computer.class, 22L);
        System.out.println("*********************");
        System.out.println(com2.getDeveloper());
        System.out.println("*********************");

        //id= 2 olan developerin kullandigi computer bilgilerini getirin

        Developer03 dev1 = session.get(Developer03.class, 2L);
        System.out.println("*********************");
        System.out.println(dev1.getComputer());
        System.out.println("*********************");

        tx.commit();
        session.close();
        sf.close();


    }
}
