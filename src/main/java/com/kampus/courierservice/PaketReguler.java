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
public class PaketReguler extends Paket implements DapatDibatalkan, DapatDilacak {

    private int estimasiHari;
    protected final static double tarifReguler = 5000;

    public PaketReguler(String namaPenerima, String tujuan, double berat, String resi, String namaKurir, String namaEkspedisi, int estimasiHari) throws Exception {
        if(berat <= 0 || estimasiHari <= 0 || resi == null || resi.trim().isEmpty()){
            throw new Exception("[ERROR] Input berat atau estimasi hari tidak valid!");
        }
        super(namaPenerima, tujuan, berat, resi, namaKurir, namaEkspedisi);
        this.estimasiHari = estimasiHari;
    }

    public int getEstimasiHari() {
        return this.estimasiHari;
    }

    @Override
    public double hitungBiaya() {
//        Jika berat >= 15 Kg, mendapat diskon 80%
        if (getBerat() >= 15) {
            return (getBerat() * this.tarifReguler) * 0.8;
        } //        dibawah 15 Kg, 5000 perkilo
        else {
            return getBerat() * this.tarifReguler;
        }
    }

    @Override
    public void infoPaket() {
        System.out.println("=======================================================================================================================================================================================================================================");
        System.out.printf("Paket Reguler | Nama Penerima: %-20s | Tujuan: %-20s | Berat: %.2f kg | Resi: %-18s | Nama Kurir: %-15s | Nama Ekspedisi: %-15s | Estimasi Hari: %2d hari%n",
                getNamaPengirim(), getTujuan(), getBerat(), getKodeResi(), getNamaKurir(), getNamaEkspedisi(), getEstimasiHari());
        System.out.println("=======================================================================================================================================================================================================================================");
        System.out.println();
        System.out.println("Biaya pengiriman: Rp" + hitungBiaya());
        System.out.println("Paket terdaftar: " + Paket.paketTerdaftar);
        System.out.println();
    }

    @Override
    public void prosesPengiriman() {
        System.out.println("Paket Reguler dikirim menggunakan mobil pengantar paket biasa dan melalui jalur laut jika berbeda provinsi.\n");
        System.out.println("=======================================================================================================================================================================================================================================\n");
    }

    @Override
    public void deskripsiLayanan() {
        System.out.println("Layanan reguler dengan biaya ekonomis.");
    }

    @Override
    public void dapatDibatalkan() {
        System.out.println("Dapat dibatalkan selagi belum diantar ekspedisi.\n");
    }

    @Override
    public void lacakPaket(String resi) {
        System.out.println("\n========== PELACAKAN PAKET ==========");
        System.out.println("Nomor Resi : " + getKodeResi());
        System.out.println("Status     : Paket sedang diantar menggunakan kendaraan reguler.");
        System.out.println("Informasi  : Paket Reguler dapat dilacak secara real-time melalui aplikasi.");
        System.out.println("=====================================");
    }
}
