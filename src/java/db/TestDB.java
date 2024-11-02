package db;

import model.Entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDB implements DatabaseInfo {
    public static void main(String[] args) throws Exception {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.openConnecion();
        String sql = "SELECT * FROM products";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            int productId = rs.getInt(1);
            String productName = rs.getString(2);
            String productImg = rs.getString(3);
            String Description = rs.getString(4);
            String Date = rs.getString(5);
            String link_game = rs.getString(6);
            con.close();
            stmt.close();
            rs.close();
            System.out.println(productId + "|" + productName + "|" + productImg + "|" + Description + "|" + Date + "|" + link_game );
        }

    }
}