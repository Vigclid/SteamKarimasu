package repository;

import controller.dto.ProductDTO;
import model.Entity.product;

import java.util.List;

public interface ProductRepository {
    void addProduct(ProductDTO productDTO);
    int findIdProductByName(String name);
    List<product> ListProductByName();
    product findProductById(int id);
    product findProductByName(String name);
    List<product> ListProduct();

}