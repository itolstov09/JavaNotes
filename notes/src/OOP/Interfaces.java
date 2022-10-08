package OOP;

public class Interfaces {
    /*
    пример интерфейса + реализация

    пример иерархии интерфейсов

    стандартные методы интерфейса

    Абстрактный класс + интерфейс

     */

//    пример интерфейса + реализация
    interface Interface1 {
        void in1Method1();
        void in1Method2(String string);
        int in1Method3(int i);
    }

    class class1 implements Interface1 {

        @Override
        public void in1Method1() {

        }

        @Override
        public void in1Method2(String string) {

        }

        @Override
        public int in1Method3(int i) {
            return 0;
        }
    }

//    пример иерархии интерфейсов
    interface Speaker {
        void speak();
    }

    interface Listener {
        void listen();
    }

    // интерфейс наследует другие интерфейсы
    // или говоря другим языком
    // speakerListener ЯВЛЯЕТСЯ и speaker'ом и listrener'ом
    interface SpeakerListener extends Speaker, Listener {
        void makeDialog();
    }

    // создаем 2 класса, реализующих данные интерфейсы

    static class SpeakerListenerImplementation implements SpeakerListener {

        @Override
        public void makeDialog() {

        }

        @Override
        public void speak() {

        }

        @Override
        public void listen() {

        }
    }

    // этот класс реализует интерфейс speaker и listener напрямую. Поэтому не нужно реализовывать метод makeDialog
    static class SpeakerANDListenerImplementation implements Speaker, Listener {

        @Override
        public void speak() {

        }

        @Override
        public void listen() {

        }
    }

//    методы интерфейса с ключевым словом default
    /*
 метод с ключевым словом default позволяет описать реализацию метода

     */
    interface InterfaceWithDefaultMethod {
        void someAbstractMethod();

        default void defaultMethod() {
            System.out.println("Some default actions from interface");
        }
    }

    // класс, который как и положено реализует абстрактные методы интерфейса
    static class Implementor implements InterfaceWithDefaultMethod {

        @Override
        public void someAbstractMethod() {

        }
    }

    // класс, у которого будут переопределены оба метода, хотя только абстрактные методы нужно реализовывать ВСЕГДА
    static class ImplementsWithDefault implements InterfaceWithDefaultMethod {

        @Override
        public void someAbstractMethod() {

        }

        @Override
        public void defaultMethod() {
            InterfaceWithDefaultMethod.super.defaultMethod();
        }
    }


}
