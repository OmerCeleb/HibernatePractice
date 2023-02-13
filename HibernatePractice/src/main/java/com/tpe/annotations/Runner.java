package com.tpe.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner {
    public static void main(String[] args) {

        Developer01 dev1 = new Developer01(1, "HarryPotter", "hp@gmail.com", "backend");
        Developer01 dev2 = new Developer01(2, "Shrek", "shrek@gmail.com", "frontend");
        Developer01 dev3 = new Developer01(3, "JackSparrow", "jack@gmail.com", "mobile");

        //konfigurasyon olusturyorum
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer01.class);

        //session factory session uretmek icin kullaniyorum,
        SessionFactory sf = cfg.buildSessionFactory();

        //Session ise java ile db arasinda baglantiyi sagliyor islem bitince kapatilmasi gerekiyor. kendine ait metodlari var
        //örnek get update save
        Session session = sf.openSession();

        //Transaction atomik yapi
        Transaction tx = session.beginTransaction();

        session.save(dev1);//kayit islemi
        session.save(dev2);
        session.save(dev3);



        tx.commit();//transaction sonu
        session.close();//session sonu
        sf.close();//sessionfactory sonu
    }
}
