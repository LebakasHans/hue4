package net.htlgkr.DrittesBeispiel;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class JavaStreamTester {
    public static void main(String[] args){
        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("");
        strings.add("kjg");
        strings.add("sdf");
        strings.add("foo");
        strings.add("foooo");
        System.out.println(getCountEmptyString(strings));
        System.out.println("--------------------------");
        System.out.println(getCountLength3(strings));
        System.out.println("--------------------------");
        strings = deleteEmptyStrings(strings);
        strings.forEach(System.out::println);
        System.out.println("--------------------------");
        System.out.println(getMergedString(strings, "-"));
        System.out.println("--------------------------");
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(14);
        integers.add(45);
        integers.add(5);
        integers.add(75);
        integers.add(4);

        integers = getSquares(integers);
        integers.forEach(System.out::println);
        System.out.println("--------------------------");
        System.out.println(getMax(integers));
        System.out.println("--------------------------");
        System.out.println(getMin(integers));
        System.out.println("--------------------------");
        System.out.println(getSum(integers));
        System.out.println("--------------------------");
        System.out.println(getAverage(integers));
    }

    private static int getCountEmptyString(List<String> strings){
        strings = strings.stream().filter(String::isEmpty).collect(Collectors.toList());
        return strings.size();
    }

    private static int getCountLength3(List<String> strings){
        strings = strings.stream().filter(s -> s.length() == 3).collect(Collectors.toList());
        return strings.size();
    }

    private static List<String> deleteEmptyStrings(List<String> strings){
        return strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String separator){
        return strings.stream().collect(Collectors.joining(separator));
    }

    private static List<Integer> getSquares(List<Integer> numbers){
        return numbers.stream().map(integer -> integer*integer).collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers){
        return numbers.stream().mapToInt(value -> value).max().getAsInt();
    }

    private static int getMin(List<Integer> numbers){
        return numbers.stream().mapToInt(value -> value).min().getAsInt();
    }

    private static int getSum(List<Integer> numbers){
        return numbers.stream().mapToInt(value -> value).sum();
    }

    private static int getAverage(List<Integer> numbers){
        return (int)(numbers.stream().mapToInt(value -> value).average().getAsDouble());
    }
}
