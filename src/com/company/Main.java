package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ParseException {

        //-----------CHAPTER 1------------------
        // doing stuff with arrayList of Integers

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 7, 6, 5));

        //max

        final Integer max = arrayList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("the max number of the arrayList is: "+max);
        /** OR
         */

        final int max1 = arrayList.stream().mapToInt(Integer::valueOf).summaryStatistics().getMax();

        // min

        final Integer min = arrayList.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("the min number of the arrayList is: "+min);
        /** OR
         */

        final int min1 = arrayList.stream().mapToInt(Integer::valueOf).summaryStatistics().getMin();


        //average

        final double average = arrayList.stream().mapToInt(Integer::valueOf).summaryStatistics().getAverage();
        System.out.println("the average price of the arrayList is: "+average);

        //count the list items

        final long count = arrayList.stream().mapToInt(Integer::valueOf).summaryStatistics().getCount();
        System.out.println("the count of the arrayList is: "+ count);

        //sum all the items of that list

        final long sum = arrayList.stream().mapToInt(Integer::valueOf).summaryStatistics().getSum();
        System.out.println("the sum of the arrayList's items is: "+sum);
        /** OR
         */

        final Integer sum1 = arrayList.stream().reduce(Integer::sum).get();

        // sort the list in descending order
        System.out.println("sort the arrayList in descending order");
        arrayList.stream()

                .sorted(Collections.reverseOrder(Integer::compareTo))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        // sort the list in ascending order
        System.out.println("\nsort the arrayList in ascending order");
        arrayList.stream()

                .sorted(Collections.reverseOrder(Collections.reverseOrder(Integer::compareTo)))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // do that: 1-2-3....-7
        System.out.println("\ndo that: 1-2-3....-7");
        final String collect =arrayList.stream()
                .sorted(Collections.reverseOrder(Collections.reverseOrder()))
                .map(String::valueOf)
                .collect(Collectors.joining("-"));

        System.out.println(collect);

        //-----------CHAPTER 2------------------
        // playing with Maps


        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "x2");
        map.put(4, "x4");
        map.put(3, "x3");
        map.put(1, "x1");

        //sout-ing the value of a map
        System.out.println("\nthe values of a map");
        map.values().forEach(System.out::println);

        //sout-ing the key of a map
        System.out.println("the keys of a map");
        map.keySet().forEach(System.out::println);

        // sout-ing the sum of the keys
        System.out.println("the sum of the keys of a map");
        final int asInt = map.keySet().stream().mapToInt(i -> i).reduce(Integer::sum).getAsInt();
        System.out.println(asInt);

        // sout-ing all values except one item by the value
        System.out.println("all values except one item by the value");
        map.values().stream().filter(a->!(a.equals("x1"))).forEach(System.out::println);

        // sout-ing all keys except one item by the key
        System.out.println("all keys except one by a key");
        map.keySet().stream().filter(a-> a!=1).forEach(System.out::println);

        // sout-ing all values except one filtered by a key
        System.out.println("all values except one item by a key");
        map.entrySet().stream().filter(a->a.getKey()!=1).forEach(a-> System.out.println(a.getValue()));

        // sout-ing all keys except one filtered by a value
        System.out.println("all keys except one by the value");
        map.entrySet().stream().filter(a->!a.getValue().equals("x1")).forEach(a->System.out.println(a.getKey()));

        // sorting the map by the key  in ascending order
        System.out.println("sorted map in ascending order");
        map.entrySet().stream()
                // or.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())
                .sorted(Map.Entry.comparingByKey())
                .forEach(a-> System.out.println(a.getValue()));

        // sorting the map by the key  in descending order
        System.out.println("sorted map in descending order");
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(a-> System.out.println(a.getValue()));

        //-----------CHAPTER 3------------------
        // playing with Objects

      Person p1= new Person("Nick", 26, 82.1, "8/06/1993");
      Person p2= new Person("Joe", 28, 61.1, "8/06/1991");
      Person p3= new Person("Mary", 20, 50.1, "8/06/1999");
      Person p4= new Person("Jason", 18, 102.1, "8/06/2001");

        ArrayList<Person> arrayList1 = new ArrayList<>(Arrays.asList(
            p3, p4, p2, p1 ));

        //order by the age in ascending order
        System.out.println("\norder by the age in ascending order");
        arrayList1.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Person::getAge)))
                .collect(Collectors.toList())
                .forEach(a-> System.out.println(a.getAge()+"->" +a.getName()+" "+a.getDateOfBirth()+" "+a.getKilos()));

        //order by the kilos in descending order
        System.out.println("\norder by the kilos in descending order");
        arrayList1.stream()
                .sorted(Collections.reverseOrder(Collections.reverseOrder(Comparator.comparing(Person::getKilos))))
                .collect(Collectors.toList())
                .forEach(a-> System.out.println(a.getKilos()+"->"+a.getName()+" "+a.getDateOfBirth()+" "+a.getAge()));

        //sum the ages
        System.out.println("\nsum the ages");
        final int reduceAgesSum = arrayList1.stream()
                .mapToInt(Person::getAge)
                .reduce(0, Integer::sum);
        System.out.println(reduceAgesSum);

        // find the average kilos
        System.out.println("\nfind the average kilos");
        final double averageKilos = arrayList1.stream()
                .mapToDouble(Person::getKilos)
                .summaryStatistics().getAverage();
        System.out.println(averageKilos);

        // find the person whose kilos are ???
        System.out.println("\nfind the person whose kilos are 61.1");
        arrayList1.stream()
                .filter(a->a.getKilos()==61.1)
                .forEach(a-> System.out.println(a.getName()+" is "+a.getKilos()+" kilos"));

    }
}
