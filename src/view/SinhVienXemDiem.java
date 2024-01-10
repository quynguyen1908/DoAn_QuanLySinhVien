/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author acer
 */
public class SinhVienXemDiem extends javax.swing.JPanel {
    
    private String maSV = "";
    private double diemHe10 = 0;
    private double diemHe4 = 0;
    private int tongSoTC = 0;
    private double tongDiem = 0;
    private double tongDiem4 = 0;
    /**
     * Creates new form SinhVienXemDiem
     */
    public SinhVienXemDiem(String maSV) {
        initComponents();
        txtMaSV.setText(maSV.toUpperCase());
        txtMaSV.setEditable(false);
        fillDataTable(maSV);
    }
    
    NumberFormat formatter = new DecimalFormat("#0.00");
    
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
    
    double diemChu_diemSo(String diem)
    {
        double diemSo = 0;
        if(diem.equals("A+"))
        {
            diemSo = 4;
        }
        else if(diem.equals("A"))
        {
            diemSo = 3.7;
        }
        else if(diem.equals("B+"))
        {
            diemSo = 3.5;
        }
        else if(diem.equals("B"))
        {
            diemSo = 3;
        }
        else if(diem.equals("C+"))
        {
            diemSo = 2.5;
        }
        else if(diem.equals("C"))
        {
            diemSo = 2;
        }
        else if(diem.equals("D+"))
        {
            diemSo = 1.5;
        }
        else if(diem.equals("D"))
        {
            diemSo = 1;
        }
        else
        {
            diemSo = 0;
        }
        return diemSo;
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
                tongDiem += diem*(tclt+tcth);
                rowData[3] = diem;
                rowData[4] = diemHe4(diem);
                rowData[5] = diemHeChu(diem);
                String diemChu = diemHeChu(diem);
                double diemSotuChu = diemChu_diemSo(diemChu);
                tongDiem4 += diemSotuChu*(tclt+tcth);
//                diemHe10 += 
                model.addRow(rowData);
            }
            double diemTBhe10 = tongDiem/tongSoTC;
            txtDiemTB10.setText(String.valueOf(formatter.format(diemTBhe10)));
            double diemTBhe4 = tongDiem4/tongSoTC;
            txtDiemTB4.setText(String.valueOf(formatter.format(diemTBhe4)));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiem = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtDiemTB10 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiemTB4 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã sinh viên:");

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
        jScrollPane1.setViewportView(tbDiem);

        jLabel2.setText("Điểm trung bình hệ 10:");

        jLabel3.setText("Điểm trung bình hệ 4:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiemTB10, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(txtDiemTB4))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiemTB10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDiemTB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDiem;
    private javax.swing.JTextField txtDiemTB10;
    private javax.swing.JTextField txtDiemTB4;
    private javax.swing.JTextField txtMaSV;
    // End of variables declaration//GEN-END:variables
}
