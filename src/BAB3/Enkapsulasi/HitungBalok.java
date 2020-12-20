/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB3.Enkapsulasi;

/**
 *
 * @author USER
 */
public class HitungBalok {
    public double panjang, lebar, tinggi;
    double volume;
    
    private double volumeBalok(){
        return panjang * lebar *tinggi;
    }
    public double tampilBalok(){
        return volumeBalok();
    }
}
