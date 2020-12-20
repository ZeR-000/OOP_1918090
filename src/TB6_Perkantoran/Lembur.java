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
public class Lembur extends Gaji{
    
    public int HitungA(){
        total = Hasil() + (14 * 25000);
        return total;
    }
    public int HitungB(){
        total = Hasil() + (28 * 25000);
        return total;
    }
    public int HitungC(){
        total = Hasil() + (42 * 25000);
        return total;
    }
    public int HitungD(){
        total = Hasil() + (56 * 25000);
        return total;
    }
}
