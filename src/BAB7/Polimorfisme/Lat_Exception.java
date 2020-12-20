/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB7.Polimorfisme;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Lat_Exception {
    public static void main(String[] args) {
    int a=0 ,b=10 ,hasil;

    try{
        hasil = b/a;
    }catch(ArithmeticException c){ 
        JOptionPane.showMessageDialog(null, "Nilai pembagi tidak boleh 0 !!", "Warning",2);
    }catch(NumberFormatException d){ 
        JOptionPane.showMessageDialog(null, "Karena pembaginya huruf !!", "Warning",2);
    }finally{
        System.out.println("Trimakasi sudah menjalankan program");
        }
    }
}
