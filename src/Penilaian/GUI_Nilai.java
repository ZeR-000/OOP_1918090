/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Penilaian;
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
public class GUI_Nilai extends javax.swing.JFrame {
    String nim1,kd_mk1,n1,n2,n3;
    /**
     * Creates new form GUI_Nilai
     */
    public GUI_Nilai() {
        initComponents();
        tampil();
        tampil_mhs();
        tampil_mk(); 
        txtNP.setEnabled(false);
    }
    public Connection conn;
    public void batal(){
        txtNT.setText("");
        txtNP.setText("");
        txtNA.setText("");
    }
    public void koneksi() throws SQLException {
        try {
            conn=null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/oop_1918090?user=root&password=");
        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(GUI_Nilai.class.getName()).log(Level.SEVERE,null,ex);
        }
        catch (SQLException e) {
            Logger.getLogger(GUI_Nilai.class.getName()).log(Level.SEVERE,null,e);
        }
        catch (Exception es) {
            Logger.getLogger(GUI_Nilai.class.getName()).log(Level.SEVERE,null,es);
        }
    }
    public void tampil() {
    DefaultTableModel tabelhead = new DefaultTableModel();
    tabelhead.addColumn("NIM");
    tabelhead.addColumn("Kode MK");
    tabelhead.addColumn("NT");
    tabelhead.addColumn("NP");
    tabelhead.addColumn("NA");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_nilai";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
            tabelhead.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3)
                    ,res.getString(4), res.getString(5),});
        }
        tabel_data.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    public void refresh(){
        new GUI_Nilai().setVisible(true);
        this.setVisible(false);
    }
    public void insert(){
        String Nim = (String) cmbNim.getSelectedItem();
        String KodeMK = (String) cmbKodeMK.getSelectedItem();
        String NT = txtNT.getText();
        String NP = txtNP.getText();
        String NA = txtNA.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_nilai(nim, kode_mk, n_tugas,n_prak,n_akhir)" +"VALUES('"+Nim+"','"+KodeMK+"','"+NT+"','"+NP+"','"+NA+"')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Nilai!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    public void update(){
        String Nim = (String) cmbNim.getSelectedItem();
        String KodeMK = (String) cmbKodeMK.getSelectedItem();
        String NT = txtNT.getText();
        String NP = txtNP.getText();
        String NA = txtNA.getText();

        String nim_lama = nim1;
        String kode_lama = kd_mk1;

        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_nilai SET nim='"+Nim+"'," + "kode_mk='"
                                    +KodeMK+"'"+",n_tugas='"+NT+"',n_prak='"+NP+"',n_akhir='"
                                    +NA+"' WHERE nim ='"+nim_lama+"' AND kode_mk='"+kode_lama+"'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Nilai!");
        } catch (Exception e) {
            System.out.println("Error : "+e);
        }
        refresh();
    }
    public void delete(){
        int ok =JOptionPane.showConfirmDialog(null,"Apakah Anda yakin akan menghapus data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            try{
                String sql="DELETE FROM tb_nilai WHERE nim='"+cmbNim.getSelectedItem()+"' AND kode_mk='"+cmbKodeMK.getSelectedItem()+"'";
                PreparedStatement stmt = conn.prepareStatement(sql);
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
            String sql="SELECT * FROM tb_nilai WHERE `nim` LIKE'%"+txtCari.getText()+"%'";
            ResultSet rs = statement.executeQuery(sql);
           //menampilkan data dari sql query
                if(rs.next()) // .next() = scanner method
                {
                    cmbNim.setSelectedItem(rs.getString(1));
                    cmbKodeMK.setSelectedItem(rs.getString(2));
                    txtNT.setText(rs.getString(3));
                    txtNP.setText(rs.getString(4));
                    txtNA.setText(rs.getString(5));
                }else{
                JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        }catch (Exception ex){
            System.out.println("Error."+ex);
        }
    }
    void itempilih(){
        cmbNim.setSelectedItem(nim1);
        cmbKodeMK.setSelectedItem(kd_mk1);
        txtNT.setText(n1);
        txtNP.setText(n2);
        txtNA.setText(n3);
    }
    public void tampil_mhs(){
        try {
            koneksi();
            String sql = "SELECT nim FROM tb_mahasiswa order by nim asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                cmbNim.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void tampil_mk(){
        try {
            koneksi();
            String sql = "SELECT kode_mk FROM tb_matkul order by kode_mk asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                cmbKodeMK.addItem((String) ob[0]);
            }
            res.close(); stt.close();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNT = new javax.swing.JTextField();
        txtNP = new javax.swing.JTextField();
        cek_prak = new javax.swing.JCheckBox();
        btnNA = new javax.swing.JButton();
        btnNIM = new javax.swing.JButton();
        btnkodeMK = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNA = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        cmbNim = new javax.swing.JComboBox<>();
        cmbKodeMK = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PROGRAM PENILAIAN");

        jLabel4.setText("Nilai Tugas");

        jLabel5.setText("Nilai Praktikum");

        cek_prak.setText("Praktikum");
        cek_prak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cek_prakActionPerformed(evt);
            }
        });

        btnNA.setText("Proses");
        btnNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNAActionPerformed(evt);
            }
        });

        btnNIM.setText("NIM");
        btnNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNIMActionPerformed(evt);
            }
        });

        btnkodeMK.setText("Kode MK");
        btnkodeMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkodeMKActionPerformed(evt);
            }
        });

        jLabel6.setText("Nilai Ahkir");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIM", "Kode MK", "NT", "NP", "NA"
            }
        ));
        tabel_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_data);

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

        cmbNim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--NIM--" }));

        cmbKodeMK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Kode MK--" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 443, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(191, 191, 191)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(5, 5, 5))
                                                .addComponent(btnkodeMK, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cek_prak)
                                            .addComponent(txtNT)
                                            .addComponent(txtNP)
                                            .addComponent(cmbKodeMK, 0, 124, Short.MAX_VALUE)
                                            .addComponent(cmbNim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(txtNA, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNIM)
                            .addComponent(cmbNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnkodeMK)
                            .addComponent(cmbKodeMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(cek_prak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(btnNA)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnSimpan))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbah)
                            .addComponent(btnHapus)
                            .addComponent(btnBatal))))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cek_prakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cek_prakActionPerformed
        // TODO add your handling code here:
        if (cek_prak.isSelected()){
            txtNP.setEnabled(true);
        }
        else{
            txtNP.setEnabled(false);
        }
    }//GEN-LAST:event_cek_prakActionPerformed

    private void btnNAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNAActionPerformed
        // TODO add your handling code here:
        Penilaian nilai; // instansiasi
       //objek nilai di instansiasi ulang dengan sub class
        nilai = new Penilaian_NonPrak();   
       if (cek_prak.isSelected()){
           nilai.nilaiTugas = Integer.parseInt(txtNT.getText());
           nilai.nilaiPrak = Integer.parseInt(txtNP.getText());
           txtNA.setText(Double.toString(nilai.tampilNA()));
           
       }else {
           nilai.nilaiTugas = Integer.parseInt(txtNT.getText());
           txtNP.setText("0");
           txtNA.setText(Double.toString(nilai.nilaiAkhir()));
       }
    }//GEN-LAST:event_btnNAActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void tabel_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataMouseClicked
        // TODO add your handling code here:
        int tabel = tabel_data.getSelectedRow(); //0
        nim1 = tabel_data.getValueAt(tabel, 0).toString();
        kd_mk1 = tabel_data.getValueAt(tabel, 1).toString();
        n1 = tabel_data.getValueAt(tabel, 2).toString();
        n2 = tabel_data.getValueAt(tabel, 3).toString();
        n3 = tabel_data.getValueAt(tabel, 4).toString();
        itempilih();
    }//GEN-LAST:event_tabel_dataMouseClicked

    private void btnNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNIMActionPerformed
        // TODO add your handling code here:
        new GUI_Mahasiswa().setVisible(true);
    }//GEN-LAST:event_btnNIMActionPerformed

    private void btnkodeMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkodeMKActionPerformed
        // TODO add your handling code here:
        new GUI_Nilai().setVisible(true);
    }//GEN-LAST:event_btnkodeMKActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnNA;
    private javax.swing.JButton btnNIM;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnkodeMK;
    private javax.swing.JCheckBox cek_prak;
    private javax.swing.JComboBox<String> cmbKodeMK;
    private javax.swing.JComboBox<String> cmbNim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_data;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNA;
    private javax.swing.JTextField txtNP;
    private javax.swing.JTextField txtNT;
    // End of variables declaration//GEN-END:variables
}
