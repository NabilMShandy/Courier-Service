/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class PaketInternasional extends Paket implements DapatDibatalkan {

    private double biayaCukai;

    public PaketInternasional(String namaPenerima, String tujuan, double berat, String resi, String namaKurir, String namaEkspedisi, double biayaCukai) {
        super(namaPenerima, tujuan, berat, resi, namaKurir, namaEkspedisi);
        setBiayaCukai(biayaCukai);
    }

    public double getBiayaCukai() {
        return this.biayaCukai;
    }

    public void setBiayaCukai(double biayaCukai) {
        this.biayaCukai = biayaCukai;
    }

    @Override
    public double hitungBiaya() {
        // Jika paket internasional, kali berat dengan 20 ribu + biaya cukai
        return getBerat() * 20000 + getBiayaCukai();
    }

    @Override
    public void infoPaket() {
        System.out.println("=======================================================================================================================================================================================================================================");
        System.out.printf("Paket Internasional | Nama Penerima: %-20s | Tujuan: %-20s | Berat: %.2f kg | Resi: %-18s | Nama Kurir: %-15s | Nama Ekspedisi: %-15s | Biaya Cukai: %.2f Rp%n",
                getNamaPengirim(), getTujuan(), getBerat(), getKodeResi(), getNamaKurir(), getNamaEkspedisi(), getBiayaCukai());
        System.out.println("=======================================================================================================================================================================================================================================");
        System.out.println();
        System.out.println("Biaya pengiriman: Rp" + hitungBiaya());
        System.out.println("Paket terdaftar: " + Paket.paketTerdaftar);
        System.out.println();
    }

    @Override
    public void dapatDibatalkan() {
        System.out.println("Paket Internasional tidak dapat dibatalkan!");
    }

    @Override
    public void deskripsiLayanan() {
        System.out.println("Layanan paket internasional dengan tambahan biaya bea cukai.");
    }

    @Override
    public void prosesPengiriman() {
        System.out.println("Paket internasional akan dikirim melalui jalur laut dan udara.\n");
        System.out.println("=======================================================================================================================================================================================================================================\n");
    }
}
