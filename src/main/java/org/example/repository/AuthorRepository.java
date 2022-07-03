package org.example.repository;

import org.example.model.Author;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorRepository extends EntityRepository<Author> {

    public AuthorRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Author.class);
    }

    public List<Author> getAll(){
        Session session = getSessionFactory().openSession();
        List<Author> resultList = session.createQuery("From Author", Author.class)
                .getResultList();
        session.close();
        return resultList;
    }

    public List<Author> getAllWithStickers(){
        Session session = getSessionFactory().openSession();
        List<Author> resultList = session.createQuery("From Author", Author.class)
                .getResultList();
        for (Author author : resultList) {
            Hibernate.initialize(author.getStickers());
        }
        session.close();
        return resultList;
    }

}
