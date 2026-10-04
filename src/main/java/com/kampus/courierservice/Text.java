/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;

/**
 *
 * @author NABIL MUHAMMAD S
 */
public class Text {

    public static void Header() {
        System.out.println(" = = = = = = = = = = = = = = = = = = =");
        System.out.println(" = = = = = = = = = = = = = = = = = = =");
        System.out.println(" ========== COURIER SERVICE ==========");
        System.out.println(" = = = = = = = = = = = = = = = = = = =");
        System.out.println(" = = = = = = = = = = = = = = = = = = =");
    }

    public static void Menu() {
        System.out.println("Silahkan gunakan menu berikut");
        System.out.println("1. Tambah Paket");
        System.out.println("2. Tampil semua paket");
        System.out.println("3. Cari Paket");
        System.out.println("4. Keluar");
        System.out.print("Pilih 1-4: ");
    }

    public static void pilihPaket() {
        System.out.println("--- Pilih jenis paket ---");
        System.out.println("1. Paket Reguler");
        System.out.println("2. Paket Express");
        System.out.println("3. Paket Same Day");
        System.out.println("4. Paket Internasional");
        System.out.print("Pilih 1-4: ");
    }

    public static void menuCariPaket() {
        System.out.println("**** CARI PAKET ****");
        System.out.println("1. Cari berdasarkan tujuan");
        System.out.println("2. Cari berdasarkan berat");
        System.out.println("3. Cari berdasarkan resi");
        System.out.print("Pilih opsi pencarian: ");
    }
}
