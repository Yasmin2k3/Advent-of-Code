import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day4 {
    public static boolean search(ArrayList<ArrayList<Character>> grid, int row, int col, String word){
        int m = grid.size();
        int n = grid.getFirst().size();

        // return false if the given coordinate
        // does not match with first index char.
        if (grid.get(row).get(col) != word.charAt(0))
            return false;

        int len = word.length();

        // x and y are used to set the direction in which
        // word needs to be searched.
        int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // This loop will search in all the 8 directions
        for (int dir = 0; dir < 8; dir++) {
            int k, currX = row + x[dir],
                    currY = col + y[dir];

            // First character is already checked, match
            // remaining
            for (k = 1; k < len; k++) {
                if (currX >= m || currX < 0 || currY >= n
                        || currY < 0)
                    break;

                if (grid.get(currX).get(currY) != word.charAt(k)) {
                    break;
                }

                currX += x[dir];
                currY += y[dir];
            }

            if (k == len)
                return true;
        }

        return false;
    }

    static int searchWord(ArrayList<ArrayList<Character>> grid, String word) {
        int m = grid.size();
        int n = grid.getFirst().size();

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(grid, i, j, word)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        try{
            ArrayList<ArrayList<Character>> input = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("text files/Day4"));
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<Character> charArray = new ArrayList<>();
                for(char i : line.toCharArray()){
                    charArray.add(i);
                }
                input.add(charArray);
            }
            System.out.println("Part 1: " + searchWord(input, "SAMX"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
