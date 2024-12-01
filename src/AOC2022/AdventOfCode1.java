package AOC2022;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class AdventOfCode1 {
    public static void main(String[] args) {
        File input = new File("AOC-2022-inputs/input.txt");
        Stack<Integer> food = new Stack<>();
        try {
            Scanner inputScanner = new Scanner(input);
            int carriedFood = 0;
            while (inputScanner.hasNext()) {
                String line = inputScanner.nextLine();
                if (!line.isBlank()) {
                    carriedFood += Integer.parseInt(line);
                } else {
                    food.push(carriedFood);
                    carriedFood = 0;
                }
            }
            int max = 0;
            int max2 = 0;
            int max3 = 0;
            while (!food.empty()) {
                carriedFood = food.pop();
                if (carriedFood > max) {
                    max3 = max2;
                    max2 = max;
                    max = carriedFood;
                } else if (carriedFood > max2) {
                    max3 = max2;
                    max2 = carriedFood;
                } else if (carriedFood > max3) {
                    max3 = carriedFood;
                }
            }
            System.out.println(max + max2 + max3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}