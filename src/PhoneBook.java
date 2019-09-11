import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class PhoneBook {
    private final static String NAME_ERROR = "Вы ввели неправильно ФИО.";

    private final static Map<String, List<String>> PHONEBASE = new HashMap<>();

    static {
        PHONEBASE.put("Иванов", Arrays.asList("+8 800 800 800", "+88008080"));
        PHONEBASE.put("Иваноа", Arrays.asList("+8 800 800 800", "+880084444444080"));
        PHONEBASE.put("Иванок", Arrays.asList("+8 800 845450", "+88999999008080"));
        PHONEBASE.put("Иванор", Arrays.asList("+8 800 8454545 800", "+88012312308080"));
    }

    private static void printPhone (String name) {
        boolean ok = false;

        // Создаю Entry в цикле.
        for (Map.Entry<String, List<String>> pair : PHONEBASE.entrySet()) {
            if (pair.getKey().equals(name)) {
                for (int i = 0; i < pair.getValue().size(); i++) {
                    System.out.println((i + 1) + ". " + pair.getValue().get(i));
                }

                ok = true;
            }
        }
        if(!ok){
            // Создаю новое исключение.
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void main (String[]args) throws Exception {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name = "";

            while (name.length() == 0){
                name = br.readLine();
            }

            br.close();
            printPhone(name);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(NAME_ERROR);
        }
    }
}