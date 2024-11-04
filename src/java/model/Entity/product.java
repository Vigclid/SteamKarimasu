package model.Entity;

public class product {
    private int productId;
    private String productName;
    private String productImage;
    private String prodcuctDescription;
    private String dateOfUpdate; // Sử dụng LocalDate nếu cần
    private String LinkKeyGame;
    private float price;
    private int UserId;
    private int TypeId;

    // Constructor không tham số
    public product() {}

    // Constructor có tham số
    public product(int productId, String productName, String productImage, String prodcuctDescription, String dateOfUpdate, String linkKeyGame, float price, int userId, int typeId) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.prodcuctDescription = prodcuctDescription;
        this.dateOfUpdate = dateOfUpdate;
        this.LinkKeyGame = linkKeyGame;
        this.price = price;
        this.UserId = userId;
        this.TypeId = typeId;
    }

    // Getter và Setter


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProdcuctDescription() {
        return prodcuctDescription;
    }

    public void setProdcuctDescription(String prodcuctDescription) {
        this.prodcuctDescription = prodcuctDescription;
    }

    public String getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(String dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public String getLinkKeyGame() {
        return LinkKeyGame;
    }

    public void setLinkKeyGame(String linkKeyGame) {
        LinkKeyGame = linkKeyGame;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    @Override
    public String toString() {
        return "product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", prodcuctDescription='" + prodcuctDescription + '\'' +
                ", dateOfUpdate='" + dateOfUpdate + '\'' +
                ", LinkKeyGame='" + LinkKeyGame + '\'' +
                ", price=" + price +
                ", UserId=" + UserId +
                ", TypeId=" + TypeId +
                '}';
    }
}