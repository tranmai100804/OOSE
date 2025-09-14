/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/**
 *
 * @author ADMIN
 */
public class SinhVien{

    private String maSV;
    private String hoTen;
    private String ngaySinh;
    private String nganhDTao;
    private double dtb;
    private String lopSH;

    public SinhVien() {

            this.maSV = " ";
            this.hoTen = " ";
            this.ngaySinh = " ";
            this.nganhDTao = " ";
            this.dtb = 0;
            this.lopSH = " ";
    }

    public SinhVien(String maSV, String hoTen, String ngaySinh, String nganhDTao, double dtb, String lopSH) {
            this.maSV = maSV;
            this.hoTen = hoTen;
            this.ngaySinh = ngaySinh;
            this.nganhDTao = nganhDTao;
            this.dtb = dtb;
            this.lopSH = lopSH;
    }
    public String getmaSV() 
    {
            return this.maSV;
    }
    public String gethoTen()
    {
            return this.hoTen;
    }
    public String ngaySinh()
    {
            return this.ngaySinh;
    }
    public String nganhDTao()
    {
            return this.nganhDTao;
    }
    public double dtb()
    {
            return this.dtb;
    }
    public String lopSH()
    {
            return this.lopSH;
    }

    @Override
    public String toString() {
        return  "Ma Sinh Vien: " + this.maSV + "Ho Ten: " + this.hoTen + "Ngay Sinh: " + this.ngaySinh + "Nganh Dao Tao: " + this.nganhDTao + "Diem Trung Binh: " + this.dtb + "Lop Sinh Hoat: " + this.lopSH;
    }


}


