package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import dao.ThongKe_DAO;
import entity.NhanVien;
import entity.ThongKeDoanhThu;
import entity.ThongKeNhanVien;
import entity.ThongKeSanPham;

public class ThongKe_Panel extends JPanel implements ActionListener {

    private JButton jButton_xuatFile;
    private JButton jButton_doanhThu;
    private JButton jButton_sanPham;
    private JButton jButton_nhanVien;
    private JComboBox<String> jComboBox_thongKeTheo;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_nguoiDung;
    private JMonthChooser jMonthChooser_theoThang;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel6;
    private JScrollPane jScrollPane2;
    private JTable jTable_bangThongKe;
    private DefaultTableModel tableModel_sanPham;
    private DefaultTableModel tableModel_nhanVien;
    private DefaultTableModel tableModel_doanhThu;
    private JYearChooser jYearChooser_theoNam;

    private NhanVien nhanVien = new NhanVien();
    private ThongKe_DAO tk_dao = new ThongKe_DAO();
    
    public ThongKe_Panel(NhanVien nhanVien) {
    	this.nhanVien = nhanVien;
        khoiTao();
    }

    private void khoiTao() {
        jPanel3 = new JPanel();
        jLabel_chuDe = new JLabel();
        jLabel_nguoiDung = new JLabel();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jMonthChooser_theoThang = new JMonthChooser();
        jMonthChooser_theoThang.setLocale(new Locale("vi", "VN"));
        jMonthChooser_theoThang.setMonth(LocalDate.now().getMonthValue()+1);

        jLabel2 = new JLabel();
        jYearChooser_theoNam = new JYearChooser();
        jYearChooser_theoNam.setYear(LocalDate.now().getYear());
        System.out.println(jYearChooser_theoNam.getYear());
        jButton_xuatFile = new JButton();
        jButton_sanPham = new JButton();
        jLabel5 = new JLabel();
        jComboBox_thongKeTheo = new JComboBox<>();
        jButton_nhanVien = new JButton();
        jButton_doanhThu = new JButton();
        jPanel2 = new JPanel();
        jPanel6 = new JPanel();

        // Table
        String[] cols_sanPham = {"Mã sản phẩm", "Tên sản phẩm", "Tổng số lượng", "Tổng tiền"};
        String[] cols_nhanVien = {"Mã nhân viên", "Tên nhân viên", "Tổng số lượng", "Tổng tiền"};
        String[] cols_doanhThu = {"Ngày lập hoá đơn", "Tổng số lượng", "Tổng tiền"};
        tableModel_sanPham = new DefaultTableModel(cols_sanPham, 0);
        tableModel_nhanVien = new DefaultTableModel(cols_nhanVien, 0);
        tableModel_doanhThu = new DefaultTableModel(cols_doanhThu, 0);
        jTable_bangThongKe = new JTable(tableModel_sanPham);
        jScrollPane2 = new JScrollPane(jTable_bangThongKe);
        
        
        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("THỐNG KÊ");

        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14)); 
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226)
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

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Theo tháng");

        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Theo năm");

        jButton_xuatFile.setText("XUẤT EXCEL");
        jButton_xuatFile.addActionListener(this);

        jButton_sanPham.setText("Thống kê sản phẩm bán chạy nhất");
        jButton_sanPham.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_sanPham.addActionListener(this);

        jLabel5.setText("Thống kê theo");

        jComboBox_thongKeTheo.setModel(new DefaultComboBoxModel<>(new String[] { "Tháng", "Năm" }));
        jComboBox_thongKeTheo.setSelectedItem("Tháng");
        jComboBox_thongKeTheo.addActionListener(this);
        
        jMonthChooser_theoThang.setMonth(LocalDate.now().getMonthValue());
        jYearChooser_theoNam.setYear(LocalDate.now().getYear());
        importSanPham();

        jButton_nhanVien.setText("Thống kê doanh thu của nhân viên bán nhiều nhất ");
        jButton_nhanVien.addActionListener(this);

        jButton_doanhThu.setText("Thống kê tổng doanh thu");
        jButton_doanhThu.addActionListener(this);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_thongKeTheo, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_sanPham, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_nhanVien, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jMonthChooser_theoThang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jYearChooser_theoNam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton_doanhThu, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jButton_xuatFile, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jYearChooser_theoNam, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(jMonthChooser_theoThang, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(jComboBox_thongKeTheo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_sanPham, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_nhanVien)
                            .addComponent(jButton_doanhThu)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton_xuatFile, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 1040, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
            .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

    }

    // Code sự kiện
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_sanPham)) {
			jTable_bangThongKe.setModel(tableModel_sanPham);
			importSanPham();
			return;
		}
		if(source.equals(jButton_nhanVien)) {
			jTable_bangThongKe.setModel(tableModel_nhanVien);
			importNhanVien();
			return;
		}
		if(source.equals(jButton_doanhThu)) {
			jTable_bangThongKe.setModel(tableModel_doanhThu);
			importDoanhThu();
		}
	}
	
	public void importSanPham() {
		ArrayList<ThongKeSanPham> thongKeSPList = null;
		if(jComboBox_thongKeTheo.getSelectedItem().equals("Tháng")) {
			int thang = jMonthChooser_theoThang.getMonth()+1;
			thongKeSPList = tk_dao.getAllSanPhamBanChayNhatTheoThang(thang);
		} else if(jComboBox_thongKeTheo.getSelectedItem().equals("Năm")) {
			int nam = jYearChooser_theoNam.getYear();
			thongKeSPList = tk_dao.getAllSanPhamBanChayNhatTheoNam(nam);
		}
		
		if(thongKeSPList != null) {
			tableModel_sanPham.setRowCount(0);
			for (ThongKeSanPham tksp : thongKeSPList) {
				tableModel_sanPham.addRow(tksp.toString().split(";"));
			}
		}
	}
	
	public void importNhanVien() {
		ArrayList<ThongKeNhanVien> thongKeNVList = null;
		if(jComboBox_thongKeTheo.getSelectedItem().equals("Tháng")) {
			int thang = jMonthChooser_theoThang.getMonth()+1;
			thongKeNVList = tk_dao.getAllDoanhThuNhanVienTheoThang(thang);
		} else if(jComboBox_thongKeTheo.getSelectedItem().equals("Năm")) {
			int nam = jYearChooser_theoNam.getYear();
			thongKeNVList = tk_dao.getAllDoanhThuNhanVienTheoNam(nam);
		}
		
		if(thongKeNVList != null) {
			tableModel_nhanVien.setRowCount(0);
			for (ThongKeNhanVien tknv : thongKeNVList) {
				tableModel_nhanVien.addRow(tknv.toString().split(";"));
			}
		}
	}
	
	public void importDoanhThu() {
		ArrayList<ThongKeDoanhThu> thongKeDTList = null;
		if(jComboBox_thongKeTheo.getSelectedItem().equals("Tháng")) {
			int thang = jMonthChooser_theoThang.getMonth()+1;
			thongKeDTList = tk_dao.getDoanhThuTheoThang(thang);
		} else if(jComboBox_thongKeTheo.getSelectedItem().equals("Năm")) {
			int nam = jYearChooser_theoNam.getYear();
			thongKeDTList = tk_dao.getDoanhThuTheoNam(nam);
		}
		
		if(thongKeDTList != null) {
			tableModel_doanhThu.setRowCount(0);
			for (ThongKeDoanhThu tkdt : thongKeDTList) {
				tableModel_doanhThu.addRow(tkdt.toString().split(";"));
			}
		}
	}
}
