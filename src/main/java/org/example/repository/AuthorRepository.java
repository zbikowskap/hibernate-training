package org.example.repository;

import org.example.model.Author;
import org.hibernate.SessionFactory;

public class AuthorRepository extends EntityRepository<Author> {

    public AuthorRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Author.class);
    }
}
