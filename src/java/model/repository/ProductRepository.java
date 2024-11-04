package model.repository;

import controller.dto.ProductDTO;
import model.Entity.Product;

import java.util.List;

public interface ProductRepository {
    void addProduct(ProductDTO productDTO);
    int findIdProductByName(String name);
    List<Product> ListProduct();
    Product findProductById(int id);
    Product findProductByName(String name);
    void updateProduct(ProductDTO productDTO);
    void deleteProductById(int id);
}
