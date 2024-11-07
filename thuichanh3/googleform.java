import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    String studentId;
    String name;
    String className;
    String email;
    String phoneNumber;

    public Student(String studentId, String name, String className, String email, String phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.className = className;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return studentId + " " + name + " " + className + " " + email + " " + phoneNumber;
    }

    @Override
    public int compareTo(Student other) {
        // So sánh theo lớp trước, sau đó theo mã sinh viên
        int classComparison = this.className.compareTo(other.className);
        if (classComparison != 0) {
            return classComparison;
        }
        return this.studentId.compareTo(other.studentId);
    }
}

public class NewClass {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        // Đọc dữ liệu từ file DANHSACH.in bằng Scanner
        try (Scanner scanner = new Scanner(new File("DANHSACH.in"))) {
            while (scanner.hasNextLine()) {
                String studentId = scanner.nextLine().trim();
                String name = scanner.nextLine().trim();
                String className = scanner.nextLine().trim();
                String email = scanner.nextLine().trim();
                String phoneNumber = scanner.nextLine().trim();

                // Bổ sung số 0 vào đầu số điện thoại nếu cần
                if (!phoneNumber.startsWith("0")) {
                    phoneNumber = "0" + phoneNumber;
                }

                students.add(new Student(studentId, name, className, email, phoneNumber));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Sắp xếp danh sách sinh viên theo lớp và mã sinh viên
        Collections.sort(students);

        // In kết quả ra màn hình
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
