/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TB_Perkantoran;

/**
 *
 * @author USER
 */
public class Karyawan {
    String NamaKar, NoKar, AlamatKar, ShifKerja;
    int GajiKar = 0 , LamaJamKerja ;

    
    void dataNamaKar(String NamaKar){
        this.NamaKar = NamaKar;
    }
    void dataNoKar(String NoKar){
        this.NoKar = NoKar;
    }
    void dataAlamatKar(String AlamatKar){
        this.AlamatKar = AlamatKar;
    }
    void dataShifKerja(String ShifKerja){
        this.ShifKerja = ShifKerja;
    }

    int dataLamaJamKerja(){
        LamaJamKerja = 7 ;
        return (GajiKar = GajiKar * LamaJamKerja);
    }
    
    String cetakNamaKar(){
        return NamaKar;
    }
    String cetakNoKar(){
        return NoKar;
    }
    String cetakAlamatKar(){
        return AlamatKar;
    }
    String cetakShifKerja(){
        return ShifKerja;
    }
}
