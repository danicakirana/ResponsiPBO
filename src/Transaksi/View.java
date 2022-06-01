/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class View extends JFrame{
    String move;
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","Nama Barang","Nama Kasir","Jumlah Barang","Harga Satuan", "Diskon", "Total Harga"};
    final JTextField fid = new JTextField(10);
    final JTextField fbarang = new JTextField();
    final JTextField fkasir = new JTextField();
    final JTextField fqty = new JTextField();
    final JTextField fprice = new JTextField();
    final JTextField fdisc = new JTextField();
    
    JLabel lid= new JLabel("ID Barang");
    JLabel lbarang = new JLabel("Nama Barang");
    JLabel lkasir = new JLabel("Nama Kasir");
    JLabel lqty = new JLabel("Jumlah Barang");
    JLabel lprice = new JLabel("Harga Satuan");
    JLabel ldisc = new JLabel("Diskon(%)");
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Reset");
    
    public View(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(1000,700);
        setVisible(true);
        setResizable(false);
        setTitle("Transactions");
        setDefaultCloseOperation(3);
  
        add(scrollPane);
        add(lid);
        add(fid);
        add(lbarang);
        add(fbarang);
        add(lkasir);
        add(fkasir);
        add(lqty);
        add(fqty);
        add(lprice);
        add(fprice);
        add(ldisc);
        add(fdisc);
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);


        scrollPane.setBounds(20, 40, 700, 450);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        lid.setBounds(750, 40, 120, 20);
        fid.setBounds(750, 70, 170, 30);
        
        lbarang.setBounds(750, 110, 120, 20);
        fbarang.setBounds(750, 140, 170, 30);
        
        lkasir.setBounds(750, 180, 120, 20);
        fkasir.setBounds(750, 210, 170, 30);
        
        lqty.setBounds(750, 250, 120, 20);
        fqty.setBounds(750, 280, 170, 30);
        
        lprice.setBounds(750, 320, 120, 20);
        fprice.setBounds(750, 350, 170, 30);
        
        ldisc.setBounds(750, 390, 120, 20);
        fdisc.setBounds(750, 420, 170, 30);
        
        btnTambah.setBounds(100, 550, 100, 50);
        btnUpdate.setBounds(250, 550, 100, 50);
        btnDelete.setBounds(400, 550, 100, 50);
        btnClear.setBounds(550, 550, 100, 50);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
        
        tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                JTable target = (JTable)me.getSource();
                int baris = target.getSelectedRow(); 
                move =tabel.getValueAt(baris, 0).toString();
                fid.setText(tabel.getValueAt(baris, 0).toString());
                fbarang.setText(tabel.getValueAt(baris, 1).toString());
                fkasir.setText( tabel.getValueAt(baris, 2).toString());
                fqty.setText(tabel.getValueAt(baris, 3).toString());
                fprice.setText(tabel.getValueAt(baris, 4).toString());
                fdisc.setText(tabel.getValueAt(baris, 5).toString());          
            }
        });       
    }
    public JTextField getFid() {
        return fid;
    }

    public JTextField getFbarang() {
        return fbarang;
    }

    public JTextField getFkasir() {
        return fkasir;
    }

    public JTextField getFqty() {
        return fqty;
    }
    
    public JTextField getFprice() {
        return fprice;
    }
    
    public JTextField getFdisc() {
        return fdisc;
    }
}
