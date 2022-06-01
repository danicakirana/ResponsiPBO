/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaksi;

/**
 *
 * @author ASUS
 */
public class Tambahan {
    public void MVC(){
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
    }
}

