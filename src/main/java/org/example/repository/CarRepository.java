package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@AllArgsConstructor
public class CarRepository {
    private SessionFactory sessionFactory;

    public void save(Car car){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(car);
        transaction.commit();
        session.close();
    }

    public Car find(Integer id){
        Session session = sessionFactory.openSession();
        Car car = session.find(Car.class, id);
        session.close();
        return car;
    }
}
