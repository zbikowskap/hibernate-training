package org.example.repository;

import org.example.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CarRepository extends EntityRepository<Car>{
    public CarRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Car.class);
    }

    // SELECT MAX_SPEED FROM CAR AS c
    public List<Integer> getMaxSpeed(){
        Session session = getSessionFactory().openSession();
        List<Integer> resultList = session.createQuery("Select c.maxSpeed From Car c", Integer.class)
                .getResultList();
        session.close();
        return resultList;
    }
}
