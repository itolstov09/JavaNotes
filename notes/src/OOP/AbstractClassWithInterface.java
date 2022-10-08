package OOP;

public class AbstractClassWithInterface {
    /*
    Обычно либо используют абстрактный класс, либо интерфейс
    Но никто не запрещает реализовать интерфейс в абстрактном классе
     */

    public static void main(String[] args) {
        Class_ class_Instance = new Class_();
        class_Instance.intMethod1();
        class_Instance.intMethod2();
    }

    interface Interface_ {
        void intMethod1();
        void intMethod2();
    }

    abstract static class AbstractClass implements Interface_ {
        // Так как класс абстрактный, реализовывать методы интерфейса не нужно

        // но можно рассмотреть пример по интереснее. Реализовать 1 из методов интерфейса

        @Override
        public void intMethod1() {
            System.out.println("intMethod1 - Implements from abstract class");
        }
    }

    static class Class_ extends AbstractClass {
        @Override
        public void intMethod2() {
            System.out.println("intMethod2 - From class");
        }
    }

}
