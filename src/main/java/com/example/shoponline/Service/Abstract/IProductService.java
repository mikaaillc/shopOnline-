package com.example.shoponline.Service.Abstract;

import com.example.shoponline.Entities.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    Product getDetailByProductId(Long productId);
    List<Product> getProductsByCategoryId(Long categoryId);
    List<Product> getByProductNameContains(String productName);
    List<Product> getProductsByActive(Boolean active);
    Product getProductByBarcode(String barcode);
    Boolean saveProduct(Product product);
    Boolean deleteByProductId(Long productId);
    Product updateProduct(Long productId,Product product);

}
