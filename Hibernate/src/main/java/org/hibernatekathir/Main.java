package org.hibernatekathir;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Laptop lap = new Laptop();
        lap.setLap_id(1);
        lap.setL_name("asus");
        lap.setRam(16);
        lap.setModel("Rog");

        Student stu = new Student();
        stu.setRollno(6);
        stu.setName("kathiravan");
        stu.setMarks(85);
        stu.setLaptop(lap);



        Configuration cnf = new Configuration();
        cnf.configure("hibernate.cfg.xml");
        cnf.addAnnotatedClass(Student.class);
        cnf.addAnnotatedClass(Laptop.class);

        SessionFactory sf = cnf.buildSessionFactory();

        Session ses = sf.openSession();

        //Saving:

        Transaction transaction = ses.beginTransaction();
        ses.persist(lap);
        ses.persist(stu);
        transaction.commit();

    // Fetching:

//        Student s2 = null;
//        s2= ses.find(Student.class, 4);
//        System.out.println("data : "+ s2);


    // update
//        Transaction transaction = ses.beginTransaction();
//        ses.merge(stu);
//        transaction.commit();

//      Delete
//        Transaction transaction = ses.beginTransaction();
//        Student s3 = null;
//        s3= ses.find(Student.class, 6);
//        ses.remove(s3);
//        transaction.commit();


        ses.close();
        sf.close();


    }
}
