/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsystem;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Reservation implements Payable {
    
    
    private Accommodation accommodation;
    private int days;
    private int nights;
    private Guest guest;
    private String status;
    private final  int RESERVATION_ID;
    private static int numOfBooking=0 ;
   
    
    
    public Reservation(int days ,int nights ,String status, Accommodation accommodaton , Guest guest ){
        this.accommodation=accommodaton ;
        this.status=status;
        this.nights= nights;
        this.days=this.nights;
       this.RESERVATION_ID = (int) (Math.random() * ((1000 - 1) + 1)) + 1;
       this.guest=guest;
       numOfBooking++;
    
    
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public static int getNumOfBooking() {
        return numOfBooking;
    }

    public static void setNumOfBooking(int numOfBooking) {
        Reservation.numOfBooking = numOfBooking;
    }

    
    public int getRESERVATION_ID() {
        return RESERVATION_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    //START METHOOD

private final int generateId() {
        int min = 1;
        int max = 1000;
        int id = (int) (Math.random() * ((max - min) + 1)) + min;
        return id;}

public final void Confirm() {
        setStatus("Confirmed");
        System.out.println("Booking has been confirmed.");
    }

    public final void cancel() {
        setStatus("Cancelled");
        System.out.println("Booking has been cancelled.");
    }


@Override 
public double calculateBill(){
double total =accommodation.getPricePerNight()*nights;
double tax =total* Payable.TAX;
return total +tax;
}

public String toString (){
return "---- Reservation Details ----"+"\nReservationID:"+RESERVATION_ID +"\nGuest Name :"+guest.getGuestName()+"\nRoom number :"+accommodation.getRoomNumber()
+"\n Duratiom :"+nights +"Nights("+days +"days)"+"\n Total Bill(withTax):"+calculateBill()+"SAR";

}


}