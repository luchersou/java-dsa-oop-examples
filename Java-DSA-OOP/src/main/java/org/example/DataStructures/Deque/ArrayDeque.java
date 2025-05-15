package org.example.DataStructures.Deque;

public class ArrayDeque {
    ArrayDeque<String> arrayDeque = new ArrayDeque<>();

    // ==== Exclusive to ArrayDeque/Deque (NOT in Queue) ====

    // 1. Double-ended insertion
        arrayDeque.addFirst("Front");  // Add to head
        arrayDeque.addLast("End");     // Add to tail (same as queue.add())

    // 2. Double-ended removal
    String first = arrayDeque.removeFirst();  // Remove from head
    String last = arrayDeque.removeLast();    // Remove from tail

    // 3. Stack operations
        arrayDeque.push("StackItem");  // LIFO push (add to head)
    String popped = arrayDeque.pop();  // LIFO pop (remove from head)

    // 4. Double-ended peeking
    String head = arrayDeque.peekFirst();  // View head
    String tail = arrayDeque.peekLast();   // View tail

    // 5. Descending iteration
        System.out.println("Reverse order:");
        arrayDeque.descendingIterator().forEachRemaining(System.out::println);
}

/*

There are no methods in ArrayDeque<String> that are inaccessible when using Deque<String> as the reference type. This is because:

ArrayDeque fully implements the Deque interface

All public methods of ArrayDeque are either:
-Declared in Deque interface
-Inherited from AbstractCollection
-Overridden implementations of Deque methods

*/
