package org.example.DataStructures.List;

public class ArrayList {
    // Creating ArrayList with specific type
    ArrayList<String> fruits = new ArrayList<>();

        System.out.println("==== Demonstrating ArrayList specific methods not available in List interface ====\n");

    // Adding elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Initial fruits: " + fruits);

    // 1. ensureCapacity() - Increases the capacity of ArrayList
    // This method is specific to ArrayList and not available in List interface
        System.out.println("\n1. ensureCapacity() method:");
        System.out.println("Before: Internal capacity is managed automatically");
        fruits.ensureCapacity(20); // Ensures the ArrayList can hold at least 20 elements without resizing
        System.out.println("After: Capacity ensured for at least 20 elements");

    // 2. trimToSize() - Trims the capacity to the current size
    // This method is specific to ArrayList and not available in List interface
        System.out.println("\n2. trimToSize() method:");
        System.out.println("Before trimToSize(): ArrayList might have extra capacity");
        fruits.trimToSize(); // Trims the internal array to match current size
        System.out.println("After trimToSize(): ArrayList capacity trimmed to current size: " + fruits.size());

    // 3. clone() - Creates a shallow copy of the ArrayList
    // This method returns an ArrayList object, not just a List
        System.out.println("\n3. clone() method:");
    @SuppressWarnings("unchecked")
    ArrayList<String> fruitsCopy = (ArrayList<String>) fruits.clone();
        System.out.println("Original fruits: " + fruits);
        System.out.println("Cloned fruits: " + fruitsCopy);

    // 4. removeRange() - Removes elements between specified indices
    // This is protected in ArrayList, so we need to extend ArrayList to use it
        System.out.println("\n4. removeRange() method (demonstration through subclass):");
    CustomArrayList<String> customFruits = new CustomArrayList<>();
        customFruits.add("Apple");
        customFruits.add("Banana");
        customFruits.add("Orange");
        customFruits.add("Mango");
        customFruits.add("Grape");
        System.out.println("Before removeRange(): " + customFruits);
        customFruits.removeRangeCustom(1, 3); // Removes elements at index 1 and 2
        System.out.println("After removeRange(1, 3): " + customFruits);
}

// Custom class to demonstrate protected removeRange() method
class CustomArrayList<E> extends ArrayList<E> {
    // Exposing the protected removeRange method
    public void removeRangeCustom(int fromIndex, int toIndex) {
        removeRange(fromIndex, toIndex);
    }
}

/*

Additional Methods Available with ArrayList<String> fruits = new ArrayList<>;,not available with the List interface:

ensureCapacity(int minCapacity) – Ensures the ArrayList can hold at least minCapacity elements.
trimToSize() – Trims the internal array size to match the current number of elements.
clone() - Creates a shallow copy of the ArrayList

*/