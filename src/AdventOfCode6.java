import java.io.File;
import java.util.Scanner;

public class AdventOfCode6 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        File input = new File("input6.txt");
        int total = 0;

        try {
            Scanner scanner = new Scanner(input);
            String line = scanner.nextLine();
            boolean flag = true;
            int counter = 0;

            while (flag) {
                String sub = line.substring(counter, counter + 4);
                if (!(sub.charAt(0) == sub.charAt(1) || sub.charAt(0) == sub.charAt(2) ||
                        sub.charAt(0) == sub.charAt(3) || sub.charAt(1) == sub.charAt(2) ||
                        sub.charAt(1) == sub.charAt(3) || sub.charAt(2) == sub.charAt(3))) {
                    flag = false;
                    total = counter + 4;
                }
                counter++;
            }

            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2() {
        File input = new File("input6.txt");
        int total = 0;

        try {
            Scanner scanner = new Scanner(input);
            String line = scanner.nextLine();
            boolean flag = true;
            boolean duplicate;
            int counter = 0;

            while (flag) {
                duplicate = false;
                if (counter + 14 < line.length()) {
                    String sub = line.substring(counter, counter + 14);
                    for (int i = 0; i < sub.length(); i++) {
                        String subsub = sub.substring(0, i) + sub.substring(i + 1);
                        if (subsub.contains(String.valueOf(sub.charAt(i)))) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (!duplicate) {
                        flag = false;
                        total = counter + 14;
                    }
                    counter++;
                }

            }

            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
