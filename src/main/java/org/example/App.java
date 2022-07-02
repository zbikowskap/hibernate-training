package org.example;

import org.example.model.Author;
import org.example.model.Car;
import org.example.repository.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class App
{
    public static void main( String[] args ) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Adamski");
        author.setAddress("Gdansk");

        NewAuthorRepository authorRepository = new NewAuthorRepository(sessionFactory);
        authorRepository.save(author);
//        Author authorFromDb = authorRepository.find(author.getId());
//        System.out.println("AUTHOR FROM DB: " + authorFromDb);

        //OPTIONAL V1
        authorRepository.find(author.getId())
                .ifPresent(authorFromDb -> System.out.println("AUTHOR FROM DB: " + authorFromDb));

        //OPTIONAL V2
        Optional<Author> optionalAuthorFromDb = authorRepository.find(author.getId());
        if(optionalAuthorFromDb.isPresent()){
            Author authorFromDb = optionalAuthorFromDb.get();
            System.out.println("AUTHOR FROM DB: " + authorFromDb);
        }

        author.setLastName("Edamski");
        authorRepository.update(author);

        authorRepository.find(author.getId())
                .ifPresent(authorFromDb -> System.out.println("AUTHOR FROM DB: " + authorFromDb));

//        authorRepository.delete(author.getId());
        Optional<Author> authorAfterDelete = authorRepository.find(author.getId());
        if(authorAfterDelete.isPresent()){
            System.out.println("NIE USUNALEM AUTORA");
        } else {
            System.out.println("USUWANIE SIE UDALO !");
        }


        NewCarRepository carRepository = new NewCarRepository(sessionFactory);
        Car car = new Car();
        car.setBrand("fiat");
        car.setName("multipla");
        car.setMaxSpeed(70);
        carRepository.save(car);
        Optional<Car> carFromDb = carRepository.find(car.getId());
        System.out.println("CAR FROM DB: " + carFromDb.get());

        //update
        System.out.println("CAR AFTER UPDATE: " + carRepository.find(car.getId()));

//        carRepository.delete(9999);
        System.out.println("CAR PO USUNIECIU: " + carRepository.find(car.getId()));


        NewAuthorRepository newAuthorRepository = new NewAuthorRepository(sessionFactory);
    }
}
