package com.example.shoponline.Controller;

import com.example.shoponline.Entities.Product;
import com.example.shoponline.Service.Abstract.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/Product")//
public class ProductController {


    @Autowired
    private IProductService iProductService;

    public ProductController(IProductService iProductService){
        this.iProductService=iProductService;
    }

    @GetMapping("/getAllProduct")
    private List<Product> getAllProduct(){
     return iProductService.getAllProduct();
    }

    @GetMapping("/getDetailByProductId")
    @ResponseBody
    private Product getDetailByProductId(@RequestParam Long ProductId){
        return iProductService.getDetailByProductId(ProductId);
    }

    @GetMapping("/getProductsByCategoryId")
    @ResponseBody
    private List<Product> getProductsByCategoryId(@RequestParam Long categoryId){
        return  iProductService.getProductsByCategoryId(categoryId);
    }

    @GetMapping("/getByProductNameContains/{productName}")
    private List<Product> getByProductNameContains(@PathVariable String productName){
        return  iProductService.getByProductNameContains(productName);
    }

    @GetMapping("/getProductsByActive/")
    @ResponseBody
    private List<Product> getProductsByActive(@RequestParam boolean active){
        return  iProductService.getProductsByActive(active);
    }

    @GetMapping("/getProductByBarcode/{barcode}")
    private Product getProductByBarcode(@PathVariable String barcode){
        return  iProductService.getProductByBarcode(barcode);
    }

    @PostMapping("/addProduct")
    private Boolean saveProduct(@RequestBody Product newProduct){
        return  iProductService.saveProduct(newProduct);
    }

    @DeleteMapping("/deleteByProductId/{productId}")
    private Boolean deleteByProductId(@PathVariable Long productId){
        return  iProductService.deleteByProductId(productId);
    }

    @PutMapping("/updateProduct/{productId}")
    private Product updateProduct(@PathVariable Long productId,@RequestBody Product product){
        return  iProductService.updateProduct(productId,product);
    }




}
