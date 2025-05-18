package org.example.DataStructures.Map.WithoutMapInterface;

public class Hashtable {
    Hashtable<String, Integer> hashtable = new Hashtable<>();

    // Add some data
        hashtable.put("Apple", 10);
        hashtable.put("Banana", 20);
        hashtable.put("Orange", 30);

    // (A) Legacy enumeration of keys
        System.out.println("Keys (Enumeration):");
    java.util.Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
        System.out.println(keys.nextElement());
    }

    // (B) Legacy enumeration of values
        System.out.println("\nValues (Enumeration):");
    java.util.Enumeration<Integer> values = hashtable.elements();
        while (values.hasMoreElements()) {
        System.out.println(values.nextElement());
    }

    // (C) Synchronized methods (legacy thread-safety)
        System.out.println("\nSynchronized access:");
    synchronized (hashtable) {
        hashtable.put("Grape", 40);
        System.out.println("Grape added in synchronized block");
    }
}

/*

Additional Methods Available with Hashtable<String, Integer> hashtable = new Hashtable<>();, not available with the Map interface:

keys() - Returns legacy Enumeration of keys
elements() - Returns legacy Enumeration of values
contains(Object value) - Legacy method identical to containsValue()
rehash() - Internal capacity management (protected)

*/