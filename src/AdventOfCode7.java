import java.io.File;
import java.util.*;

public class AdventOfCode7 {
    static Map<String, List<String>> directories = new HashMap<>();
    static List<Integer> sizes = new ArrayList<>();
    static int main = 0;
    public static void main(String[] args) {
        part1();
        part2();
    }

    public static void part1() {
        File input = new File("input7.txt");
        int total = 0;

        try {
            Scanner scanner = new Scanner(input);
            Stack<String> previousDirectories = new Stack<>();
            String directoryKey = "/";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains("$ cd")) {
                    if (line.contains("..")) {
                        directoryKey = directoryKey.substring(0, directoryKey.length() - previousDirectories.pop().length());
                    } else if (line.contains("/")) {
                        previousDirectories.empty();
                        previousDirectories.push("/");
                        directoryKey = "/";
                    } else {
                        previousDirectories.push(line.substring(5));
                        directoryKey += line.substring(5);
                    }
                } else {
                    if (line.contains("dir ")) {
                        if (directories.containsKey(directoryKey)) {
                            directories.get(directoryKey).add(directoryKey + line.substring(4));
                        } else {
                            List<String> temp = new ArrayList<>();
                            temp.add(directoryKey + line.substring(4));
                            directories.put(directoryKey, temp);
                        }
                    } else if (!line.contains("$ ls")) {
                        Scanner intScanner = new Scanner(line);
                        if (directories.containsKey(directoryKey)) {
                            directories.get(directoryKey).add(intScanner.next());
                        } else {
                            List<String> temp = new ArrayList<>();
                            temp.add(String.valueOf(intScanner.nextInt()));
                            directories.put(directoryKey, temp);
                        }
                    }
                }
            }

            getTotalSize("/");

            for (int i = 0; i < sizes.size(); i++) {
                if (sizes.get(i) < 100000) {
                    total += sizes.get(i);
                }
            }

            System.out.println("Total Size " + total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2() {
        int spaceLeft = 30000000 - (70000000 - main);
        int toDelete = 70000000;
        for (int i = 1; i < sizes.size(); i++) {
            if (sizes.get(i) > spaceLeft && sizes.get(i) < toDelete) {
                toDelete = sizes.get(i);
            }
        }
        System.out.println("Deletion Size " + toDelete);
    }

    public static int getTotalSize(String key) {
        int size = 0;
        for (int i = 0; i < directories.get(key).size(); i++) {
            try {
                size += Integer.parseInt(directories.get(key).get(i));
            } catch (Exception e) {
                size += getTotalSize(directories.get(key).get(i));
            }
        }

        if (key.equals("/")) {
            main = size;
        }

        sizes.add(size);
        return size;
    }
}