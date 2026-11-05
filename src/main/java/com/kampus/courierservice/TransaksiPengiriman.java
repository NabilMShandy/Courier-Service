/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;

/**
 *
 * @author NABIL MUHAMMAD S
 */

// Asosiasi
public class TransaksiPengiriman {

    public static void prosesKirim(Pelanggan pelanggan, Paket paket) {
        System.out.println("\n ===== INFORMASI PENGIRIMAN =====");
        System.out.println("Penerima        : " + pelanggan.getNamaPelanggan() + " | ID Pelanggan : " + pelanggan.getIdPelanggan());
        System.out.println("Paket           : " + paket.getKodeResi());
        System.out.println("Status          : Berhasil tercatat.");
        
        if(paket instanceof DapatDilacak){
            ((DapatDilacak) paket).lacakPaket(paket.getKodeResi());
        }
        
        System.out.println("======================================");
    }
}
