import java.io.File;
import java.util.Scanner;

public class AdventOfCode4 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        File input = new File("input4.txt");
        int total = 0;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] ranges = line.split(",");
                String[] range1 = ranges[0].split("-");
                String[] range2 = ranges[1].split("-");

                if (Integer.parseInt(range1[0]) >= Integer.parseInt(range2[0]) && Integer.parseInt(range1[1]) <= Integer.parseInt(range2[1])) {
                    total++;
                }
                else if (Integer.parseInt(range2[0]) >= Integer.parseInt(range1[0]) && Integer.parseInt(range2[1]) <= Integer.parseInt(range1[1])) {
                    total++;
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2() {
        File input = new File("input4.txt");
        int total = 0;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] ranges = line.split(",");
                String[] range1 = ranges[0].split("-");
                String[] range2 = ranges[1].split("-");


                if ((Integer.parseInt(range1[0]) <= Integer.parseInt(range2[1]) && Integer.parseInt(range1[0]) >= Integer.parseInt(range2[0])) ||
                        (Integer.parseInt(range2[0]) <= Integer.parseInt(range1[1])) && Integer.parseInt(range2[0]) >= Integer.parseInt(range1[0])) {
                    total++;
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}