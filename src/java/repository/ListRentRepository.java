package repository;

import model.Entity.ListRent;
import model.Entity.user;

import java.util.List;

public interface ListRentRepository {
    void addListRent(int productID, int userID);

    boolean checkUserHaveProduct(int productID, int userID);

    public List<ListRent> getListRent(int idProduct);
    public void deleteByListRentId(int id);
}
