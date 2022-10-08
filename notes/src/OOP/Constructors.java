package OOP;

public class Constructors {
    /*
    Пример конструктора и отличия static полей и обычных

    Конструктор экземпляра и работа со статическим полем класса.

    Пример нескольких конструкторов в одном классе


    Использование модификаторов в конструкторах класса
     */
    public static void main(String[] args) {
//        Пример конструктора и отличия static полей и обычных

        String staticFieldBeforeInstance = ConstructorsExample.staticField; // staticField
        ConstructorsExample constructorsExample = new ConstructorsExample("TEST");
        String staticFieldAfterInstance = ConstructorsExample.staticField; // TEST
        ConstructorsExample anotherInstance = new ConstructorsExample("ANOTHER");
        String staticFieldAfterAnother = ConstructorsExample.staticField; // ANOTHER
        // Вручную меняем значение static поля
        ConstructorsExample.staticField = "New value";

        System.out.println();

        //    Пример нескольких конструкторов в одном классе. Вариант 1: Значения по умолчанию
        // вызов первого конструктора, принимающего все параметры
        SeveralConstructorsOne severalConstructorsOneInstOne = new SeveralConstructorsOne("Adam", 20, 15);
        // вызов второго конструктора, которому достаточно имени
        SeveralConstructorsOne severalConstructorsOneInstTwo = new SeveralConstructorsOne("Zeliboba");

//    Пример нескольких конструкторов в одном классе. Вариант 2: Перегрузка конструкторов
        SeveralConstructorsTwo severalConstructorsTwoInstOne = new SeveralConstructorsTwo("Mitch");
        SeveralConstructorsTwo severalConstructorsTwoInstTwo = new SeveralConstructorsTwo("Taylor", 250, 1444);
        System.out.println();


//        Конструктор экземпляра и работа со статическим полем класса.
        Item appleJuice = new Item("Apple Juice", 15.2f);
        Item orangeJuice = new Item("Orange Juice", 22.7f);

        System.out.println();

    }

    static class ConstructorsExample{
        //Значения указывать необязательно. Хотя их можно использовать как значения по умолчанию
        static String staticField = "staticField";
        String nonStaticField = "nonStaticField";

        ConstructorsExample(String someText) {
            staticField = someText;
            nonStaticField = someText;
        }
    }

    /*
    Представим что есть класс с 3мя полями. Но 2 из них можно присваивать по умолчанию.
    Например, пусть это будет процесс спавна врагов в игре.
    У каждого врага будет имя.
    А также 2 координаты по X и Y
    Имя указывать нужно обязательно, а вот координаты нет. Если координаты не указаны, враг спавнится в точке 1,1
     */

    //    Так писать не стоит. 2 точки изменения параметров enemyPosX и enemyPosY. 2ой вариант получше.
    //    Пример нескольких конструкторов в одном классе. Вариант 1: Значения по умолчанию
    static class SeveralConstructorsOne {
        String enemyName;
        int enemyPosX = 1;
        int enemyPosY = 1;

        SeveralConstructorsOne(String enemyName, int enemyPosX, int enemyPosY) {
            this.enemyName = enemyName;
            this.enemyPosX = enemyPosX;
            this.enemyPosY = enemyPosY;
        }

        SeveralConstructorsOne(String enemyName) {
            this.enemyName = enemyName;
        }
    }
//    Пример нескольких конструкторов в одном классе. Вариант 2: Перегрузка конструкторов
    static class SeveralConstructorsTwo {
        String enemyName;
        int enemyPosX;
        int enemyPosY;

        SeveralConstructorsTwo(String enemyName) {
            this(enemyName, 1, 1);
        }

        SeveralConstructorsTwo(String enemyName, int enemyPosX, int enemyPosY) {
            this.enemyName = enemyName;
            this.enemyPosX = enemyPosX;
            this.enemyPosY = enemyPosY;
        }
    }

//    Конструктор экземпляра и работа со статическим полем класса.
    /*
    В этом классе будут создаваться экземпляры содержащие какие то поля, и обязательное поле id
    Id экземпляра будет создаваться используя статическое поле класса.
     */
    static class Item {
        static private long nextItemID = 0;

        String name;
        float price;
        final long ID;


    Item(String name, float price) {
        this.name = name;
        this.price = price;
        this.ID = getNewID();
    }

    static private long getNewID() {
        return nextItemID++;
    }
}
}
