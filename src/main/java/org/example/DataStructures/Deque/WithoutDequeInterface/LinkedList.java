package org.example.DataStructures.Deque.WithoutDequeInterface;

public class LinkedList {
    // Both declarations provide identical method access
    LinkedList<String> concreteList = new LinkedList<>();

    // 1. Double-ended operations
        concreteList.addFirst("Front");
        interfaceDeque.addFirst("Front");

    // 2. Stack operations
        concreteList.push("StackItem");
        interfaceDeque.push("StackItem");

    // 3. Queue operations
        concreteList.offer("End");
        interfaceDeque.offer("End");

    // 4. Inspection methods
    String first1 = concreteList.peekFirst();
    String first2 = interfaceDeque.peekFirst();

    // 5. Removal methods
    String last1 = concreteList.pollLast();
    String last2 = interfaceDeque.pollLast();
}

/*

There are NO METHODS in LinkedList<String> that are inaccessible through Deque<String> reference. This is because:

LinkedList fully implements the Deque interface

All public methods of LinkedList are either:
-Declared in Deque interface
-Inherited from AbstractSequentialList
-Implementations of List methods

*/
