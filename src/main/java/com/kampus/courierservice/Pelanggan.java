/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kampus.courierservice;

/**
 *
 * @author NABIL MUHAMMAD S
 */

// Entitas Mandiri - Aggregation
public class Pelanggan {
    private String idPelanggan;
    private String namaPelanggan;
    
    public Pelanggan(String idPelanggan, String namaPelanggan){
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
    }
    
    public String getIdPelanggan(){return this.idPelanggan;}
    public String getNamaPelanggan(){return this.namaPelanggan;}
}
