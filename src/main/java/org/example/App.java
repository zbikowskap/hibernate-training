package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App
{
    public static void main( String[] args ) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Car car = new Car();
//        car.setId(1);
//        car.setName("hmm");
//        session.save(car);
//        transaction.commit();
        session.close();
    }
}
