package Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import controller.dto.ProductDTO;
import model.Entity.Product;

public class ProductConverter {

    public Product convertProductDTOToProductEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getIdProduct());
        product.setProductName(productDTO.getNameProduct());
        product.setDescription(productDTO.getProductDescription());
        product.setPrice(Float.parseFloat(productDTO.getPriceForBuyProduct()));
        product.setLinkKeyGame(productDTO.getLinkKeyProduct());
        product.setDateOfUpdate(productDTO.getDateCreated());
        product.setUserId(productDTO.getUserId());
        product.setTypeProductId(1);
        product.setProductImage(productDTO.getImageProduct());
        return product;
    }

    public ProductDTO convertProductEntityToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(product.getProductId());
        productDTO.setNameProduct(product.getProductName());
        productDTO.setProductDescription(product.getDescription());
        productDTO.setPriceForBuyProduct(Float.toString(product.getPrice()));
        productDTO.setLinkKeyProduct(product.getLinkKeyGame());
        productDTO.setImageProduct(product.getProductImage());
        return productDTO;
    }
}
