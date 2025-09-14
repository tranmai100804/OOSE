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
        Connection conn = DriverManager.getConnection(url, "sa", "your_password");

        //String url = "jdbc:mysql://localhost:3306/StudentDB";
       // String user = "root"; // thay bằng user của bạn
        //String password = ""; // thay bằng mật khẩu
        //conn = DriverManager.getConnection(url);
    }

    // Thêm sinh viên
    public void addStudent(SinhVien s) throws Exception {
        String sql = "INSERT INTO Student VALUES (?,?,?,?,?,?)";
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

    // Xóa sinh viên
    public void deleteStudent(String id) throws Exception {
        String sql = "DELETE FROM Student WHERE studentId=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        }
    }

    // Sửa thông tin sinh viên
    public void updateStudent(SinhVien s) throws Exception {
        String sql = "UPDATE Student SET fullName=?, birthDate=?, major=?, gpa=?, className=? WHERE studentId=?";
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

    // Lấy danh sách sinh viên
    public List<SinhVien> getAllStudents() throws Exception {
        List<SinhVien> list = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Student");
            while (rs.next()) {
                SinhVien s = new SinhVien(
                        rs.getString("studentId"),
                        rs.getString("fullName"),
                        rs.getString("birthDate"),
                        rs.getString("major"),
                        rs.getDouble("gpa"),
                        rs.getString("className")
                );
                list.add(s);
            }
            rs.close();
        }
        return list;
    }

    // Lấy sinh viên theo lớp
    public List<SinhVien> getStudentsByClass(String className) throws Exception {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM Student WHERE className=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, className);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new SinhVien(
                            rs.getString("studentId"),
                            rs.getString("fullName"),
                            rs.getString("birthDate"),
                            rs.getString("major"),
                            rs.getDouble("gpa"),
                            rs.getString("className")
                    ));
                }
            }
        }
        return list;
    }
}

