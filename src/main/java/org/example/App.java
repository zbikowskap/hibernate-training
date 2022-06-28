package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App
{
    public static void main( String[] args ) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.close();
    }
}
