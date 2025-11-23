package com.mycompany.GUI;


import com.mycompany.entity.UserLogin;
import com.mycompany.service.UserLoginService;
import javax.swing.JOptionPane;

public class DialogPasswordBaru extends javax.swing.JDialog {

    private final UserLogin user;
    private final UserLoginService service = new UserLoginService();

    public DialogPasswordBaru(java.awt.Frame parent, boolean modal, String otpBenar, UserLogin user) {
        super(parent, modal);
        this.user = user;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPasswordBaru = new javax.swing.JPasswordField();
        btnBuatPasswordbaru = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPasswordKonfirmasiBaru = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("Buat password baru : ");

        btnBuatPasswordbaru.setText("Buat");
        btnBuatPasswordbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuatPasswordbaruActionPerformed(evt);
            }
        });

        jLabel2.setText("Konfirmasi password : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtPasswordBaru)
                            .addComponent(jLabel2)
                            .addComponent(txtPasswordKonfirmasiBaru, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btnBuatPasswordbaru)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordKonfirmasiBaru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnBuatPasswordbaru)
                .addGap(71, 71, 71))
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

    private void btnBuatPasswordbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuatPasswordbaruActionPerformed

        String pass1 = new String(txtPasswordBaru.getPassword()).trim();
        String pass2 = new String(txtPasswordKonfirmasiBaru.getPassword()).trim();

        if (pass1.isEmpty() || pass2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password tidak boleh kosong!");
            return;
        }

        if (!pass1.equals(pass2)) {
            JOptionPane.showMessageDialog(this, "Password tidak sama!");
            return;
        }

        try {
            service.updatePassword(user, pass1);
            JOptionPane.showMessageDialog(this, "Password berhasil diperbarui!");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui password: " + e.getMessage());
        }     // TODO add your handling code here:
    }//GEN-LAST:event_btnBuatPasswordbaruActionPerformed

    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuatPasswordbaru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPasswordBaru;
    private javax.swing.JPasswordField txtPasswordKonfirmasiBaru;
    // End of variables declaration//GEN-END:variables
}
