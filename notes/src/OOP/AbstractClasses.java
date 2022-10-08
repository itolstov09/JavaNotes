package OOP;

public class AbstractClasses {
    /*
    Пример абстрактного класса и его использование
     */

    // Создаем абстрактный класс-родитель
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.makeNoise();
        cat.move();

        Bird bird = new Bird();
        bird.makeNoise();
        bird.move();

        // Можно так делать, но зачем? Скорее всего для интерфейсов такое будет куда полезнее
        Animal typeAnimalClassCat = new Cat();
        typeAnimalClassCat.makeNoise();

        Animal typeAnimalClassBird = new Bird();
        typeAnimalClassBird.move();

        // использование Animal.test()
        cat.test();
        bird.test();
        System.out.println(cat.classGroup);
        System.out.println(bird.classGroup);

        System.out.println();

    }

    abstract static class Animal {
        // придумать поле для абстрактного класса
        String classGroup = "Animals";


        abstract void makeNoise();
        abstract void move();
        void test() {
            System.out.println("Animal test method");
        };
    }

    // Наследуемся от абстрактного класса
    // Реализацию метода test делать не нужно, так как метод не абстрактный
    static class Cat extends Animal {

        @Override
        void makeNoise() {
            System.out.println("Cat: MEOW!");
        }

        @Override
        void move() {
            System.out.println("Cat is running");
        }
    }

    static class Bird extends Animal {

        @Override
        void makeNoise() {
            System.out.println("Bird: *sings*");
        }

        @Override
        void move() {
            System.out.println("Bird is flying");
        }
    }
}
