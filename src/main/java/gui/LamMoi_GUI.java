package gui;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dao.NhanVien_DAO;
import entity.NhanVien;
import util.MD5Encode;
import util.email;

public class LamMoi_GUI extends JFrame implements ActionListener {
	
    private JButton jButton_lamMoi;
    private JButton jButton_dangNhap;
    private JLabel jLabel_chuDe;
    private JLabel jLabel_email;
    private JLabel jLabel_tenDangNhap;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTextField jTextField_email;
    private JTextField jTextField_tenDangNhap;
    private NhanVien_DAO nv_dao = new NhanVien_DAO();

    public LamMoi_GUI() {
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
        jLabel_email = new JLabel();
        jTextField_email = new JTextField();
        jPanel3 = new JPanel();
        jButton_lamMoi = new JButton();
        jButton_dangNhap = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("LÀM MỚI MẬT KHẨU");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel_chuDe, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel_email.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel_email.setText("Email");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_tenDangNhap)
                    .addComponent(jLabel_email))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_tenDangNhap, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jTextField_email))
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
                    .addComponent(jLabel_email)
                    .addComponent(jTextField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton_lamMoi.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_lamMoi.setText("Làm mới");
        jButton_lamMoi.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_lamMoi.addActionListener(this);

        jButton_dangNhap.setFont(new Font("Times New Roman", 1, 14));
        jButton_dangNhap.setText("Đăng nhập ?");
        jButton_dangNhap.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton_dangNhap.addActionListener(this);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton_lamMoi)
                .addGap(37, 37, 37)
                .addComponent(jButton_dangNhap)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_lamMoi)
                    .addComponent(jButton_dangNhap))
                .addContainerGap(12, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(LamMoi_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LamMoi_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LamMoi_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LamMoi_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         new LamMoi_GUI().setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_dangNhap)) {
			this.dispose();
			new DangNhap_GUI().setVisible(true);
		}
		else if (source.equals(jButton_lamMoi)) {
	            // TODO add your handling code here:
	            try {
					String mail = jTextField_email.getText().trim();
					String tenDN = jTextField_tenDangNhap.getText().trim();
					if (nv_dao.checkNV(mail, tenDN) == false) {
					    JOptionPane.showMessageDialog(null, "Tài khoản và email không trùng khớp");
					} else {
					    double number = Math.random();
					    int interger = (int) (number * 1000000);
					    String text = interger + "";
					    NhanVien nv = new NhanVien(tenDN, text);
					    if (nv_dao.lamMoiMatKhau(nv) == true) {
					        email.sendMess(mail, text);
					        JOptionPane.showMessageDialog(null, "Mậu khẩu mới đã được gửi về email của bạn!");
					    } else {
					        JOptionPane.showMessageDialog(null, "lỗi!");
					    }

					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		}
	}
