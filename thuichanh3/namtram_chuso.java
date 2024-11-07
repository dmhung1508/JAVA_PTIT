import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class namtram_chuso {
    public static void main(String[] args) {
        List<BigInteger> numbers = new ArrayList<>();
        String fileName = "DANHSACH.in";

        // Đọc dữ liệu từ file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int N = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                numbers.add(new BigInteger(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Tìm số nhỏ nhất
        BigInteger minNumber = numbers.get(0);
        // Tìm số lớn nhất
        BigInteger maxNumber = numbers.get(0);
        // Tính tổng
        BigInteger sum = BigInteger.ZERO;

        for (BigInteger number : numbers) {
            if (number.compareTo(minNumber) < 0) {
                minNumber = number;
            }
            if (number.compareTo(maxNumber) > 0) {
                maxNumber = number;
            }
            sum = sum.add(number);
        }

        // In kết quả ra màn hình
        System.out.println(minNumber);
        System.out.println(maxNumber);
        System.out.println(sum);
    }
}