package OOP;

public class NoteClass {
    public static void main(String[] args) {
        Class<String> stringInfo = String.class;
        String aga = "aga";
        Class<? extends String> aClass = aga.getClass();
        System.out.println();
    }

}
