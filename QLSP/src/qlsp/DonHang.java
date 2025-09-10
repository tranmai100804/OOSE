/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlsp;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class DonHang {
    
    private final QuanLySanPham manager;

    public DonHang(QuanLySanPham manager) {
        this.manager = manager;
    }

    public void createOrder(Scanner sc) {
        manager.showAll();
        System.out.print("Nhap ID san pham muon dat: ");
        int id = sc.nextInt();
        System.out.print("Nhap so luong: ");
        int qty = sc.nextInt();

        for (SanPham s : manager.getProducts()) {
            if (s.getId() == id) {
                if (qty <= s.getQuantity()) {
                    double total = qty * s.getPrice();
                    System.out.println("Dat hang thanh cong!");
                    System.out.println("Tong so tien: " + total);
                    s.setQuantity(s.getQuantity() - qty);
                } else {
                    System.out.println("So luong khong du!");
                }
                return;
            }
        }
        System.out.println("Khong tim thay san pham!");
    }
}

