package be.intecbrussel;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Oefeningen {
    public static void main(String[] args) {
        int[] numbers = new int[]{23, 22, 51, 73, 54, 48, 61, 84, 95, 11};
        String[] names = new String[]{"Manu", "Audric", "Dieter", "Tonykjagjksjbikjsboijzbeobsdovcns", "Mert"};

        // Opdracht 1
        IntStream.of(numbers)
                .map(i -> i *= 5)
                .filter(i -> i > 50)
                .forEach(i -> System.out.print(i + " "));
        System.out.println(" ");

        // Opdracht 2
        int[] intArr = IntStream.of(numbers)
                .map(i -> i /= 2)
                .toArray();

        // Opdracht 3
        Optional<String> singleString = Stream.of(names)
                .limit(2)
                .map(String::toUpperCase)
                .reduce((acc, el) -> acc + el);

        if (singleString.isPresent()) {
            System.out.println("singleString = " + singleString);
        }
        // Opdracht 4
        IntStream.of(numbers)
                .skip(2)
                .sum();

        // Opdracht 5
        Stream<String> stringToIntStream = Stream.of(names);

        stringToIntStream.mapToInt(String::hashCode)
                .peek(i -> {
                    try {
                        checkSize(i);
                    } catch (TooBigTooHandleException e) {
                        e.getMessage();
                    }
                })
                .forEach(i -> System.out.print(i + " "));
    }

    private static void checkSize(int i) throws TooBigTooHandleException {
        if (!(i < Integer.MAX_VALUE)) {
            throw new TooBigTooHandleException("this value is bigger than the max value of an integer.");
        }
    }
}
