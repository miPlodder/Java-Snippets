package basic;

import java.util.HashSet;

/**
 * If we override the equals() method, we also have to override hashCode().
 *
 * Contract b/w equals() and hashCode()
 *
 * If 2 objects are equal by equals(), then their hashCode() should be SAME
 * If 2 objects are equal by hashCode(), then their equals() MAY or MAY NOT be SAME
 *
 * */
public class HashCodeAndEqualsDemo {

    static class Employee {
        int id;
        String name;
        int age;

        public Employee(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        /**
         * It returns the hashcode value as an Integer.
         * Hashcode value is mostly used in hashing based collections like HashMap, HashSet, HashTable….etc.
         * This method must be overridden in every class which overrides equals() method.
         * */
        @Override
        public int hashCode() {
            return 1;
        }

        /**
         * used to compare equality of two Objects
         * */
        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }

    public static void main(String[] args) {
        // Case 1
        HashSet<String> set = new HashSet<>();
        set.add("saksham");
        set.add("saksham");
        // we will have only 1 object
        set.stream().forEach(i -> System.out.println(i));

        // Case 2
        HashSet<Employee> set2 = new HashSet<>();
        set2.add(new Employee(1, "saksham", 25));
        set2.add(new Employee(1, "saksham", 25));
        // we will have 2 objects here [with java default implementation of hashcode() and equals()]
        set2.stream().forEach(i -> System.out.println(i));

        // Case 3

        // Case 4
    }
}
