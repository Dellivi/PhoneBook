package MyPhoneBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Shageev Vitaliy
 */
public class MyPhoneBook {

    private final static String NAME_ERROR = "Вы ввели неправильно ФИО.";
    private final static String NAME_NULL = "Вы ничего не ввели, повторите попытку.";

    private final static Map<String, List<String>> PHONEBASE = new HashMap<>();

    static {
        PHONEBASE.put("Иванова", Arrays.asList("+8 951 803 800", "+8 919 354 444"));
        PHONEBASE.put("Петров", Arrays.asList("+8 803 950 340", "+8 800 444 480"));
        PHONEBASE.put("Соколова", Arrays.asList("+8 800 845 450", "+8 899 999 900"));
        PHONEBASE.put("Дегтярев", Arrays.asList("+8 800 845 800", "+8 845 012 312"));
        PHONEBASE.put("Шагеев", Arrays.asList("+8 908 045 404", "+8 863 822 462"));
        PHONEBASE.put("Смирнова", Arrays.asList("+8 234 875 560", "+8 945 262 812"));
        PHONEBASE.put("Соколов", Arrays.asList("+8 560 789 999", "+8 945 016 563"));
        PHONEBASE.put("Власова", Arrays.asList("+8 980 655 850", "+8 960 012 913"));
    }

    private static void printPhone(String name) {
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

        if (!ok) {
            // Создаю новое исключение.
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private static boolean checkEmpty(String name){
        if(!name.isEmpty() && !name.trim().equals("")){
            return true;
        } else {
            System.out.println(NAME_NULL);
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name = br.readLine();

            if(checkEmpty(name)){
                printPhone(name);
            }

            br.close();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(NAME_ERROR);
        }
    }
}
