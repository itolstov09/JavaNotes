package collectionsApi;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsNote {
    static HashSet<Integer> hashSet = new HashSet<>();

    static ArrayList<Integer> arrayList = new ArrayList();

    static HashMap<String, Integer> hashMap = new HashMap<>();




    public static void main(String[] args) {
//        workWithHashSet();
//        System.out.println("==========");
//        workWithArrayList();
//        System.out.println("==========");
        workWithHashMap();
    }

    private static void workWithHashMap() {
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("n", null);

        System.out.println(hashMap);
        System.out.println("containtsKey two: " + hashMap.containsKey("two"));
        System.out.println("containtsValue 3: " + hashMap.containsValue(3));
        System.out.println("entrySet: " + hashMap.entrySet());
        System.out.println("get or default");
        System.out.println("get 1, default 0: " + hashMap.getOrDefault("one", 0));
        System.out.println("get 8, default 0: " + hashMap.getOrDefault("eighth", 0));
        System.out.println("keySet: " + hashMap.keySet());
        System.out.println("merge three with 5");
        hashMap.merge("three", 5, Integer::sum);
        System.out.println(hashMap);
        System.out.println("merge four with 4");
        hashMap.merge("four", 4, Integer::sum);
        System.out.println(hashMap);

        System.out.println("merge n with 4");
        hashMap.merge("n", 4, Integer::sum);
        System.out.println(hashMap);

    }

    private static void workWithArrayList() {
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(-6);

        System.out.println("get");
        System.out.println(arrayList.get(1));
        System.out.println("add index");
        arrayList.add(2, -6);
        System.out.println(arrayList);
        System.out.println("set index");
        arrayList.set(0, 2555);
        System.out.println(arrayList);
        System.out.println("indexOf -6");
        System.out.println(arrayList.indexOf(-6));
        System.out.println("lastIndexOf -6");
        System.out.println(arrayList.lastIndexOf(-6));
        System.out.println("subList");
        arrayList.addAll(Arrays.asList(4,5,6,87,8,8,465,16,1));
        System.out.println(arrayList.subList(3, 12));
        System.out.println("ensureCapacity");
        System.out.println("before: " + arrayList);
        arrayList.ensureCapacity(25);
        System.out.println("after: " + arrayList);
        System.out.println("trimToSize");
        arrayList.trimToSize();
        System.out.println(arrayList);

    }

    private static void workWithHashSet() {
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(6);

        System.out.println(hashSet);
        System.out.println("2 in hashSet: " + hashSet.contains(2));
        System.out.println("8 in hashSet: " + hashSet.contains(8));
        System.out.println("hashSet Size: " + hashSet.size());
        System.out.println("hashSet 2 was removed: " + hashSet.remove(2));
        System.out.println(hashSet);
        System.out.println("* 10 on each number");
        hashSet = (HashSet<Integer>) hashSet
                .stream()
                        .map(number -> number * 10)
                                .collect(Collectors.toSet());
        System.out.println(hashSet);
        hashSet.add(2);
        hashSet.add(4);
        hashSet.add(1);
        System.out.println("remove even numbers: " + hashSet.removeIf(number -> number % 2 == 0));
        System.out.println(hashSet);
    }
}
