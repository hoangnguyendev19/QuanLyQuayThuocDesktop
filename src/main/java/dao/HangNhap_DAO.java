package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HangNhap;
import entity.NhaCungCap;
import entity.SanPham;

public class HangNhap_DAO {
	
	public HangNhap_DAO() {
		
	}
	
	public boolean nhapHang(HangNhap hangNhap) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Insert into HangNhap(SanPhamID, NhaCungCapID, SoLuong, TongTien, NgayNhap) values(?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, hangNhap.getSanPham().getSanPhamID());
			statement.setString(2, hangNhap.getNhaCungCap().getNhaCungCapID());
			statement.setInt(3, hangNhap.getSoLuong());
			statement.setDouble(4, hangNhap.getTongTien());
			statement.setDate(5, hangNhap.getNgayNhap());
			
			int rs = statement.executeUpdate();
			if(rs > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
	
	public ArrayList<HangNhap> getAllHangNhap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "select * from HangNhap";
			statement = con.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			ArrayList<HangNhap> hangNhapList = new ArrayList<HangNhap>();
			while(rs.next()) {
				SanPham sanPham = new SanPham();
				sanPham.setSanPhamID(rs.getString("SanPhamID"));
				NhaCungCap nhaCungCap = new NhaCungCap();
				nhaCungCap.setNhaCungCapID(rs.getString("NhaCungCapID"));
				int soLuong = rs.getInt("SoLuong");
				double tongTien = rs.getDouble("TongTien");
				Date ngayNhap = rs.getDate("NgayNhap");
				
				HangNhap hangNhap = new HangNhap(sanPham, nhaCungCap, soLuong, tongTien, ngayNhap);
				
				hangNhapList.add(hangNhap);
			}
			return hangNhapList;
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
	
	public HangNhap getHangNhap(String maNCC, String maSP) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		HangNhap hangNhap = null;
		try {
			String sql = "Select ncc.*, sp.SanPhamID, sp.TenSanPham, hn.SoLuong, hn.TongTien, hn.NgayNhap from HangNhap as hn inner join SanPham as sp on hn.SanPhamID=sp.SanPhamID "
					+ "inner join NhaCungCap as ncc on ncc.NhaCungCapID=hn.NhaCungCapID where hn.NhaCungCapID=? and hn.SanPhamID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNCC);
			statement.setString(2, maSP);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				String nhaCungCapID = rs.getString("NhaCungCapID");
				String tenNhaCungCap = rs.getString("TenNhaCungCap");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				NhaCungCap nhaCungCap = new NhaCungCap(nhaCungCapID, tenNhaCungCap, soDienThoai, diaChi);
				
				SanPham sanPham = new SanPham();
				sanPham.setSanPhamID(rs.getString("SanPhamID"));
				sanPham.setTenSanPham(rs.getString("TenSanPham"));
				
				int soLuong = rs.getInt("SoLuong");
				double tongTien = rs.getDouble("TongTien");
				Date ngayNhap = rs.getDate("NgayNhap");
				
				hangNhap = new HangNhap(sanPham, nhaCungCap, soLuong, tongTien, ngayNhap);
			}
			
			return hangNhap;
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
	
	public ArrayList<HangNhap> timKiemHangNhapTheoNgay(Date ngayNhap) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select * from HangNhap where NgayNhap=?";
			statement = con.prepareStatement(sql);
			statement.setDate(1, ngayNhap);
			
			ResultSet rs = statement.executeQuery();
			ArrayList<HangNhap> hangNhapList = new ArrayList<HangNhap>();
			while(rs.next()) {
				SanPham sanPham = new SanPham();
				sanPham.setSanPhamID(rs.getString("SanPhamID"));
				NhaCungCap nhaCungCap = new NhaCungCap();
				nhaCungCap.setNhaCungCapID(rs.getString("NhaCungCapID"));
				int soLuong = rs.getInt("SoLuong");
				double tongTien = rs.getDouble("TongTien");
				Date ngay = rs.getDate("NgayNhap");
				
				HangNhap hangNhap = new HangNhap(sanPham, nhaCungCap, soLuong, tongTien, ngay);
				
				hangNhapList.add(hangNhap);
			}
			return hangNhapList;
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
	
	public boolean xoaHangNhap(String maNCC, String maSP) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Delete from HangNhap where NhaCungCapID=? and SanPhamID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNCC);
			statement.setString(2, maSP);
			
			int rs = statement.executeUpdate();
			if(rs > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
