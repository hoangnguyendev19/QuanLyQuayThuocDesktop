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

import dao.NhanVien_DAO;
import entity.NhanVien;

public class NhanVien_Panel extends JPanel implements ActionListener {

    private JButton jButton_lamMoi;
    private JButton jButton_sua;
    private JButton jButton_them;
    private JButton jButton_timKiem;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_nguoiDung;
    private JLabel jLabel_nhapMa;
    private JLabel jLabel_soDienThoai;
    private JPanel jPanel_center;
    private JPanel jPanel_north;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private DefaultTableModel tableModel;
    private JTextField jTextField_nhapMa;
    private JTextField jTextField_soDienThoai;
    
    private NhanVien nhanVien = new NhanVien();
    private NhanVien_DAO nv_dao = new NhanVien_DAO();
    
    public NhanVien_Panel(NhanVien nhanVien) {
    	this.nhanVien = nhanVien;
        khoiTao();
    }

    private void khoiTao() {
        jPanel_north = new JPanel();
        jLabel_chuDe = new JLabel();
        jLabel_nguoiDung = new JLabel();
        jPanel_center = new JPanel();
        jTextField_nhapMa = new JTextField();
        jButton_timKiem = new JButton();
        jButton_lamMoi = new JButton();
        jButton_them = new JButton();
        jButton_sua = new JButton();
        jLabel_nhapMa = new JLabel();
        jLabel_soDienThoai = new JLabel();
        jTextField_soDienThoai = new JTextField();
        String[] cols = {"Mã", "Họ Tên", "Giới tính", "Ngày sinh", "Email", "Số điện thoại", "Địa chỉ", "Chức vụ", "Tên tài khoản", "Mật khẩu"};
        tableModel = new DefaultTableModel(cols, 0);
        importNhanVien();
        jTable = new JTable(tableModel);
        jScrollPane = new JScrollPane(jTable);

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24));
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14)); 
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());

        GroupLayout jPanel_northLayout = new GroupLayout(jPanel_north);
        jPanel_north.setLayout(jPanel_northLayout);
        jPanel_northLayout.setHorizontalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_northLayout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226)
                .addComponent(jLabel_nguoiDung, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
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

        jTextField_nhapMa.addActionListener(this);

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

        jLabel_nhapMa.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_nhapMa.setText("Nhập mã:");

        jLabel_soDienThoai.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_soDienThoai.setText("Nhập số điện thoại:");
        
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
        
        GroupLayout jPanel_centerLayout = new GroupLayout(jPanel_center);
        jPanel_center.setLayout(jPanel_centerLayout);
        jPanel_centerLayout.setHorizontalGroup(
            jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_centerLayout.createSequentialGroup()
                        .addComponent(jLabel_nhapMa, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
                    .addComponent(jLabel_soDienThoai, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_nhapMa, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(jTextField_soDienThoai))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_timKiem)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_lamMoi)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_them)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_sua)
                .addGap(74, 74, 74))
        );
        jPanel_centerLayout.setVerticalGroup(
            jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nhapMa)
                    .addComponent(jTextField_nhapMa, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_timKiem)
                    .addComponent(jButton_lamMoi)
                    .addComponent(jButton_them)
                    .addComponent(jButton_sua))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_soDienThoai)
                    .addComponent(jTextField_soDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable.setFont(new Font("Times New Roman", 0, 14)); 

        GroupLayout layout = new GroupLayout(this);
       setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_north, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_center, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_north, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_center, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );

    }

    // Code sự kiện
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_them)) {
			themNhanVien();
		}
		if(source.equals(jButton_lamMoi)) {
			lamMoi();
			return;
		}
		if(source.equals(jButton_sua)) {
			capNhatNhanVien();
			return;
		}
		if(source.equals(jButton_timKiem)) {
			timKiemNhanVien();
		}
		
	}
	
	public void importNhanVien() {
		tableModel.setRowCount(0);
		ArrayList<NhanVien> nhanVienList = nv_dao.getAllNhanVien();
		for (NhanVien nv : nhanVienList) {
			tableModel.addRow(nv.toString().split(";"));
		}
	}
	
	public void lamMoi() {
		jTextField_nhapMa.setText("");
		jTextField_soDienThoai.setText("");
		importNhanVien();
	}
	
	public void timKiemNhanVien() {
		String ma = jTextField_nhapMa.getText().trim();
		String soDienThoai = jTextField_soDienThoai.getText().trim();
		if(ma.equals("") && soDienThoai.equals("")) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên hoặc số điện thoại chưa nhập!");
			return;
		}
		
		NhanVien nhanVien = null;
		if(ma.length() > 0 && soDienThoai.equals("")) {
			nhanVien = nv_dao.timKiemNhanVienTheoMa(ma);
		} else if(ma.equals("") && soDienThoai.length() > 0) {
			nhanVien = nv_dao.timKiemNhanVienTheoSDT(soDienThoai);
		} else {
			nhanVien = nv_dao.timKiemNhanVienTheoDieuKien(ma, soDienThoai);
		}
		
		if(nhanVien != null) {
			tableModel.setRowCount(0);
			tableModel.addRow(nhanVien.toString().split(";"));
		} else {
			JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại!");
		}
	}
	
	public void themNhanVien() {
		new ThemNhanVien_GUI().setVisible(true);
	}
	
	public void capNhatNhanVien() {
		int row = jTable.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(this, "Nhân viên chưa được chọn!");
			return;
		}
		String maNV = jTable.getValueAt(row, 0).toString();
		new CapNhatNhanVien_GUI(maNV).setVisible(true);
	}
}
