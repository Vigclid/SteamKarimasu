package model.Entity;

public class productDetail {
    private int idDetailProduct;  // Auto-incremented ID
    private String accountProduct; // Account username
    private String passwordAccount; // Account password
    private int productId;

    public productDetail() {
    }

    public int getIdDetailProduct() {
        return idDetailProduct;
    }

    public void setIdDetailProduct(int idDetailProduct) {
        this.idDetailProduct = idDetailProduct;
    }

    public String getAccountProduct() {
        return accountProduct;
    }

    public void setAccountProduct(String accountProduct) {
        this.accountProduct = accountProduct;
    }

    public String getPasswordAccount() {
        return passwordAccount;
    }

    public void setPasswordAccount(String passwordAccount) {
        this.passwordAccount = passwordAccount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
