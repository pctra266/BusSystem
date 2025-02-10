/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Bus;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tra Pham
 */
public class BusDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Bus> getAllBusDAO() {
        ArrayList<Bus> list = new ArrayList<>();
        String query = "select b.BusID, b.BusNumber, r.RouteName\n"
                + "from Bus b \n"
                + "left join BusRoute bs on b.BusID = bs.BusID\n"
                + "left join [Route] r on bs.RouteID = r.RouteID;";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bus(rs.getInt("BusID"), rs.getString("BusNumber"), rs.getString("RouteName")));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public void deleteBusbyID(String BusID) {
        String query = "delete from BusRoute\n"
                + "where BusID =?\n"
                + "\n"
                + "delete from Bus\n"
                + "where BusID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, BusID);
            ps.setString(2, BusID);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void createBus(String busNumber, String routeID) {
        String query = "insert into Bus(BusNumber)\n"
                + "values (?);\n"
                + "\n"
                + "declare @busID int;\n"
                + "set @busID = SCOPE_IDENTITY();\n"
                + "\n"
                + "insert into BusRoute(BusID, RouteID)\n"
                + "values (@busID, ?);";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, busNumber);
            ps.setString(2, routeID);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void updateBus(String busID, String busNumber, String RouteID, boolean hasOldRoute) {
        if (hasOldRoute) {
            if (RouteID != null && !RouteID.isEmpty()) {
                String query = "update Bus\n"
                        + "set BusNumber = ?\n"
                        + "where BusID = ?\n"
                        + "\n"
                        + "update BusRoute\n"
                        + "set RouteID = ?\n"
                        + "where BusID = ?";
                try {
                    conn = new DBContext().connection;
                    ps = conn.prepareStatement(query);
                    ps.setString(1, busNumber);
                    ps.setString(2, busID);
                    ps.setString(3, RouteID);
                    ps.setString(4, busID);
                    ps.executeUpdate();

                } catch (Exception e) {

                }
            } else {
                String query = "delete BusRoute\n"
                        + "where BusID = ?\n"
                        + "\n"
                        + "update Bus\n"
                        + "set BusNumber = ?\n"
                        + "where BusID = ?";
                try {
                    conn = new DBContext().connection;
                    ps = conn.prepareStatement(query);
                    ps.setString(1, busID);
                    ps.setString(2, busNumber);
                    ps.setString(3, busID);
                    ps.executeUpdate();

                } catch (Exception e) {

                }
            }
        } else {
            if (RouteID != null) {
                String insertQuery = "insert into BusRoute(BusID, RouteID) values (?, ?)";
                String updateQuery = "update Bus set BusNumber = ? where BusID = ?";
                try {
                    conn = new DBContext().connection;

                    ps = conn.prepareStatement(insertQuery);
                    ps.setString(1, busID);
                    ps.setString(2, RouteID);
                    ps.executeUpdate();

                    ps = conn.prepareStatement(updateQuery);
                    ps.setString(1, busNumber);
                    ps.setString(2, busID);
                    ps.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                String updateQuery = "update Bus set BusNumber = ? where BusID = ?";
                try {
                    conn = new DBContext().connection;

                    ps = conn.prepareStatement(updateQuery);
                    ps.setString(1, busNumber);
                    ps.setString(2, busID);
                    ps.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Bus getBusByID(String BusID) {
        String query = "select b.BusID, b.BusNumber, r.RouteName\n"
                + "                from Bus b \n"
                + "                left join BusRoute bs on b.BusID = bs.BusID\n"
                + "                left join [Route] r on bs.RouteID = r.RouteID\n"
                + "                where b.BusID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, BusID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Bus(rs.getInt("BusID"), rs.getString("BusNumber"), rs.getString("RouteName"));
            }
        } catch (Exception e) {

        }

        return null;
    }
}
