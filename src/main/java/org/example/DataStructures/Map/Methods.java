package org.example.DataStructures.Map;

public class Methods {

/*

Main methods accessible by all of its implementations:

Implementations:
Map<String, Integer> hashMap = new HashMap<>();
Map<String, Integer> hashtable = new Hashtable<>();
Map<String, Integer> linkedMap = new LinkedHashMap<>();
Map<String, Integer> treeMap = new TreeMap<>();


put(K key, V value) – Inserts or updates a key-value pair
get(Object key) – Returns the value for the specified key (or null)
remove(Object key) – Removes and returns the value for the key
containsKey(Object key) – Checks if a key exists
containsValue(Object v) – Checks if a value exists
putAll(Map<? extends K,? extends V> m) – Copies all entries from another map
clear() – Removes all entries
keySet() – Returns a Set view of all keys
values() – Returns a Collection view of all values
entrySet() – Returns a Set view of all key-value pairs
size() – Returns number of key-value pairs
isEmpty() – Checks if the map is empty
getOrDefault(Object k, V dv) – Returns value or default if key absent
putIfAbsent(K k, V v) – Inserts only if key doesn't exist
remove(Object k, Object v) – Removes only if key-value matches
replace(K k, V v) – Updates only if key exists
forEach(BiConsumer<? super K,? super V>) – Iterates all entries

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MapCompleteExamples {
    
    public static void main(String[] args) {
        demonstrateImplementationDifferences();
        demonstrateBasicMethods();
        demonstrateMapOperations();
        demonstrateJava8Methods();
        demonstrateSpecificUseCases();
        demonstratePerformance();
        demonstrateConcurrency();
    }
    
    // ===== DIFFERENCES BETWEEN IMPLEMENTATIONS =====
    private static void demonstrateImplementationDifferences() {
        System.out.println("=== DIFFERENCES BETWEEN IMPLEMENTATIONS ===");
        
        // HashMap - no guaranteed order
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Banana", 5);
        hashMap.put("Apple", 3);
        hashMap.put("Orange", 8);
        hashMap.put("Grape", 12);
        hashMap.put("Apple", 7); // Overwrites previous value
        System.out.println("HashMap (no order): " + hashMap);
        
        // LinkedHashMap - keeps insertion order
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Banana", 5);
        linkedHashMap.put("Apple", 3);
        linkedHashMap.put("Orange", 8);
        linkedHashMap.put("Grape", 12);
        linkedHashMap.put("Apple", 7); // Overwrites but keeps position
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);
        
        // TreeMap - natural order of keys (alphabetical)
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Banana", 5);
        treeMap.put("Apple", 3);
        treeMap.put("Orange", 8);
        treeMap.put("Grape", 12);
        treeMap.put("Apple", 7); // Overwrites previous value
        System.out.println("TreeMap (natural key order): " + treeMap);
        
        // ConcurrentHashMap - thread-safe HashMap
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Banana", 5);
        concurrentMap.put("Apple", 3);
        concurrentMap.put("Orange", 8);
        System.out.println("ConcurrentHashMap (thread-safe): " + concurrentMap);
        
        // Demonstrating null handling
        System.out.println("\n--- Null Handling ---");
        hashMap.put(null, 999); // HashMap allows one null key
        hashMap.put("NullValue", null); // and multiple null values
        System.out.println("HashMap with nulls: " + hashMap);
        
        try {
            treeMap.put(null, 999); // TreeMap does NOT allow null keys
        } catch (NullPointerException e) {
            System.out.println("TreeMap does not allow null keys: " + e.getClass().getSimpleName());
        }
        
        System.out.println();
    }
    
    // ===== BASIC METHODS =====
    private static void demonstrateBasicMethods() {
        System.out.println("=== BASIC METHODS OF MAP ===");
        
        Map<String, Double> studentGrades = new HashMap<>();
        
        // ===== INSERTION =====
        System.out.println("--- Insertion Methods ---");
        Double oldGrade1 = studentGrades.put("John", 8.5);
        Double oldGrade2 = studentGrades.put("Mary", 9.2);
        Double oldGrade3 = studentGrades.put("John", 8.8); // Overwrites
        
        System.out.println("Put John (first time) - old value: " + oldGrade1); // null
        System.out.println("Put Mary - old value: " + oldGrade2); // null
        System.out.println("Put John (second time) - old value: " + oldGrade3); // 8.5
        System.out.println("Current map: " + studentGrades);
        
        // putAll - adds all from another map
        Map<String, Double> moreGrades = Map.of("Peter", 7.5, "Anna", 9.8);
        studentGrades.putAll(moreGrades);
        System.out.println("After putAll: " + studentGrades);
        
        // putIfAbsent - only puts if key doesn't exist
        Double putIfAbsentResult1 = studentGrades.putIfAbsent("John", 10.0); // Won't overwrite
        Double putIfAbsentResult2 = studentGrades.putIfAbsent("Carlos", 7.8); // Will add
        System.out.println("putIfAbsent John (exists): " + putIfAbsentResult1); // 8.8
        System.out.println("putIfAbsent Carlos (new): " + putIfAbsentResult2); // null
        System.out.println("After putIfAbsent: " + studentGrades);
        
        // ===== QUERY =====
        System.out.println("\n--- Query Methods ---");
        System.out.println("Size: " + studentGrades.size());
        System.out.println("Is empty: " + studentGrades.isEmpty());
        System.out.println("Contains key 'John': " + studentGrades.containsKey("John"));
        System.out.println("Contains key 'Robert': " + studentGrades.containsKey("Robert"));
        System.out.println("Contains value 9.2: " + studentGrades.containsValue(9.2));
        System.out.println("Contains value 10.0: " + studentGrades.containsValue(10.0));
        
        // get and getOrDefault
        Double johnGrade = studentGrades.get("John");
        Double robertGrade = studentGrades.get("Robert"); // null
        Double robertGradeDefault = studentGrades.getOrDefault("Robert", 0.0);
        
        System.out.println("John's grade: " + johnGrade);
        System.out.println("Robert's grade: " + robertGrade);
        System.out.println("Robert's grade (with default): " + robertGradeDefault);
        
        // ===== REMOVAL =====
        System.out.println("\n--- Removal Methods ---");
        Double removedGrade = studentGrades.remove("Peter");
        System.out.println("Removed Peter's grade: " + removedGrade);
        
        // Conditional removal
        boolean removedConditional = studentGrades.remove("Mary", 9.2); // Only if value matches
        System.out.println("Removed Mary with grade 9.2: " + removedConditional);
        System.out.println("Map after removals: " + studentGrades);
        
        // ===== VIEWS =====
        System.out.println("\n--- Map Views ---");
        Set<String> keys = studentGrades.keySet();
        Collection<Double> values = studentGrades.values();
        Set<Map.Entry<String, Double>> entries = studentGrades.entrySet();
        
        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);
        System.out.println("Entries: " + entries);
        
        System.out.println();
    }
    
    // ===== MAP OPERATIONS =====
    private static void demonstrateMapOperations() {
        System.out.println("=== MAP OPERATIONS ===");
        
        Map<String, Set<String>> programmingSkills = new HashMap<>();
        programmingSkills.put("John", Set.of("Java", "Python", "JavaScript"));
        programmingSkills.put("Mary", Set.of("C++", "Java", "Go"));
        programmingSkills.put("Peter", Set.of("Python", "JavaScript", "TypeScript"));
        programmingSkills.put("Anna", Set.of("Java", "C#", "Kotlin"));
        
        System.out.println("Programming Skills: " + programmingSkills);
        
        // ===== MERGE OPERATION =====
        System.out.println("\n--- Merge Operations ---");
        Map<String, Integer> projectHours = new HashMap<>();
        projectHours.put("John", 40);
        projectHours.put("Mary", 35);
        projectHours.put("Peter", 30);
        
        // Adding more hours for existing people and new person
        projectHours.merge("John", 10, Integer::sum); // 40 + 10 = 50
        projectHours.merge("Anna", 25, Integer::sum); // New entry, just puts 25
        projectHours.merge("Mary", 15, Integer::sum); // 35 + 15 = 50
        
        System.out.println("Project hours after merge: " + projectHours);
        
        // ===== COMPUTE OPERATIONS =====
        System.out.println("\n--- Compute Operations ---");
        Map<String, String> userStatus = new HashMap<>();
        userStatus.put("John", "active");
        userStatus.put("Mary", "inactive");
        
        // compute - always executes the function
        userStatus.compute("John", (k, v) -> v != null ? v.toUpperCase() : "UNKNOWN");
        userStatus.compute("Peter", (k, v) -> v != null ? v.toUpperCase() : "NEW_USER");
        
        System.out.println("After compute: " + userStatus);
        
        // computeIfAbsent - only if key is absent or value is null
        userStatus.computeIfAbsent("Anna", k -> "pending");
        userStatus.computeIfAbsent("John", k -> "this_wont_be_used"); // Won't execute
        
        System.out.println("After computeIfAbsent: " + userStatus);
        
        // computeIfPresent - only if key exists and value is not null
        userStatus.computeIfPresent("Mary", (k, v) -> v + "_updated");
        userStatus.computeIfPresent("Robert", (k, v) -> v + "_updated"); // Won't execute
        
        System.out.println("After computeIfPresent: " + userStatus);
        
        // ===== REPLACE OPERATIONS =====
        System.out.println("\n--- Replace Operations ---");
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Apples", 50);
        inventory.put("Bananas", 30);
        inventory.put("Oranges", 25);
        
        System.out.println("Original inventory: " + inventory);
        
        // replace - unconditional
        Integer oldApples = inventory.replace("Apples", 45);
        System.out.println("Replaced Apples, old value: " + oldApples);
        
        // replace - conditional (only if current value matches)
        boolean replaced = inventory.replace("Bananas", 30, 35);
        System.out.println("Conditionally replaced Bananas: " + replaced);
        
        // replaceAll - applies function to all values
        inventory.replaceAll((fruit, quantity) -> quantity > 40 ? quantity - 5 : quantity + 5);
        System.out.println("After replaceAll: " + inventory);
        
        System.out.println();
    }

*/
}
