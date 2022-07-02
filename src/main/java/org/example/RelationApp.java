package org.example;

import org.example.model.Car;
import org.example.model.Owner;
import org.example.repository.CarRepository;
import org.example.repository.OwnerRepository;
import org.hibernate.SessionFactory;

public class RelationApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        CarRepository carRepository = new CarRepository(sessionFactory);
        OwnerRepository ownerRepository = new OwnerRepository(sessionFactory);

        Car fiatMultipla = new Car();
        fiatMultipla.setName("multipla");
        fiatMultipla.setBrand("fiat");
        fiatMultipla.setMaxSpeed(120);
        carRepository.save(fiatMultipla);

        Owner michal = new Owner();
        michal.setFirstName("Michal");
        michal.setLastName("Michalski");
        ownerRepository.save(michal);
    }
}
