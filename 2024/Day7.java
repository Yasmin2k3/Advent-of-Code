import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Day7 {

    public static long concat(long number1, long number2){
        String temp = Long.toString(number1) + Long.toString(number2);
        return Long.parseLong(temp);
    }

    public static boolean evaluateCombinations1(long[] numbers, int index, long currentValue, long targetValue) {
        if (index == numbers.length - 1) {
            return currentValue == targetValue;
        }else if (evaluateCombinations(numbers, index+1, concat(currentValue, numbers[index+1]), targetValue)){
            return true;
        }
        else return evaluateCombinations(numbers, index + 1, currentValue * numbers[index + 1], targetValue);
    }


    public static boolean evaluateCombinations(long[] numbers, int index, long currentValue, long targetValue) {
        if (index == numbers.length - 1) {
            return currentValue == targetValue;
        } else if (evaluateCombinations(numbers, index + 1, currentValue + numbers[index + 1], targetValue)) {
            return true;
        } else if (evaluateCombinations(numbers, index+1, concat(currentValue, numbers[index+1]), targetValue)){
            return true;
        }
        else return evaluateCombinations(numbers, index + 1, currentValue * numbers[index + 1], targetValue);
    }

    public static boolean trueStatement(long target, long[] numbers){
        return evaluateCombinations(numbers, 0, numbers[0], target);
    }

    public static boolean trueStatement1(long target, long[] numbers){
        return evaluateCombinations1(numbers, 0, numbers[0], target);
    }


    public static void main(String[] args) {
        long totalCalculation1 = 0;
        long totalCalculation2 = 0;

        try{
            Scanner input = new Scanner(Paths.get("text files/Day7"));

            while (input.hasNextLine()){
                String line = input.nextLine();
                String[] lines = line.split(":");
                long targetValue = Long.parseLong(lines[0].trim());
                String[] numberString = lines[1].trim().split(" ");
                long[] numbers = new long[numberString.length];

                for(int i=0; i<numbers.length; i++){
                    numbers[i] = Long.parseLong(numberString[i]);
                }

                if(trueStatement1(targetValue, numbers)){
                    totalCalculation1 += targetValue;
                }

                if(trueStatement(targetValue, numbers)){
                    totalCalculation2 += targetValue;
                }
            }

            System.out.println("Part 1: " + totalCalculation1);
            System.out.println("Part 2: " + totalCalculation2);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
