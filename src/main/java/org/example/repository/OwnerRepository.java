package org.example.repository;

import org.example.model.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class OwnerRepository extends EntityRepository<Owner> {
    public OwnerRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Owner.class);
    }

    public List<String> getLastName(){
        Session session = getSessionFactory().openSession();
        List<String> resultList = session.createQuery("Select o.lastName From Owner o", String.class)
                .getResultList();
        session.close();
        return resultList;
    }
}
