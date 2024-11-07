import java.io.*;
import java.util.ArrayList;

public class CreateDataFile {
    public static void main(String[] args) {
        // Tạo một ArrayList<Integer> chứa các số
        ArrayList<Integer> numbers = new ArrayList<>();
        
        // Thêm các số vào danh sách (thay đổi các số này theo yêu cầu)
        numbers.add(121);
        numbers.add(676);
        numbers.add(1441);
        numbers.add(34543);
        numbers.add(907709);
        numbers.add(123); // Số không thuận nghịch để kiểm tra

        // Ghi ArrayList vào file nhị phân DAYSO.DAT
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("DAYSO.DAT");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(numbers);
            objectOutputStream.close();
            System.out.println("Tạo file DAYSO.DAT thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
