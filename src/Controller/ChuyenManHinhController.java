/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GuiNetbean.guiAdmin;
import Controller.DanhmucBean;
import GuiNetbean.guiProfile;
import GuiNetbean.guiStatisticalChart;
import Storage.Account;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ChuyenManHinhController {

    private final JPanel root;
    private String kindSelected = "";

    Account a = new Account("fudio101_admin007", "Ng01637202484", "Nguyen Do The Nguyen",
            LocalDate.of(2001, Month.JANUARY, 1), "0337202484");

    private List<DanhmucBean> listItem = null;

    public ChuyenManHinhController(JPanel panelRoot) {
        this.root = panelRoot;
    }

    public void setView(JPanel paneItem, JLabel lbItem) {
        kindSelected = "Account Management";
        paneItem.setBackground(new Color(96, 100, 191));
        lbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        //    root.add(node);
        root.validate();
        root.repaint();

    }

    public void setEvent(List<DanhmucBean> listItem) {
        this.listItem = listItem;
        for (DanhmucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(a, item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JFrame node;

        private final String kind;
        private final JPanel paneItem;
        private final JLabel lbItem;

        public LabelEvent(Account login, String kind, JPanel paneItem, JLabel lbItem) {
            this.kind = kind;
            this.paneItem = paneItem;
            this.lbItem = lbItem;
        }

        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "AccountManager":
                    node = new guiAdmin();
                    break;
                case "StatisChart":
                    node = new guiStatisticalChart();
                case "AdminProfile":
                    node = new guiProfile(a);
                    break;

                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            paneItem.setBackground(new Color(96, 100, 191));
            lbItem.setBackground(new Color(96, 100, 191));

        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            paneItem.setBackground(new Color(96, 100, 191));
            lbItem.setBackground(new Color(96, 100, 191));
        }

        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                paneItem.setBackground(new Color(76, 175, 80));
                lbItem.setBackground(new Color(76, 175, 80));

            }
        }
    }

    private void setChangeBackground(String kind) {
        for (DanhmucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpn().setBackground(new Color(76, 175, 80));
                item.getJlb().setBackground(new Color(76, 175, 80));
            }
        }
    }

}
