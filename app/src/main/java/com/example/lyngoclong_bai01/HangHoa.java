package com.example.lyngoclong_bai01;

public class HangHoa {
    private String tenHang;
    private int soLuong;
    private double donGia;

    public HangHoa() {
    }

    public HangHoa(String tenHang, double donGia, int soLuong) {
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }


    public double getThanhTien() {
        return soLuong * donGia;
    }

    @Override
    public String toString() {
        return tenHang + " - SL: " + soLuong + " - Giá: " + donGia + " -> Tổng: " + getThanhTien();
    }
}
