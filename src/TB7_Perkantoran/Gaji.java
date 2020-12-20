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
public class Gaji extends Hitung{
    protected int hasil;

    @Override
    protected int hitung() {
        hasil = 160 * 25000;
        return hasil;
    }

    @Override
    protected int HitungA() {
       return 0;
    }

    @Override
    protected int HitungB() {
        return 0;
    }

    @Override
    protected int HitungC() {
        return 0;
    }

    @Override
    protected int HitungD() {
        return 0;
    }
}
