/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author NABIL MUHAMMAD S
 */

// Induk Sistem
public class SistemEkspedisi {

    private String namaEkspedisi;

    private GudangEkspedisi gudangPaketHub;

    private ArrayList<Paket> daftarPaket;
    private HashMap<String, Pelanggan> daftarPelanggan;

    public SistemEkspedisi(String namaEkspedisi) {
        this.namaEkspedisi = namaEkspedisi;

        // Composition - bergantung mutlak pada class induk
        this.gudangPaketHub = new GudangEkspedisi("NGAWI HUB", 2000, 30000);
        this.daftarPaket = new ArrayList<>();
        this.daftarPelanggan = new HashMap<>();
    }

    public void deskripsiEkspedisi() {
        System.out.println("\nEkspedisi " + this.namaEkspedisi);
        gudangPaketHub.informasiGudang();
    }

    public void tambahPaket(Paket pa) {
        daftarPaket.add(pa);
        System.out.println("Berhasil menambahkan paket." + "(Total Paket: " + daftarPaket.size() + ")");
    }

    public void tambahPelanggan(Pelanggan pe) {
        daftarPelanggan.put(pe.getIdPelanggan(), pe);
        System.out.println("Pelanggan berhasil ditambahkan!");
    }

    public void lihatSemuaPaket() {
        if (daftarPaket.isEmpty()) {
            System.out.println("\nBelum ada paket ditambahkan.\n");
        } else {
            for (int i = 0; i < daftarPaket.size(); i++) {
                System.out.println((i + 1) + ". ");
                daftarPaket.get(i).infoPaket();
            }
        }
    }

    public void cariPaket(String resi) throws Exception {
        System.out.println("Mencari paket dengan kode resi: " + resi);

        boolean ketemu = false;

        for (int i = 0; i < daftarPaket.size(); i++) {
            if (daftarPaket.get(i).getKodeResi().equalsIgnoreCase(resi)) {
                System.out.println("Paket dengan tujuan " + resi + " Ditemukan!");
                daftarPaket.get(i).infoPaket();
                ketemu = true;
            }
        }
        if (!ketemu) {
            throw new PaketTidakDitemukanException("Paket dengan kode resi " + resi + " tidak ditemukan pada sistem!");
        }
    }

    public void cariPelanggan(String idPelanggan) {
        if (daftarPelanggan.containsKey(idPelanggan)) {
            System.out.println("ID ditemukan. -> [Nama: " + daftarPelanggan.get(idPelanggan).getNamaPelanggan() + "]");
        } else {
            System.out.println("Pelanggan tidak terdaftar.");
        }
    }

    public void lihatSemuaPelanggan() {
        System.out.println("Total pelanggan: " + daftarPelanggan.size());

        for (Pelanggan pe : daftarPelanggan.values()) {
            System.out.println("ID Pelanggan: " + pe.getIdPelanggan() + " | Nama: " + pe.getNamaPelanggan());
        }
    }

    public Pelanggan getPelanggan(String id) {
        return daftarPelanggan.get(id);
    }
    
    public Paket getPaket(int i){
        return daftarPaket.get(i);
    }
    
    public int getJumlahPaket(){
        return daftarPaket.size();
    }
}
