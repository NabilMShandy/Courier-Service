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
public class PaketExpress extends Paket {

    private int estimasiJam;
    protected final static double tarifExpress = 8000;

    public PaketExpress(String namaPenerima, String tujuan, double berat, String resi, String namaKurir, String namaEkspedisi, int estimasiJam) {
        super(namaPenerima, tujuan, berat, resi, namaKurir, namaEkspedisi);
        this.estimasiJam = estimasiJam;
    }
    
    public int getEstimasiJam(){
        return this.estimasiJam;
    }
    
    @Override
    public double hitungBiaya() {
    //  Jika berat > 15 Kg, berat sekarang dikurangi 15 lalu dikali tarif express
        if (getBerat() > 15) {
            return (getBerat() * this.tarifExpress) + ((getBerat() - 15) * this.tarifExpress);
        }
    // dibawah atau sama dengan 15, berat dikali tarif express
        else {
            return getBerat() * this.tarifExpress;
        }
    }

    @Override
    public void infoPaket() {
        System.out.println("=======================================================================================================================================================================================================================================");
        System.out.printf("Paket Express | Nama Pengirim: %-20s | Tujuan: %-20s | Berat: %.2f kg | Resi: %-18s | Nama Kurir: %-15s | Nama Ekspedisi: %-15s  | Estimasi Jam: %2d jam%n", getNamaPengirim(), getTujuan(), getBerat(), getKodeResi(), getNamaKurir(), getNamaEkspedisi(), getEstimasiJam());
        System.out.println("=======================================================================================================================================================================================================================================");
        System.out.println();
        System.out.println("Biaya pengiriman: Rp" + hitungBiaya());
        System.out.println("Paket terdaftar: " + Paket.paketTerdaftar);
        System.out.println();
    }
}