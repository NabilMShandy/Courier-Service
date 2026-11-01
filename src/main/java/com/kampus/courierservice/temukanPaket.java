/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;
import java.util.ArrayList;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class temukanPaket {
    
    // Refactor kode hanya 1 bentuk saja yakni mencari berdasarkan kode resi    
    public static void cari(String resi, ArrayList<Paket> daftarPaket) throws Exception{
        System.out.println("Mencari paket dengan kode resi: " + resi);

        boolean ketemu = false;

        for (int i = 0; i < daftarPaket.size(); i++) {
            if (daftarPaket.get(i).getTujuan().equalsIgnoreCase(resi)) {
                System.out.println("Paket dengan tujuan " + resi + " Ditemukan!");
                daftarPaket.get(i).infoPaket();
                ketemu = true;
            }
        }
        if (!ketemu) {throw new PaketTidakDitemukanException("Paket dengan kode resi " + resi + " tidak ditemukan pada sistem!");}
    }
}