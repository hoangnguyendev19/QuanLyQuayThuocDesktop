package entity;

import java.sql.Date;

public class ThongKeDoanhThu {
	
	private Date ngayLapHD;
	private int tongSoLuong;
	private double tongTien;
	
	public ThongKeDoanhThu() {

	}

	public ThongKeDoanhThu(Date ngayLapHD, int tongSoLuong, double tongTien) {
		this.ngayLapHD = ngayLapHD;
		this.tongSoLuong = tongSoLuong;
		this.tongTien = tongTien;
	}

	public Date getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
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
		return ngayLapHD + ";" + tongSoLuong + ";" + tongTien;
	}
}
