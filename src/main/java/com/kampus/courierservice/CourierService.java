/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.kampus.courierservice;

import java.util.Scanner;
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

        SistemEkspedisi ngawiHub = new SistemEkspedisi("Ngawi Hub");
        ngawiHub.deskripsiEkspedisi();

        // Penerapan struktur dasar java
        boolean isRun = true;

        while (isRun) {

            // Implementasi try & catch            
            try {
                Text.Header();
                Text.Menu();

                int pilih = scan.nextInt();
                scan.nextLine();

                switch (pilih) {
                    case 1 -> {
                        Text.pilihPaket();

                        int pilihanPaket = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Masukkan ID Pelanggan: ");
                        String idPelanggan = scan.nextLine();

                        System.out.print("Masukkan tujuan: ");
                        String tujuanKirim = scan.nextLine();

                        System.out.print("Masukkan berat (Kg) paket: ");
                        double beratPaket = scan.nextDouble();
                        scan.nextLine();

                        System.out.print("Masukkan resi paket (wajib): ");
                        String resiBarang = scan.nextLine();

                        System.out.print("Masukkan nama kurir (opsional): ");
                        String kurir = scan.nextLine();

                        System.out.print("Masukkan nama ekspedisi: ");
                        String ekspedisi = scan.nextLine();

                        if (pilihanPaket == 1) {

                            System.out.print("Masukkan estimasi hari: ");
                            ngawiHub.tambahPaket(new PaketReguler(idPelanggan, tujuanKirim, beratPaket, resiBarang,
                                    kurir, ekspedisi, scan.nextInt()));

                            System.out.println("Berhasil ditambahkan!\n");
                        } 
                        else if (pilihanPaket == 2) {

                            System.out.print("Masukkan estimasi jam: ");

                            ngawiHub.tambahPaket(new PaketExpress(idPelanggan, tujuanKirim, beratPaket,
                                    resiBarang, kurir, ekspedisi, scan.nextInt()));

                            System.out.println("Berhasil ditambahkan!\n");

                        }
                        else if (pilihanPaket == 3) {

                            System.out.print("Masukkan jarak (Km) penerima dengan ekspedisi: ");
                            int jarakPenerima = scan.nextInt();
                            scan.nextLine();

                            System.out.print("Apakah satu kota? isi dengan true atau false: ");
                            boolean satuDomisili = scan.nextBoolean();

                            ngawiHub.tambahPaket(new PaketSameDay(idPelanggan, tujuanKirim, beratPaket, resiBarang,
                                    kurir, ekspedisi, jarakPenerima, satuDomisili));

                            System.out.println("Berhasil ditambahkan!\n");

                        } 
                        else if (pilihanPaket == 4) {

                            System.out.print("Masukkan biaya cukai: ");
                            double beaCukai = scan.nextDouble();
                            scan.nextLine();

                            ngawiHub.tambahPaket(new PaketInternasional(idPelanggan, tujuanKirim, beratPaket, resiBarang,
                                    kurir, ekspedisi, beaCukai));

                            System.out.println("Berhasil ditambahkan!\n");

                        }
                        else{
                            System.out.println("[ERROR] Input tidak valid.");
                        }
                    }

                    case 2 -> {
                        System.out.println("\n----------- Daftar Paket di Gudang Ekspedisi --------");
                        ngawiHub.lihatSemuaPaket();
                    }

                    case 3 -> {
                        try {
                            System.out.println("\n ----- CARI KOLEKSI -----");
                            System.out.print("Masukkan kode resi paket : ");
                            String kodeResiDicari = scan.nextLine();
                            ngawiHub.cariPaket(kodeResiDicari);

                        } 
                        catch (PaketTidakDitemukanException e) {
                            System.out.println("WARNING : " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        Text.manajemenPelanggan();
                        int menuPelanggan = scan.nextInt();
                        scan.nextLine();

                        if (menuPelanggan == 1) {
                            System.out.print("Masukkan ID Pelanggan: ");
                            String idPelanggan = scan.nextLine();
                            System.out.print("Masukkan Nama Pelanggan: ");
                            String namaPelanggan = scan.nextLine();

                            ngawiHub.tambahPelanggan(new Pelanggan(idPelanggan, namaPelanggan));
                            
                        } else if (menuPelanggan == 2) {
                            System.out.print("Masukkan ID Pelanggan yang dicari: ");
                            ngawiHub.cariPelanggan(scan.nextLine());
                            
                        } else if (menuPelanggan == 3) {
                            ngawiHub.lihatSemuaPelanggan();
                        }
                    }
                    
                    case 5 ->{
                        System.out.println("\n Sistem Pengiriman Paket (Asosiasi)");
                        System.out.println("Masukkan ID Pelanggan: ");
                        String inputId = scan.nextLine();
                        
                        Pelanggan penerima = ngawiHub.getPelanggan(inputId);
                        
                        if(penerima == null){
                            System.out.println("[ERROR] Tidak ada pelanggan yang terdaftar!");
                        }
                        else if(ngawiHub.getJumlahPaket() == 0){
                            System.out.println("[ERROR] Tidak ada paket terdaftar!");
                        }
                        else{
                            ngawiHub.lihatSemuaPaket();
                            System.out.print("Pilih Paket yang ingin dikirim: ");
                            int noPaket = scan.nextInt()-1;
                            scan.nextLine();
                            
                            if(noPaket >= 0 && noPaket <= ngawiHub.getJumlahPaket() && ngawiHub.getPaket(noPaket).getIdPelanggan().equalsIgnoreCase(inputId)){
                                Paket paketKirim = ngawiHub.getPaket(noPaket);
                      
                                TransaksiPengiriman.prosesKirim(penerima, paketKirim);
                            }
                            else{
                                System.out.println("[ERROR] ID Pelanggan yang ingin dikirim harus cocok dengan yang terdaftar pada paket!");
                            }
                        }
                        
                    }

                    case 6 -> {
                        System.out.println("Keluar...");
                        isRun = false;
                    }

                    default ->
                        System.out.println("Input tidak valid!");
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("\n[ERROR] Input tidak valid! Anda harus memasukkan angka!");
                scan.nextLine();
            } 
            catch (Exception e) {
                System.out.println("\n[SYSTEM ERROR] Terjadi kegagalan: " + e.getMessage());
            }
        }
        scan.close();
    }
}
