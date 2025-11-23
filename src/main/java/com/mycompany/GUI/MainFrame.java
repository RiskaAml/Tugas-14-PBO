package com.mycompany.GUI;

import com.mycompany.db.DatabaseConnection;
import com.mycompany.entity.Customer;
import com.mycompany.service.MobilService;
import com.mycompany.service.PenjualanService;
import com.mycompany.tablemodel.MobilTableModel;
import com.mycompany.tablemodel.PenjualanTableModel;
import com.mycompany.entity.Mobil;
import com.mycompany.entity.Penjualan;
import com.mycompany.service.CustomerService;
import com.mycompany.tablemodel.CustomerTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    private final MobilService mobilService = new MobilService();
    private final PenjualanService penjualanService = new PenjualanService();
    private final CustomerService customerService = new CustomerService();

    public MainFrame() {
        initComponents();
        loadMobilTable();
        loadPenjualanTable();
        loadCustomerTable();
            // listener saat tab diganti
        TabbedPanePenjualan.addChangeListener(e -> {
            int index = TabbedPanePenjualan.getSelectedIndex();
            if (index == 0) {
                loadMobilTable();
            } else if (index == 1) {
                loadPenjualanTable();
            }
        });
    }
    private void loadMobilTable() {
    List<Mobil> list = mobilService.getAll();
    TableTabMobil.setModel(new MobilTableModel(list));
    }

    private void loadPenjualanTable() {
        List<Penjualan> list = penjualanService.getAll();
        TableTabPenjualan.setModel(new PenjualanTableModel(list));
    }
    private void loadCustomerTable() {
        List<Customer> list = customerService.getAll();
        TableTabCustomer.setModel(new CustomerTableModel(list));
    }
    private String safeCSV(String text) {
        if (text == null) return "";
        if (text.contains(",") || text.contains("\"")) {
            return "\"" + text.replace("\"", "\"\"") + "\"";
        }
        return text;
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPanePenjualan = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableTabMobil = new javax.swing.JTable();
        btnInsertMobil = new javax.swing.JButton();
        btnUpdateMobil = new javax.swing.JButton();
        btnDeleteMobil = new javax.swing.JButton();
        btnClearAllMobil = new javax.swing.JButton();
        btnUploadMobil = new javax.swing.JButton();
        btnCetakMobil = new javax.swing.JButton();
        btnExportCsvMobil = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableTabPenjualan = new javax.swing.JTable();
        btnInsertPenjualan = new javax.swing.JButton();
        btnDeletePenjualan = new javax.swing.JButton();
        btnUpdatePenjualan = new javax.swing.JButton();
        btnClearAllPenjualan = new javax.swing.JButton();
        btnUploadPenjualan = new javax.swing.JButton();
        btnCetakPenjualan = new javax.swing.JButton();
        btnExportCsvPenjualan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableTabCustomer = new javax.swing.JTable();
        btnInsertCustomer = new javax.swing.JButton();
        btnUpdateCustomer = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();
        btnClearAllCustomer = new javax.swing.JButton();
        btnUploadCustomer = new javax.swing.JButton();
        btnCetakCustomer = new javax.swing.JButton();
        btnExportCsvCustomer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));

        TabbedPanePenjualan.setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        TableTabMobil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Mobil", "Merk", "Model", "Tahun", "Harga"
            }
        ));
        jScrollPane1.setViewportView(TableTabMobil);

        btnInsertMobil.setText("INSERT");
        btnInsertMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertMobilActionPerformed(evt);
            }
        });

        btnUpdateMobil.setText("UPDATE");
        btnUpdateMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMobilActionPerformed(evt);
            }
        });

        btnDeleteMobil.setText("DELETE");
        btnDeleteMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMobilActionPerformed(evt);
            }
        });

        btnClearAllMobil.setText("CLEAR ALL");
        btnClearAllMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllMobilActionPerformed(evt);
            }
        });

        btnUploadMobil.setText("UPLOAD");
        btnUploadMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadMobilActionPerformed(evt);
            }
        });

        btnCetakMobil.setText("Cetak");
        btnCetakMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakMobilActionPerformed(evt);
            }
        });

        btnExportCsvMobil.setText("Export CSV");
        btnExportCsvMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportCsvMobilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnInsertMobil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdateMobil))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDeleteMobil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClearAllMobil)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExportCsvMobil)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCetakMobil)
                            .addComponent(btnUploadMobil))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertMobil)
                    .addComponent(btnUpdateMobil)
                    .addComponent(btnUploadMobil))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteMobil)
                            .addComponent(btnClearAllMobil)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCetakMobil)
                            .addComponent(btnExportCsvMobil))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        TabbedPanePenjualan.addTab("Mobil", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        TableTabPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Penjualan", "Nama Pembeli", "Tanggal", "Total Harga", "ID Mobil"
            }
        ));
        jScrollPane2.setViewportView(TableTabPenjualan);

        btnInsertPenjualan.setText("INSERT");
        btnInsertPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertPenjualanActionPerformed(evt);
            }
        });

        btnDeletePenjualan.setText("DELETE");
        btnDeletePenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePenjualanActionPerformed(evt);
            }
        });

        btnUpdatePenjualan.setText("UPDATE");
        btnUpdatePenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePenjualanActionPerformed(evt);
            }
        });

        btnClearAllPenjualan.setText("CLEAR ALL");
        btnClearAllPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllPenjualanActionPerformed(evt);
            }
        });

        btnUploadPenjualan.setText("UPLOAD");
        btnUploadPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadPenjualanActionPerformed(evt);
            }
        });

        btnCetakPenjualan.setText("Cetak");
        btnCetakPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakPenjualanActionPerformed(evt);
            }
        });

        btnExportCsvPenjualan.setText("Export CSV");
        btnExportCsvPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportCsvPenjualanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnInsertPenjualan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdatePenjualan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnDeletePenjualan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClearAllPenjualan)
                                .addGap(113, 113, 113)
                                .addComponent(btnExportCsvPenjualan)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCetakPenjualan)
                            .addComponent(btnUploadPenjualan))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertPenjualan)
                    .addComponent(btnUpdatePenjualan)
                    .addComponent(btnUploadPenjualan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearAllPenjualan)
                    .addComponent(btnDeletePenjualan)
                    .addComponent(btnCetakPenjualan)
                    .addComponent(btnExportCsvPenjualan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedPanePenjualan.addTab("Penjualan", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        TableTabCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Cuctomer", "Nama Pembeli", "Alamat", "No Telp", "Email"
            }
        ));
        jScrollPane3.setViewportView(TableTabCustomer);

        btnInsertCustomer.setText("INSERT");
        btnInsertCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertCustomerActionPerformed(evt);
            }
        });

        btnUpdateCustomer.setText("UPDATE");
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        btnDeleteCustomer.setText("DELETE");
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        btnClearAllCustomer.setText("CLEAR ALL");
        btnClearAllCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllCustomerActionPerformed(evt);
            }
        });

        btnUploadCustomer.setText("UPLOAD");
        btnUploadCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadCustomerActionPerformed(evt);
            }
        });

        btnCetakCustomer.setText("CETAK");
        btnCetakCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakCustomerActionPerformed(evt);
            }
        });

        btnExportCsvCustomer.setText("Export CSV");
        btnExportCsvCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportCsvCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnInsertCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUploadCustomer))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnDeleteCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(btnClearAllCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExportCsvCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetakCustomer)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertCustomer)
                    .addComponent(btnUploadCustomer)
                    .addComponent(btnUpdateCustomer))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearAllCustomer)
                    .addComponent(btnCetakCustomer)
                    .addComponent(btnDeleteCustomer)
                    .addComponent(btnExportCsvCustomer))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        TabbedPanePenjualan.addTab("Customer", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPanePenjualan)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPanePenjualan, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearAllMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllMobilActionPerformed
        List<Mobil> list = mobilService.getAll();

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada data untuk dihapus.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Hapus semua data mobil?\nSemua penjualan terkait akan ikut terhapus!",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        for (Mobil m : list) {
            mobilService.delete(m.getId());
        }

        loadMobilTable();
        loadPenjualanTable();      // TODO add your handling code here:
    }//GEN-LAST:event_btnClearAllMobilActionPerformed

    private void btnUploadMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadMobilActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih File CSV Mobil");

        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        java.io.File file = fileChooser.getSelectedFile();

        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {

            String line;
            int count = 0;

            // Baca header (5 kolom: id,merk,model,tahun,harga)
            line = br.readLine();
            if (line == null) {
                JOptionPane.showMessageDialog(this, "File CSV kosong!");
                return;
            }

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Sekarang cek minimal 5 kolom
                if (data.length < 5) {
                    JOptionPane.showMessageDialog(this,
                        "Format CSV tidak valid pada baris: " + line);
                    continue;
                }

                Mobil m = new Mobil();

                // **Lewati data[0] = ID**
                m.setMerk(data[1].trim());
                m.setModel(data[2].trim());
                m.setTahun(Integer.parseInt(data[3].trim()));
                m.setHarga(new java.math.BigInteger(data[4].trim()));

                mobilService.insert(m);
                count++;
            }

            loadMobilTable();

            JOptionPane.showMessageDialog(this,
                    "Upload selesai! " + count + " data berhasil ditambahkan.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Terjadi error saat membaca file: " + e.getMessage());
            e.printStackTrace();
        }      // TODO add your handling code here:
    }//GEN-LAST:event_btnUploadMobilActionPerformed

    private void btnDeletePenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePenjualanActionPerformed
        int row = TableTabPenjualan.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data penjualan dulu!");
            return;
        }

        PenjualanTableModel model = (PenjualanTableModel) TableTabPenjualan.getModel();
        Penjualan p = model.getPenjualanAt(row);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Hapus penjualan ini?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            penjualanService.delete(p.getId());
            loadPenjualanTable();
            loadMobilTable(); // jika ingin cascade refresh
        }      // TODO add your handling code here:
    }//GEN-LAST:event_btnDeletePenjualanActionPerformed

    private void btnInsertMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertMobilActionPerformed
        MobilDialog dialog = new MobilDialog(this, true);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        if (dialog.isSaved()) {
            Mobil m = dialog.getMobil();
            mobilService.insert(m);
            loadMobilTable();
        }
    }//GEN-LAST:event_btnInsertMobilActionPerformed

    private void btnUpdateMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMobilActionPerformed
        int row = TableTabMobil.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data dulu!");
            return;
        }

        MobilTableModel model = (MobilTableModel) TableTabMobil.getModel();
        Mobil m = model.getMobilAt(row);

        // buka dialog edit
        MobilDialog dialog = new MobilDialog(this, true, m);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        if (dialog.isSaved()) {
            mobilService.update(m);
            loadMobilTable();
        }      // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateMobilActionPerformed

    private void btnDeleteMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMobilActionPerformed
        int row = TableTabMobil.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data dulu!");
            return;
        }

        MobilTableModel model = (MobilTableModel) TableTabMobil.getModel();
        Mobil m = model.getMobilAt(row);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Hapus mobil ini?\nSemua penjualan terkait juga akan terhapus!",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            mobilService.delete(m.getId());
            loadMobilTable();
            loadPenjualanTable(); // refresh juga penjualan karena cascade
        }     // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMobilActionPerformed

    private void btnInsertPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertPenjualanActionPerformed
        DialogPenjualan dialog = new DialogPenjualan(this, true);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        if (dialog.isSaved()) {
            Penjualan p = dialog.getPenjualan();
            penjualanService.insert(p);
            loadPenjualanTable();
        }      // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertPenjualanActionPerformed

    private void btnUpdatePenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePenjualanActionPerformed
        int row = TableTabPenjualan.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data penjualan dulu!");
            return;
        }

        PenjualanTableModel model = (PenjualanTableModel) TableTabPenjualan.getModel();
        Penjualan p = model.getPenjualanAt(row);

        DialogPenjualan dialog = new DialogPenjualan(this, true, p);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        if (dialog.isSaved()) {
            penjualanService.update(p);
            loadPenjualanTable();
        }      // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdatePenjualanActionPerformed

    private void btnClearAllPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllPenjualanActionPerformed
        List<Penjualan> list = penjualanService.getAll();

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada data penjualan untuk dihapus.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Hapus semua data penjualan?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        for (Penjualan p : list) {
            penjualanService.delete(p.getId());
        }

        loadPenjualanTable();
        loadMobilTable();      // TODO add your handling code here:
    }//GEN-LAST:event_btnClearAllPenjualanActionPerformed

    private void btnUploadPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadPenjualanActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Pilih File CSV Penjualan");

    int result = fileChooser.showOpenDialog(this);
    if (result != JFileChooser.APPROVE_OPTION) return;

    java.io.File file = fileChooser.getSelectedFile();

    try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(file))) {

        String line;
        int count = 0;

        // Skip header
        line = br.readLine();
        if (line == null) {
            JOptionPane.showMessageDialog(this, "File CSV kosong!");
            return;
        }

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data.length < 5) {
                JOptionPane.showMessageDialog(this,
                        "Format CSV tidak valid pada baris: " + line);
                continue;
            }

            // format CSV:
            // id, nama_pembeli, tanggal, total_harga, id_mobil
            String namaCustomer = data[1].trim();
            String tanggalStr = data[2].trim();
            String totalStr = data[3].trim();
            String idMobilStr = data[4].trim();

            // 1. Cari customer berdasarkan nama
            Customer cust = customerService.findByNama(namaCustomer);
            if (cust == null) {
                JOptionPane.showMessageDialog(this,
                        "Customer '" + namaCustomer + "' tidak ditemukan! Baris dilewati.");
                continue;
            }

            // 2. Parse tanggal
            java.util.Date date = null;
            try {
                date = sdf.parse(tanggalStr);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Format tanggal salah pada baris: " + line);
                continue;
            }

            // 3. Ambil mobil
            int idMobil = Integer.parseInt(idMobilStr);
            Mobil m = mobilService.getById(idMobil);
            if (m == null) {
                JOptionPane.showMessageDialog(this,
                        "ID Mobil " + idMobil + " tidak ditemukan! Baris dilewati.");
                continue;
            }

            // 4. Buat objek penjualan
            Penjualan p = new Penjualan();
            p.setCustomerId(cust);
            p.setTanggal(date);
            p.setTotalHarga(new java.math.BigInteger(totalStr));
            p.setMobilId(m);

            penjualanService.insert(p);
            count++;
        }

        loadPenjualanTable();
        loadMobilTable();

        JOptionPane.showMessageDialog(this,
                "Upload selesai! " + count + " data penjualan berhasil ditambahkan.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error membaca file: " + e.getMessage());
        e.printStackTrace();
    }

    }//GEN-LAST:event_btnUploadPenjualanActionPerformed

    private void btnCetakPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakPenjualanActionPerformed
        try {
            String path = "src/main/resources/reports/ReportPenjualan.jrxml";

            JasperReport jr = JasperCompileManager.compileReport(path);

            // gunakan koneksi JDBC kita
            Connection conn = DatabaseConnection.getConnection();

            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);

            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setTitle("Laporan Data Penjualan");
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mencetak: " + e.getMessage());
        } 
    }//GEN-LAST:event_btnCetakPenjualanActionPerformed

    private void btnCetakMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakMobilActionPerformed
        try {
            String path = "src/main/resources/reports/ReportMobil.jrxml";

            JasperReport jr = JasperCompileManager.compileReport(path);

            // gunakan koneksi JDBC kita
            Connection conn = DatabaseConnection.getConnection();

            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);

            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setTitle("Laporan Data Mobil");
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mencetak: " + e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakMobilActionPerformed

    private void btnInsertCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertCustomerActionPerformed
        String nama = JOptionPane.showInputDialog(this, "Masukkan nama:");
        if (nama == null || nama.isEmpty()) return;

        String alamat = JOptionPane.showInputDialog(this, "Masukkan alamat:");
        String no = JOptionPane.showInputDialog(this, "Masukkan No Telp:");
        if (no == null || no.isEmpty()) return;

        String email = JOptionPane.showInputDialog(this, "Masukkan Email:");

        Customer c = new Customer();
        c.setNama(nama);
        c.setAlamat(alamat);
        c.setNoTelp(no);
        c.setEmail(email);

        customerService.insert(c);
        loadCustomerTable();   
    }//GEN-LAST:event_btnInsertCustomerActionPerformed

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
        int row = TableTabCustomer.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih customer terlebih dahulu!");
            return;
        }

        CustomerTableModel model = (CustomerTableModel) TableTabCustomer.getModel();
        Customer c = model.getCustomerAt(row);

        String nama = JOptionPane.showInputDialog(this, "Nama baru:", c.getNama());
        if (nama == null) return;

        String alamat = JOptionPane.showInputDialog(this, "Alamat baru:", c.getAlamat());
        String no = JOptionPane.showInputDialog(this, "No Telp baru:", c.getNoTelp());
        String email = JOptionPane.showInputDialog(this, "Email baru:", c.getEmail());

        c.setNama(nama);
        c.setAlamat(alamat);
        c.setNoTelp(no);
        c.setEmail(email);

        customerService.update(c);
        loadCustomerTable();        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        int row = TableTabCustomer.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih customer terlebih dahulu!");
            return;
        }

        CustomerTableModel model = (CustomerTableModel) TableTabCustomer.getModel();
        Customer c = model.getCustomerAt(row);

        int konfirm = JOptionPane.showConfirmDialog(this,
                "Hapus customer " + c.getNama() + "?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);

        if (konfirm == JOptionPane.YES_OPTION) {
            customerService.delete(c.getId());
            loadCustomerTable();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void btnClearAllCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllCustomerActionPerformed
        int konfirm = JOptionPane.showConfirmDialog(this,
                "Hapus semua customer?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);

        if (konfirm == JOptionPane.YES_OPTION) {
            customerService.clearAll();
            loadCustomerTable();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearAllCustomerActionPerformed

    private void btnUploadCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadCustomerActionPerformed
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;

        try (BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                Customer c = new Customer();
                c.setNama(d[0].trim());
                c.setAlamat(d[1].trim());
                c.setNoTelp(d[2].trim());
                c.setEmail(d[3].trim());

                customerService.insert(c);
            }

            loadCustomerTable();
            JOptionPane.showMessageDialog(this, "Upload selesai!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnUploadCustomerActionPerformed

    private void btnCetakCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakCustomerActionPerformed
        try {
            String path = "src/main/resources/reports/ReportCustomer.jrxml";

            JasperReport jr = JasperCompileManager.compileReport(path);

            // gunakan koneksi JDBC kita
            Connection conn = DatabaseConnection.getConnection();

            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);

            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setTitle("Laporan Data Customer");
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mencetak: " + e.getMessage());
        }       
    }//GEN-LAST:event_btnCetakCustomerActionPerformed

    private void btnExportCsvMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportCsvMobilActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Simpan CSV Mobil");
        chooser.setSelectedFile(new java.io.File("mobil.csv"));

        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        java.io.File file = chooser.getSelectedFile();

        try (java.io.PrintWriter pw = new java.io.PrintWriter(file)) {

            // Header CSV
            pw.println("id,merk,model,tahun,harga");

            List<Mobil> list = mobilService.getAll();

            for (Mobil m : list) {
                pw.println(
                    m.getId() + "," +
                    safeCSV(m.getMerk()) + "," +
                    safeCSV(m.getModel()) + "," +
                    m.getTahun() + "," +
                    m.getHarga()
                );
            }

            JOptionPane.showMessageDialog(this, "Export CSV mobil berhasil!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal export mobil: " + e.getMessage());
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnExportCsvMobilActionPerformed

    private void btnExportCsvPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportCsvPenjualanActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Simpan CSV Penjualan");
        chooser.setSelectedFile(new java.io.File("penjualan.csv"));

        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        java.io.File file = chooser.getSelectedFile();

        try (java.io.PrintWriter pw = new java.io.PrintWriter(file)) {

            // Header CSV
            pw.println("id,nama_pembeli,tanggal,total_harga,id_mobil");

            List<Penjualan> list = penjualanService.getAll();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

            for (Penjualan p : list) {

                String namaCustomer = (p.getCustomerId() != null)
                        ? p.getCustomerId().getNama()
                        : "";

                String tanggal = (p.getTanggal() != null)
                        ? sdf.format(p.getTanggal())
                        : "";

                String idMobil = (p.getMobilId() != null)
                        ? String.valueOf(p.getMobilId().getId())
                        : "";

                pw.println(
                    p.getId() + "," +
                    safeCSV(namaCustomer) + "," +
                    safeCSV(tanggal) + "," +
                    p.getTotalHarga() + "," +
                    idMobil
                );
            }

            JOptionPane.showMessageDialog(this, "Export CSV penjualan berhasil!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal export penjualan: " + e.getMessage());
        }

    }//GEN-LAST:event_btnExportCsvPenjualanActionPerformed

    private void btnExportCsvCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportCsvCustomerActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Simpan CSV Customer");
        chooser.setSelectedFile(new java.io.File("customer.csv"));

        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        java.io.File file = chooser.getSelectedFile();

        try (java.io.PrintWriter pw = new java.io.PrintWriter(file)) {

            // Header CSV
            pw.println("id,nama,alamat,no_telp,email");

            List<Customer> list = customerService.getAll();

            for (Customer c : list) {
                pw.println(
                    c.getId() + "," +
                    safeCSV(c.getNama()) + "," +
                    safeCSV(c.getAlamat()) + "," +
                    safeCSV(c.getNoTelp()) + "," +
                    safeCSV(c.getEmail())
                );
            }

            JOptionPane.showMessageDialog(this, "Export CSV customer berhasil!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal export customer: " + e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportCsvCustomerActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPanePenjualan;
    private javax.swing.JTable TableTabCustomer;
    private javax.swing.JTable TableTabMobil;
    private javax.swing.JTable TableTabPenjualan;
    private javax.swing.JButton btnCetakCustomer;
    private javax.swing.JButton btnCetakMobil;
    private javax.swing.JButton btnCetakPenjualan;
    private javax.swing.JButton btnClearAllCustomer;
    private javax.swing.JButton btnClearAllMobil;
    private javax.swing.JButton btnClearAllPenjualan;
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnDeleteMobil;
    private javax.swing.JButton btnDeletePenjualan;
    private javax.swing.JButton btnExportCsvCustomer;
    private javax.swing.JButton btnExportCsvMobil;
    private javax.swing.JButton btnExportCsvPenjualan;
    private javax.swing.JButton btnInsertCustomer;
    private javax.swing.JButton btnInsertMobil;
    private javax.swing.JButton btnInsertPenjualan;
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.JButton btnUpdateMobil;
    private javax.swing.JButton btnUpdatePenjualan;
    private javax.swing.JButton btnUploadCustomer;
    private javax.swing.JButton btnUploadMobil;
    private javax.swing.JButton btnUploadPenjualan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
