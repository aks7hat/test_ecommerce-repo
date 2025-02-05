package com.auth.Authentication.Service.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.Authentication.Service.product.Dto.ProductDto;
import com.auth.Authentication.Service.product.model.Product;
import com.auth.Authentication.Service.product.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false,name = "categoryId",value = "categoryId") UUID categoryId, 
    		@RequestParam(required = false,name = "typeId",value = "typeId") UUID typeId, 
    		@RequestParam(required = false) String slug, HttpServletResponse response){
        List<ProductDto> productList = new ArrayList<>();
        if(!StringUtils.isEmpty(slug)){
            ProductDto productDto = productService.getProductBySlug(slug);
            productList.add(productDto);
        }
        else {
            productList = productService.getAllProducts(categoryId, typeId);
        }
        response.setHeader("Content-Range",String.valueOf(productList.size()));
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
    	List<ProductDto> productsList = productService.getAllProducts();
    	return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable UUID id){
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        Product product = productService.addProduct(productDto);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto,@PathVariable UUID id){
        Product product = productService.updateProduct(productDto,id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    
    @GetMapping("/type/{typeName}")
    public ResponseEntity<List<ProductDto>> fetchProductByTypeId(@PathVariable String typeName,
    		@RequestParam(required = false,name = "categoryId",value = "categoryId") UUID categoryId){
    	List<ProductDto> productList = new ArrayList<>();
    	if(null != categoryId) {
    		productList = productService.fetchProductByTypeIdAndCategoryId(typeName, categoryId);
    	}
    	else {
    		productList = productService.fetchProductByTypeId(typeName);
    	}
    	return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    
    @PostMapping("/indexAll")
    public String indexAllProducts() {
    	String response = "";
    	try {
    		productService.indexAllProducts();
    		response = "Indexed all products";
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		response = "error";
    	}
    	return response;
    }


}
