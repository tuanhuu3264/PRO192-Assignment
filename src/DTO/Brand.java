/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import DTO.Car;

/**
 *
 * @author DELL
 */
public class Brand {
    private String id=null; 
    private String brandname=null; 
    private String sound=null; 
    private double price=0; 
    //cóntructor
    public Brand(){
        
    }
    public Brand(String id, String brandname, String sound, double price)
    {
       this.id=id; 
       this.brandname=brandname;
       this.sound=sound;
       if(price>0) this.price=price;
       else System.out.println("Error Price");
    }
    //getter/setter
    
    public String getID()
    {
        return this.id;
    }
    public String getBrandName()
    {
        return this.brandname;
    }
    public String getSound()
    {
        return this.sound;
    }
    public double getPrice()
    {
        return this.price;
    }
    public void setID(String id)
    {
        this.id=id;
    }
    public void setBrandName(String brandname)
    {
        this.brandname=brandname;
    }
    public void setSound(String sound)
    {
        this.sound=sound;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
            
    @Override
    public String toString()
    {
        return this.id+", "+this.brandname+", "+this.sound+": "+this.price; 
    }
}
