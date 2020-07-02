/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Koneksi;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class koneksi {
    
    
    private Connection connect;
    private Statement db;
    private String database = "RizalAdi07040";
    
    public koneksi(){
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Class Driver Ditemukan !");
            
            try {
                
                connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RizalAdi07040","rizal");
                System.out.println("Koneksi Database Sukses !");
                
            } catch (SQLException ex) {
                
                System.out.println("Koneksi Database Gagal : "+ex);
                
            }
            
        } catch (ClassNotFoundException e) {
            
            System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : "+e);
        }
        
    }
    
    public ResultSet getData(String sql){
        try {
            
            db = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return db.executeQuery(sql);
            
        } catch (SQLException e) {
            
            return null;
            
        }
    }
    
    public int ManipulasiData(String sql){
        try {
            
            db = connect.createStatement();
            return db.executeUpdate(sql);
            
        } catch (SQLException e) {
            
            return 0;
        }
    }
}
