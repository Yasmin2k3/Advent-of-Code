import java.io.*;
import java.util.*;

public class Day2 {
    public static boolean safe1(List<Integer> levels) {
        // Check the condition: differences between consecutive elements are between 1 and 3
        for (int i = 0; i < levels.size() - 1; i++) {
            int diff = Math.abs(levels.get(i) - levels.get(i + 1));
            if (diff < 1 || diff > 3) {
                return false;
            }
        }

        // Check if levels are sorted in ascending or descending order
        List<Integer> sorted = new ArrayList<>(levels);
        Collections.sort(sorted);
        List<Integer> reversed = new ArrayList<>(sorted);
        Collections.reverse(reversed);

        return levels.equals(sorted) || levels.equals(reversed);
    }

    public static boolean safe2(List<Integer> levels) {
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> modifiedArray = new ArrayList<>(levels);
            modifiedArray.remove(i);
            if (safe1(modifiedArray)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            // Read input from the file
            List<List<Integer>> ls = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("text files/Day2"));
            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> numbers = new ArrayList<>();
                String[] temp = line.split(" ");
                for(String i : temp){
                    numbers.add(Integer.parseInt(i));
                }
                ls.add(numbers);
            }
            br.close();

            int part1 = 0;
            for(List<Integer> arr : ls){
                if(safe1(arr)){
                    part1 ++;
                }
            }

            System.out.println(part1);

            int part2 = 0;
            for(List<Integer> arr : ls){
                if(safe2(arr)){
                    part2++;
                }
            }
            System.out.println(part2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}