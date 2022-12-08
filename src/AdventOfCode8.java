import java.io.File;
import java.util.*;

public class AdventOfCode8 {

    public static ArrayList<int[]> grid = new ArrayList<>();
    public static ArrayList<Integer> treeVisibility = new ArrayList<>();

    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        File input = new File("input8.txt");
        int total = 0;

        try {
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int[] row = new int[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    row[i] = Integer.parseInt(String.valueOf(line.charAt(i)));
                }
                grid.add(row);
            }

            for (int i = 1; i < grid.size() - 1; i++) {
                for (int j = 1; j < grid.get(i).length - 1; j++) {
                    if (isVisible(i, j)) {
                        total++;
                    }
                }
            }
            total += (grid.size() * 2) + ((grid.get(0).length - 2) * 2);

            System.out.println("Amount of trees visible: " + total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2() {
        int treeVisibilityScore = treeVisibility.get(0);
        for (int i = 1; i < treeVisibility.size(); i++) {
            if (treeVisibility.get(i) > treeVisibilityScore) {
                treeVisibilityScore = treeVisibility.get(i);
            }
        }

        System.out.println("Highest tree visibility score: " + treeVisibilityScore);
    }

    public static boolean isVisible(int i, int j) {
        int tree = grid.get(i)[j];
        int visible = 0;
        int view1 = 0;
        int view2 = 0;
        int view3 = 0;
        int view4 = 0;
        for (int k = i - 1; k >= 0; k--) {
            if (grid.get(k)[j] >= tree) {
                visible++;
                view1++;
                break;
            }
            view1++;
        }
        for (int k = i + 1; k < grid.size(); k++) {
            if (grid.get(k)[j] >= tree) {
                visible++;
                view2++;
                break;
            }
            view2++;
        }
        for (int k = j - 1; k >= 0; k--) {
            if (grid.get(i)[k] >= tree) {
                visible++;
                view3++;
                break;
            }
            view3++;
        }
        for (int k = j + 1; k < grid.get(i).length; k++) {
            if (grid.get(i)[k] >= tree) {
                visible++;
                view4++;
                break;
            }
            view4++;
        }
        treeVisibility.add(view1 * view2 * view3 * view4);
        return visible != 4;
    }
}