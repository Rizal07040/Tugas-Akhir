/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;

/**
 *
 * @author PCPC
 */
public class Detail_pemesanan {
    private Integer Id_transaksi;
    private Pembeli pembeli;
    private Pembelian pembelian;
    private Date Tgl_transaksi;
    private Integer Harga_total;
    private Double Bayar;
    private Double Kembalian;

    public Integer getId_transaksi() {
        return Id_transaksi;
    }

    public void setId_transaksi(Integer Id_transaksi) {
        this.Id_transaksi = Id_transaksi;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public Pembelian getPembelian() {
        return pembelian;
    }

    public void setPembelian(Pembelian pembelian) {
        this.pembelian = pembelian;
    }

    public Date getTgl_transaksi() {
        return Tgl_transaksi;
    }

    public void setTgl_transaksi(Date Tgl_transaksi) {
        this.Tgl_transaksi = Tgl_transaksi;
    }

    public Integer getHarga_total() {
        return Harga_total;
    }

    public void setHarga_total(Integer Harga_total) {
        this.Harga_total = Harga_total;
    }

    public Double getBayar() {
        return Bayar;
    }

    public void setBayar(Double Bayar) {
        this.Bayar = Bayar;
    }

    public Double getKembalian() {
        return Kembalian;
    }

    public void setKembalian(Double Kembalian) {
        this.Kembalian = Kembalian;
    }
    
    
    
}
