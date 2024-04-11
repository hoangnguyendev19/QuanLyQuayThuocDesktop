package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dao.NhaCungCap_DAO;
import entity.NhaCungCap;
import util.GenerateID;

public class ThemNhaCungCap_GUI extends JFrame implements ActionListener {

    private ButtonGroup buttonGroup1;
    private JButton jButton_huyBo;
    private JButton jButton_them;
    private JFileChooser jFileChooser1;
    private JLabel jLabel11;
    private JLabel jLabel3;
    private JLabel jLabel9;
    private JLabel jLabel_chuDe;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JTextField jTextField_diaChi;
    private JTextField jTextField_soDienThoai;
    private JTextField jTextField_tenNhaCungCap;

    private NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();
    private GenerateID generateID = new GenerateID();
    
    public ThemNhaCungCap_GUI() {
        khoiTao();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void khoiTao() {
        jFileChooser1 = new JFileChooser();
        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel_chuDe = new JLabel();
        jPanel4 = new JPanel();
        jLabel3 = new JLabel();
        jTextField_tenNhaCungCap = new JTextField();
        jLabel9 = new JLabel();
        jTextField_soDienThoai = new JTextField();
        jLabel11 = new JLabel();
        jTextField_diaChi = new JTextField();
        jPanel3 = new JPanel();
        jButton_them = new JButton();
        jButton_them.addActionListener(this);
        jButton_huyBo = new JButton();
        jButton_huyBo.addActionListener(this);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Thêm nhà cung cấp");

        jLabel_chuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_chuDe.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_chuDe.setText("THÔNG TIN NHÀ CUNG CẤP");

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
        jLabel3.setText("Tên nhà cung cấp");

        jLabel9.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel9.setText("Số điện thoại");

        jLabel11.setFont(new Font("Times New Roman", 1, 14)); 
        jLabel11.setText("Địa chỉ");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_soDienThoai, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(jTextField_tenNhaCungCap)
                    .addComponent(jTextField_diaChi))
                .addGap(37, 37, 37))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_tenNhaCungCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTextField_soDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_diaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jButton_them.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_them.setText("Thêm");

        jButton_huyBo.setFont(new Font("Times New Roman", 1, 14)); 
        jButton_huyBo.setText("Huỷ bỏ");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jButton_them, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jButton_huyBo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_them)
                    .addComponent(jButton_huyBo))
                .addContainerGap(17, Short.MAX_VALUE))
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
            .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(ThemNhaCungCap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNhaCungCap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNhaCungCap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNhaCungCap_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new ThemNhaCungCap_GUI().setVisible(true);
    }
    
    // Code
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(jButton_huyBo)) {
			dispose();
		}
		
		if(source.equals(jButton_them)) {
			themNCC();
		}
		
	}
	
	public void themNCC() {
		String nhaCungCapID = generateID.sinhMa("NCC");
		String tenNhaCungCap = jTextField_tenNhaCungCap.getText().trim();
		if(tenNhaCungCap.equals("")) {
			JOptionPane.showMessageDialog(this, "Tên nhà cung cấp chưa được nhập!");
			return;
		}
		String soDienThoai = jTextField_soDienThoai.getText().trim();
		if(soDienThoai.equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại chưa được nhập!");
			return;
		}
		String diaChi = jTextField_diaChi.getText().trim();
		if(diaChi.equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ chưa được nhập!");
			return;
		}
		
		NhaCungCap ncc = new NhaCungCap(nhaCungCapID, tenNhaCungCap, soDienThoai, diaChi);
		
		boolean kq = ncc_dao.themNhaCungCap(ncc);
		if(kq) {
			JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công!");
			jTextField_tenNhaCungCap.setText("");
			jTextField_soDienThoai.setText("");
			jTextField_diaChi.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thất bại!");
		}
		
	}
}
