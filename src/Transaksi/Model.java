/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Model {
    
    Konektor konektor = new Konektor(); 
    public int ambildata(){
        int Data=0;
        try{
            String query = "Select * FROM transactions"; 
            konektor.statement = konektor.koneksi.createStatement();
            ResultSet resultSet = konektor.statement.executeQuery(query); 
            while(resultSet.next()){ 
                Data++; 
            }
            konektor.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        return Data;
    }
    
    public String[][] READ(){ 
        try{
            int jmlData = 0; 
            String data[][] = new String[ambildata()][7];
            String query = "Select * FROM `transactions`"; 
            konektor.statement = konektor.koneksi.createStatement();
            ResultSet resultSet = konektor.statement.executeQuery(query);
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("id_trans"); 
                data[jmlData][1] = resultSet.getString("nama_barang");
                data[jmlData][2] = resultSet.getString("nama_kasir"); 
                data[jmlData][3] = resultSet.getString("qty");
                data[jmlData][4] = resultSet.getString("price_per_qty");
                data[jmlData][5] = resultSet.getString("discount");
                data[jmlData][6] = resultSet.getString("price_total");
                jmlData++;       
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Koneksi Gagal");
            return null;
        }
    }
    
    public void ADD(String id, String barang, String kasir, int qty, int price, int disc, double total){
        
        try{
            String query = "INSERT INTO transactions VALUES ('"+ id +"','"+ barang +"','"+ kasir +"','"+ qty +"','"+ price +"','"+ disc +"','"+ total +"')";  
            konektor.statement = konektor.koneksi.createStatement();
            konektor.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Berhasil Menambahkan Data!!");
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Id Sudah Digunakan!!");
        }
    }
    
    public void UPDATE(String id, String barang, String kasir, int qty, int price, int disc, double total, String pindah){
            
        try {
            String query = "UPDATE transactions SET id_trans=?, "
                    + "nama_barang=?, nama_kasir=?, qty=?, price_per_qty=?, discount=?, price_total=? where id_trans=?";
            PreparedStatement preparedStmt = konektor.koneksi.prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, barang);
            preparedStmt.setString(3, kasir);
            preparedStmt.setInt(4, qty);
            preparedStmt.setInt(5, price);
            preparedStmt.setInt(6, disc);
            preparedStmt.setDouble(7, total);
            preparedStmt.setString(8, pindah);
            preparedStmt.execute();
            
           if(pindah.compareTo(id)==0)
            JOptionPane.showMessageDialog(null,"Data Transaksi Berhasil Diupdate!!");
            else
                JOptionPane.showMessageDialog(null,"Data Transaksi Tidak Ada!!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteData(String id){
        try{
            String query = "DELETE from transactions WHERE id_trans = '"+ id +"'";
            konektor.statement = konektor.koneksi.createStatement();
            konektor.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Transaksi berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}
