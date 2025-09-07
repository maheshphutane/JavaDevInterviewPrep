# Java Memory Types

- **Heap Memory**
    - Stores objects and JRE classes.
    - Divided into Young Generation, Old Generation, and Permanent Generation.
    - Managed by the Garbage Collector.
    - Heap Memory
      ├── Young Generation
      │   ├── Eden Space
      │   ├── Survivor Space 0 (S0)
      │   └── Survivor Space 1 (S1)
      └── Old Generation (Tenured Generation)

- **Stack Memory**
    - Stores method-specific values and references to objects in the heap.
    - Each thread has its own stack.
    - Memory is automatically allocated and deallocated.

- **Metaspace**
    - Stores class metadata.
    - Introduced in Java 8, replacing the Permanent Generation.
    - Grows automatically as needed.(unlike permGen which was fixed in size)
    - it is generally used to store class level information e.x: className, method signature,
      constructor static methods/collection
    - it is not a part of heap memory
      

- **Program Counter (PC) Register**
    - Stores the address of the current instruction being executed.
    - Each thread has its own PC register.