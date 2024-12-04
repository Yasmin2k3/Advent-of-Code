import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.*;

public class Day3 {

    public static List<String> clean(String s) {
        Pattern p = Pattern.compile("mul\\([0-9]{1,3},[0-9]{1,3}\\)");
        Matcher matcher = p.matcher(s);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    public static int mul(String s) {
        String[] numbers = s.replace("mul(", "").replace(")", "").split(",");
        int a = Integer.parseInt(numbers[0].trim());
        int b = Integer.parseInt(numbers[1].trim());
        return a * b;
    }

    public static void main(String[] args) throws IOException {
        try {
            // Read the file content
            String data = new String(Files.readAllBytes(new File("text files/Day3").toPath()));

            // Split the input data based on "do()" or "don't()"
            String regex = "(do\\(\\)|don't\\(\\))";
            Pattern pattern = Pattern.compile(regex);
            ArrayList<String> partition = getStrings(pattern, data);

            int total = 0;
            boolean doOperation = true;

            // Process each part of the split data
            for (String s : partition) {
                if (s.equals("do()")) {
                    doOperation = true;
                } else if (s.equals("don't()")) {
                    doOperation = false;
                }
                if (doOperation) {
                    for (String x : clean(s)) {
                        total += mul(x);
                    }
                }
            }

            // Print the total
            System.out.println(total);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static ArrayList<String> getStrings(Pattern pattern, String data) {
        Matcher matcher = pattern.matcher(data);

        ArrayList<String> partition = new ArrayList<>();
        int lastIndex = 0;

        while (matcher.find()) {
            // Add the text before the match
            if (matcher.start() > lastIndex) {
                partition.add(data.substring(lastIndex, matcher.start()));
            }
            // Add the matched delimiter
            partition.add(matcher.group());
            lastIndex = matcher.end();
        }

        if (lastIndex < data.length()) {
            partition.add(data.substring(lastIndex));
        }
        return partition;
    }
}