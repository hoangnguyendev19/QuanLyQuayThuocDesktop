package entity;

public class ThongKeSanPham {
	
	private String sanPhamID;
	private String tenSanPham;
	private int tongSoLuong;
	private double tongTien;
	
	public ThongKeSanPham() {
	}

	public ThongKeSanPham(String sanPhamID, String tenSanPham, int tongSoLuong, double tongTien) {
		this.sanPhamID = sanPhamID;
		this.tenSanPham = tenSanPham;
		this.tongSoLuong = tongSoLuong;
		this.tongTien = tongTien;
	}

	public String getSanPhamID() {
		return sanPhamID;
	}

	public void setSanPhamID(String sanPhamID) {
		this.sanPhamID = sanPhamID;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
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
		return sanPhamID + ";" + tenSanPham + ";" + tongSoLuong
				+ ";" + tongTien;
	}
	
}
