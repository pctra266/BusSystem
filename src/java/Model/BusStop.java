/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tra Pham
 */
public class BusStop {
    private int StopID;
    private String StopName;

    public BusStop() {
    }

    public BusStop(int StopID, String StopName) {
        this.StopID = StopID;
        this.StopName = StopName;
    }

    public int getStopID() {
        return StopID;
    }

    public void setStopID(int StopID) {
        this.StopID = StopID;
    }

    public String getStopName() {
        return StopName;
    }

    public void setStopName(String StopName) {
        this.StopName = StopName;
    }

    @Override
    public String toString() {
        return "BusStop{" + "StopID=" + StopID + ", StopName=" + StopName + '}';
    }
    
}
