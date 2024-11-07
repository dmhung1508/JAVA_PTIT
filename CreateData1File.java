import java.io.*;
import java.util.ArrayList;

public class CreateData1File {
    public static void main(String[] args) {
        // Tạo danh sách các chuỗi ký tự 5 chữ cái viết hoa
        ArrayList<String> strings = new ArrayList<>();
        strings.add("AAAAA");
        strings.add("BBBBB");
        strings.add("CCCCC");
        strings.add("DDDDD"); // Thêm các chuỗi khác nếu cần

        // Ghi ArrayList vào file nhị phân DATA1.in
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("DATA1.in");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(strings);
            objectOutputStream.close();
            System.out.println("Tạo file DATA1.in thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
