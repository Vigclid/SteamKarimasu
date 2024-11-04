package repository;

public interface ProductBillRepository {
    void addProductBill(int productID, int userID);

    boolean checkUserHaveProduct(int productID, int userID);
}
