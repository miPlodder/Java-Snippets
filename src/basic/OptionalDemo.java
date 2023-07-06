package basic;

import java.util.Optional;

/**
 * It provides a type-level solution for representing optional values instead of null references.
 * It's helps in writing neat code without too manu null checks, by specifying alternative values to return or alternate code to run
 */
public class OptionalDemo {

    public static void main(String[] args) {
        // empty() -> Creating empty Optional object
        Optional<String> opt1 = Optional.empty();
        System.out.println(opt1.isEmpty());

        // of() -> Creating an Optional with value inside, accepts only non-null values
        Optional<String> opt2 = Optional.of("saksham");
        // get() -> get the value
        System.out.println(opt2.get());
        System.out.println(opt2.isPresent());

        // ofNullable() -> Creating an Optional with value inside, accept null values also
        Optional<String> opt3 = Optional.ofNullable(null);
        System.out.println(opt3.isEmpty());

        // ifPresent() -> run code on wrapped object if it's non-null
        Optional<String> opt4 = Optional.ofNullable("saksham");
        opt4.ifPresent((i) -> System.out.println(i));

        // orElse() -> if the value is null, we can pass default value
        System.out.println(Optional.ofNullable(null).orElse("rahul"));

        // orElseGet() -> if the value is null, we can execute some code to get the default value
        System.out.println(Optional.ofNullable(null).orElseGet(OptionalDemo::fetchDefaultValueFromDatabase));

        // orElseThrow() -> if the value is null, we throw an exception
        Optional.ofNullable("null").orElseThrow(RuntimeException::new);

    }

    private static String fetchDefaultValueFromDatabase() {
        return "value fetched from db";
    }
}
