package repository.impl;

import db.ConnectDB;
import repository.ListRentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListRentRepositoryImpl implements ListRentRepository {


    @Override
    public void addListRent(int productID, int userID) {
        
    }

    @Override
    public boolean checkUserHaveProduct(int productID, int userID) {
        return false;
    }
}
