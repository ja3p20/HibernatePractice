package com.learning.hibernatetutorial.demo;

import com.learning.hibernatetutorial.entity.DateUtils;
import com.learning.hibernatetutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class ReadStudent {

    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        System.out.println("Connected");

        try {

            String dobString = "19/5/2004";
            Date theDate = DateUtils.parseDate(dobString);
            Student student = new Student("Siddhi","Panchal","dhaval@gmail.com",theDate);
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Done1");

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student theStudent = session.get(Student.class, student.getId());
            System.out.println("The Student object "+theStudent);

            session.getTransaction().commit();
            System.out.println("Done2");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
