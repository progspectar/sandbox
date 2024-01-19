package org.example;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Observer<Object> observer = System.out::println;
        observer.showMessage("show some message ");
        Consumer<Object> consumer1 = System.out::println;
        Consumer<Object> consumer2 = System.out::print;
        Consumer<Object> consumer3 = consumer1.andThen(consumer2);
        consumer3.accept("str2 ");

        Function<String, Integer> f1 = Integer::valueOf;
        Function<String, Integer> f2 = Integer::parseInt;
        int mutatedstr = f1.apply("0001");
        System.out.println(mutatedstr);
        Supplier<Integer> s1 = () -> 11;
        Supplier<Integer> s2 = () -> 22;
        Supplier<Integer> s3 = () -> s1.get() + s2.get();
        System.out.println(s3.get());

        Supplier<String> su1= ()-> "it's result";
    }
}

interface Observer<T> {
    void showMessage(T t);
}