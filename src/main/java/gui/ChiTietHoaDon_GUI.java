package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;

public class ChiTietHoaDon_GUI extends JFrame implements ActionListener {
	
    private JButton jButton_thoat;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_maHoaDon;
    private JLabel jLabel_maKhachHang;
    private JLabel jLabel_maNhanVien;
    private JLabel jLabel_ngayLap;
    private JLabel jLabel_tongTien;
    private JScrollPane jScrollPane1;
    private JTable jTable_sanPham;
    private DefaultTableModel tableModel;
    
    private String ma;
    private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
    private HoaDon_DAO hd_dao = new HoaDon_DAO();

    public ChiTietHoaDon_GUI(String ma) {
    	this.ma = ma;
        khoiTao();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void khoiTao() {
        jLabel_chuDe = new JLabel();
        jLabel2 = new JLabel();
        jLabel_maNhanVien = new JLabel();
        jLabel4 = new JLabel();
        jLabel_maKhachHang = new JLabel();
        jLabel6 = new JLabel();
        jLabel_ngayLap = new JLabel();
        jLabel8 = new JLabel();
        jLabel_maHoaDon = new JLabel();
        jButton_thoat = new JButton();
        jButton_thoat.addActionListener(this);
        jLabel10 = new JLabel();
        jLabel_tongTien = new JLabel();
        // Table
        String[] cols = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền"};
        tableModel = new DefaultTableModel(cols, 0);
        jTable_sanPham = new JTable(tableModel);
        jScrollPane1 = new JScrollPane(jTable_sanPham);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Thông tin chi tiết hoá đơn");
        importHoaDon();

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("THÔNG TIN CHI TIẾT HOÁ ĐƠN");

        jLabel2.setFont(new Font("Segoe UI", 1, 12)); 
        jLabel2.setText("Mã nhân viên");

        jLabel_maNhanVien.setFont(new Font("Segoe UI", 2, 12)); 

        jLabel4.setFont(new Font("Segoe UI", 1, 12)); 
        jLabel4.setText("Mã khách hàng");

        jLabel_maKhachHang.setFont(new Font("Segoe UI", 2, 12)); 

        jLabel6.setFont(new Font("Segoe UI", 1, 12)); 
        jLabel6.setText("Ngày lập");

        jLabel_ngayLap.setFont(new Font("Segoe UI", 2, 12)); 

        jLabel8.setFont(new Font("Segoe UI", 1, 12)); 
        jLabel8.setText("Mã hoá đơn");

        jLabel_maHoaDon.setFont(new Font("Segoe UI", 2, 12)); 

        jButton_thoat.setFont(new Font("Segoe UI", 1, 12)); 
        jButton_thoat.setText("Thoát");

        jLabel10.setFont(new Font("Segoe UI", 1, 12)); 
        jLabel10.setText("Tổng tiền");

        jLabel_tongTien.setFont(new Font("Segoe UI", 2, 12)); 

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_maNhanVien, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jLabel_maKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_maHoaDon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(130, 130, 130)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_ngayLap, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel_tongTien, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jButton_thoat)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel_chuDe)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel_ngayLap)
                    .addComponent(jLabel8)
                    .addComponent(jLabel_maHoaDon))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel_maNhanVien))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel_maKhachHang))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel_tongTien))
                .addGap(18, 18, 18)
                .addComponent(jButton_thoat)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedClassVersionError ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
	
	public void importHoaDon() {
		HoaDon hd = hd_dao.getHoaDonTheoMa(ma);
		jLabel_maHoaDon.setText(hd.getHoaDonID());
		jLabel_maNhanVien.setText(hd.getNhanVien().getNhanVienID());
		jLabel_maKhachHang.setText(hd.getKhachHang().getKhachHangID());
		jLabel_ngayLap.setText(hd.getNgayLap().toString());
		jLabel_tongTien.setText(hd.getTongTien()+"");
		
		ArrayList<ChiTietHoaDon> cthdList = cthd_dao.getAllCTHDTheoHoaDon(ma);
		for (ChiTietHoaDon cthd : cthdList) {
			tableModel.addRow(cthd.toString().split(";"));
		}
	}
}
