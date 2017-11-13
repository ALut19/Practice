import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReadTextFromFile_01{

    public static void main(String[] args) {

        String raz = null;
        List<String> wordsList = new ArrayList<>();
        Integer maxRepWorld = 0;

        Map<String, Integer> stat = new TreeMap<>();
        //List <Map.Entry<String, Integer>>
        try {
            Files.readAllLines(Paths.get("src\\main\\java\\Attachments\\doc.txt"), Charset.defaultCharset())
                    .forEach(e -> wordsList.addAll(Arrays.asList(e.split("\\s")))); // считываются данные из файла
            wordsList.forEach(key -> {   //цикл forech
                if (stat.containsKey(key))  //слово - это ключ
                    stat.put(key, stat.get(key)+1);
                else
                    stat.put(key, 1);
            });
        } catch (Exception e){
            e.printStackTrace();
        }

        List <String> keys = stat.entrySet().stream()
                .filter(e -> e.getValue() == Collections.max(stat.values())) //e - это текущий эленент, переменная
                .map(e -> e.getKey()) //обрабатываем пару ключ - значение и получаем значение только ключа
                .collect(Collectors.toList());

        System.out.println(keys);
        //System.out.println(Collections.max(wordsList));


        //  while (scanner.hasNext()) {
     /*       String wordsFromDoc = scanner.useDelimiter("\\s+").next();
            Integer countWord = stat.get(wordsFromDoc);

            if (countWord == null) {
                countWord = 0;
            }
            stat.put(wordsFromDoc, ++countWord);

            if (maxRepWorld < countWord) {
                maxRepWorld = countWord;
                wordsList.clear();
                wordsList.add(wordsFromDoc);
                if (maxRepWorld < 5 | maxRepWorld <= 1) {
                    raz = " раза";
                }else {
                    raz = " раз";
                }
            }
        }
        System.out.println(stat);
        System.out.println("Слово с максимальным количеством повторений: " + wordsList + ", встречается " + maxRepWorld + raz);*/
    }
}