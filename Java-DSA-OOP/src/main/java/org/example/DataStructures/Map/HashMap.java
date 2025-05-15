package org.example.Map;

public class HashMap {
    HashMap<String, Integer> hashMap = new HashMap<>();

    // Add some data
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 35);

    // (A) Capacity management
        System.out.println("Current capacity: " + getCapacity(hashMap));
        hashMap.ensureCapacity(100);  // Pre-allocate space

    // (B) Clone the HashMap
    HashMap<String, Integer> clone = (HashMap<String, Integer>) hashMap.clone();
        System.out.println("Cloned map: " + clone);
}


// Helper method to access capacity via reflection
private static int getCapacity(HashMap<?, ?> map) {
    try {
        java.lang.reflect.Field field = HashMap.class.getDeclaredField("table");
        field.setAccessible(true);
        Object[] table = (Object[]) field.get(map);
        return table == null ? 0 : table.length;
    } catch (Exception e) {
        return -1;
    }
}

/*

Additional Methods Available with HashMap<String, Integer> hashMap = new HashMap<>();, not available with the Map interface:

clone() - Creates a shallow copy of the HashMap
ensureCapacity(int minCapacity) - Pre-allocates internal storage
putIfAbsent(K key, V value) - (Note: Actually in Map interface since Java 8)

Very Few Exclusive Methods: Most HashMap functionality is exposed through the Map interface

*/
