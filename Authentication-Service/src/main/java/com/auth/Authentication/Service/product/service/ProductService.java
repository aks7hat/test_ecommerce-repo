package com.auth.Authentication.Service.product.service;

import java.util.List;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.auth.Authentication.Service.product.Dto.ProductDto;
import com.auth.Authentication.Service.product.Dto.ProductESDto;
import com.auth.Authentication.Service.product.exceptions.ResourceNotFoundEx;
import com.auth.Authentication.Service.product.mappper.ProductMapper;
import com.auth.Authentication.Service.product.model.Product;
import com.auth.Authentication.Service.product.repo.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${elastic.search.service.url}")
    private String elasticSearchBaseUrl;
    
    
    public Product addProduct(ProductDto productDto) {
        Product product = productMapper.mapToProductEntity(productDto);
        Product savedProd =  productRepository.save(product);
    	ProductESDto dto = productMapper.mapProductToESDTO(savedProd);
    	String url = elasticSearchBaseUrl + "/api/search";
    	String res = restTemplate.postForObject(url, dto, String.class);
        return savedProd;
    }

    public List<ProductDto> indexAllProducts() {
        List<Product> products = productRepository.findAll();
        for(Product prod : products) {
        	ProductESDto dto = productMapper.mapProductToESDTO(prod);
        	String url = elasticSearchBaseUrl + "/api/search";
        	String res = restTemplate.postForObject(url, dto, String.class);        	
        }
        return productMapper.getProductDtos(products);
    }

    public List<ProductDto> getAllProducts(UUID categoryId, UUID typeId) {

        Specification<Product> productSpecification= Specification.where(null);

        if(null != categoryId){
            productSpecification = productSpecification.and(ProductSpecification.hasCategoryId(categoryId));
        }
        if(null != typeId){
            productSpecification = productSpecification.and(ProductSpecification.hasCategoryTypeId(typeId));
        }

        List<Product> products = productRepository.findAll(productSpecification);
        return productMapper.getProductDtos(products);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.getProductDtos(products);
    }

    public ProductDto getProductBySlug(String slug) {
        Product product= productRepository.findBySlug(slug);
        if(null == product){
            throw new ResourceNotFoundEx("Product Not Found!");
        }
        ProductDto productDto = productMapper.mapProductToDto(product);
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setCategoryTypeId(product.getCategoryType().getId());
        productDto.setVariants(productMapper.mapProductVariantListToDto(product.getProductVariants()));
        productDto.setProductResources(productMapper.mapProductResourcesListDto(product.getResources()));
        return productDto;
    }


    public ProductDto getProductById(UUID id) {
        Product product= productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundEx("Product Not Found!"));
        ProductDto productDto = productMapper.mapProductToDto(product);
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setCategoryTypeId(product.getCategoryType().getId());
        productDto.setVariants(productMapper.mapProductVariantListToDto(product.getProductVariants()));
        productDto.setProductResources(productMapper.mapProductResourcesListDto(product.getResources()));
        return productDto;
    }


    public Product updateProduct(ProductDto productDto, UUID id) {
        Product product= productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundEx("Product Not Found!"));
        productDto.setId(product.getId());
        return productRepository.save(productMapper.mapToProductEntity(productDto));
    }


    public Product fetchProductById(UUID id) throws Exception {
        return productRepository.findById(id).orElseThrow(BadRequestException::new);
    }
    
    public List<ProductDto> fetchProductByTypeId(String typeName) {
    	List<Product> products = productRepository.findByCategoryTypeName(typeName);
    	return productMapper.getProductDtos(products);
    }
    
    public List<ProductDto> fetchProductByTypeIdAndCategoryId(String typeName, UUID categoryId) {
    	List<Product> products = productRepository.findByCategoryTypeNameAndCategoryId(typeName, categoryId);
    	return productMapper.getProductDtos(products);
    }

}
