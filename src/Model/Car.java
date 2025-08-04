
package src.Model;

public class Car{
    private int ID;
    private String brand;
    private String model;
    private String color;
    private int year;
    private double price;
    private int available; // 0 if free 1 if rented 2 if deleted

    public void Car(){
        
    }
    public int getID(){
        return ID;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public String getColor(){
        return color;
    }
    public int getYear(){
        return year;
    }
    public double getPrice(){
        return price;
    }
    public int isAvailable(){
        return available;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
      
    public void setBrand(String brand) {
        this.brand = brand;
    }
      
      public void setModel(String model) {
        this.model = model;
    }
      
      public void setColor(String color) {
        this.color = color;
    }
      
      public void setYear(int year) {
        this.year = year;
    }
      
      public void setPrice(double price) {
        
        if(price>=0) this.price = price;
    }
      
      public void setAvailable(int available) {
        this.available = available;
    }
}