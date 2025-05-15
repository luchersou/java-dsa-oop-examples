package org.example.DataStructures.Queue;

public class LinkedList {
    // Using concrete type (LinkedList) - has all methods
    LinkedList<String> linkedList = new LinkedList<>();

    // Add elements
        linkedList.add("First");
        linkedList.add("Middle");
        linkedList.add("Last");

    // ==== 1. LinkedList-Specific Deque Methods (Not in Queue) ====

    // (A) Add/remove from both ends
        linkedList.addFirst("New First");  // [New First, First, Middle, Last]
        linkedList.addLast("New Last");    // [New First, First, Middle, Last, New Last]

    // (B) Get elements from both ends without removal
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());

    // (C) Remove from both ends
        System.out.println("Removed first: " + linkedList.removeFirst());
        System.out.println("Removed last: " + linkedList.removeLast());

    // (D) Push/pop (stack operations)
        linkedList.push("Stack Item");    // Adds to head [Stack Item, First, Middle, Last]
        System.out.println("Popped: " + linkedList.pop());  // Removes from head

    // (E) Peek at both ends
        System.out.println("Peek first: " + linkedList.peekFirst());
        System.out.println("Peek last: " + linkedList.peekLast());
}

/*

Additional Methods Available with LinkedList<String> linkedList = new LinkedList<>();, not available with the Queue interface:

add(int index, E element)	Inserts element at specified position
addAll(int index, Collection<? extends E> c)	Inserts collection at position
get(int index)	Returns element by position
set(int index, E element)	Replaces element at position
remove(int index)	Removes element by position
indexOf(Object o)	Returns first occurrence index
lastIndexOf(Object o)	Returns last occurrence index
listIterator()	Returns bidirectional iterator
listIterator(int index)	Returns iterator starting at position
subList(int fromIndex, int toIndex)	Returns view of portion of list
addFirst(E e)	Inserts at head (equivalent to push)
addLast(E e)	Inserts at tail (equivalent to add)
removeFirst()	Removes head element
removeLast()	Removes tail element
getFirst()	Returns head without removal
getLast()	Returns tail without removal
peekFirst()	Retrieves head (null if empty)
peekLast()	Retrieves tail (null if empty)
descendingIterator()	Returns reverse-order iterator
push(E e)	Adds element to head (stack push)
pop()	Removes head element (stack pop)
removeFirstOccurrence(Object o)	Removes first matching element
removeLastOccurrence(Object o)	Removes last matching element

*/