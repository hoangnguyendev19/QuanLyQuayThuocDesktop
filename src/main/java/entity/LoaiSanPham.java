package entity;

public class LoaiSanPham {
	private String loaiID;
	private String tenLoai;
	
	public LoaiSanPham() {

	}

	public LoaiSanPham(String loaiID, String tenLoai) {
		this.loaiID = loaiID;
		this.tenLoai = tenLoai;
	}
	public LoaiSanPham(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getLoaiID() {
		return loaiID;
	}

	public void setLoaiID(String loaiID) {
		this.loaiID = loaiID;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [loaiID=" + loaiID + ", tenLoai=" + tenLoai + "]";
	}
}
