package org.example;

import org.example.model.*;
import org.example.repository.AuthorRepository;
import org.example.repository.CarRepository;
import org.example.repository.OwnerRepository;
import org.example.repository.StickerRepository;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RelationApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        CarRepository carRepository = new CarRepository(sessionFactory);
        OwnerRepository ownerRepository = new OwnerRepository(sessionFactory);
        StickerRepository stickerRepository = new StickerRepository(sessionFactory);
        AuthorRepository authorRepository = new AuthorRepository(sessionFactory);

        Owner michal = createOwner();
        Car fiatMultipla = createFiat(michal, "multipla");
        Car fiatPanda = createFiat(null, "panda");

        ownerRepository.save(michal);
        carRepository.save(fiatMultipla);
        carRepository.save(fiatPanda);

        System.out.println("ZNALEZIONY OWNER!!");
        ownerRepository.find(michal.getId()).ifPresent(System.out::println);
        System.out.println("ZNALEZIONY CAR !!!");
        carRepository.find(fiatMultipla.getId()).ifPresent(System.out::println);

        Author author = createAuthor();
        Sticker sticker = createSticker(Set.of(fiatMultipla), author, "flames");
        Sticker fireAndFlames = createSticker(Set.of(fiatMultipla, fiatPanda), author, "fire and flames");

        authorRepository.save(author);
        stickerRepository.save(sticker);
        stickerRepository.save(fireAndFlames);

//        List<Author> all = authorRepository.getAll();
//        for (Author a : all) {
//            System.out.println(a);
//        }
//
//        authorRepository.getAll().forEach(a -> System.out.println(a));
        System.out.println("ALL AUTHORS !!!:");
        authorRepository.getAllWithStickers()
                .forEach(System.out::println);

        //to wyrzuci wyjatek -  Lazy initialization exception
//        List<Author> allAuthors = authorRepository.getAll();
//        for (Author author1 : allAuthors) {
//            System.out.println("AUTHOR NAME: " + author1.getFirstName());
//            System.out.println("AUTHOR STICKERS: " + author1.getStickers());
//        }

        System.out.println("ALL MAX SPEEDS");
        carRepository.getMaxSpeed().forEach(System.out::println);

        System.out.println("GET OWNER LAST NAMES");
        ownerRepository.getLastName().forEach(System.out::println);

        System.out.println("GET STICKERS BY NAME");
        stickerRepository.getStickersByName("flames").forEach(System.out::println);

        System.out.println("GET STICKERS BY NAME 2");
        stickerRepository.getStickerByName2("flames").forEach(System.out::println);

        System.out.println("GET AUTHORS BY NAME AND LASTNAME");
        authorRepository.getAuthorByFirstNameAndLastName("Adam", "Adamski").forEach(System.out::println);

        System.out.println("DELETE CARS SLOWER THAN");
        carRepository.deleteCarsWithSpeedLowerThen(121);
        carRepository.findAll().forEach(System.out::println);

        Sticker managedContextExample = createSticker(null, null, "managedContextExample");
        stickerRepository.managedContextExample(managedContextExample);
        stickerRepository.find(managedContextExample.getId()).ifPresent(System.out::println);

        System.out.println("ALL CARS USING CRITERIA QUERRY!!");
        carRepository.getAllCarsWithCriteriaQuery().forEach(System.out::println);
    }

    private static Sticker createSticker(Set<Car> cars, Author author, String name) {
        Sticker sticker = new Sticker();
        sticker.setName(name);
        sticker.setWidth(20.5F);
        sticker.setHeight(10.2F);
        sticker.setAuthor(author);
        sticker.setCars(cars);
        return sticker;
    }

    private static Author createAuthor() {
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Adamski");
        author.setAddress("Gdansk");
        author.setFullAddress(new Address("20-200", "blotna", "Gdansk"));
        author.setPesel("82060335397");
        return author;
    }

    private static Car createFiat(Owner michal, String name) {
        Car fiatMultipla = new Car();
        fiatMultipla.setName(name);
        fiatMultipla.setBrand("fiat");
        fiatMultipla.setMaxSpeed(200);
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
