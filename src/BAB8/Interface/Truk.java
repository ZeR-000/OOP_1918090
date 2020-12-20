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
public class Truk implements Kendaraan{

    @Override
    public String nama() {
        return "Mesin";
    }

    @Override
    public int jumlah_roda() {
        return 8;
    }

    @Override
    public String lintasan() {
        return "ASpal";
    }
    
}
