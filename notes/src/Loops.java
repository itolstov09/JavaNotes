/* Заметки по Java

 Заметки разделены на блоки

 Циклы
 1_ - Цикл for
     1_1 - for i
     1_2 - for each
     1_3 - for i с несколькими действиями при итерации
     1_4 - for без действий при итерации (хотя зачем он нужен когда есть while?)

 2_ - Цикл while
     2_1 - Пример while
     2_2 - Бесконечный while

 */

public class Loops {
    public static void main(String[] args) {
        System.out.println("Циклы");
//        Для циклов нужна последовательность элементов.
//        Пускай это будут имена
        String[] names = {"Adam", "John", "Bill", "Mary", "Kate"};
        System.out.print("Массив имен: Adam John Bill Mary Kate");


        System.out.println("1_ - Цикл for");
        System.out.println("1_1 - for i: вывод нечетных элементов");
        for (int i = 0; i < names.length; i++) {
            if (i %2 != 0) {
                System.out.print(names[i] + " ");
            }
        }
        System.out.println();
        // Вывод: John Mary

//      Если нужно было вывести все имена из массива на экран,
//      то конечно можно было через тот же for i без условия.
//      Но для таких случаев лучше подходит for each


        System.out.println("1_2 - for each");
        for (String name : names) {
            System.out.print(name + " ");
        }
//        Вывод: Adam John Bill Mary Kate


        System.out.println("1_3 - for i с несколькими действиями при итерации");
        for (int i = 0, j = 0; i < names.length; i++, j += 2) {
            String scream = "A";
            for (int k = 0; k <= j; k += 2) {
                scream += scream;
            }
            System.out.printf("%s says: \"%s\"%n", names[i], scream);
        }
//        Вывод:
//        Adam says: "AA"
//        John says: "AAAA"
//        Bill says: "AAAAAAAA"
//        Mary says: "AAAAAAAAAAAAAAAA"
//        Kate says: "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"


        System.out.println("1_4 - for без действий при итерации (хотя зачем он нужен когда есть while?)");
        // Пример просто иллюстрирует что так можно, можно но не нужно. Или пример просто неудачный
        int loopLimit = 3;
        for ( int i = 0; ; ) {
            if ( loopLimit == 0) {
                break;
            }
            loopLimit--;
            System.out.println("infinite for");
        }

        System.out.println("2_ - Цикл while");
        System.out.println("2_1 - Пример while");
        int i = 0;
        while ( i < names.length ) {
            System.out.print(names[i] + " ");
            i++;
        }
//        Вывод: Adam John Bill Mary Kate
    }
}
