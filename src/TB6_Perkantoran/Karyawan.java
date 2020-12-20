/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB6_Perkantoran;

/**
 *
 * @author USER
 */
public class Karyawan extends Data{

    @Override
    protected String shif() {
        return "Shif Pagi";
    }

    @Override
    protected String shif(String shif) {
        return "Shif Malam";
    }
}
