/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */import java.util.Scanner;
final class SUITE extends Accommodation{
    private int NumOfRooms;
    private int MaximumGuests;

    public SUITE( String RoomNumber, double pricePerNight, boolean Available,int NumOfRooms, int MaximumGuests) {
        super(RoomNumber, pricePerNight, Available);
        this.NumOfRooms = NumOfRooms;
        this.MaximumGuests = MaximumGuests;
    }

    public SUITE() {
        this("",0.0,true,0,0);
    }

    public void setNumOfRooms(int NumOfRooms) {
        this.NumOfRooms = NumOfRooms;
    }

    public void setMaximumGuests(int MaximumGuests) {
        this.MaximumGuests = MaximumGuests;
    }

    public int getNumOfRooms() {
        return NumOfRooms;
    }

    public int getMaximumGuests() {
        return MaximumGuests;
    }

   @Override
public String toString() {
    return "SUITE Details:\n" +
           "Number of Rooms: " + NumOfRooms + "\n" +
           "Maximum Guests: " + MaximumGuests + "\n";
}

    @Override
    public void showAmenities(){
        System.out.println("Pools, Fitness centers");
        System.out.println("Restaurant");
}
    
    @Override
    public int  NumOfBeds(){
       int num =4;
       return num;
    }
    
    public String RoomService(){
      return ("VIP service");
    }
    public void PartyType(){
        System.out.println("Choose your party type: ");
        System.out.println("BBQ party");
        System.out.println("Graduation party");
        System.out.println("Success party");
        System.out.println("Birthday party");
        System.out.println("Other");
    }
    
}