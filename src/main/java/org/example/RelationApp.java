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

        Owner michal = createOwner();
        Car fiatMultipla = createCar(michal);

        ownerRepository.save(michal);
        carRepository.save(fiatMultipla);

        System.out.println("ZNALEZIONY OWNER!!");
        ownerRepository.find(michal.getId()).ifPresent(System.out::println);
        System.out.println("ZNALEZIONY CAR !!!");
        carRepository.find(fiatMultipla.getId()).ifPresent(System.out::println);
    }

    private static Car createCar(Owner michal) {
        Car fiatMultipla = new Car();
        fiatMultipla.setName("multipla");
        fiatMultipla.setBrand("fiat");
        fiatMultipla.setMaxSpeed(120);
        fiatMultipla.setOwnerrrrrrrr(michal);
        return fiatMultipla;
    }

    private static Owner createOwner() {
        Owner michal = new Owner();
        michal.setFirstName("Michal");
        michal.setLastName("Michalski");
        return michal;
    }
}
