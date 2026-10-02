/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;

/**
 *
 * @author NABIL MUHAMMAD S
 */
// Inhertance dari Paket
public class PaketSameDay extends Paket {

    private int jarakEkspedisi;
    private boolean satuKota;
    protected final static double tarifSameDay = 12000;

    public PaketSameDay(String namaPenerima, String tujuan, double berat, String resi, String namaKurir, String namaEkspedisi, int jarakEkspedisi, boolean satuKota) {
        super(namaPenerima, tujuan, berat, resi, namaKurir, namaEkspedisi);
        this.jarakEkspedisi = jarakEkspedisi;
        this.satuKota = satuKota;
    }

    public int getJarakEkspedisi() {
        return this.jarakEkspedisi;
    }

    public boolean isSatuKota() {
        return this.satuKota;
    }

    @Override
    public double hitungBiaya() {
//        Jika satu kota dengan ekspedisi dan jarak ekspedisi <= 10 dan > 0 hitung tarif same day dikali berat
        if (isSatuKota() && jarakEkspedisi <= 10 && jarakEkspedisi > 0) {
            return tarifSameDay * getBerat();
            
        } 
        
//        kalo jaraknya antara 10 sampe 15 km, tarif same day dikali berat + tarif same day
        else if (isSatuKota() && jarakEkspedisi > 10 && jarakEkspedisi <= 15) {
            return tarifSameDay * getBerat() + tarifSameDay;
        }
        
//        Kalau kedua kondisi diatas false, yang dijalanin ini
        return tarifSameDay * getBerat() + (0.5 * tarifSameDay);
    }

    @Override
    public void infoPaket() {
        System.out.println("=======================================================================================================================================================================================================================================");
        System.out.printf("Paket Reguler | Nama Pengirim: %-20s | Tujuan: %-20s | Berat: %.2f kg | Resi: %-18s | Nama Kurir: %-15s | Nama Ekspedisi: %-15s | Jarak Ekspedisi: %2d Km%n",
                getNamaPengirim(), getTujuan(), getBerat(), getKodeResi(), getNamaKurir(), getNamaEkspedisi(), getJarakEkspedisi());
        System.out.println("=======================================================================================================================================================================================================================================");
        System.out.println();
        System.out.println("Biaya pengiriman: Rp" + hitungBiaya());
        System.out.println("Paket terdaftar: " + Paket.paketTerdaftar);
        System.out.println();
    }

}