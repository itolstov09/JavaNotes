import java.util.Locale;
import java.util.Optional;

public class COptional {
    public static void main(String[] args) {
        String result = Optional.of("Hi").orElse(sayHola());
        System.out.println(result);
        System.out.println(Optional.empty().orElse(sayHola()));
//        В обоих случаях будет запускаться SayHola. Для исправления предлагают использовать OrElseGet
        String result2 = Optional.of("Hello").orElseGet(() -> sayHola());
        Optional<String> someStr = Optional.ofNullable("wassup");
        ifPresentTest(someStr);
        Optional<String> someStr2 = Optional.ofNullable(null);
        ifPresentTest(someStr2);

        System.out.println("map");
        System.out.println(mapTest(someStr));
        System.out.println(mapTest(someStr2));

        Optional<Integer> someNum = Optional.ofNullable(4);
        Optional<Integer> someNum2 = Optional.ofNullable(20);
        Optional<Integer> someNull = Optional.ofNullable(null);
        System.out.println(chainMapTest(someNum));
        System.out.println(chainMapTest(someNull));
        System.out.println(chainMapTest(someNum2));

        int num1 = 3;
        int num2 = 4;

        System.out.println(filterTest(num1));
        System.out.println(filterTest(num2));
    }

    private static int filterTest(int num) {
        return Optional.ofNullable(num)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .orElse(0);
    }

    // Лютая наркомания :D Так делать вообще не стоит.
    private static int chainMapTest(Optional<Integer> optInt) {
        return optInt
                .map(COptional::processing1)
                .orElse(150);
    }
    public static Integer processing1(Integer number) {
        if (number < 10) {
            number = number * 2;
        } else {
            number = null;
        }
        return number;
    }

    public static void ifPresentTest(Optional<String> arg) {
        arg.ifPresent(text -> {
            System.out.println(text.toUpperCase(Locale.ROOT));
        });
    }

    public static String mapTest(Optional<String> arg) {
        return arg.map(String::toUpperCase)
                .orElse("DEFAULT");
    }

    public static String sayHola() {
        System.out.println("SayHola is running");
        return "Hola";
    }
}
