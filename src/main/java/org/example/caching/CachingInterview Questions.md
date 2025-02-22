# Caching Interview Questions

## What is Caching?
Caching is a technique used to store frequently accessed data in memory to improve application performance by reducing database queries or expensive computations.

## Types of Caching in Java
1. **In-Memory Caching**: Stores data in RAM for fast access.
2. **Distributed Caching**: Shared cache across multiple instances of an application.
3. **Persistent Caching**: Stores data on disk or database to retain it across restarts.

## Caching Strategies
### Least Recently Used (LRU)
- Removes the least recently accessed items when the cache is full.
- **Example**: `LinkedHashMap` with access order enabled.

### Least Frequently Used (LFU)
- Removes the least frequently accessed items.
- **Example**: Guava Cache with eviction policies.

### First-In-First-Out (FIFO)
- Evicts the oldest cached entry first.
- **Example**: Simple queue-based caching.

### Time-To-Live (TTL)
- Items expire after a fixed time.
- **Example**: Ehcache with expiration policies.

### Write-Through Caching
- Data is written to both the cache and database simultaneously.
- Ensures data consistency but adds latency.

### Write-Behind (Write-Back) Caching
- Data is written to the cache first and later persisted to the database asynchronously.
- Improves performance but may risk data loss if the system crashes.

### Cache-Aside (Lazy Loading)
- Data is loaded into the cache only when requested.
- If not found, fetch from DB and store in cache.
- **Example**: Redis, Memcached.

### Read-Through Caching
- The cache itself fetches data from the database when a cache miss occurs.
- Used in frameworks like Ehcache and Hazelcast.