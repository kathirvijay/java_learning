package org.hibernatekathir;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Student stu = new Student();
        stu.setRollno(6);
        stu.setName("kathiavan");
        stu.setMarks(45);


        Configuration cnf = new Configuration();
        cnf.configure()

        SessionFactory sf = cnf.buildSessionFactory();

        Session ses = sf.openSession();

        ses.persist(stu);

    }
}
