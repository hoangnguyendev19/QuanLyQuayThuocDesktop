package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.HangNhap_DAO;
import dao.NhaCungCap_DAO;
import dao.SanPham_DAO;
import entity.HangNhap;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.SanPham;

public class PhieuNhapHang_Panel extends JPanel implements ActionListener {

    private JButton jButton_lamMoi;
    private JButton jButton_nhapHang;
    private JButton jButton_timKiemNhaCungCap;
    private JButton jButton_timKiemSanPham;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_maNhaCungCap;
    private JLabel jLabel_maSanPham;
    private JLabel jLabel_nguoiDung;
    private JLabel jLabel_soLuong;
    private JLabel jLabel_tongTien;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable_nhaCungCap;
    private JTable jTable_sanPham;
    private DefaultTableModel tableModel_nhaCungCap;
    private DefaultTableModel tableModel_sanPham;
    private JTextField jTextField_maNhaCungCap;
    private JTextField jTextField_maSanPham;
    private JTextField jTextField_soLuong;
    private JTextField jTextField_tongTien;
    
    private NhanVien nhanVien = new NhanVien();
    private SanPham_DAO sp_dao = new SanPham_DAO();
    private NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();
    private HangNhap_DAO hn_dao = new HangNhap_DAO();
    
    public PhieuNhapHang_Panel(NhanVien nhanVien) {
    	this.nhanVien = nhanVien;
        khoiTao();
    }

    private void khoiTao() {
        jPanel3 = new JPanel();
        jLabel_chuDe = new JLabel();
        jLabel_nguoiDung = new JLabel();
        jPanel1 = new JPanel();
        jTextField_maNhaCungCap = new JTextField();
        jButton_timKiemNhaCungCap = new JButton();
        jLabel_maNhaCungCap = new JLabel();
        // Table
        String[] cols_sp = {"Mã", "Tên", "Ảnh", "Thành phần", "Cách dùng", "Xuất xứ", "Ngày sản xuất", "Ngày hết hạn", "Đơn giá", "Số lượng tồn", "Loại", "Tình trạng"};
        tableModel_sanPham = new DefaultTableModel(cols_sp, 0);
        importSanPham();
        jTable_sanPham = new JTable(tableModel_sanPham);
        jScrollPane1 = new JScrollPane(jTable_sanPham);

        String[] cols_ncc = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"};
        tableModel_nhaCungCap = new DefaultTableModel(cols_ncc, 0);
        importNhaCungCap();
        jTable_nhaCungCap = new JTable(tableModel_nhaCungCap);
        jScrollPane2 = new JScrollPane(jTable_nhaCungCap);
        
        jPanel6 = new JPanel();
        jTextField_maSanPham = new JTextField();
        jButton_timKiemSanPham = new JButton();
        jButton_lamMoi = new JButton();
        jLabel_maSanPham = new JLabel();
        jPanel5 = new JPanel();
        jLabel_soLuong = new JLabel();
        jTextField_soLuong = new JTextField();
        jLabel_tongTien = new JLabel();
        jTextField_tongTien = new JTextField();
        jButton_nhapHang = new JButton();
        
        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("PHIẾU NHẬP HÀNG");

        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14)); 
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(393, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208)
                .addComponent(jLabel_nguoiDung, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jLabel_nguoiDung))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_chuDe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField_maNhaCungCap.setFont(new Font("Times New Roman", 0, 14)); 
        jTextField_maNhaCungCap.addActionListener(this);

        jButton_timKiemNhaCungCap.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_timKiemNhaCungCap.setText("Tìm kiếm");
        jButton_timKiemNhaCungCap.addActionListener(this);

        jLabel_maNhaCungCap.setFont(new Font("Times New Roman", 1, 14));
        jLabel_maNhaCungCap.setText("Nhập mã nhà cung cấp:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_maNhaCungCap, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_maNhaCungCap, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_timKiemNhaCungCap)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_maNhaCungCap, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_maNhaCungCap)
                    .addComponent(jButton_timKiemNhaCungCap))
                .addGap(10, 10, 10))
        );

        jTable_sanPham.setFont(new Font("Times New Roman", 0, 14)); 
        
        if (jTable_sanPham.getColumnModel().getColumnCount() > 0) {
            jTable_sanPham.getColumnModel().getColumn(2).setHeaderValue("Ảnh");
            jTable_sanPham.getColumnModel().getColumn(3).setHeaderValue("Thành phần");
            jTable_sanPham.getColumnModel().getColumn(4).setHeaderValue("Xuất xứ");
            jTable_sanPham.getColumnModel().getColumn(5).setHeaderValue("Ngày SX");
            jTable_sanPham.getColumnModel().getColumn(6).setHeaderValue("Ngày HH");
            jTable_sanPham.getColumnModel().getColumn(7).setHeaderValue("Lô sản xuất");
            jTable_sanPham.getColumnModel().getColumn(9).setHeaderValue("Loại");
            jTable_sanPham.getColumnModel().getColumn(11).setHeaderValue("Tình trạng");
        }

        jTable_nhaCungCap.setFont(new Font("Times New Roman", 0, 14)); 

        jTextField_maSanPham.setFont(new Font("Times New Roman", 0, 14)); 
        jTextField_maSanPham.addActionListener(this);

        jButton_timKiemSanPham.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_timKiemSanPham.setText("Tìm kiếm");
        jButton_timKiemSanPham.addActionListener(this);
        
        jButton_lamMoi.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_lamMoi.setText("Làm mới");
        jButton_lamMoi.addActionListener(this);

        jLabel_maSanPham.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_maSanPham.setText("Nhập mã sản phẩm:");
        
        //        Thêm icon
        ImageIcon img_btnTimKiem = new ImageIcon("src//img//icon//buttonTimKiem.png");
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        jButton_timKiemNhaCungCap.setIcon(img_btnTimKiem);
        
        ImageIcon img_btnLamMoi = new ImageIcon("src//img//icon//buttonLamMoi.png");
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
        jButton_lamMoi.setIcon(img_btnLamMoi);
        
        ImageIcon img_btnXem = new ImageIcon("src//img//icon//buttonNhapHang.png");
        Image scaled = img_btnXem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXem = new ImageIcon(scaled);
        jButton_nhapHang.setIcon(img_btnXem);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_maSanPham, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_maSanPham, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_timKiemSanPham)
                .addGap(18, 18, 18)
                .addComponent(jButton_lamMoi)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_maSanPham, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_maSanPham)
                    .addComponent(jButton_lamMoi)
                    .addComponent(jButton_timKiemSanPham))
                .addGap(10, 10, 10))
        );

        jLabel_soLuong.setText("Nhập số lượng");

        jLabel_tongTien.setText("Nhập tổng tiền");

        jButton_nhapHang.setText("Nhập hàng");
        jButton_nhapHang.addActionListener(this);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_soLuong, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_tongTien, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_tongTien, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jTextField_soLuong))
                .addGap(18, 18, 18)
                .addComponent(jButton_nhapHang, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_soLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_soLuong))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_tongTien)
                            .addComponent(jTextField_tongTien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton_nhapHang, GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
		if(source.equals(jButton_timKiemSanPham)) {
			timKiemSanPham();
			return;
		}
		if(source.equals(jButton_timKiemNhaCungCap) ) {
			timKiemNhaCungCap();
			return;
		}
		if(source.equals(jButton_nhapHang)) {
			nhapHang();
		}
		
	}
	
	public void importSanPham() {
		tableModel_sanPham.setRowCount(0);
		ArrayList<SanPham> sanPhamList = sp_dao.getAllSanPham();
		for (SanPham sp : sanPhamList) {
			tableModel_sanPham.addRow(sp.toString().split(";"));
		}
	}
	
	public void importNhaCungCap() {
		tableModel_nhaCungCap.setRowCount(0);
		ArrayList<NhaCungCap> nccList = ncc_dao.getAllNhaCungCap();
		for (NhaCungCap ncc : nccList) {
			tableModel_nhaCungCap.addRow(ncc.toString().split(";"));
		}
	}
	
	public void timKiemSanPham() {
		String ma = jTextField_maSanPham.getText().trim();
		if(ma.equals("")) {
			JOptionPane.showMessageDialog(this, "Mã sản phẩm chưa được nhập!");
			return;
		}
		SanPham sanPham = sp_dao.timKiemSanPhamTheoMa(ma);
		if(sanPham != null) {
			tableModel_sanPham.setRowCount(0);
			tableModel_sanPham.addRow(sanPham.toString().split(";"));
		} else {
			JOptionPane.showMessageDialog(this, "Mã sản phẩm không tồn tại!");
		}
	}
	
	public void timKiemNhaCungCap() {
		String ma = jTextField_maNhaCungCap.getText().trim();
		if(ma.equals("")) {
			JOptionPane.showMessageDialog(this, "Mã nhà cung cấp chưa được nhập!");
			return;
		}
		NhaCungCap ncc = ncc_dao.timKiemNCCTheoMa(ma);
		if(ncc != null) {
			tableModel_nhaCungCap.setRowCount(0);
			tableModel_nhaCungCap.addRow(ncc.toString().split(";"));
		} else {
			JOptionPane.showMessageDialog(this, "Mã nhà cung cấp không tồn tại!");
		}
	}
	
	public void lamMoi() {
		jTextField_maSanPham.setText("");
		jTextField_maNhaCungCap.setText("");
		jTextField_soLuong.setText("");
		jTextField_tongTien.setText("");
		
		importSanPham();
		importNhaCungCap();
	}
	
	public void nhapHang() {
		int sanPhamSelected = jTable_sanPham.getSelectedRow();
		if(sanPhamSelected < 0) {
			JOptionPane.showMessageDialog(this, "Sản phẩm chưa được chọn!");
			return;
		}
		int nccSelected = jTable_nhaCungCap.getSelectedRow();
		if(nccSelected < 0) {
			JOptionPane.showMessageDialog(this, "Nhà cung cấp chưa được chọn!");
			return;
		}
		
		String soLuong = jTextField_soLuong.getText().trim();
		if(soLuong.equals("")) {
			JOptionPane.showMessageDialog(this, "Số lượng chưa được nhập!");
			return;
		}
		int sl = Integer.parseInt(soLuong);
		if(sl <= 0) {
			JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
			return;
		}
		
		String tongTien = jTextField_tongTien.getText().trim();
		if(tongTien.equals("")) {
			JOptionPane.showMessageDialog(this, "Tổng tiền chưa được nhập!");
			return;
		}
		int tt = Integer.parseInt(tongTien);
		if(tt <= 0) {
			JOptionPane.showMessageDialog(this, "Tổng tiền phải lớn hơn 0!");
			return;
		}
		
		SanPham sanPham = new SanPham();
		sanPham.setSanPhamID(tableModel_sanPham.getValueAt(sanPhamSelected, 0).toString());
		NhaCungCap nhaCungCap = new NhaCungCap();
		nhaCungCap.setNhaCungCapID(tableModel_nhaCungCap.getValueAt(nccSelected, 0).toString());
		Date ngayLap = Date.valueOf(LocalDate.now());
		HangNhap hangNhap = new HangNhap(sanPham, nhaCungCap, sl, tt, ngayLap);
		
		boolean kq = hn_dao.nhapHang(hangNhap);
		if(kq) {
			JOptionPane.showMessageDialog(this, "Nhập hàng thành công!");
			lamMoi();
		} else {
			JOptionPane.showMessageDialog(this, "Nhập hàng thất bại!");
		}
	}
}
