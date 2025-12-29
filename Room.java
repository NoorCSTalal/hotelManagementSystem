/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */

    public abstract class Room extends Accommodation{
    
     
    // Constructors
    public Room(String roomNumber, double pricePerNight, boolean available) {
        super(roomNumber, pricePerNight, available);
    }
    //embty Constructors
    public Room() {
        super();
    }

    
    
   // Abstract methods (must be implemented by subclasses)
    public abstract String UpgradeToSuite();  
    public abstract int NumOfBeds();
    public abstract String RoomService();
    
    
    // Common toString for all rooms
    @Override
    public String toString() {
        return "Room{" +
                "RoomNumber='" + getRoomNumber() + '\'' +
                ", PricePerNight=" + getPricePerNight() +
                ", Available=" + isAvailable() +
                '}';
    }
    
}


