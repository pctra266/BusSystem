/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tra Pham
 */
public class Bus {
   private int BusID;
   private String BusNumber, RouteName;

    public Bus() {
    }

    public Bus(int BusID, String BusNumber, String RouteName) {
        this.BusID = BusID;
        this.BusNumber = BusNumber;
        this.RouteName = RouteName;
    }

    public int getBusID() {
        return BusID;
    }

    public void setBusID(int BusID) {
        this.BusID = BusID;
    }

    public String getBusNumber() {
        return BusNumber;
    }

    public void setBusNumber(String BusNumber) {
        this.BusNumber = BusNumber;
    }

    public String getRouteName() {
        return RouteName;
    }

    public void setRouteName(String RouteName) {
        this.RouteName = RouteName;
    }

    @Override
    public String toString() {
        return "Bus{" + "BusID=" + BusID + ", BusNumber=" + BusNumber + ", RouteName=" + RouteName + '}';
    }

    
   
}
