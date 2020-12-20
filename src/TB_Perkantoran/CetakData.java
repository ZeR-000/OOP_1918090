/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_Perkantoran;

import Penilaian.Mahasiswa;

/**
 *
 * @author USER
 */
public class CetakData {
    public static void main(String[] args){
        Karyawan DataKar = new Karyawan();
     //ketika akan menggunakan method dari class Mahasiswa maka harus menyertakan nama object
    DataKar.dataNamaKar("Restu Febri Ahmad Raihan");
    DataKar.dataNoKar("03052005");
    DataKar.dataAlamatKar("Kepanjen, Malang");
    DataKar.dataShifKerja("Pagi");

    System.out.println("Data  Karyawan");
    System.out.println("------------------------------------");
    System.out.println("Nama Karyawan   : "+ DataKar.cetakNamaKar());
    System.out.println("No Karyawan     : "+ DataKar.cetakNoKar());
    System.out.println("Alamat Karyawan : "+ DataKar.cetakAlamatKar());
    System.out.println("Shif Kerja      : "+ DataKar.cetakShifKerja());
    }
}
