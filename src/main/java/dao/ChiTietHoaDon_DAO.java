package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class ChiTietHoaDon_DAO {

	public ChiTietHoaDon_DAO() {
		
	}
	
	public boolean themChiTietHoaDon(ChiTietHoaDon cthd) {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO ChiTietHoaDon VALUES (?, ?, ?, ?, ?)";
            statement = con.prepareStatement(sql);
            statement.setString(1, cthd.getSanPham().getSanPhamID());
            statement.setString(2, cthd.getHoaDon().getHoaDonID());
            statement.setInt(3, cthd.getSoLuong());
            statement.setDouble(4, cthd.getGiaBan());
            statement.setDouble(5, cthd.getThanhTien());
            
            int rs = statement.executeUpdate();

            if(rs < 0) {
            	return false;
            }
            
            return true; 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
	
	public ArrayList<ChiTietHoaDon> getAllCTHDTheoHoaDon(String maHD) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ArrayList<ChiTietHoaDon> cthdList = new ArrayList<ChiTietHoaDon>();
		try {
			String sql = "Select cthd.*, TenSanPham from ChiTietHoaDon as cthd inner join SanPham as sp on cthd.SanPhamID=sp.SanPhamID where HoaDonID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String sanPhamID = rs.getString("SanPhamID");
				String tenSanPham = rs.getString("TenSanPham");
				SanPham sanPham = new SanPham();
				sanPham.setSanPhamID(sanPhamID);
				sanPham.setTenSanPham(tenSanPham);
				String hoaDonID = rs.getString("HoaDonID");
				HoaDon hoaDon = new HoaDon();
				hoaDon.setHoaDonID(hoaDonID);
				int soLuong = rs.getShort("SoLuong");
				double giaBan = rs.getDouble("GiaBan");
				double thanhTien = rs.getDouble("ThanhTien");
				
				ChiTietHoaDon cthd = new ChiTietHoaDon(sanPham, hoaDon, soLuong, giaBan, thanhTien);
				
				cthdList.add(cthd);
			}
			return cthdList;
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
}
