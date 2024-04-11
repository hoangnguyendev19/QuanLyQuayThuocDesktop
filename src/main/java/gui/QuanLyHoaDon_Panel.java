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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.HoaDon_DAO;
import entity.HoaDon;
import entity.NhanVien;

public class QuanLyHoaDon_Panel extends JPanel implements ActionListener {
	   
    private JButton jButton_lamMoi;
    private JButton jButton_timKiem;
    private JButton jButton_xem;
    private JButton jButton_xoa;
    private JDateChooser jDateChooser_ngayLap;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_ngayLap;
    private JLabel jLabel_nguoiDung;
    private JLabel jLabel_nhapMa;
    private JPanel jPanel_center;
    private JPanel jPanel_north;
    private JScrollPane jScrollPane;
    private JTable jTable;
    private DefaultTableModel tableModel;
    private JTextField jTextField_ma;

    private NhanVien nhanVien = new NhanVien();
    private HoaDon_DAO hd_dao = new HoaDon_DAO();
    
    public QuanLyHoaDon_Panel(NhanVien nhanVien) {
    	this.nhanVien = nhanVien;
        khoiTao();
    }

    private void khoiTao() {
        jPanel_north = new JPanel();
        jLabel_chuDe = new JLabel();
        jLabel_nguoiDung = new JLabel();
        jPanel_center = new JPanel();
        jTextField_ma = new JTextField();
        jButton_timKiem = new JButton();
        jButton_lamMoi = new JButton();
        jButton_xoa = new JButton();
        jLabel_nhapMa = new JLabel();
        jLabel_ngayLap = new JLabel();
        jButton_xem = new JButton();
        jDateChooser_ngayLap = new JDateChooser();
        jDateChooser_ngayLap.setLocale(new Locale("vi", "VN"));
        // Table
        String[] cols = {"Mã hoá đơn", "Mã nhân viên", "Mã khách hàng", "Tổng tiền", "Ngày lập"};
        tableModel = new DefaultTableModel(cols, 0);
        importHoaDon();
        jTable = new JTable(tableModel);
        jScrollPane = new JScrollPane(jTable);

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24));
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("QUẢN LÝ HOÁ ĐƠN");

        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14)); 
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());

        GroupLayout jPanel_northLayout = new GroupLayout(jPanel_north);
        jPanel_north.setLayout(jPanel_northLayout);
        jPanel_northLayout.setHorizontalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_northLayout.createSequentialGroup()
                .addContainerGap(391, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208)
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

        jTextField_ma.setFont(new Font("Times New Roman", 0, 14)); 

        jButton_timKiem.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_timKiem.setText("Tìm kiếm");
        jButton_timKiem.addActionListener(this);

        jButton_lamMoi.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_lamMoi.setText("Làm mới");
        jButton_lamMoi.addActionListener(this);

        jButton_xoa.setFont(new Font("Times New Roman", 0, 14));
        jButton_xoa.setText("Xoá");
        jButton_xoa.addActionListener(this);

        jLabel_nhapMa.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_nhapMa.setText("Nhập mã:");

        jLabel_ngayLap.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_ngayLap.setText("Ngày lập:");

        jButton_xem.setFont(new Font("Times New Roman", 0, 14)); 
        jButton_xem.setText("Xem");
        jButton_xem.addActionListener(this);
        
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
        jButton_xem.setIcon(img_btnXem);

        GroupLayout jPanel_centerLayout = new GroupLayout(jPanel_center);
        jPanel_center.setLayout(jPanel_centerLayout);
        jPanel_centerLayout.setHorizontalGroup(
            jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_centerLayout.createSequentialGroup()
                        .addComponent(jLabel_nhapMa, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addComponent(jLabel_ngayLap, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_ma, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jDateChooser_ngayLap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_timKiem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_xem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_lamMoi)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_xoa)
                .addGap(72, 72, 72))
        );
        jPanel_centerLayout.setVerticalGroup(
            jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_lamMoi)
                        .addComponent(jButton_timKiem)
                        .addComponent(jButton_xoa))
                    .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_ma, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_nhapMa)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_xem)
                    .addGroup(jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel_ngayLap)
                        .addComponent(jDateChooser_ngayLap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    // Code sự kiện
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_lamMoi)) {
			lamMoi();
		}
		if(source.equals(jButton_timKiem)) {
			timKiemHoaDon();
			return;
		}
		if(source.equals(jButton_xem)) {
			xemChiTietHoaDon();
			return;
		}
		if(source.equals(jButton_xoa)) {
			xoaHoaDon();
		}
	}
	
	public void importHoaDon() {
		tableModel.setRowCount(0);
		ArrayList<HoaDon> hoaDonList = hd_dao.getAllHoaDon();
		for (HoaDon hoaDon : hoaDonList) {
			tableModel.addRow(hoaDon.toString().split(";"));
		}
	}
	
	public void timKiemHoaDon() {
	    String ma = jTextField_ma.getText().trim();
	    java.util.Date ngayLapUtil = jDateChooser_ngayLap.getDate();

	    if (ma.equals("") && ngayLapUtil == null) {
	        JOptionPane.showMessageDialog(this, "Mã hoá đơn hoặc ngày lập chưa được nhập!");
	        return;
	    }

	    ArrayList<HoaDon> hdList = new ArrayList<HoaDon>();

	    if (ma.length() > 0 && ngayLapUtil == null) {
	    	hdList = hd_dao.timKiemHoaDonTheoDieuKien(ma, null);
	    } else if (ma.length() <= 0 && ngayLapUtil != null) {
	        java.sql.Date ngayLapSql = new java.sql.Date(ngayLapUtil.getTime());
	        hdList = hd_dao.timKiemHoaDonTheoDieuKien("", ngayLapSql);
	    } else {
	        java.sql.Date ngayLapSql = new java.sql.Date(ngayLapUtil.getTime());
	        hdList = hd_dao.timKiemHoaDonTheoDieuKien(ma, ngayLapSql);
	    }

	    if (hdList != null) {
	        tableModel.setRowCount(0);
	        for (HoaDon hd : hdList) {
	        	tableModel.addRow(hd.toString().split(";"));
			}
	        jTextField_ma.setText("");
	        jDateChooser_ngayLap.setDate(null);
	    }
	}
	
	public void lamMoi() {
		jTextField_ma.setText("");
		jDateChooser_ngayLap.setDate(null);
		importHoaDon();
	}
	
	public void xoaHoaDon() {
		int row = jTable.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(this, "Hoá đơn chưa được chọn!");
			return;
		}
		int thongBao = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá không ?","Xoá", JOptionPane.YES_NO_OPTION);
		
		if(thongBao == JOptionPane.YES_OPTION) {
			String ma = jTable.getValueAt(row, 0).toString();
			boolean kq = hd_dao.xoaHoaDon(ma);
			if(kq) {				
				tableModel.removeRow(row);
			} else {
				JOptionPane.showMessageDialog(this, "Xoá hoá đơn thất bại!");
			}
		}
	}
	
	public void xemChiTietHoaDon() {
		int row = jTable.getSelectedRow();
		if(row < 0) {
			JOptionPane.showMessageDialog(this, "Hoá đơn chưa được chọn!");
			return;
		}
		String ma = jTable.getValueAt(row, 0).toString();
		System.out.println(ma);
		new ChiTietHoaDon_GUI(ma).setVisible(true);
	}
	
}
