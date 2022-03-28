package login.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    private String username, password;
    private Connection conn;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void getCredentials(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root", "root");
            PreparedStatement select = conn.prepareStatement("SELECT * FROM account WHERE username = ?");
            select.setString(1, username);
            ResultSet rs = select.executeQuery();
            if(rs.next()){
                password = rs.getString("password");
            }
            else{
                password = "";
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
