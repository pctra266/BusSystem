/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tra Pham
 */
public class Stop {
    private String StopName;
    private int StopID;

    public Stop() {
    }

    public Stop(String StopName, int StopID) {
        this.StopName = StopName;
        this.StopID = StopID;
    }

    public String getStopName() {
        return StopName;
    }

    public void setStopName(String StopName) {
        this.StopName = StopName;
    }

    public int getStopID() {
        return StopID;
    }

    public void setStopID(int StopID) {
        this.StopID = StopID;
    }

    @Override
    public String toString() {
        return "Stop{" + "StopName=" + StopName + ", StopID=" + StopID + '}';
    }
    
            
}
