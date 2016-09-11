import java.io.*;
import java.util.RandomAccess;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * Created by tanya on 11.09.16.
 */
public class Solution {

    private int[] number;
    private int size, l1, l2, r1, r2;
    private String inputFile, outputFile;

    public Solution(String inFile, String outFile){
        this.inputFile = inFile;
        this.outputFile = outFile;
        size = 0;
        l1 = l2 = r1 = r2 = 0;
    }

    public void readParams(){

        try(Scanner sc = new Scanner(new File(inputFile));){
            if (sc.hasNextInt())
                size = sc.nextInt();

            number = new int[size];

            for (int i = 0; i < size; i++){
                if (sc.hasNextInt())
                    number[i] = sc.nextInt();
            }

                l1 = sc.nextInt()-1;
                r1 = sc.nextInt()-1;
                l2 = sc.nextInt()-1;
                r2 = sc.nextInt()-1;


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeArray(){

        reverse(l1,r1);
        reverse(l2,r2);

        try(FileWriter fw = new FileWriter(outputFile);){
            for (int a : number)
                fw.write(Integer.toString(a) + " ");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void reverse(int left, int right){

        int tmp;

        for (int i = left; i < right; i++) {
            if (left == right) break;
            tmp = number[i];
            number[i] = number[right];
            number[right] = tmp;
            right--;
        }
    }

    public static void main(String[] args) {
        String userDir = getProperty("user.dir");
        Solution sol = new Solution(userDir + "/input.txt", userDir + "/output.txt");
        sol.readParams();
        sol.writeArray();
    }

}
/*
* Задан массив из n чисел (a1, a2,..., an). На нем два раза осуществляют операцию переворота подмассива: первый раз с позиции l1 по r1, второй раз с позиции l2 по r2.

При перевороте подмассива порядок элементов в нем меняется на обратный.

Ваша задача — найти последовательность после осуществления переворотов.


Входные данные
В первой строке входного файла дано число n (1 ≤ n ≤ 100) — количество чисел в массиве. Во второй строке через пробел записаны целые
 числа a1, a2,..., an (1 ≤ ai ≤ 100). В третьей строке записаны через пробел числа l1 и r1 (1 ≤ l1 ≤ r1 ≤ n), в четвертой — числа l2 и r2 (1 ≤ l2 ≤ r2 ≤ n).


Выходные данные
Выведите последовательность (a1, a2,..., an) после осуществления переворотов. Числа разделяйте пробелом.
* */