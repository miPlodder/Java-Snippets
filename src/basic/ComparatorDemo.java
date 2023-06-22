package basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Comparator is used to give inline implementation
 */
public class ComparatorDemo {

    static class Movie {

        String name;
        int rating;

        public Movie(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    public static void main(String[] args) {
        Movie m1 = new Movie("A", 7);
        Movie m2 = new Movie("B", 8);
        Movie m3 = new Movie("C", 6);

        ArrayList<Movie> al = new ArrayList<>();
        al.add(m1);
        al.add(m2);
        al.add(m3);

        Collections.sort(al, (i, j) -> i.rating - j.rating);
        al.stream().forEach(i -> System.out.print(i.rating + ", "));
    }
}
