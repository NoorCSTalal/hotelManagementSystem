/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotelsystem;

/**
 *
 * @author noort
 */
public interface Payable {
   public static final double TAX =0.15 ;
   public static final int MAX_BOOKING=3 ;
   public abstract double calculateBill();
}
