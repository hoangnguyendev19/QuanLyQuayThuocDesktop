package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ThongKeDoanhThu;
import entity.ThongKeNhanVien;
import entity.ThongKeSanPham;

public class ThongKe_DAO {
	
	public ThongKe_DAO() {
		
	}
	
	public ArrayList<ThongKeSanPham> getAllSanPhamBanChayNhatTheoThang(int thang) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select sp.SanPhamID, sp.TenSanPham, TongSoLuong=sum(cthd.SoLuong), TongTien=sum(cthd.ThanhTien) from SanPham as sp inner join ChiTietHoaDon as cthd on sp.SanPhamID=cthd.SanPhamID"
					+ " inner join HoaDon as hd on hd.HoaDonID=cthd.HoaDonID where month(hd.NgayLap)=? group by sp.SanPhamID, sp.TenSanPham order by sum(cthd.ThanhTien) desc";
			statement = con.prepareStatement(sql);
			statement.setInt(1, thang);
			ResultSet rs = statement.executeQuery();
			
			ArrayList<ThongKeSanPham> thongKeSPList = new ArrayList<ThongKeSanPham>();
			while(rs.next()) {
				String sanPhamID = rs.getString("SanPhamID");
				String tenSanPham = rs.getString("TenSanPham");
				int tongSoLuong = rs.getInt("TongSoLuong");
				double tongTien = rs.getDouble("TongTien");
				
				ThongKeSanPham thongKeSanPham = new ThongKeSanPham(sanPhamID, tenSanPham, tongSoLuong, tongTien);
				thongKeSPList.add(thongKeSanPham);
			}
			
			return thongKeSPList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<ThongKeSanPham> getAllSanPhamBanChayNhatTheoNam(int nam) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select sp.SanPhamID, sp.TenSanPham, TongSoLuong=sum(cthd.SoLuong), TongTien=sum(cthd.ThanhTien) from SanPham as sp inner join ChiTietHoaDon as cthd on sp.SanPhamID=cthd.SanPhamID"
					+ " inner join HoaDon as hd on hd.HoaDonID=cthd.HoaDonID where year(hd.NgayLap)=? group by sp.SanPhamID, sp.TenSanPham order by sum(cthd.ThanhTien) desc";
			statement = con.prepareStatement(sql);
			statement.setInt(1, nam);
			
			ResultSet rs = statement.executeQuery();
			
			ArrayList<ThongKeSanPham> thongKeSPList = new ArrayList<ThongKeSanPham>();
			while(rs.next()) {
				String sanPhamID = rs.getString("SanPhamID");
				String tenSanPham = rs.getString("TenSanPham");
				int tongSoLuong = rs.getInt("TongSoLuong");
				double tongTien = rs.getDouble("TongTien");
				
				ThongKeSanPham thongKeSanPham = new ThongKeSanPham(sanPhamID, tenSanPham, tongSoLuong, tongTien);
				thongKeSPList.add(thongKeSanPham);
			}
			
			return thongKeSPList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<ThongKeNhanVien> getAllDoanhThuNhanVienTheoThang(int thang) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select nv.NhanVienID, nv.HoTen, TongSoLuong=sum(cthd.SoLuong), TongTien=sum(cthd.ThanhTien) from NhanVien as nv inner join HoaDon as hd on nv.NhanVienID=hd.NhanVienID"
					+ " inner join ChiTietHoaDon as cthd on hd.HoaDonID=cthd.HoaDonID where month(hd.NgayLap)=? group by nv.NhanVienID, nv.HoTen order by sum(cthd.ThanhTien) desc";
			statement = con.prepareStatement(sql);
			statement.setInt(1, thang);
			
			ResultSet rs = statement.executeQuery();
			
			ArrayList<ThongKeNhanVien> thongKeNVList = new ArrayList<ThongKeNhanVien>();
			while(rs.next()) {
				String nhanVienID = rs.getString("nhanVienID");
				String hoTen = rs.getString("HoTen");
				int tongSoLuong = rs.getInt("TongSoLuong");
				double tongTien = rs.getDouble("TongTien");
				
				ThongKeNhanVien thongKeNhanVien = new ThongKeNhanVien(nhanVienID, hoTen, tongSoLuong, tongTien);
				thongKeNVList.add(thongKeNhanVien);
			}
			
			return thongKeNVList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<ThongKeNhanVien> getAllDoanhThuNhanVienTheoNam(int nam) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select nv.NhanVienID, nv.HoTen, TongSoLuong=sum(cthd.SoLuong), TongTien=sum(cthd.ThanhTien) from NhanVien as nv inner join HoaDon as hd on nv.NhanVienID=hd.NhanVienID"
					+ " inner join ChiTietHoaDon as cthd on hd.HoaDonID=cthd.HoaDonID where year(hd.NgayLap)=? group by nv.NhanVienID, nv.HoTen order by sum(cthd.ThanhTien) desc";
			statement = con.prepareStatement(sql);
			statement.setInt(1, nam);
			
			ResultSet rs = statement.executeQuery();
			
			ArrayList<ThongKeNhanVien> thongKeNVList = new ArrayList<ThongKeNhanVien>();
			while(rs.next()) {
				String nhanVienID = rs.getString("nhanVienID");
				String hoTen = rs.getString("HoTen");
				int tongSoLuong = rs.getInt("TongSoLuong");
				double tongTien = rs.getDouble("TongTien");
				
				ThongKeNhanVien thongKeNhanVien = new ThongKeNhanVien(nhanVienID, hoTen, tongSoLuong, tongTien);
				thongKeNVList.add(thongKeNhanVien);
			}
			
			return thongKeNVList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<ThongKeDoanhThu> getDoanhThuTheoThang(int thang) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select hd.NgayLap, TongSoLuong=sum(cthd.SoLuong), TongTien=sum(cthd.ThanhTien) from HoaDon as hd inner join ChiTietHoaDon as cthd"
					+ " on hd.HoaDonID=cthd.HoaDonID where month(hd.NgayLap)=? group by hd.NgayLap order by sum(cthd.ThanhTien) desc";
			statement = con.prepareStatement(sql);
			statement.setInt(1, thang);
			
			ResultSet rs = statement.executeQuery();
			
			ArrayList<ThongKeDoanhThu> thongKeDTList = new ArrayList<ThongKeDoanhThu>();
			while(rs.next()) {
				Date ngayLap = rs.getDate("NgayLap");
				int tongSoLuong = rs.getInt("TongSoLuong");
				double tongTien = rs.getDouble("TongTien");
				
				ThongKeDoanhThu thongKeDoanhThu = new ThongKeDoanhThu(ngayLap, tongSoLuong, tongTien);
				thongKeDTList.add(thongKeDoanhThu);
			}
			
			return thongKeDTList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<ThongKeDoanhThu> getDoanhThuTheoNam(int nam) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select hd.NgayLap, TongSoLuong=sum(cthd.SoLuong), TongTien=sum(cthd.ThanhTien) from HoaDon as hd inner join ChiTietHoaDon as cthd"
					+ " on hd.HoaDonID=cthd.HoaDonID where year(hd.NgayLap)=? group by hd.NgayLap order by sum(cthd.ThanhTien) desc";
			statement = con.prepareStatement(sql);
			statement.setInt(1, nam);
			
			ResultSet rs = statement.executeQuery();
			
			ArrayList<ThongKeDoanhThu> thongKeDTList = new ArrayList<ThongKeDoanhThu>();
			while(rs.next()) {
				Date ngayLap = rs.getDate("NgayLap");
				int tongSoLuong = rs.getInt("TongSoLuong");
				double tongTien = rs.getDouble("TongTien");
				
				ThongKeDoanhThu thongKeDoanhThu = new ThongKeDoanhThu(ngayLap, tongSoLuong, tongTien);
				thongKeDTList.add(thongKeDoanhThu);
			}
			
			return thongKeDTList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
