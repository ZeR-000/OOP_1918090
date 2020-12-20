/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB4.Inheritance;

/**
 *
 * @author USER
 */
public abstract class Segitiga {
    double alas, tinggi, luas;
    double Luas(){
        luas = 0.5*(alas*tinggi);
        return luas;
    }
    abstract double Volume();
}
