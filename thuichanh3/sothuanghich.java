import java.io.*;
import java.util.*;

public class sothuanghich {
    public static void main(String[] args) {
        try {
            // Đọc file nhị phân DAYSO.DAT
            FileInputStream fileInputStream = new FileInputStream("DAYSO.DAT");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Integer> numbers = (ArrayList<Integer>) objectInputStream.readObject();
            objectInputStream.close();

            // Tập hợp lưu trữ các số thuận nghịch khác nhau có 3 chữ số trở lên
            Set<Integer> palindromes = new TreeSet<>();

            // Kiểm tra từng số trong danh sách
            for (Integer num : numbers) {
                if (num >= 100 && num <= 1000000 && isPalindrome(num)) {
                    palindromes.add(num);
                }
            }

            // Ghi các số thuận nghịch vào output
            for (Integer num : palindromes) {
                System.out.println(num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm kiểm tra số thuận nghịch
    public static boolean isPalindrome(int num) {
        int reversed = 0, original = num;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed == original;
    }
}
