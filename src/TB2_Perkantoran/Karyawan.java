/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB2_Perkantoran;

/**
 *
 * @author USER
 */
public class Karyawan {
    String id_kar, nama_kar, alamat_kar, shif_ker;
    int jmlhari_ker, gaji_kar, hasil;
    
    public Karyawan(int masuk, int gaji){
        jmlhari_ker = masuk;
        gaji_kar = gaji;
        hasil = gaji_kar * masuk;
    }
    
    public Karyawan(String id, String nama, String alamat, String shif){
        id_kar = id;
        nama_kar = nama;
        alamat_kar = alamat;
        shif_ker = shif ;
    }
}
