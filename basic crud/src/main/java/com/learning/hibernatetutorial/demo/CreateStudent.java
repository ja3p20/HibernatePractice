package com.learning.hibernatetutorial.demo;

import com.learning.hibernatetutorial.entity.DateUtils;
import com.learning.hibernatetutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateStudent {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();
        Session session = factory.getCurrentSession();

        System.out.println("Connected");

        try {

            String dateOfBirthString = "31/12/1996";
            Date dateOfBirth = DateUtils.parseDate(dateOfBirthString);
            Student student = new Student("Jatin","Panchal","jatin@gmail.com", dateOfBirth);

            session.beginTransaction();

            session.save(student);

            session.getTransaction();

            System.out.println("Done");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
