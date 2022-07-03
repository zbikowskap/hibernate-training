package org.example.repository;

import org.example.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CarRepository extends EntityRepository<Car> {
    public CarRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Car.class);
    }

    // SELECT MAX_SPEED FROM CAR AS c
    public List<Integer> getMaxSpeed() {
        Session session = getSessionFactory().openSession();
        List<Integer> resultList = session.createQuery("Select c.maxSpeed From Car c", Integer.class)
                .getResultList();
        session.close();
        return resultList;
    }

    public List<Car> getAllCarsWithCriteriaQuery(){
        Session session = getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Car> query = cb.createQuery(Car.class);
        Root<Car> root = query.from(Car.class);
        query.select(root);

        List<Car> resultList = session.createQuery(query).getResultList();
        session.close();
        return resultList;
    }

    public void deleteCarsWithSpeedLowerThen(Integer speed) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("Delete From Car c Where c.maxSpeed < :speed")
                .setParameter("speed", speed)
                .executeUpdate();

        transaction.commit();
        session.close();
    }

    public List<Car> findAll(){
        Session session = getSessionFactory().openSession();
        List<Car> fromCar = session.createQuery("From Car", Car.class).getResultList();
        session.close();
        return fromCar;
    }
}
