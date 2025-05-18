package org.example.DataStructures.Set.WithoutSetInterface;

public class TreeSet {
    // Using concrete type (TreeSet) - has all methods
    TreeSet<String> treeSet = new TreeSet<>();

    // Add elements
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");
        treeSet.add("Mango");

    // ==== 1. TreeSet-Specific Methods (Not in Set) ====

    // (A) First and Last elements
        System.out.println("First element: " + treeSet.first()); // "Apple"
        System.out.println("Last element: " + treeSet.last());   // "Orange"

    // (B) HeadSet (elements < given value)
        System.out.println("\nHeadSet (before 'Mango'): " + treeSet.headSet("Mango")); // [Apple, Banana]

    // (C) TailSet (elements >= given value)
        System.out.println("TailSet (after 'Mango'): " + treeSet.tailSet("Mango")); // [Mango, Orange]

    // (D) SubSet (range between two values)
        System.out.println("SubSet (Banana-Orange): " + treeSet.subSet("Banana", "Orange")); // [Banana, Mango]

    // (E) Polling (retrieve and remove first/last)
        System.out.println("\nPollFirst: " + treeSet.pollFirst()); // Removes & returns "Apple"
        System.out.println("PollLast: " + treeSet.pollLast());     // Removes & returns "Orange"

    // (F) Descending Set (reverse order)
        System.out.println("\nDescending set: " + treeSet.descendingSet()); // [Mango, Banana]

    // (G) Comparator access (returns null if natural ordering)
    Comparator<? super String> comparator = treeSet.comparator();
        System.out.println("\nComparator: " + comparator); // null (natural ordering)
}

/*

Additional Methods Available with TreeSet<String> TreeSet = new TreeSet<>();, not available with the Set interface:

first() – Returns the lowest (first) element.
last() – Returns the highest (last) element.
ceiling(String e) – Returns the least element ≥ e, or null.
floor(String e) – Returns the greatest element ≤ e, or null.
higher(String e) – Returns the least element > e, or null.
lower(String e) – Returns the greatest element < e, or null.
headSet(String toElement) – Returns a view of elements strictly less than toElement.
tailSet(String fromElement) – Returns a view of elements ≥ fromElement.
subSet(String fromElement, String toElement) – Returns a view of elements in range.
descendingSet() – Returns a reverse-order view of the set.
pollFirst() – Removes and returns the first (lowest) element.
pollLast() – Removes and returns the last (highest) element.

*/
