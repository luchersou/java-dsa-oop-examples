package org.example.DataStructures.List.WithoutListInterface;

public class Vector {
    // Creating a Vector of strings
    Vector<String> employees = new Vector<>();

        System.out.println("==== Demonstrating Vector specific methods not available in List interface ====\n");

    // Adding elements to the Vector
        employees.add("John Doe");
        employees.add("Jane Smith");
        employees.add("Robert Johnson");
        employees.add("Maria Garcia");

        System.out.println("Initial Vector: " + employees);

    // 1. capacity() - Returns the current capacity of the vector
        System.out.println("\n1. capacity() method:");
        System.out.println("Current capacity: " + employees.capacity());

    // 2. ensureCapacity() - Increases the capacity of the vector
    // Similar to ArrayList but not available in List interface
        System.out.println("\n2. ensureCapacity() method:");
        employees.ensureCapacity(20);
        System.out.println("Capacity after ensureCapacity(20): " + employees.capacity());

    // 3. setSize() - Sets the size of the vector
        System.out.println("\n3. setSize() method:");
        System.out.println("Current size: " + employees.size());
        employees.setSize(6); // Increases the size, filling with nulls if necessary
        System.out.println("Vector after setSize(6): " + employees);
        System.out.println("New size: " + employees.size());

    // 4. trimToSize() - Trims the capacity to the current size
    // Similar to ArrayList but not available in List interface
        System.out.println("\n4. trimToSize() method:");
        System.out.println("Capacity before trimToSize(): " + employees.capacity());
        employees.trimToSize();
        System.out.println("Capacity after trimToSize(): " + employees.capacity());

    // 5. elements() - Returns an Enumeration of the vector
        System.out.println("\n5. elements() method:");
    Enumeration<String> enumeration = employees.elements();
        System.out.println("Iterating through Enumeration:");
        while (enumeration.hasMoreElements()) {
        System.out.println("  - " + enumeration.nextElement());
    }

    // 6. copyInto() - Copies elements into an array
        System.out.println("\n6. copyInto() method:");
    String[] employeeArray = new String[employees.size()];
        employees.copyInto(employeeArray);
        System.out.println("Array after copyInto():");
        for (String employee : employeeArray) {
        System.out.println("  - " + employee);
    }

    // 7. addElement(), elementAt(), removeElement(), removeElementAt()
        System.out.println("\n7. Legacy Vector methods:");

    // 7.1. addElement()
        employees.addElement("Alex Brown");
        System.out.println("After addElement(): " + employees);

    // 7.2. elementAt()
        System.out.println("Element at index 2: " + employees.elementAt(2));

    // 7.3. removeElement()
    boolean removed = employees.removeElement("Jane Smith");
        System.out.println("removeElement('Jane Smith'): " + removed);
        System.out.println("Vector after removeElement(): " + employees);

    // 7.4. removeElementAt()
        employees.removeElementAt(0);
        System.out.println("Vector after removeElementAt(0): " + employees);

    // 8. firstElement() and lastElement()
        System.out.println("\n8. firstElement() and lastElement() methods:");
        System.out.println("First element: " + employees.firstElement());
        System.out.println("Last element: " + employees.lastElement());

    // 9. setElementAt() - Sets element at the specified index
    // This is a legacy method specific to Vector
        System.out.println("\n9. setElementAt() method:");
        employees.setElementAt("Modified Employee", 1);
        System.out.println("Vector after setElementAt(): " + employees);

    // 10. insertElementAt() - Inserts element at the specified index
    // This is a legacy method specific to Vector
        System.out.println("\n10. insertElementAt() method:");
        employees.insertElementAt("New Employee", 2);
        System.out.println("Vector after insertElementAt(): " + employees);
}

/*

Additional Methods Available with Vector<String> Vector = new Vector<>();, not available with the List interface:

addElement(E obj) – Adds an element to the end (same as add).
removeElement(Object obj) – Removes the first occurrence of the specified object.
elementAt(int index) – Returns the element at the specified index (same as get).
firstElement() – Returns the first element.
lastElement() – Returns the last element.
insertElementAt(E obj, int index) – Inserts an element at the specified position.
removeElementAt(int index) – Removes the element at the specified index.
removeAllElements() – Clears the vector (same as clear).
capacity() – Returns the current capacity of the vector.
ensureCapacity(int minCapacity) – Increases the capacity if necessary.
trimToSize() – Trims the capacity to match the size of the vector.

*/
