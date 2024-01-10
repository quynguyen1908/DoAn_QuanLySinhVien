/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.LopSinhVienDAO;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.LopSinhVien;
import model.SinhVien;

/**
 *
 * @author acer
 */
public class LopSinhVienJPanel extends javax.swing.JPanel {

    LopSinhVienDAO lDAO = new LopSinhVienDAO();
    String layMaLop = "";
    String maSV = "";
    private double diemHe10 = 0;
    private double diemHe4 = 0;
    private int tongSoTC = 0;
    /**
     * Creates new form LopSinhVienJPanel
     */
    public LopSinhVienJPanel() {
        initComponents();
        fillDataTable();
        txtMaLop.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkMaLop();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkMaLop();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkMaLop();
            }
        });
        txtTenLop.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkTenLop();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkTenLop();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkTenLop();
            }
        });
        txtMaLop.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi con trỏ vào txtMaSV
            }

            @Override
            public void focusLost(FocusEvent e) {
                checkMaLop();
            }
        });
        txtTenLop.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi con trỏ vào txtMaSV
            }

            @Override
            public void focusLost(FocusEvent e) {
                checkTenLop();
            }
        });
    }
    
    public void fillDataTable()
    {
        DefaultTableModel model = (DefaultTableModel)tbLopSV.getModel();
        model.setRowCount(0);
        for(LopSinhVien l : lDAO.getALlLopSV())
        {
            Object rowData[] = new Object[2];
            rowData[0] = l.getMaLop();
            rowData[1] = l.getTenLop();
            model.addRow(rowData);
        }
    }
    
    public void fillDataTableDSSV(String maLop)
    {
        DefaultTableModel model = (DefaultTableModel)tab_DanhSachSinhVien.getModel();
        model.setRowCount(0);
        for(SinhVien sv : lDAO.getALlSinhVienByMaLop(maLop))
        {
            Object rowData[] = new Object[5];
            rowData[0] = sv.getMaSV();
            rowData[1] = sv.getTenSV();
            rowData[2] = sv.getNgaySinh();
            rowData[3] = sv.getSdt();
            rowData[4] = sv.getDiaChi();
            model.addRow(rowData);
        }
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
        txtTimkiem = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenLop = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jlbTBMaLop = new javax.swing.JLabel();
        jlbTBTenLop = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLopSV = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_DanhSachSinhVien = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDiem = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });
        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyReleased(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm lớp"));

        jLabel1.setText("Mã Lớp:");

        jLabel2.setText("Tên Lớp:");

        btnThem.setText("Thêm mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jlbTBMaLop.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlbTBMaLop.setForeground(new java.awt.Color(255, 51, 51));

        jlbTBTenLop.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlbTBTenLop.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua)
                        .addGap(10, 10, 10)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLuu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbTBTenLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbTBMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addComponent(jlbTBMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTBTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tbLopSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã lớp", "Tên lớp"
            }
        ));
        tbLopSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLopSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLopSV);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tab_DanhSachSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Ngày sinh", "Số điện thoại", "Địa chỉ"
            }
        ));
        tab_DanhSachSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_DanhSachSinhVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tab_DanhSachSinhVien);

        tbDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã môn", "Tên môn", "Số tín chỉ", "Điểm hệ 10", "Điểm hệ 4", "Điểm hệ chữ"
            }
        ));
        jScrollPane3.setViewportView(tbDiem);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void reset()
    {
        txtMaLop.setText("");
        txtTenLop.setText("");
        
    }
    
    public boolean TrungMaLop(String maLop)
    {
        for(LopSinhVien l : lDAO.getALlLopSV())
        {
            if(l.getMaLop().equalsIgnoreCase(maLop))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean validateForm()
    {
        if(txtMaLop.getText().isEmpty() || txtTenLop.getText().isEmpty())
        {
            return false;
        }
        return true;
    }
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbLopSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLopSVMouseClicked
        // TODO add your handling code here:
        int id = tbLopSV.rowAtPoint(evt.getPoint());
        String maLop = tbLopSV.getValueAt(id, 0).toString();
        LopSinhVien l = lDAO.getLopSinhVienByID(maLop);
        txtMaLop.setText(l.getMaLop());
        txtTenLop.setText(l.getTenLop());
        layMaLop = maLop;
        fillDataTableDSSV(maLop);
    }//GEN-LAST:event_tbLopSVMouseClicked

    
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(TrungMaLop(txtMaLop.getText()))
            {
                JOptionPane.showMessageDialog(this, "Mã lớp trùng");
            }
            else
            {
                LopSinhVien l = new LopSinhVien();
                l.setMaLop(txtMaLop.getText());
                l.setTenLop(txtTenLop.getText());
                if(lDAO.add(l) > 0)
                {
                    JOptionPane.showMessageDialog(this, "Thêm lớp thành công");
                    fillDataTable();
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            String maLop = txtMaLop.getText();
            if(maLop.equalsIgnoreCase(layMaLop))
            {
                if(lDAO.delLopSinhVienByID(maLop) > 0)
                {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    reset();
                    fillDataTable();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Bạn đã thay đổi mã lớp nên không xóa được");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            LopSinhVien l = new LopSinhVien();
            l.setMaLop(txtMaLop.getText());
            l.setTenLop(txtTenLop.getText());
            // neu thong tin form ma lop khong doi ( tuc chi doi ten lop) HOAC doi ma lop nhung khong gay trung ma
            if((layMaLop.equalsIgnoreCase(l.getMaLop())) || ((!layMaLop.equalsIgnoreCase(l.getMaLop())) && !TrungMaLop(l.getMaLop())))
            {
                if(lDAO.updateSinhVienByID(l, layMaLop) > 0)
                {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                    fillDataTable();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Trùng mã lớp");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    public void search(String str)
    {
        DefaultTableModel model = (DefaultTableModel)tbLopSV.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tbLopSV.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    
    private void txtTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyReleased
        // TODO add your handling code here:
        String strSearch = txtTimkiem.getText();
        search(strSearch);
    }//GEN-LAST:event_txtTimkiemKeyReleased

        public double diemHe4(double diem)
    {
        return diem*4 / 10;
    }
    
    public String diemHeChu(double diem)
    {
        String diemChu = "";
        if(diem >= 9)
        {
            diemChu = "A+";
        }
        else if(diem >= 8.5)
        {
            diemChu = "A";
        }
        else if(diem >= 8)
        {
            diemChu = "B+";
        }
        else if(diem >= 7)
        {
            diemChu = "B";
        }
        else if(diem >= 6.5)
        {
            diemChu = "C+";
        }
        else if(diem >= 5.5)
        {
            diemChu = "C";
        }
        else if(diem >= 5)
        {
            diemChu = "D+";
        }
        else if(diem >= 4)
        {
            diemChu = "D";
        }
        else
        {
            diemChu = "F";
        }
        return diemChu;
    }
    
    public void fillDataTable(String maSV)
    {
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select MonHoc.maMon, MonHoc.tenMon, MonHoc.sltclt, MonHoc.sltcth , DangKiMon.diem "
                    + "from DangKiMon, LopTinChi, MonHoc "
                    + "where DangKiMon.maLopTC = LopTinChi.maLopTC and LopTinChi.maMon = MonHoc.maMon and DangKiMon.maSV = '" + maSV + "'";
            conn = database.DatabaseHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            DefaultTableModel model = (DefaultTableModel)tbDiem.getModel();
            model.setRowCount(0);
            while (rs.next()) {
//                System.out.println("1");
                Object rowData[] = new Object[6];
                String maMon = rs.getString(1);
                rowData[0] = maMon;
                String tenMon = rs.getString(2);
                rowData[1] = tenMon;
                int tclt = rs.getInt(3);
                int tcth = rs.getInt(4);
                rowData[2] = tclt + tcth;
                tongSoTC += tclt + tcth;
                double diem = rs.getDouble(5);
                rowData[3] = diem;
                rowData[4] = diemHe4(diem);
                rowData[5] = diemHeChu(diem);
//                diemHe10 += 
                model.addRow(rowData);
            }
        } catch (Exception e) {
            System.out.println("Err: " + e.toString());
        }
        finally{
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
        }
    }
    
    private void tab_DanhSachSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_DanhSachSinhVienMouseClicked
        // TODO add your handling code here:        
        int id = tab_DanhSachSinhVien.rowAtPoint(evt.getPoint());
        maSV = tab_DanhSachSinhVien.getValueAt(id, 0).toString();
        fillDataTable(maSV);
    }//GEN-LAST:event_tab_DanhSachSinhVienMouseClicked

    public void checkMaLop()
    {
        String regMaLop = "^D\\d{2}CQ[A-Z]{2}\\d{2}-N$";
        if (!txtMaLop.getText().matches(regMaLop)) {
            jlbTBMaLop.setText("Mã lớp có dạng D21CQCN01-N");
        } else {
            jlbTBMaLop.setText("");
        }
    }
    
    public void checkTenLop()
    {
        String regMaLop = "[a-zA-Z_0-9 ]+";
        if (!txtMaLop.getText().matches(regMaLop)) {
            jlbTBMaLop.setText("Tên lớp không có kí tự đặc biêt * + ( ...");
        } else {
            jlbTBMaLop.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlbTBMaLop;
    private javax.swing.JLabel jlbTBTenLop;
    private javax.swing.JTable tab_DanhSachSinhVien;
    private javax.swing.JTable tbDiem;
    private javax.swing.JTable tbLopSV;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtTenLop;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
