/*
 * QUẢN LÝ BÁN HÀNG – 2
 * @since  10/12/2021
 * @author TaDuy
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class quanlibanhang_sai {

    static class KhachHang {

        private String ma;
        private String ten;
        private String gioi;
        private String ngaysinh;
        private String diachi;

        public void nhap(Scanner s) {
            ten = s.nextLine();
            gioi = s.nextLine();
            ngaysinh = s.nextLine();
            diachi = s.nextLine();
        }

        public void setMa(int a) {
            ma = a < 10 ? "KH00" + a : "KH0" + a;
        }

        public String getMa() {
            return ma;
        }

        public String getTen() {
            return ten;
        }

        public String getGioi() {
            return gioi;
        }

        public String getNgaysinh() {
            return ngaysinh;
        }

        public String getDiachi() {
            return diachi;
        }
    }

    static class MatHang {

        private String ma;
        private String ten;
        private String donvi;
        private long giamua;
        private long giaban;

        public void nhap(Scanner s) {
            s.nextLine();
            ten = s.nextLine();
            donvi = s.next();
            giamua = s.nextLong();
            giaban = s.nextLong();
        }

        public void setMa(int a) {
            ma = a < 10 ? "MH00" + a : "MH0" + a;
        }

        public String getMa() {
            return ma;
        }

        public String getTen() {
            return ten;
        }

        public String getDonvi() {
            return donvi;
        }

        public long getGiamua() {
            return giamua;
        }

        public long getGiaban() {
            return giaban;
        }
    }

    static class HoaDon {

        private String mahoadon;
        private String makhach;
        private String mamathang;
        private int soluong;
        private long loinhuan;

        public void nhap(Scanner s) {
            makhach = s.next();
            mamathang = s.next();
            soluong = s.nextInt();
        }

        public void setMahoadon(int a) {
            mahoadon = a < 10 ? "HD00" + a : "HD0" + a;
        }

        public void setLoinhuan(ArrayList<MatHang> mh) {
            MatHang m = null;
            for (MatHang i : mh) {
                if (i.getMa().equals(mamathang)) {
                    m = i;
                    break;
                }
            }
            loinhuan = m.getGiaban() * soluong - m.getGiamua() * soluong;
        }

        public long getLoinhuan() {
            return loinhuan;
        }

        public void xuat(ArrayList<KhachHang> k, ArrayList<MatHang> m) {
            KhachHang khach = null;
            MatHang math = null;
            for (KhachHang i : k) {
                if (i.getMa().equals(makhach)) {
                    khach = i;
                    break;
                }
            }
            for (MatHang i : m) {
                if (i.getMa().equals(mamathang)) {
                    math = i;
                    break;
                }
            }
            System.out.println(
                    this.mahoadon + " " + khach.getTen() + " " + khach.getDiachi() + " " + math.getTen()
                    + " " + this.soluong + " " + (this.soluong) * math.getGiaban() + " " + this.loinhuan
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> khachhang = new ArrayList<>();
        int stt = 1;
        while (k-- > 0) {
            KhachHang i = new KhachHang();
            i.nhap(sc);
            i.setMa(stt);
            stt++;
            khachhang.add(i);
        }
        ArrayList<MatHang> hang = new ArrayList<>();
        int m = sc.nextInt();
        stt = 1;
        while (m-- > 0) {
            MatHang i = new MatHang();
            i.nhap(sc);
            i.setMa(stt);
            stt++;
            hang.add(i);
        }
        int hd = sc.nextInt();
        stt = 1;
        ArrayList<HoaDon> hdlist = new ArrayList<>();
        while (hd-- > 0) {
            HoaDon i = new HoaDon();
            i.nhap(sc);
            i.setMahoadon(stt);
            i.setLoinhuan(hang);
            stt++;
            hdlist.add(i);
        }
        hdlist.sort(Comparator.comparing(HoaDon::getLoinhuan).reversed());
        for (HoaDon i : hdlist) {
            i.xuat(khachhang, hang);
        }
    }
}