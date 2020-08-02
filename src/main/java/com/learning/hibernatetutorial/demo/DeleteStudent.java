package com.learning.hibernatetutorial.demo;

import com.learning.hibernatetutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        System.out.println("Connected");

        try {

            int studentId = 1;
            session.beginTransaction();
            session = factory.getCurrentSession();

            session.createQuery("delete Student where id =  "+studentId).executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done deleting");
        } finally {
            session.close();
        }
    }
}
