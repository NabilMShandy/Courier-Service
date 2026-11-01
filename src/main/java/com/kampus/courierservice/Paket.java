/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;

/**
 *
 * @author NABIL MUHAMMAD S
 */
// Superclass
public abstract class Paket {

    // Encapsulation
    private String namaPenerima;
    private String tujuan;
    private double berat;
    private String resi;
    private String namaKurir;
    private String namaEkspedisi;

    public static int paketTerdaftar = 0;

//    Constructor
    public Paket(String namaPenerima, String tujuan, double berat, String resi, String namaKurir, String namaEkspedisi) throws Exception {

        if (berat <= 0 || resi == null || resi.trim().isEmpty()) {
            throw new Exception("[ERROR] Terdapat kesalahan input pada berat atau resi");
        }

        setNamaPengirim(namaPenerima);
        setTujuan(tujuan);
        setBerat(berat);
        setResi(resi);
        setNamaKurir(namaKurir);
        setNamaEkspedisi(namaEkspedisi);
        paketTerdaftar++;
    }

//    Setter
    public void setNamaPengirim(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public void setBerat(double berat) throws Exception {
        if (berat <= 0) {
            throw new Exception("Berat yang dimasukkan salah!");
        } else {
            this.berat = berat;
        }
    }

//    Setter
    public void setResi(String resi) {
        if (resi == null || resi.trim().isEmpty()) {
            throw new IllegalArgumentException("Kesalahan input resi!");
        }
        this.resi = resi;
    }

    public void setNamaKurir(String namaKurir) {
        this.namaKurir = namaKurir;
    }

    public void setNamaEkspedisi(String namaEkspedisi) {
        this.namaEkspedisi = namaEkspedisi;
    }

//    Getter
    public String getNamaPengirim() {
        return this.namaPenerima;
    }

    public String getTujuan() {
        return this.tujuan;
    }

    public double getBerat() {
        return this.berat;
    }

    public String getKodeResi() {
        return this.resi;
    }

    public String getNamaKurir() {
        return this.namaKurir;
    }

    public String getNamaEkspedisi() {
        return this.namaEkspedisi;
    }

//    Akan dioverride
    public abstract void infoPaket();

    public abstract double hitungBiaya();

    public abstract void prosesPengiriman();

    public abstract void deskripsiLayanan();
}
