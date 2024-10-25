package model.Entity;

public class Product {
    private int productId;
    private String productName;
    private String productImage;
    private String dateOfUpdate; // Sử dụng LocalDate nếu cần
    private String description;

    // Constructor không tham số
    public Product() {}

    // Constructor có tham số
    public Product(int productId, String productName, String productImage, String dateOfUpdate, String description) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.dateOfUpdate = dateOfUpdate;
        this.description = description;
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
