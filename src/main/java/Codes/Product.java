/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codes;

/**
 *
 * @author Pramodhi
 */
public class Product {
    public int pId;
    public String name,email,address;
    public int quantity;
    public double price;
    public String category;
    public byte[] image;
    
    public Product(String name, String email, String address){
        this.email = email;
        this.name = name;
        this.address = address;
    }
    
    public Product(int pId, String Name, int quantity, double price, String category, byte[] image){
    
        this.pId = pId;
        this.name = Name;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.category = category;
       
    }
}
