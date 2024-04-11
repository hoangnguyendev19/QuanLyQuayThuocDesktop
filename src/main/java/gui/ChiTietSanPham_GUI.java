package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import entity.SanPham;

public class ChiTietSanPham_GUI extends JFrame implements ActionListener {
	private static String filePrefix = "src//img//";
	private JFileChooser jFileChooser1;
    private JButton jButton_thoat;
    private JLabel jLabelText_donGia;
    private JLabel jLabelText_cachDung;
    private JLabel jLabelText_loai;
    private JLabel jLabelText_maSanPham;
    private JLabel jLabelText_ngayHetHan;
    private JLabel jLabelText_ngaySanXuat;
    private JLabel jLabelText_soLuongTon;
    private JLabel jLabelText_tenSanPham;
    private JLabel jLabelText_thanhPhan;
    private JLabel jLabelText_tinhTrang;
    private JLabel jLabelText_xuatXu;
    private JLabel jLabel_picture;
    private JLabel jLabel_anh;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_donGia;
    private JLabel jLabel_cachDung;
    private JLabel jLabel_loai;
    private JLabel jLabel_maSanPham;
    private JLabel jLabel_ngayHetHan;
    private JLabel jLabel_ngaySanXuat;
    private JLabel jLabel_soLuongTon;
    private JLabel jLabel_tenSanPham;
    private JLabel jLabel_thanhPhan;
    private JLabel jLabel_tinhTrang;
    private JLabel jLabel_xuatXu;
    private JPanel jPanel_anh;
    private JPanel jPanel_left;
    private JPanel jPanel_north;
    private JPanel jPanel_right;
    private JPanel jPanel_south;
    private JSplitPane jSplitPane;
    private JFileChooser jFileChooser;
    private static SanPham sp = new SanPham();

    public ChiTietSanPham_GUI(SanPham sp) {
    	this.sp = sp;
        khoiTao();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
   
    private void khoiTao() {
    	jFileChooser1 = new JFileChooser("src//img");
        jPanel_north = new JPanel();
        jLabel_chuDe = new JLabel();
        jSplitPane = new JSplitPane();
        jPanel_left = new JPanel();
        jPanel_anh = new JPanel();
        jLabel_picture = new JLabel();
        jPanel_right = new JPanel();
        jLabel_maSanPham = new JLabel();
        jLabel_tenSanPham = new JLabel();
        jLabel_thanhPhan = new JLabel();
        jLabel_xuatXu = new JLabel();
        jLabel_ngaySanXuat = new JLabel();
        jLabel_ngayHetHan = new JLabel();
        jLabel_cachDung = new JLabel();
        jLabel_donGia = new JLabel();
        jLabel_loai = new JLabel();
        jLabel_soLuongTon = new JLabel();
        jLabel_tinhTrang = new JLabel();
        jLabelText_maSanPham = new JLabel();
        jLabelText_tenSanPham = new JLabel();
        jLabelText_thanhPhan = new JLabel();
        jLabelText_xuatXu = new JLabel();
        jLabelText_ngaySanXuat = new JLabel();
        jLabelText_ngayHetHan = new JLabel();
        jLabelText_cachDung = new JLabel();
        jLabelText_donGia = new JLabel();
        jLabelText_loai = new JLabel();
        jLabelText_soLuongTon = new JLabel();
        jLabelText_tinhTrang = new JLabel();
        jPanel_south = new JPanel();
        jButton_thoat = new JButton();
        jLabel_anh = new JLabel();
        jLabel_anh.setPreferredSize(new Dimension(200, 200));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Thông tin chi tiết sản phẩm");

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("THÔNG TIN SẢN PHẨM");

        GroupLayout jPanel_northLayout = new GroupLayout(jPanel_north);
        jPanel_north.setLayout(jPanel_northLayout);
        jPanel_northLayout.setHorizontalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_northLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        jPanel_northLayout.setVerticalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_northLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane.setDividerSize(0);
        jSplitPane.setResizeWeight(0.5);

        jPanel_anh.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jPanel_anh.setPreferredSize(new Dimension(215, 200));

        GroupLayout jPanel_anhLayout = new GroupLayout(jPanel_anh);
        jPanel_anh.setLayout(jPanel_anhLayout);
        jPanel_anhLayout.setHorizontalGroup(
            jPanel_anhLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        jPanel_anhLayout.setVerticalGroup(
            jPanel_anhLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        jLabel_picture.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_picture.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_picture.setText("Ảnh");

        GroupLayout jPanel_leftLayout = new GroupLayout(jPanel_left);
        jPanel_left.setLayout(jPanel_leftLayout);
        jPanel_leftLayout.setHorizontalGroup(
            jPanel_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_leftLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel_anh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_leftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_picture, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        jPanel_leftLayout.setVerticalGroup(
            jPanel_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_leftLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel_anh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel_picture, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(jPanel_left);

        jLabel_maSanPham.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_maSanPham.setText("Mã sản phẩm");

        jLabel_tenSanPham.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_tenSanPham.setText("Tên sản phẩm");

        jLabel_thanhPhan.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_thanhPhan.setText("Thành phần");

        jLabel_xuatXu.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_xuatXu.setText("Xuất xứ");

        jLabel_ngaySanXuat.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_ngaySanXuat.setText("Ngày sản xuất");

        jLabel_ngayHetHan.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_ngayHetHan.setText("Ngày hết hạn");

        jLabel_cachDung.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_cachDung.setText("Cách dùng");

        jLabel_donGia.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_donGia.setText("Đơn giá");

        jLabel_loai.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_loai.setText("Loại");

        jLabel_soLuongTon.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_soLuongTon.setText("Số lượng tồn");

        jLabel_tinhTrang.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_tinhTrang.setText("Tình trạng");

        jLabelText_maSanPham.setFont(new Font("Times New Roman", 2, 14)); 
        jLabelText_maSanPham.setText(sp.getSanPhamID());

        jLabelText_tenSanPham.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_tenSanPham.setText(sp.getTenSanPham());

        jLabelText_thanhPhan.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_thanhPhan.setText(sp.getThanhPhan());

        jLabelText_xuatXu.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_xuatXu.setText(sp.getXuatXu());

        jLabelText_ngaySanXuat.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_ngaySanXuat.setText(sp.getNgaySanXuat().toString());

        jLabelText_ngayHetHan.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_ngayHetHan.setText(sp.getNgayHetHan().toString());

        jLabelText_cachDung.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_cachDung.setText(sp.getCachDung());
        jLabelText_cachDung.setMaximumSize(new Dimension(300, 20));

        jLabelText_donGia.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_donGia.setText(sp.getDonGia()+"");

        jLabelText_loai.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_loai.setText(sp.getLoaiSanPham().getTenLoai());

        jLabelText_soLuongTon.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_soLuongTon.setText(sp.getSoLuongTon()+"");

        jLabelText_tinhTrang.setFont(new Font("Times New Roman", 0, 14)); 
        jLabelText_tinhTrang.setText(sp.getTinhTrang());
        
        jLabel_anh.setIcon(ResizeImageIcon("src//img//labelAnh.png"));
        jPanel_anh.setPreferredSize(new Dimension(200, 200));
        jPanel_anh.setLayout(new BorderLayout());
        jPanel_anh.add(jLabel_anh, BorderLayout.CENTER);
        
        jLabel_anh.setIcon(ResizeImageIcon(sp.getImgPath()));

        ImageIcon imageIcon;
        if (sp.getImgPath() != null) {
            imageIcon = new ImageIcon(new ImageIcon(sp.getImgPath()).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        } else {
            ImageIcon anhMacDinh = new ImageIcon("src//img//labelAnh.png");
            imageIcon = new ImageIcon(anhMacDinh.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        }
        jLabel_anh.setIcon(imageIcon);
        
        jPanel_anh.setLayout(new BorderLayout());
        jPanel_anh.add(jLabel_anh, BorderLayout.CENTER);
        
        GroupLayout jPanel_rightLayout = new GroupLayout(jPanel_right);
        jPanel_right.setLayout(jPanel_rightLayout);
        jPanel_rightLayout.setHorizontalGroup(
            jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_rightLayout.createSequentialGroup()
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel_tinhTrang, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_soLuongTon, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_loai, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_donGia, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_cachDung, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_ngayHetHan, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_ngaySanXuat, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel_thanhPhan, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_tenSanPham, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_maSanPham, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel_xuatXu, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelText_maSanPham, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelText_tenSanPham, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelText_thanhPhan, GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jLabelText_xuatXu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelText_ngaySanXuat, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(jLabelText_ngayHetHan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelText_cachDung, GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jLabelText_donGia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelText_loai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelText_soLuongTon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelText_tinhTrang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel_rightLayout.setVerticalGroup(
            jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_rightLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_maSanPham)
                    .addComponent(jLabelText_maSanPham))
                .addGap(16, 16, 16)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_tenSanPham, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelText_tenSanPham))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_thanhPhan, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelText_thanhPhan))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_xuatXu)
                    .addComponent(jLabelText_xuatXu))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ngaySanXuat)
                    .addComponent(jLabelText_ngaySanXuat))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ngayHetHan)
                    .addComponent(jLabelText_ngayHetHan))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_cachDung)
                    .addComponent(jLabelText_cachDung))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_donGia)
                    .addComponent(jLabelText_donGia))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_loai)
                    .addComponent(jLabelText_loai))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_soLuongTon)
                    .addComponent(jLabelText_soLuongTon))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_tinhTrang)
                    .addComponent(jLabelText_tinhTrang))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jSplitPane.setRightComponent(jPanel_right);

        jButton_thoat.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_thoat.setText("Thoát");
        jButton_thoat.addActionListener(this);

        GroupLayout jPanel_southLayout = new GroupLayout(jPanel_south);
        jPanel_south.setLayout(jPanel_southLayout);
        jPanel_southLayout.setHorizontalGroup(
            jPanel_southLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_southLayout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jButton_thoat, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_southLayout.setVerticalGroup(
            jPanel_southLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_southLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton_thoat)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_north, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_south, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_north, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSplitPane, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_south, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(ChiTietSanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    
    // Code sự kiện
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_thoat)) {
			dispose();
		}
		
	}
	                                      
    private ImageIcon ResizeImageIcon(String ImagePath) {
        ImageIcon myIcon = new ImageIcon(ImagePath);
        Image img = myIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        return image;
    }
}
