import java.io.File;
import java.util.*;

public class AdventOfCode5 {
    public static void main(String[] args) {
        part1(9);
        part2(9);
    }

    public static void part1(int columns) {
        File input = new File("input5.txt");
        StringBuilder total = new StringBuilder();
        Deque<Character>[] crates = new Deque[columns];
        for(int i = 0; i < columns; i++)
            crates[i] = new LinkedList<Character>();
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (line.charAt(1) == '1') {
                    break;
                }

                int counter = 0;
                for (int i = 1; i < line.length(); i += 4) {
                    if (line.charAt(i) != ' ') {
                        crates[counter].add(line.charAt(i));
                    }
                    counter++;
                }
            }
            while (scanner.hasNextLine()) {
                scanner.next();
                int amount = scanner.nextInt();
                scanner.next();
                int from = scanner.nextInt();
                scanner.next();
                int to = scanner.nextInt();

                for (int i = 0; i < amount; i++) {
                    crates[to - 1].addFirst(crates[from - 1].remove());
                }
            }
            for (int i = 0; i < columns; i++) {
                total.append(crates[i].remove());
            }
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2(int columns) {
        File input = new File("input5.txt");
        StringBuilder total = new StringBuilder();
        Deque<Character>[] crates = new Deque[columns];
        for(int i = 0; i < columns; i++)
            crates[i] = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (line.charAt(1) == '1') {
                    break;
                }

                int counter = 0;
                for (int i = 1; i < line.length(); i += 4) {
                    if (line.charAt(i) != ' ') {
                        crates[counter].add(line.charAt(i));
                    }
                    counter++;
                }
            }
            while (scanner.hasNextLine()) {
                scanner.next();
                int amount = scanner.nextInt();
                scanner.next();
                int from = scanner.nextInt();
                scanner.next();
                int to = scanner.nextInt();

                Stack<Character> temp = new Stack<>();
                for (int i = 0; i < amount; i++) {
                    temp.push(crates[from - 1].remove());
                }
                for (int i = 0; i < amount; i++) {
                    crates[to - 1].addFirst(temp.pop());
                }
            }
            for (int i = 0; i < columns; i++) {
                total.append(crates[i].remove());
            }
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
