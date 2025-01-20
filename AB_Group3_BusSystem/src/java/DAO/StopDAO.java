/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Stop;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tra Pham
 */
public class StopDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Stop> getAllStop() {
        ArrayList<Stop> list = new ArrayList<>();
        String query = "select * from BusStop ";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Stop(rs.getString(2), rs.getInt(1)));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public void deleteStopByID(String StopID) {
        String query = "delete RouteStop\n"
                + "where StopID = ?\n"
                + "delete BusStop\n"
                + "where StopID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, StopID);
            ps.setString(2, StopID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void createStop(String StopName) {
        String query = "insert into BusStop(StopName)\n"
                + "values(?)";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, StopName);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Stop getStopByID(String StopID) {
        String query = "select * from BusStop \n"
                + "where StopID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, StopID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return (new Stop(rs.getString(2), rs.getInt(1)));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateStop(String StopID,String StopName) {
        String query = "update BusStop\n"
                + "set StopName = ?\n"
                + "where StopID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, StopName);
            ps.setString(2, StopID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
