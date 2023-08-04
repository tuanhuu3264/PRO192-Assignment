/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
/**
 *
 * @author DELL
 */
public class Car implements Comparable<Car> {
    private String id=null; 
    private Brand brand;
    private String color=null; 
    private String frameid=null; 
    private String engineid=null; 
    
    //Constructor
    public Car()
    {
        this.brand = new Brand();
        
    }
    public Car(String id, String brandid, String color, String frameid, String engineid)
    {
        this.brand = new Brand();
        this.id=id;
        this.brand.setID(brandid);
        this.color=color;
        this.frameid=frameid; 
        this.engineid=engineid;
    }
    //getter/setter
    
    public String getID()
    {
        return this.id; 
    }
    public String getBrandID()
    {
        return this.brand.getID(); 
    }
    public String getColor()
    {
        return this.color; 
    }
    public String getFrameID()
    {
        return this.frameid; 
    }
    public String getEngineID()
    {
        return this.engineid; 
    }
    
    public void setID(String id)
    {
        this.id=id; 
    }
    public void setBrandID(String brandid)
    {
        this.brand.setID(brandid);
    }
    public void setColor(String color)
    {
        this.color=color;
    }
    public void setFrameID(String frameid)
    {
        this.frameid=frameid;
    }
    public void setEngineID(String engineid)
    {
        this.engineid=engineid;
    }
    
    public Brand getBrand()
    {
        return this.brand;
    }
    
    @Override
    public String toString()
    {
        return this.id+", "+this.getBrandID()+", "+this.color+", "+this.frameid+", "+this.engineid;
    }
    @Override
    public int compareTo(Car a)
    {   int tmp=this.getBrand().getBrandName().compareTo(a.getBrand().getBrandName());
        if(tmp>0) return 1; 
        else if (tmp<0) return -1;
       else return this.getBrandID().compareTo(a.getBrandID());
    
    }
}
