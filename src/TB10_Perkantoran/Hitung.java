/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB10_Perkantoran;

import TB8_Perkantoran.*;

/**
 *
 * @author USER
 */
public class Hitung extends Gaji implements Lembur{
    int lembur;
    @Override
    protected int Gaji() {
        hasil = 160 * uang;
        return hasil;
    }

    @Override
    public int HitungA() {
        total = lembur * uang;
        return total;
    }
}
