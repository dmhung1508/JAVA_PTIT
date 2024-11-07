import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            System.out.println(minMoves(N));
        }
        scanner.close();
    }

    public static int minMoves(int N) {
        if (N == 1) return 0; // Ban đầu xúc xắc đã có mặt 1
        if (N <= 6) return 1; // Nếu N <= 6, chỉ cần lật một lần

        // Các trường hợp tổng quát
        // Các mặt khác nhau sẽ có các giá trị tăng thêm khác nhau.
        // Chúng ta cần tìm số bước ít nhất để đạt được N điểm.
        int moves = 1;
        int sum = 1; // Điểm ban đầu là 1
        while (sum < N) {
            if (sum + 6 <= N) {
                sum += 6;
            } else {
                sum += (N - sum); // Chỉ cần thêm điểm còn thiếu để đạt N
            }
            moves++;
        }

        return moves;
    }
}
