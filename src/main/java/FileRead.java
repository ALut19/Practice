/**
 * Created by user on 02.11.2017.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileRead {
    public static void main(String[] args) {
        String data = "Это тестовая строка для записи в файл";
        int noOfLines = 5;
        String browser = "Chrome";


        //  System.out.println(dateFormat.format(date));


        // пишем в файл с помощью FileWriter
        writeUsingFileWriter(data);

        // пишем в файл с помощью BufferdWriter
        writeUsingBufferedWriter(data, noOfLines);

        // пишем в файл с помощью Files
        // writeUsingFiles(data);

        // пишем в файл с помощью OutputStream
        //writeUsingOutputStream(data);
    }

    // пишем в файл с помощью OutputStream
    private static void writeUsingFileWriter(String data) {
        String browser = "Chrome";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_hh.mm.ss");
        //   dateFormat.toString();
        System.out.println(dateFormat.format(date));

        File file = new File("C:/Users/user/Desktop/Java,Selenium/doc1.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
                file.renameTo(new File("C:/Users/user/Desktop/Java,Selenium/doc2.1 " + browser +"_" + dateFormat.format(date) + ".txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeUsingBufferedWriter(String data, int noOfLines) {
        String browser = "Chrome";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        File file = new File("C:/Users/user/Desktop/Java,Selenium/doc.txt");

        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine = data + System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = noOfLines; i > 0; i--){
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }file.renameTo(new File("C:/Users/user/Desktop/Java,Selenium/doc2.txt"));

            //  + browser + dateFormat.format(date)
        }
    }
}
