package entity;

import java.sql.Date;

public class KhachHang {
	private String khachHangID;
	private String hoTen;
	private String gioiTinh;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private String diaChi;
	
	public KhachHang() {
		
	}

	public KhachHang(String khachHangID, String hoTen, String gioiTinh, Date ngaySinh, String soDienThoai, String email,
			String diaChi) {
		this.khachHangID = khachHangID;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
	}

	public String getKhachHangID() {
		return khachHangID;
	}

	public void setKhachHangID(String khachHangID) {
		this.khachHangID = khachHangID;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return khachHangID + ";" + hoTen + ";" + gioiTinh + ";"
				+ ngaySinh + ";" + soDienThoai + ";" + email + ";" + diaChi;
	}
	
	
}
