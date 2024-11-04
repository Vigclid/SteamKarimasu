package model.repository.impl;

import db.ConnectDB;
import model.repository.ProductBillRepository;

import java.sql.Connection;

public class ProductBillRepositoryImpl implements ProductBillRepository {

    @Override
    public void DeleteProductBillByProductId(int productId) {
        String sql = "DELETE FROM productbill WHERE productid = " + productId;
        try{
            ConnectDB db = new ConnectDB();
            Connection conn = db.openConnecion();
            conn.createStatement().executeUpdate(sql);
            conn.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
