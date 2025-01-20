/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Tra Pham
 */
public class User {
    private int RoleID, UserID;
    private String UserName,Password,RoleName;

    public User(int roleID, int userID, String UserName, String Password, String RoleName) {
        this.RoleID = roleID;
        this.UserID = userID;
        this.UserName = UserName;
        this.Password = Password;
        this.RoleName = RoleName;
    }

    public User() {
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        this.RoleID = roleID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        this.UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    @Override
    public String toString() {
        return "User{" + "roleID=" + RoleID + ", userID=" + UserID + ", UserName=" + UserName + ", Password=" + Password + ", RoleName=" + RoleName + '}';
    }

    
}
