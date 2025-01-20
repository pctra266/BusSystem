/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tra Pham
 */
public class ListOrderOfRoute {
    private int StopID, StopOrder;
    private String StopName;

    public ListOrderOfRoute() {
    }

    public ListOrderOfRoute(int StopID, int StopOrder, String StopName) {
        this.StopID = StopID;
        this.StopOrder = StopOrder;
        this.StopName = StopName;
    }

    public int getStopID() {
        return StopID;
    }

    public void setStopID(int StopID) {
        this.StopID = StopID;
    }

    public int getStopOrder() {
        return StopOrder;
    }

    public void setStopOrder(int StopOrder) {
        this.StopOrder = StopOrder;
    }

    public String getStopName() {
        return StopName;
    }

    public void setStopName(String StopName) {
        this.StopName = StopName;
    }

    @Override
    public String toString() {
        return "ListOrderOfRoute{" + "StopID=" + StopID + ", StopOrder=" + StopOrder + ", StopName=" + StopName + '}';
    }
    
           
}
