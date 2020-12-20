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
public class GUI_Gaji extends javax.swing.JFrame {
    String id1,lembur1;
    /**
     * Creates new form GUI_Gaji
     */
    public GUI_Gaji() {
        initComponents();
        txtLembur.setEnabled(false);
        tampil();
        tampil_ID();
    }
    public Connection conn;
    
    public void batal(){
        txtLembur.setText("");
        txtCari.setText("");
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
        tabelhead.addColumn("Lembur");
        tabelhead.addColumn("Gaji");
        tabelhead.addColumn("Gaji Lembur");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_gaji";
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
        new GUI_Gaji().setVisible(true);
        this.setVisible(false);
    }
    public void insert(){
        String Id = (String) cmbId.getSelectedItem();
        String Lembur = txtLembur.getText();
        Hitung HT = new Hitung();
        int Gaji = HT.Gaji();
        int GajiLembur = HT.total;
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_gaji(id, lembur, gaji, gaji_lembur)"
                                    +"VALUES('"+Id+"','"+Lembur+"','"+Gaji+"','"+GajiLembur+"')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Karyawan!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    public void update(){
        String Id = (String) cmbId.getSelectedItem();
        String Lembur = txtLembur.getText();
        Hitung HT = new Hitung();
        int Gaji = HT.Gaji();
        int GajiLembur = HT.total;
        txtLembur.setText(Integer.toString(HT.HitungA()));
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_gaji SET id='"+Id+"'," + "lembur='"+GajiLembur+"'"
                                    + ",gaji='"+Gaji+"',gaji_lembur='"+GajiLembur+"'WHERE nim = '"+Id+"'");
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
            String sql="DELETE FROM tb_gaji WHERE id='"+cmbId.getSelectedItem()+"'";
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
                String sql="SELECT * FROM tb_gaji WHERE `id`LIKE '%"+txtCari.getText()+"%'";
                ResultSet rs=statement.executeQuery(sql); //menampilkan data dari sql query
                if(rs.next()) // .next() = scanner method
            {
                cmbId.setSelectedItem(rs.getString(1));
                txtLembur.setText(rs.getString(2));
            }else{
                JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
            }
        }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "TerjadiKesalahan!");
        }
    }
    public void itempilih(){
        cmbId.setSelectedItem(id1);
        txtLembur.setText(lembur1);
    }
    public void tampil_ID(){
        try {
            koneksi();
            String sql = "SELECT id FROM tb_data order by id asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                cmbId.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        btnId = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        cmbId = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pCentang = new javax.swing.JCheckBox();
        txtLembur = new javax.swing.JTextField();
        btnProses = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Gaji Karyawan");

        btnId.setText("ID");
        btnId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "Lembur", "Gaji ", "Gaji Lembur"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        cmbId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Pilih ---" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Lembur");

        pCentang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCentangActionPerformed(evt);
            }
        });

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel2.setText("/Jam");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pCentang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtLembur, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCari)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUbah)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnBatal)))))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnId)
                            .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pCentang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtLembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(jLabel7))
                        .addGap(28, 28, 28)
                        .addComponent(btnProses)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbah)
                            .addComponent(btnHapus)
                            .addComponent(btnBatal))
                        .addGap(0, 19, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pCentangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pCentangActionPerformed
        // TODO add your handling code here:
        if (pCentang.isSelected()){
            txtLembur.setEnabled(true);
        }
        else{
            txtLembur.setEnabled(false);
            txtLembur.setText("0");
        }
    }//GEN-LAST:event_pCentangActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        
        Hitung HT = new Hitung();
        HT.lembur = (Integer.parseInt(txtLembur.getText()));
        
        if (pCentang.isSelected()){
            txtLembur.setText(Integer.toString(HT.HitungA()));
            HT.HitungA();
           // txtLembur.getText(HT.HitungA());
        } else {
            txtLembur.setText("0");
        }
        insert();
    }//GEN-LAST:event_btnProsesActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int tb = tabel.getSelectedRow();
        id1 = tabel.getValueAt(tb, 0).toString();
        lembur1 = tabel.getValueAt(tb, 1).toString();
        itempilih();
    }//GEN-LAST:event_tabelMouseClicked

    private void btnIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdActionPerformed
        // TODO add your handling code here:
        new GUI_Karyawan().setVisible(true);
    }//GEN-LAST:event_btnIdActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Gaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Gaji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnId;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox pCentang;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtLembur;
    // End of variables declaration//GEN-END:variables
}
