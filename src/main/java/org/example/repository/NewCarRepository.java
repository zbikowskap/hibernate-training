package org.example.repository;

import org.example.model.Car;
import org.hibernate.SessionFactory;

public class NewCarRepository extends EntityRepository<Car>{
    public NewCarRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Car.class);
    }
}
