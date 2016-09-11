import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

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
            while(sc.hasNext()){
                number = sc.nextInt();
                truckCapacity = sc.nextInt();
                for (int i = 0; i < number; i++)
                    goodsWeight[i] = sc.nextInt();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeParams(){

        calculateWeight();

        try{
            PrintWriter pw = new PrintWriter(new File(outputFile));
            pw.println(number+" "+curCapacity);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void calculateWeight(){

        for (int a: goodsWeight){
            if ((curCapacity += a) > truckCapacity) continue;
                else {
                number++;
                curCapacity += a;
            };
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution("input.txt","output.txt");
        sol.readParams();
        sol.writeParams();
    }

}
