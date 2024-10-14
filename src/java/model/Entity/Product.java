package model.Entity;

public class Product {
    private int productId;
    private String productName;
    private String productImage;
    private String dateOfUpdate; // Sử dụng LocalDate nếu cần
    private int price;
    private boolean active;

    // Constructor không tham số
    public Product() {}

    // Constructor có tham số
    public Product(int productId, String productName, String productImage, String dateOfUpdate, int price, boolean active) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.dateOfUpdate = dateOfUpdate;
        this.price = price;
        this.active = active;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Phương thức để hiển thị thông tin đối tượng Product
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", dateOfUpdate='" + dateOfUpdate + '\'' +
                ", price=" + price +
                ", active=" + active +
                '}';
    }
}
