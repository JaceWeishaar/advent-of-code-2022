package AOC2024;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AdventOfCode01 {

    public static void main(String[] args) {
        partA();
        partB();
    }

    public static void partA() {
        File input = new File("AOC-2024-inputs/input01.txt");
        ArrayList<Integer> listLeft = new ArrayList<>();
        ArrayList<Integer> listRight = new ArrayList<>();
        try {
            Scanner inputScanner = new Scanner(input);
            int totalDistance = 0;

            while (inputScanner.hasNext()) {
                String line = inputScanner.nextLine();
                if (!line.isBlank()) {
                    Scanner lineScanner = new Scanner(line);

                    listLeft.add(lineScanner.nextInt());
                    listRight.add(lineScanner.nextInt());
                }
            }

            Collections.sort(listLeft);
            Collections.sort(listRight);

            for (int i = 0; i < listLeft.size(); i++) {
                totalDistance += Math.abs(listLeft.get(i) - listRight.get(i));
            }

            System.out.println("\n\tTotal Distance: " + totalDistance);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void partB() {
        File input = new File("AOC-2024-inputs/input01.txt");
        ArrayList<Integer> listLeft = new ArrayList<>();
        ArrayList<Integer> listRight = new ArrayList<>();
        try {
            Scanner inputScanner = new Scanner(input);
            int similarityScore = 0;

            while (inputScanner.hasNext()) {
                String line = inputScanner.nextLine();
                if (!line.isBlank()) {
                    Scanner lineScanner = new Scanner(line);

                    listLeft.add(lineScanner.nextInt());
                    listRight.add(lineScanner.nextInt());
                }
            }

            for (Integer integer : listLeft) {
                similarityScore += integer * totalCount(integer, listRight);
            }

            System.out.println("\n\tSimilarity Score: " + similarityScore);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int totalCount(int id, ArrayList<Integer> list) {
        AtomicInteger count = new AtomicInteger();

        list.forEach((integer) -> {
            if (integer == id) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }
}