package org.example.DataStructures.Queue;

public class PriorityQueue {
    PriorityQueue<String> priorityQueue = new PriorityQueue<>();

    // Add elements (will be ordered automatically)
        priorityQueue.add("Banana");
        priorityQueue.add("Apple");
        priorityQueue.add("Orange");
        priorityQueue.add("Mango");

    // ==== 1. PriorityQueue-Specific Methods (Not in Queue) ====

    // (A) Access the comparator
    Comparator<? super String> comparator = priorityQueue.comparator();
        System.out.println("Comparator: " + comparator); // null (natural ordering)

    // (B) Bulk remove while processing (Java 8+)
        System.out.println("\nRemoving all fruits starting with 'A':");
        priorityQueue.removeIf(fruit -> fruit.startsWith("A"));
        System.out.println("Queue after removal: " + priorityQueue);

    // (C) Create from another PriorityQueue (preserves comparator)
    PriorityQueue<String> anotherQueue = new PriorityQueue<>(priorityQueue);
        System.out.println("\nCopied queue: " + anotherQueue);
}

/*

Additional Methods Available with PriorityQueue<String> PriorityQueue = new PriorityQueue<>();, not available with the Queue interface:

comparator()	Returns the comparator used for ordering (null if natural order)
removeIf(Predicate)	Bulk removal based on condition (from Collection interface but often used with PQ)
PriorityQueue(PriorityQueue)	Special constructor that copies comparator
PriorityQueue(PriorityQueue<? extends E> c)	Creates a PQ with the same comparator and elements
PriorityQueue(SortedSet<? extends E> c)	Creates a PQ from a sorted set (inherits comparator)

*/
