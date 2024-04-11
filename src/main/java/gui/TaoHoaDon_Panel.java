package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
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

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.SanPham_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import util.GenerateID;

public class TaoHoaDon_Panel extends JPanel implements ActionListener {
	
    private JButton jButton_lamMoi;
    private JButton jButton_taoHoaDon;
    private JButton jButton_themGioHang;
    private JButton jButton_tim;
    private JButton jButton_timKiem;
    private JButton jButton_xoaGioHang;
    private JButton jButton_tinh;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_nguoiDung;
    private JLabel jLabel_nhapMa;
    private JLabel jLabel_soLuong;
    private JLabel jLabel_tenKhachHang;
    private JLabel jLabel_tienGuiLai;
    private JLabel jLabel_tongTien;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPanel_sanPham;
    private JScrollPane jScrollPanel_gioHang;
    private JTable jTable_gioHang;
    private DefaultTableModel tableModel_gioHang;
    private JTable jTable_sanPham;
    private DefaultTableModel tableModel_sanPham;
    private JTextField jTextField_ma;
    private JTextField jTextField_soDienThoai;
    private JTextField jTextField_soLuong;
    private JTextField jTextField_tienNhan;
    
    private ArrayList<SanPham> sanPhamList;
    private NhanVien nhanVien = new NhanVien();
    private GenerateID generateID = new GenerateID();
    private HoaDon_DAO hd_dao = new HoaDon_DAO();
    private KhachHang_DAO kh_dao = new KhachHang_DAO();
    private SanPham_DAO sp_dao = new SanPham_DAO();
    
    public TaoHoaDon_Panel(NhanVien nhanVien) {
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
        jButton_lamMoi = new JButton();
        jLabel_nhapMa = new JLabel();
        
        jPanel2 = new JPanel();
        jButton_themGioHang = new JButton();
        jTextField_soLuong = new JTextField();
        jLabel_soLuong = new JLabel();
        jButton_xoaGioHang = new JButton();
        jScrollPanel_gioHang = new JScrollPane();
        
        jPanel4 = new JPanel();
        jLabel5 = new JLabel();
        jTextField_soDienThoai = new JTextField();
        jButton_tim = new JButton();
        jLabel6 = new JLabel();
        jLabel_tenKhachHang = new JLabel();
        jLabel8 = new JLabel();
        jButton_tinh = new JButton();
        
        jLabel_tongTien = new JLabel();
        jButton_taoHoaDon = new JButton();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jTextField_tienNhan = new JTextField();
        jLabel_tienGuiLai = new JLabel();
        
        // Table SanPham
		String[] cols = {"Mã sản phẩm", "Tên sản phẩm", "Ảnh", "Thành phần", "Cách dùng", "Xuất xứ", "Ngày sản xuất", "Ngày hết hạn", "Đơn giá", "Số lượng tồn", "Loại", "Tình trạng"};
		tableModel_sanPham = new DefaultTableModel(cols, 0);
		importSanPham();
		jTable_sanPham = new JTable(tableModel_sanPham);
        jTable_sanPham.setFont(new Font("Times New Roman", 0, 14));
        jScrollPanel_sanPham = new JScrollPane(jTable_sanPham);

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("TẠO HOÁ ĐƠN");

        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14)); 
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208)
                .addComponent(jLabel_nguoiDung, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
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

        jTextField_ma.setFont(new Font("Times New Roman", 0, 14)); 
        jTextField_ma.addActionListener(this);

        jButton_timKiem.setFont(new Font("Times New Roman", 0, 14));
        jButton_timKiem.setText("Tìm kiếm");
        jButton_timKiem.addActionListener(this);

        jButton_lamMoi.setFont(new Font("Times New Roman", 0, 14));
        jButton_lamMoi.setText("Làm mới");
        jButton_lamMoi.addActionListener(this);

        jLabel_nhapMa.setFont(new Font("Times New Roman", 1, 14));
        jLabel_nhapMa.setText("Nhập mã:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_nhapMa, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_ma, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_timKiem)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_lamMoi)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_ma, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_nhapMa)
                    .addComponent(jButton_timKiem)
                    .addComponent(jButton_lamMoi))
                .addGap(10, 10, 10))
        );

        jButton_themGioHang.setText("Thêm vào giỏ hàng");
        jButton_themGioHang.addActionListener(this);

        jTextField_soLuong.addActionListener(this);

        jLabel_soLuong.setText("Nhập số lượng");

        jButton_xoaGioHang.setFont(new Font("Times New Roman", 0, 14));
        jButton_xoaGioHang.setText("Xoá khỏi giỏ hàng");
        jButton_xoaGioHang.addActionListener(this);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel_soLuong)
                .addGap(18, 18, 18)
                .addComponent(jTextField_soLuong, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_themGioHang)
                .addGap(18, 18, 18)
                .addComponent(jButton_xoaGioHang, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_soLuong)
                    .addComponent(jTextField_soLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_themGioHang)
                    .addComponent(jButton_xoaGioHang))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        // Table gio hang
        String[] cols_gioHang = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền"};
		tableModel_gioHang = new DefaultTableModel(cols_gioHang, 0);
		jTable_gioHang = new JTable(tableModel_gioHang);
        jTable_gioHang.setFont(new Font("Times New Roman", 0, 14));
		jScrollPanel_gioHang = new JScrollPane(jTable_gioHang);

        jLabel5.setText("Nhập số điện thoại");

        jTextField_soDienThoai.addActionListener(this);

        jButton_tim.setText("Tìm kiếm");
        jButton_tim.addActionListener(this);

        jLabel6.setText("Tên khách hàng");

        jLabel_tenKhachHang.setText("");

        jLabel8.setText("Tổng tiền");

        jLabel_tongTien.setText("0 VND");

        jButton_taoHoaDon.setText("Tạo hoá đơn");
        jButton_taoHoaDon.addActionListener(this);

        jLabel10.setText("Tiền nhận");
        
        jButton_tinh.setText("Tính");
        jButton_tinh.addActionListener(this);

        jLabel11.setText("Tiền gửi lại");

        jLabel_tienGuiLai.setText("0 VND");
        
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
        jButton_themGioHang.setIcon(img_btnThem);
        
        ImageIcon img_btnCapNhat = new ImageIcon("src//img//icon//buttonXoa.png");
        Image scaled_btnCapNhat = img_btnCapNhat.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnCapNhat = new ImageIcon(scaled_btnCapNhat);
        jButton_xoaGioHang.setIcon(img_btnCapNhat);
        
        ImageIcon img_btnXem = new ImageIcon("src//img//icon//buttonTaoDonHang.png");
        Image scaled = img_btnXem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXem = new ImageIcon(scaled);
        jButton_taoHoaDon.setIcon(img_btnXem);
        
        ImageIcon img_btnTinh = new ImageIcon("src//img//icon//phieunhap.png");
        Image scala = img_btnTinh.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTinh = new ImageIcon(scala);
        jButton_taoHoaDon.setIcon(img_btnTinh);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_tenKhachHang, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_soDienThoai, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_tienGuiLai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_tongTien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_tienNhan, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton_tinh)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jButton_tim, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(20, 20, 20))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_taoHoaDon)
                .addGap(156, 156, 156))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_soDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButton_tim))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel_tenKhachHang))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel_tongTien))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jButton_tinh)
                    .addComponent(jTextField_tienNhan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel_tienGuiLai))
                .addGap(32, 32, 32)
                .addComponent(jButton_taoHoaDon)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPanel_sanPham, GroupLayout.PREFERRED_SIZE, 1040, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPanel_gioHang, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanel_sanPham, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPanel_gioHang, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

    }
    
    
    // Code sự kiện
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source.equals(jButton_timKiem)) {
			timKiemSanPham();
			return;
		}
		if(source.equals(jButton_lamMoi)) {
			lamMoi();
			return;
		}
		if(source.equals(jButton_themGioHang)) {
			themVaoGioHang();
			return;
		}
		if(source.equals(jButton_xoaGioHang)) {
			xoaKhoiGioHang();
			return;
		}
		if(source.equals(jButton_tim)) {
			timKiemKhachHang();
			return;
		}
		if(source.equals(jButton_tinh)) {
			tinhTien();
			return;
		}
		if(source.equals(jButton_taoHoaDon)) {
			taoHoaDon();
			return;
		}
	}
	
	public void timKiemSanPham() {
	    String ma = jTextField_ma.getText().trim();
	    if(ma.equals("")) {
	    	JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sản phẩm!");
	    	return;
	    }
	    SanPham sanPham = sp_dao.timKiemSanPhamTheoMa(ma);
	    if (sanPham != null) {
	        tableModel_sanPham.setRowCount(0); 
	        tableModel_sanPham.addRow(sanPham.toString().split(";"));
	    } else {
	        JOptionPane.showMessageDialog(this, "Mã sản phẩm không tồn tại!");
	    }
	}

	
	public void lamMoi() {
		jTextField_ma.setText("");
		jTextField_soLuong.setText("");
		jTable_sanPham.clearSelection();
		tableModel_sanPham.setRowCount(0);
		importSanPham();
		tableModel_gioHang.setRowCount(0);
		
		jTextField_soDienThoai.setText("");
		jLabel_tenKhachHang.setText("");
		jLabel_tongTien.setText("");
		jTextField_tienNhan.setText("");
		jLabel_tienGuiLai.setText("");
	}
	
	public void importSanPham() {
		sanPhamList = new SanPham_DAO().getAllSanPham();
		for (SanPham sanPham : sanPhamList) {
			tableModel_sanPham.addRow(sanPham.toString().split(";"));
		}
	}
	
	public void themVaoGioHang() {
		int row = jTable_sanPham.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm!");
			return;
		}
		if(jTextField_soLuong.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng !");
			return;
		}
		
		boolean flag = false;
		String maSanPham = jTable_sanPham.getValueAt(row, 0).toString();
		int soLuong = Integer.parseInt(jTextField_soLuong.getText().trim());
		if(jTable_gioHang.getRowCount() > 0) {
			for(int i = 0; i <= jTable_gioHang.getRowCount()-1; i++) {
			       String maSP = jTable_gioHang.getValueAt(i, 0).toString();
			       if(maSP.equals(maSanPham)) {
			    	   flag = true;
			    	   int sl = Integer.parseInt(jTable_gioHang.getValueAt(i, 2).toString());
			    	   int giaBan = Integer.parseInt(jTable_gioHang.getValueAt(i, 3).toString());
			    	   jTable_gioHang.setValueAt(sl+soLuong, i, 2);
			    	   jTable_gioHang.setValueAt(giaBan*(sl+soLuong), i, 4);
			    	   break;
			       }
			}
		}
		
		if(!flag) {
			String tenSanPham = jTable_sanPham.getValueAt(row, 1).toString();
			double donGia = Double.parseDouble(jTable_sanPham.getValueAt(row, 8).toString());
			int giaBan = (int) (donGia*1.4);
			int thanhTien = giaBan*soLuong;
			
			String[] data = {maSanPham, tenSanPham, soLuong+"", giaBan+"", thanhTien+""};
			tableModel_gioHang.addRow(data);
			jTextField_soLuong.setText("");
			jTable_sanPham.clearSelection();
		}
		int tongTien=0;
		for(int i = 0; i <= jTable_gioHang.getRowCount()-1; i++) {
		       int thanhTien = Integer.parseInt(jTable_gioHang.getValueAt(i, 4).toString());
		       tongTien+=thanhTien;
		}
		jLabel_tongTien.setText(tongTien+""+" VND");
		
		jTextField_ma.setText("");
		jTextField_soLuong.setText("");
		jTable_sanPham.clearSelection();
		tableModel_sanPham.setRowCount(0);
		importSanPham();
	}
	
	public void xoaKhoiGioHang() {
		int row = jTable_gioHang.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để xoá!");
			return;
		}
		
		tableModel_gioHang.removeRow(row);
	}
	
	public void timKiemKhachHang() {
		String soDienThoai = jTextField_soDienThoai.getText().trim();
		if(soDienThoai.equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại!");
			return;
		}

		KhachHang khachHang = new KhachHang_DAO().getKhachHangTheoSDT(soDienThoai);
		if(!khachHang.toString().split(";")[0].equals("null")) {
			jLabel_tenKhachHang.setText(khachHang.getHoTen());				
		} else {				
			jLabel_tenKhachHang.setText("");
			JOptionPane.showMessageDialog(this, "Số điện thoại không tồn tại!");
		}
	}
	
	public void tinhTien() {
		if(jTextField_tienNhan.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập tiền nhận!");
			return;
		}
		int tienNhan = Integer.parseInt(jTextField_tienNhan.getText().trim());
		int tongTien = Integer.parseInt(jLabel_tongTien.getText().split(" ")[0]);
		if(tienNhan < tongTien) {
			JOptionPane.showMessageDialog(this, "Tiền nhận phải lớn hơn tổng tiền!");
			return;
		}
		int tienGuiLai = tienNhan - tongTien;
		jLabel_tienGuiLai.setText(tienGuiLai+" VND");
	}
	
	public void taoHoaDon() {
		if(jLabel_tenKhachHang.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Khách hàng chưa được chọn!");
			return;
		}
		if(jTable_gioHang.getRowCount() <= 0) {
			JOptionPane.showMessageDialog(this, "Giỏ hàng không có sản phẩm nào!");
			return;
		}
		
		String maHD = generateID.sinhMa("HD");
		KhachHang khachHang = kh_dao.getKhachHangTheoSDT(jTextField_soDienThoai.getText().trim());
		double tongTien = Double.parseDouble(jLabel_tongTien.getText().split(" ")[0]);
		Date ngayLap = Date.valueOf(LocalDate.now());
		
		ArrayList<ChiTietHoaDon> cthdList = new ArrayList<ChiTietHoaDon>();
		for (int i = 0; i <= jTable_gioHang.getRowCount()-1; i++) {
			SanPham sanPham = new SanPham();
			sanPham.setSanPhamID(jTable_gioHang.getValueAt(i, 0).toString());
			int soLuong = Integer.parseInt(jTable_gioHang.getValueAt(i, 2).toString());
			double giaBan = Double.parseDouble(jTable_gioHang.getValueAt(i, 3).toString());
			double thanhTien = Double.parseDouble(jTable_gioHang.getValueAt(i, 4).toString());
			HoaDon hoaDon = new HoaDon();
			hoaDon.setHoaDonID(maHD);
			ChiTietHoaDon cthd = new ChiTietHoaDon(sanPham, hoaDon, soLuong, giaBan, thanhTien);
			
			cthdList.add(cthd);
		}
		
		
		HoaDon hoaDon = new HoaDon(maHD, nhanVien, khachHang, tongTien, ngayLap);
		boolean kq = hd_dao.taoHoaDon(hoaDon, cthdList);
		
		if(kq) {
			double tienGuiLai = Double.parseDouble(jLabel_tienGuiLai.getText().trim().split(" ")[0]);
			double tienNhan = Double.parseDouble(jTextField_tienNhan.getText().trim().split(" ")[0]);
			new ThongTinHoaDon_GUI(maHD, tienGuiLai, tienNhan).setVisible(true);
			lamMoi();
		} else {
			JOptionPane.showMessageDialog(this, "Tạo hoá đơn thất bại!");
		}
	}
}
