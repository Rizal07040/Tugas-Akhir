/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author PCPC
 */
public class Pembelian {
    private Pembeli pembeli;
    private Integer Kode_tiket;
    private String Judul_film;
    private Integer No_kursi;
    private String Jam_tayang;
    private Double Harga_tiket;
    private ArrayList<Pembeli>arrpembeli;

    public ArrayList<Pembeli> getArrpembeli() {
        return arrpembeli;
    }

    public void setpembeli(ArrayList<Pembeli> arrpembeli) {
        this.arrpembeli = arrpembeli;
    }
    
    

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public String getJam_tayang() {
        return Jam_tayang;
    }

    public void setJam_tayang(String Jam_tayang) {
        this.Jam_tayang = Jam_tayang;
    }
    public Integer getKode_tiket() {
        return Kode_tiket;
    }

    public void setKode_tiket(Integer Kode_tiket) {
        this.Kode_tiket = Kode_tiket;
    }

  
    public String getJudul_film() {
        return Judul_film;
    }

    public void setJudul_film(String Judul_film) {
        this.Judul_film = Judul_film;
    }

    public Integer getNo_kursi() {
        return No_kursi;
    }

    public void setNo_kursi(Integer No_kursi) {
        this.No_kursi = No_kursi;
    }

    public Double getHarga_tiket() {
        return Harga_tiket;
    }

    public void setHarga_tiket(Double Harga_tiket) {
        this.Harga_tiket = Harga_tiket;
    }
        
    
    
}
