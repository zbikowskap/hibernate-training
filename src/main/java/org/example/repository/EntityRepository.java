package org.example.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public abstract class EntityRepository<T> {
    private SessionFactory sessionFactory;
    private Class<T> clazz;

    public EntityRepository(SessionFactory sessionFactory, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    public void save(T entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
    }

    public Optional<T> find(Integer id){
        Session session = sessionFactory.openSession();
        T entity = session.find(clazz, id);
        session.close();
        return Optional.ofNullable(entity);
    }

    public void update(T entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public void delete(Integer id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        find(id).ifPresent(author -> session.remove(author));
        find(id).ifPresent(session::remove);
        transaction.commit();
        session.close();
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
