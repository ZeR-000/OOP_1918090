/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB1.CLASSOBJECT;

/**
 *
 * @author USER
 */
public class KENDARAAN {
    String nama, warna; // atribut
    
    //method
    int jmlRoda(int jml){
        return jml;
    }
    void kendaraanMaju(){
        System.out.println("Berjalan ke depan");
    }
    void kendaraanMundur(){
        System.out.println("Berjalan ke belakang");
    }
    void kendaraanBerhenti(){
        System.out.println("Berhenti");
    }
}
