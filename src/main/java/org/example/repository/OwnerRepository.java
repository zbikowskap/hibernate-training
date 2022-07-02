package org.example.repository;

import org.example.model.Owner;
import org.hibernate.SessionFactory;

public class OwnerRepository extends EntityRepository<Owner> {
    public OwnerRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Owner.class);
    }
}
