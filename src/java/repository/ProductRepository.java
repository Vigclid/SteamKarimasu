package repository;

import controller.dto.ProductDTO;
import model.Entity.product;

import java.util.List;

public interface ProductRepository {
    void addProduct(ProductDTO productDTO);
    int findIdProductByName(String name);
    List<product> ListProductByName();
}