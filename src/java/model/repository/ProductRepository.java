package model.repository;

import controller.dto.ProductDTO;
import model.Entity.Product;

import java.util.List;

public interface ProductRepository {
    void addProduct(ProductDTO productDTO);
    int findIdProductByName(String name);
    List<Product> ListProductByName();
}
