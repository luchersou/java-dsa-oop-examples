package org.example.DataStructures.List.WithoutListInterface;

public class LinkedList {
    // Using concrete type (LinkedList) - has all methods
    LinkedList<String> linkedList = new LinkedList<>();

    // Add elements
        linkedList.add("First");
        linkedList.add("Middle");
        linkedList.add("Last");

    // ==== 1. LinkedList-Specific Deque Methods (Not in List) ====

    // (A) Queue operations (FIFO)
        System.out.println("Queue operations:");
        System.out.println("Peek (head): " + linkedList.peek());  // First
        System.out.println("Poll (remove head): " + linkedList.poll());  // Removes "First"

    // (B) Stack operations (LIFO)
        System.out.println("\nStack operations:");
        linkedList.push("StackItem");  // Adds to head
        System.out.println("Pop: " + linkedList.pop());  // Removes from head

    // (C) Double-ended operations
        System.out.println("\nDouble-ended operations:");
        linkedList.addFirst("NewFirst");
        linkedList.addLast("NewLast");
        System.out.println("First: " + linkedList.getFirst());
        System.out.println("Last: " + linkedList.getLast());
        System.out.println("Remove first: " + linkedList.removeFirst());
        System.out.println("Remove last: " + linkedList.removeLast());

    // (D) Other Deque operations
        System.out.println("\nOther Deque operations:");
        System.out.println("Peek first: " + linkedList.peekFirst());
        System.out.println("Peek last: " + linkedList.peekLast());
}

/*

Additional Methods Available with LinkedList<String> = new LinkedList<>();, not available with the List interface:

peek()	Returns the head (first element) without removal → returns null if empty
poll()	Removes and returns the head → returns null if empty
element()	Returns the head (throws NoSuchElementException if empty)
remove()	Removes and returns the head (throws NoSuchElementException if empty)
push(E e)	Inserts an element at the head (like a stack)
pop()	Removes and returns the head (throws NoSuchElementException if empty)
addFirst(E e)	Inserts at the head
addLast(E e)	Inserts at the tail (same as add(E e))
removeFirst()	Removes and returns the head
removeLast()	Removes and returns the tail
getFirst()	Returns the head (throws exception if empty)
getLast()	Returns the tail (throws exception if empty)
peekFirst()	Returns the head (or null if empty)
peekLast()	Returns the tail (or null if empty)
descendingIterator()	Returns an iterator in reverse order
offer(E e)	Adds to the tail (same as add(E e))
offerFirst(E e)	Adds to the head
offerLast(E e)	Adds to the tail

*/

