package model.Entity;

public class ListRent {
    private int listRentId;
    private int productId;
    private int userId;

    public ListRent() {
    }

    public int getListRentId() {
        return listRentId;
    }

    public void setListRentId(int listRentId) {
        this.listRentId = listRentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
