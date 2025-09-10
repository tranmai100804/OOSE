/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlsp;
import java.util.*;
/**
 *
 * @author ADMIN
 */
public class QuanLySanPham {
    private List<SanPham> sanphams = new ArrayList<>();

    public void themSanPham(SanPham s) {
        sanphams.add(s);
    }

    public void capNhatSanPham(int id, double newPrice, String newDescription) {
        for (SanPham s : sanphams) {
            if (s.getId() == id) {
                s.setPrice(newPrice);
                s.setDescription(newDescription);
                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham!");
    }

    public void hienThiTheoDanhMuc(String category) {
        sanphams.stream()
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .forEach(System.out::println);
    }

    public void hienThiTheoGia() {
        sanphams.stream()
                .sorted(Comparator.comparingDouble(SanPham::getPrice))
                .forEach(System.out::println);
    }

    public void tongGTTheoDanhMuc(String category) {
        double total = sanphams.stream()
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .mapToDouble(SanPham::getTotalValue)
                .sum();
        System.out.println("Tong gia tri ton kho danh muc " + category + ": " + total);
    }

    public void giamGia(int id, double percent) {
        for (SanPham s : sanphams) {
            if (s.getId() == id) {
                double newPrice = s.getPrice() * (1 - percent / 100);
                s.setPrice(newPrice);
                System.out.println("Ap dung giam gia thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham!");
    }

    public List<SanPham> getProducts() {
        return sanphams;
    }

    public void showAll() {
        sanphams.forEach(System.out::println);
    }
}
