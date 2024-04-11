package entity;

import java.sql.Date;

public class HoaDon {
	private String hoaDonID;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private double tongTien;
	private Date ngayLap;
	
	public HoaDon() {
	}

	public HoaDon(String hoaDonID, NhanVien nhanVien, KhachHang khachHang, double tongTien, Date ngayLap) {
		this.hoaDonID = hoaDonID;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.tongTien = tongTien;
		this.ngayLap = ngayLap;
	}

	public String getHoaDonID() {
		return hoaDonID;
	}

	public void setHoaDonID(String hoaDonID) {
		this.hoaDonID = hoaDonID;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	@Override
	public String toString() {
		return hoaDonID + ";" + nhanVien.getNhanVienID() + ";" + khachHang.getKhachHangID() + ";"
				+ tongTien + ";" + ngayLap;
	}
	
}
