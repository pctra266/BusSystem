/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tra Pham
 */
public class UserDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User findUser(String userName, String password) {
        String query = "select * from [User] u join [Role] r on u.RoleID = r.RoleID\n"
                + "where UserName like ?\n"
                + "and [Password] like ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt("RoleID"), rs.getInt("UserID"),
                        rs.getString("UserName"), rs.getString("Password"),
                        rs.getString("RoleName"));
            }
        } catch (Exception e) {

        }

        return null;
    }

    public ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<>();
        String query = "select *\n"
                + "from [User] u join [Role] r on u.RoleID = r.RoleID";

        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt("RoleID"), rs.getInt("UserID"),
                        rs.getString("UserName"), rs.getString("Password"),
                        rs.getString("RoleName")));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public void deleteUserByID(String UserID) {
        String query = "delete [User]\n"
                + "where UserID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, UserID);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void createUser(String UserName, String Password, String RoleID) {
        String query = "insert into [User](UserName,Password,RoleID)\n"
                + "values (?,?,?)";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, UserName);
            ps.setString(2, Password);
            ps.setString(3, RoleID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateUser(String UserName, String Password, String RoleID, String UserID) {
        String query = "update [User]\n"
                + "set UserName = ?,\n"
                + "[Password] = ?,\n"
                + "RoleID = ?\n"
                + "where UserID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, UserName);
            ps.setString(2, Password);
            ps.setString(3, RoleID);
            ps.setString(4, UserID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public User getUserByID(String UserID) {
        String query = "select * from [User] u join [Role] r on u.RoleID = r.RoleID\n"
                + "where UserID = ?";
        try {
            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            ps.setString(1, UserID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt("RoleID"), rs.getInt("UserID"),
                        rs.getString("UserName"), rs.getString("Password"),
                        rs.getString("RoleName"));
            }
        } catch (Exception e) {

        }

        return null;
    }
    
  
   

}