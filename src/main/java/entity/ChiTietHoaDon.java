package entity;

public class ChiTietHoaDon {
	private SanPham sanPham;
	private HoaDon hoaDon;
	private int soLuong;
	private double giaBan;
	private double thanhTien;
	
	public ChiTietHoaDon() {

	}

	public ChiTietHoaDon(SanPham sanPham, HoaDon hoaDon, int soLuong, double giaBan, double thanhTien) {
		this.sanPham = sanPham;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.thanhTien = thanhTien;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return sanPham.getSanPhamID()+ ";" + sanPham.getTenSanPham() + ";" + soLuong + ";"
				+ giaBan + ";" + thanhTien;
	}
	
}
