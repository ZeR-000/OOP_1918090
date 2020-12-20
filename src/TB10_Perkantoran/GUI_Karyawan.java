/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB10_Perkantoran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USER
 */
public class GUI_Karyawan extends javax.swing.JFrame {
    String id1,nama1,alamat1,shif1;
    /**
     * Creates new form GUI_Karyawan
     */
    public GUI_Karyawan() {
        initComponents();
        tampil();
    }
    public Connection conn;
    
    public void batal(){
        txtId.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
    }
    public void koneksi() throws SQLException {
        try {
        conn=null;
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost/karyawan?user=root&password=");
        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(GUI_Karyawan.class.getName()).log(Level.SEVERE,null, ex);
        }
        catch (SQLException e) {
            Logger.getLogger(GUI_Karyawan.class.getName()).log(Level.SEVERE,null, e);
        }
        catch (Exception es) {
            Logger.getLogger(GUI_Karyawan.class.getName()).log(Level.SEVERE,null, es);
        }
    }
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("ID Karyawan");
        tabelhead.addColumn("Nama Karyawan");
        tabelhead.addColumn("Alamat Karyawana");
        tabelhead.addColumn("Shif Kerja");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_data";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
        while(res.next()){
            tabelhead.addRow(new
            Object[]{res.getString(1),res.getString(2),res.getString(3),
            res.getString(4),});
        }
        tabel.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    public void refresh(){
        new GUI_Karyawan().setVisible(true);
        this.setVisible(false);
    }
    public void insert(){
        String Id = txtId.getText();
        String Nama = txtNama.getText();
        String Alamat = txtAlamat.getText();
        String Shif = (String) cmbShif.getSelectedItem();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_data(id, nama, alamat, shif)"
                                    +"VALUES('"+Id+"','"+Nama+"','"+Alamat+"','"+Shif+"')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Karyawan!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    public void update(){
        String Id = txtId.getText();
        String Nama = txtNama.getText();
        String Alamat = txtAlamat.getText();
        String Shif = (String) cmbShif.getSelectedItem();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_data SET id='"+Id+"'," + "nama='"+Nama+"'"
                                    + ",alamat='"+Alamat+"',shif='"+Shif+"'WHERE id = '"+Id+"'");
            statement.close();
        conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Karyawan!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan!");
        }
        refresh();
    }
    public void delete(){
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin akan menghapus data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(ok==0){
        try{
            String sql="DELETE FROM tb_data WHERE id='"+txtId.getText()+"'";
            java.sql.PreparedStatement
            stmt=conn.prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil di hapus");
            batal();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data gagal di hapus");
            }
        }
        refresh();
    }
    public void cari(){
        try{
            try (Statement statement = conn.createStatement()) {
                String sql="SELECT * FROM tb_data WHERE `id`LIKE '%"+txtCari.getText()+"%'";
                ResultSet rs=statement.executeQuery(sql); //menampilkan data dari sql query
                if(rs.next()) // .next() = scanner method
            {
                txtId.setText(rs.getString(1));
                txtNama.setText(rs.getString(2));
                txtAlamat.setText(rs.getString(3));
                cmbShif.setSelectedItem(rs.getString(4));
            }else{
                JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
            }
        }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "TerjadiKesalahan!");
        }
    }
    public void itempilih(){
        txtId.setText(id1);
        txtNama.setText(nama1);
        txtAlamat.setText(alamat1);
        cmbShif.setSelectedItem(shif1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProses = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtCari = new javax.swing.JTextField();
        cmbShif = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtUbah = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtHapus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtBatal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnProses.setText("PROSES");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        cmbShif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagi", "Malam" }));
        cmbShif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbShifActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("DATA KARYAWAN");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID Karyawan");

        txtUbah.setText("Ubah");
        txtUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUbahActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Alamat Karyawan");

        txtHapus.setText("Hapus");
        txtHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHapusActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama Karywan");

        txtBatal.setText("Batal");
        txtBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBatalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Shif Kerja");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "Nama Karyawan", "Alamat Karyawan", "Shif Kerja"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(txtAlamat)
                                    .addComponent(txtId)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnProses, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(75, 75, 75)
                                    .addComponent(cmbShif, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtUbah)
                                .addGap(31, 31, 31)
                                .addComponent(txtHapus)
                                .addGap(28, 28, 28)
                                .addComponent(txtBatal)
                                .addGap(216, 216, 216))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnCari)
                                .addGap(73, 73, 73))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBatal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUbah)
                                .addComponent(txtHapus)))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbShif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(btnProses)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUbahActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_txtUbahActionPerformed

    private void txtHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_txtHapusActionPerformed

    private void txtBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_txtBatalActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int tb = tabel.getSelectedRow();
        id1 = tabel.getValueAt(tb, 0).toString();
        nama1 = tabel.getValueAt(tb, 1).toString();
        alamat1 = tabel.getValueAt(tb, 2).toString();
        shif1 = tabel.getValueAt(tb, 3).toString();
        itempilih();
    }//GEN-LAST:event_tabelMouseClicked

    private void cmbShifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbShifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbShifActionPerformed

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
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnProses;
    private javax.swing.JComboBox<String> cmbShif;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JButton txtBatal;
    private javax.swing.JTextField txtCari;
    private javax.swing.JButton txtHapus;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JButton txtUbah;
    // End of variables declaration//GEN-END:variables
}
