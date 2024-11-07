/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DMHUNG
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class email {
    public static Scanner sc = new Scanner(System.in);
    public static Map<String, Integer> map = new LinkedHashMap<>();

    public static void testcase() {
        String name = sc.nextLine();
        String nz = normalize(name);
        System.out.println(nz);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            testcase();
        }
    }

    private static String normalize(String name) {
        String[] words = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(words[words.length - 1].toLowerCase());
        for (int i = 0; i < words.length - 1; i++) {
            sb.append(Character.toLowerCase(words[i].charAt(0)));
        }
        if (map.containsKey(sb.toString())) {
            int cnt = map.get(sb.toString()) + 1;
            map.put(sb.toString(), cnt);
            sb.append(cnt);

        } else {
            map.put(sb.toString(), 1);

        }
        sb.append("@ptit.edu.vn");
        return sb.toString();
    }

}
