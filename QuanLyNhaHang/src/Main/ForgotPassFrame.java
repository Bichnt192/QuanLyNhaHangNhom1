/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import Untils.MsgBox;
import Untils.Xmail;

/**
 *
 * @author doanp
 */
public class ForgotPassFrame extends javax.swing.JFrame {

    /**
     * Creates new form QuenMatKhauFrame
     */
    public ForgotPassFrame() {
        setUndecorated(true);
        initComponents();
        init();
    }

    void init() {
        setSize(800, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(2);
        statusDefault();
    }

    void statusDefault() {
        txtMa.setEnabled(false);
        btnGuiLai.setEnabled(false);
        btnXN.setEnabled(false);
    }
    int code;

    void sendCode(String mailTo) {
        double random = Math.random();
        if (random < 0.1) {
            random += 0.1;
        }
        code = (int) Math.round(random * 1000000);
        Xmail.sendCode(code, mailTo);
    }

    boolean checkUser() {
        if (txtTenDangNhap.getText().length() == 0) {
            MsgBox.alert(this, "Vui lòng nhập tên đăng nhập!");
            txtTenDangNhap.requestFocus();
            return false;
        }
        return true;
    }
    NhanVien nv;

    void guiMa() {
        if (checkUser()) {
            nv = new NhanVienDAO().selectById(txtTenDangNhap.getText());
            if (nv == null || nv.isTrangThai() == false) {
                MsgBox.alert(this, "Tên đăng nhập không tồn tại!");
            } else {
                sendCode(nv.getEmail());
                MsgBox.alert(this, "Đã gửi mã xác thực!");
                txtMa.setEnabled(true);
                btnGuiLai.setEnabled(true);
                btnXN.setEnabled(true);
                txtTenDangNhap.setEnabled(false);
                btnGuiMa.setEnabled(false);

            }
        }
    }

    void xacThuc() {
        if (txtMa.getText().length() == 0) {
            MsgBox.alert(this, "Vui lòng nhập tên đăng nhập!");
            txtMa.requestFocus();
        } else {
            if (Integer.parseInt(txtMa.getText()) != code) {
                MsgBox.alert(this, "Mã xác thực không chính xác!");
            } else {
                dispose();
                new XacthucFrame(nv).setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTenDangNhap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuiLai = new javax.swing.JButton();
        btnGuiMa = new javax.swing.JButton();
        btnXN = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lblBG = new javax.swing.JLabel();
        lblNP1 = new javax.swing.JLabel();
        lblFB1 = new javax.swing.JLabel();
        lblIG1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 83, 148));
        jLabel1.setText("QUÊN MẬT KHẨU");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 70, 330, 70);

        txtMa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaFocusLost(evt);
            }
        });
        txtMa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaKeyReleased(evt);
            }
        });
        jPanel1.add(txtMa);
        txtMa.setBounds(80, 250, 260, 30);

        txtTenDangNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusLost(evt);
            }
        });
        txtTenDangNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenDangNhapKeyReleased(evt);
            }
        });
        jPanel1.add(txtTenDangNhap);
        txtTenDangNhap.setBounds(80, 180, 260, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tên đăng nhập");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 150, 140, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã xác thực tài khoản");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 220, 180, 22);

        btnGuiLai.setBackground(new java.awt.Color(8, 83, 148));
        btnGuiLai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuiLai.setForeground(new java.awt.Color(255, 255, 255));
        btnGuiLai.setText("Gửi lại mã");
        btnGuiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiLaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuiLai);
        btnGuiLai.setBounds(360, 250, 90, 30);

        btnGuiMa.setBackground(new java.awt.Color(8, 83, 148));
        btnGuiMa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuiMa.setForeground(new java.awt.Color(255, 255, 255));
        btnGuiMa.setText("Gửi mã");
        btnGuiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuiMa);
        btnGuiMa.setBounds(360, 180, 90, 30);

        btnXN.setBackground(new java.awt.Color(8, 83, 148));
        btnXN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXN.setForeground(new java.awt.Color(255, 255, 255));
        btnXN.setText("XÁC THỰC");
        btnXN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXNActionPerformed(evt);
            }
        });
        jPanel1.add(btnXN);
        btnXN.setBounds(220, 300, 100, 30);

        btnHuy.setBackground(new java.awt.Color(8, 83, 148));
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HUỶ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel1.add(btnHuy);
        btnHuy.setBounds(100, 300, 100, 30);

        lblBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fpw.jpg"))); // NOI18N
        jPanel1.add(lblBG);
        lblBG.setBounds(0, 0, 800, 400);

        lblNP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/call.jpg"))); // NOI18N
        lblNP1.setText("0368.721.JQK");
        jPanel1.add(lblNP1);
        lblNP1.setBounds(170, 310, 120, 50);

        lblFB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fb.jpg"))); // NOI18N
        lblFB1.setText("Ngỹn Pick");
        lblFB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFB1MouseClicked(evt);
            }
        });
        jPanel1.add(lblFB1);
        lblFB1.setBounds(70, 310, 110, 50);

        lblIG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ig.jpg"))); // NOI18N
        lblIG1.setText("Dogpick");
        lblIG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIG1MouseClicked(evt);
            }
        });
        jPanel1.add(lblIG1);
        lblIG1.setBounds(290, 310, 100, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaFocusGained

    }//GEN-LAST:event_txtMaFocusGained

    private void txtMaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaFocusLost

    }//GEN-LAST:event_txtMaFocusLost

    private void txtMaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKeyReleased

    }//GEN-LAST:event_txtMaKeyReleased

    private void btnXNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXNActionPerformed
        xacThuc();
    }//GEN-LAST:event_btnXNActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        if (MsgBox.confirm(this, "Bạn có chắc chắn muốn thoát?")) {
            dispose();
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtTenDangNhapFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDangNhapFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapFocusGained

    private void txtTenDangNhapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDangNhapFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapFocusLost

    private void txtTenDangNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenDangNhapKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapKeyReleased

    private void btnGuiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMaActionPerformed
        guiMa();
    }//GEN-LAST:event_btnGuiMaActionPerformed

    private void btnGuiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiLaiActionPerformed
        guiMa();
    }//GEN-LAST:event_btnGuiLaiActionPerformed

    private void lblFB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFB1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFB1MouseClicked

    private void lblIG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIG1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblIG1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgotPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              new ForgotPassFrame().setVisible(true);
           }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuiLai;
    private javax.swing.JButton btnGuiMa;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBG;
    private javax.swing.JLabel lblFB1;
    private javax.swing.JLabel lblIG1;
    private javax.swing.JLabel lblNP1;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}