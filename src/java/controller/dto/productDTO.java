package controller.dto;

import java.io.File;

public class productDTO {
    private int idProduct;
    private String nameProduct;
    private double priceForBuyProduct;
    private double priceForRentProduct;
    private String productDescription;
    private String accountProduct;
    private String passwordProduct;
    private String imageProduct;
    private String imageBase64;

    public productDTO() {
    }

    public productDTO(String nameProduct, double priceForBuyProduct, String productDescription, double priceForRentProduct, String accountProduct, String passwordProduct, String imageProduct) {
        this.nameProduct = nameProduct;
        this.priceForBuyProduct = priceForBuyProduct;
        this.productDescription = productDescription;
        this.priceForRentProduct = priceForRentProduct;
        this.accountProduct = accountProduct;
        this.passwordProduct = passwordProduct;
        this.imageProduct = imageProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPriceForBuyProduct() {
        return priceForBuyProduct;
    }

    public void setPriceForBuyProduct(double priceForBuyProduct) {
        this.priceForBuyProduct = priceForBuyProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceForRentProduct() {
        return priceForRentProduct;
    }

    public void setPriceForRentProduct(double priceForRentProduct) {
        this.priceForRentProduct = priceForRentProduct;
    }

    public String getAccountProduct() {
        return accountProduct;
    }

    public void setAccountProduct(String accountProduct) {
        this.accountProduct = accountProduct;
    }

    public String getPasswordProduct() {
        return passwordProduct;
    }

    public void setPasswordProduct(String passwordProduct) {
        this.passwordProduct = passwordProduct;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public productDTO(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
    public String getImageBase64() {
        return imageBase64;
    }
}
