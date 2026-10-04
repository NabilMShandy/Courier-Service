/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;

import java.lang.classfile.Opcode;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class temukanPaket {
    // Akan di overload
    public static void cari(String tujuan, Paket[] cariPaket, int jumlahPaketTerdaftar) {
        System.out.println("Mencari paket dengan tujuan: " + tujuan);

        boolean ketemu = false;

        for (int i = 0; i < jumlahPaketTerdaftar; i++) {
            if (cariPaket[i].getTujuan().equalsIgnoreCase(tujuan)) {
                cariPaket[i].infoPaket();
                ketemu = true;
            }
        }
        if (!ketemu) {System.out.println("Paket dengan tujuan " + tujuan + " tidak ditemukan!");}
    }

    //    Overloading method cari
    public static void cari(double berat, Paket[] cariPaket, int jumlahPaketTerdaftar) {
        boolean ketemu = false;
        for (int i = 0; i < jumlahPaketTerdaftar; i++) {
            if (cariPaket[i].getBerat() == berat) {
                cariPaket[i].infoPaket();
                ketemu = true;
            }
        }
        if (!ketemu) {System.out.println("Paket dengan berat " + berat + " Kg tidak ditemukan!");}
    }
    
    //    Method cari paling spesifik berdasarkan resi
    public static void car(String resi, Paket[] cariPaket, int jumlahPaketTerdaftar, String tujuan){
        System.out.println("Mencari paket dengan resi: " + resi);
        
        boolean ketemu = false;
        
        for(int i = 0; i < jumlahPaketTerdaftar; i++){
            if(cariPaket[i].getKodeResi().equalsIgnoreCase(resi)){
                cariPaket[i].infoPaket();
                ketemu = true;
            }
        }
        
        if(!ketemu){System.out.println("Tidak ada paket dengan resi " + resi);}
    }
}
