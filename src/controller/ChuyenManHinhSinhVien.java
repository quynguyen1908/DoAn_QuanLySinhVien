/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import bean.DanhMucBean;
import dao.tinhTrangDangKiDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.tinhTrangDangKi;
import view.SinhVienChoDKMonJPanel;
import view.SinhVienDangKiMon;
import view.SinhVienXemDiem;
import view.TrangChuJPanel;
import view.TrangChuJPanel1;
import view.TrangChuSVJPanel;

/**
 *
 * @author acer
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author acer
 */
public class ChuyenManHinhSinhVien {
    private JPanel root;
    private String kindSelected = "";
    tinhTrangDangKiDAO ttdkDAO = new tinhTrangDangKiDAO();
    
   private String maSV;
    
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhSinhVien(JPanel jpnRoot, String maSV) {
        this.root = jpnRoot;
        this.maSV = maSV.toUpperCase();
    }
    
    public String getMaSV() {
        return maSV;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem)
    {
        kindSelected = "TrangChu";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuSVJPanel(maSV));
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem)
    {
        this.listItem = listItem;
        for(DanhMucBean item : listItem)
        {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener
    {
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpbItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpbItem;
            this.jlbItem = jlbItem;
        }
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind)
            {
                case "TrangChu":
                    node = new TrangChuSVJPanel(maSV);
                    break;
                case "SinhVienDangKi":
                    tinhTrangDangKi tt = new tinhTrangDangKi();
                    tt = ttdkDAO.getTinhTrang();
                    if(tt.isTrangThai() == true)
                    {
                        node = new SinhVienDangKiMon(getMaSV());
                    }
                    else
                    {
                        node = new SinhVienChoDKMonJPanel();
                    }
                    break;
                case "SinhVienXemDiem":
                    node = new SinhVienXemDiem(getMaSV());
                    break;
                default:
                    break;
                    
                    
                    
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));   // Mau Tim
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(kindSelected.equalsIgnoreCase("TrangChu"))
            {
                jpnItem.setBackground(new Color(232,64,60));  // mau do
                jlbItem.setBackground(new Color(232,64,60));
            }
            if(!kindSelected.equalsIgnoreCase(kind))
            {
                jpnItem.setBackground(new Color(76, 175, 80));  // mau xanh
                jlbItem.setBackground(new Color(76, 175, 80));
            }
            
        }
        
    }
    
    private void setChangeBackgroud(String kind) {
    for (DanhMucBean item : listItem) {
        if (item.getKind().equalsIgnoreCase("TrangChu")) {
            // Xử lý cho "TrangChu"
            if (kind.equals("TrangChu")) {
                // Màu khi "TrangChu" được click
                item.getJpn().setBackground(new Color(96, 100, 191));  // Màu tím
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                // Màu khi "TrangChu" không được click
                item.getJpn().setBackground(new Color(232, 64, 60));  // Màu đỏ
                item.getJlb().setBackground(new Color(232, 64, 60));
            }
        } else {
            // Xử lý cho các "kind" khác
            if (item.getKind().equalsIgnoreCase(kind)) {
                // Màu khi "kind" được click
                item.getJpn().setBackground(new Color(96, 100, 191));  // Màu tím
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                // Màu khi "kind" không được click
                item.getJpn().setBackground(new Color(76, 175, 80));   // Màu xanh
                item.getJlb().setBackground(new Color(76, 175, 80));
            }
        }
    }
}
    
    // 232,64,60
    
}




