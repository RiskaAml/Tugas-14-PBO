package com.mycompany.GUI;

import com.mycompany.entity.Mobil;
import java.math.BigInteger;

public class MobilDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MobilDialog.class.getName());

    private Mobil mobil;       // null = mode insert, not null = update
    private boolean saved = false;

    public MobilDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Tambah Mobil");
        txtIDMobil.setEditable(false); // ID tidak editable
    }
    public MobilDialog(java.awt.Frame parent, boolean modal, Mobil mobil) {
        super(parent, modal);
        initComponents();
        this.mobil = mobil;

        setTitle("Edit Mobil");
        txtIDMobil.setEditable(false);

        loadMobilData();
    }
    public boolean isSaved() {
        return saved;
    }

    public Mobil getMobil() {
        return mobil;
    }

    private void loadMobilData() {
        txtIDMobil.setText(String.valueOf(mobil.getId()));
        txtMerkMobil.setText(mobil.getMerk());
        txtModelMobil.setText(mobil.getModel());
        txtTahunMobil.setText(String.valueOf(mobil.getTahun()));
        txtHargaMobill.setText(String.valueOf(mobil.getHarga()));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDMobil = new javax.swing.JTextField();
        txtModelMobil = new javax.swing.JTextField();
        txtTahunMobil = new javax.swing.JTextField();
        txtHargaMobill = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMerkMobil = new javax.swing.JTextField();
        btnSaveMobil = new javax.swing.JButton();
        btnCancelMobil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setText("ID Mobil");

        jLabel3.setText("Model");

        jLabel4.setText("Tahun");

        jLabel5.setText("Harga");

        txtIDMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMobilActionPerformed(evt);
            }
        });

        jLabel6.setText("Merk");

        btnSaveMobil.setText("Save");
        btnSaveMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveMobilActionPerformed(evt);
            }
        });

        btnCancelMobil.setText("Cancel");
        btnCancelMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelMobilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnCancelMobil)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                            .addComponent(btnSaveMobil))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIDMobil)
                                .addComponent(txtModelMobil)
                                .addComponent(txtTahunMobil)
                                .addComponent(txtHargaMobill, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                .addComponent(txtMerkMobil)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMerkMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTahunMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHargaMobill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveMobil)
                    .addComponent(btnCancelMobil))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDMobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMobilActionPerformed

    private void btnCancelMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelMobilActionPerformed
        saved = false;   // pastikan tidak disimpan
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMobilActionPerformed

    private void btnSaveMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMobilActionPerformed
        if (mobil == null) {
            mobil = new Mobil(); // insert mode
        }

        mobil.setMerk(txtMerkMobil.getText());
        mobil.setModel(txtModelMobil.getText());
        mobil.setTahun(Integer.valueOf(txtTahunMobil.getText()));
        mobil.setHarga(new BigInteger(txtHargaMobill.getText()));

        saved = true;
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMobilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelMobil;
    private javax.swing.JButton btnSaveMobil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtHargaMobill;
    private javax.swing.JTextField txtIDMobil;
    private javax.swing.JTextField txtMerkMobil;
    private javax.swing.JTextField txtModelMobil;
    private javax.swing.JTextField txtTahunMobil;
    // End of variables declaration//GEN-END:variables
}
