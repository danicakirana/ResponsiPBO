/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author ASUS
 */
public class Controller {
    Model model;
    View view;
    
    public Controller(View view, Model model) {
        this.model = model;
        this.view = view;

        if(model.ambildata() != 0){
            String data[][] = model.READ();
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Tidak Ada Data Transaksi");
        }
    
        view.btnTambah.addActionListener((ActionEvent e) -> {
            String id = view.getFid().getText();
            String barang = view.getFbarang().getText();
            String kasir = view.getFkasir().getText();
            int qty = Integer.parseInt(view.getFqty().getText());
            int price = Integer.parseInt(view.getFprice().getText());
            int disc = Integer.parseInt(view.getFdisc().getText());
            double total = (qty*price)-(qty*price*(disc*0.01));
            
            if (id.equals("")||barang.equals("")||kasir.equals("")||qty==0||price==0||disc==0) {
                JOptionPane.showMessageDialog(view, "Harap tidak mengosongi inputan!");
            }else{
                model.ADD(id,barang,kasir,qty,price,disc,total);
               
                view.dispose();
                Tambahan tambah = new Tambahan();
                tambah.MVC();
            }
        });
 
        view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String move = view.move;
                String id = view.getFid().getText();
                String barang = view.getFbarang().getText();
                String kasir = view.getFkasir().getText();
                int qty = Integer.parseInt(view.getFqty().getText());
                int price = Integer.parseInt(view.getFprice().getText());
                int disc = Integer.parseInt(view.getFdisc().getText());
                double total = (qty*price)-(qty*price*(disc*0.01));
                if (id.equals("")||barang.equals("")||kasir.equals("")||qty==0||price==0||disc==0) {
                    JOptionPane.showMessageDialog(view, "Harap tidak mengosongi inputan!");
                }else {
                    model.UPDATE(id,barang,kasir,qty,price,disc,total,move);
                    view.dispose();
                    Tambahan tambah = new Tambahan();
                    tambah.MVC();
                }
            }
        });

        view.btnDelete.addActionListener((ActionEvent e) -> {
            String id = view.getFid().getText();
            
            if (id.equals("")) {
                JOptionPane.showMessageDialog(view, "Pilih Data Yang Akan Dihapus");
            }else {
                model.deleteData(id);
                view.dispose();
                Tambahan tambah = new Tambahan();
                tambah.MVC();
            }
        });

        view.btnClear.addActionListener((ActionEvent e) -> {
            view.fid.setText("");
            view.fbarang.setText("");
            view.fkasir.setText("");
            view.fqty.setText("");
            view.fprice.setText("");
            view.fdisc.setText("");
        });  
    }
}
