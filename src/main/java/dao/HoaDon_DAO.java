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

public class HoaDon_DAO {
	
	private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
	
	public HoaDon_DAO() {
		
	}
	
	public boolean taoHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> cthdList) {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO HoaDon(HoaDonID, NhanVienID, KhachHangID, TongTien, NgayLap) VALUES (?, ?, ?, ?, ?)";
            statement = con.prepareStatement(sql);
            statement.setString(1, hoaDon.getHoaDonID());
            statement.setString(2, hoaDon.getNhanVien().getNhanVienID());
            statement.setString(3, hoaDon.getKhachHang().getKhachHangID());
            statement.setDouble(4, hoaDon.getTongTien());
            statement.setDate(5, hoaDon.getNgayLap());
            
            int kq = statement.executeUpdate();
            
            if(kq < 0) {
            	return false;
            }
            
            for (ChiTietHoaDon cthd : cthdList) {
				boolean rs = cthd_dao.themChiTietHoaDon(cthd);
				if(!rs) {
					return false;
				}
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
	
	public HoaDon getHoaDonTheoMa(String maHD) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		HoaDon hoaDon = null;
		try {
			String sql = "Select hd.*, HoTen, SoDienThoai from HoaDon as hd inner join KhachHang as kh on hd.KhachHangID=kh.KhachHangID where HoaDonID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				String HoaDonID = rs.getString("HoaDonID");
				String NhanVienID = rs.getString("NhanVienID");
				NhanVien nhanVien = new NhanVien();
				nhanVien.setNhanVienID(NhanVienID);
				String KhachHangID = rs.getString("KhachHangID");
				String hoTen = rs.getString("HoTen");
				String soDienThoai = rs.getString("SoDienThoai");
				KhachHang khachHang = new KhachHang();
				khachHang.setKhachHangID(KhachHangID);
				khachHang.setHoTen(hoTen);
				khachHang.setSoDienThoai(soDienThoai);
				double tongTien = rs.getDouble("TongTien");
				Date ngayLap = rs.getDate("NgayLap");
				
				hoaDon = new HoaDon(HoaDonID, nhanVien, khachHang, tongTien, ngayLap);
			}
			return hoaDon;
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
	
	public ArrayList<HoaDon> getAllHoaDon() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Select * from HoaDon";
			statement = con.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			ArrayList<HoaDon> hoaDonList = new ArrayList<HoaDon>();
			while(rs.next()) {
				String hoaDonID = rs.getString("HoaDonID");
				KhachHang khachHang = new KhachHang();
				khachHang.setKhachHangID(rs.getString("KhachHangID"));
				NhanVien nhanVien = new NhanVien();
				nhanVien.setNhanVienID(rs.getString("NhanVienID"));
				double tongTien = rs.getDouble("TongTien");
				Date ngayLap = rs.getDate("NgayLap");
				
				HoaDon hoaDon = new HoaDon(hoaDonID, nhanVien, khachHang, tongTien, ngayLap);
				hoaDonList.add(hoaDon);
			}
			return hoaDonList;
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
	
	public boolean xoaHoaDon(String ma) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "Delete from HoaDon where HoaDonID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			
			int rs = statement.executeUpdate();
			
			if(rs == 1) {
				return true;
			}
			return false;
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
	
	public ArrayList<HoaDon> timKiemHoaDonTheoDieuKien(String maHD, Date ngayLap) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			ArrayList<HoaDon> hdList = new ArrayList<HoaDon>();
			String sql = "";
			if(ngayLap == null) {
				sql = "Select * from HoaDon where HoaDonID=?";				
				statement = con.prepareStatement(sql);
				statement.setString(1, maHD);
			} else if(maHD.equals("")) {
				sql = "Select * from HoaDon where NgayLap=?";
				statement = con.prepareStatement(sql);
				statement.setDate(1, ngayLap);
			} else {
				sql = "Select * from HoaDon where HoaDonID=? and NgayLap=?";				
				statement = con.prepareStatement(sql);
				statement.setString(1, maHD);
				statement.setDate(2, ngayLap);
			}
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String HoaDonID = rs.getString("HoaDonID");
				String NhanVienID = rs.getString("NhanVienID");
				NhanVien nhanVien = new NhanVien();
				nhanVien.setNhanVienID(NhanVienID);
				String KhachHangID = rs.getString("KhachHangID");
				KhachHang khachHang = new KhachHang();
				khachHang.setKhachHangID(KhachHangID);
				double tongTien = rs.getDouble("TongTien");
				Date nl = rs.getDate("NgayLap");
				
				HoaDon hoaDon = new HoaDon(HoaDonID, nhanVien, khachHang, tongTien, nl);
				hdList.add(hoaDon);
			}
			return hdList;
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
