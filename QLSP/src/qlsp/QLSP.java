/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qlsp;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class QLSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
        QuanLySanPham manager = new QuanLySanPham();
        DonHang donhang = new DonHang(manager);
        Scanner sc = new Scanner(System.in);

        // Thêm sản phẩm mẫu
        manager.themSanPham(new SanPham(1, "Giày", "Sneaker", 1000000, 5, "Giày thể thao"));
        manager.themSanPham(new SanPham(2, "Iphone 16", "Điện tử", 40000000, 3, "Điện thoại Apple"));
        manager.themSanPham(new SanPham(3, "Áo thun Boxy", "Thời trang", 270000, 17, "Áo thun cotton"));

        int choice;
        do {
            System.out.println("\nMenu");
            System.out.println("1. Hien thi tat ca san pham");
            System.out.println("2. Cap nhat san pham");
            System.out.println("3. Hien thi san pham theo gia");
            System.out.println("4. Hien thi san pham theo danh muc");
            System.out.println("5. Tinh tong ton kho theo danh muc");
            System.out.println("6. Giam gia san pham");
            System.out.println("7. Dat hang");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manager.showAll();
                    break;
                case 2:
                    System.out.print("Nhap ID san pham: ");
                    int id = sc.nextInt();
                    System.out.print("Nhap gia moi: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Nhap mo ta moi: ");
                    String newDesc = sc.nextLine();
                    manager.capNhatSanPham(id, newPrice, newDesc);
                    break;
                case 3:
                    manager.hienThiTheoGia();
                    break;
                case 4:
                    System.out.print("Nhap danh muc: ");
                    String cat = sc.nextLine();
                    manager.hienThiTheoDanhMuc(cat);
                    break;
                case 5:
                    System.out.print("Nhap danh muc: ");
                    String cat2 = sc.nextLine();
                    manager.tongGTTheoDanhMuc(cat2);
                    break;
                case 6:
                    System.out.print("Nhap ID san pham: ");
                    int id2 = sc.nextInt();
                    System.out.print("Nhap % giam gia: ");
                    double percent = sc.nextDouble();
                    manager.giamGia(id2, percent);
                    break;
                case 7:
                    donhang.createOrder(sc);
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);

        sc.close();
    }
    
    
}
