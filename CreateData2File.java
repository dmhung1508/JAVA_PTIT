import java.io.*;
import java.util.ArrayList;

public class CreateData2File {
    public static void main(String[] args) {
        // Tạo danh sách các số nguyên có 3 chữ số
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(111);
        numbers.add(222);
        numbers.add(333);
        numbers.add(444); // Thêm các số khác nếu cần

        // Ghi ArrayList vào file nhị phân DATA2.in
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("DATA2.in");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(numbers);
            objectOutputStream.close();
            System.out.println("Tạo file DATA2.in thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
