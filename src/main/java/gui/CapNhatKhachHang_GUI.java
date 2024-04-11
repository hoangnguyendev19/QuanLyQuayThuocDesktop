package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.toedter.calendar.JDateChooser;

import dao.KhachHang_DAO;
import entity.KhachHang;

public class CapNhatKhachHang_GUI extends JFrame implements ActionListener {
	
    private JButton jButton_huyBo;
    private JButton jButton_sua;
    private JDateChooser jDateChooser_ngaySinh;
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_maKhachHang;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JRadioButton jRadioButton_nam;
    private JRadioButton jRadioButton_nu;
    private ButtonGroup buttonGroup;
    private JTextField jTextField_diaChi;
    private JTextField jTextField_email;
    private JTextField jTextField_soDienThoai;
    private JTextField jTextField_tenKhachHang;

    private String maKH;
    private KhachHang_DAO kh_dao = new KhachHang_DAO();
    
    public CapNhatKhachHang_GUI(String maKH) {
    	this.maKH = maKH;
        khoiTao();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void khoiTao() {
        jPanel1 = new JPanel();
        jLabel_chuDe = new JLabel();
        jPanel4 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField_tenKhachHang = new JTextField();
        jLabel6 = new JLabel();
        jLabel8 = new JLabel();
        jTextField_email = new JTextField();
        jLabel9 = new JLabel();
        jTextField_soDienThoai = new JTextField();
        jLabel11 = new JLabel();
        jTextField_diaChi = new JTextField();
        jDateChooser_ngaySinh = new com.toedter.calendar.JDateChooser();
        jRadioButton_nam = new JRadioButton();
        jRadioButton_nam.setSelected(true);
        jRadioButton_nu = new JRadioButton();
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton_nam);
        buttonGroup.add(jRadioButton_nu);
        jLabel_maKhachHang = new JLabel();
        jLabel1 = new JLabel();
        jPanel3 = new JPanel();
        jButton_sua = new JButton();
        jButton_sua.addActionListener(this);
        jButton_huyBo = new JButton();
        jButton_huyBo.addActionListener(this);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cập nhật thông tin khách hàng");
        importKhachHang();

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("THÔNG TIN KHÁCH HÀNG");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_chuDe, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
        );

        jPanel4.setAutoscrolls(true);
        jPanel4.setPreferredSize(new Dimension(400, 434));

        jLabel3.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel3.setText("Tên khách hàng");

        jLabel4.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel4.setText("Giới tính");

        jLabel6.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel6.setText("Ngày sinh");

        jLabel8.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel8.setText("Email");

        jLabel9.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel9.setText("Số điện thoại");

        jLabel11.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel11.setText("Địa chỉ");

        jRadioButton_nam.setText("Nam");

        jRadioButton_nu.setText("Nữ");

        jLabel_maKhachHang.setFont(new Font("Times New Roman", 2, 14)); 

        jLabel1.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel1.setText("Mã khách hàng");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jRadioButton_nam, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton_nu, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_diaChi, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_email, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser_ngaySinh, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_soDienThoai, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_tenKhachHang, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_maKhachHang, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_maKhachHang)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_tenKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton_nam)
                    .addComponent(jRadioButton_nu))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser_ngaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_soDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_diaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton_sua.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_sua.setText("Sửa");

        jButton_huyBo.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_huyBo.setText("Huỷ bỏ");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jButton_sua, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
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
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
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
            java.util.logging.Logger.getLogger(CapNhatKhachHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapNhatKhachHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapNhatKhachHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapNhatKhachHang_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
    
    
    // Code 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_huyBo)) {
			dispose();
		}
		
		if(source.equals(jButton_sua)) {
			capNhatKhachHang();
		}
	}
	
	public void importKhachHang() {
		KhachHang kh = kh_dao.getKhachHangTheoMa(maKH);
		if(kh != null) {
			jLabel_maKhachHang.setText(kh.getKhachHangID());
			jTextField_tenKhachHang.setText(kh.getHoTen());
			if(kh.getGioiTinh().equals("Nam")) {
				jRadioButton_nam.setSelected(true);
			} else {
				jRadioButton_nu.setSelected(true);
			}
			jDateChooser_ngaySinh.setDate(kh.getNgaySinh());
			jTextField_email.setText(kh.getEmail());
			jTextField_soDienThoai.setText(kh.getSoDienThoai());
			jTextField_diaChi.setText(kh.getDiaChi());
		}
	}
	
	public void capNhatKhachHang() {
		String tenKH = jTextField_tenKhachHang.getText().trim();
		if(tenKH.equals("")) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được rỗng!");
			return;
		}
		String gioiTinh = "Nam";
		if(jRadioButton_nu.isSelected()) {
			gioiTinh = "Nữ";
		}
		if(jDateChooser_ngaySinh.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Ngày sinh không được rỗng!");
			return;
		}
		Date ngaySinh = new Date(jDateChooser_ngaySinh.getDate().getTime());
		String email = jTextField_email.getText().trim();
		if(email.equals("")) {
			JOptionPane.showMessageDialog(this, "Email không được rỗng!");
			return;
		}
		String sdt = jTextField_soDienThoai.getText().trim();
		if(sdt.equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được rỗng!");
			return;
		}
		String diaChi = jTextField_diaChi.getText().trim();
		if(diaChi.equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được rỗng!");
			return;
		}
		
		KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, sdt, email, diaChi);
		
		boolean kq = kh_dao.capNhatKhachHang(kh);
		if(kq) {
			JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công!");
			importKhachHang();
		} else {
			JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thất bại!");
		}
	}
}
