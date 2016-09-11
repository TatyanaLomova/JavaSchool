import java.io.*;
import java.util.RandomAccess;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * Created by tanya on 11.09.16.
 */
public class Solution {

    private int[] goodsWeight;
    private int truckCapacity, curCapacity, number;
    private String inputFile, outputFile;

    public Solution(String inFile, String outFile){

        this.inputFile = inFile;
        this.outputFile = outFile;
        truckCapacity = 0;
        curCapacity = 0;
        number = 0;
    }

    public void readParams(){

        try{
            Scanner sc = new Scanner(new File(inputFile));
            if (sc.hasNextInt())
                number = sc.nextInt();

            if (sc.hasNextInt())
                truckCapacity = sc.nextInt();

            goodsWeight = new int [number];

            for (int i = 0; i < number; i++){
                if (sc.hasNextInt())
                    goodsWeight[i] = sc.nextInt();
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeParams(){

        calculateWeight();

        try(FileWriter fw = new FileWriter(outputFile);){
            fw.write(Integer.toString(number) + " " + Integer.toString(curCapacity));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void calculateWeight(){

        number = 0;

        for (int a: goodsWeight){
            if ((curCapacity += a) <= truckCapacity) {
                number++;
            }
            else {
                curCapacity -= a;
                continue;
            }
        }
    }

    public static void main(String[] args) {

        String userDir = getProperty("user.dir");
        Solution sol = new Solution(userDir + "/input.txt", userDir + "/output.txt");
        sol.readParams();
        sol.writeParams();
    }

}
