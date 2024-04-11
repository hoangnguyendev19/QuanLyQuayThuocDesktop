package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.LoaiSanPham_DAO;
import dao.SanPham_DAO;
import entity.LoaiSanPham;
import entity.NhanVien;
import entity.SanPham;


public class SanPham_Panel extends JPanel implements ActionListener{
    private JButton jButton_lamMoi;
    private JButton jButton_sua;
    private JButton jButton_them;
    private JButton jButton_timKiem;
    private JButton jButton_xem;
    private JComboBox<String> jComboBox_loaiSanPham;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_loaiSanPham;
    private JLabel jLabel_nguoiDung;
    private JLabel jLabel_nhapMa;
    private JPanel jPanel_center;
    private JPanel jPanel_north;
    private JScrollPane jScrollPane;
    private DefaultTableModel tableModel;
    private JTable jTable;
    private JTextField jTextField_nhapMa;
    
    private SanPham_DAO sp_dao = new SanPham_DAO();
    private LoaiSanPham_DAO loaiSP_dao = new LoaiSanPham_DAO();
    private ArrayList<SanPham> sanPhamList = new ArrayList<SanPham>();
    private NhanVien nhanVien = new NhanVien();

    public SanPham_Panel(NhanVien nhanVien) {
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
        jComboBox_loaiSanPham = new JComboBox<>();
        
        LoaiSanPham_DAO loaiSP_Dao = new LoaiSanPham_DAO();
        
        
        
        jLabel_nhapMa = new JLabel();
        jLabel_loaiSanPham = new JLabel();
        jButton_xem = new JButton();
        jLabel_nguoiDung = new JLabel();
        // Table
//        String[] cols = {"Mã sản phẩm", "Tên sản phẩm", "Ảnh", "Thành phần", "Cách dùng", "Xuất xứ", "Ngày sản xuất", "Ngày hết hạn", "Đơn giá", "Số lượng tồn", "Loại", "Tình trạng"};
        tableModel = new DefaultTableModel();
        jTable = new JTable();
        jTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                		"Mã sản phẩm", "Tên sản phẩm", "Ảnh", "Thành phần", "Cách dùng", "Xuất xứ", "Ngày sản xuất", "Ngày hết hạn", "Đơn giá", "Số lượng tồn", "Loại", "Tình trạng"
                }
            ));
        tableModel = (DefaultTableModel) jTable.getModel();
        jTable.setModel(tableModel);
        jScrollPane = new JScrollPane(jTable);
        

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("QUẢN LÝ SẢN PHẨM");
        
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());

        GroupLayout jPanel_northLayout = new GroupLayout(jPanel_north);
        jPanel_north.setLayout(jPanel_northLayout);
        jPanel_northLayout.setHorizontalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_northLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );
        jPanel_northLayout.setVerticalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_northLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_chuDe, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        jTextField_nhapMa.setFont(new Font("Times New Roman", 0, 14)); 
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

        jComboBox_loaiSanPham.setFont(new Font("Times New Roman", 0, 14));  
        ArrayList<LoaiSanPham> listLoaiSP = loaiSP_Dao.getAllLoaiSanPham();
        for (LoaiSanPham loaiSanPham : listLoaiSP) {
			jComboBox_loaiSanPham.addItem(loaiSanPham.getTenLoai());
		}
        
        jLabel_nhapMa.setFont(new Font("Times New Roman", 1, 14));  
        jLabel_nhapMa.setText("Nhập mã:");

        jLabel_loaiSanPham.setFont(new Font("Times New Roman", 1, 14));  
        jLabel_loaiSanPham.setText("Loại sản phẩm:");

        jButton_xem.setFont(new Font("Times New Roman", 0, 14));  
        jButton_xem.setText("Xem");
        jButton_xem.addActionListener(this);

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
                    .addComponent(jLabel_loaiSanPham, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_nhapMa)
                    .addComponent(jComboBox_loaiSanPham, 0, 400, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_timKiem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_xem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_sua)
                        .addComponent(jButton_them)
                        .addComponent(jButton_lamMoi)
                        .addComponent(jButton_timKiem))
                    .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_nhapMa, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_nhapMa)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_loaiSanPham)
                    .addComponent(jComboBox_loaiSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_xem))
                .addContainerGap())
        );

        jTable.setFont(new Font("Times New Roman", 0, 14));  

        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14));  
        
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
        
        ImageIcon img_btnXem = new ImageIcon("src//img//icon//eye.png");
        Image scaled = img_btnXem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXem = new ImageIcon(scaled);
        jButton_xem.setIcon(img_btnXem);
        
        
        

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_north, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_nguoiDung, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addComponent(jPanel_center, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 1042, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_north, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel_nguoiDung, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_center, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );
        importSanPham();
        
        refresh();
        
    }

    // Code sự kiện
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_them)) {
			new ThemSanPham_GUI().setVisible(true);
			refresh();
		}
		if(source.equals(jButton_lamMoi)) {
	        jTextField_nhapMa.setText("");
	        refresh();
		}
		if(source.equals(jButton_timKiem)) {
			String id = jTextField_nhapMa.getText();
			String comboLoai = jComboBox_loaiSanPham.getSelectedItem() == null ? "null" : jComboBox_loaiSanPham.getSelectedItem().toString();
			LoaiSanPham lsp = loaiSP_dao.getLoaiSPTheoTenLoai(comboLoai);
			SanPham sp = sp_dao.findOne(id);
	        if (id.isBlank() && !comboLoai.equals("null"))  {
	        	ArrayList<SanPham> listSPTheoLoai = sp_dao.getSPTheoLoaiID(lsp.getLoaiID());
	        	deleteAllRows(tableModel);
	        	for (SanPham sanPham : listSPTheoLoai) {
					tableModel.addRow(sanPham.toString().split(";"));
				}
	        }
	        else if (sp == null && !id.isBlank()){
				 JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại!");
	        }
	        else if (!id.isBlank() && !comboLoai.equals("null")) {
	        	SanPham sp1 = sp_dao.timKiemSPTheoMaVaLoai(id, lsp.getLoaiID(), lsp);
	        	if (sp1 != null) {
	        		deleteAllRows(tableModel);
					tableModel.addRow(sp1.toString().split(";"));
	        	}
	        	else JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại!");
	        }
	        else if (!id.isBlank() && comboLoai.equals("null")) {
	        	deleteAllRows(tableModel);
				tableModel.addRow(sp.toString().split(";"));
	        }
	        
		}
		if(source.equals(jButton_sua)) {
			capNhatSanPham();
			refresh();
		}
		if(source.equals(jButton_xem)) {
			xemSanPham();
		}
	}
	
	public void importSanPham() {
		try {
			sanPhamList = sp_dao.getAllSanPham();
			for (SanPham sanPham : sanPhamList) {
				tableModel.addRow(sanPham.toString().split(";"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void capNhatSanPham() {
		int row = jTable.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(this, "Sản phẩm chưa được chọn!");
			return;
		}
		String sanPhamID = jTable.getValueAt(row, 0).toString();
		String tenSanPham = jTable.getValueAt(row, 1).toString();
		String imgPath = jTable.getValueAt(row, 2).toString();
		String thanhPhan = jTable.getValueAt(row, 3).toString();
		String cachDung = jTable.getValueAt(row, 4).toString();
		String xuatXu = jTable.getValueAt(row, 5).toString();
		Date ngaySanXuat = Date.valueOf(jTable.getValueAt(row, 6).toString());
		Date ngayHetHan = Date.valueOf(jTable.getValueAt(row, 7).toString());
		double donGia = Double.parseDouble(jTable.getValueAt(row, 8).toString());
		int soLuongTon = Integer.parseInt(jTable.getValueAt(row, 9).toString());
		String tenLoai = jTable.getValueAt(row, 10).toString();
		LoaiSanPham loaiSP = new LoaiSanPham();
		loaiSP = loaiSP_dao.getLoaiSPTheoTenLoai(tenLoai);
		String tinhTrang = jTable.getValueAt(row, 11).toString();
		SanPham sanPham = new SanPham(sanPhamID, imgPath, tenSanPham, thanhPhan, cachDung, xuatXu, ngaySanXuat, ngayHetHan, donGia, soLuongTon, loaiSP, tinhTrang);
		new CapNhatSanPham_GUI(sanPham).setVisible(true);
		refresh();
	}
	
	public void xemSanPham() {
		int row = jTable.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(this, "Sản phẩm chưa được chọn!");
			return;
		}
		String sanPhamID = jTable.getValueAt(row, 0).toString();
		String tenSanPham = jTable.getValueAt(row, 1).toString();
		String imgPath = jTable.getValueAt(row, 2).toString();
		String thanhPhan = jTable.getValueAt(row, 3).toString();
		String cachDung = jTable.getValueAt(row, 4).toString();
		String xuatXu = jTable.getValueAt(row, 5).toString();
		Date ngaySanXuat = Date.valueOf(jTable.getValueAt(row, 6).toString());
		Date ngayHetHan = Date.valueOf(jTable.getValueAt(row, 7).toString());
		double donGia = Double.parseDouble(jTable.getValueAt(row, 8).toString());
		int soLuongTon = Integer.parseInt(jTable.getValueAt(row, 9).toString());
		String tenLoai = jTable.getValueAt(row, 10).toString();
		LoaiSanPham loaiSP = new LoaiSanPham();
		loaiSP = loaiSP_dao.getLoaiSPTheoTenLoai(tenLoai);
		String tinhTrang = jTable.getValueAt(row, 11).toString();
		SanPham sanPham = new SanPham(sanPhamID, imgPath, tenSanPham, thanhPhan, cachDung, xuatXu, ngaySanXuat, ngayHetHan, donGia, soLuongTon, loaiSP, tinhTrang);
		new ChiTietSanPham_GUI(sanPham).setVisible(true);
	}
	
	public void refresh() {
		deleteAllRows(tableModel);
        jComboBox_loaiSanPham.setSelectedIndex(-1);
        importSanPham();
    }
	
	public static void deleteAllRows(DefaultTableModel model) {
        while (model.getRowCount() > 0) {
            model.removeRow(0); // Xoá hàng đầu tiên (index 0) cho đến khi không còn hàng nào
        }
    }
	
	
}
