package org.example;

import org.example.model.Author;
import org.example.model.Car;
import org.example.model.Owner;
import org.example.model.Sticker;
import org.example.repository.AuthorRepository;
import org.example.repository.CarRepository;
import org.example.repository.OwnerRepository;
import org.example.repository.StickerRepository;
import org.hibernate.SessionFactory;

public class RelationApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        CarRepository carRepository = new CarRepository(sessionFactory);
        OwnerRepository ownerRepository = new OwnerRepository(sessionFactory);
        StickerRepository stickerRepository = new StickerRepository(sessionFactory);
        AuthorRepository authorRepository = new AuthorRepository(sessionFactory);

        Owner michal = createOwner();
        Car fiatMultipla = createCar(michal);

        ownerRepository.save(michal);
        carRepository.save(fiatMultipla);

        System.out.println("ZNALEZIONY OWNER!!");
        ownerRepository.find(michal.getId()).ifPresent(System.out::println);
        System.out.println("ZNALEZIONY CAR !!!");
        carRepository.find(fiatMultipla.getId()).ifPresent(System.out::println);

        Author author = createAuthor();
        Sticker sticker = createSticker(author, "flames");
        Sticker fireAndFlames = createSticker(author, "fire and flames");

        authorRepository.save(author);
        stickerRepository.save(sticker);
        stickerRepository.save(fireAndFlames);
    }

    private static Sticker createSticker(Author author, String name) {
        Sticker sticker = new Sticker();
        sticker.setName(name);
        sticker.setWidth(20.5F);
        sticker.setHeight(10.2F);
        sticker.setAuthor(author);
        return sticker;
    }

    private static Author createAuthor() {
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Adamski");
        author.setAddress("Gdansk");
        return author;
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
