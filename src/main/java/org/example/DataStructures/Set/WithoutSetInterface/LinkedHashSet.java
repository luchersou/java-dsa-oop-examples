package org.example.DataStructures.Set.WithoutSetInterface;

import java.util.Set;

public class LinkedHashSet {
    // Using concrete type - we get access to all LinkedHashSet methods
    LinkedHashSet<String> concreteSet = new LinkedHashSet<>();

    Set<String> interfaceSet = new LinkedHashSet<>();

    // 1. clone() - Only available with concrete type
    @SuppressWarnings("unchecked")
    LinkedHashSet<String> clonedSet = (LinkedHashSet<String>) concreteSet.clone();
        System.out.println("Cloned set: " + clonedSet);

    // 2. Spliterator characteristics check (more specific with concrete type)
    // While Set has spliterator(), we can be more specific about ordered nature
        System.out.println("\nSpliterator details:");
        System.out.println("Is ORDERED: " +
                concreteSet.spliterator().hasCharacteristics(java.util.Spliterator.ORDERED));
        System.out.println("Is SIZED: " +
                concreteSet.spliterator().hasCharacteristics(java.util.Spliterator.SIZED));

    // 3. Capacity methods (implementation specific)
        System.out.println("\nImplementation-specific methods:");
    printCapacityInfo(concreteSet);


    private static void printCapacityInfo(LinkedHashSet<String> set) {
        try {
            // Using reflection to access implementation details from HashSet
            java.lang.reflect.Field field = LinkedHashSet.class.getSuperclass().getDeclaredField("map");
            field.setAccessible(true);
            Object map = field.get(set);

            // These methods are from HashMap (HashSet's implementation)
            java.lang.reflect.Method capacityMethod = map.getClass().getDeclaredMethod("capacity");
            capacityMethod.setAccessible(true);

            java.lang.reflect.Method loadFactorMethod = map.getClass().getDeclaredMethod("loadFactor");
            loadFactorMethod.setAccessible(true);

            System.out.println("Internal capacity: " + capacityMethod.invoke(map));
            System.out.println("Load factor: " + loadFactorMethod.invoke(map));
        } catch (Exception e) {
            System.out.println("Couldn't access implementation details: " + e.getMessage());
        }
}

/*

Additional Methods Available with LinkedHashSet<String> LinkedHashSet = new LinkedHashSet<>();, not available with the Set interface:

add(E e) - Adds an element if not already present
remove(Object o) - Removes the specified element
contains(Object o) - Checks if element exists in set
size() - Returns number of elements
isEmpty() - Checks if set is empty
clear() - Removes all elements
iterator() - Returns iterator in insertion order
toArray() - Converts set to array
spliterator() - Returns an ordered Spliterator over the LinkedHashSet's elements, enabling parallel traversal while maintaining insertion order

*/
