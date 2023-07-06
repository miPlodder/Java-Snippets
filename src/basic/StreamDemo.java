package basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    static class Employee {

        int id;
        String name;
        int salary;

        public Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "[ id:" + id + ", name:" + name + ", salary:" + salary + "]";
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "A", 10000);
        Employee e2 = new Employee(2, "B", 15000);
        Employee e3 = new Employee(3, "C", 8000);

        List<Employee> al = Arrays.asList(e1, e2, e3);

        // Creating a stream
        Stream<Employee> streamOfAl = al.stream();
        Stream<Employee> directStream = Stream.of(e1, e2, e3);

        // forEach() - terminal operator
        al.stream().forEach(i -> System.out.print(i + ", "));
        System.out.println();

        // map() - intermediate operation, convert 1 stream to another stream
        // collect() - store items in list at end of stream operations
        System.out.println(al.stream().map(i -> i.name).collect(Collectors.toList()));

        // filter() - intermediate operation, produces a new stream that contains elements of original stream that pass a given test/condition
        System.out.println(al.stream().filter(i -> i.salary > 9000).map(i -> i.name).collect(Collectors.toList()));

        // flatMap() - intermediate operation, allows us to flatten an inner collection of a complex data type in new stream

        // limit(n) - return first n elements of original stream
        System.out.println(al.stream().limit(1).collect(Collectors.toList()));

        // min() - gives minimum value in the stream
        System.out.println(al.stream().min((i, j) -> i.salary - j.salary).get().name);

        // max() - gives maximum value in the stream
        System.out.println(al.stream().max((i, j) -> i.salary - j.salary).get().name);

        // count() - returns the number of elements in the stream
        System.out.println(al.stream().filter(i -> i.salary > 9000).count());

        // reduce() - reduce the elements of a stream to a single value
        // it compares variable which satisfies the previous condition with current variable
        System.out.println(al.stream().reduce((emp1, emp2) -> e1.salary > e2.salary ? e1 : e2).get());
    }
}
