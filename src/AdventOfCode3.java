import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventOfCode3 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        ArrayList<Character> alphabet = getAlphabetArray();
        File input = new File("input3.txt");
        int total = 0;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String comp1 = line.substring(0, line.length() / 2);
                String comp2 = line.substring(line.length() / 2);
                for (int i = 0; i < comp1.length(); i++) {
                    if (comp2.contains(Character.toString(comp1.charAt(i)))) {
                        total += alphabet.indexOf(comp1.charAt(i)) + 1;
                        break;
                    }
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2() {
        File input = new File("input3.txt");
        ArrayList<Character> alphabet = getAlphabetArray();
        int total = 0;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                String line1 = scanner.nextLine();
                String line2 = scanner.nextLine();
                String line3 = scanner.nextLine();

                for (int i = 0; i < line1.length(); i++) {
                    if (line2.contains(Character.toString(line1.charAt(i))) && line3.contains(Character.toString(line1.charAt(i)))) {
                        total += alphabet.indexOf(line1.charAt(i)) + 1;
                        break;
                    }
                }
            }
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Character> getAlphabetArray() {
        ArrayList<Character> alphabet = new ArrayList<>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');
        alphabet.add('A');
        alphabet.add('B');
        alphabet.add('C');
        alphabet.add('D');
        alphabet.add('E');
        alphabet.add('F');
        alphabet.add('G');
        alphabet.add('H');
        alphabet.add('I');
        alphabet.add('J');
        alphabet.add('K');
        alphabet.add('L');
        alphabet.add('M');
        alphabet.add('N');
        alphabet.add('O');
        alphabet.add('P');
        alphabet.add('Q');
        alphabet.add('R');
        alphabet.add('S');
        alphabet.add('T');
        alphabet.add('U');
        alphabet.add('V');
        alphabet.add('W');
        alphabet.add('X');
        alphabet.add('Y');
        alphabet.add('Z');

        return alphabet;
    }
}