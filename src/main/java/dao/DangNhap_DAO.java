package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.NhanVien;

public class DangNhap_DAO {

    public DangNhap_DAO() {

    }

    public NhanVien dangNhap(String tenTaiKhoan, String matKhau) {
        try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM NhanVien WHERE TenTaiKhoan = ? AND MatKhau = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, tenTaiKhoan);
            statement.setString(2, matKhau);
            
            ResultSet rs = statement.executeQuery();
            
            NhanVien nhanVien = null;
            if (rs.next()) {
                String nhanVienID = rs.getString("NhanVienID");
                String hoTen = rs.getString("HoTen");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("ngaySinh");
                String email = rs.getString("Email");
                String soDienThoai = rs.getString("SoDienThoai");
                String diaChi = rs.getString("DiaChi");
                String chucVu = rs.getString("ChucVu");
                String tenTK = rs.getString("TenTaiKhoan");
                String mk = rs.getString("MatKhau");
                
                nhanVien = new NhanVien(nhanVienID, hoTen, gioiTinh, ngaySinh, email, soDienThoai, diaChi, chucVu, tenTK, mk);
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
}
