package org.example.DataStructures.Set.WithoutSetInterface;

public class EnumSet {
    // Using concrete type (EnumSet) - has all methods
    EnumSet<Day> enumSet = EnumSet.of(Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY);

    // ==== 1. EnumSet-Specific Methods (Not in Set) ====

    // (A) Create EnumSet from enum class (all values)
    EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All days: " + allDays);

    // (B) Create empty EnumSet of specific enum type
    EnumSet<Day> noneOf = EnumSet.noneOf(Day.class);
        System.out.println("Empty set: " + noneOf);

    // (C) Create EnumSet from range (inclusive)
    EnumSet<Day> range = EnumSet.range(Day.TUESDAY, Day.FRIDAY);
        System.out.println("Range (Tue-Fri): " + range);

    // (D) Create complement of existing EnumSet
    EnumSet<Day> complement = EnumSet.complementOf(enumSet);
        System.out.println("Complement: " + complement);

    // (E) Create EnumSet by copying another EnumSet
    EnumSet<Day> copy = EnumSet.copyOf(enumSet);
        System.out.println("Copy: " + copy);
}

/*

Additional Methods Available with EnumSet<String> EnumSet = new EnumSet<>();, not available with the Set interface:

EnumSet.allOf(Class<E>)	- Creates an EnumSet containing all enum constants
EnumSet.noneOf(Class<E>) - Creates an empty EnumSet of the specified enum type
EnumSet.range(E from, E to) - Creates an EnumSet from the specified range
EnumSet.complementOf(EnumSet<E>) - Creates an EnumSet containing all enum values not in the specified set
EnumSet.copyOf(EnumSet<E>) - Creates an EnumSet from another EnumSet

*/
