package AOC2022;

import java.io.File;
import java.util.*;

public class AdventOfCode9 {

    static ArrayList<String> visited = new ArrayList<>();
    static ArrayList<String> longVisited = new ArrayList<>();
    static int[] head = new int[2];
    static int[] tail = new int[2];

    static int[][] longRope = new int[10][2];

    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        File input = new File("AOC-2022-inputs/input9.txt");

        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");

                for (int i = 0; i < Integer.parseInt(line[1]); i++) {
                    switch (line[0]) {
                        case ("R"):
                            head[0]++;
                            break;
                        case ("L"):
                            head[0]--;
                            break;
                        case ("D"):
                            head[1]--;
                            break;
                        case ("U"):
                            head[1]++;
                            break;
                    }
                    moveTail();
                }
            }

            System.out.println(visited.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2() {
        File input = new File("AOC-2022-inputs/input9.txt");

        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");

                for (int i = 0; i < Integer.parseInt(line[1]); i++) {
                    switch (line[0]) {
                        case ("R"):
                            longRope[0][0]++;
                            break;
                        case ("L"):
                            longRope[0][0]--;
                            break;
                        case ("D"):
                            longRope[0][1]--;
                            break;
                        case ("U"):
                            longRope[0][1]++;
                            break;
                    }
                    for (int j = 0; j < longRope.length - 1; j++) {
                        moveLongTail(longRope[j], longRope[j + 1]);
                    }

                    if (!longVisited.contains(longRope[9][0] + "," + longRope[9][1])) {
                        longVisited.add(longRope[9][0] + "," + longRope[9][1]);
                    }
                }
            }

            System.out.println(longVisited.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void moveTail() {
        if (head[0] != tail[0] && head[1] != tail[1]) {
            if (Math.abs(tail[0] - head[0]) != 1 || Math.abs(tail[1] - head[1]) != 1) {
                if (tail[0] < head[0]) {
                    if (tail[1] < head[1]) {
                        tail[0]++;
                        tail[1]++;
                    } else {
                        tail[0]++;
                        tail[1]--;
                    }
                } else {
                    if (tail[1] < head[1]) {
                        tail[0]--;
                        tail[1]++;
                    } else {
                        tail[0]--;
                        tail[1]--;
                    }
                }
            }
        } else if (head[0] == tail[0] && Math.abs(tail[1] - head[1]) > 1) {
            if (tail[1] < head[1]) {
                tail[1]++;
            } else {
                tail[1]--;
            }
        } else if (head[1] == tail[1] && Math.abs(tail[0] - head[0]) > 1) {
            if (tail[0] < head[0]) {
                tail[0]++;
            } else {
                tail[0]--;
            }
        }

        if (!visited.contains(tail[0] + "," + tail[1])) {
            visited.add(tail[0] + "," + tail[1]);
        }
    }

    public static void moveLongTail(int[] s1, int[] s2) {
        if (s1[0] != s2[0] && s1[1] != s2[1]) {
            if (Math.abs(s2[0] - s1[0]) != 1 || Math.abs(s2[1] - s1[1]) != 1) {
                if (s2[0] < s1[0]) {
                    if (s2[1] < s1[1]) {
                        s2[0]++;
                        s2[1]++;
                    } else {
                        s2[0]++;
                        s2[1]--;
                    }
                } else {
                    if (s2[1] < s1[1]) {
                        s2[0]--;
                        s2[1]++;
                    } else {
                        s2[0]--;
                        s2[1]--;
                    }
                }
            }
        } else if (s1[0] == s2[0] && Math.abs(s2[1] - s1[1]) > 1) {
            if (s2[1] < s1[1]) {
                s2[1]++;
            } else {
                s2[1]--;
            }
        } else if (s1[1] == s2[1] && Math.abs(s2[0] - s1[0]) > 1) {
            if (s2[0] < s1[0]) {
                s2[0]++;
            } else {
                s2[0]--;
            }
        }
    }
}