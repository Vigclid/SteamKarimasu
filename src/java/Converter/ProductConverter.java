package Converter;

import controller.dto.ProductDTO;
import model.Entity.Product;

public class ProductConverter {

    public Product convertProductDTOToProductEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getNameProduct());
        product.setProductImage(productDTO.getImageProduct());
        product.setDescription(productDTO.getProductDescription());
        product.setPrice(Float.parseFloat(productDTO.getPriceForBuyProduct()));
        product.setLinkKeyGame(productDTO.getLinkKeyProduct());
        product.setDateOfUpdate(productDTO.getDateCreated());
        product.setUserId(productDTO.getUserId());
        product.setTypeProductId(1);
        return product;
    }

    public ProductDTO convertProductEntityToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(product.getProductId());
        productDTO.setNameProduct(product.getProductName());
        productDTO.setImageProduct(product.getProductImage());
        productDTO.setProductDescription(product.getDescription());
        productDTO.setPriceForBuyProduct(Float.toString(product.getPrice()));
        productDTO.setLinkKeyProduct(product.getLinkKeyGame());
        return productDTO;
    }
}
