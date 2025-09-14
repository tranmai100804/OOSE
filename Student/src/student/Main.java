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
                        System.out.print("Mã SV: "); String id = sc.nextLine();
                        System.out.print("Họ tên: "); String name = sc.nextLine();
                        System.out.print("Ngày sinh (yyyy-MM-dd): "); String dob = sc.nextLine();
                        System.out.print("Ngành (CNTT/KTPM): "); String major = sc.nextLine();
                        System.out.print("Điểm TB: "); double gpa = Double.parseDouble(sc.nextLine());
                        System.out.print("Lớp: "); String cls = sc.nextLine();
                        SinhVien s = new SinhVien(id, name, dob, major, gpa, cls);
                        dlsv.addStudent(s);
                    }
                    case 2 -> {
                        System.out.print("Nhập mã SV cần xóa: ");
                        dlsv.deleteStudent(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Nhập mã SV cần sửa: ");
                        String idU = sc.nextLine();
                        System.out.print("Tên mới: "); String nameU = sc.nextLine();
                        System.out.print("Ngày sinh mới: "); String dobU = sc.nextLine();
                        System.out.print("Ngành mới: "); String majorU = sc.nextLine();
                        System.out.print("Điểm TB mới: "); double gpaU = Double.parseDouble(sc.nextLine());
                        System.out.print("Lớp mới: "); String clsU = sc.nextLine();
                        dlsv.updateStudent(new SinhVien(idU, nameU, dobU, majorU, gpaU, clsU));
                    }
                    case 4 -> {
                        for (SinhVien st : dlsv.getAllStudents())
                            System.out.println(st);
                    }
                    case 5 -> {
                        System.out.print("Nhập tên lớp: ");
                        for (SinhVien st : dlsv.getStudentsByClass(sc.nextLine()))
                            System.out.println(st);
                    }
                    case 6 -> System.exit(0);
                }
            }
        } catch (Exception e) {
        }
    }
}
