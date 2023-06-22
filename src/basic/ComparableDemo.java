package basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Comparable class is used to compare similar objects with themselves
 */

public class ComparableDemo implements Comparable<ComparableDemo> {

    private int id;

    public ComparableDemo(int id) {
        this.id = id;
    }

    /**
     * Sort in ascending order of id
     */
    @Override
    public int compareTo(ComparableDemo other) {
        return this.id - other.id;
    }

    public static void main(String[] args) {
        ComparableDemo c1 = new ComparableDemo(1);
        ComparableDemo c2 = new ComparableDemo(2);
        ComparableDemo c3 = new ComparableDemo(3);

        ArrayList<ComparableDemo> al = new ArrayList<>();
        al.add(c1);
        al.add(c2);
        al.add(c3);

        Collections.sort(al);
        System.out.println(c1.compareTo(c2));
        al.stream().forEach((i) -> System.out.print(i.id + ", "));
    }
}
