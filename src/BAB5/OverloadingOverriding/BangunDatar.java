/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB5.OverloadingOverriding;

/**
 *
 * @author USER
 */
public class BangunDatar {
    //method yang akan di overriding
    public double Luas(double p, double l){
        return (p*l);
        }
    public double Luas(double r){
        return (2*3.14*r);
    }
}
