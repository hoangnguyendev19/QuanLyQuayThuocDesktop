package gui;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import dao.KhachHang_DAO;
import entity.KhachHang;
import entity.NhanVien;

public class KhachHang_Panel extends JPanel implements ActionListener{
	
    private JButton jButton7;
    private JButton jButton_lamMoi;
    private JButton jButton_sua;
    private JButton jButton_them;
    private JButton jButton_timKiem;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_nguoiDung;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTable jTable;
    private DefaultTableModel tableModel;
    private JTextField jTextField_ma;
    private JTextField jTextField_soDienThoai;

    private NhanVien nhanVien = new NhanVien();
    private KhachHang_DAO kh_dao = new KhachHang_DAO();
    
    public KhachHang_Panel(NhanVien nhanVien) {
    	this.nhanVien = nhanVien;
        khoiTao();
    }

    private void khoiTao() {
        jPanel3 = new JPanel();
        jLabel_chuDe = new JLabel();
        jLabel_nguoiDung = new JLabel();
        jPanel1 = new JPanel();
        jTextField_ma = new JTextField();
        jButton_timKiem = new JButton();
        jButton_timKiem.addActionListener(this);
        jButton_lamMoi = new JButton();
        jButton_them = new JButton();
        jButton_sua = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField_soDienThoai = new JTextField();
        jButton7 = new JButton();
        // Table
        String[] cols = {"Mã", "Họ tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email", "Địa chỉ"};
        tableModel = new DefaultTableModel(cols, 0);
        importKhachHang();
        jTable = new JTable(tableModel);
        jScrollPane1 = new JScrollPane(jTable);

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("QUẢN LÝ KHÁCH HÀNG");

        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14)); 
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(403, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(jLabel_nguoiDung, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
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

        jButton_timKiem.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_timKiem.setText("Tìm kiếm");
        jButton_timKiem.addActionListener(this);

        jButton_lamMoi.setFont(new Font("Times New Roman", 0, 14));
        jButton_lamMoi.setText("Làm mới");
        jButton_lamMoi.addActionListener(this);

        jButton_them.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_them.setText("Thêm");
        jButton_them.addActionListener(this);

        jButton_sua.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_sua.setText("Sửa");
        jButton_sua.addActionListener(this);

        jLabel1.setFont(new Font("Times New Roman", 1, 14));
        jLabel1.setText("Nhập mã:");

        jLabel2.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel2.setText("Nhập số điện thoại:");
        
        //        Thêm icon
        ImageIcon img_btnTimKiem = new ImageIcon("src//img//icon//buttonTimKiem.png");
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        jButton_timKiem.setIcon(img_btnTimKiem);
        
        ImageIcon img_btnLamMoi = new ImageIcon("src//img//icon//buttonLamMoi.png");
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
        jButton_lamMoi.setIcon(img_btnLamMoi);
        
        ImageIcon img_btnThem = new ImageIcon("src//img//icon//buttonThem.png");
        Image scaled_btnThem = img_btnThem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnThem = new ImageIcon(scaled_btnThem);
        jButton_them.setIcon(img_btnThem);
        
        ImageIcon img_btnCapNhat = new ImageIcon("src//img//icon//buttonCapNhat.png");
        Image scaled_btnCapNhat = img_btnCapNhat.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnCapNhat = new ImageIcon(scaled_btnCapNhat);
        jButton_sua.setIcon(img_btnCapNhat);
        
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jTextField_ma, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_soDienThoai)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_timKiem)
                .addGap(18, 18, 18)
                .addComponent(jButton_lamMoi)
                .addGap(18, 18, 18)
                .addComponent(jButton_them)
                .addGap(18, 18, 18)
                .addComponent(jButton_sua)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_ma, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_timKiem)
                    .addComponent(jButton_lamMoi)
                    .addComponent(jButton_them)
                    .addComponent(jButton_sua))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_soDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton7.setText("jButton7");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

    }

    // Code sự kiện
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_them)) {
			themKhachHang();
			return;
		}
		
		if(source.equals(jButton_sua)) {
			capNhatKhachHang();
			return;
		}
		if(source.equals(jButton_lamMoi)) {
			lamMoi();
			return;
		}
		if(source.equals(jButton_timKiem)) {
			timKiemKhachHang();
		}
	}
	
	public void importKhachHang() {
		tableModel.setRowCount(0);
		ArrayList<KhachHang> khList = kh_dao.getAllKhachHang();
		for (KhachHang kh : khList) {
			tableModel.addRow(kh.toString().split(";"));
		}
	}
	
	public void lamMoi() {
		jTextField_ma.setText("");
		jTextField_soDienThoai.setText("");
		importKhachHang();
	}
	
	public void timKiemKhachHang() {
		String ma = jTextField_ma.getText().trim();
		String sdt = jTextField_soDienThoai.getText().trim();
		
		if(ma.equals("") && sdt.equals("")) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng hoặc số điện thoại chưa được nhập!");
			return;
		}
		
		KhachHang kh = null;
		if(ma.length() > 0 && sdt.equals("")) {
			kh = kh_dao.getKhachHangTheoMa(ma);
		} else if(ma.equals("") && sdt.length() > 0) {
			kh = kh_dao.getKhachHangTheoSDT(sdt);
		} else {
			kh = kh_dao.getKhachHangTheoDieuKien(sdt, ma);
		}
		
		if(kh != null) {
			tableModel.setRowCount(0);
			tableModel.addRow(kh.toString().split(";"));
		} else {
			JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại!");
		}
	}
	
	public void themKhachHang() {
		new ThemKhachHang_GUI().setVisible(true);
	}
	
	public void capNhatKhachHang() {
		int row = jTable.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(this, "Khách hàng chưa được chọn");
			return;
		}
		
		String maKH = jTable.getValueAt(row, 0).toString();
		new CapNhatKhachHang_GUI(maKH).setVisible(true);
	}
}
