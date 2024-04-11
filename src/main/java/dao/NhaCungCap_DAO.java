package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaCungCap;

public class NhaCungCap_DAO {
	
	public NhaCungCap_DAO() {
		
	}
	
	public ArrayList<NhaCungCap> getAllNhaCungCap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select * from NhaCungCap";
			statement = con.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			ArrayList<NhaCungCap> nccList = new ArrayList<NhaCungCap>();
			while(rs.next()) {
				String nhaCungCapID = rs.getString("NhaCungCapID");
				String tenNhaCungCap = rs.getString("TenNhaCungCap");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				
				NhaCungCap ncc = new NhaCungCap(nhaCungCapID, tenNhaCungCap, soDienThoai, diaChi);
				
				nccList.add(ncc);
			}
			return nccList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public NhaCungCap timKiemNCCTheoMa(String ma) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from NhaCungCap where NhaCungCapID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			
			ResultSet rs = statement.executeQuery();
			NhaCungCap ncc = null;
			if(rs.next()) {
				String nhaCungCapID = rs.getString("NhaCungCapID");
				String tenNhaCungCap = rs.getString("TenNhaCungCap");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				
				ncc = new NhaCungCap(nhaCungCapID, tenNhaCungCap, soDienThoai, diaChi);
			}
			return ncc;
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
	
	public NhaCungCap timKiemNCCTheoSoDienThoai(String sdt) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from NhaCungCap where SoDienThoai=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, sdt);
			
			ResultSet rs = statement.executeQuery();
			NhaCungCap ncc = null;
			if(rs.next()) {
				String nhaCungCapID = rs.getString("NhaCungCapID");
				String tenNhaCungCap = rs.getString("TenNhaCungCap");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				
				ncc = new NhaCungCap(nhaCungCapID, tenNhaCungCap, soDienThoai, diaChi);
			}
			return ncc;
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
	
	public NhaCungCap timKiemNCCTheoDieuKien(String sdt, String ma) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from NhaCungCap where SoDienThoai=? and NhaCungCapID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, sdt);
			statement.setString(2, ma);
			
			ResultSet rs = statement.executeQuery();
			NhaCungCap ncc = null;
			if(rs.next()) {
				String nhaCungCapID = rs.getString("NhaCungCapID");
				String tenNhaCungCap = rs.getString("TenNhaCungCap");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				
				ncc = new NhaCungCap(nhaCungCapID, tenNhaCungCap, soDienThoai, diaChi);
			}
			return ncc;
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
	
	public boolean themNhaCungCap(NhaCungCap ncc) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;	
		
		try {
			String sql = "Insert into NhaCungCap(NhaCungCapID, TenNhaCungCap, SoDienThoai, DiaChi) values(?, ?, ?, ?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, ncc.getNhaCungCapID());
			statement.setString(2, ncc.getTenNhaCungCap());
			statement.setString(3, ncc.getSoDienThoai());
			statement.setString(4, ncc.getDiaChi());
			
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
	
	public boolean capNhatNhaCungCap(NhaCungCap ncc) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;	
		
		try {
			String sql = "Update NhaCungCap set TenNhaCungCap=?, SoDienThoai=?, DiaChi=? where NhaCungCapID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ncc.getTenNhaCungCap());
			statement.setString(2, ncc.getSoDienThoai());
			statement.setString(3, ncc.getDiaChi());
			statement.setString(4, ncc.getNhaCungCapID());
			
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
