package org.example.DataStructures.Queue;

public class Methods {

/*

Main methods accessible by all of its implementations:

Implementations:
Queue<String> arrayDeque = new ArrayDeque<>();
Queue<String> linkedList = new LinkedList<>();
PriorityQueue<String> priorityQueue = new PriorityQueue<>();

offer(E e)	Inserts element, returns true if successful
add(E e)	Inserts element
poll()	Removes and returns head element
remove()	Removes and returns head element
peek()	Retrieves but doesn't remove head
element()	Retrieves but doesn't remove head

import java.util.*;
import java.util.concurrent.*;

public class QueueCompleteExamples {

    public static void main(String[] args) {
        demonstrateImplementationDifferences();
        demonstrateBasicMethods();
        demonstratePriorityBehavior();
        demonstrateDequeUsage();
        demonstrateSpecificUseCases();
        demonstrateConcurrency();
    }

    // ===== DIFFERENCES BETWEEN IMPLEMENTATIONS =====
    private static void demonstrateImplementationDifferences() {
        System.out.println("=== DIFFERENCES BETWEEN IMPLEMENTATIONS ===");

        // LinkedList - preserves insertion order, allows null, FIFO
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.offer("Banana");
        linkedListQueue.offer("Apple");
        linkedListQueue.offer("Orange");
        System.out.println("LinkedList Queue (insertion order): " + linkedListQueue);

        // PriorityQueue - orders elements by natural order (or comparator), no nulls
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("Banana");
        priorityQueue.offer("Apple");
        priorityQueue.offer("Orange");
        System.out.println("PriorityQueue (natural order): " + priorityQueue);

        // ArrayDeque - double-ended queue (fast insert/remove at both ends), no nulls
        Deque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer("Banana");
        arrayDeque.offer("Apple");
        arrayDeque.offer("Orange");
        System.out.println("ArrayDeque (insertion order): " + arrayDeque);

        // ConcurrentLinkedQueue - thread-safe, non-blocking, FIFO
        Queue<String> concurrentQueue = new ConcurrentLinkedQueue<>();
        concurrentQueue.offer("Banana");
        concurrentQueue.offer("Apple");
        concurrentQueue.offer("Orange");
        System.out.println("ConcurrentLinkedQueue (thread-safe, FIFO): " + concurrentQueue);

        System.out.println();
    }

    // ===== BASIC METHODS =====
    private static void demonstrateBasicMethods() {
        System.out.println("=== BASIC METHODS OF QUEUE ===");

        Queue<Integer> queue = new LinkedList<>();

        // ===== INSERTION =====
        System.out.println("--- Insertion Methods ---");
        queue.add(10);  // add throws exception if full
        queue.offer(20); // offer returns false if full (safer)
        queue.offer(30);

        System.out.println("Queue after insertion: " + queue);

        // ===== ACCESS =====
        System.out.println("\n--- Access Methods ---");
        System.out.println("Peek (head, no removal): " + queue.peek()); // 10
        System.out.println("Element (head, exception if empty): " + queue.element()); // 10

        // ===== REMOVAL =====
        System.out.println("\n--- Removal Methods ---");
        System.out.println("Poll (head, removes or null if empty): " + queue.poll()); // 10
        System.out.println("Remove (head, removes or exception if empty): " + queue.remove()); // 20
        System.out.println("Queue after removals: " + queue);

        System.out.println();
    }

    // ===== PRIORITY BEHAVIOR =====
    private static void demonstratePriorityBehavior() {
        System.out.println("=== PRIORITY QUEUE BEHAVIOR ===");

        Queue<Integer> priorityQueue = new PriorityQueue<>(); // Min-heap by default
        priorityQueue.offer(50);
        priorityQueue.offer(20);
        priorityQueue.offer(40);
        priorityQueue.offer(10);

        System.out.println("PriorityQueue contents: " + priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.println("Polling: " + priorityQueue.poll()); // returns in ascending order
        }

        System.out.println();
    }

    // ===== DEQUE USAGE =====
    private static void demonstrateDequeUsage() {
        System.out.println("=== DEQUE USAGE (ARRAYDEQUE) ===");

        Deque<String> deque = new ArrayDeque<>();

        // Insert at both ends
        deque.offerFirst("Front1");
        deque.offerLast("Back1");
        deque.offerFirst("Front2");
        deque.offerLast("Back2");

        System.out.println("Deque after offers: " + deque);

        // Access both ends
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        // Remove from both ends
        System.out.println("Poll First: " + deque.pollFirst());
        System.out.println("Poll Last: " + deque.pollLast());
        System.out.println("Deque after polls: " + deque);

        System.out.println();
    }

    // ===== SPECIFIC USE CASES =====
    private static void demonstrateSpecificUseCases() {
        System.out.println("=== SPECIFIC USE CASES ===");

        // Example 1: BFS (Breadth-First Search) simulation
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.offer("Start");
        bfsQueue.offer("Node1");
        bfsQueue.offer("Node2");

        while (!bfsQueue.isEmpty()) {
            String node = bfsQueue.poll();
            System.out.println("Processing node: " + node);
        }

        // Example 2: Undo/Redo with Deque
        Deque<String> actions = new ArrayDeque<>();
        actions.push("Open File"); // push = addFirst
        actions.push("Edit File");
        actions.push("Save File");

        System.out.println("Undo: " + actions.pop()); // Save File
        System.out.println("Undo: " + actions.pop()); // Edit File

        System.out.println();
    }

    // ===== CONCURRENCY =====
    private static void demonstrateConcurrency() {
        System.out.println("=== CONCURRENCY QUEUES ===");

        // BlockingQueue - thread-safe, can wait if empty/full
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);

        try {
            blockingQueue.put("Task1");
            blockingQueue.put("Task2");
            System.out.println("BlockingQueue after put: " + blockingQueue);

            // This would block until space is available
            // blockingQueue.put("Task3");

            String task = blockingQueue.take();
            System.out.println("Took from BlockingQueue: " + task);
            System.out.println("BlockingQueue after take: " + blockingQueue);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}


*/
}
