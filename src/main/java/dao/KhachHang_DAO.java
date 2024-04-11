package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	
	public KhachHang_DAO() {
		
	}
	
	public ArrayList<KhachHang> getAllKhachHang() {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "Select * FROM KhachHang";
            statement = con.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            ArrayList<KhachHang> khList = new ArrayList<KhachHang>();
            while(rs.next()) {
            	KhachHang khachHang = new KhachHang();
            	khachHang.setKhachHangID(rs.getString(1));
            	khachHang.setHoTen(rs.getString(2));
            	khachHang.setGioiTinh(rs.getString(3));
            	khachHang.setNgaySinh(rs.getDate(4));
            	khachHang.setSoDienThoai(rs.getString(5));
            	khachHang.setEmail(rs.getString(6));
            	khachHang.setDiaChi(rs.getString(7));
            	
            	khList.add(khachHang);
            }
            
            return khList; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public KhachHang getKhachHangTheoSDT(String soDienThoai) {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM KhachHang WHERE SoDienThoai=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, soDienThoai);
            
            ResultSet rs = statement.executeQuery();
            
            KhachHang khachHang = null;
            if(rs.next()) {
            	khachHang = new KhachHang();
            	khachHang.setKhachHangID(rs.getString(1));
            	khachHang.setHoTen(rs.getString(2));
            	khachHang.setGioiTinh(rs.getString(3));
            	khachHang.setNgaySinh(rs.getDate(4));
            	khachHang.setSoDienThoai(rs.getString(5));
            	khachHang.setEmail(rs.getString(6));
            	khachHang.setDiaChi(rs.getString(7));
            }
            
            return khachHang; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public KhachHang getKhachHangTheoMa(String khachHangID) {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM KhachHang WHERE KhachHangID=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, khachHangID);
            
            ResultSet rs = statement.executeQuery();
            
            KhachHang khachHang = null;
            if(rs.next()) {
            	khachHang = new KhachHang();
            	khachHang.setKhachHangID(rs.getString(1));
            	khachHang.setHoTen(rs.getString(2));
            	khachHang.setGioiTinh(rs.getString(3));
            	khachHang.setNgaySinh(rs.getDate(4));
            	khachHang.setSoDienThoai(rs.getString(5));
            	khachHang.setEmail(rs.getString(6));
            	khachHang.setDiaChi(rs.getString(7));
            }
            
            return khachHang; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public KhachHang getKhachHangTheoDieuKien(String soDienThoai, String ma) {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM KhachHang WHERE SoDienThoai=? and KhachHangID=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, soDienThoai);
            statement.setString(2, ma);
            
            ResultSet rs = statement.executeQuery();
            
            KhachHang khachHang = null;
            if(rs.next()) {
            	khachHang = new KhachHang();
            	khachHang.setKhachHangID(rs.getString(1));
            	khachHang.setHoTen(rs.getString(2));
            	khachHang.setGioiTinh(rs.getString(3));
            	khachHang.setNgaySinh(rs.getDate(4));
            	khachHang.setSoDienThoai(rs.getString(5));
            	khachHang.setEmail(rs.getString(6));
            	khachHang.setDiaChi(rs.getString(7));
            }
            
            return khachHang; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public boolean themKhachHang(KhachHang kh) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Insert into KhachHang(KhachHangID, HoTen, GioiTinh, NgaySinh, SoDienThoai, Email, DiaChi) "
					+ "values (?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, kh.getKhachHangID());
			statement.setString(2, kh.getHoTen());
			statement.setString(3, kh.getGioiTinh());
			statement.setDate(4, kh.getNgaySinh());
			statement.setString(5, kh.getSoDienThoai());
			statement.setString(6, kh.getEmail());
			statement.setString(7, kh.getDiaChi());
			
			int rs = statement.executeUpdate();
			if(rs == 1) {
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
	
	public boolean capNhatKhachHang(KhachHang kh) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Update KhachHang set HoTen=?, GioiTinh=?, NgaySinh=?, SoDienThoai=?, Email=?, DiaChi=? where KhachHangID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, kh.getHoTen());
			statement.setString(2, kh.getGioiTinh());
			statement.setDate(3, kh.getNgaySinh());
			statement.setString(4, kh.getSoDienThoai());
			statement.setString(5, kh.getEmail());
			statement.setString(6, kh.getDiaChi());
			statement.setString(7, kh.getKhachHangID());
			
			int rs = statement.executeUpdate();
			if(rs == 1) {
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
