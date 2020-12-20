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
public class Hitung extends Gaji implements Lembur{

    @Override
    protected int Gaji() {
        hasil = 160 * uang;
        return hasil;
    }

    @Override
    public int HitungA() {
        total = hasil + (14 * uang);
        return total;
    }

    @Override
    public int HitungB() {
        total = hasil + (28 * uang);
        return total;
    }

    @Override
    public int HitungC() {
        total = hasil + (48 * uang);
        return total;
    }

    @Override
    public int HitungD() {
        total = hasil + (56 * uang);
        return total;
    }
}
