package org.example.repository;

import org.example.model.Car;
import org.hibernate.SessionFactory;

public class CarRepository extends EntityRepository<Car>{
    public CarRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Car.class);
    }
}
