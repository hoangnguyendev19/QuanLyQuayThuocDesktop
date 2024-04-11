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

import dao.NhaCungCap_DAO;
import entity.NhaCungCap;
import entity.NhanVien;

public class NhaCungCap_Panel extends JPanel implements ActionListener {
	
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
    private NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();
    
    public NhaCungCap_Panel(NhanVien nhanVien) {
    	this.nhanVien = nhanVien;
        khoiTao();
    }

    private void khoiTao() {
        jPanel_north = new JPanel();
        jLabel_chuDe = new JLabel();
        jPanel_center = new JPanel();
        jTextField_nhapMa = new JTextField();
        jButton_timKiem = new JButton();
        jButton_lamMoi = new JButton();
        jButton_them = new JButton();
        jButton_sua = new JButton();
        jLabel_nhapMa = new JLabel();
        jLabel_soDienThoai = new JLabel();
        jTextField_soDienThoai = new JTextField();
        jLabel_nguoiDung = new JLabel();
        String[] cols = {"Mã", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"};
        tableModel = new DefaultTableModel(cols, 0);
        importNCC();
        jTable = new JTable(tableModel);
        jScrollPane = new JScrollPane(jTable);

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("QUẢN LÝ NHÀ CUNG CẤP");
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());

        GroupLayout jPanel_northLayout = new GroupLayout(jPanel_north);
        jPanel_north.setLayout(jPanel_northLayout);
        jPanel_northLayout.setHorizontalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_northLayout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        jPanel_northLayout.setVerticalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_northLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_chuDe, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_centerLayout.createSequentialGroup()
                        .addComponent(jLabel_nhapMa, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel_soDienThoai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_soDienThoai, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(jTextField_nhapMa))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_timKiem)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_lamMoi)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_them)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_sua)
                .addGap(84, 84, 84))
        );
        jPanel_centerLayout.setVerticalGroup(
            jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_nhapMa, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_nhapMa)
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

        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14)); 

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_center, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_north, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_nguoiDung)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 1040, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_north, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_nguoiDung))
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
			themNCC();
			return;
		}
		if(source.equals(jButton_lamMoi)) {
			lamMoi();
			return;
		}
		if(source.equals(jButton_sua)) {
			capNhatNCC();
			return;
		}
		if(source.equals(jButton_timKiem)) {
			timKiemNCC();
			return;
		}
		
	}
	
	public void importNCC() {
		tableModel.setRowCount(0);
		ArrayList<NhaCungCap> nccList = ncc_dao.getAllNhaCungCap();
		for (NhaCungCap ncc : nccList) {
			tableModel.addRow(ncc.toString().split(";"));
		}
	}
	
	public void lamMoi() {
		jTextField_nhapMa.setText("");
		jTextField_soDienThoai.setText("");
		importNCC();
	}
	
	public void timKiemNCC() {
		String ma = jTextField_nhapMa.getText().trim();
		String soDienThoai = jTextField_soDienThoai.getText().trim();
		
		if(ma.equals("") && soDienThoai.equals("")) {
			JOptionPane.showMessageDialog(this, "Mã nhà cung cấp hoặc số điện thoại chưa được nhập!");
			return;
		}
		NhaCungCap ncc = null;
		if(ma.length() > 0 && soDienThoai.equals("")) {
			ncc = ncc_dao.timKiemNCCTheoMa(ma);
		} else if(ma.equals("") && soDienThoai.length() > 0) {
			ncc = ncc_dao.timKiemNCCTheoSoDienThoai(soDienThoai);
		} else {
			ncc = ncc_dao.timKiemNCCTheoDieuKien(soDienThoai, ma);
		}
		
		if(ncc != null) {
			tableModel.setRowCount(0);
			tableModel.addRow(ncc.toString().split(";"));
		} else {
			JOptionPane.showMessageDialog(this, "Nhà cung cấp không tồn tại!");
		}
	}
	
	public void themNCC() {
		new ThemNhaCungCap_GUI().setVisible(true);
	}
	
	public void capNhatNCC() {
		int row = jTable.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(this, "Nhà cung cấp chưa được chọn!");
			return;
		}
		String ma = jTable.getValueAt(row, 0).toString();
		new CapNhatNhaCungCap_GUI(ma).setVisible(true);
	}
}
