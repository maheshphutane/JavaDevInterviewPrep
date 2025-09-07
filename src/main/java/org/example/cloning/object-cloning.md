# Object Cloning in Java

Object cloning in Java is the process of creating an exact copy of an object. It is typically achieved using the `clone()` method provided by the `Object` class. To enable cloning, a class must implement the `Cloneable` interface and override the `clone()` method.

## Types of Object Cloning

### 1. Shallow Cloning
- Creates a copy of the object but does not clone the objects referenced by it.
- Changes to the referenced objects in the cloned object will reflect in the original object.

### 2. Deep Cloning
- Creates a copy of the object and also clones the objects referenced by it.
- Changes to the referenced objects in the cloned object will not affect the original object.

## Examples

### Shallow Cloning
```java
class Address {
    String city;

    public Address(String city) {
        this.city = city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }
}

public class ShallowCloningExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Person person1 = new Person("John", address);

        // Shallow cloning
        Person person2 = (Person) person1.clone();

        System.out.println("Before modification:");
        System.out.println("Person1 Address: " + person1.address.city);
        System.out.println("Person2 Address: " + person2.address.city);

        // Modifying the address in person2
        person2.address.city = "Los Angeles";

        System.out.println("After modification:");
        System.out.println("Person1 Address: " + person1.address.city); // Reflects change
        System.out.println("Person2 Address: " + person2.address.city);
    }
}
```
### Deap Cloning
```java
class Address implements Cloneable {
    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Deep copy of Address
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) address.clone(); // Deep copy of Address
        return cloned;
    }
}

public class DeepCloningExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("New York");
        Person person1 = new Person("John", address);

        // Deep cloning
        Person person2 = (Person) person1.clone();

        System.out.println("Before modification:");
        System.out.println("Person1 Address: " + person1.address.city);
        System.out.println("Person2 Address: " + person2.address.city);

        // Modifying the address in person2
        person2.address.city = "Los Angeles";

        System.out.println("After modification:");
        System.out.println("Person1 Address: " + person1.address.city); // No change
        System.out.println("Person2 Address: " + person2.address.city);
    }
}
```