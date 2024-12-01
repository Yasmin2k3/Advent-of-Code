import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        try {
            File myObj = new File("text files/Day1");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split("   ");
                list1.add(temp[0]);
                list2.add(temp[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int distance = 0;

        try{
            for (int i=0; i<list1.size(); i++){
                distance += Math.abs(Integer.parseInt(list1.get(i)) - Integer.parseInt(list2.get(i)));
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("List 1 bigger than List 2: " + e);
        }

        System.out.println(distance);

        //Part 2:
        //there has to be a better way of doing this:
        int similarityScore = 0;
        for (String i : list1) {
            int count = 0;
            for (String j : list2) {
                if (j.equals(i)) {
                    count++;
                }
            }
            similarityScore += Integer.parseInt(i) * count;
        }
        System.out.println(similarityScore);
    }
}
