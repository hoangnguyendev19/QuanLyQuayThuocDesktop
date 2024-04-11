
package gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dao.DangNhap_DAO;
import entity.NhanVien;

public class DangNhap_GUI extends JFrame implements ActionListener{
	
    private JButton jButton_dangNhap;
    private JButton jButton_quenMatKhau;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_matKhau;
    private JLabel jLabel_tenDangNhap;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPasswordField jPasswordField_matKhau;
    private JTextField jTextField_tenDangNhap;

    public DangNhap_GUI() {
        khoiTao();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void khoiTao() {
        jPanel1 = new JPanel();
        jLabel_chuDe = new JLabel();
        jPanel2 = new JPanel();
        jLabel_tenDangNhap = new JLabel();
        jTextField_tenDangNhap = new JTextField();
        // tendangnhap
        jTextField_tenDangNhap.setText("0367819442");
        jLabel_matKhau = new JLabel();
        jPasswordField_matKhau = new JPasswordField();
        // matkhau
        jPasswordField_matKhau.setText("123456");
        jPanel3 = new JPanel();
        jButton_dangNhap = new JButton();
        jButton_quenMatKhau = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("ĐĂNG NHẬP");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel_chuDe)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_chuDe, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel_tenDangNhap.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_tenDangNhap.setText("Tên đăng nhập");

        jLabel_matKhau.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_matKhau.setText("Mật khẩu");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_tenDangNhap)
                    .addComponent(jLabel_matKhau))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_tenDangNhap, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jPasswordField_matKhau))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_tenDangNhap)
                    .addComponent(jTextField_tenDangNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_matKhau)
                    .addComponent(jPasswordField_matKhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButton_dangNhap.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_dangNhap.setText("Đăng nhập");
        jButton_dangNhap.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_dangNhap.addActionListener(this);

        jButton_quenMatKhau.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_quenMatKhau.setText("Quên mật khẩu ?");
        jButton_quenMatKhau.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_quenMatKhau.addActionListener(this);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton_dangNhap)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_quenMatKhau)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_dangNhap)
                    .addComponent(jButton_quenMatKhau))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
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
            java.util.logging.Logger.getLogger(DangNhap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new DangNhap_GUI().setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_dangNhap)) {
			String tenTaiKhoan = jTextField_tenDangNhap.getText().trim();
			String matKhau = jPasswordField_matKhau.getText().trim();
			
			NhanVien nhanVien = new DangNhap_DAO().dangNhap(tenTaiKhoan, matKhau);
			if(nhanVien != null) {
				this.dispose();
				new ManHinh_GUI(nhanVien).setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không chính xác! Vui lòng nhập lại!");
			}
		}
		
		if(source.equals(jButton_quenMatKhau)) {
			this.dispose();
			new LamMoi_GUI().setVisible(true);
		}
	}
}
