package org.example.DataStructures.List.WithoutListInterface;

public class Stack {
    // Creating a Stack of strings
    Stack<String> bookStack = new Stack<>();

        System.out.println("==== Demonstrating Stack specific methods not available in List interface ====\n");

    // Adding elements to the Stack using push() method
        System.out.println("1. push() method:");
        bookStack.push("Book 1: Harry Potter");
        System.out.println("After push: " + bookStack);
        bookStack.push("Book 2: Lord of the Rings");
        System.out.println("After push: " + bookStack);
        bookStack.push("Book 3: Game of Thrones");
        System.out.println("After push: " + bookStack);

    // 2. pop() - Removes and returns the top element
        System.out.println("\n2. pop() method:");
        System.out.println("Current stack: " + bookStack);
    String removedBook = bookStack.pop();
        System.out.println("Popped element: " + removedBook);
        System.out.println("Stack after pop(): " + bookStack);

    // 3. peek() - Returns the top element without removing it
        System.out.println("\n3. peek() method:");
    String topBook = bookStack.peek();
        System.out.println("Current stack: " + bookStack);
        System.out.println("Peeked element (top of stack): " + topBook);
        System.out.println("Stack after peek() (unchanged): " + bookStack);

    // 4. empty() - Checks if the stack is empty
        System.out.println("\n4. empty() method:");
        System.out.println("Is stack empty? " + bookStack.empty());

    // 5. search() - Returns the 1-based position of an element from the top
        System.out.println("\n5. search() method:");
    int position = bookStack.search("Book 1: Harry Potter");
        System.out.println("Position of 'Book 1: Harry Potter' from top: " + position);
    // Search for an element that doesn't exist
    position = bookStack.search("Book 4: Dune");
        System.out.println("Position of non-existent book: " + position + " (returns -1 if not found)");

    // Demonstrating exception handling with Stack methods
        System.out.println("\n6. Exception handling with Stack methods:");
        try {
        // Pop all elements
        while (!bookStack.empty()) {
            System.out.println("Popping: " + bookStack.pop());
        }

        // Stack is now empty, trying to pop will cause EmptyStackException
        System.out.println("Trying to pop from empty stack...");
        bookStack.pop(); // This will throw EmptyStackException
    } catch (EmptyStackException e) {
        System.out.println("EmptyStackException caught: Cannot pop from an empty stack!");
    }

    // Similarly, peek() will also throw EmptyStackException on empty stack
        try {
        System.out.println("Trying to peek from empty stack...");
        bookStack.peek(); // This will throw EmptyStackException
    } catch (EmptyStackException e) {
        System.out.println("EmptyStackException caught: Cannot peek from an empty stack!");
    }
}

/*

# The modern recommendation is to completely avoid Stack (even
# when declared as Stack<String>) and use Deque<String> with
# ArrayDeque for stacks.
#############
# IMPORTANT #
#############

Additional Methods Available with Stack<String> stack = new Stack<>();, not available with the List interface:

When using the concrete Stack type directly, you get stack-specific methods in addition to all the List and Vector methods:

push(E item) — Pushes an item onto the top of the stack.
pop() — Removes and returns the top element.
peek() — Returns the top element without removing it.
empty() — Checks if the stack is empty.
search(Object o) — Returns the 1-based position of an object on the stack (or -1 if not found).

*/

