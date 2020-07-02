/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Detail_pemesanan;
import model.Pembeli;
import model.Pembelian;

/**
 *
 * @author PCPC
 */
public class Transaksi {

    koneksi kon;
    ArrayList<Pembeli> arrPembeli;
    ArrayList<Pembelian> arrPembelian;
    ArrayList<Detail_pemesanan> arrDetail_pemesanan;

    
    public Transaksi() throws SQLException {

        this.kon = new koneksi();
        this.arrPembeli = new ArrayList<>();
        this.arrPembelian = new ArrayList<>();
        this.arrDetail_pemesanan = new ArrayList<>();

    }
   
     public ArrayList<Pembeli> getDataPembeli() throws SQLException {

        this.arrPembeli.clear();

        ResultSet rs = this.kon.getData("select * from Pembeli_07040 ");

        while (rs.next()) {

            Pembeli pembeli = new Pembeli();
            pembeli.setId_pembeli(rs.getInt("Id_pembeli"));
            pembeli.setNama_pembeli(rs.getString("Nama_pembeli"));
            pembeli.setUmur(rs.getString("Umur"));
            pembeli.setAlamat(rs.getString("Alamat"));
            pembeli.setJenis_kelamin(rs.getString("Jenis_kelamin"));
            
            this.arrPembeli.add(pembeli);

        }

        return this.arrPembeli;

    }
     public ArrayList<Pembelian> getDataPembelian() throws SQLException {

        this.arrPembeli.clear();

       // ResultSet rs = this.kon.getData("SELECT * FROM PEMBELI_07040 JOIN PEMBELIAN_07040 ON PEMBELI_07040.ID_PEMBELI = PEMBELIAN_07040.KODE_TIKET");
            ResultSet rs = this.kon.getData("SELECT * FROM PEMBELIAN_07040");
        while (rs.next()) {
            
            Pembeli pembeli = new Pembeli();
            
//            pembeli.setNama_pembeli(rs.getString("Nama_pembeli"));
//            pembeli.setUmur(rs.getString("Umur"));
//            pembeli.setAlamat(rs.getString("Alamat"));
//            pembeli.setJenis_kelamin(rs.getString("Jenis_kelamin"));
            
            Pembelian pembelian = new Pembelian();
            pembelian.setKode_tiket(rs.getInt("KODE_TIKET"));
            pembeli.setId_pembeli(rs.getInt("ID_PEMBELI"));
            pembelian.setJudul_film(rs.getString("JUDUL_FILM"));
            pembelian.setNo_kursi(rs.getInt("NO_KURSI"));
            pembelian.setJam_tayang(rs.getString("JAM_TAYANG"));
            pembelian.setHarga_tiket(rs.getDouble("HARGA_TIKET"));
            
            this.arrPembelian.add(pembelian);

        }

        return this.arrPembelian;

    }
     public ArrayList<Detail_pemesanan> getDataPemesanan() throws SQLException {

        this.arrDetail_pemesanan.clear();

        ResultSet rs = this.kon.getData("SELECT * FROM PEMBELI_07040 JOIN PEMBELIAN_07040 ON "
                + "PEMBELI_07040.ID_PEMBELI = PEMBELIAN_07040.KODE_TIKET JOIN TRANSAKSI_07040 ON "
                + "PEMBELIAN_07040.KODE_TIKET = TRANSAKSI_07040.ID_TRANSAKSI");
        while (rs.next()) {

            Pembeli pembeli = new Pembeli();
            pembeli.setId_pembeli(rs.getInt("Id_pembeli"));
            pembeli.setNama_pembeli(rs.getString("Nama_pembeli"));
            pembeli.setUmur(rs.getString("Umur"));
            pembeli.setAlamat(rs.getString("Alamat"));
            pembeli.setJenis_kelamin(rs.getString("Jenis_kelamin"));
            
            Pembelian pembelian = new Pembelian();
            pembelian.setKode_tiket(rs.getInt("Kode_tiket"));
            pembelian.setJudul_film(rs.getString("Judul_film"));
            pembelian.setNo_kursi(rs.getInt("No_kursi"));
            pembelian.setJam_tayang(rs.getString("Jam_tayang"));
            pembelian.setHarga_tiket(rs.getDouble("Harga_tiket"));
            

            Detail_pemesanan pemesanan = new Detail_pemesanan();
            pemesanan.setId_transaksi(rs.getInt("Id_transaksi"));
            pemesanan.setPembeli(pembeli);
            pemesanan.setPembelian(pembelian);
            pemesanan.setTgl_transaksi(rs.getDate("Tgl_transaksi"));
            pemesanan.setHarga_total(rs.getInt("Harga_total"));
            pemesanan.setBayar(rs.getDouble("Bayar"));
            pemesanan.setKembalian(rs.getDouble("Kembalian"));
            
           
            this.arrDetail_pemesanan.add(pemesanan);

        }

        return this.arrDetail_pemesanan;

    }
    public void insertpembeli(Pembeli pembeli) throws SQLException {
             try {
            this.kon.ManipulasiData("INSERT INTO PEMBELI_07040 VALUES('"+pembeli.getId_pembeli().toString()+ "',"
                    + "'" + pembeli.getNama_pembeli()+ "','" +  pembeli.getUmur()+ "',"
                    + "'" +  pembeli.getAlamat()+ "','" +  pembeli.getJenis_kelamin()+ "')");
        } catch (Exception ex) {
            System.out.println(ex);
        }  

         }
    public void insertpembelian(Pembelian pembelian) throws SQLException {
             try {
            this.kon.ManipulasiData("INSERT INTO PEMBELIAN_07040 VALUES('"+pembelian.getKode_tiket()+ "','"
                    +pembelian.getPembeli().getId_pembeli()+ "',"
                    + "'" + pembelian.getJudul_film()+ "','" +  pembelian.getNo_kursi().toString()
                    + "','" +  pembelian.getJam_tayang()+ "','" +  pembelian.getHarga_tiket().toString()+ "')");
        } catch (Exception ex) {
            System.out.println(ex);
        }  

         }
        public void inserttransaksi(Detail_pemesanan pesan) throws SQLException {
             
            try {
        String tglpesan= new SimpleDateFormat("dd/MM/yyyy").format(pesan.getTgl_transaksi());
        this.kon.ManipulasiData("INSERT INTO PEMBELIAN_07040 VALUES('"+pesan.getPembelian().getKode_tiket()+ "','"
                    +pesan.getPembeli().getId_pembeli()+ "',"
                    + "'" + pesan.getPembelian().getJudul_film()+ "','" +  pesan.getPembelian().getNo_kursi().toString()
                    + "','" +  pesan.getPembelian().getJam_tayang()+ "','" +  pesan.getPembelian().getHarga_tiket().toString()+ "')");
        ResultSet rs = this.kon.getData("SELECT KODE_TIKET.CURRVAL FROM DUAL");
            rs.next();
        this.kon.ManipulasiData("INSERT INTO TRANSAKSI_07040 VALUES (" +
                "'" + pesan.getId_transaksi()+ "' "+ ","
                + "'" +pesan.getPembeli().getId_pembeli()+ "',"
                + "'"+pesan.getPembelian().getKode_tiket()+ "',"
                + ",TO_DATE('"+tglpesan+"','dd/mm/yyyy'),"
                +"'"+pesan.getHarga_total()+"','"+pesan.getBayar()+"','"+pesan.getKembalian() +"')");
        } catch (Exception ex) {
        }      

         }
    public void deletepembeli(Integer i) throws SQLException {
        
            this.kon.ManipulasiData("DELETE FROM PEMBELI_07040 WHERE ID_PEMBELI = " + i);
    }
     public void deletetransaksi(Integer i) throws SQLException {
        
            this.kon.ManipulasiData("DELETE FROM TRANSAKSI_07040 WHERE ID_PEMBELI = " + i);
    }   
            
    }
    
          
