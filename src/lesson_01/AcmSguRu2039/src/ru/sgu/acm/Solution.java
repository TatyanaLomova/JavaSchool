import java.io.*;
import java.util.RandomAccess;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * Created by tanya on 11.09.16.
 */
public class Solution {

    private String inputFile, outputFile;
    private String dividers="0123456789.-*/~!@#$%^&*()_+ \r\t\n";
    //private String[] words;
    private int number;

    public Solution(String inFile, String outFile){
        this.inputFile = inFile;
        this.outputFile = outFile;
        number = 0;
    }

    public void readWords(){

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))){

            int symbol = bufferedReader.read();
            System.out.println((char)symbol + " " + symbol);
            int flag = 0;

            while (symbol != -1) {

                symbol = bufferedReader.read();

                if ( (symbol > 64) &&(symbol < 91) || (symbol > 96) && (symbol < 123) ){
                    flag = 1;
                }
                else if (flag == 1) {
                    number++;
                    flag = 0;
                }

            }
            if (flag == 1) number ++;

        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNumber(){

        try(FileWriter fw = new FileWriter(outputFile);){
            fw.write(Integer.toString(number));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String userDir = getProperty("user.dir");
        Solution sol = new Solution(userDir + "/input.txt", userDir + "/output.txt");
        sol.readWords();
        sol.writeNumber();
    }

}
/*
* Определим слово как последовательность латинских букв алфавита. Все остальные символы являются разделителями.

Дан текст, состоящий из символов с номерами от 32 до 127 (см. таблицу символов ASCII). Ваша задача — подсчитать количество слов в этом тексте.


Входные данные
Входные данные состоят из единственной строки, длиной не более 10000 символов — исходный текст.


Выходные данные
Выведите единственное число — количество слов в данном тексте.
*
* */