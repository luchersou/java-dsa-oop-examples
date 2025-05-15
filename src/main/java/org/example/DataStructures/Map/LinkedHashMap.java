package org.example.DataStructures.Map;

public class LinkedHashMap {
    LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>(16, 0.75f, true);

    // Add some data
        linkedMap.put("Apple", 10);
        linkedMap.put("Banana", 20);
        linkedMap.put("Orange", 30);

    // (A) Access ordering demonstration
        System.out.println("Initial order: " + linkedMap);
        linkedMap.get("Apple");  // Access changes order
        System.out.println("After access: " + linkedMap);

    // (B) Eldest entry check (override for cache implementations)
    LinkedHashMap<String, Integer> cache = new LinkedHashMap<String, Integer>(16, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            return size() > 3;  // Remove oldest when size exceeds 3
        }
    };

        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);
        cache.put("D", 4);  // Automatically removes "A"
        System.out.println("Cache contents: " + cache);
}

/*

Additional Methods/feature Available with LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>(16, 0.75f, true);, not available with the Map interface:

Access-Order Constructor - LinkedHashMap(int, float, boolean) with access-order flag
removeEldestEntry() - Protected method for cache implementations
Iteration Order Guarantee -	Predictable iteration order (insertion or access)
Internal Structure Access -	Methods to inspect linked list structure (via reflection)

*/
