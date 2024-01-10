/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import dao.DangKiMonDAO;
import dao.LopTinChiDAO;
import dao.MonHocDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DangKiMon;
import model.LopTinChi;
import model.MonHoc;
/**
 *
 * @author acer
 */
public class LopTinChiJPanel extends javax.swing.JPanel {
    private int demG;
    JPanel panel;
    DefaultTableModel tableModel;
    LopTinChi x;
    private boolean check = false;  // kiem tra de cho xem diem
    private static int pos = 0;
//    private static int check = 0;
    List<LopTinChi> list = new ArrayList<>();
    /**
     * Creates new form LopTinChiJPanel
     */
    public LopTinChiJPanel() {
        initComponents();
        tableModel = (DefaultTableModel) tblLopTinChi.getModel();
        showQLLTC();
        btnXemDiem.setEnabled(check);
    }
    
     private void showQLLTC() {
        list = LopTinChiDAO.selectAll();//            Logger.getLogger(QLLTCJFrame.class.getName()).log(Level.SEVERE, null, ex);
        tableModel.setRowCount(0);
        for (LopTinChi x : list) {
            tableModel.addRow(new Object[]{x.getMaLopTC(), x.getMh().getMaMon(), x.getNienKhoa(), x.getHocKy(), x.getNhom(), x.getSlsvMin(), x.getSlsvMax()});
        }
    }

    public void View() {
        x = list.get(pos);
        this.txtnienkhoa.setText(x.getNienKhoa());
        this.txtmaMonHoc.setText(x.getMh().getMaMon());
        this.txthocky.setText("" + x.getHocKy());
        this.txtNhom.setText("" + x.getNhom());
        this.txtMin.setText("" + x.getSlsvMin());
        this.txtMax.setText("" + x.getSlsvMax());
        OnOff(false, true);
    }

    public void OnOff(boolean a, boolean b) {
        this.btnAdd.show(b);
        this.btnDelete.show(b);
        this.btnFind.show(b);
        this.btnEdit.show(b);
//        this.btnReset.show(a);
//        this.txtFind.show(b);

        this.btnSave.show(a);

    }
    public boolean checkTrungMa(int maLopTC)
    {
        try {
            List<DangKiMon> list = new ArrayList<>();
            list =DangKiMonDAO.findAll();
            for(DangKiMon dk: list)
            {
                if(dk.getMaLopTC() == maLopTC)
                {
                    return true;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Err: " + ex.toString());
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmaMonHoc = new javax.swing.JTextField();
        txthocky = new javax.swing.JTextField();
        txtNhom = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtnienkhoa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMax = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLopTinChi = new javax.swing.JTable();
        btnXemDiem = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhap thong tin"));
        jPanel2.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mã môn học :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Học kỳ:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nhóm:");

        txtmaMonHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtmaMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaMonHocActionPerformed(evt);
            }
        });

        txthocky.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txthocky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthockyActionPerformed(evt);
            }
        });

        txtNhom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnFind.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFind.setText("Tìm Kiếm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Niên khóa:");

        txtnienkhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnienkhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnienkhoaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("SLSVMin");

        txtMax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("SLSVMax:");

        txtMin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Xóa ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setText("Hủy bỏ");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnAdd)
                .addGap(65, 65, 65)
                .addComponent(btnSave)
                .addGap(65, 65, 65)
                .addComponent(btnEdit)
                .addGap(65, 65, 65)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addGap(92, 92, 92))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthocky, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnienkhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(txtMin))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFind))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtmaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txthocky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnienkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtNhom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        tblLopTinChi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã lớp TC", "Mã môn học", "Niên khóa", "Học kỳ", "Nhóm", "SLSVMin", "SLSVMax"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLopTinChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLopTinChiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLopTinChi);

        btnXemDiem.setText("Xem điểm");
        btnXemDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXemDiem)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXemDiem)
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblLopTinChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLopTinChiMouseClicked
        // TODO add your handling code here:
        pos = this.tblLopTinChi.getSelectedRow();
        demG = Integer.parseInt(tblLopTinChi.getValueAt(pos, 0).toString());
        check = true;
        btnXemDiem.setEnabled(check);
        View();
    }//GEN-LAST:event_tblLopTinChiMouseClicked

    private void btnXemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDiemActionPerformed
        // TODO add your handling code here:
            MonHocDAO mhDAO =new MonHocDAO();
            MonHoc mh = new MonHoc();
            mh = mhDAO.getMonHocByMaMon(txtmaMonHoc.getText().toString());
            String tenMon = mh.getTenMon();
            int maLopTC = x.getMaLopTC();
            xemDiemLTCFrame xemDiem = new xemDiemLTCFrame(maLopTC, tenMon);
            xemDiem.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
            xemDiem.setTitle("Bảng điểm" + tenMon);
            xemDiem.setLocationRelativeTo(this);
            xemDiem.setVisible(true);
        
    }//GEN-LAST:event_btnXemDiemActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String nk = this.txtnienkhoa.getText();
        String monhoc = this.txtmaMonHoc.getText();
        MonHoc mh = new MonHoc(monhoc);
        int tc = demG;
        int nhom = Integer.parseInt(this.txtNhom.getText());
        int hocki = Integer.parseInt(this.txthocky.getText());
        int min = Integer.parseInt(this.txtMin.getText());
        int max = Integer.parseInt(this.txtMax.getText());
        if(max <= min)
        {
            JOptionPane.showMessageDialog(this, "Số lượng sinh viên max phải lớn hơn số lượng sinh viên min");
        }
        else
        {
            LopTinChi x= new LopTinChi( nk, mh, tc, hocki, nhom, min,max);
            try {
                if(checkTrungMa(tc))
                {
                    JOptionPane.showMessageDialog(this, "Lớp tín chỉ đã được đăng kí! ");
                }
                else
                {
                    LopTinChiDAO.update(x);
                    JOptionPane.showConfirmDialog(panel, "Cập nhật thành công!!", "Thông báo", JOptionPane.CLOSED_OPTION);
                }
            } catch (ClassNotFoundException ex) {
                //            Logger.getLogger(QLLTCJFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Err: " + ex.toString());
            }

            showQLLTC();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtnienkhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnienkhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnienkhoaActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        txtmaMonHoc.setText("");
        txthocky.setText("");
        txtNhom.setText("");
        txtnienkhoa.setText("");
        txtMin.setText("");
        txtMax.setText("");
        check = false;
        btnXemDiem.setEnabled(check);
        OnOff(true, false);
        //        check = 1;
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        //        txtMaLopTC.setText("");
        txtmaMonHoc.setText("");
        txthocky.setText("");
        txtNhom.setText("");
        txtnienkhoa.setText("");
        txtMin.setText("");
        txtMax.setText("");
        showQLLTC();
        View();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        String ip = JOptionPane.showInputDialog(this, "Nhập mã môn học cần tìm :");
        if (ip != null && ip.length() > 0) {
            try {
                list = LopTinChiDAO.findByFullname(ip);
            } catch (ClassNotFoundException ex) {
                //                Logger.getLogger(QLLTCJFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Err: " + ex.toString());
            }
            tableModel.setRowCount(0);
            for (LopTinChi x : list) {
                tableModel.addRow(new Object[]{x.getMaLopTC(), x.getMh().getMaMon(), x.getNienKhoa(), x.getHocKy(), x.getNhom(), x.getSlsvMin(), x.getSlsvMax()});
            }
        } else {
            showQLLTC();
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedIndex = tblLopTinChi.getSelectedRow();
        if (selectedIndex >= 0) {
            LopTinChi x = list.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa?");

            if (option == 0) {

                try {
                    LopTinChiDAO.delete(x.getMaLopTC());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LopTinChiDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showConfirmDialog(panel, "Xóa thành công!!", "Thông báo", JOptionPane.CLOSED_OPTION);

                showQLLTC();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String nk = this.txtnienkhoa.getText();
        String monhoc = this.txtmaMonHoc.getText();
        MonHoc mh = new MonHoc(monhoc);
        int tc = demG;
        int nhom = Integer.parseInt(this.txtNhom.getText());
        int hocki = Integer.parseInt(this.txthocky.getText());
        int min = Integer.parseInt(this.txtMin.getText());
        int max = Integer.parseInt(this.txtMax.getText());
        if(max <= min)
        {
            JOptionPane.showMessageDialog(this, "Số lượng sinh viên max phải lớn hơn số lượng sinh viên min");
        }
        else
        {
            LopTinChi x= new LopTinChi( nk, mh, tc, hocki, nhom, min,max);
            try {
                LopTinChiDAO.insert(x);
            } catch (ClassNotFoundException ex) {
                //            Logger.getLogger(QLLTCJFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Err: " + ex.toString());
            }
        }
        

        JOptionPane.showConfirmDialog(panel, "Cập nhật thành công!!", "Thông báo", JOptionPane.CLOSED_OPTION);
        showQLLTC();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txthockyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthockyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthockyActionPerformed

    private void txtmaMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaMonHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaMonHocActionPerformed

    private void txtMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnXemDiem;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLopTinChi;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtNhom;
    private javax.swing.JTextField txthocky;
    private javax.swing.JTextField txtmaMonHoc;
    private javax.swing.JTextField txtnienkhoa;
    // End of variables declaration//GEN-END:variables
}
