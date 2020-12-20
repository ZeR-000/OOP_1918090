/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB3_Perkantoran;

/**
 *
 * @author USER
 */
public class Karyawan {
    private String id_kar, alamat_kar, shif_ker;
    public String nama_kar;
    public int jmlhari_ker;
    private int gaji_kar, hasil;
    
    public Karyawan(){
        id_kar = " ";
        nama_kar = " ";
        alamat_kar = " ";
        shif_ker = " " ;
    }
    
    public Karyawan(int masuk, int gaji){
        jmlhari_ker = masuk;
        gaji_kar = gaji;
    }
    
    public Karyawan(int hasil){
        this.hasil = hasil;
    }
    
    public void innama (String nama){
        nama_kar = nama;
    }
    public String outnama(){
        return nama_kar;
    }
    
    public int outhari(){
        return jmlhari_ker;
    }
    
    //set punya strin
    public void setId_kar(String id_kar) {
        this.id_kar = id_kar;
    }
    public void setAlamat_kar(String alamat_kar) {
        this.alamat_kar = alamat_kar;
    }
    public void setShif_ker(String shif_ker) {
        this.shif_ker = shif_ker;
    }
    
    //get puynya string
    public String getId_kar() {
        return id_kar;
    }
    public String getAlamat_kar() {
        return alamat_kar;
    }
    public String getShif_ker() {
        return shif_ker;
    }
    
    //set punya int
    public void setGaji_kar(int gaji_kar) {
        this.gaji_kar = gaji_kar;
    }

    //get punya int
    public int getHasil() {
        return gaji_kar*jmlhari_ker;
    }
    
}
