package org.example.repository;

import org.example.model.Author;
import org.hibernate.SessionFactory;

public class NewAuthorRepository extends EntityRepository<Author> {

    public NewAuthorRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Author.class);
    }
}
