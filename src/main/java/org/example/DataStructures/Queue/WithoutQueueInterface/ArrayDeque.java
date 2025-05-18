package org.example.DataStructures.Queue.WithoutQueueInterface;

public class ArrayDeque {
    ArrayDeque<String> arrayDeque = new ArrayDeque<>();

    // Add elements
        arrayDeque.add("Middle");

    // (A) Add/remove from both ends
        arrayDeque.addFirst("First");    // [First, Middle]
        arrayDeque.addLast("Last");      // [First, Middle, Last]

    // (B) Get elements from both ends without removal
        System.out.println("First element: " + arrayDeque.getFirst());
        System.out.println("Last element: " + arrayDeque.getLast());

    // (C) Remove from both ends
        System.out.println("Removed first: " + arrayDeque.removeFirst());
        System.out.println("Removed last: " + arrayDeque.removeLast());

    // (D) Stack operations
        arrayDeque.push("StackItem");    // [StackItem, Middle]
        System.out.println("Popped: " + arrayDeque.pop());  // StackItem

    // (E) Peek at both ends
        System.out.println("Peek first: " + arrayDeque.peekFirst());
        System.out.println("Peek last: " + arrayDeque.peekLast());
}

/*

Additional Methods Available with ArrayDeque<String> = new ArrayDeque<>();, not available with the Queue interface:

addFirst(E e)	Inserts element at front
addLast(E e)	Inserts element at end
getFirst()	Retrieves first element
getLast()	Retrieves last element
removeFirst()	Removes and returns first element
removeLast()	Removes and returns last element
peekFirst()	Retrieves first element without removal
peekLast()	Retrieves last element without removal
push(E e)	Stack operation (adds to front)
pop()	Stack operation (removes from front)
descendingIterator()	Returns reverse order iterator

*/