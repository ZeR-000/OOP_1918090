/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB8.Interface;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        LaskarPelangi LP = new LaskarPelangi();
        
        System.out.println("Judul = ");LP.judul();
        System.out.println("Tahun = ");LP.tahun();
        System.out.println("Pengarang = ");LP.pengarang();
        System.out.println("Penerbit = ");LP.nama_penerbit();
        System.out.println("Kota = ");LP.kota();
        System.out.println("Jumlah Halaman = " +Integer.toString(Buku.halaman)+"Halaman");
        System.out.println("Negara = "+Penerbit.negara);
    }
}
