import java.io.*;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws IOException {
        // Open the file
        BufferedReader reader = new BufferedReader(new FileReader("text files/Day5"));

        boolean rules = true;
        List<int[]> ordering = new ArrayList<>();
        List<List<Integer>> sequences = new ArrayList<>();

        String line = reader.readLine();

        // Read the file
        while (line != null) {
            if (line.equals("")) {
                rules = false;
                line = reader.readLine();
                continue;
            }
            if (rules) {
                String[] parts = line.split("\\|");
                int[] rule = {Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
                ordering.add(rule);
            } else {
                List<Integer> sequence = new ArrayList<>();
                for (String num : line.split(",")) {
                    sequence.add(Integer.parseInt(num));
                }
                sequences.add(sequence);
            }
            line = reader.readLine();
        }
        reader.close();

        // Part 1
        int total = 0;
        List<List<Integer>> wrongSequences = new ArrayList<>();

        for (List<Integer> sequence : sequences) {
            boolean allGood = true;

            for (int[] rule : ordering) {
                int firstIx = 0, secondIx = 0;
                if (sequence.contains(rule[0]) && sequence.contains(rule[1])) {
                    firstIx = sequence.indexOf(rule[0]);
                    secondIx = sequence.indexOf(rule[1]);

                    if (firstIx > secondIx) {
                        allGood = false;
                    }
                }
            }

            if (allGood) {
                int middleNum = sequence.get(sequence.size() / 2);
                total += middleNum;
            } else {
                wrongSequences.add(sequence);
            }
        }
        System.out.println(total);

        // Part 2
        boolean changes = true;

        while (changes) {
            changes = false;

            for (int i = 0; i < wrongSequences.size(); i++) {
                List<Integer> sequence = wrongSequences.get(i);

                for (int[] rule : ordering) {
                    int firstIx = 0, secondIx = 0;

                    if (sequence.contains(rule[0]) && sequence.contains(rule[1])) {
                        firstIx = sequence.indexOf(rule[0]);
                        secondIx = sequence.indexOf(rule[1]);

                        if (firstIx > secondIx) {
                            // Swap the elements
                            Collections.swap(sequence, firstIx, secondIx);
                            changes = true;
                        }
                    }
                }
                wrongSequences.set(i, sequence);
            }
        }

        total = 0;

        for (List<Integer> sequence : wrongSequences) {
            int middleNum = sequence.get(sequence.size() / 2);
            total += middleNum;
        }

        System.out.println(total);
    }
}
