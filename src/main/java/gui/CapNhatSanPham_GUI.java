package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.toedter.calendar.JDateChooser;

import dao.LoaiSanPham_DAO;
import dao.SanPham_DAO;
import entity.LoaiSanPham;
import entity.SanPham;

public class CapNhatSanPham_GUI extends JFrame implements ActionListener {
	private static String filePrefix = "src//img//";
    private JButton jButton_chonAnh;
    private JButton jButton_huyBo;
    private JButton jButton_sua;
    private JComboBox<String> jComboBox_loai;
    private JComboBox<String> jComboBox_tinhTrang;
    private JDateChooser jDateChooser_ngayHH;
    private JDateChooser jDateChooser_ngaySX;
    private JFileChooser jFileChooser1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel3;
    private JLabel jLabel_anh;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_maSanPham;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel_anh;
    private JSplitPane jSplitPane2;
    private JTextField jTextField_donGia;
    private JTextField jTextField_cachDung;
    private JTextField jTextField_soLuongTon;
    private JTextField jTextField_tenSanPham;
    private JTextField jTextField_thanhPhan;
    private JTextField jTextField_xuatXu;
    private SanPham sanPham = new SanPham();
    
    private LoaiSanPham_DAO loaisp_dao = new LoaiSanPham_DAO();
    private SanPham_DAO sp_dao = new SanPham_DAO();

    public CapNhatSanPham_GUI(SanPham sanPham) {
    	this.sanPham = sanPham;
        khoiTao();
        pack();
        setSize(800, 650);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void khoiTao() {
    	jFileChooser1 = new JFileChooser("src//img");
        jPanel1 = new JPanel();
        jLabel_chuDe = new JLabel();
        jSplitPane2 = new JSplitPane();
        jPanel2 = new JPanel();
        jButton_chonAnh = new JButton();
        jButton_chonAnh.addActionListener(this);
        jPanel_anh = new JPanel();
        jPanel4 = new JPanel();
        jLabel3 = new JLabel();
        jTextField_thanhPhan = new JTextField();
        jLabel4 = new JLabel();
        jTextField_tenSanPham = new JTextField();
        jLabel5 = new JLabel();
        jTextField_xuatXu = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jTextField_cachDung = new JTextField();
        jLabel9 = new JLabel();
        jTextField_donGia = new JTextField();
        jLabel10 = new JLabel();
        jComboBox_loai = new JComboBox<>();
        jLabel11 = new JLabel();
        jTextField_soLuongTon = new JTextField();
        jLabel12 = new JLabel();
        jComboBox_tinhTrang = new JComboBox<>();
        jDateChooser_ngaySX = new JDateChooser();
        jDateChooser_ngayHH = new JDateChooser();
        jDateChooser_ngayHH.setLocale(new Locale("vi", "VN"));
        jDateChooser_ngaySX.setLocale(new Locale("vi", "VN"));
        jLabel1 = new JLabel();
        jLabel_maSanPham = new JLabel();
        jPanel3 = new JPanel();
        jButton_sua = new JButton();
        jButton_sua.addActionListener(this);
        jButton_huyBo = new JButton();
        jButton_huyBo.addActionListener(this);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cập nhật thông tin sản phẩm");
        importSanPham();

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("THÔNG TIN SẢN PHẨM");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel_chuDe, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_chuDe, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
        );

        jSplitPane2.setDividerSize(0);
        jSplitPane2.setResizeWeight(0.5);

        jButton_chonAnh.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_chonAnh.setText("Chọn ảnh");

        jPanel_anh.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        GroupLayout jPanel_anhLayout = new GroupLayout(jPanel_anh);
        jPanel_anh.setLayout(jPanel_anhLayout);
        jPanel_anhLayout.setHorizontalGroup(
            jPanel_anhLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        jPanel_anhLayout.setVerticalGroup(
            jPanel_anhLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel_anh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton_chonAnh)))
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel_anh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton_chonAnh)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel2);
        
        jLabel_anh = new JLabel();
        jLabel_anh.setPreferredSize(new Dimension(200, 200));

        jLabel3.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel3.setText("Tên sản phẩm");

        jLabel4.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel4.setText("Thành phần");

        jLabel5.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel5.setText("Xuất xứ");

        jLabel6.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel6.setText("Ngày sản xuất");

        jLabel7.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel7.setText("Ngày hết hạn");

        jLabel8.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel8.setText("Cách dùng");

        jLabel9.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel9.setText("Đơn giá");

        jLabel10.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel10.setText("Loại");
        
        // Loai
        DefaultComboBoxModel<String> comboboxModel = new DefaultComboBoxModel<>();
        ArrayList<LoaiSanPham> loaiSPList = loaisp_dao.getAllLoaiSanPham();
        for (LoaiSanPham loai : loaiSPList) {
        	comboboxModel.addElement(loai.getTenLoai());
		}
        jComboBox_loai.setModel(comboboxModel);
        jComboBox_loai.setSelectedItem(sanPham.getLoaiSanPham().getTenLoai());

        jLabel11.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel11.setText("Số lượng tồn");

        jLabel12.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel12.setText("Tình trạng");

        jComboBox_tinhTrang.setModel(new DefaultComboBoxModel<>(new String[] { "Đang bán", "Ngừng bán" }));
        jComboBox_tinhTrang.setSelectedItem(sanPham.getTinhTrang());
        
        jLabel_anh.setIcon(ResizeImageIcon(sanPham.getImgPath()));
        jPanel_anh.setPreferredSize(new Dimension(200, 200));
        jPanel_anh.setLayout(new BorderLayout());
        jPanel_anh.add(jLabel_anh, BorderLayout.CENTER);
        
        jLabel1.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel1.setText("Mã sản phẩm");

        jLabel_maSanPham.setFont(new Font("Times New Roman", 2, 14)); 

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_cachDung, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_thanhPhan, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_donGia, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox_loai, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser_ngayHH, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser_ngaySX, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_xuatXu, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_soLuongTon, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_tinhTrang, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_tenSanPham, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(jLabel_maSanPham, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_maSanPham))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_tenSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_thanhPhan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_xuatXu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser_ngaySX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser_ngayHH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_cachDung, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_donGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox_loai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_soLuongTon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox_tinhTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jSplitPane2.setRightComponent(jPanel4);
        jSplitPane2.getLeftComponent().setMinimumSize(new Dimension(300, 0));

        jButton_sua.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_sua.setText("Sửa");

        jButton_huyBo.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_huyBo.setText("Huỷ bỏ");
        
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jButton_sua, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jButton_huyBo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_sua)
                    .addComponent(jButton_huyBo))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jSplitPane2, GroupLayout.PREFERRED_SIZE, 756, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jSplitPane2, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
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
            java.util.logging.Logger.getLogger(CapNhatSanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapNhatSanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapNhatSanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapNhatSanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_huyBo)) {
			dispose();
		}
		
		if(source.equals(jButton_chonAnh)) {
			btn_ChonAnhActionPerformed();
		}
		
		if(source.equals(jButton_sua)) {
			try {
				if (checkInput()) {
					SanPham sp = new SanPham();
					String loaiSP = jComboBox_loai.getSelectedItem().toString();
					sp = sp_dao.findOne(jLabel_maSanPham.getText());
					sp.setLoaiSanPham(sp_dao.getLoaiSanPham(loaiSP));
					sp.setCachDung(jTextField_cachDung.getText());
					sp.setDonGia(Double.parseDouble(jTextField_donGia.getText()));
					if (jFileChooser1.getSelectedFile() != null) {
						sp.setImgPath(filePrefix+jFileChooser1.getSelectedFile().getName());
					}
					java.sql.Date ngaySX = new java.sql.Date(jDateChooser_ngaySX.getDate().getTime());
			        java.sql.Date ngayHH = new java.sql.Date(jDateChooser_ngayHH.getDate().getTime());
					sp.setNgayHetHan(ngayHH);
					sp.setNgaySanXuat(ngaySX);
					sp.setSoLuongTon(Integer.valueOf(jTextField_soLuongTon.getText()));
					sp.setXuatXu(jTextField_xuatXu.getText());
					sp.setTinhTrang(jComboBox_tinhTrang.getSelectedItem().toString());
					sp.setTenSanPham(jTextField_tenSanPham.getText());
					sp.setThanhPhan(jTextField_thanhPhan.getText());
					int n = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa thông tin sản phẩm này?");
					if (n == JOptionPane.YES_OPTION) {
						if (sp_dao.update(sp)) {
							JOptionPane.showMessageDialog(this, "Cập nhật thông tin sản phẩm thành công!");
							dispose();
						}
					}
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void importSanPham() {
		jLabel_maSanPham.setText(sanPham.getSanPhamID());
		jTextField_tenSanPham.setText(sanPham.getTenSanPham());
		jTextField_thanhPhan.setText(sanPham.getThanhPhan());
		jTextField_cachDung.setText(sanPham.getCachDung());
		jTextField_xuatXu.setText(sanPham.getXuatXu());
		jTextField_donGia.setText(sanPham.getDonGia()+"");
		jTextField_soLuongTon.setText(sanPham.getSoLuongTon()+"");
		
		jDateChooser_ngaySX.setDate(sanPham.getNgaySanXuat());
		jDateChooser_ngayHH.setDate(sanPham.getNgayHetHan());
		jComboBox_loai.setName(sanPham.getLoaiSanPham().getTenLoai());
	}
	
	private void btn_ChonAnhActionPerformed() {                                            
        int kq = jFileChooser1.showOpenDialog(null);
        File selectedFile = null;
        if (kq == JFileChooser.APPROVE_OPTION) {
            if (jFileChooser1.getSelectedFile() != null) {
            	selectedFile = jFileChooser1.getSelectedFile();
            }
            String fileChose = filePrefix + selectedFile.getName();
            jLabel_anh.setIcon(ResizeImageIcon(fileChose));
        } else if (kq == JFileChooser.CANCEL_OPTION) {

        } else {
            JOptionPane.showMessageDialog(null, "Lỗi chọn ảnh");
        }
    }                                                                   
    private ImageIcon ResizeImageIcon(String ImagePath) {
        ImageIcon myIcon = new ImageIcon(ImagePath);
        Image img = myIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        return image;
    }
    
    public boolean checkInput() {
		try {
			String tenSP = jTextField_tenSanPham.getText();
			String cachDung = jTextField_cachDung.getText();
			String donGia = jTextField_donGia.getText();
			String slt = jTextField_soLuongTon.getText();
			String thanhPhan = jTextField_thanhPhan.getText();
			String xuatXu = jTextField_xuatXu.getText();
			Date date1 = (Date) jDateChooser_ngayHH.getDate();
			Date date2 = (Date) jDateChooser_ngaySX.getDate();
			if (tenSP.isBlank() || cachDung.isBlank() || donGia.isBlank() || slt.isBlank() || thanhPhan.isBlank() || xuatXu.isBlank()) {
				JOptionPane.showMessageDialog(this, "Tất cả thông tin không được rỗng");
				return false;
			}
			else if (date1 == null || date2 == null) {
				JOptionPane.showMessageDialog(this, "Phải chọn ngày sản xuất và ngày hết hạn");
				return false;
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
