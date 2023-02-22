import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Taska {
    public static void main(String[] args) {
        words();
    }

    public static void words() {
        var map = Stream.of(new Scanner(System.in).nextLine().split("\\W+"))
                .map(String::toLowerCase)
                .filter(x -> !x.isBlank())
                .sorted()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.printf("Total words amount: %d\nTOP 10:\n", map.values().stream().mapToLong(x -> x).sum());
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(v -> System.out.println(v.getValue() + " --- " + v.getKey()));
    }
}
