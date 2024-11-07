import java.util.*;

public class giao_tong_hop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read array a
        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(scanner.nextInt());
        }

        // Read array b
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < m; i++) {
            setB.add(scanner.nextInt());
        }

        // Intersection of A and B
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        // A - B
        Set<Integer> diffAB = new HashSet<>(setA);
        diffAB.removeAll(setB);

        // B - A
        Set<Integer> diffBA = new HashSet<>(setB);
        diffBA.removeAll(setA);

        // Sort and print the results
        printSorted(intersection);
        printSorted(diffAB);
        printSorted(diffBA);

        scanner.close();
    }

    private static void printSorted(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        for (int num : sortedList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
