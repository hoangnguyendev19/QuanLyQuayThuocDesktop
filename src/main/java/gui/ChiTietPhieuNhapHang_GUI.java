package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dao.HangNhap_DAO;
import entity.HangNhap;

public class ChiTietPhieuNhapHang_GUI extends JFrame implements ActionListener {
	
    private JButton jButton_thoat;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_diaChi;
    private JLabel jLabel_maNhaCungCap;
    private JLabel jLabel_maSanPham;
    private JLabel jLabel_ngayNhap;
    private JLabel jLabel_soDienThoai;
    private JLabel jLabel_soLuong;
    private JLabel jLabel_tenNhaCungCap;
    private JLabel jLabel_tenSanPham;
    private JLabel jLabel_tongTien;
    
    private String maSP;
    private String maNCC;
    private HangNhap_DAO hn_dao = new HangNhap_DAO();

    public ChiTietPhieuNhapHang_GUI(String maSP, String maNCC) {
    	this.maSP = maSP;
    	this.maNCC = maNCC;
        khoiTao();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void khoiTao() {

        jLabel_chuDe = new JLabel();
        jLabel2 = new JLabel();
        jLabel_tenNhaCungCap = new JLabel();
        jLabel4 = new JLabel();
        jLabel_soDienThoai = new JLabel();
        jLabel6 = new JLabel();
        jLabel_ngayNhap = new JLabel();
        jLabel8 = new JLabel();
        jLabel_maNhaCungCap = new JLabel();
        jButton_thoat = new JButton();
        jButton_thoat.addActionListener(this);
        jLabel10 = new JLabel();
        jLabel_tongTien = new JLabel();
        jLabel1 = new JLabel();
        jLabel_diaChi = new JLabel();
        jLabel5 = new JLabel();
        jLabel_maSanPham = new JLabel();
        jLabel9 = new JLabel();
        jLabel_tenSanPham = new JLabel();
        jLabel12 = new JLabel();
        jLabel_soLuong = new JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Thông tin chi tiết phiếu nhập");
        importChiTietHangNhap();

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("THÔNG TIN PHIẾU NHẬP HÀNG");

        jLabel2.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel2.setText("Tên nhà cung cấp");

        jLabel_tenNhaCungCap.setFont(new Font("Times New Roman", 2, 14)); 

        jLabel4.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel4.setText("Số điện thoại");

        jLabel_soDienThoai.setFont(new Font("Times New Roman", 2, 14)); 

        jLabel6.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel6.setText("Ngày nhập");

        jLabel_ngayNhap.setFont(new Font("Times New Roman", 2, 14)); 

        jLabel8.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel8.setText("Mã nhà cung cấp");

        jLabel_maNhaCungCap.setFont(new Font("Times New Roman", 2, 14)); 

        jButton_thoat.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_thoat.setText("Thoát");

        jLabel10.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel10.setText("Tổng tiền");

        jLabel_tongTien.setFont(new Font("Times New Roman", 2, 14)); 

        jLabel1.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel1.setText("Địa chỉ");

        jLabel_diaChi.setFont(new Font("Times New Roman", 2, 14)); 

        jLabel5.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel5.setText("Mã sản phẩm");

        jLabel_maSanPham.setFont(new Font("Times New Roman", 2, 14)); 

        jLabel9.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel9.setText("Tên sản phẩm");

        jLabel_tenSanPham.setFont(new Font("Times New Roman", 2, 14)); 

        jLabel12.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel12.setText("Số lượng");

        jLabel_soLuong.setFont(new Font("Times New Roman", 2, 14)); 

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_diaChi, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel_tenNhaCungCap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_soDienThoai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_maNhaCungCap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel_maSanPham, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_tenSanPham, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_soLuong, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_tongTien, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_ngayNhap, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_thoat)
                .addGap(224, 224, 224))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel_chuDe)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel_ngayNhap)
                    .addComponent(jLabel8)
                    .addComponent(jLabel_maNhaCungCap))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel_tenNhaCungCap))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel_soDienThoai))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_diaChi))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_maSanPham))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel_tenSanPham))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel_soLuong))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel_tongTien))
                .addGap(18, 18, 18)
                .addComponent(jButton_thoat)
                .addGap(23, 23, 23))
        );

        pack();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhapHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhapHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhapHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhapHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    // Code
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(jButton_thoat)) {
			dispose();
		}
	}
	
	public void importChiTietHangNhap() {
		HangNhap hangNhap = hn_dao.getHangNhap(maNCC, maSP);
		if(hangNhap != null) {
			jLabel_maNhaCungCap.setText(hangNhap.getNhaCungCap().getNhaCungCapID());
			jLabel_tenNhaCungCap.setText(hangNhap.getNhaCungCap().getTenNhaCungCap());
			jLabel_soDienThoai.setText(hangNhap.getNhaCungCap().getSoDienThoai());
			jLabel_diaChi.setText(hangNhap.getNhaCungCap().getDiaChi());
			
			jLabel_maSanPham.setText(hangNhap.getSanPham().getSanPhamID());
			jLabel_tenSanPham.setText(hangNhap.getSanPham().getTenSanPham());
			jLabel_soLuong.setText(hangNhap.getSoLuong()+"");
			jLabel_tongTien.setText(hangNhap.getTongTien()+" VND");
			jLabel_ngayNhap.setText(hangNhap.getNgayNhap().toString());
		}
	}
}
