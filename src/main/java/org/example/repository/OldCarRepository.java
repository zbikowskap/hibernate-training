package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@AllArgsConstructor
public class OldCarRepository {
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

    public void update(Car car){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
        session.close();
    }

    public void delete(Integer id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = find(id);
        //Car car = session.find(Car.class, id);
        if (car != null) {
            session.remove(car);
        }
        transaction.commit();
        session.close();
    }
}
