import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    public static boolean decreasing(String[] arr){
        boolean dec = false;
        for(int i=1; i<arr.length; i++){
            if(Integer.parseInt(arr[i-1]) - Integer.parseInt(arr[i]) > 0){
                dec = true;
            }
            else{
                return false;
            }
        }
        return dec;
    }
    public static boolean increasing(String[] arr){
        boolean inc = false;
        for(int i=1; i<arr.length; i++){
            if(Integer.parseInt(arr[i]) - Integer.parseInt(arr[i-1]) > 0){
                inc = true;
            }
            else{
                return false;
            }
        }
        return inc;
    }
    public static boolean isSafe(String[] arr){
        int diff = 0;
            for(int i=1; i<arr.length; i++){
                int prob1 = Integer.parseInt(arr[i]);
                int prob2 = Integer.parseInt(arr[i-1]);
                if(Math.abs(prob2 - prob1) > diff){
                    diff = Math.abs(prob2 - prob1);
                }
            }

        if(diff > 0 && diff < 4){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<String[]> ls = new ArrayList<>();
        try {
            File myObj = new File("text files/Day2");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split(" ");
                ls.add(temp);
            }
            myReader.close();
//            for(String[] i : ls){
//                System.out.println(Arrays.toString(i));
//            }
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int safe = 0;
        for(String[] arr : ls){
            if(increasing(arr) || decreasing(arr)){
                if(isSafe(arr)){
                    safe ++;
                }
            }
        }

        System.out.println(safe);
    }
}
