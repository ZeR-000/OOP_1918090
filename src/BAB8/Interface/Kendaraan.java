/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB8.Interface;

/**
 *
 * @author USER
 */
public interface Kendaraan {
    final static int alat_penggerak = 100;
    
    abstract String nama();
    abstract int jumlah_roda();
    abstract String lintasan();
}
