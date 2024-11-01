package model.Entity;

public class Product {
    private int productId;
    private String productName;
    private String productImage;
    private String dateOfUpdate; // Sử dụng LocalDate nếu cần
    private String description;
    private float price;
    private String linkKeyGame;
    private int userId;
    private int typeProductId;

    // Constructor không tham số
    public Product() {}

    // Constructor có tham số
    public Product(int productId, String productName, String productImage, String description, float price, String linkKeyGame) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.dateOfUpdate = dateOfUpdate;
        this.description = description;
        this.price = price;
        this.linkKeyGame = linkKeyGame;
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

    public String getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(String dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLinkKeyGame() {
        return linkKeyGame;
    }

    public void setLinkKeyGame(String linkKeyGame) {
        this.linkKeyGame = linkKeyGame;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(int typeProductId) {
        this.typeProductId = typeProductId;
    }

    // Phương thức để hiển thị thông tin đối tượng Product
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", dateOfUpdate='" + dateOfUpdate + '\'' +
                '}';
    }
}
