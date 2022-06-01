/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class Konektor {
   
    Connection koneksi;
    Statement statement;
    public Konektor() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/trans_db","root","");
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
}