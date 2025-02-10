/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.BusStop;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tra Pham
 */
public class BusStopDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<BusStop> getAllBusStop() {
        ArrayList<BusStop> list = new ArrayList<>();
        String query = "select * from BusStop";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BusStop(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public ArrayList<BusStop> getBusStopByRouteID(String routeID) {
        ArrayList<BusStop> list = new ArrayList<>();
        String query = "select * from BusStop bs join RouteStop rs on bs.StopID = rs.StopID\n"
                + "where RouteID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, routeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BusStop(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {

        }

        return list;
    }
}

