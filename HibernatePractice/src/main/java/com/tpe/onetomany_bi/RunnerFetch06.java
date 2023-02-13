package com.tpe.onetomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company3.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1--Amazonda çalışan developer bilgilerini getiriniz.

        String hql1 = "FROM Company3 c WHERE c.companyname = 'Amazon' ";
        Company3 companyA = session.createQuery(hql1, Company3.class).uniqueResult();
        System.out.println("**************Amazonda Calisanlar*************");
        companyA.getDevs().forEach(System.out::println);
        System.out.println("******************************************");
        //companyden devlere ulasiliyor

        //2--"Gandalf"ın çalıştığı company bilgilerini getiriniz.

        String hql2 = "FROM Developer06 d where d.name ='Gandalf'";
        Developer06 dev1 = session.createQuery(hql2, Developer06.class).uniqueResult();
        System.out.println("*********************Gandalf*************");
        System.out.println(dev1.getCompany());

        //-------------------------- DELETE - ORPHANREMOVAL - CASCADETYPEALL ---------------------------------

        //3--id=22 olan companynin dev listesinden id=3 olan developerı siliniz.

//        Developer06 dev3 = session.get(Developer06.class, 3L);
//        Company3 company = session.get(Company3.class, 22L);
//        company.getDevs().remove(dev3);
//        System.out.println("Amazon Dev Listesi" + company.getDevs());

        //orphanRemoval true oldugunda tabledan da siliyor
        //CascadeTypeALL da ise sadece listeden cikartiyor.

        //4--id 11 olan company i sil
        Company3 company1 = session.get(Company3.class, 11L);
        session.delete(company1);
        //company iflas etti calisanlar da gitti(cascadetypeALL)






        tx.commit();
        session.close();
        sf.close();
    }
}
