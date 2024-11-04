package model.Entity;

public class ListRent {
    private int ListRentId, productId, userId;

    public ListRent(int listRentId, int productId, int userId) {
        ListRentId = listRentId;
        this.productId = productId;
        this.userId = userId;
    }

    public ListRent(){

    }

    public int getListRentId() {
        return ListRentId;
    }

    public void setListRentId(int listRentId) {
        ListRentId = listRentId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ListRent{" +
                "ListRentId=" + ListRentId +
                ", productId=" + productId +
                ", userId=" + userId +
                '}';
    }
}
