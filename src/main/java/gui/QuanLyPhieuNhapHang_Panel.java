package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.HangNhap_DAO;
import entity.HangNhap;
import entity.NhanVien;

public class QuanLyPhieuNhapHang_Panel extends JPanel implements ActionListener {
	
    private JButton jButton_lamMoi;
    private JButton jButton_timKiem;
    private JButton jButton_xemChiTiet;
    private JButton jButton_xoa;
    private JDateChooser jDateChooser_ngayNhap;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_ngayNhap;
    private JLabel jLabel_nguoiDung;
    private JPanel jPanel_center;
    private JPanel jPanel_north;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private DefaultTableModel tableModel;
    
    private NhanVien nhanVien = new NhanVien();
    private HangNhap_DAO hn_dao = new HangNhap_DAO();
    
    public QuanLyPhieuNhapHang_Panel(NhanVien nhanVien) {
    	this.nhanVien = nhanVien;
    	khoiTao();
    }
    
    private void khoiTao() {
        jPanel_north = new JPanel();
        jLabel_chuDe = new JLabel();
        jLabel_nguoiDung = new JLabel();
        jPanel_center = new JPanel();
        jButton_timKiem = new JButton();
        jButton_lamMoi = new JButton();
        jButton_xoa = new JButton();
        jLabel_ngayNhap = new JLabel();
        jDateChooser_ngayNhap = new JDateChooser();
        jDateChooser_ngayNhap.setLocale(new Locale("vi", "VN"));
        jButton_xemChiTiet = new JButton();
        // Table
        String[] cols = {"Mã sản phẩm", "Mã nhà cung cấp", "Số lượng", "Tổng tiền", "Ngày nhập"};
        tableModel = new DefaultTableModel(cols, 0);
        importHangNhap();
        jTable = new JTable(tableModel);
        jScrollPane = new JScrollPane(jTable);
        
        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24));
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("QUẢN LÝ PHIẾU NHẬP HÀNG");

        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14)); 
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());

        GroupLayout jPanel_northLayout = new GroupLayout(jPanel_north);
        jPanel_north.setLayout(jPanel_northLayout);
        jPanel_northLayout.setHorizontalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_northLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173)
                .addComponent(jLabel_nguoiDung, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel_northLayout.setVerticalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_northLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jLabel_nguoiDung))
            .addGroup(jPanel_northLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_chuDe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_timKiem.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_timKiem.setText("Tìm kiếm");
        jButton_timKiem.addActionListener(this);

        jButton_lamMoi.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_lamMoi.setText("Làm mới");
        jButton_lamMoi.addActionListener(this);

        jButton_xoa.setFont(new Font("Times New Roman", 0, 14));
        jButton_xoa.setText("Xoá");
        jButton_xoa.addActionListener(this);

        jLabel_ngayNhap.setFont(new Font("Times New Roman", 1, 14));
        jLabel_ngayNhap.setText("Ngày nhập:");
        
        jButton_xemChiTiet.setFont(new Font("Times New Roman", 0, 14));
        jButton_xemChiTiet.setText("Xem chi tiết");
        jButton_xemChiTiet.addActionListener(this);
        
        //        Thêm icon
        ImageIcon img_btnTimKiem = new ImageIcon("src//img//icon//buttonTimKiem.png");
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        jButton_timKiem.setIcon(img_btnTimKiem);
        
        ImageIcon img_btnLamMoi = new ImageIcon("src//img//icon//buttonLamMoi.png");
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
        jButton_lamMoi.setIcon(img_btnLamMoi);
        
        ImageIcon img_btnCapNhat = new ImageIcon("src//img//icon//buttonXoa.png");
        Image scaled_btnCapNhat = img_btnCapNhat.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnCapNhat = new ImageIcon(scaled_btnCapNhat);
        jButton_xoa.setIcon(img_btnCapNhat);
        
        ImageIcon img_btnXem = new ImageIcon("src//img//icon//eye.png");
        Image scaled = img_btnXem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXem = new ImageIcon(scaled);
        jButton_xemChiTiet.setIcon(img_btnXem);

        GroupLayout jPanel_centerLayout = new GroupLayout(jPanel_center);
        jPanel_center.setLayout(jPanel_centerLayout);
        jPanel_centerLayout.setHorizontalGroup(
            jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel_ngayNhap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser_ngayNhap, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_timKiem)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_lamMoi)
                .addGap(11, 11, 11)
                .addComponent(jButton_xemChiTiet)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_xoa, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel_centerLayout.setVerticalGroup(
            jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_centerLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_lamMoi)
                        .addComponent(jButton_timKiem)
                        .addComponent(jButton_xoa)
                        .addComponent(jButton_xemChiTiet))
                    .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel_ngayNhap)
                        .addComponent(jDateChooser_ngayNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        jTable.setFont(new Font("Times New Roman", 0, 14)); 

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_north, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_center, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 1042, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_north, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_center, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

    }

    // Code sự kiện
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_lamMoi)) {
			lamMoi();
			return;
		}
		if(source.equals(jButton_timKiem)) {
			timKiemPhieuNhapHang();
			return;
		}
		if(source.equals(jButton_xemChiTiet)) {
			xemChiTietPhieuNhapHang();
			return;
		}
		if(source.equals(jButton_xoa)) {
			xoaPhieuNhapHang();
		}
		
	}

    public void importHangNhap() {
    	tableModel.setRowCount(0);
    	ArrayList<HangNhap> hangNhapList = hn_dao.getAllHangNhap();
    	for (HangNhap hn : hangNhapList) {
			tableModel.addRow(hn.toString().split(";"));
		}
    }
    
    public void lamMoi() {
    	jDateChooser_ngayNhap.setDate(null);
    	importHangNhap();
    }
    
    public void timKiemPhieuNhapHang() {
    	java.util.Date ngayNhap = jDateChooser_ngayNhap.getDate(); 
    	if(ngayNhap == null) {
    		JOptionPane.showMessageDialog(this, "Ngày chưa được chọn!");
    		return;
    	}
    	java.sql.Date ngayNhapSQL = new java.sql.Date(ngayNhap.getTime());
    	ArrayList<HangNhap> hangNhapList = hn_dao.timKiemHangNhapTheoNgay(ngayNhapSQL);
    	if(hangNhapList != null) {
    		tableModel.setRowCount(0);
    		for (HangNhap hn : hangNhapList) {
				tableModel.addRow(hn.toString().split(";"));
			}
    	} else {
    		JOptionPane.showMessageDialog(this, "Tìm kiếm thất bại!");
    	}
    }
    
    public void xoaPhieuNhapHang() {
    	int row = jTable.getSelectedRow();
    	if(row < 0) {
    		JOptionPane.showMessageDialog(this, "Phiếu nhập hàng chưa được chọn!");
    		return;
    	}
    	
    	int thongBao = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá không ?", "Xoá", JOptionPane.YES_NO_OPTION);
    	
    	if(thongBao == JOptionPane.YES_OPTION) {
    		String maSP = jTable.getValueAt(row, 0).toString();
    		String maNCC = jTable.getValueAt(row, 1).toString();
    	
	    	boolean kq = hn_dao.xoaHangNhap(maNCC, maSP);
	    	if(kq) {
	    		tableModel.removeRow(row);
	    	} else {
	    		JOptionPane.showMessageDialog(this, "Xoá phiếu nhập hàng thất bại!");
	    	}
    	}
    }
    
    public void xemChiTietPhieuNhapHang() {
    	int row = jTable.getSelectedRow();
    	if(row < 0) {
    		JOptionPane.showMessageDialog(this, "Phiếu nhập hàng chưa được chọn!");
    		return;
    	}
    	String maSP = jTable.getValueAt(row, 0).toString();
    	String maNCC = jTable.getValueAt(row, 1).toString();
    	new ChiTietPhieuNhapHang_GUI(maSP, maNCC).setVisible(true);
    }
}
