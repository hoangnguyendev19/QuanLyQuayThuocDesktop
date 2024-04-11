package gui;

import java.awt.BorderLayout;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import dao.NhanVien_DAO;
import entity.NhanVien;


public class TrangChu_Panel extends JPanel{
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel_nguoiDung;
    private JLabel jLabel_tieuDe;

    private JPanel jPanel;
    private JPanel jPanel_center;
    private JPanel jPanel_left;
    private JPanel jPanel_north;
    private JPanel jPanel_right;
    private NhanVien nhanVien = new NhanVien();

    public TrangChu_Panel(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    	khoiTao();
    }

    private void khoiTao() {
        jPanel_north = new JPanel();
        jLabel_tieuDe = new JLabel();
        jLabel_nguoiDung = new JLabel();
        jPanel_center = new JPanel();
        jPanel_left = new JPanel();
        jLabel3 = new JLabel();
        jLabel1 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jPanel_right = new JPanel();
        jLabel4 = new JLabel();
        

        jLabel_tieuDe.setFont(new Font("Times New Roman", 1, 24)); 
        jLabel_tieuDe.setText("HỆ THỐNG QUẢN LÝ CỬA HÀNG QUẦY THUỐC");
        
        jLabel_nguoiDung.setFont(new Font("Times New Roman", 0, 14));
        jLabel_nguoiDung.setText(nhanVien.getChucVu() + " : "+ nhanVien.getHoTen()+ "-"+nhanVien.getNhanVienID());
        

        GroupLayout jPanel_northLayout = new GroupLayout(jPanel_north);
        jPanel_north.setLayout(jPanel_northLayout);
        jPanel_northLayout.setHorizontalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_northLayout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(jLabel_tieuDe)
                .addGap(103, 103, 103)
                .addComponent(jLabel_nguoiDung)
                .addGap(18, 18, 18))
        );
        jPanel_northLayout.setVerticalGroup(
            jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_northLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel_northLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_nguoiDung, GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel_northLayout.createSequentialGroup()
                        .addComponent(jLabel_tieuDe, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jLabel3.setFont(new Font("Times New Roman", 1, 18));  
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("CÁC THÀNH VIÊN");

        jLabel1.setFont(new Font("Times New Roman", 2, 14));  
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Nguyễn Huy Hoàng (Nhóm Trưởng)");

        jLabel5.setFont(new Font("Times New Roman", 2, 14));  
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Trần Gia Huy");

        jLabel6.setFont(new Font("Times New Roman", 2, 14));  
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Nguyễn Lê Nhật Huy");

        GroupLayout jPanel_leftLayout = new GroupLayout(jPanel_left);
        jPanel_left.setLayout(jPanel_leftLayout);
        jPanel_leftLayout.setHorizontalGroup(
            jPanel_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(jLabel6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_leftLayout.setVerticalGroup(
            jPanel_leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_leftLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel_rightLayout = new GroupLayout(jPanel_right);
        jPanel_right.setLayout(jPanel_rightLayout);
        jPanel_rightLayout.setHorizontalGroup(
            jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
        );
        jPanel_rightLayout.setVerticalGroup(
            jPanel_rightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/img/anh-quay-thuoc.png")));  
        jLabel4.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel4.setIconTextGap(0);

        GroupLayout jPanel_centerLayout = new GroupLayout(jPanel_center);
        jPanel_center.setLayout(jPanel_centerLayout);
        jPanel_centerLayout.setHorizontalGroup(
            jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addComponent(jPanel_left, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_right, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel_centerLayout.setVerticalGroup(
            jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_right, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel_centerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel_left, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        this.setLayout(new BorderLayout());
        this.add(jPanel_north, BorderLayout.NORTH);
        this.add(jPanel_center, BorderLayout.CENTER);
    }

}


