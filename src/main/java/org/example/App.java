package org.example;

import org.example.model.Author;
import org.example.model.Car;
import org.example.repository.AuthorRepository;
import org.example.repository.CarRepository;
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

        AuthorRepository authorRepository = new AuthorRepository(sessionFactory);
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

        CarRepository carRepository = new CarRepository(sessionFactory);
        Car car = new Car();
        car.setBrand("fiat");
        car.setName("multipla");
        car.setMaxSpeed(70);
        carRepository.save(car);
        Car carFromDb = carRepository.find(car.getId());
        System.out.println("CAR FROM DB: " + carFromDb);
    }
}
