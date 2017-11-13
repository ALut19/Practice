
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Collections;
/**
 * Created by user on 03.11.2017.
 */
public class ReadTextFromFile {
    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("C:/Users/user/Desktop/Java,Selenium/nums.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Integer> numbersList = new ArrayList<>();

        while (scanner.hasNext()) {
            int numbers = Integer.parseInt(scanner.useDelimiter(",").next());
            numbersList.add(Integer.valueOf(numbers)); // сортировка по возростанию
        }
        List<Integer> aaa = new ArrayList<>(numbersList);

        Collections.sort(aaa, Collections.reverseOrder()); // сортировка по убыванию
        System.out.println(aaa);

        System.out.println(numbersList);
    }
}
