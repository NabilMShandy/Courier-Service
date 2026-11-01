/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.kampus.courierservice;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class CourierService {

    //    Runtime polymorphism
    public static void prosesPengirimanBarang(Paket barang) {
        barang.prosesPengiriman();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Array List
        ArrayList<Paket> daftarPaket = new ArrayList<>();

        // Hash Map
        HashMap<String, String> dataPelanggan = new HashMap<>();

        // Penerapan struktur dasar java
        int jumlahPaketSekarang = 0;
        boolean isRun = true;

        while (isRun) {
            
            // Implementasi try & catch            
            try {
                Text.Header();
                Text.Menu();

                int pilih = scan.nextInt();
                scan.nextLine();

                switch (pilih) {
                    case 1:
                        Text.pilihPaket();
                        
                        int pilihanPaket = scan.nextInt();
                        scan.nextLine();

                        if (pilihanPaket == 1) {
                            System.out.print("Masukkan nama penerima: ");
                            String namaPenerima = scan.nextLine();

                            System.out.print("Masukkan tujuan: ");
                            String tujuanKirim = scan.nextLine();

                            System.out.print("Masukkan berat (Kg) paket: ");
                            double beratPaket = scan.nextDouble();
                            scan.nextLine();

                            System.out.print("Masukkan resi paket: ");
                            String resiBarang = scan.nextLine();

                            System.out.print("Masukkan nama kurir: ");
                            String kurir = scan.nextLine();

                            System.out.print("Masukkan nama ekspedisi: ");
                            String ekspedisi = scan.nextLine();

                            System.out.print("Masukkan estimasi hari: ");
                            int estimasi = scan.nextInt();
                            scan.nextLine();

                            daftarPaket.add(new PaketReguler(namaPenerima, tujuanKirim, beratPaket, resiBarang,
                                    kurir, ekspedisi, estimasi));

                            // Memanggil interface untuk Paket Reguler                                      
                            if (daftarPaket.get(jumlahPaketSekarang) instanceof DapatDilacak) {
                                DapatDilacak barang = (DapatDilacak) daftarPaket.get(jumlahPaketSekarang);
                                barang.lacakPaket(resiBarang);
                            }

                            jumlahPaketSekarang++;
                            System.out.println("Berhasil ditambahkan!\n");

                        } else if (pilihanPaket == 2) {
                            System.out.print("Masukkan nama penerima: ");
                            String namaPenerima = scan.nextLine();

                            System.out.print("Masukkan tujuan: ");
                            String tujuanKirim = scan.nextLine();

                            System.out.print("Masukkan berat (Kg) paket: ");
                            double beratPaket = scan.nextDouble();
                            scan.nextLine();

                            System.out.print("Masukkan resi paket: ");
                            String resiBarang = scan.nextLine();

                            System.out.print("Masukkan nama kurir: ");
                            String kurir = scan.nextLine();

                            System.out.print("Masukkan nama ekspedisi: ");
                            String ekspedisi = scan.nextLine();

                            System.out.print("Masukkan estimasi jam: ");
                            int estimasiJam = scan.nextInt();
                            scan.nextLine();

                            daftarPaket.add(new PaketExpress(namaPenerima, tujuanKirim, beratPaket,
                                    resiBarang, kurir, ekspedisi, estimasiJam));

                            // Memanggil interface untuk Paket Express                     
                            if (daftarPaket.get(jumlahPaketSekarang) instanceof DapatDilacak) {
                                DapatDilacak barang = (DapatDilacak) daftarPaket.get(jumlahPaketSekarang);
                                barang.lacakPaket(resiBarang);
                            }

                            jumlahPaketSekarang++;
                            System.out.println("Berhasil ditambahkan!\n");

                        } else if (pilihanPaket == 3) {
                            System.out.print("Apakah satu kota? isi dengan true atau false: ");
                            boolean satuDomisili = scan.nextBoolean();

                            System.out.print("Masukkan jarak (Km) penerima dengan ekspedisi: ");
                            int jarakPenerima = scan.nextInt();
                            scan.nextLine();

                            System.out.print("Masukkan nama penerima: ");
                            String namaPenerima = scan.nextLine();

                            System.out.print("Masukkan tujuan: ");
                            String tujuanKirim = scan.nextLine();

                            System.out.print("Masukkan berat (Kg) paket: ");
                            double beratPaket = scan.nextDouble();
                            scan.nextLine();

                            System.out.print("Masukkan resi paket: ");
                            String resiBarang = scan.nextLine();

                            System.out.print("Masukkan nama kurir: ");
                            String kurir = scan.nextLine();

                            System.out.print("Masukkan nama ekspedisi: ");
                            String ekspedisi = scan.nextLine();

                            daftarPaket.add(new PaketSameDay(namaPenerima, tujuanKirim, beratPaket, resiBarang,
                                    kurir, ekspedisi, jarakPenerima, satuDomisili));

                            // Memanggil interface Paket Same Day                                    
                            if (daftarPaket.get(jumlahPaketSekarang) instanceof DapatDilacak) {
                                DapatDilacak barang = (DapatDilacak) daftarPaket.get(jumlahPaketSekarang);
                                barang.lacakPaket(resiBarang);
                            }
                            jumlahPaketSekarang++;
                            System.out.println("Berhasil ditambahkan!");

                        } else if (pilihanPaket == 4) {
                            System.out.print("Masukkan nama penerima: ");
                            String namaPenerima = scan.nextLine();

                            System.out.print("Masukkan tujuan negara: ");
                            String tujuanKirim = scan.nextLine();

                            System.out.print("Masukkan berat (Kg) paket: ");
                            double beratPaket = scan.nextDouble();
                            scan.nextLine();

                            System.out.print("Masukkan resi paket: ");
                            String resiBarang = scan.nextLine();

                            System.out.print("Masukkan nama kurir: ");
                            String kurir = scan.nextLine();

                            System.out.print("Masukkan nama ekspedisi: ");
                            String ekspedisi = scan.nextLine();

                            System.out.print("Masukkan biaya cukai: ");
                            double beaCukai = scan.nextDouble();
                            scan.nextLine();

                            daftarPaket.add(new PaketInternasional(namaPenerima, tujuanKirim, beratPaket, resiBarang,
                                    kurir, ekspedisi, beaCukai));

                            jumlahPaketSekarang++;
                            System.out.println("Berhasil ditambahkan!\n");

                        }
                        break;

                    case 2:
                        if (daftarPaket.isEmpty()) {
                            System.out.println("Tidak ada paket terdaftar!");
                        } else {
                            for (int i = 0; i < daftarPaket.size(); i++) {
                                daftarPaket.get(i).infoPaket();

                                // Pemanggilan runtime polymorphism, method akan dipanggil sesuai dari subclass yang lebih spesifik
                                prosesPengirimanBarang(daftarPaket.get(i));

                                // Memanggil interface DapatDibatalkan dan DapatDilacak
                                daftarPaket.get(i).deskripsiLayanan();
                                if (daftarPaket.get(i) instanceof DapatDibatalkan) {
                                    DapatDibatalkan barang = (DapatDibatalkan) daftarPaket.get(i);
                                    barang.dapatDibatalkan();
                                }
                            }
                        }
                        break;

                    case 3:
                        try {
                            System.out.println("\n ----- CARI KOLEKSI -----");
                            System.out.print("Masukkan kode resi paket : ");
                            String kodeResiDicari = scan.nextLine();
                            temukanPaket.cari(kodeResiDicari, daftarPaket);
                            
                        } catch (PaketTidakDitemukanException e) {
                            System.out.println("WARNING : " + e.getMessage());
                            
                        } finally {
                            System.out.println("---> Pencarian selesai <----");
                        }
                        break;

                    case 4:
                        Text.manajemenPelanggan();
                        int menuPelanggan = scan.nextInt();
                        scan.nextLine();
                        
                        if(menuPelanggan == 1){
                            System.out.print("Masukkan ID Pelanggan: ");
                            String idPelanggan = scan.nextLine();
                            System.out.print("Masukkan Nama Pelanggan: ");
                            String namaPelanggan = scan.nextLine();
                            
                            dataPelanggan.put(idPelanggan, namaPelanggan);
                            System.out.println("Pelanggan berhasil ditambahkan!");
                        }
                        else if(menuPelanggan == 2){
                            System.out.print("Masukkan ID Pelanggan yang dicari: ");
                            String idCari = scan.nextLine();
                            
                            if(dataPelanggan.containsKey(idCari)){
                                System.out.println("ID " + idCari + " ditemukan!");
                                System.out.println("Nama: " + dataPelanggan.get(idCari));
                            }
                            else{
                                System.out.println("Pelanggan tersebut tidak terdaftar!");
                            }
                            
                        }
                        else if(menuPelanggan == 3){
                            System.out.println("Pelanggan terdaftar: " + dataPelanggan.size());
                            
                            System.out.println("==== Menampilkan Seluruh Anggota ====");
                            for(String keyID : dataPelanggan.keySet()){
                                System.out.println("ID " + keyID + " | Nama: " + dataPelanggan.get(keyID));
                            }
                        }             
                        break;

                    case 5:
                        System.out.println("Keluar...");
                        isRun = false;
                        break;

                    default:
                        System.out.println("Masukan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Input tidak valid! Anda harus memasukkan angka!");
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("\n[SYSTEM ERROR] Terjadi kegagalan: " + e.getMessage());
            }
        }
        scan.close();
    }
}