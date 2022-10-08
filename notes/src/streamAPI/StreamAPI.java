package streamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    // Сделать декорацию
//    Имитируем Результат от БД, который вернулся в виде JSON, который уже был переделан в List<Map>
//    Внутри списка будет храниться информация о сотруднике
//    Имя
//    Фамилия
//    Возраст
//    Должность
//    оклад
//    isOk

//    Получить общую сумму ЗП всех сотрудников
    static Long getSalarySum(List<Map> list) {
        return list.stream()
                .mapToLong(employee -> (int) employee.get("Salary"))
                //хотя тут проще использовать .sum()
                .reduce(0, Long::sum);
    }

//    Строку, состоящую из всех Фамилий по алфавиту
    static String getSurnamesList(List<Map> list) {
        return list.stream()
                .map(employee -> (String) employee.get("Surname"))
                .sorted()
                .collect(Collectors.joining(", "));
    }

//    Получить список должностей, ЗП которых меньше чем Х
    static List<String> getUnderpaymentPosts(List<Map> list, int salary) {
        return list.stream()
                .filter(employee -> (int) employee.get("Salary") < salary)
                .map(employee -> (String) employee.get("Post"))
                .distinct()
                .collect(Collectors.toList());
    }

//    Получить список имен тех сотрудников, которые ОК
    static List<String> getOKEmployeeNames(List<Map> list) {
        return list.stream()
                .filter(employee -> (boolean) employee.get("isOK") == true)
                .map(employee -> (String) employee.get("Name"))
                .collect(Collectors.toList());
    }

//    Вывести возраст сотрудников в формате "<int> лет"
    static List<String> getEmployeesAge(List<Map> list) {
        return list.stream()
                .map(employee -> employee.get("Age").toString() + " лет")
                .collect(Collectors.toList());
    }

//    Получить количество программистов
    static long getProgrammersCount(List<Map> list) {
        return list.stream()
                .filter(employee -> employee.get("Post") == "Programmer")
                .count();
    }



    public static void main(String[] args) {
        List<Map> resultList = new ArrayList();

        Map<String, Object> row1 = new HashMap<>();
        Map<String, Object> row2 = new HashMap<>();
        Map<String, Object> row3 = new HashMap<>();
        Map<String, Object> row4 = new HashMap<>();
        Map<String, Object> row5 = new HashMap<>();
        Map<String, Object> row6 = new HashMap<>();

        row1.put("Name", "Elliot");
        row1.put("Surname", "Alderson");
        row1.put("Age", 23);
        row1.put("Post", "Programmer");
        row1.put("Salary", 120000);
        row1.put("isOK", true);

        row6.put("Name", "John");
        row6.put("Surname", "Anderson");
        row6.put("Age", 26);
        row6.put("Post", "Programmer");
        row6.put("Salary", 150000);
        row6.put("isOK", true);

        row2.put("Name", "Adam");
        row2.put("Surname", "Smith");
        row2.put("Age", 38);
        row2.put("Post", "Director");
        row2.put("Salary", 350000);
        row2.put("isOK", false);

        row3.put("Name", "Maria");
        row3.put("Surname", "Jackson");
        row3.put("Age", 19);
        row3.put("Post", "Secretary");
        row3.put("Salary", 120000);
        row3.put("isOK", true);

        row4.put("Name", "Rick");
        row4.put("Surname", "Sanchez");
        row4.put("Age", 62);
        row4.put("Post", "Scientist");
        row4.put("Salary", 9_999_999);
        row4.put("isOK", true);

        row5.put("Name", "Consuela");
        row5.put("Surname", "Griffin");
        row5.put("Age", 48);
        row5.put("Post", "Cleaning Manager");
        row5.put("Salary", 50000);
        row5.put("isOK", true);


        resultList.add(row1);
        resultList.add(row2);
        resultList.add(row3);
        resultList.add(row4);
        resultList.add(row5);
        resultList.add(row6);

        System.out.println("Сумма ЗП всех сотрудников");
        System.out.println(getSalarySum(resultList));
        System.out.println("Список фамилий по алфавиту");
        System.out.println(getSurnamesList(resultList));
        System.out.println("Сотрудники с ЗП меньше чем 180000");
        System.out.println(getUnderpaymentPosts(resultList, 180000));
        System.out.println("Адекваты компании");
        System.out.println(getOKEmployeeNames(resultList));
        System.out.println("Возраст сотрудников");
        System.out.println(getEmployeesAge(resultList));
        System.out.println("Количество программистов компании");
        System.out.println(getProgrammersCount(resultList));

    }
}
