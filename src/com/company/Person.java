package com.company;

import java.util.Date;
import java.util.stream.Stream;

public class Person {

   private String name;
   private Integer age;
   private Double kilos;
   private String dateOfBirth;

    public Person(String name, Integer age, Double kilos, String dateOfBirth) {
        this.name = name;
        this.age = age;
        this.kilos = kilos;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getKilos() {
        return kilos;
    }

    public String  getDateOfBirth() {
        return dateOfBirth;
    }
}
