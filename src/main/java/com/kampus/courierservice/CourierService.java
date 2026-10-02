/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.kampus.courierservice;

import java.util.Scanner;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class CourierService {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Paket[] paketBarang = new Paket[5];

        // Penerapan struktur dasar java
        int jumlahPaketSekarang = 0;
        boolean isRun = true;

        while (isRun) {
            Text.Header();
            Text.Menu();

            int pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    if (jumlahPaketSekarang < paketBarang.length) {
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

                            if (beratPaket > 0 && estimasi > 0) {
                                paketBarang[jumlahPaketSekarang]
                                        = new PaketReguler(namaPenerima, tujuanKirim, beratPaket, resiBarang,
                                                kurir, ekspedisi, estimasi);
                                jumlahPaketSekarang++;
                                System.out.println("Berhasil ditambahkan!");

                            } else {
                                System.out.println("Input berat atau estimasi hari salah!");
                            }

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

                            if (beratPaket > 0 && estimasiJam > 0) {
                                paketBarang[jumlahPaketSekarang] = new PaketExpress(namaPenerima, tujuanKirim, beratPaket,
                                        resiBarang, kurir, ekspedisi, estimasiJam);
                                jumlahPaketSekarang++;
                                System.out.println("Berhasil ditambahkan!");
                            } else {
                                System.out.println("Input berat atau estimasi jam salah!");
                            }

                        } else if (pilihanPaket == 3) {
                            System.out.println("Apakah satu kota? isi dengan true atau false");
                            boolean satuDomisili = scan.nextBoolean();

                            if (satuDomisili) {
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

                                if (beratPaket > 0 && jarakPenerima > 0) {
                                    paketBarang[jumlahPaketSekarang] = new PaketSameDay(namaPenerima, tujuanKirim, beratPaket, resiBarang,
                                            kurir, ekspedisi, jarakPenerima, satuDomisili);
                                    jumlahPaketSekarang++;
                                    System.out.println("Berhasil ditambahkan!");
                                } else {
                                    System.out.println("Salah input berat atau jarak!");
                                }
                            }
                            else{
                                System.out.println("Tidak satu provinsi sehingga pengiriman same day tidak bisa dilakukan!");
                            }
                        }
                    } else {
                        System.out.println("Pengiriman sedang penuh!");
                    }

                    break;

                case 2:
                    if (jumlahPaketSekarang == 0) {
                        System.out.println("Tidak ada paket terdaftar!");
                    } else {
                        for (int i = 0; i < jumlahPaketSekarang; i++) {
                            paketBarang[i].infoPaket();
                        }
                    }

                    break;

                case 3:
                    System.out.println("**** CARI PAKET ****");
                    System.out.println("1. Cari berdasarkan tujuan");
                    System.out.println("2. Cari berdasarkan berat");
                    System.out.print("Pilih opsi pencarian: ");
                    int opsiCari = scan.nextInt();
                    scan.nextLine();

                    if (opsiCari == 1) {
                        System.out.print("Masukkan tujuan paket yang dicari: ");
                        String tujuanDicari = scan.nextLine();
                        temukanPaket.cari(tujuanDicari, paketBarang, jumlahPaketSekarang);

                    } else if (opsiCari == 2) {
                        System.out.print("Masukkan berat (Kg) paket yang dicari: ");
                        double beratPaketDicari = scan.nextDouble();
                        scan.nextLine();
                        temukanPaket.cari(beratPaketDicari, paketBarang, jumlahPaketSekarang);
                    }
                    break;

                case 4:
                    System.out.println("Keluar...");
                    isRun = false;
                    break;
                default:
                    System.out.println("Masukan tidak valid!");
            }
        }
        scan.close();
    }
}