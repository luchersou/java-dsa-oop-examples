package org.example.DataStructures.Set;

public class Methods {

/*

Main methods accessible by all of its implementations:

Implementations:
Set<String> treeSet = new TreeSet<>();
Set<String> linkedHashSet = new LinkedHashSet<>();
Set<String> hashSet = new HashSet<>();
Set<Day> enumSet = EnumSet.of(Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY);

add(String element) – Adds the specified element to the set if it is not already present.
addAll(Collection<? extends String> c) – Adds all elements from the specified collection, ignoring duplicates.
remove(Object o) – Removes the specified element from the set if it is present.
removeAll(Collection<?> c) – Removes all elements that are also contained in the specified collection.
contains(Object o) – Returns true if the set contains the specified element.
containsAll(Collection<?> c) – Returns true if the set contains all elements of the specified collection.
isEmpty() – Returns true if the set contains no elements.
size() – Returns the number of elements in the set.
clear() – Removes all elements from the set.
iterator() – Returns an iterator over the elements in the set.
forEach(Consumer<? super String> action) – Performs the given action for each element in the set.
retainAll(Collection<?> c) – Retains only the elements that are also contained in the specified collection.

import java.util.*;
import java.util.stream.Collectors;

public class SetCompleteExamples {
    
    public static void main(String[] args) {
        demonstrateImplementationDifferences();
        demonstrateBasicMethods();
        demonstrateSetOperations();
        demonstrateJava8Methods();
        demonstrateSpecificUseCases();
        demonstratePerformance();
    }
    
    // ===== DIFFERENCES BETWEEN IMPLEMENTATIONS =====
    private static void demonstrateImplementationDifferences() {
        System.out.println("=== DIFFERENCES BETWEEN IMPLEMENTATIONS ===");
        
        // HashSet - no guaranteed order
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Orange");
        hashSet.add("Grape");
        hashSet.add("Banana"); // Duplicate - will be ignored
        System.out.println("HashSet (no order): " + hashSet);
        
        // LinkedHashSet - keeps insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Grape");
        linkedHashSet.add("Banana"); // Duplicate - will be ignored
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
        
        // TreeSet - natural order (alphabetical)
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");
        treeSet.add("Grape");
        treeSet.add("Banana"); // Duplicate - will be ignored
        System.out.println("TreeSet (natural order): " + treeSet);
        
        // Demonstrating that duplicates are ignored
        System.out.println("Size of all sets: " + hashSet.size()); // 4, not 5
        System.out.println();
    }
    
    // ===== BASIC METHODS =====
    private static void demonstrateBasicMethods() {
        System.out.println("=== BASIC METHODS OF SET ===");
        
        Set<Integer> numbers = new HashSet<>();
        
        // ===== ADDITION =====
        System.out.println("--- Addition Methods ---");
        boolean added1 = numbers.add(10);
        boolean added2 = numbers.add(20);
        boolean added3 = numbers.add(10); // Duplicate
        
        System.out.println("Added 10: " + added1); // true
        System.out.println("Added 20: " + added2); // true  
        System.out.println("Added 10 again: " + added3); // false
        System.out.println("Current set: " + numbers);
        
        // addAll - adds a collection
        Set<Integer> moreNumbers = Set.of(30, 40, 10); // 10 is duplicate
        boolean addedAny = numbers.addAll(moreNumbers);
        System.out.println("addAll added any element: " + addedAny);
        System.out.println("Set after addAll: " + numbers);
        
        // ===== QUERY =====
        System.out.println("\n--- Query Methods ---");
        System.out.println("Size: " + numbers.size());
        System.out.println("Is empty: " + numbers.isEmpty());
        System.out.println("Contains 20: " + numbers.contains(20));
        System.out.println("Contains 50: " + numbers.contains(50));
        
        Set<Integer> subset = Set.of(10, 20);
        System.out.println("Contains all from " + subset + ": " + numbers.containsAll(subset));
        
        // ===== REMOVAL =====
        System.out.println("\n--- Removal Methods ---");
        boolean removed = numbers.remove(20);
        System.out.println("Removed 20: " + removed);
        System.out.println("Set after removal: " + numbers);
        
        // ===== CONVERSION =====
        System.out.println("\n--- Conversion to Array ---");
        Object[] array = numbers.toArray();
        System.out.println("Array: " + Arrays.toString(array));
        
        Integer[] intArray = numbers.toArray(new Integer[0]);
        System.out.println("Integer Array: " + Arrays.toString(intArray));
        
        System.out.println();
    }
    
    // ===== SET OPERATIONS =====
    private static void demonstrateSetOperations() {
        System.out.println("=== SET OPERATIONS ===");
        
        Set<String> webLanguages = new HashSet<>(Arrays.asList("HTML", "CSS", "JavaScript", "PHP"));
        Set<String> backendLanguages = new HashSet<>(Arrays.asList("Java", "Python", "PHP", "C#"));
        
        System.out.println("Web Languages: " + webLanguages);
        System.out.println("Backend Languages: " + backendLanguages);
        
        // ===== UNION =====
        Set<String> union = new HashSet<>(webLanguages);
        union.addAll(backendLanguages);
        System.out.println("Union (all languages): " + union);
        
        // ===== INTERSECTION =====
        Set<String> intersection = new HashSet<>(webLanguages);
        intersection.retainAll(backendLanguages);
        System.out.println("Intersection (common languages): " + intersection);
        
        // ===== DIFFERENCE =====
        Set<String> difference = new HashSet<>(webLanguages);
        difference.removeAll(backendLanguages);
        System.out.println("Difference (Web - Backend): " + difference);
        
        // ===== SYMMETRIC DIFFERENCE (using streams) =====
        Set<String> symmetricDifference = new HashSet<>();
        symmetricDifference.addAll(webLanguages);
        symmetricDifference.addAll(backendLanguages);
        
        Set<String> tempIntersection = new HashSet<>(webLanguages);
        tempIntersection.retainAll(backendLanguages);
        symmetricDifference.removeAll(tempIntersection);
        
        System.out.println("Symmetric Difference (unique elements): " + symmetricDifference);
        System.out.println();
    }
    
    // ===== JAVA 8+ METHODS =====
    private static void demonstrateJava8Methods() {
        System.out.println("=== JAVA 8+ METHODS ===");
        
        Set<String> names = new HashSet<>(Arrays.asList("John", "Mary", "Peter", "Anna", "Charles"));
        System.out.println("Original set: " + names);
        
        // ===== forEach =====
        System.out.println("\n--- forEach ---");
        System.out.print("Names in uppercase: ");
        names.forEach(name -> System.out.print(name.toUpperCase() + " "));
        System.out.println();
        
        // ===== removeIf =====
        System.out.println("\n--- removeIf ---");
        Set<String> namesToRemove = new HashSet<>(names);
        boolean removedAny = namesToRemove.removeIf(name -> name.length() <= 4);
        System.out.println("Removed names with 4 or fewer characters: " + removedAny);
        System.out.println("Set after removeIf: " + namesToRemove);
        
        // ===== Stream Operations =====
        System.out.println("\n--- Stream Operations ---");
        List<String> namesWithA = names.stream()
                .filter(name -> name.toLowerCase().contains("a"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Names containing 'a' (sorted): " + namesWithA);
        
        long namesLongerThan4 = names.stream()
                .filter(name -> name.length() > 4)
                .count();
        System.out.println("Number of names longer than 4 characters: " + namesLongerThan4);
        
        // ===== Parallel Stream =====
        System.out.println("\n--- Parallel Stream ---");
        Set<Integer> bigNumbers = new HashSet<>();
        for (int i = 1; i <= 1000; i++) {
            bigNumbers.add(i);
        }
        
        long evenNumbersParallel = bigNumbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Even numbers (parallel processing): " + evenNumbersParallel);
        System.out.println();
    }
    
    // ===== SPECIFIC USE CASES =====
    private static void demonstrateSpecificUseCases() {
        System.out.println("=== SPECIFIC USE CASES ===");
        
        // ===== 1. REMOVE DUPLICATES FROM A LIST =====
        System.out.println("--- 1. Remove Duplicates ---");
        List<String> listWithDuplicates = Arrays.asList("Java", "Python", "Java", "C++", "Python", "JavaScript");
        System.out.println("Original list: " + listWithDuplicates);
        
        Set<String> withoutDuplicates = new LinkedHashSet<>(listWithDuplicates); // Keeps order
        System.out.println("Without duplicates: " + withoutDuplicates);
        
        List<String> listWithoutDuplicates = new ArrayList<>(withoutDuplicates);
        System.out.println("Back to List: " + listWithoutDuplicates);
        
        // ===== 2. CHECK UNIQUE ELEMENTS =====
        System.out.println("\n--- 2. Check Unique Elements ---");
        List<String> emails = Arrays.asList("user1@email.com", "user2@email.com", "user1@email.com");
        Set<String> uniqueEmails = new HashSet<>(emails);
        
        if (emails.size() != uniqueEmails.size()) {
            System.out.println("❌ There are duplicate emails!");
            System.out.println("Total emails: " + emails.size());
            System.out.println("Unique emails: " + uniqueEmails.size());
        } else {
            System.out.println("✅ All emails are unique!");
        }
        
        // ===== 3. UNIQUE TAGS/CATEGORIES =====
        System.out.println("\n--- 3. Tag System ---");
        Set<String> articleTags = new TreeSet<>(); // TreeSet for alphabetical order
        articleTags.add("java");
        articleTags.add("programming");
        articleTags.add("tutorial");
        articleTags.add("java"); // Duplicate ignored
        articleTags.add("backend");
        
        System.out.println("Article tags (sorted): " + articleTags);
        
        // ===== 4. PERMISSIONS CONTROL =====
        System.out.println("\n--- 4. Permission System ---");
        Set<String> userPermissions = new HashSet<>();
        userPermissions.add("READ");
        userPermissions.add("WRITE");
        userPermissions.add("DELETE");
        
        Set<String> requiredPermissions = Set.of("READ", "WRITE");
        
        if (userPermissions.containsAll(requiredPermissions)) {
            System.out.println("✅ User has all required permissions");
        } else {
            System.out.println("❌ User does not have enough permissions");
        }
        
        System.out.println();
    }
    
    // ===== PERFORMANCE COMPARISON =====
    private static void demonstratePerformance() {
        System.out.println("=== PERFORMANCE COMPARISON ===");
        
        final int AMOUNT = 100000;
        
        // ===== ADDITION TEST =====
        System.out.println("--- Addition Test (" + AMOUNT + " elements) ---");
        
        // HashSet
        long start = System.nanoTime();
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < AMOUNT; i++) {
            hashSet.add(i);
        }
        long hashSetTime = System.nanoTime() - start;
        
        // LinkedHashSet  
        start = System.nanoTime();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < AMOUNT; i++) {
            linkedHashSet.add(i);
        }
        long linkedHashSetTime = System.nanoTime() - start;
        
        // TreeSet
        start = System.nanoTime();
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < AMOUNT; i++) {
            treeSet.add(i);
        }
        long treeSetTime = System.nanoTime() - start;
        
        System.out.println("HashSet: " + hashSetTime / 1_000_000 + " ms");
        System.out.println("LinkedHashSet: " + linkedHashSetTime / 1_000_000 + " ms");
        System.out.println("TreeSet: " + treeSetTime / 1_000_000 + " ms");
        
        // ===== SEARCH TEST =====
        System.out.println("\n--- Search Test (10,000 searches) ---");
        Random random = new Random(42);
        
        // HashSet
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            hashSet.contains(random.nextInt(AMOUNT));
        }
        hashSetTime = System.nanoTime() - start;
        
        // LinkedHashSet
        random = new Random(42);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedHashSet.contains(random.nextInt(AMOUNT));
        }
        linkedHashSetTime = System.nanoTime() - start;
        
        // TreeSet
        random = new Random(42);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            treeSet.contains(random.nextInt(AMOUNT));
        }
        treeSetTime = System.nanoTime() - start;
        
        System.out.println("HashSet: " + hashSetTime / 1_000_000 + " ms");
        System.out.println("LinkedHashSet: " + linkedHashSetTime / 1_000_000 + " ms");
        System.out.println("TreeSet: " + treeSetTime / 1_000_000 + " ms");
        
        // ===== ORDERED ITERATION DEMONSTRATION =====
        System.out.println("\n--- Iteration Demonstration (first 10 elements) ---");
        
        System.out.print("HashSet: ");
        hashSet.stream().limit(10).forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.print("LinkedHashSet: ");
        linkedHashSet.stream().limit(10).forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        System.out.print("TreeSet: ");
        treeSet.stream().limit(10).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}

*/
}
