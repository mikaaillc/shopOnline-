package com.example.shoponline.Service.Concrete;

import com.example.shoponline.Entities.Product;
import com.example.shoponline.Repository.ProductRepository;
import com.example.shoponline.Service.Abstract.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{


    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getDetailByProductId(Long productId) {
        return productRepository.getById(productId);
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.getProductsByCategoryId(categoryId);
    }

    @Override
    public List<Product> getByProductNameContains(String productName) {
        return productRepository.getByProductNameContains(productName);
    }

    @Override
    public List<Product> getProductsByActive(Boolean active) {
        return productRepository.getProductsByActive(active);
    }

    @Override
    public Product getProductByBarcode(String barcode) {
        return productRepository.getProductByBarcode(barcode);
    }

    @Override
    public Boolean saveProduct(Product product) {
        try {
            product.setCreateDate(Timestamp.from(Instant.now()));
            //todo
            //user login olduktan sora id de save yapılırken setlencek product a
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();//Bütün hata adımlarını gösterir
            return false;
        }
    }

    @Override
    public Boolean deleteByProductId(Long productId) {
        try {
            Product product = productRepository.getById(productId);
            if (product != null) {
                productRepository.deleteById(productId);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Product updateProduct(Long productId,Product product) {
        Optional<Product> product1 = productRepository.findById(productId);
        if(product1.isPresent()){
            Product foundProduct=product1.get();
            foundProduct.setProductName(product.getProductName());
            foundProduct.setActive(product.getActive());
            foundProduct.setBarcode(product.getBarcode());
            foundProduct.setDiscount(product.getDiscount());
            foundProduct.setPrice(product.getPrice());
            foundProduct.setStock(product.getStock());
            foundProduct.setCategory(product.getCategory());
            foundProduct.setCreateDate(Timestamp.from(Instant.now()));
            //todo Son güncelleyen userId login işlemlerinden sonra setlenecek
            productRepository.save(foundProduct);
            return foundProduct;
        }else{
            return null;
        }

    }


}
