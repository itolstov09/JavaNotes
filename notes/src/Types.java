import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Types {

    public static void main(String[] args) {

        byte byte_ = 1;
        short short_ = 2;
        int int_ = 3;
        long long_ = 4;

        float float_ = 5.12345f;
        double double_ = 6.123456789;

        char char_ = 'C';
        String string = "Some string for example";
        String numberString = "8";

        boolean true_ = true;

        Map<String, Object> types = new HashMap();
        types.put("byte", byte_);
        types.put("short", short_);
        types.put("int", int_);
        types.put("long", long_);
        types.put("float", float_);
        types.put("double", double_);
        types.put("char", char_);
        types.put("string", string);
        types.put("boolean", true_);
        types.put("string_with_number", numberString);

        // показать содержимое
        System.out.println(types);
//        types.entrySet().forEach(e -> System.out.println(e));
//        types.values().forEach(v -> System.out.println(v.getClass()));
        String intToString1 = ((Integer) int_).toString();
        String intToString2 = Integer.toString(int_);
        String intToString3 = String.valueOf(int_);

        ArrayList<String> aList = new ArrayList();
        types.values().forEach(e -> {
            aList.add(String.valueOf(e));
            aList.add("aga");
        });

        // for each для map и нескольких действий для каждого элемента
        for (Map.Entry<String, Object> type: types.entrySet()) {

        }

        }
    }
