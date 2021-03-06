package com.learning.mappingtutorial.onetoone.demo;

import com.learning.mappingtutorial.onetoone.entity.Instructor;
import com.learning.mappingtutorial.onetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            int id = 2;

            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, id);
            session.delete(instructor);
            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}
