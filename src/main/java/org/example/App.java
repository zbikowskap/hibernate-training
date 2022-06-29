package org.example;

import org.example.model.Author;
import org.example.repository.AuthorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args ) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Adamski");
        author.setAddress("Gdansk");

        AuthorRepository authorRepository = new AuthorRepository(sessionFactory);
        authorRepository.save(author);
    }
}
