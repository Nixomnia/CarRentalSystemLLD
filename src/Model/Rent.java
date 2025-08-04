package src.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Rent {
    private int ID;
    private User user;
    private Car car;
    private LocalDateTime dateTime;
    private int hours;
    private double total;
    private int status;// 0 rented, 1 returned
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm");

    public Rent(){
        dateTime = LocalDateTime.now();
    }

    public int getID() {
        return ID;
      }
      
      public User getUser() {
        return user;
      }
      
      public Car getCar() {
        return car;
      }
      
      public String getDateTime() {
        return formatter.format(dateTime);
      }

      public LocalDateTime getLocalDateTime(){
          return dateTime;
      }
      
      public int getHours() {
        return hours;
      }
      
      public double getTotal() {
        return total;
      }
      
      public int getStatus() {
        return status;
      }
      
      public String getStatusToString(){
        long passedHours = ChronoUnit.HOURS.between(dateTime,LocalDateTime.now());
        String stat="";
        if(getStatus()==0 && passedHours < hours){
          stat = "On Time";
        }
        else if(getStatus()==0 && passedHours > hours){
          stat = "Delayed";
        }
        else stat = "Returned";

        return stat;
      }
      public DateTimeFormatter getFormatter() {
        return formatter;
      }
    
      public long getDelayedHours(){
        long passedHours = ChronoUnit.HOURS.between(dateTime,LocalDateTime.now());
        return passedHours-hours;
      }
      public void setID(int ID) {
        this.ID = ID;
      }
      
      public void setUser(User user) {
        this.user = user;
      }
      
      public void setCar(Car car) {
        this.car = car;
      }
      
      public void setDateTime(String dateTimeString) {
        this.dateTime = LocalDateTime.parse(dateTimeString,formatter);
      }
      
      public void setHours(int hours) {
        this.hours = hours;
      }
      
      public void setTotal(double total) {
        this.total = total;
      }
      
      public void setStatus(int status) {
        this.status = status;
      }
      
}
