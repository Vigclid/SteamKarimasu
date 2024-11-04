package model.repository;

import model.Entity.ListRent;

import java.util.List;

public interface ListRentRepository {
    List<ListRent> getListRent(int idProduct);
    void deleteByListRentId(int id);
}
