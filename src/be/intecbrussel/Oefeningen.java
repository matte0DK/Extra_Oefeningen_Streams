package be.intecbrussel;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Oefeningen {
    public static void main(String[] args) {
        int[] numbers = new int[]{23, 22, 51, 73, 54, 48, 61, 84, 95, 11};
        String[] names = new String[]{"Manu", "Audric", "Dieter", "881", "Mert"};

        // OPDRACHT 1 //
        IntStream.of(numbers)
                .map(i -> i * 5)
                .filter(i -> i > 50)
                .forEach(i -> System.out.print(i + " "));
        System.out.println(" ");

        // OPDRACHT 2 //
        double[] intArr = IntStream.of(numbers)
                .mapToDouble(i -> (double) i / 2) // => typecasten, geeft aan dat dit een double moet zijn!
                .toArray();
        DoubleStream.of(intArr)
                .forEach(d -> System.out.print(d + " "));
        System.out.println(" ");

        // OPDRACHT 3 //
        Optional<String> singleString = Stream.of(names)
                .limit(2)
                .map(String::toUpperCase)
                .reduce((acc, el) -> acc + el);

        if (singleString.isPresent()) {
            System.out.println("singleString = " + singleString.get());
        } // => my solution

        String newString = Stream.of(names)
                .limit(2)
                .map(String::toUpperCase)
                .reduce("", (acc, el) -> acc + el);

        // OPDRACHT 4 //
        int sum = IntStream.of(numbers)
                .skip(2)
                .sum();
        System.out.println(sum);


        // OPDRACHT 5 //
        Stream.of(names).filter(i -> convertableToInt(i))
                .mapToInt(i -> Integer.valueOf(i))
                .forEach(i -> System.out.println(i + " "));

//        Stream<String> stringToIntStream = Stream.of(names);
//        stringToIntStream.mapToLong(String::hashCode)
//                .peek(i -> {
//                    try {
//                        checkInt(i);
//                    } catch (NumberFormatException e) {
//                        e.getMessage();
//                    }
//                })
//                .forEach(i -> System.out.print(i + " "));

//      <=> niet de vraag! dit is om te checken of een string als een long in een int past...

    }

    private static boolean convertableToInt(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

//    private static void checkInt(long l) throws NumberFormatException {
//        if (!(l < Integer.MAX_VALUE)) {
//            throw new NumberFormatException("this value is not valid for an integer.");
//        }
//    }

//    <=> niet de vraag! dit is om te checken of een string als een long in een int past...

}
