import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Day6 {

    public static int turnRight(int direction){
        direction+= 90;
        if(direction >=360){
            direction = 0;
        }

        return direction;
    }

    public static void main(String[] args) {
        ArrayList<int[]> positions = new ArrayList<>();
        int currentDirection = 0;
        int distinctPositions =0;
        ArrayList<String[]> map = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("text files/Day6"));
            String line;

            while((line = reader.readLine()) != null){
                String[] mapStrip = reader.readLine().split("");
                for(int i=0; i<mapStrip.length; i++){
                    if(Objects.equals(mapStrip[i], "^")){
                        positions.add(new int[]{map.size(), i});
                    }
                }
                map.add(mapStrip);
            }

            int[] currentPos = positions.getLast();
            for(int[] i: positions){
                System.out.println(Arrays.toString(i));
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
