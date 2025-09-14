/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            DuLieuSinhVien dlsv = new DuLieuSinhVien();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println(" MENU ");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Xóa sinh viên");
                System.out.println("3. Sửa sinh viên");
                System.out.println("4. In danh sách sinh viên");
                System.out.println("5. In theo lớp");
                System.out.println("6. Thoát");
                System.out.print("Chọn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Mã SV: "); String ma = sc.nextLine();
                        System.out.print("Họ tên: "); String ten = sc.nextLine();
                        System.out.print("Ngày sinh (yyyy-MM-dd): "); String ngaysinh = sc.nextLine();
                        System.out.print("Ngành (CNTT/KTPM): "); String nganh = sc.nextLine();
                        System.out.print("Điểm TB: "); double dtb = Double.parseDouble(sc.nextLine());
                        System.out.print("Lớp: "); String lop = sc.nextLine();
                        SinhVien s = new SinhVien(ma, ten, ngaysinh, nganh, stb, lop);
                        dlsv.themSinhVien(s);
                    }
                    case 2 -> {
                        System.out.print("Nhập mã sinh viên cần xóa: ");
                        dlsv.xoaSinhVien(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Nhập mã sinh viên cần sửa: ");
                        String mamoi = sc.nextLine();
                        System.out.print("Tên mới: "); String tenmoi = sc.nextLine();
                        System.out.print("Ngày sinh mới: "); String ngaysinhmoi  = sc.nextLine();
                        System.out.print("Ngành mới: "); String nganhmoi = sc.nextLine();
                        System.out.print("Điểm TB mới: "); double stbmoi = Double.parseDouble(sc.nextLine());
                        System.out.print("Lớp mới: "); String lopmoi = sc.nextLine();
                        dlsv.updateStudent(new SinhVien(mamoi, tenmoi, ngaysinhmoi, nganhmoi, dtbmoi, lopmoi));
                    }
                    case 4 -> {
                        for (SinhVien st : dlsv.layDSSinhVien())
                            System.out.println(st);
                    }
                    case 5 -> {
                        System.out.print("Nhập tên lớp: ");
                        for (SinhVien st : dlsv.laySVTheoLop(sc.nextLine()))
                            System.out.println(st);
                    }
                    case 6 -> System.exit(0);
                }
            }
        } catch (Exception e) {
        }
    }
}

