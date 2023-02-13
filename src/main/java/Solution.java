import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final int ASCII_SYMBOL_A = 65;
    private static final int ASCII_SYMBOL_Z = 90;
    private static final int LOWER_CASE = 32;

    private static final HashMap<Character, Integer> symbolsCounter = new HashMap<>();

    public Solution() {
    }

    public void readFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла для чтения");
        boolean isReadable = true;
        while (isReadable) {
            try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(scanner.nextLine()))) {
                String data;
                StringBuilder fileInputData = new StringBuilder();
                while ((data = bufferedReader.readLine()) != null) {
                    fileInputData.append(data);
                }
                countingSymbols(fileInputData.toString());
                isReadable = false;
            } catch (IOException e) {
                throw new RuntimeException("Неправильное имя файла");
            }
        }
    }

    private void countingSymbols(String fileInputData) {
        for (int i = 0; i < fileInputData.length(); i++) {
            char symbol = fileInputData.charAt(i);
            if (symbolsCounter.containsKey(symbol)){
                symbolsCounter.put(symbol, symbolsCounter.get(symbol) + 1);
            }
        }
    }

    public void fillWithSymbols(){
        for (int i = ASCII_SYMBOL_A; i <= ASCII_SYMBOL_Z; i++) {
            symbolsCounter.put((char) i, 0);
            symbolsCounter.put((char) (i + LOWER_CASE), 0);
        }
    }

    public void writeFile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите файл для записи");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scanner.nextLine()))){
            for (Map.Entry<Character, Integer> entry : symbolsCounter.entrySet()) {
                bufferedWriter.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка");
        }
    }
}
