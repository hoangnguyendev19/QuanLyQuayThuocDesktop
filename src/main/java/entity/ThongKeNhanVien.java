package entity;

public class ThongKeNhanVien {
	
	private String nhanVienID;
	private String hoTen;
	private int tongSoLuong;
	private double tongTien;
	
	public ThongKeNhanVien() {

	}

	public ThongKeNhanVien(String nhanVienID, String hoTen, int tongSoLuong, double tongTien) {
		this.nhanVienID = nhanVienID;
		this.hoTen = hoTen;
		this.tongSoLuong = tongSoLuong;
		this.tongTien = tongTien;
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

	public int getTongSoLuong() {
		return tongSoLuong;
	}

	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return nhanVienID + ";" + hoTen + ";" + tongSoLuong + ";"
				+ tongTien;
	}
}
