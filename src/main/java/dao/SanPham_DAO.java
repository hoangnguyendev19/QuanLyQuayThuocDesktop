package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiSanPham;
import entity.SanPham;

public class SanPham_DAO {
	private LoaiSanPham_DAO loaiSP_dao = new LoaiSanPham_DAO();
	
	public SanPham_DAO() {
		
	}
	
	public ArrayList<SanPham> getAllSanPham() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PreparedStatement statement = null;
        ArrayList<SanPham> sanPhamList = new ArrayList<SanPham>();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT sp.SanPhamID, ImgPath, TenSanPham, ThanhPhan, CachDung, XuatXu, NgaySanXuat, NgayHetHan, DonGia, SoLuongTon, TenLoai, TinhTrang, sp.LoaiID  FROM SanPham as sp inner join LoaiSanPham as lsp on sp.LoaiID=lsp.LoaiID";
            statement = con.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
            	SanPham sanPham = new SanPham();
            	sanPham.setSanPhamID(rs.getString(1));
            	sanPham.setImgPath(rs.getString(2));
            	sanPham.setTenSanPham(rs.getString(3));
            	sanPham.setThanhPhan(rs.getString(4));
            	sanPham.setCachDung(rs.getString(5));
            	sanPham.setXuatXu(rs.getString(6));
            	sanPham.setNgaySanXuat(rs.getDate(7));
            	sanPham.setNgayHetHan(rs.getDate(8));
            	sanPham.setDonGia(rs.getDouble(9));
            	sanPham.setSoLuongTon(rs.getInt(10));
            	LoaiSanPham loai = new LoaiSanPham(rs.getString(13), rs.getString(11));
            	sanPham.setLoaiSanPham(loai);
            	sanPham.setTinhTrang(rs.getString(12));
            	
            	sanPhamList.add(sanPham);
            }
            return sanPhamList; 
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
	
	public SanPham findOne(String maSP) {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
        	String sql = "SELECT sp.SanPhamID, ImgPath, TenSanPham, ThanhPhan, CachDung, XuatXu, NgaySanXuat, NgayHetHan, DonGia, SoLuongTon, TenLoai, TinhTrang, sp.LoaiID  FROM SanPham as sp inner join LoaiSanPham as lsp on sp.LoaiID=lsp.LoaiID WHERE sp.SanPhamID = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maSP);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	SanPham sanPham = new SanPham();
            	sanPham.setSanPhamID(rs.getString(1));
            	sanPham.setImgPath(rs.getString(2));
            	sanPham.setTenSanPham(rs.getString(3));
            	sanPham.setThanhPhan(rs.getString(4));
            	sanPham.setCachDung(rs.getString(5));
            	sanPham.setXuatXu(rs.getString(6));
            	sanPham.setNgaySanXuat(rs.getDate(7));
            	sanPham.setNgayHetHan(rs.getDate(8));
            	sanPham.setDonGia(rs.getDouble(9));
            	sanPham.setSoLuongTon(rs.getInt(10));
            	LoaiSanPham loai = new LoaiSanPham(rs.getString(13), rs.getString(11));
            	sanPham.setLoaiSanPham(loai);
            	sanPham.setTinhTrang(rs.getString(12));
            	return sanPham;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public boolean update(SanPham sp) throws SQLException {
		int n = 0;
		ConnectDB.getInstance().connect();
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
         try {
        	 String sql = "UPDATE SanPham" 
        			 + " SET ImgPath = ?, TenSanPham = ?, ThanhPhan = ?, CachDung = ?, XuatXu = ?, NgaySanXuat = ?, NgayHetHan = ?, DonGia = ?, SoLuongTon = ?, LoaiID = ?, TinhTrang = ?" 
        			 + " WHERE SanPhamID = ?";
             statement = connection.prepareStatement(sql);
             statement.setString(1, sp.getImgPath());
             statement.setString(2, sp.getTenSanPham());
             statement.setString(3, sp.getThanhPhan());
             statement.setString(4, sp.getCachDung());
             statement.setString(5, sp.getXuatXu());
             statement.setDate(6, sp.getNgaySanXuat());
             statement.setDate(7, sp.getNgayHetHan());
             statement.setDouble(8, sp.getDonGia());
             statement.setInt(9, sp.getSoLuongTon());
             statement.setString(10, sp.getLoaiSanPham().getLoaiID());
             statement.setString(11, sp.getTinhTrang());
             statement.setString(12, sp.getSanPhamID());
             n = statement.executeUpdate();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         return n > 0;
	}
	
	public LoaiSanPham getLoaiSanPham(String id) throws SQLException{
		ConnectDB.getInstance().connect();
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
         try {
        	 String sql = "SELECT * FROM LoaiSanPham WHERE TenLoai = ?";
             statement = connection.prepareStatement(sql);
             statement.setString(1, id);
             ResultSet rs = statement.executeQuery();
             while (rs.next()) {
            	 LoaiSanPham lsp = new LoaiSanPham();
            	 lsp.setLoaiID(rs.getString("LoaiID"));
            	 lsp.setTenLoai(rs.getString("TenLoai"));
            	 return lsp;
             }
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         return null;
	}
	
	public boolean insert(SanPham sp) {
		int n = 0;
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT INTO SanPham(SanPhamID, ImgPath, TenSanPham, ThanhPhan, CachDung, XuatXu, NgaySanXuat, NgayHetHan, DonGia, SoLuongTon, LoaiID, TinhTrang)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, sp.getSanPhamID());
			statement.setString(2, sp.getImgPath());
            statement.setString(3, sp.getTenSanPham());
            statement.setString(4, sp.getThanhPhan());
            statement.setString(5, sp.getCachDung());
            statement.setString(6, sp.getXuatXu());
            statement.setDate(7, sp.getNgaySanXuat());
            statement.setDate(8, sp.getNgayHetHan());
            statement.setDouble(9, sp.getDonGia());
            statement.setInt(10, sp.getSoLuongTon());
            statement.setString(11, sp.getLoaiSanPham().getLoaiID());
            statement.setString(12, sp.getTinhTrang());
            n = statement.executeUpdate();
            ConnectDB.getInstance().disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<SanPham> getSPTheoLoaiID(String loaiID) {
		ArrayList<SanPham> listSP = new ArrayList<>();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM SanPham WHERE LoaiID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, loaiID);
			rs = statement.executeQuery();
			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setSanPhamID(rs.getString("SanPhamID"));
				sp.setCachDung(rs.getString("CachDung"));
				sp.setDonGia(rs.getDouble("DonGia"));
				sp.setTenSanPham(rs.getString("TenSanPham"));
				sp.setImgPath(rs.getString("ImgPath"));
				LoaiSanPham lsp = new LoaiSanPham();
				lsp = loaiSP_dao.getLoaiSPTheoMaLoai(rs.getString("LoaiID"));
				sp.setLoaiSanPham(lsp);
				sp.setThanhPhan(rs.getString("ThanhPhan"));
				sp.setSoLuongTon(rs.getInt("SoLuongTon"));
				sp.setNgayHetHan(rs.getDate("NgayHetHan"));
				sp.setNgaySanXuat(rs.getDate("NgaySanXuat"));
				sp.setTinhTrang(rs.getString("TinhTrang"));
				sp.setXuatXu(rs.getString("XuatXu"));
				
				listSP.add(sp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return listSP;
	}
	public SanPham timKiemSanPhamTheoMa(String ma) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT sp.*, lsp.TenLoai  FROM SanPham as sp inner join LoaiSanPham as lsp on sp.LoaiID=lsp.LoaiID where SanPhamID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			
			ResultSet rs = statement.executeQuery();
			SanPham sanPham = null; 
			if(rs.next()) {
				sanPham = new SanPham();
            	sanPham.setSanPhamID(rs.getString("SanPhamID"));
            	sanPham.setImgPath(rs.getString("ImgPath"));
            	sanPham.setTenSanPham(rs.getString("TenSanPham"));
            	sanPham.setThanhPhan(rs.getString("ThanhPhan"));
            	sanPham.setCachDung(rs.getString("CachDung"));
            	sanPham.setXuatXu(rs.getString("XuatXu"));
            	sanPham.setNgaySanXuat(rs.getDate("NgaySanXuat"));
            	sanPham.setNgayHetHan(rs.getDate("NgayHetHan"));
            	sanPham.setDonGia(rs.getDouble("DonGia"));
            	sanPham.setSoLuongTon(rs.getInt("SoLuongTon"));
            	LoaiSanPham loai = new LoaiSanPham(rs.getString("LoaiID"), rs.getString("TenLoai"));
            	sanPham.setLoaiSanPham(loai);
            	sanPham.setTinhTrang(rs.getString("TinhTrang"));
			}
			return sanPham;
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
	
	public SanPham timKiemSPTheoMaVaLoai(String ma, String loaiSP, LoaiSanPham lsp) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		SanPham sanPham = null; 
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM SanPham WHERE SanPhamID = ? AND LoaiID = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			statement.setString(2, loaiSP);
			rs = statement.executeQuery();
			if(rs.next()) {
				sanPham = new SanPham();
            	sanPham.setSanPhamID(rs.getString("SanPhamID"));
            	sanPham.setImgPath(rs.getString("ImgPath"));
            	sanPham.setTenSanPham(rs.getString("TenSanPham"));
            	sanPham.setThanhPhan(rs.getString("ThanhPhan"));
            	sanPham.setCachDung(rs.getString("CachDung"));
            	sanPham.setXuatXu(rs.getString("XuatXu"));
            	sanPham.setNgaySanXuat(rs.getDate("NgaySanXuat"));
            	sanPham.setNgayHetHan(rs.getDate("NgayHetHan"));
            	sanPham.setDonGia(rs.getDouble("DonGia"));
            	sanPham.setSoLuongTon(rs.getInt("SoLuongTon"));
            	sanPham.setLoaiSanPham(lsp);
            	sanPham.setTinhTrang(rs.getString("TinhTrang"));
            	
            	return sanPham;
			}
		} catch (Exception e) {
            e.printStackTrace();
        } 
		return null;
	}
}
