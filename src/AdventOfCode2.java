import java.io.File;
import java.util.Scanner;

public class AdventOfCode2 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        File input = new File("input2.txt");
        int total = 0;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                int points = 0;
                String elf = scanner.next();
                String you = scanner.next();

                switch (you) {
                    case ("X"):
                        points += 1;
                        if (elf.equals("A"))
                            points += 3;
                        if (elf.equals("C"))
                            points += 6;
                        break;
                    case ("Y"):
                        points += 2;
                        if (elf.equals("B"))
                            points += 3;
                        if (elf.equals("A"))
                            points += 6;
                        break;
                    case ("Z"):
                        points += 3;
                        if (elf.equals("C"))
                            points += 3;
                        if (elf.equals("B"))
                            points += 6;
                        break;
                }
                total += points;
            }
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2() {
        File input = new File("input2.txt");
        int total = 0;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                int points = 0;
                String elf = scanner.next();
                String you = scanner.next();

                switch (you) {
                    case ("X"):
                        if (elf.equals("A"))
                            points += 3;
                        if (elf.equals("B"))
                            points += 1;
                        if (elf.equals("C"))
                            points += 2;
                        break;
                    case ("Y"):
                        points += 3;
                        if (elf.equals("A"))
                            points += 1;
                        if (elf.equals("B"))
                            points += 2;
                        if (elf.equals("C"))
                            points += 3;
                        break;
                    case ("Z"):
                        points += 6;
                        if (elf.equals("A"))
                            points += 2;
                        if (elf.equals("B"))
                            points += 3;
                        if (elf.equals("C"))
                            points += 1;
                        break;
                }
                total += points;
            }
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}