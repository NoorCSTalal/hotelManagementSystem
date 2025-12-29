/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */
public class Guest {
private String GuestName;
private int GuestNumber;


    public Guest(String GuestName, int GuestNumber) {
        this.GuestName = GuestName;
        this.GuestNumber = GuestNumber;
       
    }

public Guest(){
   this("", 0);
}

    public void setGuestName(String GuestName) {
        this.GuestName = GuestName;
    }

    public void setGuestNumber(int GuestNumber) {
        this.GuestNumber = GuestNumber;
    }

   

    public String getGuestName() {
        return GuestName;
    }

    public int getGuestNumber() {
        return GuestNumber;
    }

    

    @Override
    public String toString() {
        return "Guest{" + "GuestName=" + GuestName + ", GuestNumber=" + GuestNumber  ;
    }

}
