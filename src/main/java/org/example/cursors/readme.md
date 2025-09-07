# Summary of Cursors in Java

## 1. Enumeration
- **Applicable To**: Legacy classes like `Vector`, `Stack`, and `Hashtable`.
- **Direction**: Forward only.
- **Operations**: Read-only (cannot modify the collection).
- **Methods**:
    - `hasMoreElements()`: Checks if more elements are available.
    - `nextElement()`: Retrieves the next element.

---

## 2. Iterator
- **Applicable To**: All `Collection` classes (e.g., `List`, `Set`, `Queue`).
- **Direction**: Forward only.
- **Operations**: Read and remove elements.
- **Methods**:
    - `hasNext()`: Checks if more elements are available.
    - `next()`: Retrieves the next element.
    - `remove()`: Removes the current element.

---

## 3. ListIterator
- **Applicable To**: Only `List`-implementing classes (e.g., `ArrayList`, `LinkedList`).
- **Direction**: Forward and backward.
- **Operations**: Read, remove, add, and update elements.
- **Methods**:
    - `hasNext()`, `next()`: Forward traversal.
    - `hasPrevious()`, `previous()`: Backward traversal.
    - `add()`: Adds an element.
    - `set()`: Updates the current element.
    - `remove()`: Removes the current element.

---

## Summary Table

| **Cursor**      | **Applicable To**         | **Direction**       | **Operations**         | **Methods**                     |
|------------------|---------------------------|----------------------|-------------------------|----------------------------------|
| **Enumeration**  | Legacy classes           | Forward only         | Read                   | `hasMoreElements()`, `nextElement()` |
| **Iterator**     | All `Collection` classes | Forward only         | Read, Remove           | `hasNext()`, `next()`, `remove()` |
| **ListIterator** | `List` classes only      | Forward and Backward | Read, Remove, Add, Update | `hasNext()`, `next()`, `hasPrevious()`, `previous()`, `add()`, `set()`, `remove()` |

# Fail-Fast and Fail-Safe Iterators in Java

## 1. Fail-Fast Iterators
- **Definition**: Fail-Fast iterators immediately throw a `ConcurrentModificationException` if the collection is structurally modified while iterating, except through the iterator's own `remove()` method.
- **Behavior**:
  - Detects structural modifications (e.g., adding, removing, or updating elements) during iteration.
  - Operates directly on the collection.
- **Examples**: Iterators of `ArrayList`, `HashMap`, `HashSet`, etc.
- **Use Case**: Suitable for single-threaded environments or when structural modifications are not expected during iteration.
- **Example Code**:
  ```java
  import java.util.ArrayList;
  import java.util.Iterator;

  public class FailFastExample {
      public static void main(String[] args) {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(1);
          list.add(2);

          Iterator<Integer> iterator = list.iterator();
          while (iterator.hasNext()) {
              System.out.println(iterator.next());
              list.add(3); // Structural modification
          }
      }
  }
  // Output: ConcurrentModificationException
  ```

# Fail-Safe Iterators in Java

## 1. Fail-Safe Iterators
- **Definition**: Fail-Safe iterators do not throw `ConcurrentModificationException` if the collection is structurally modified during iteration.
- **Behavior**:
  - Operates on a **clone** or **snapshot** of the collection, so modifications do not affect the iterator.
  - Does not guarantee real-time consistency of the collection.
- **Examples**: Iterators of `CopyOnWriteArrayList`, `ConcurrentHashMap`, etc.
- **Use Case**: Suitable for multi-threaded environments where modifications to the collection are expected during iteration.
- **Example Code**:
  ```java
  import java.util.concurrent.CopyOnWriteArrayList;

  public class FailSafeExample {
      public static void main(String[] args) {
          CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
          list.add(1);
          list.add(2);

          for (Integer value : list) {
              System.out.println(value);
              list.add(3); // Structural modification
          }
          System.out.println(list); // Output includes all elements
      }
  }
    // Output: [1, 2, 3]
    ```