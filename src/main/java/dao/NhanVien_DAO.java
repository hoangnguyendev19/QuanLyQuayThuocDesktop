package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {
	
	public NhanVien_DAO() {

    }

    public NhanVien getNhanVien(String tenTaiKhoan) {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM NhanVien WHERE TenTaiKhoan = ? ";
            statement = con.prepareStatement(sql);
            statement.setString(1, tenTaiKhoan);
            
            ResultSet rs = statement.executeQuery();
            
            NhanVien nhanVien = new NhanVien(); 
            while(rs.next()) {
            	nhanVien.setNhanVienID(rs.getString(1));
            	nhanVien.setHoTen(rs.getString(2));
            	nhanVien.setGioiTinh(rs.getString(3));
            	nhanVien.setNgaySinh(rs.getDate(4));
            	nhanVien.setEmail(rs.getString(5));
            	nhanVien.setSoDienThoai(rs.getString(6));
            	nhanVien.setDiaChi(rs.getString(7));
            	nhanVien.setChucVu(rs.getString(8));
            	nhanVien.setTenTaiKhoan(rs.getString(9));
            }
            
            return nhanVien;
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
    
    public ArrayList<NhanVien> getAllNhanVien() {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM NhanVien";
            statement = con.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            ArrayList<NhanVien> nhanVienList = new ArrayList<NhanVien>();
            
            while(rs.next()) {
            	NhanVien nhanVien = new NhanVien(); 
            	nhanVien.setNhanVienID(rs.getString(1));
            	nhanVien.setHoTen(rs.getString(2));
            	nhanVien.setGioiTinh(rs.getString(3));
            	nhanVien.setNgaySinh(rs.getDate(4));
            	nhanVien.setEmail(rs.getString(5));
            	nhanVien.setSoDienThoai(rs.getString(6));
            	nhanVien.setDiaChi(rs.getString(7));
            	nhanVien.setChucVu(rs.getString(8));
            	nhanVien.setTenTaiKhoan(rs.getString(9));
            	nhanVien.setMatKhau(rs.getString(10));
            	
            	nhanVienList.add(nhanVien);
            }
            
            return nhanVienList;
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
    
    public NhanVien timKiemNhanVienTheoMa(String ma) {
    	try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection con = ConnectDB.getConnection();
    	PreparedStatement statement = null;
    	
    	try {
			String sql = "Select * from NhanVien where NhanVienID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			
			ResultSet rs = statement.executeQuery();
			NhanVien nhanVien = null;
			if(rs.next()) {
				String nhanVienID = rs.getString("NhanVienID");
				String hoTen = rs.getString("HoTen");
				String gioiTinh = rs.getString("GioiTinh");
				Date ngaySinh = rs.getDate("NgaySinh");
				String email = rs.getString("Email");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String chucVu = rs.getString("ChucVu");
				String tenTaiKhoan = rs.getString("TenTaiKhoan");
				String matKhau = rs.getString("MatKhau");
				
				nhanVien = new NhanVien(nhanVienID, hoTen, gioiTinh, ngaySinh, email, soDienThoai, diaChi, chucVu, tenTaiKhoan, matKhau);
			}
			return nhanVien;
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
    
    public NhanVien timKiemNhanVienTheoSDT(String sdt) {
    	try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection con = ConnectDB.getConnection();
    	PreparedStatement statement = null;
    	
    	try {
			String sql = "Select * from NhanVien where SoDienThoai=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, sdt);
			
			ResultSet rs = statement.executeQuery();
			NhanVien nhanVien = null;
			if(rs.next()) {
				String nhanVienID = rs.getString("NhanVienID");
				String hoTen = rs.getString("HoTen");
				String gioiTinh = rs.getString("GioiTinh");
				Date ngaySinh = rs.getDate("NgaySinh");
				String email = rs.getString("Email");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String chucVu = rs.getString("ChucVu");
				String tenTaiKhoan = rs.getString("TenTaiKhoan");
				String matKhau = rs.getString("MatKhau");
				
				nhanVien = new NhanVien(nhanVienID, hoTen, gioiTinh, ngaySinh, email, soDienThoai, diaChi, chucVu, tenTaiKhoan, matKhau);
			}
			return nhanVien;
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
    
    public NhanVien timKiemNhanVienTheoDieuKien(String ma, String sdt) {
    	try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection con = ConnectDB.getConnection();
    	PreparedStatement statement = null;
    	
    	try {
			String sql = "Select * from NhanVien where NhanVienID=? and SoDienThoai=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			statement.setString(2, sdt);
			
			ResultSet rs = statement.executeQuery();
			NhanVien nhanVien = null;
			if(rs.next()) {
				String nhanVienID = rs.getString("NhanVienID");
				String hoTen = rs.getString("HoTen");
				String gioiTinh = rs.getString("GioiTinh");
				Date ngaySinh = rs.getDate("NgaySinh");
				String email = rs.getString("Email");
				String soDienThoai = rs.getString("SoDienThoai");
				String diaChi = rs.getString("DiaChi");
				String chucVu = rs.getString("ChucVu");
				String tenTaiKhoan = rs.getString("TenTaiKhoan");
				String matKhau = rs.getString("MatKhau");
				
				nhanVien = new NhanVien(nhanVienID, hoTen, gioiTinh, ngaySinh, email, soDienThoai, diaChi, chucVu, tenTaiKhoan, matKhau);
			}
			return nhanVien;
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
    
    public boolean themNhanVien(NhanVien nhanVien) {
    	try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection con = ConnectDB.getConnection();
    	PreparedStatement statement = null;
    	
    	try {
			String sql = "Insert into NhanVien(NhanVienID, HoTen, GioiTinh, NgaySinh, Email, SoDienThoai, DiaChi, ChucVu, TenTaiKhoan, MatKhau) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, nhanVien.getNhanVienID());
			statement.setString(2, nhanVien.getHoTen());
			statement.setString(3, nhanVien.getGioiTinh());
			statement.setDate(4, nhanVien.getNgaySinh());
			statement.setString(5, nhanVien.getEmail());
			statement.setString(6, nhanVien.getSoDienThoai());
			statement.setString(7, nhanVien.getDiaChi());
			statement.setString(8, nhanVien.getChucVu());
			statement.setString(9, nhanVien.getTenTaiKhoan());
			statement.setString(10, nhanVien.getMatKhau());
			
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
    
    public boolean capNhatNhanVien(NhanVien nhanVien) {
    	try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Connection con = ConnectDB.getConnection();
    	PreparedStatement statement = null;
    	
    	try {
			String sql = "Update NhanVien set HoTen=?, GioiTinh=?, NgaySinh=?, Email=?, SoDienThoai=?, DiaChi=?, ChucVu=? where NhanVienID=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, nhanVien.getHoTen());
			statement.setString(2, nhanVien.getGioiTinh());
			statement.setDate(3, nhanVien.getNgaySinh());
			statement.setString(4, nhanVien.getEmail());
			statement.setString(5, nhanVien.getSoDienThoai());
			statement.setString(6, nhanVien.getDiaChi());
			statement.setString(7, nhanVien.getChucVu());
			statement.setString(8, nhanVien.getNhanVienID());
			
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
    
    public Boolean checkNV(String email, String tenTK) {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM NhanVien WHERE Email = ? AND TenTaiKhoan = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, tenTK);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return false;
      
    }
    
    public boolean lamMoiMatKhau(NhanVien nv) {

        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {
            statement = con.prepareStatement("update NhanVien set MatKhau = ? where TenTaiKhoan= ?");
            statement.setString(1, nv.getMatKhau());
            statement.setString(2, nv.getTenTaiKhoan());
            n = statement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return n > 0;
    }
}
