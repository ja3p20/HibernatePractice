package com.learning.hibernatetutorial.demo;

import com.learning.hibernatetutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        System.out.println("Connected");

        try {

            session.beginTransaction();
            List<Student> theStudents = session.createQuery("from Student s where s.firstName='Jatin'").getResultList();

            for(Student tempStudent: theStudents){
                System.out.println(tempStudent);
            }
            session.getTransaction().commit();
            System.out.println("Done1");

        } finally {
            session.close();
        }
    }
}
