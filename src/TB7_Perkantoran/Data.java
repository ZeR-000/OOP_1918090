/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB7_Perkantoran;

/**
 *
 * @author USER
 */
public abstract class Data {
    private String alamat_kar;
    public String nama_kar;
    int id_kar;
    
    // id
    public int getId_kar() {
        return id_kar;
    }
    public void setId_kar(int id_kar) {
        this.id_kar = id_kar;
    }
    
    // alamat
    public String getAlamat_kar() {
        return alamat_kar;
    }
    public void setAlamat_kar(String alamat_kar) {
        this.alamat_kar = alamat_kar;
    }
    
    protected abstract String shif();
    protected abstract String shif(String shif);
}
