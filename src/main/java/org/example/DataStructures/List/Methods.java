package org.example.DataStructures.List;

public class Methods {

/*

# Main methods accessible by all of its implementations:

Implementations:
List<String> linkedList = new LinkedList<>();
List<String> arrayList = new ArrayList<>();
List<String> stack = new Stack<>();
List<String> vector = new Vector<>();



add(E e) – Adds an element to the end.
add(int index, E e) – Inserts an element at a specific index.
get(int index) – Retrieves an element by index.
set(int index, E e) – Replaces an element at a given index.
remove(int index) – Removes an element by index.
remove(Object o) – Removes the first occurrence of an object.
size() – Returns the number of elements.
isEmpty() – Checks if the list is empty.
clear() – Removes all elements.
contains(Object o) – Checks if an element exists.
indexOf(Object o) – Returns the first index of an element.
lastIndexOf(Object o) – Returns the last index of an element.
addAll(Collection<? extends E> c) – Adds all elements from another collection.
addAll(int index, Collection<? extends E> c) – Inserts all elements at a specific index.
removeAll(Collection<?> c) – Removes all elements present in another collection.
retainAll(Collection<?> c) – Keeps only elements present in another collection.
iterator() – Returns an iterator for looping.
listIterator() – Returns a list iterator (supports bidirectional traversal).
toArray() – Converts the list to an array.
subList(int fromIndex, int toIndex) – Returns a sublist.

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListMethodsExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        // ===== ADDITION METHODS =====
        System.out.println("=== ADDITION METHODS ===");
        list.add("Java");                    // Add at the end
        list.add("Python");
        list.add("JavaScript");
        list.add(1, "C++");                  // Add at position 1
        System.out.println("After additions: " + list);
        
        List<String> anotherList = Arrays.asList("Go", "Rust");
        list.addAll(anotherList);             // Add collection at the end
        list.addAll(2, Arrays.asList("C#", "Swift")); // Add collection at position 2
        System.out.println("After addAll: " + list);
        
        // ===== ACCESS METHODS =====
        System.out.println("\n=== ACCESS METHODS ===");
        System.out.println("Element at position 0: " + list.get(0));
        System.out.println("List size: " + list.size());
        System.out.println("List empty? " + list.isEmpty());
        System.out.println("Contains 'Java'? " + list.contains("Java"));
        System.out.println("Contains all from anotherList? " + list.containsAll(anotherList));
        
        // ===== SEARCH METHODS =====
        System.out.println("\n=== SEARCH METHODS ===");
        System.out.println("First index of 'Java': " + list.indexOf("Java"));
        System.out.println("Last index of 'Java': " + list.lastIndexOf("Java"));
        System.out.println("Index of 'Kotlin' (doesn't exist): " + list.indexOf("Kotlin"));
        
        // ===== MODIFICATION METHODS =====
        System.out.println("\n=== MODIFICATION METHODS ===");
        String replacedElement = list.set(0, "Kotlin"); // Replace element at position 0
        System.out.println("Replaced element: " + replacedElement);
        System.out.println("List after replacement: " + list);
        
        // ===== REMOVAL METHODS =====
        System.out.println("\n=== REMOVAL METHODS ===");
        String removedByIndex = list.remove(1);      // Remove by index
        System.out.println("Removed by index 1: " + removedByIndex);
        
        boolean removedByValue = list.remove("Swift"); // Remove by value
        System.out.println("'Swift' removed? " + removedByValue);
        System.out.println("List after removals: " + list);
        
        // ===== SUBLIST =====
        System.out.println("\n=== SUBLIST ===");
        List<String> sublist = list.subList(1, 4); // Elements from index 1 to 3
        System.out.println("Sublist (1-3): " + sublist);
        
        // ===== ARRAY CONVERSION =====
        System.out.println("\n=== ARRAY CONVERSION ===");
        Object[] array = list.toArray();
        System.out.println("Object array: " + Arrays.toString(array));
        
        String[] stringArray = list.toArray(new String[0]);
        System.out.println("String array: " + Arrays.toString(stringArray));
        
        // ===== ITERATION =====
        System.out.println("\n=== ITERATION ===");
        
        // Simple Iterator
        System.out.println("With Iterator:");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        
        // ListIterator (bidirectional)
        System.out.println("With ListIterator (reverse):");
        ListIterator<String> listIt = list.listIterator(list.size());
        while (listIt.hasPrevious()) {
            System.out.print(listIt.previous() + " ");
        }
        System.out.println();
        
        // Enhanced for loop
        System.out.println("With enhanced for:");
        for (String language : list) {
            System.out.print(language + " ");
        }
        System.out.println();
        
        // ===== JAVA 8+ METHODS =====
        System.out.println("\n=== JAVA 8+ METHODS ===");
        
        // forEach with Consumer
        System.out.println("With forEach:");
        list.forEach(language -> System.out.print(language.toUpperCase() + " "));
        System.out.println();
        
        // removeIf with Predicate
        List<String> listToRemove = new ArrayList<>(list);
        boolean removedSome = listToRemove.removeIf(s -> s.length() < 4);
        System.out.println("Removed elements with less than 4 chars? " + removedSome);
        System.out.println("List after removeIf: " + listToRemove);
        
        // replaceAll with UnaryOperator
        List<String> listToReplace = new ArrayList<>(list);
        listToReplace.replaceAll(String::toLowerCase);
        System.out.println("List after replaceAll (toLowerCase): " + listToReplace);
        
        // sort with Comparator
        List<String> listToSort = new ArrayList<>(list);
        listToSort.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Sorted list: " + listToSort);
        
        // Stream operations
        System.out.println("Languages that start with 'J':");
        list.stream()
             .filter(s -> s.startsWith("J"))
             .forEach(System.out::println);
        
        // ===== SET OPERATIONS =====
        System.out.println("\n=== SET OPERATIONS ===");
        List<String> list1 = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Python", "JavaScript", "Go"));
        
        // retainAll (intersection)
        List<String> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        System.out.println("Intersection: " + intersection);
        
        // removeAll (difference)
        List<String> difference = new ArrayList<>(list1);
        difference.removeAll(list2);
        System.out.println("Difference (list1 - list2): " + difference);
        
        // ===== SPECIAL LISTITERATOR METHODS =====
        System.out.println("\n=== SPECIAL LISTITERATOR METHODS ===");
        ListIterator<String> specialIt = list.listIterator();
        
        if (specialIt.hasNext()) {
            System.out.println("Next element: " + specialIt.next());
            System.out.println("Current index: " + specialIt.nextIndex());
            System.out.println("Previous index: " + specialIt.previousIndex());
            
            // Modification during iteration
            specialIt.set("MODIFIED"); // Replace current element
            specialIt.add("NEW");       // Add new element
        }
        System.out.println("List after ListIterator modifications: " + list);
        
        // ===== CLEANUP =====
        System.out.println("\n=== CLEANUP ===");
        List<String> listToClean = new ArrayList<>(list);
        listToClean.clear();
        System.out.println("List after clear(): " + listToClean);
        System.out.println("Is empty? " + listToClean.isEmpty());
    }
}

*/
}
