package Converter;

import controller.dto.ProductDTO;
import model.Entity.product;

public class ProductConverter {

    public product convertProductDTOToProductEntity(ProductDTO productDTO) {
        product product = new product();
        product.setProductName(productDTO.getNameProduct());
        product.setProductImage(productDTO.getImageProduct());
        product.setProdcuctDescription(productDTO.getProductDescription());
        product.setPrice(Float.parseFloat(productDTO.getPriceForBuyProduct()));
        product.setLinkKeyGame(productDTO.getLinkKeyProduct());
        product.setDateOfUpdate(productDTO.getDateCreated());
        product.setUserId(productDTO.getUserId());
        product.setTypeId(1);
        return product;
    }

    public ProductDTO convertProductEntityToProductDTO(product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(product.getProductId());
        productDTO.setNameProduct(product.getProductName());
        productDTO.setImageProduct(product.getProductImage());
        productDTO.setProductDescription(product.getProdcuctDescription());
        productDTO.setPriceForBuyProduct(Float.toString(product.getPrice()));
        productDTO.setLinkKeyProduct(product.getLinkKeyGame());
        return productDTO;
    }
}