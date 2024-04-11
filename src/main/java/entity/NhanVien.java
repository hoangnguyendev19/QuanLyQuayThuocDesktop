package entity;

import java.sql.Date;

public class NhanVien {
	
	private String nhanVienID;
	private String hoTen;
	private String gioiTinh;
	private Date ngaySinh;
	private String email;
	private String soDienThoai;
	private String diaChi;
	private String chucVu; // Nhan vien va quan ly
	private String tenTaiKhoan;
	private String matKhau;
	
	public NhanVien() {
		
	}

	public NhanVien(String nhanVienID, String hoTen, String gioiTinh, Date ngaySinh, String email, String soDienThoai,
			String diaChi, String chucVu, String tenTaiKhoan, String matKhau) {
		this.nhanVienID = nhanVienID;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}

	

	public NhanVien(String tenTaiKhoan, String matKhau) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}

	public String getNhanVienID() {
		return nhanVienID;
	}

	public void setNhanVienID(String nhanVienID) {
		this.nhanVienID = nhanVienID;
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

	public void setNgaySinh(Date date) {
		this.ngaySinh = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return nhanVienID + ";" + hoTen + ";" + gioiTinh + ";"
				+ ngaySinh + ";" + email + ";" + soDienThoai + ";" + diaChi + ";"
				+ chucVu + ";" + tenTaiKhoan + ";" + matKhau;
	}
	
}
