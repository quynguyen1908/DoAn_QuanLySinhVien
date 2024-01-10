/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.DangKiMonDAO;
import dao.LopSinhVienDAO;
import dao.SinhVienDAO;
import dao.UserDAO;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.DangKiMon;
import model.LopSinhVien;
import model.SinhVien;
import model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class HocVienJPanel extends javax.swing.JPanel{

    SinhVienDAO svDAO = new SinhVienDAO();
    LopSinhVienDAO lDAO = new LopSinhVienDAO();
    DangKiMonDAO dkmDAO = new DangKiMonDAO();
    String strHinhAnh = null;
    SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
    private Component HocVienJPanel;
    UserDAO uDAO = new UserDAO();
    /**
     * Creates new form HocVienJPanel
     */
    public HocVienJPanel() {
        initComponents();
        String[] data = new String[lDAO.getALlLopSV().size()];
        for(int i = 0; i < lDAO.getALlLopSV().size(); i++)
        {
            data[i] = lDAO.getALlLopSV().get(i).getMaLop();
        }
        // Tạo một DefaultComboBoxModel và thiết lập nó cho cbLop
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(data);
        cbLop.setModel(comboBoxModel);
        txtMaLop.setText(cbLop.getSelectedItem().toString());
        txtMaLop.setEditable(false);
        fillDataTable(cbLop.getSelectedItem().toString());
        
        txtMaSV.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkMaSV();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkMaSV();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkMaSV();
            }
        });

        txtTenSV.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkTenSV();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkTenSV();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkTenSV();
            }
        });

        txtSDT.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkSDT();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkSDT();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkSDT();
            }
        });
        
        txtNamNhapHoc.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkNamNhapHoc();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkNamNhapHoc();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkNamNhapHoc();
            }
        });

        // Thêm FocusListener cho các JTextField
        txtMaSV.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi con trỏ vào txtMaSV
            }

            @Override
            public void focusLost(FocusEvent e) {
                checkMaSV();
            }
        });

        txtTenSV.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jlbTBMasV.getText().isEmpty()) {
                    // Xử lý khi con trỏ vào txtTenSV
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                checkTenSV();
            }
        });

        txtSDT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jlbTBMasV.getText().isEmpty() && jlbTBTenSV.getText().isEmpty()) {
                    // Xử lý khi con trỏ vào txtSDT
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                checkSDT();
            }
        });
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cbLop = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jpnHinhAnh = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtTenSV = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jlbTBMasV = new javax.swing.JLabel();
        jlbTBTenSV = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rdNam = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rdNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNamNhapHoc = new javax.swing.JTextField();
        jlbTBSDT = new javax.swing.JLabel();
        jlbTBNamNhapHoc = new javax.swing.JLabel();
        tbSVvvvv = new javax.swing.JScrollPane();
        tbSV = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();

        cbLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLopItemStateChanged(evt);
            }
        });
        cbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLopActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết"));

        jpnHinhAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnHinhAnhMouseClicked(evt);
            }
        });

        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnHinhAnhLayout = new javax.swing.GroupLayout(jpnHinhAnh);
        jpnHinhAnh.setLayout(jpnHinhAnhLayout);
        jpnHinhAnhLayout.setHorizontalGroup(
            jpnHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jpnHinhAnhLayout.setVerticalGroup(
            jpnHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHinhAnhLayout.createSequentialGroup()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

        jLabel4.setText("Địa Chỉ:");

        jLabel3.setText("Ngày Sinh:");

        jLabel2.setText("Tên Sinh Viên:");

        jLabel1.setText("Mã Sinh Viên:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        jlbTBMasV.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jlbTBMasV.setForeground(new java.awt.Color(255, 0, 0));

        jlbTBTenSV.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jlbTBTenSV.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbTBMasV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbTBTenSV, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jlbTBMasV, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTBTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        buttonGroup1.add(rdNam);
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        jLabel5.setText("Phái");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        jLabel6.setText("Số Điện Thoại:");

        jLabel7.setText("Mã Lớp");

        jLabel8.setText("Năm Nhập Học:");

        jlbTBSDT.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jlbTBSDT.setForeground(new java.awt.Color(255, 0, 0));

        jlbTBNamNhapHoc.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jlbTBNamNhapHoc.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rdNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdNu))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMaLop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(txtNamNhapHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(jlbTBSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(jlbTBNamNhapHoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jlbTBSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNamNhapHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTBNamNhapHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(btnThem)
                .addGap(80, 80, 80)
                .addComponent(btnSua)
                .addGap(80, 80, 80)
                .addComponent(btnXoa)
                .addGap(80, 80, 80)
                .addComponent(btnLuu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu))
                .addGap(10, 10, 10))
        );

        tbSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Phái", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Mã lớp", "Năm nhập học", "Hình ảnh"
            }
        ));
        tbSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSVMouseClicked(evt);
            }
        });
        tbSVvvvv.setViewportView(tbSV);

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tbSVvvvv))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbSVvvvv, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    public void fillDataTable(String maLop)
    {
        DefaultTableModel model = (DefaultTableModel)tbSV.getModel();
        model.setRowCount(0);
        for(SinhVien sv : svDAO.getAllSinhVien())
        {
            if(sv.getLopSV().getMaLop().equalsIgnoreCase(maLop))
            {
                Object rowData[] = new Object[9];
                rowData[0] = sv.getMaSV();
                rowData[1] = sv.getTenSV();
                rowData[2] = sv.isGioiTinh() ? "Nam" : "Nu";
                rowData[3] = date_format.format(sv.getNgaySinh());
                rowData[4] = sv.getDiaChi();
                rowData[5] = sv.getSdt();
                rowData[6] = sv.getLopSV().getMaLop();
                rowData[7] = sv.getNamNhapHoc();
                rowData[8] = sv.getHinhAnh();
                model.addRow(rowData);
            }
            else
            {
                continue;
            }
            
        }
    }
    
    public void reset()
    {
        String maLop = cbLop.getSelectedItem().toString();
        txtMaSV.setText("");
        txtTenSV.setText("");
        txtMaLop.setText(maLop); ////////
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtNamNhapHoc.setText("");
        rdNam.setSelected(true);
        lblHinhAnh.setText("HINH ANH");
        lblHinhAnh.setIcon(null);
        strHinhAnh = null;
        jlbTBMasV.setText("");
        jlbTBTenSV.setText("");
        jlbTBNamNhapHoc.setText("");
        jlbTBSDT.setText("");
    }
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        reset();
        txtMaSV.setEditable(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLopActionPerformed
        // TODO add your handling code here:
        cbLop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maLop = (String) cbLop.getSelectedItem();
                txtMaLop.setText(maLop);
                fillDataTable(maLop);
            }
        });
        
    }//GEN-LAST:event_cbLopActionPerformed

    private void cbLopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLopItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbLopItemStateChanged

    /////-----------Chuan hoa truoc khi luu vao database-------
    public String chuanHoaTen(String ten)
    {
        String res = "";
        String[] words = ten.trim().toLowerCase().split("\\s+");
        for(String x : words)
        {
            if (!x.isEmpty()) {
                String firstCharUpper = x.substring(0, 1).toUpperCase() + x.substring(1);
//                System.out.println(firstCharUpper);
                  res += firstCharUpper;
                  res += " ";
            }
        }
        res = res.trim();  // xoa khoang trang cuoi cung
        return res;
    }
    
    //getModel: lay du lieu tu form ep cho SinhVien
    public SinhVien getModel() throws ParseException
    {
        SinhVien sv = new SinhVien();
        sv.setMaSV(txtMaSV.getText());
        String tenSV = chuanHoaTen(txtTenSV.getText());
        sv.setTenSV(tenSV);
        boolean gt = false;  // mac dinh la nu
        if(rdNam.isSelected())
        {
            gt = true;
        }
        sv.setGioiTinh(gt);
        sv.setDiaChi(txtDiaChi.getText());
        sv.setNgaySinh(date_format.parse(txtNgaySinh.getText()));
        sv.setSdt(txtSDT.getText());
        sv.setNamNhapHoc(txtNamNhapHoc.getText());
        sv.setLopSV(new LopSinhVien(txtMaLop.getText()));
        if(strHinhAnh == null)
        {
            sv.setHinhAnh("NO AVATAR");
        }
        else
        {
            sv.setHinhAnh(strHinhAnh);
        }
        return sv;
    }
    
    //setModel: do du lieu tu table len form
    public void setModel(SinhVien sv)
    {
        txtMaSV.setText(sv.getMaSV());
        txtTenSV.setText(sv.getTenSV());
        txtNgaySinh.setText(date_format.format(sv.getNgaySinh()));
        txtDiaChi.setText(sv.getDiaChi());
        if(sv.isGioiTinh())
        {
            rdNam.isSelected();
        }
        else
        {
            rdNu.isSelected();
        }
        txtSDT.setText(sv.getSdt());
        txtMaLop.setText(sv.getLopSV().getMaLop());
        txtNamNhapHoc.setText(sv.getNamNhapHoc());
        if(sv.getHinhAnh().equalsIgnoreCase("no avatar"))
        {
            lblHinhAnh.setText("NO AVATAR");
            lblHinhAnh.setIcon(null);
        }
        else
        {
            lblHinhAnh.setText("");
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/" + sv.getHinhAnh()));
            Image img = imgIcon.getImage();
            
            Image scaledImg = img.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledImgIcon = new ImageIcon(scaledImg);
            lblHinhAnh.setIcon(scaledImgIcon);

        }
    }
    
    private void tbSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSVMouseClicked
        // TODO add your handling code here:
        int id = tbSV.rowAtPoint(evt.getPoint());
        String maSV = tbSV.getValueAt(id, 0).toString();
        SinhVien sv = svDAO.getSinhVienByID(maSV);
        txtMaSV.setEditable(false);
        setModel(sv);

    }//GEN-LAST:event_tbSVMouseClicked

    private void jpnHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHinhAnhMouseClicked



    }//GEN-LAST:event_jpnHinhAnhMouseClicked

    public boolean validateForm()
    {
        if(txtMaLop.getText().isEmpty() || txtTenSV.getText().isEmpty() || txtNgaySinh.getText().isEmpty()
                || txtNamNhapHoc.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtSDT.getText().isEmpty())
        {
            return false;
        }
        return true;
    }
    
    public boolean trungMaSV(String maSV)
    {
        for(SinhVien sv : svDAO.getAllSinhVien())
        {
            if(sv.getMaSV().equalsIgnoreCase(maSV))
            {
                return true;
            }
        }
        return false;
    }
    
    public String validDay(int day)
    {
        String s = String.valueOf(day);
        if(s.length() < 2)
        {
            s = "0" + s;
        }
        return s;
    }
    
    public String validMonth(int month)
    {
        String s = String.valueOf(month);
        if(s.length() < 2)
        {
            s = "0" + s;
        }
        return s;
    }
    
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(trungMaSV(txtMaSV.getText()))
            {
                JOptionPane.showMessageDialog(this, "Trung ma sinh vien");
            }
            else
            {
                try {
                    SinhVien sv = getModel();
                    if(svDAO.add(sv) > 0)
                    {
                        User u = new User();
                        u.setRole(false);
                        u.setUsername(sv.getMaSV());
                        String day = validDay(getDay(sv.getNgaySinh()));
                        String month = validMonth(getMonth(sv.getNgaySinh()));
                        String year = String.valueOf(getYear(sv.getNgaySinh()));
                        u.setPassword(day + month + year);
                        if(uDAO.add(u) > 0)
                        {
                            System.out.println("Thêm tài khoản thành công");
                        }
                        JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công");
                        fillDataTable(sv.getLopSV().getMaLop());
                    }
                } catch (ParseException ex) {
                    System.out.println("Err: " + ex.toString());
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private int getYear(Date date) {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        return Integer.parseInt(yearFormat.format(date));
    }

    private int getMonth(Date date) {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        return Integer.parseInt(monthFormat.format(date));
    }

    private int getDay(Date date) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        return Integer.parseInt(dayFormat.format(date));
    }
    
    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        // TODO add your handling code here:                                      
    try 
    {
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser("D:/DAI_HOC/nam3/HK1/Lap_trinh_huong_doi_tuong/thuc_hanh_tren_lop/DoAn_QuanLySinhVien/src/images");
        jfc.showOpenDialog(null);

        File file = jfc.getSelectedFile();

        // Check if a file was selected
        if (file != null) 
        {
            Image image = ImageIO.read(file);
            strHinhAnh = file.getName();
            lblHinhAnh.setText("");

            int width = lblHinhAnh.getWidth();
            int height = lblHinhAnh.getHeight();

            lblHinhAnh.setIcon(new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        } 
        else 
        {
            // Handle the case where no file was selected
            System.out.println("No file selected.");
        }
    } catch (IOException ex) {
        System.out.println("Err: " + ex.toString());
    }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            try {
                SinhVien sv = getModel();
                if(svDAO.updateSinhVienByID(sv) > 0)
                {
//                    String day = validDay(getDay(sv.getNgaySinh()));
//                    String month = validMonth(getMonth(sv.getNgaySinh()));
//                    String year = String.valueOf(getYear(sv.getNgaySinh()));
//                    uDAO.updatePassUser(sv.getMaSV(),day + month + year);
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                    fillDataTable(txtMaLop.getText());
                }
            } catch (ParseException ex) {
                System.out.println("Err: " + ex.toString());
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            String maSV = txtMaSV.getText();
            
            
            DangKiMon svDKM = dkmDAO.getSinhVienDangKiByID(maSV);
            if(svDKM != null)  // sinh vien da dang ki lop tin chi
            {
                JOptionPane.showMessageDialog(this, "Sinh viên đã đăng kí lớp tín chỉ, không thể xóa!");
            }
            else
            {
                if(svDAO.delSinhVienByID(maSV) > 0)
                {
                    if(uDAO.deleteUserByID(txtMaSV.getText()) > 0)
                    {
                        System.out.println("Xoa tai khoan thanh cong");
                    }
                    JOptionPane.showMessageDialog(this.HocVienJPanel, "Xóa sinh viên thành công");
                    fillDataTable(txtMaLop.getText());
                }
            }  
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    public void search(String str)
    {
        DefaultTableModel model = (DefaultTableModel)tbSV.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tbSV.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    
    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String strSearch = txtTimKiem.getText();
        search(strSearch);
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbTBMasV;
    private javax.swing.JLabel jlbTBNamNhapHoc;
    private javax.swing.JLabel jlbTBSDT;
    private javax.swing.JLabel jlbTBTenSV;
    private javax.swing.JPanel jpnHinhAnh;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbSV;
    private javax.swing.JScrollPane tbSVvvvv;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtNamNhapHoc;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenSV;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    
    private void checkMaSV() {
        String regMa = "^N\\d{2}DC[A-Z]{2}\\d{3}$";
        if (!txtMaSV.getText().matches(regMa)) {
            jlbTBMasV.setText("Mã sinh viên có dạng N21DCCN001");
        } else {
            jlbTBMasV.setText("");
        }
    }

    private void checkTenSV() {
        String regTen = "[A-Za-z ]+";
        if (!txtTenSV.getText().matches(regTen)) {
            jlbTBTenSV.setText("Tên không hợp lệ");
        } else {
            jlbTBTenSV.setText("");
        }
    }

    private void checkSDT() {
        String regSDT = "\\d+";
        if (!txtSDT.getText().matches(regSDT)) {
            jlbTBSDT.setText("Điện thoại chỉ gồm các số");
        } else {
            jlbTBSDT.setText("");
        }
    }
     
    private void checkNamNhapHoc(){
        String regNamNH = "\\d{4}";
        if (!txtNamNhapHoc.getText().matches(regNamNH)) {
            jlbTBNamNhapHoc.setText("Năm nhập học gồm 4 số");
        } else {
            jlbTBNamNhapHoc.setText("");
        }
    }
}
