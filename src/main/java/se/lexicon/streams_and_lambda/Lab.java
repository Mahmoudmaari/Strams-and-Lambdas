package se.lexicon.streams_and_lambda;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.lexicon.streams_and_lambda.utility.Gender;
import se.lexicon.streams_and_lambda.utility.Person;

/**
 * All exercises should be completed using Lambda expressions and the new
 * methods added to JDK 8 where appropriate. There is no need to use an
 * explicit loop in any of the code.
 *
 */
public class Lab {
    private List<Person> persons;
    
    public Lab(List<Person> persons) {
        this.persons = persons;
    }

    /**
     * Exercise1
     * Create print out the first names of each person in the list
     */
    public void exercise1() {
        System.out.println("\nRunning exercise 1:\n");
      
    		  
       persons.stream()
       .forEach(p-> System.out.println(p.getFirstName()));
      
       

    }

    /**
     * Exercise2
     * Remove the words that have odd lengths from the local list using removeIf()
     * Print out the remainder
     */
    public void exercise2() {
        System.out.println("\nRunning exercise 2:\n");
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        list.removeIf(l -> (l.length() %2) != 0);
        
        list.forEach(System.out::println);

    }

    /**
     * Exercise 3
     * Replace every word in the list with its upper case equivalent using replaceAll()
     * Print out the remainder
     */
    public void exercise3() {
        System.out.println("\nRunning exercise 3:\n");
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        	list.replaceAll(l-> l.toUpperCase());
        	list.forEach(System.out::println);
    }

    /**
     * Exercise 4
     * Convert every key-value pair of the map into a string and append them all
     * into a single string
     * Hint: Maps forEach takes a BiConsumer...
     */
    public void exercise4() {
        System.out.println("\nRunning exercise 4:\n");
        Map<String, Integer> map = new HashMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);

        StringBuilder sb = new StringBuilder();

       map.forEach((s,i)-> sb.append(s).append(i));
      System.out.println(sb); 

    }

    /**
     * Exercise 5
     * Create a new thread that prints the numbers from the local list
     */
    public void exercise5() {
        System.out.println("\nRunning exercise 5:\n");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ExecutorService servis = Executors.newSingleThreadExecutor();
        servis.execute(()-> list.forEach(System.out::println));


    }

    /**
     * Exercise 6
     * By using stream create a new list with all the strings from the original list converted to
     * lower case and print them out.
     * Hint: Use .collect as a terminal operation(closing and ending)
     */
    public void exercise6() {
        System.out.println("\nRunning exercise 6:\n");
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");
         List<String> newlist = list.stream()
        		.map(String::toLowerCase)
        		.collect(Collectors.toList());
         System.out.println(newlist);
        		
    }
      

    

    /**
     * Exercise 7
     * Modify exercise 6 so that the new list only contains strings that have an
     * odd length
     */
    public void exercise7() {
        System.out.println("\nRunning exercise 7:\n");
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

       List<String> newlist = list.stream()
    		   .filter(l -> l.length() %2 != 0)
    		   .map(String::toLowerCase)
    		   .collect(Collectors.toList());
    		   
       newlist.forEach(System.out::println);
    		   

    }

    /**
     * Exercise 8
     * Turn list persons into a stream and print all elements whose lastName starts with 'A'
     * Use a forEach as a terminal operation
     */
    public void exercise8() {
        System.out.println("\nRunning exercise 8:\n");

        persons.stream()
        .filter(p -> p.getLastName().startsWith("A"))
        .forEach(System.out::println);

    }

    /**
     * Exercise 9
     * Create a new list from this.persons that should be sorted by lastName
     */
    public void exercise9(){
        System.out.println("\nRunning exercise 9:\n");

       List<Person> sorted = persons.stream()
    		   .sorted((p1,p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()))
    		   .collect(Collectors.toList());
       System.out.println(sorted+"\n");
    		 
      
    		 


    }

    /**
     * Exercise 10
     * Create a new list from persons that should only contain those with lastname "Ali".
     * then change the first name of all inside the stream to Muhammad
     */
    public void exercise10(){
        System.out.println("\nRunning exercise 10:\n");

      List<Person> newlist = persons.stream()
    		  .filter(p -> p.getLastName().equals("Ali"))
    		  .map(original -> new Person("mohammad", original.getLastName() , original.getGender()))
    		  .collect(Collectors.toList());
              newlist.forEach(System.out::println);
    		   
    		   
    		   

    }

    /**
     * Exercise 11
     * Count how many persons is of female gender in this.persons.
     * Present the result
     */
    public void exercise11(){
        System.out.println("\nRunning exercise 11:\n");

      long number = persons.stream()
    		  .filter(p->p.getGender() == Gender.FEMALE)
    		  .count();
      System.out.println(number);

    }

}