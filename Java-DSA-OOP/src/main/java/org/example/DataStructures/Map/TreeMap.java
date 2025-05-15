package org.example.DataStructures.Map;

public class TreeMap {
    TreeMap<String, Integer> treeMap = new TreeMap<>();

    // Add some data
        treeMap.put("Apple", 10);
        treeMap.put("Banana", 20);
        treeMap.put("Orange", 30);
        treeMap.put("Grape", 40);

    // ==== 1. TreeMap-Specific Methods (Not in Map) ====

    // (A) Navigation methods
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());
        System.out.println("Floor entry for 'Carrot': " + treeMap.floorEntry("Carrot"));
        System.out.println("Ceiling key for 'Pear': " + treeMap.ceilingKey("Pear"));

    // (B) Range views
    NavigableMap<String, Integer> subMap = treeMap.subMap("Banana", true, "Orange", true);
        System.out.println("Submap from Banana to Orange: " + subMap);

    // (C) Comparator access
    Comparator<? super String> comparator = treeMap.comparator();
        System.out.println("Comparator: " + comparator);

    // (D) Polling first/last entries
    Map.Entry<String, Integer> firstEntry = treeMap.pollFirstEntry();
    Map.Entry<String, Integer> lastEntry = treeMap.pollLastEntry();
        System.out.println("Removed first: " + firstEntry);
        System.out.println("Removed last: " + lastEntry);
}

/*

Additional Methods/feature Available with TreeMap<String, Integer> treeMap = new TreeMap<>();, not available with the Map interface:

firstKey() - Returns the first (lowest) key
lastKey() - Returns the last (highest) key
lowerKey(K) - Returns the greatest key strictly less than given key
higherKey(K) - Returns the least key strictly greater than given key
floorKey(K) - Returns the greatest key less than or equal to given key
ceilingKey(K) - Returns the least key greater than or equal to given key
firstEntry() - Returns the first (lowest) key-value pair
lastEntry() - Returns the last (highest) key-value pair
lowerEntry(K) - Returns entry with greatest key strictly less than given key
higherEntry(K) - Returns entry with least key strictly greater than given key
floorEntry(K) - Returns entry with greatest key less than or equal to given key
ceilingEntry(K) - Returns entry with least key greater than or equal to given key
pollFirstEntry() - Removes and returns the first entry
pollLastEntry() - Removes and returns the last entry
subMap(K, K) - Returns a view of portion between two keys
headMap(K) - Returns a view of portion before given key
tailMap(K) - Returns a view of portion after given key
descendingMap() - Returns a reverse-order view
comparator() - Returns the comparator used for ordering

*/
