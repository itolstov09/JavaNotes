// Источник: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

package OOP;
/*
В этом примере как при использовании inner класса можно использовать значение outer класса (ShadowTest)
19 строка
 */
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("firstLevelInstance.x = " + this.x);
            System.out.println("ShadowTest.firstLevelInstance.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
//        Вывод:
//        x = 23
//        firstLevelInstance.x = 1
//        ShadowTest.firstLevelInstance.x = 0
    }
}
