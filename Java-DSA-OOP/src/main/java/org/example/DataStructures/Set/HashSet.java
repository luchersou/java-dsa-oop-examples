package org.example.DataStructures.Set;

public class HashSet {
    // Creating a HashSet of strings
    HashSet<String> countries = new HashSet<>();

        System.out.println("==== Demonstrating HashSet specific methods not available in Set interface ====\n");

    // Adding elements to the HashSet
        countries.add("USA");
        countries.add("Brazil");
        countries.add("India");
        countries.add("Japan");
        countries.add("Germany");

        System.out.println("Initial HashSet: " + countries);

    // 1. clone() - Creates a shallow copy of this HashSet instance
        System.out.println("\n1. clone() method:");
    @SuppressWarnings("unchecked")
    HashSet<String> clonedCountries = (HashSet<String>) countries.clone();
        System.out.println("Original HashSet: " + countries);
        System.out.println("Cloned HashSet: " + clonedCountries);

    // Let's modify the clone to show they are independent
        clonedCountries.add("France");
        System.out.println("\nAfter adding 'France' to the clone:");
        System.out.println("Original HashSet: " + countries);
        System.out.println("Modified clone: " + clonedCountries);

    // 2. Constructors specific to HashSet
        System.out.println("\n2. HashSet specific constructors:");

    // 2.1 Constructor with initial capacity
    HashSet<String> countriesWithCapacity = new HashSet<>(20); // initial capacity of 20
        System.out.println("Created HashSet with initial capacity of 20");

    // 2.2 Constructor with initial capacity and load factor
    HashSet<String> countriesWithLoadFactor = new HashSet<>(20, 0.6f); // capacity 20, load factor 0.6
        System.out.println("Created HashSet with initial capacity of 20 and load factor of 0.6");
    // Load factor determines when the set will be resized (default is 0.75)

    // 2.3 Constructor that creates a set containing the elements of another collection
    HashSet<String> countriesCopy = new HashSet<>(countries);
        System.out.println("HashSet created from another collection: " + countriesCopy);

    // 3. removeIf() - Removes all elements that satisfy the given predicate
    // While technically available from Collection, it's worth showing as it's very useful with sets
        System.out.println("\n3. removeIf() method:");
        System.out.println("Before removeIf(): " + clonedCountries);
    boolean removed = clonedCountries.removeIf(country -> country.length() <= 5); // Remove countries with names of 5 chars or less
        System.out.println("Removed countries with names of 5 chars or less: " + removed);
        System.out.println("After removeIf(): " + clonedCountries);

    // 4. Methods inherited from AbstractCollection but worth demonstrating
        System.out.println("\n4. Notable methods inherited from AbstractCollection:");

    // 4.1 toArray() - different implementations but available in Set
    String[] countriesArray = countries.toArray(new String[0]);
        System.out.println("HashSet converted to array: " + java.util.Arrays.toString(countriesArray));

    // 5. HashSet-specific behavior demonstration
        System.out.println("\n5. HashSet-specific behavior (doesn't allow duplicates):");
        System.out.println("HashSet before adding duplicate: " + countries);
    boolean added = countries.add("USA"); // Trying to add a duplicate
        System.out.println("Result of adding duplicate 'USA': " + added);
        System.out.println("HashSet after attempting to add duplicate: " + countries);

    // 6. Performance characteristics (demonstration)
        System.out.println("\n6. HashSet performance characteristics demonstration:");

    // Create larger set for performance demonstration
    HashSet<Integer> numbers = new HashSet<>();
    final int COUNT = 100000;

    // Measure time to add elements
    long startTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
        numbers.add(i);
    }
    long endTime = System.nanoTime();
        System.out.println("Time taken to add " + COUNT + " elements: " +
            ((endTime - startTime) / 1000000) + " ms");

    // Measure time for lookups (a HashSet's strength)
    startTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
        numbers.contains(i);
    }
    endTime = System.nanoTime();
        System.out.println("Time taken for " + COUNT + " lookups: " +
            ((endTime - startTime) / 1000000) + " ms");

    // 7. Exploring iterators
        System.out.println("\n7. Iterator behavior with HashSet:");

    // Demonstrating that HashSet doesn't guarantee iteration order
    HashSet<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Purple");

        System.out.println("HashSet of colors: " + colors);
        System.out.println("Note that the iteration order may differ from insertion order:");

    Iterator<String> iterator = colors.iterator();
        System.out.println("Elements through iterator:");
        while (iterator.hasNext()) {
        System.out.println("  - " + iterator.next());
    }

    // 8. Spliterator demonstration
        System.out.println("\n8. Spliterator characteristics:");
    Spliterator<String> spliterator = colors.spliterator();
        System.out.println("Spliterator characteristics: " + spliterator.characteristics());

    // Create a new set for testing
    HashSet<String> newSet = new HashSet<>();
        System.out.println("\nEmpty HashSet: " + newSet);
        System.out.println("HashSet.isEmpty(): " + newSet.isEmpty());
}
/*

Additional Methods Available with HashSet<String> HashSet = new HashSet<>();, not available with the Set interface:

clone() – Creates and returns a shallow copy of this HashSet.
spliterator() – Creates a late-binding and fail-fast Spliterator over the elements in this set.
removeIf(Predicate<? super String> filter) – Removes all elements of the set that satisfy the given predicate.
stream() – Returns a sequential Stream with the set as its source.
parallelStream() – Returns a possibly parallel Stream with the set as its source.
equals(Object o) – Indicates whether some other object is "equal to" this set (inherited from Object, but behaves meaningfully in HashSet).
hashCode() – Returns the hash code value for the set (used when stored in hash-based collections).
toString() – Returns a string representation of the set.

*/