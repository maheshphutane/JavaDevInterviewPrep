1. Features in Java 8, 11, and 17:
    Java 8 Features (Released in March 2014):
        Lambda Expressions: Enables functional programming by allowing you to pass behavior as a parameter.
        Stream API: Provides a functional approach to process collections.
        Default Methods: Allows interfaces to have methods with default implementations.
            interface MyInterface {
                default void show() {
                    System.out.println("Default Method");
                }
            }
        Optional Class: Helps avoid NullPointerException.
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("Default Name"));
        Date and Time API: Introduced java.time package for better date and time handling.
        LocalDate date = LocalDate.now();
        System.out.println(date);
        Functional Interfaces: Predefined interfaces like Predicate, Function, Consumer, etc.


    Java 11 Features (Released in September 2018):
        Local-Variable Syntax for Lambda Parameters:
        var list = List.of(1, 2, 3);
        list.forEach((var n) -> System.out.println(n));
        String Methods:
        isBlank(), lines(), strip(), repeat().
        String str = " Hello ";
        System.out.println(str.strip()); // Removes leading and trailing spaces
        HTTP Client API: Standardized java.net.http for HTTP requests.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        File Methods: readString() and writeString() in Files.
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "Hello, World!");
        System.out.println(Files.readString(path));
        Launch Single-File Source Code: Run Java files directly without compilation.
        java HelloWorld.java

    Java 17 Features (Released in September 2021, LTS):
        Sealed Classes: Restricts which classes can extend a class.
        public sealed class Shape permits Circle, Rectangle {}
        public final class Circle extends Shape {}
        public final class Rectangle extends Shape {}
        Pattern Matching for switch:
        Object obj = 123;
        switch (obj) {
            case Integer i -> System.out.println("Integer: " + i);
            case String s -> System.out.println("String: " + s);
            default -> System.out.println("Unknown type");
        }
        Text Blocks: Multiline strings with better readability.
        String json = """
            {
                "name": "John",
                "age": 30
            }
            """;
        Enhanced NullPointerException: Provides detailed messages about null references.
        Removal of Deprecated Features: Removed RMI Activation, Applet API, etc.
        New Garbage Collectors: Improved ZGC and G1 GC performance.
        These features collectively enhance Java's performance, readability, and developer productivity.

2. StringBuffer vs StringBuilder:
    StringBuffer: Thread-safe (synchronized), slower due to synchronization.
    StringBuilder: Not thread-safe (unsynchronized), faster due to no synchronization.

3. Comparable vs Comparator
    Comparable:
        Used to define the natural ordering of objects.
        Implemented by the class whose objects need to be compared.
        Contains the compareTo() method.
        Example: String, Integer, etc.
        public class Employee implements Comparable<Employee> {
            private String name;
            private int age;
            public int compareTo(Employee other) {
                return this.name.compareTo(other.name);
            }
        }
    Comparator:
        Used to define custom ordering of objects.
        Implemented in a separate class or as an anonymous class.
        Contains the compare() method.
        Example: Custom sorting logic.
        public class EmployeeComparator implements Comparator<Employee> {
            public int compare(Employee e1, Employee e2) {
                return e1.age - e2.age;
            }
        }

4. Methode overriding exceptions

    Access Specifier → can be widened, not restricted.

    Return Type → can be covariant (subtype). (Object -> String allowed

    Exceptions → can be fewer or narrower checked exceptions.

5. Methode hiding:
    Static methode depends on the reference type not on the object type.
    (Hence the referencing class static methode will be called)
    Non-static methode depends on the object type
    (Hence the object class non-static methode will be called)

    class Parent {
        static void staticShow() {
            System.out.println("Parent static method");
        }
        void instanceShow() {
            System.out.println("Parent instance method");
        }
    }

    class Child extends Parent {
        static void staticShow() {
            System.out.println("Child static method");
        }
        @Override
        void instanceShow() {
            System.out.println("Child instance method");
        }
    }

    public class Test {
        public static void main(String[] args) {
            Parent p = new Parent();
            Parent pc = new Child();
            Child c = new Child();

            System.out.println("=== Static methods ===");
            p.staticShow();   // Parent static method
            pc.staticShow();  // Parent static method (method hiding → ref type)
            c.staticShow();   // Child static method

            System.out.println("\n=== Instance methods ===");
            p.instanceShow();   // Parent instance method
            pc.instanceShow();  // Child instance method (runtime polymorphism)
            c.instanceShow();   // Child instance method
        }
    }

6. try { return 3; }
    catch(Throwable e) { return 5; }
    finally { return 7; }

   Will it compile? What will it return? Is catching Throwable a good practice?
   ✔ Compiles successfully.
   ✔ Always returns 7. (try return is overridden by finally return)
   ❌ Catching Throwable is a bad practice; catch specific exceptions instead.
   (Throwable is superclass of all errors and exceptions)

