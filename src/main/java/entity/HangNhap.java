package entity;

import java.sql.Date;

public class HangNhap {
	private SanPham sanPham;
	private NhaCungCap nhaCungCap;
	private int soLuong;
	private double tongTien;
	private Date ngayNhap;
	
	public HangNhap() {

	}

	public HangNhap(SanPham sanPham, NhaCungCap nhaCungCap, int soLuong, double tongTien, Date ngayNhap) {
		this.sanPham = sanPham;
		this.nhaCungCap = nhaCungCap;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
		this.ngayNhap = ngayNhap;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	@Override
	public String toString() {
		return sanPham.getSanPhamID() + ";" + nhaCungCap.getNhaCungCapID() + ";" + soLuong + ";"
				+ tongTien + ";" + ngayNhap;
	}
}
