/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB4_Perkantoran;

/**
 *
 * @author USER
 */
public class Lembur extends Hitung{
    int a = 14, b = 28, c = 42, d = 56; 
    int gaji_lem = 25000, total;
       
    int lemburA(){
        return total = this.Hasil() + (gaji_lem * a);
    }    
    int lemburB(){
        return total = this.Hasil() + (gaji_lem * b);
    }
    int lemburC(){
        return total = this.Hasil() + (gaji_lem * c);
    }
    int lemburD(){
        return total = this.Hasil() + (gaji_lem * d);
    }
}