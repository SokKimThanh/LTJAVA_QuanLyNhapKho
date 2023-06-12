/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Thanh
 */
public class HangHoa {

    private String ma, ten, noisx;
    private int donGia, soluong;
    private String ngaySX;

    public HangHoa() {
    }
    
    public HangHoa(String ma) {
        this.ma = ma;
    }
    public HangHoa(String ma, String ten, String noisx, int gia, int soluong, String ngaySX) {
        this.ma = ma;
        this.ten = ten;
        this.noisx = noisx;
        this.donGia = gia;
        this.soluong = soluong;
        this.ngaySX = ngaySX;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoisx() {
        return noisx;
    }

    public void setNoisx(String noisx) {
        this.noisx = noisx;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(String ngaySX) {
        this.ngaySX = ngaySX;
    }

    public int ThanhTien() {
        return soluong * donGia;
    }

    @Override
    public String toString() {
        return "HangHoa{" + "ma=" + ma + ", ten=" + ten + ", noisx=" + noisx + ", gia=" + donGia + ", soluong=" + soluong + ", ngaySX=" + ngaySX + ", ThanhTien=" + ThanhTien() + '}';
    }

    public String ToFile() {
        return String.format("%s#%s#%s#%s#%s#%s", ma, ten, noisx, donGia, soluong, ngaySX);
    }
}
