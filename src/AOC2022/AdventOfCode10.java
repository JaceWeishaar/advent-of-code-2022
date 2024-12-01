package AOC2022;

import java.io.File;
import java.util.*;

public class AdventOfCode10 {

    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        File input = new File("AOC-2022-inputs/input10.txt");
        int cycle = 0;
        int x = 1;
        int total = 0;
        ArrayList<Integer> signalStrenths = new ArrayList<>();
        boolean addCycle = false;
        String line = "";
        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                cycle++;
                if (!addCycle) {
                    if (line.length() > 5)
                        x += Integer.parseInt(line.substring(5));
                    line = scanner.nextLine();
                }
                if (cycle % 40 == 20) {

                    signalStrenths.add(cycle * x);
                }
                if (!line.contains("noop")) {
                    addCycle = !addCycle;
                }
            }

            for (int i = 0; i < signalStrenths.size(); i++) {
                total += signalStrenths.get(i);
            }

            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2() {
        File input = new File("AOC-2022-inputs/input10.txt");
        String output = "";
        int x = 1;
        String line = "";
        int cycle = 1;
        int counter = 0;

        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                if (counter == 0) {
                    line = scanner.nextLine();
                    if (line.contains("addx")) {
                        counter++;
                    }
                } else {
                    counter++;
                }

                if (cycle - 1 == x + 1 || cycle - 1 == x - 1 || cycle - 1 == x) {
                    output += '#';
                } else {
                    output += '.';
                }
                if (cycle == 40) {
                    cycle = 0;
                    System.out.println(output);
                    output = "";
                }

                if (counter == 2) {
                    x += Integer.parseInt(line.substring(5));
                    counter = 0;
                }

                cycle++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}