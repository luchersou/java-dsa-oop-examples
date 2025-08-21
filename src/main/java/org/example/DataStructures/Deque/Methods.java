package org.example.DataStructures.Deque;

public class Methods {

/*

Main methods accessible by all of its implementations:

Implementations:
Deque<String> arrayDeque = new ArrayDeque<>();
Deque<String> linkedList = new LinkedList<>();


addFirst(e)	Inserts at the front
addLast(e)	Inserts at the end (same as add(e))
offerFirst(e)	Inserts at the front (capacity-safe)
offerLast(e)	Inserts at the end (capacity-safe)
removeFirst()	Removes and returns front element
removeLast()	Removes and returns last element
pollFirst()	Removes front (returns null if empty)
pollLast()	Removes last (returns null if empty)
getFirst()	Returns front element (without removal)
getLast()	Returns last element (without removal)
peekFirst()	Returns front (or null if empty)
peekLast()	Returns last (or null if empty)
push(e)	Adds to front (like stack push)
pop()	Removes from front (like stack pop)
add(e)	Inserts at end (throws if full)
offer(e)	Inserts at end (capacity-safe)
remove()	Removes from front (throws if empty)
poll()	Removes from front (returns null)
element()	Returns front (throws if empty)
peek()	Returns front (or null)
descendingIterator()	Returns reverse-order iterator
size()	Current element count
isEmpty()	Checks if deque is empty
clear()	Removes all elements

import java.util.*;

public class DequeCompleteExamples {

    public static void main(String[] args) {
        demonstrateImplementationDifferences();
        demonstrateBasicMethods();
        demonstrateStackUsage();
        demonstrateQueueUsage();
        demonstrateSpecificUseCases();
        demonstratePerformanceNotes();
    }

    // ===== DIFFERENCES BETWEEN IMPLEMENTATIONS =====
    private static void demonstrateImplementationDifferences() {
        System.out.println("=== DIFFERENCES BETWEEN ARRAYDEQUE AND LINKEDLIST ===");

        // ArrayDeque - backed by resizable array (better performance, no nulls allowed)
        Deque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer("Banana");
        arrayDeque.offer("Apple");
        arrayDeque.offer("Orange");
        System.out.println("ArrayDeque (fast array-based, no nulls): " + arrayDeque);

        // LinkedList - backed by doubly-linked list (supports nulls, but slower for cache access)
        Deque<String> linkedList = new LinkedList<>();
        linkedList.offer("Banana");
        linkedList.offer("Apple");
        linkedList.offer("Orange");
        linkedList.offer(null); // LinkedList allows null
        System.out.println("LinkedList (linked nodes, allows null): " + linkedList);

        System.out.println();
    }

    // ===== BASIC METHODS =====
    private static void demonstrateBasicMethods() {
        System.out.println("=== BASIC METHODS OF DEQUE ===");

        Deque<Integer> deque = new ArrayDeque<>();

        // Insertion at both ends
        deque.offerFirst(10);
        deque.offerLast(20);
        deque.offerFirst(5);
        deque.offerLast(30);

        System.out.println("Deque after offers: " + deque); // [5, 10, 20, 30]

        // Access at both ends
        System.out.println("Peek First: " + deque.peekFirst()); // 5
        System.out.println("Peek Last: " + deque.peekLast());   // 30

        // Removal at both ends
        System.out.println("Poll First: " + deque.pollFirst()); // 5
        System.out.println("Poll Last: " + deque.pollLast());   // 30
        System.out.println("Deque after polls: " + deque);      // [10, 20]

        System.out.println();
    }

    // ===== STACK USAGE (LIFO) =====
    private static void demonstrateStackUsage() {
        System.out.println("=== DEQUE AS STACK (LIFO) ===");

        Deque<String> stack = new ArrayDeque<>();

        // Push elements (addFirst)
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Stack after pushes: " + stack); // [Third, Second, First]

        // Pop elements
        System.out.println("Pop: " + stack.pop()); // Third
        System.out.println("Peek: " + stack.peek()); // Second
        System.out.println("Stack after pop: " + stack);

        System.out.println();
    }

    // ===== QUEUE USAGE (FIFO) =====
    private static void demonstrateQueueUsage() {
        System.out.println("=== DEQUE AS QUEUE (FIFO) ===");

        Deque<String> queue = new LinkedList<>();

        // Enqueue (offerLast)
        queue.offer("Task1");
        queue.offer("Task2");
        queue.offer("Task3");

        System.out.println("Queue after offers: " + queue); // [Task1, Task2, Task3]

        // Dequeue (pollFirst)
        System.out.println("Poll: " + queue.poll()); // Task1
        System.out.println("Peek: " + queue.peek()); // Task2
        System.out.println("Queue after poll: " + queue);

        System.out.println();
    }

    // ===== SPECIFIC USE CASES =====
    private static void demonstrateSpecificUseCases() {
        System.out.println("=== SPECIFIC USE CASES ===");

        // Example 1: Palindrome Checker
        String word = "level";
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : word.toCharArray()) deque.offer(c);

        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Is 'level' a palindrome? " + isPalindrome);

        // Example 2: Undo/Redo
        Deque<String> actions = new ArrayDeque<>();
        actions.push("Typed A");
        actions.push("Typed B");
        actions.push("Typed C");

        System.out.println("Undo: " + actions.pop()); // Typed C
        System.out.println("Undo: " + actions.pop()); // Typed B
        System.out.println("Remaining actions: " + actions);

        System.out.println();
    }

    // ===== PERFORMANCE NOTES =====
    private static void demonstratePerformanceNotes() {
        System.out.println("=== PERFORMANCE NOTES ===");

        System.out.println("ArrayDeque:");
        System.out.println("- Backed by resizable array");
        System.out.println("- Faster for most use cases (better cache locality)");
        System.out.println("- Does NOT allow null elements");

        System.out.println("\nLinkedList:");
        System.out.println("- Backed by doubly-linked list");
        System.out.println("- Allows null elements");
        System.out.println("- More overhead (node objects + pointers)");

        System.out.println();
    }
}


*/
}
