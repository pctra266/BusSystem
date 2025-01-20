/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tra Pham
 */
public class Route {
    private int RouteID;
    private String RouteName, StartPoint,IntermediateStation ,EndPoint, StartTime, EndTime,Frequency;

    public Route() {
    }

    public Route(int RouteID, String RouteName, String StartPoint, String IntermediateStation, String EndPoint, String StartTime, String EndTime, String Frequency) {
        this.RouteID = RouteID;
        this.RouteName = RouteName;
        this.StartPoint = StartPoint;
        this.IntermediateStation = IntermediateStation;
        this.EndPoint = EndPoint;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Frequency = Frequency;
    }

    

    public int getRouteID() {
        return RouteID;
    }

    public void setRouteID(int RouteID) {
        this.RouteID = RouteID;
    }

    public String getRouteName() {
        return RouteName;
    }

    public void setRouteName(String RouteName) {
        this.RouteName = RouteName;
    }

    public String getStartPoint() {
        return StartPoint;
    }

    public void setStartPoint(String StartPoint) {
        this.StartPoint = StartPoint;
    }

    public String getIntermediateStation() {
        return IntermediateStation;
    }

    public void setIntermediateStation(String IntermediateStation) {
        this.IntermediateStation = IntermediateStation;
    }
    

    public String getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(String EndPoint) {
        this.EndPoint = EndPoint;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    @Override
    public String toString() {
        return "Route{" + "RouteID=" + RouteID + ", RouteName=" + RouteName + ", StartPoint=" + StartPoint + ", IntermediateStation=" + IntermediateStation + ", EndPoint=" + EndPoint + ", StartTime=" + StartTime + ", EndTime=" + EndTime + ", Frequency=" + Frequency + '}';
    }

    
}
