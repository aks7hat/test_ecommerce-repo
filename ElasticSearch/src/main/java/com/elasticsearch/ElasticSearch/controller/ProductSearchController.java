package com.elasticsearch.ElasticSearch.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.ElasticSearch.dto.ProductDto;
import com.elasticsearch.ElasticSearch.model.Product;
import com.elasticsearch.ElasticSearch.service.ProductSearchService;

@RestController
@RequestMapping("/api/search")
@CrossOrigin
public class ProductSearchController {
	
	@Autowired
    private ProductSearchService searchService;
	
    @Value("${custom.env.variable}")
    private String envVariable;
    
	
    @GetMapping("/{query}")
    public List<Product> searchProducts(@PathVariable String query) {
    	List<Product> ar= new ArrayList<>();
        try {
			return searchService.searchProducts(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ar;
    }

    @PostMapping
    public String indexProduct(@RequestBody ProductDto productDto) {
        searchService.saveProduct(productDto);
        return "Product indexed successfully";
    }

    
    @GetMapping("/greet")
    public String test() {
    	return "Hello, Env variable is " +envVariable ;
    }
}
