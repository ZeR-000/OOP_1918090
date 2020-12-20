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
public class Lembur extends Hitung{
    protected int hasil, total;
    
    @Override
    protected int hitung() {
        hasil = 160 * 25000;
        return hasil;
    }
    
    @Override
    protected int HitungA(){
        total = hitung() + (14 * 25000);
        return total;
    }
    protected int HitungB(){
        total = hitung() + (28 * 25000);
        return total;
    }
    protected int HitungC(){
        total = hitung() + (42 * 25000);
        return total;
    }
    protected int HitungD(){
        total = hitung() + (56 * 25000);
        return total;
    }
}
