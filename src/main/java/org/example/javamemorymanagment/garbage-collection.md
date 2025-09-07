# Garbage Collection in Java

Garbage Collection (GC) in Java is the process of automatically identifying and disposing of objects that are no longer needed by the application.
## Key Concepts

- **Heap Memory**: The area of memory where objects are allocated. It is divided into:
    - **Young Generation**: Where new objects are allocated.
        - **Eden Space**: Most new objects are allocated here.
        - **Survivor Spaces (S0 and S1)**: Objects that survive garbage collection in Eden are moved here.
    - **Old Generation (Tenured Generation)**: Long-lived objects that survive multiple garbage collection cycles in the Young Generation are moved here.
- **Metaspace**: Stores class metadata. It is not part of the heap memory.

## Garbage Collection Process

- **Minor GC**: Occurs in the Young Generation. It is fast and frequent. It collects garbage from the Eden space and moves surviving objects to the survivor spaces.
- **Major GC (Full GC)**: Occurs in the Old Generation. It is less frequent but more time-consuming. It collects garbage from both the Young and Old Generations.

## Garbage Collection Algorithms

- **Serial GC**: Uses a single thread for garbage collection. Suitable for small applications.
- **Parallel GC**: Uses multiple threads for garbage collection. Suitable for multi-threaded applications.
- **CMS (Concurrent Mark-Sweep) GC**: Aims to minimize pause times by performing most of the garbage collection work concurrently with the application threads.
- **G1 (Garbage-First) GC**: Divides the heap into regions and prioritizes garbage collection in regions with the most garbage.

## Triggers for Garbage Collection

- **Memory Thresholds**: The JVM monitors heap memory usage and triggers garbage collection when usage reaches certain thresholds.
- **Allocation Failure**: When the JVM cannot allocate memory for a new object, it triggers garbage collection to reclaim memory.
- **Explicit Requests**: The application can request garbage collection by calling `System.gc()`, although this is only a suggestion to the JVM.

## Adaptive Tuning

Some garbage collectors, like G1 GC, use adaptive algorithms to adjust their behavior based on the application's memory usage patterns and performance goals.

### Java 8 and Before:
- Default GC: Parallel GC (for throughput).
- Other GCs: Serial GC, CMS GC.
### Later than Java 8 (Java 9 and beyond):
- Default GC: G1 GC.
- Other GCs: ZGC, Shenandoah GC (for low-latency).

## Summary

Garbage collection in Java is a crucial process for memory management, helping to automatically reclaim memory and optimize application performance. The JVM uses various algorithms and strategies to efficiently manage this process.