package entity;

public class NhaCungCap {
	private String nhaCungCapID;
	private String tenNhaCungCap;
	private String soDienThoai;
	private String diaChi;
	
	public NhaCungCap() {
		
	}

	public NhaCungCap(String nhaCungCapID, String tenNhaCungCap, String soDienThoai, String diaChi) {
		this.nhaCungCapID = nhaCungCapID;
		this.tenNhaCungCap = tenNhaCungCap;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}

	public String getNhaCungCapID() {
		return nhaCungCapID;
	}

	public void setNhaCungCapID(String nhaCungCapID) {
		this.nhaCungCapID = nhaCungCapID;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
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

	@Override
	public String toString() {
		return nhaCungCapID + ";" + tenNhaCungCap + ";"
				+ soDienThoai + ";" + diaChi;
	}
	
}
