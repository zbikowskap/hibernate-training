package org.example.learning;

import java.util.List;
import java.util.Optional;

public class OptionalLearning {
    private static List<String> wordList = List.of("drzewo", "dom", "kot");

    public static Optional<String> findWord(String word) {
        if(wordList.contains(word)){
            return Optional.of(word);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println("SZUKAM SLOWA");
        String wordToFind = "kot";
        Optional<String> optionalWord = findWord(wordToFind);

        if(optionalWord.isPresent()){
            String result = optionalWord.get();
            System.out.println("WORD ISTNIEJE !!! " + result);
        }

        optionalWord.ifPresent(word -> System.out.println("WORD ISTNIEJE W LAMBDZIE!! " + word));

        String orElse = optionalWord.orElse("SLOWA NIE ZNALEZIONO");

        //tak nie robimy
        String takNieRobimy = optionalWord.get();


//        System.out.println("ZNALAZLEM SLOWO, JEGO DLUGOSC TO: " + result.length());

        String taaaa = "TADAM";
        Optional<String> tadam = Optional.of(taaaa);
        Optional<String> tadam1 = Optional.ofNullable(taaaa);
        Optional<String> empty = Optional.empty();

    }

}
