package repository.impl;

import db.ConnectDB;
import repository.TypeProductRepository;

import java.sql.Connection;

public class TypeProductRepositoryImpl implements TypeProductRepository {
    @Override
    public void deleteProductBillByProductId(int productId) {
        String sql = "DELETE FROM typeproduct ";
        String where = "WHERE TypeId = (SELECT TypeId FROM products WHERE ProductId ="+ productId +" )";
        String querySql = sql + where;

        try {
            ConnectDB db = new ConnectDB();
            Connection conn = db.openConnecion();
            conn.createStatement().executeUpdate(querySql);
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}