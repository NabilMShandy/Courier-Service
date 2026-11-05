/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;

/**
 *
 * @author NABIL MUHAMMAD S
 */

// Composition
public class GudangEkspedisi {
    private String namaGudang;
    private int luasGudang;
    private int kapasitasGudang;
    
    public GudangEkspedisi(String namaGudang, int luasGudang, int kapasitasGudang){
        this.namaGudang = namaGudang;
        this.luasGudang = luasGudang;
        this.kapasitasGudang = kapasitasGudang;
    }
    
    public void informasiGudang(){
        System.out.println("-----> [" + this.namaGudang + "]" + " [Luas : " + this.luasGudang + " m2] [Kapasitas : " + this.kapasitasGudang + "] <-----");
    }
}