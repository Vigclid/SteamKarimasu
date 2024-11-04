package repository;

public interface ListRentRepository {
    void addListRent(int productID, int userID);

    boolean checkUserHaveProduct(int productID, int userID);
}
