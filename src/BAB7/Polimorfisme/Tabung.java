/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB7.Polimorfisme;

/**
 *
 * @author USER
 */
public class Tabung extends Bentuk{
    int r = 3 ,t = 5;

    @Override
        double volume() {
        return ((3.14*r*r)*t);
    }
    @Override
        double luasPermukaan() {
        return ((2*3.14*r)*(r+t));
    }

}
