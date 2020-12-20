/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB4_Perkantoran;

/**
 *
 * @author USER
 */
public class Karyawan {
    private String id_kar, alamat_kar;
    public String nama_kar, shif_ker;
    
    // id
    public String getId_kar() {
        return id_kar;
    }
    public void setId_kar(String id_kar) {
        this.id_kar = id_kar;
    }
    
    // alamat
    public String getAlamat_kar() {
        return alamat_kar;
    }
    public void setAlamat_kar(String alamat_kar) {
        this.alamat_kar = alamat_kar;
    }
    
    // shif
    String shifA(){
        return this.shif_ker = "Pagi";
    }
    String shifB(){
        return this.shif_ker = "Malam";
    }
}