/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB7_Perkantoran;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class GUI_Karyawan extends javax.swing.JFrame {
        Karyawan Data = new Karyawan();      
        
    /**
     * Creates new form GUI_Karyawan
     */
    public GUI_Karyawan() {
        initComponents();
        pLembur.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pLembur = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnProses = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        pCentang = new javax.swing.JCheckBox();
        pShif = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pLembur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14 jam", "28 jam", "42 jam", "56 jam" }));
        pLembur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pLemburActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID Karyawan");

        btnProses.setText("PROSES");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama Karywan");

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Alamat Karyawan");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Shif Kerja");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Lembur");

        pCentang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCentangActionPerformed(evt);
            }
        });

        pShif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagi", "Malam" }));
        pShif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pShifActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("DATA KARYAWAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnProses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pShif, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pCentang)
                                        .addGap(18, 18, 18)
                                        .addComponent(pLembur, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(pShif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pCentang)
                                    .addComponent(pLembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(btnProses))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pLemburActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pLemburActionPerformed
        // TODO add your handling code here:
        Hitung Hasil;
        Hasil = new Gaji();
        Hasil = new Lembur();
        if (pLembur.getSelectedIndex()== 0){
            txtArea.setText (Integer.toString(Hasil.HitungA()));
        } else if (pLembur.getSelectedIndex()== 1){
            txtArea.setText (Integer.toString(Hasil.HitungB()));
        } else if (pLembur.getSelectedIndex()== 2){
            txtArea.setText (Integer.toString(Hasil.HitungC()));
        } else {
            txtArea.setText (Integer.toString(Hasil.HitungD()));
        }
    }//GEN-LAST:event_pLemburActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        txtArea.setText("");
        Hitung Hasil;
        Hasil = new Gaji();
        Hasil = new Lembur();
        int a = 1918090;
        Data.id_kar = a;
        Data.nama_kar = txtNama.getText();
        Data.setAlamat_kar(txtAlamat.getText());
        //Data.setId_kar("");
       // Data.nama_kar = "" ;
       // Data.setAlamat_kar("");
        try{
            a = Integer.parseInt(txtId.getText());
        }
        catch (Exception C){
            JOptionPane.showConfirmDialog(null, "ID harus di isi ","Eror", 2);
        }
        txtArea.append("Data Karyawan");
        txtArea.append("\n-------------------------");
        txtArea.append("\nID Karyawan : "+Data.getId_kar());
        txtArea.append("\nNama Karyawan : "+Data.nama_kar);
        txtArea.append("\nAlamat Karyawan : "+Data.getAlamat_kar());
        txtArea.append("\nGaji Karyawan : Rp"+Hasil.hitung()+" PerBulan");

        if(pCentang.isSelected()){
            if (pShif.getSelectedIndex()==0){
                txtArea.append("\nShif Kerja : "+Data.shif());
                if (pLembur.getSelectedIndex()== 0){
                    txtArea.append("\nTotal Gaji : Rp"+Hasil.HitungA()+" PerBulan");
                } else if (pLembur.getSelectedIndex()== 1){
                    txtArea.append("\nTotal Gaji : Rp"+Hasil.HitungB()+" PerBulan");
                } else if (pLembur.getSelectedIndex()== 2){
                    txtArea.append("\nTotal Gaji : Rp"+Hasil.HitungC()+" PerBulan");
                } else {
                    txtArea.append("\nGaji Lembur: Rp"+Hasil.HitungD()+" PerBulan");
                }
            } else {
                txtArea.append("\nShif Kerja : "+Data.shif("Malam"));
                if (pLembur.getSelectedIndex()== 0){
                    txtArea.append("\nTotal Gaji : Rp"+Hasil.HitungA()+" PerBulan");
                } else if (pLembur.getSelectedIndex()== 1){
                    txtArea.append("\nTotal Gaji : Rp"+Hasil.HitungB()+" PerBulan");
                } else if (pLembur.getSelectedIndex()== 2){
                    txtArea.append("\nTotal Gaji : Rp"+Hasil.HitungC()+" PerBulan");
                } else {
                    txtArea.append("\nGaji Lembur: Rp"+Hasil.HitungD()+" PerBulan");
                }
            }
        } else {
            if (pShif.getSelectedIndex()==0){
                txtArea.append("\nShif Kerja : "+Data.shif());
            } else {
                txtArea.append("\nShif Kerja : "+Data.shif("Malam"));
            }
        }
    }//GEN-LAST:event_btnProsesActionPerformed

    private void pCentangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pCentangActionPerformed
        // TODO add your handling code here:
        if (pCentang.isSelected()){
            pLembur.setEnabled(true);
        }
        else{
            pLembur.setEnabled(false);
        }
    }//GEN-LAST:event_pCentangActionPerformed

    private void pShifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pShifActionPerformed
        // TODO add your handling code here:
        if (pShif.getSelectedIndex()== 0){
            txtArea.setText(Data.shif());
        } else {
            txtArea.setText(Data.shif("Malam"));
        }
    }//GEN-LAST:event_pShifActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox pCentang;
    private javax.swing.JComboBox<String> pLembur;
    private javax.swing.JComboBox<String> pShif;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
