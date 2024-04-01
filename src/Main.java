import jdk.internal.icu.impl.StringPrepDataReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Используя класс FileReader, прочитайте данные из любого файла
        // и количество букв «а», которые в нём встречаются.
        // Результат запишите в этот же файл вместо данных, которые там были изначально.
        // Для проверки берется текст песни "Смуглянка"

        File fileName = new File("D:\\textik.txt");
        StringBuilder content = new StringBuilder();
        int countA = 0;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
                countA += line.toLowerCase().replaceAll("[^а]", "").length();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(String.valueOf( countA));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (FileReader fileReader2 = new FileReader(fileName)) {
            int read;
            while ((read = fileReader2.read()) != -1) {
                System.out.print((char) read);
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
