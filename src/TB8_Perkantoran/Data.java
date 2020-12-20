/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB8_Perkantoran;

/**
 *
 * @author USER
 */
public class Data {
    private String id_kar, alamat_kar;
    public String nama_kar;
    
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
    
    protected String shifA(){
        return "Shif Pagi";
    }
    protected String shifB(){
        return "Shif Malam";
    }
}
