package ru.registry;

/**
 * Created by tanya on 14.09.16.
 */
public class Main {

    public static void main(String[] args) {

        Person sofi = new Person(true, "Mary");
        Person john = new Person(false,"John");
        Person andrew = new Person(false,"Andrew");
        Person alisson = new Person(true,"Alisson");

        System.out.println("Try to marry Alisson and Sofi: " + alisson.marry(sofi));

        System.out.println("Try to marry Andrew and Sofi: " + sofi.marry(andrew));

        System.out.println("Try to marry John and Sofi again: " + andrew.marry(sofi));

        System.out.println("Try to marry John and Alisson: " + john.marry(alisson));

        System.out.println("Try to marry Andrew and Alisson: " + andrew.marry(alisson));
    }
}
