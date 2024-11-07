import java.io.*;
import java.util.*;

public class madinhdanh {
    public static void main(String[] args) {
        try {
            // Đọc file nhị phân DATA1.in
            FileInputStream fileInputStream1 = new FileInputStream("DATA1.in");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
            ArrayList<String> strings = (ArrayList<String>) objectInputStream1.readObject();
            objectInputStream1.close();

            // Đọc file nhị phân DATA2.in
            FileInputStream fileInputStream2 = new FileInputStream("DATA2.in");
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            ArrayList<Integer> numbers = (ArrayList<Integer>) objectInputStream2.readObject();
            objectInputStream2.close();

            // Tập hợp lưu trữ các mã duy nhất
            Set<String> uniqueCodes = new TreeSet<>();

            // Tạo các mã theo quy tắc: 5 ký tự đầu từ DATA1.in và 3 ký tự cuối từ DATA2.in
            for (String str : strings) {
                if (str.length() == 5 && str.equals(str.toUpperCase())) { // Đảm bảo 5 ký tự và toàn chữ hoa
                    for (Integer num : numbers) {
                        if (num >= 100 && num <= 999) { // Đảm bảo số có 3 chữ số
                            uniqueCodes.add(str + num);
                        }
                    }
                }
            }

            // Xuất các mã ra màn hình, sắp xếp theo thứ tự từ điển
            for (String code : uniqueCodes) {
                System.out.println(code);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
