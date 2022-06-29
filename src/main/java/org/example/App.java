package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args ) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Adamski");
        author.setAddress("Gdansk");
        session.save(author);
        transaction.commit();
        session.close();
    }
}
