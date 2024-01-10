/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import bean.DanhMucBean;
import controller.ChuyenManHinhController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setTitle("Quản lý sinh viên");
        
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setView(jpnTrangChu, jlbTrangChu);
        
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("TrangChu", jpnTrangChu, jlbTrangChu));
        listItem.add(new DanhMucBean("HocVien", jpnSinhVien, jlbSinhVien));
        listItem.add(new DanhMucBean("MonHoc", jpnMonHoc, jlbMonHoc));
        listItem.add(new DanhMucBean("LopTinChi", jpnLopTC, jlbLopTC));
        listItem.add(new DanhMucBean("LopSinhVien", jpnLopSV, jlbLopSV));
        listItem.add(new DanhMucBean("DangKi", jpnDangKi, jlbDangKi));
//        jpnThoat.setVisible(true);
//        jlbThoat.setVisible(true);
        controller.setEvent(listItem);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnMonHoc = new javax.swing.JPanel();
        jlbMonHoc = new javax.swing.JLabel();
        jpnLopTC = new javax.swing.JPanel();
        jlbLopTC = new javax.swing.JLabel();
        jpnLopSV = new javax.swing.JPanel();
        jlbLopSV = new javax.swing.JLabel();
        jpnSinhVien = new javax.swing.JPanel();
        jlbSinhVien = new javax.swing.JLabel();
        jpnDangKi = new javax.swing.JPanel();
        jlbDangKi = new javax.swing.JLabel();
        jpnThoat = new javax.swing.JPanel();
        jlbThoat = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnMenu.setBackground(new java.awt.Color(82, 83, 83));

        jpnTrangChu.setBackground(new java.awt.Color(232, 64, 60));

        jlbTrangChu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jlbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_ung_dung.png"))); // NOI18N
        jlbTrangChu.setText("QUẢN LÝ SINH VIÊN");

        javax.swing.GroupLayout jpnTrangChuLayout = new javax.swing.GroupLayout(jpnTrangChu);
        jpnTrangChu.setLayout(jpnTrangChuLayout);
        jpnTrangChuLayout.setHorizontalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTrangChuLayout.setVerticalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnMonHoc.setBackground(new java.awt.Color(76, 157, 80));

        jlbMonHoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbMonHoc.setForeground(new java.awt.Color(255, 255, 255));
        jlbMonHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_ql_mon_hoc.png"))); // NOI18N
        jlbMonHoc.setText("Quản lý môn học");

        javax.swing.GroupLayout jpnMonHocLayout = new javax.swing.GroupLayout(jpnMonHoc);
        jpnMonHoc.setLayout(jpnMonHocLayout);
        jpnMonHocLayout.setHorizontalGroup(
            jpnMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMonHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnMonHocLayout.setVerticalGroup(
            jpnMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMonHocLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlbMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnLopTC.setBackground(new java.awt.Color(76, 157, 80));

        jlbLopTC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbLopTC.setForeground(new java.awt.Color(255, 255, 255));
        jlbLopTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_lop_tinh_chi.png"))); // NOI18N
        jlbLopTC.setText("Quản lý lớp tín chỉ");

        javax.swing.GroupLayout jpnLopTCLayout = new javax.swing.GroupLayout(jpnLopTC);
        jpnLopTC.setLayout(jpnLopTCLayout);
        jpnLopTCLayout.setHorizontalGroup(
            jpnLopTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLopTCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbLopTC, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnLopTCLayout.setVerticalGroup(
            jpnLopTCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLopTCLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlbLopTC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnLopSV.setBackground(new java.awt.Color(76, 157, 80));

        jlbLopSV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbLopSV.setForeground(new java.awt.Color(255, 255, 255));
        jlbLopSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_ql_lop_hoc.png"))); // NOI18N
        jlbLopSV.setText("Quản lý lớp sinh viên");

        javax.swing.GroupLayout jpnLopSVLayout = new javax.swing.GroupLayout(jpnLopSV);
        jpnLopSV.setLayout(jpnLopSVLayout);
        jpnLopSVLayout.setHorizontalGroup(
            jpnLopSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLopSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbLopSV, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnLopSVLayout.setVerticalGroup(
            jpnLopSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLopSVLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlbLopSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnSinhVien.setBackground(new java.awt.Color(76, 157, 80));

        jlbSinhVien.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbSinhVien.setForeground(new java.awt.Color(255, 255, 255));
        jlbSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_ql_sinh_vien.png"))); // NOI18N
        jlbSinhVien.setText("Quản lý sinh viên");

        javax.swing.GroupLayout jpnSinhVienLayout = new javax.swing.GroupLayout(jpnSinhVien);
        jpnSinhVien.setLayout(jpnSinhVienLayout);
        jpnSinhVienLayout.setHorizontalGroup(
            jpnSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSinhVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnSinhVienLayout.setVerticalGroup(
            jpnSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSinhVienLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlbSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnDangKi.setBackground(new java.awt.Color(76, 157, 80));

        jlbDangKi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbDangKi.setForeground(new java.awt.Color(255, 255, 255));
        jlbDangKi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_dang_ki.png"))); // NOI18N
        jlbDangKi.setText("Quản lý đăng kí môn");

        javax.swing.GroupLayout jpnDangKiLayout = new javax.swing.GroupLayout(jpnDangKi);
        jpnDangKi.setLayout(jpnDangKiLayout);
        jpnDangKiLayout.setHorizontalGroup(
            jpnDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDangKiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDangKiLayout.setVerticalGroup(
            jpnDangKiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDangKiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jlbDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpnThoat.setBackground(new java.awt.Color(255, 153, 51));

        jlbThoat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbThoat.setForeground(new java.awt.Color(255, 255, 255));
        jlbThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_thoat.png"))); // NOI18N
        jlbThoat.setText("Đăng xuất");
        jlbThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbThoatMouseClicked(evt);
            }
        });
        jlbThoat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jlbThoatKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jpnThoatLayout = new javax.swing.GroupLayout(jpnThoat);
        jpnThoat.setLayout(jpnThoatLayout);
        jpnThoatLayout.setHorizontalGroup(
            jpnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jpnThoatLayout.setVerticalGroup(
            jpnThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThoatLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnLopTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnDangKi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnLopSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jpnMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnLopTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnLopSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(jpnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlbThoatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlbThoatKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jlbThoatKeyPressed

    private void jlbThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbThoatMouseClicked
        // TODO add your handling code here:
        this.dispose();
        LoginDiolog login = new LoginDiolog(this, true);
        login.setVisible(true);
    }//GEN-LAST:event_jlbThoatMouseClicked

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbDangKi;
    private javax.swing.JLabel jlbLopSV;
    private javax.swing.JLabel jlbLopTC;
    private javax.swing.JLabel jlbMonHoc;
    private javax.swing.JLabel jlbSinhVien;
    private javax.swing.JLabel jlbThoat;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnDangKi;
    private javax.swing.JPanel jpnLopSV;
    private javax.swing.JPanel jpnLopTC;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnMonHoc;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnSinhVien;
    private javax.swing.JPanel jpnThoat;
    private javax.swing.JPanel jpnTrangChu;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
