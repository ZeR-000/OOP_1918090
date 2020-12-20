/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB5_Perkantoran;

/**
 *
 * @author USER
 */
public class Lembur extends Hitung{
    int a = 14, b = 28, c = 42, d = 56; 
    int gaji_lem = 25000, total;
       
    @Override
    int Hasil(){
        return total = gaji_lem * a;
    }    
    int Hasil2(){
        return total = gaji_lem * b;
    }
    int Hasil3(){
        return total = gaji_lem * c;
    }
    int Hasil4(){
        return total = gaji_lem * d;
    }
}