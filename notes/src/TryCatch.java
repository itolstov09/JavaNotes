public class TryCatch {
//    try/catch/finally
//    1_ try/catch
//    несколько блоков catch
//    несколько классов исключений в одном блоке catch
//    2_ try/catch/finally
//    3_ try/catch with resources



//        try {
//
//        } catch () {
//
//        } finally {
//
//        }


    public static void main(String[] args) {

        System.out.println("1_ try/catch");
        System.out.println("try/catch: возникновение ошибки в блоке try");
        try {
            System.out.println("try starts");
            int result = 10 / 0; // на этой строке ошибка, экстренный выход из блока try.
            System.out.println(result);
            System.out.println("try ends");
        } catch (ArithmeticException arithmeticException) {
            System.out.println("catch stars");
//            получить значение result не получится, так как переменная была в блоке try
//            System.out.println(result);
            System.out.println(String.format("Error msg: '%s'", arithmeticException.getMessage()));
            System.out.println("catch ends");
        }
        System.out.println("try catch block is ends");

    }
}
