import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Day3 {
    public static int isMiddle(int index, String line){
        String nums = "1234567890";
        int numSize = 0;
        while(nums.contains(Character.toString(line.charAt(index))) || numSize <= 3){
            //System.out.println(line.charAt(index));
            numSize ++;
            index++;
        }

        //System.out.println(numSize);
        return numSize;
    }

    public static void main(String[] args) {
        String start = "mul(";
        String end = ")";
        String mid = ",";
        boolean doo = true;
        try{
            ArrayList<String> commands = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("text files/Day3"));
            String line;
            while ((line = br.readLine()) != null) {
                try{
                    for(int i=0; i<line.length(); i++){
                        if(line.substring(i, i + 4).equals(start)){
                            int ending = i+4;
                            int diff = isMiddle(i+4, line);
                            if(diff > 0 && diff < 8){
                                ending+= diff;
                                    if(line.charAt(ending) == ')'){
                                        commands.add(line.substring(i, ending));
                                }
                            }
                        }
                    }
                }catch(IndexOutOfBoundsException e){
                }

                int d = 0;
                for(String s: commands){
                    String[] temp = s.split(",");
                    System.out.println(Arrays.toString(temp));
                    //for(int i=0; i<temp.length; i++);

                    int a = Integer.parseInt(temp[0].substring(4));
                    int b = Integer.parseInt(temp[1]);
                    System.out.println("a : " + a + " b: " + b);
                    int c = a * b;
                     d += c;
                }

                System.out.println("part 1: " + d);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
