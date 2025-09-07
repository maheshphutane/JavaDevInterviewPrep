package org.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//Functional interface
@FunctionalInterface
interface Test1<T>{
    int sum(T a,T b);
}
public class Java8Features {
    public static void main(String[] args) {
        //Stream API Examples
        List<Integer> arr = Arrays.asList(5,11,2,2,4,7,6,3,4,134);
        //find out all the even numbers exist in the list using Stream functions
        //arr.stream().filter(e->e%2==0).forEach(System.out::println);
        System.out.println("Stream API examples");
        arr.stream().filter(e->e%2==0).forEach(e->System.out.print(e+" "));
        System.out.println();

        //Find the 3rd largest number from list
        System.out.print("Third largest number :- ");
        System.out.println(arr.stream().sorted((a,b)->(b-a)).skip(3).findFirst().get());

        //Find out square of all odd elements in list
        System.out.println();
        arr.stream().filter(e->e%2!=0).forEach(e->System.out.print(e*2+" "));
        System.out.println();

        //Find out all the numbers that starts with 1
        System.out.println("Numbers that starts with 1");
        arr.stream().map(e->e+"").filter(e->e.startsWith("1")).forEach(e->System.out.print(e+" "));
        System.out.println("\n");

        //find duplicate elements in a given integers list in java using Stream functions
        System.out.println("Duplicate elements in a given integers list in java using Stream functions");
        Set<Integer> st = new HashSet<>();
        arr.stream().filter(e->!st.add(e)).forEach(e->System.out.print(e+" "));
        System.out.println("\n");

        //find the first element of the list using Stream functions
        System.out.println("First element of the list using Stream functions");
        arr.stream().findFirst().ifPresent(e->System.out.print(e));
        System.out.println("\n");

        //sort all the values present in it using Stream functions
        System.out.println("sort all the values present in it using Stream functions");
        arr.stream().sorted().forEach(e->System.out.print(e+" "));
        System.out.println("\n");

        //sort all the values present in it using Stream functions in desc order
        System.out.println("sort all the values present in it using Stream functions in desc order");
        arr.stream().sorted(Collections.reverseOrder()).forEach(e->System.out.print(e+" "));
        System.out.println("\n");

        //find the maximum value element present in it using Stream functions
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1200,"Mahesh","mahesh@gmail.com"));
        employeeList.add(new Employee(1900,"Ramesh","ramesh@gmail.com"));
        employeeList.add(new Employee(200,"Suresh","suresh@gmail.com"));

        System.out.println("Max Salary of Employee using Comparator.comparing is:- " +employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary());
        System.out.println("Max Salary of Employee using reduce is:- " +employeeList.stream().reduce((a,b)->a.getSalary()>b.getSalary() ? a:b).get().getSalary());

        //Java 8 Program to Print ten random numbers using forEach

        System.out.println("\nPrinting Random value bet 1 to 10");
        Random random = new Random();
        random.ints(0,11).limit(10).forEach(e->System.out.print(e+" "));
        System.out.println("\n");

        //Count distinct elements greater than 3 in List

        System.out.println("Count distinct elements greater than 3 in List");
        Set<Integer> st2 = new HashSet<>();
        System.out.println(arr.stream().filter(e->e>3 && st2.add(e)).count()+"\n");

        //flatmap methode in stream API
        System.out.println("Print flattened list from nested list");
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(ls->ls.stream()) // Flattens the lists into a single stream
                .collect(Collectors.toList());

        System.out.println(flattenedList+"\n");

        //Functional Interface
        Test1<Integer> t1 = (a,b) -> a+b;

        System.out.println("Functional Interface Example:- \n"+t1.sum(5,10)+"\n");

        //Predicates A predicate is a functional interface that represents a condition or a test.
        // It takes an input and returns a boolean value indicating whether the condition is true or false.
        // For example:
        Predicate<Integer> isEven = num -> num % 2 == 0;
        boolean result = isEven.test(4); // true

        //Function is a functional interface that represents a transformation or mapping operation.
        // It takes an input of one type and produces an output of another type. For example:
        Function<Integer, String> intToString = num -> String.valueOf(num);
        String result1 = intToString.apply(123); // "123"
        System.out.println(result1);

        //Consumer: A consumer is a functional interface that represents an operation that takes
        // an input and performs some action, but does not produce any output.
        // For example:
        Consumer<String> printMessage = message -> System.out.println(message);
        printMessage.accept("Hello, World!"); // Prints "Hello, World!"

        //Supplier: A supplier is a functional interface that represents a supplier of results,
        // without taking any input. It provides a way to generate or produce values.
        // For example:
        Supplier<Double> getRandomNumber = () -> Math.random();
        double result2 = getRandomNumber.get(); // Generates a random number
        System.out.println(Math.round(result2*10));

        //count the frequency of each character in given string
        String str = "mynameismahesh";
        Map<String, Long> mp = Arrays.stream(str.split(""))
                                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(mp);
        
        //print the duplicate characters
        List<String> duplicateElements= Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicateElements);

        //print the duplicate characters
        List<String> uniqueElements= Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(uniqueElements);

        //first non-repeating character in given string
        String nonRepChar = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(s->s,LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()==1)
                .findFirst().get().getKey();

        nonRepChar = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(s->s,LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .reduce((a,b)-> a.getValue() == 1 ? a : b)
                .get().toString();
        System.out.println("First Non repeating character in "+str+" is = "+nonRepChar);

        //find the longest string in given array

        String[] strArr = new String[]{"nanu","vina","mahesh"};
//        String longestStr = Arrays.stream(strArr)
//                .sorted((a,b)->b.length()-a.length())
//                .findFirst().get();

        String longestStr = Arrays.stream(strArr)
                .reduce((a,b)->a.length()>b.length()?a:b)
                .get();

        System.out.println("Longest string in the given array is: "+longestStr+"\n");


        //Remove the whitespaces from the given string
        String str2 = "Mahesh is a good boy";

        str2 = str2.chars()
                        .filter(e->!Character.isWhitespace(e))
                                .mapToObj(e -> String.valueOf((char) e))
                                        .collect(Collectors.joining());
        System.out.println("Removing whitespaces by using stream api: +\n"+str2+"\n");


        //String joining

        List<String> lsStr = Arrays.asList("1","2","3","4");
        String joinedStr = lsStr.stream().collect(Collectors.joining("-"));
        //joinedStr = String.join("-",lsStr);
        System.out.println("String after joining is: "+joinedStr);
//        Make class immutable
//        Def:- immutable class means once we create a object of a class then we cannot update the data members of that class
//        The class must be declared as final so that child classes can’t be created.
//        Data members in the class must be declared private so that direct access is not allowed.
//        Data members in the class must be declared as final so that we can’t change the value of it after object creation.
//        A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
//        Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)
//        Note: There should be no setters or in simpler terms, there should be no option to change the value of the instance variable.
//        Deep copy in constructor is necessary for mutable object because if we update the mutable object afterwards
//        the same changes will be replicated int the mutable data member of that class
        final class immutableClass{
            private final int tmp;
            private final HashSet<Integer> ht;
            public HashSet<Integer> getHt() {
                HashSet<Integer> copyOfHt = new HashSet<>();
                for(int i:ht){
                    copyOfHt.add(i);
                }
                return copyOfHt;
            }
            public int getTmp() {
                return tmp;
            }
            public immutableClass(int tmp, HashSet<Integer> ht){
                this.tmp = tmp;
                HashSet<Integer> tmpHt = new HashSet<>();
                for(int i:ht){
                    tmpHt.add(i);
                }
                this.ht = tmpHt;
            }

        }

        HashSet<Integer> ht = new HashSet<>();
        ht.add(1);ht.add(2);
        immutableClass obj1 = new immutableClass(10,ht);

        ht.add(3);// will not update in obj1
        System.out.println("Immutable class implementation :-\n");
        System.out.println("obj1.tmp = "+obj1.getTmp());
        System.out.println("obj1 set size = "+obj1.getHt().size());


//        Diff between comparable and comparator
//        Comparable -> overrides compareTo() methode,
//                      sorting on only one field,
//                      need to define while creating class
//        Comparator -> overrides compare() methode,
//                      sorting can be done on multiple fields,
//                      no need to define while creating class

//        Diff bet StringBuilder and StringBuffer
//        StringBuilder -> Thread unsafe/asynchronous,
//                         faster than StringBuffer due to asynchronous nature
//        StringBuffer -> Thread safe/synchronous,
//                         slower than StringBuilder

    }
}