package data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Bottom;
import model.Toppings;
import model.User;

public class CakeMapper {

    // must be put into Facade
    private Connection con;

    public CakeMapper() {
        con = new DB().getConnection();
    }

    public Bottom getBottom(String b) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Bottom bottom = null;

        String SQLString
                = "select * from Bottom where bottom = ?";
        try {
            stmt = con.prepareStatement(SQLString);
            stmt.setString(1, b);
            rs = stmt.executeQuery();

            if (rs.next()) {
                bottom = new Bottom(b, rs.getInt("price"));
            }
        } catch (SQLException e) {
            System.out.println("Fail in CakeMapper - getBottom");
            e.printStackTrace();
        }
        return bottom;
    }

    public Toppings getTopping(String t) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Toppings topping = null;

        String SQLString
                = "select * "
                + "from Toppings "
                + "where topping = ?";
        try {
            stmt = con.prepareStatement(SQLString);
            stmt.setString(1, t);
            rs = stmt.executeQuery();

            if (rs.next()) {
                topping = new Toppings(t, rs.getInt("price"));
            }
        } catch (SQLException e) {
            System.out.println("Fail in CakeMapper - getTopping");
            System.out.println(e.getMessage());
        }
        return topping;
    }

    public User getUser(String u) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        User user = null;

        String SQLString
                = "select * from User where userID = ?";
        try {
            stmt = con.prepareStatement(SQLString);
            stmt.setString(1, u);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(u, rs.getString("password"), rs.getInt("balance"));
            }
        } catch (SQLException e) {
            System.out.println("Fail in CakeMapper - getUser");
            e.printStackTrace();
        }
        return user;
    }

}
