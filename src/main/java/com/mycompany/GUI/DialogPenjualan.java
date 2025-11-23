package com.mycompany.GUI;

import com.mycompany.entity.Customer;
import com.mycompany.entity.Mobil;
import com.mycompany.entity.Penjualan;
import com.mycompany.service.CustomerService;
import com.mycompany.service.MobilService;
import java.math.BigInteger;

public class DialogPenjualan extends javax.swing.JDialog {
    private Penjualan penjualan;    // null = insert, not null = update
    private boolean saved = false;

    private final MobilService mobilService = new MobilService();
    private final CustomerService customerService = new CustomerService();

    public DialogPenjualan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Tambah Penjualan");

        txtIDPenjualan.setEditable(false);

        // default: input ID manual
        InputIDCustomer.setSelected(true);
        txtIdCustomerManual.setEnabled(true);
        ComboBoxCustomer.setEnabled(false);

        radioIDMobilManual.setSelected(true);
        txtIDMobilManual.setEnabled(true);
        comboMobil.setEnabled(false);

        loadComboMobil();
        loadComboCustomer();
    }

    public DialogPenjualan(java.awt.Frame parent, boolean modal, Penjualan p) {
        super(parent, modal);
        initComponents();
        this.penjualan = p;

        setTitle("Edit Penjualan");

        loadComboMobil();
        loadComboCustomer();

        txtIDPenjualan.setText(String.valueOf(p.getId()));
        txtTanggalPenjualan.setText(p.getTanggal().toString());
        txtTotalHargaPenjualan.setText(String.valueOf(p.getTotalHarga()));

        // Set customer
        if (p.getCustomerId() != null) {
            Customer c = p.getCustomerId();
            PilihCustomerdaridaftar.setSelected(true);
            txtIdCustomerManual.setEnabled(false);
            ComboBoxCustomer.setEnabled(true);
            ComboBoxCustomer.setSelectedItem(c);
        }

        // Set mobil
        if (p.getMobilId() != null) {
            radioComboIDMobil.setSelected(true);
            txtIDMobilManual.setEnabled(false);
            comboMobil.setEnabled(true);

            comboMobil.setSelectedItem(p.getMobilId());
        }
    }

    public boolean isSaved() {
        return saved;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    private void loadComboMobil() {
        comboMobil.removeAllItems();
        for (Mobil m : mobilService.getAll()) {
            comboMobil.addItem(m);
        }
    }

    private void loadComboCustomer() {
        ComboBoxCustomer.removeAllItems();
        for (Customer c : customerService.getAll()) {
            ComboBoxCustomer.addItem(c);
        }
    }

    private void savePenjualan() {

        if (penjualan == null) {
            penjualan = new Penjualan(); // insert
        }

        // ======== CUSTOMER HANDLING =========
        Customer selectedCustomer = null;

        if (InputIDCustomer.isSelected()) {
            // manual id
            int id = Integer.parseInt(txtIdCustomerManual.getText());
            selectedCustomer = customerService.getById(id);
        } else {
            selectedCustomer = (Customer) ComboBoxCustomer.getSelectedItem();
        }

        penjualan.setCustomerId(selectedCustomer);

        // ======== TANGGAL =========
        String tglString = txtTanggalPenjualan.getText(); // format harus yyyy-MM-dd
        java.sql.Date tgl = java.sql.Date.valueOf(tglString);
        penjualan.setTanggal(tgl);

        // ======== TOTAL HARGA =========
        penjualan.setTotalHarga(new BigInteger(txtTotalHargaPenjualan.getText()));

        // ======== MOBIL HANDLING =========
        if (radioIDMobilManual.isSelected()) {
            int idMobil = Integer.parseInt(txtIDMobilManual.getText());
            Mobil m = mobilService.getById(idMobil);
            penjualan.setMobilId(m);
        } else {
            Mobil selectedMobil = (Mobil) comboMobil.getSelectedItem();
            penjualan.setMobilId(selectedMobil);
        }

        saved = true;
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDPenjualan = new javax.swing.JTextField();
        txtTanggalPenjualan = new javax.swing.JTextField();
        txtTotalHargaPenjualan = new javax.swing.JTextField();
        radioIDMobilManual = new javax.swing.JRadioButton();
        radioComboIDMobil = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtIDMobilManual = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboMobil = new javax.swing.JComboBox<>();
        btnCancelPenjualan = new javax.swing.JButton();
        btnSavePenjualan = new javax.swing.JButton();
        txtIdCustomerManual = new javax.swing.JTextField();
        InputIDCustomer = new javax.swing.JRadioButton();
        PilihCustomerdaridaftar = new javax.swing.JRadioButton();
        ComboBoxCustomer = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("ID Penjualan");

        jLabel2.setText("Nama Pembeli");

        jLabel3.setText("Tanggal");

        jLabel4.setText("Total Harga");

        txtIDPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPenjualanActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioIDMobilManual);
        radioIDMobilManual.setText("Input ID Mobil Manual");
        radioIDMobilManual.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        radioIDMobilManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioIDMobilManualActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioComboIDMobil);
        radioComboIDMobil.setText("Pilih Mobil dari daftar:");
        radioComboIDMobil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        radioComboIDMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioComboIDMobilActionPerformed(evt);
            }
        });

        jLabel5.setText("Mobil ID:");

        txtIDMobilManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMobilManualActionPerformed(evt);
            }
        });

        jLabel6.setText("Mobil:");

        comboMobil.setModel(new javax.swing.DefaultComboBoxModel<Mobil>());
        comboMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMobilActionPerformed(evt);
            }
        });

        btnCancelPenjualan.setText("Cancel");
        btnCancelPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelPenjualanActionPerformed(evt);
            }
        });

        btnSavePenjualan.setText("Save");
        btnSavePenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePenjualanActionPerformed(evt);
            }
        });

        txtIdCustomerManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCustomerManualActionPerformed(evt);
            }
        });

        buttonGroup2.add(InputIDCustomer);
        InputIDCustomer.setText("tulis nama manual");
        InputIDCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputIDCustomerActionPerformed(evt);
            }
        });

        buttonGroup2.add(PilihCustomerdaridaftar);
        PilihCustomerdaridaftar.setText("pilih nama");
        PilihCustomerdaridaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PilihCustomerdaridaftarActionPerformed(evt);
            }
        });

        ComboBoxCustomer.setModel(new javax.swing.DefaultComboBoxModel<Customer>());
        ComboBoxCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioComboIDMobil)
                    .addComponent(radioIDMobilManual)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIDPenjualan)
                                    .addComponent(txtTanggalPenjualan)
                                    .addComponent(txtTotalHargaPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(txtIdCustomerManual)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PilihCustomerdaridaftar)
                                    .addComponent(InputIDCustomer)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(ComboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtIDMobilManual, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelPenjualan)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addComponent(comboMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSavePenjualan)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(InputIDCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdCustomerManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PilihCustomerdaridaftar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTanggalPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalHargaPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(radioIDMobilManual)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIDMobilManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(radioComboIDMobil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelPenjualan)
                    .addComponent(btnSavePenjualan))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPenjualanActionPerformed

    private void radioIDMobilManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioIDMobilManualActionPerformed
        txtIDMobilManual.setEnabled(true);
        comboMobil.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_radioIDMobilManualActionPerformed

    private void radioComboIDMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioComboIDMobilActionPerformed
        txtIDMobilManual.setEnabled(false);
        comboMobil.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_radioComboIDMobilActionPerformed

    private void btnCancelPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelPenjualanActionPerformed
        saved = false;   // pastikan data tidak disimpan
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelPenjualanActionPerformed

    private void btnSavePenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePenjualanActionPerformed
       savePenjualan();     // TODO add your handling code here:
    }//GEN-LAST:event_btnSavePenjualanActionPerformed

    private void comboMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMobilActionPerformed
        
    }//GEN-LAST:event_comboMobilActionPerformed

    private void txtIDMobilManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDMobilManualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMobilManualActionPerformed

    private void InputIDCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputIDCustomerActionPerformed
        txtIdCustomerManual.setEnabled(true);
        ComboBoxCustomer.setEnabled(false);    // TODO add your handling code here:
    }//GEN-LAST:event_InputIDCustomerActionPerformed

    private void ComboBoxCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCustomerActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxCustomerActionPerformed

    private void txtIdCustomerManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCustomerManualActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCustomerManualActionPerformed

    private void PilihCustomerdaridaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PilihCustomerdaridaftarActionPerformed
    txtIdCustomerManual.setEnabled(false);
    ComboBoxCustomer.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_PilihCustomerdaridaftarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Customer> ComboBoxCustomer;
    private javax.swing.JRadioButton InputIDCustomer;
    private javax.swing.JRadioButton PilihCustomerdaridaftar;
    private javax.swing.JButton btnCancelPenjualan;
    private javax.swing.JButton btnSavePenjualan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<Mobil> comboMobil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radioComboIDMobil;
    private javax.swing.JRadioButton radioIDMobilManual;
    private javax.swing.JTextField txtIDMobilManual;
    private javax.swing.JTextField txtIDPenjualan;
    private javax.swing.JTextField txtIdCustomerManual;
    private javax.swing.JTextField txtTanggalPenjualan;
    private javax.swing.JTextField txtTotalHargaPenjualan;
    // End of variables declaration//GEN-END:variables
}
