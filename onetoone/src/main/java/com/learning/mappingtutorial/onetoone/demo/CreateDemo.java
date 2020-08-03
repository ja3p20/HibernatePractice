package com.learning.mappingtutorial.onetoone.demo;

import com.learning.mappingtutorial.onetoone.entity.Instructor;
import com.learning.mappingtutorial.onetoone.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            /*
            Instructor instructor = new Instructor("Jatin","Panchal","jatin@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("mr beast", "coding");
            */
            Instructor instructor = new Instructor("Dhaval","Panchal","dhaval@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("dude perfect", "trick shots");

            session.beginTransaction();
            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);
            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}
