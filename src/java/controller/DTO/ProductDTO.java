package controller.DTO;

public class ProductDTO {
    private int idProduct;
    private String nameProduct;
    private String priceForBuyProduct;
    private String productDescription;
    private String imageProduct;
    private String imageBase64;
    private String linkKeyProduct;
    private String DateCreated;
    private int userId;
    public ProductDTO() {
    }

    public ProductDTO(String nameProduct, String imageProduct, String productDescription, String linkKeyProduct,String priceForBuyProduct, int userId,String dateCreated) {
        this.nameProduct = nameProduct;
        this.priceForBuyProduct = priceForBuyProduct;
        this.productDescription = productDescription;
        this.imageProduct = imageProduct;
        this.linkKeyProduct = linkKeyProduct;
        this.DateCreated = dateCreated;
        this.userId = userId;
    }

    public ProductDTO(int idProduct, String nameProduct, String imageProduct, String productDescription, String DateCreated ,String linkKeyProduct, String priceForBuyProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceForBuyProduct = priceForBuyProduct;
        this.productDescription = productDescription;
        this.imageProduct = imageProduct;
        this.linkKeyProduct = linkKeyProduct;
        this.DateCreated = DateCreated;
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

    public String getPriceForBuyProduct() {
        return priceForBuyProduct;
    }

    public void setPriceForBuyProduct(String priceForBuyProduct) {
        this.priceForBuyProduct = priceForBuyProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }


    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public ProductDTO(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getLinkKeyProduct() {
        return linkKeyProduct;
    }

    public void setLinkKeyProduct(String linkKeyProduct) {
        this.linkKeyProduct = linkKeyProduct;
    }

    public String getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(String dateCreated) {
        DateCreated = dateCreated;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}