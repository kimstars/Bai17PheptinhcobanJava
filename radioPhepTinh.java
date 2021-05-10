/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai17Pheptinh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author CHU TUAN KIET
 */
public class radioPhepTinh extends JFrame implements ActionListener {

    private JLabel tieude, gioithieu;
    private JLabel so1, so2, kq;
    private JTextField khungso1, khungso2, khungkq;
    private JButton btnThoat, btnTiep;
    private JRadioButton Rcong, Rtru, Rnhan, Rchia;
    private ButtonGroup group1 = new ButtonGroup();

    private Font font = new Font("Tahoma", Font.BOLD, 24);

    public radioPhepTinh() {
        this.setTitle("Phép tính Radio cực mạnh");
        this.setBounds(500, 250, 500, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        tieude = new JLabel();
        tieude.setBounds(new Rectangle(100, 20, 350, 30));
        tieude.setText("Radio Phép Tính Cơ Bản");
        tieude.setFont(font);
        this.getContentPane().add(tieude);

        gioithieu = new JLabel("Chu Tuấn Kiệt ANHTTT55 ");
        gioithieu.setBounds(170, 60, 300, 30);
        this.getContentPane().add(gioithieu);

        so1 = new JLabel("Nhập số 1:");
        so1.setBounds(new Rectangle(100, 100, 100, 30));
        this.getContentPane().add(so1);

        so2 = new JLabel("Nhập số 2:");
        so2.setBounds(new Rectangle(100, 160, 100, 30));
        this.getContentPane().add(so2);

        kq = new JLabel("Kết quả:");
        kq.setBounds(new Rectangle(100, 220, 100, 30));
        this.getContentPane().add(kq);

        khungso1 = new JTextField();
        khungso1.setBounds(170, 100, 150, 30);
        this.getContentPane().add(khungso1);

        khungso2 = new JTextField();
        khungso2.setBounds(170, 160, 150, 30);
        this.getContentPane().add(khungso2);

        khungkq = new JTextField();
        khungkq.setBounds(170, 220, 150, 30);
        this.getContentPane().add(khungkq);

        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(100, 280, 100, 30);
        btnThoat.addActionListener(this);
        this.getContentPane().add(btnThoat);

        btnTiep = new JButton("Tiếp tục");
        btnTiep.setBounds(240, 280, 100, 30);
        btnTiep.addActionListener(this);

        this.getContentPane().add(btnTiep);

        //------------------- phép tính
        phanRadio k = new phanRadio();

        Rcong = new JRadioButton("Cộng");
        Rcong.setBounds(360, 100, 100, 30);
        Rcong.addItemListener(k);
        this.getContentPane().add(Rcong);

        Rtru = new JRadioButton("Trừ");
        Rtru.setBounds(360, 130, 100, 30);
        Rtru.addItemListener(k);
        this.getContentPane().add(Rtru);

        Rnhan = new JRadioButton("Nhân");
        Rnhan.setBounds(360, 160, 100, 30);
        Rnhan.addItemListener(k);
        this.getContentPane().add(Rnhan);

        Rchia = new JRadioButton("Chia");
        Rchia.setBounds(360, 190, 100, 30);
        Rchia.addItemListener(k);
        this.getContentPane().add(Rchia);

        group1.add(Rcong);
        group1.add(Rtru);
        group1.add(Rnhan);
        group1.add(Rchia);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThoat) {
            this.dispose();
        } else if (e.getSource() == btnTiep) {
            khungso1.setText("");
            khungso2.setText("");
            khungkq.setText("");
        }
    }

    public static void main(String[] args) {
        radioPhepTinh run = new radioPhepTinh();
        run.setVisible(true);
        run.setResizable(false);
    }

    public class phanRadio implements ItemListener {

        public phanRadio() {

        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            double a = 0, b = 0;

            try {
                a = Double.parseDouble(khungso1.getText());
                b = Double.parseDouble(khungso2.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Hãy nhập đúng định dạng số. Mã lỗi :" + exception);
            }
            if (Rcong.isSelected()) {
                System.out.println("cong");

                khungkq.setText(String.valueOf(a + b));
            } else if (Rtru.isSelected()) {
                System.out.println("tru");

                khungkq.setText(String.valueOf(a - b));
            } else if (Rnhan.isSelected()) {
                System.out.println("nhan");
                khungkq.setText(String.valueOf(a * b));
            } else if (Rchia.isSelected()) {
                System.out.println("chia");

                if (b == 0) {
                    JOptionPane.showMessageDialog(null, "Lỗi chia cho 0");
                } else {
                    khungkq.setText(String.valueOf(a / b));
                }
            }

        }
    }
}
