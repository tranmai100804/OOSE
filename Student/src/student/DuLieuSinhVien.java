/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;
import java.sql.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class DuLieuSinhVien {
    private Connection conn;

    public DuLieuSinhVien() throws Exception {
        String url = "jdbc:sqlserver://ocaldb\\\\MSSQLLocalDB;databaseName=StudentDB;encrypt=false;trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(url);
    }

   
    public void themSinhVien(SinhVien s) throws Exception {
        String sql = "INSERT INTO SinhVien VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getmaSV());
            ps.setString(2, s.gethoTen());
            ps.setString(3, s.ngaySinh());
            ps.setString(4, s.nganhDTao());
            ps.setDouble(5, s.dtb());
            ps.setString(6, s.lopSH());
            ps.executeUpdate();
        }
    }


    public void xoaSinhVien(String id) throws Exception {
        String sql = "DELETE FROM SinhVien WHERE maSV=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        }
    }

  
    public void capNhatSinhVien(SinhVien s) throws Exception {
        String sql = "UPDATE SinhVien SET hoTen=?, ngaySinh=?, nganhDT=?, dtb=?, lopSH=? WHERE maSV=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.gethoTen());
            ps.setString(2, s.ngaySinh());
            ps.setString(3, s.nganhDTao());
            ps.setDouble(4, s.dtb());
            ps.setString(5, s.lopSH());
            ps.setString(6, s.getmaSV());
            ps.executeUpdate();
        }
    }

 
    public List<SinhVien> layDSSinhVien() throws Exception {
        List<SinhVien> list = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM SinhVien");
            while (rs.next()) {
                SinhVien s = new SinhVien(
                        rs.getString("Ma Sinh Vien"),
                        rs.getString("Ho Ten"),
                        rs.getString("Ngay Sinh"),
                        rs.getString("Nganh DT"),
                        rs.getDouble("dtb"),
                        rs.getString("LopSH")
                );
                list.add(s);
            }
            rs.close();
        }
        return list;
    }

    // Lấy sinh viên theo lớp
    public List<SinhVien> laySVTheoLop(String lopSH) throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM SinhVien WHERE lopSH=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, lopSH);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new SinhVien(
                            rs.getString("Ma Sinh Vien"),
                            rs.getString("Ho Ten"),
                            rs.getString("Ngay Sinh"),
                            rs.getString("Nganh DT"),
                            rs.getDouble("dtb"),
                            rs.getString("LopSH")
                    ));
                }
            }
        }
        return list;
    }
}


