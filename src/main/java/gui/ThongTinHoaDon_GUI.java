package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class ThongTinHoaDon_GUI extends JFrame implements ActionListener {

    private JButton jButton_xuatHoaDon;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel14;
    private JLabel jLabel16;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_maHoaDon;
    private JLabel jLabel_ngayLap;
    private JLabel jLabel_soDienThoai;
    private JLabel jLabel_tenKhachHang;
    private JLabel jLabel_tienNhan;
    private JLabel jLabel_tienTraLai;
    private JLabel jLabel_tongTien;
    private JScrollPane jScrollPane1;
    private JTable jTable_sanPham;
    private DefaultTableModel tableModel;
    
    private String maHD;
    private double tienTraLai;
    private double tienNhan;
    private HoaDon_DAO hd_dao = new HoaDon_DAO();
    private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
    
    public ThongTinHoaDon_GUI(String maHD, double tienTraLai, double tienNhan) {
    	this.maHD = maHD;
    	this.tienTraLai = tienTraLai;
    	this.tienNhan = tienNhan;
        khoiTao();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void khoiTao() {
        jLabel_chuDe = new JLabel();
        jLabel4 = new JLabel();
        jLabel_tenKhachHang = new JLabel();
        jLabel6 = new JLabel();
        jLabel_ngayLap = new JLabel();
        // Table
        String[] cols = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền"};
        tableModel = new DefaultTableModel(cols, 0);
        jTable_sanPham = new JTable(tableModel);
        jScrollPane1 = new JScrollPane(jTable_sanPham);
        
        jLabel8 = new JLabel();
        jLabel_maHoaDon = new JLabel();
        jButton_xuatHoaDon = new JButton();
        jLabel10 = new JLabel();
        jLabel_soDienThoai = new JLabel();
        jLabel2 = new JLabel();
        jLabel_tongTien = new JLabel();
        jLabel12 = new JLabel();
        jLabel_tienNhan = new JLabel();
        jLabel14 = new JLabel();
        jLabel_tienTraLai = new JLabel();
        jLabel16 = new JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Thông tin hoá đơn");
        importHoaDon();

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("THÔNG TIN HOÁ ĐƠN");

        jLabel4.setText("Tên khách hàng");

        jLabel_tenKhachHang.setFont(new Font("Segoe UI", 2, 12)); 

        jLabel6.setText("Ngày lập");

        jLabel_ngayLap.setFont(new Font("Segoe UI", 2, 12)); 

        jLabel8.setText("Mã hoá đơn");

        jLabel_maHoaDon.setFont(new Font("Segoe UI", 2, 12)); 

        jButton_xuatHoaDon.setText("Xuất hoá đơn");

        jLabel10.setText("Số điện thoại");

        jLabel_soDienThoai.setFont(new Font("Segoe UI", 2, 12)); 

        jLabel2.setText("Tổng tiền");

        jLabel_tongTien.setFont(new Font("Segoe UI", 2, 12)); 

        jLabel12.setText("Tiền nhận");

        jLabel_tienNhan.setFont(new Font("Segoe UI", 2, 12)); 

        jLabel14.setText("Tiền trả lại");

        jLabel_tienTraLai.setFont(new Font("Segoe UI", 2, 12)); 

        jLabel16.setFont(new Font("Times New Roman", 1, 12)); 
        jLabel16.setText("CẢM ƠN QUÝ KHÁCH ĐÃ MUA SẢN PHẨM TẠI CỬA HÀNG ! HẸN GẶP QUÝ KHÁCH LẦN SAU !");

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
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel_tenKhachHang, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                            .addComponent(jLabel_maHoaDon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(130, 130, 130)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel_ngayLap, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel_soDienThoai, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel14, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                        .addComponent(jLabel12, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_tienNhan, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_tongTien, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_tienTraLai, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jButton_xuatHoaDon)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel_tenKhachHang))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel_soDienThoai))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel_tongTien))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel_tienNhan))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel_tienTraLai))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(23, 23, 23)
                .addComponent(jButton_xuatHoaDon)
                .addGap(22, 22, 22))
        );
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
            java.util.logging.Logger.getLogger(ThongTinHoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinHoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinHoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinHoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_xuatHoaDon)) {
			
		}
		
	}
	
	public void importHoaDon() {
		HoaDon hoaDon = hd_dao.getHoaDonTheoMa(maHD);
		if(hoaDon == null) {
			JOptionPane.showMessageDialog(this, "Hoá đơn không tồn tại!");
			return;
		}
		
		jLabel_maHoaDon.setText(hoaDon.getHoaDonID());
		jLabel_tenKhachHang.setText(hoaDon.getKhachHang().getHoTen());
		jLabel_soDienThoai.setText(hoaDon.getKhachHang().getSoDienThoai());
		jLabel_ngayLap.setText(hoaDon.getNgayLap().toString());
		jLabel_tongTien.setText(hoaDon.getTongTien()+"");
		jLabel_tienNhan.setText(tienNhan+"");
		jLabel_tienTraLai.setText(tienTraLai+"");
		
		ArrayList<ChiTietHoaDon> cthdList = cthd_dao.getAllCTHDTheoHoaDon(maHD);
		
		for (ChiTietHoaDon cthd : cthdList) {
			String[] data = {cthd.getSanPham().getSanPhamID(), cthd.getSanPham().getTenSanPham(), cthd.getSoLuong()+"", cthd.getGiaBan()+"", cthd.getThanhTien()+""};
			tableModel.addRow(data);
		}
	}
}
