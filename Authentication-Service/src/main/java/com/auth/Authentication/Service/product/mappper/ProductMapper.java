package com.auth.Authentication.Service.product.mappper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import com.auth.Authentication.Service.product.Dto.ProductDto;
import com.auth.Authentication.Service.product.Dto.ProductESDto;
import com.auth.Authentication.Service.product.Dto.ProductResourceDto;
import com.auth.Authentication.Service.product.Dto.ProductVariantDto;
import com.auth.Authentication.Service.product.model.Category;
import com.auth.Authentication.Service.product.model.CategoryType;
import com.auth.Authentication.Service.product.model.Product;
import com.auth.Authentication.Service.product.model.ProductVariant;
import com.auth.Authentication.Service.product.model.Resources;
import com.auth.Authentication.Service.product.service.CategoryService;


@Component
public class ProductMapper {

    @Autowired
    private CategoryService categoryService;

    public Product mapToProductEntity(ProductDto productDto){
        Product product = new Product();
        if(null != productDto.getId()){
            product.setId(productDto.getId());
        }
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setBrand(productDto.getBrand());
        product.setNewArrival(productDto.isNewArrival());
        product.setPrice(productDto.getPrice());
        product.setRating(productDto.getRating());
        product.setSlug(productDto.getSlug());

        Category category = categoryService.getCategory(productDto.getCategoryId());
        if(null != category){
            product.setCategory(category);
            UUID categoryTypeId = productDto.getCategoryTypeId();

            CategoryType categoryType = category.getCategoryTypes().stream().filter(categoryType1 -> categoryType1.getId().equals(categoryTypeId)).findFirst().orElse(null);
            product.setCategoryType(categoryType);
        }

        if(null != productDto.getVariants()){
            product.setProductVariants(mapToProductVariant(productDto.getVariants(),product));
        }

        if(null != productDto.getProductResources()){
            product.setResources(mapToProductResources(productDto.getProductResources(),product));
        }



        return product;
    }

    private List<Resources> mapToProductResources(List<ProductResourceDto> productResources, Product product) {

        return productResources.stream().map(productResourceDto -> {
            Resources resources= new Resources();
            if(null != productResourceDto.getId()){
                resources.setId(productResourceDto.getId());
            }
            resources.setName(productResourceDto.getName());
            resources.setType(productResourceDto.getType());
            resources.setUrl(productResourceDto.getUrl());
            resources.setIsPrimary(productResourceDto.getIsPrimary());
            resources.setProduct(product);
            return resources;
        }).collect(Collectors.toList());
    }

    private List<ProductVariant> mapToProductVariant(List<ProductVariantDto> productVariantDtos, Product product){
        return productVariantDtos.stream().map(productVariantDto -> {
            ProductVariant productVariant = new ProductVariant();
            if(null != productVariantDto.getId()){
                productVariant.setId(productVariantDto.getId());
            }
            productVariant.setColor(productVariantDto.getColor());
            productVariant.setSize(productVariantDto.getSize());
            productVariant.setStockQuantity(productVariantDto.getStockQuantity());
            productVariant.setProduct(product);
            return productVariant;
        }).collect(Collectors.toList());
    }

    public List<ProductDto> getProductDtos(List<Product> products) {
        return products.stream().map(this::mapProductToDto).toList();
    }

    public ProductDto mapProductToDto(Product product) {
    	ProductDto productDto = new ProductDto();
    	productDto.setId(product.getId());
    	productDto.setBrand(product.getBrand());
    	productDto.setName(product.getName());
    	productDto.setPrice(product.getPrice());
    	productDto.setNewArrival(product.isNewArrival());
    	productDto.setRating(product.getRating());
    	productDto.setDescription(product.getDescription());
    	productDto.setSlug(product.getSlug());
    	productDto.setCategoryId(product.getCategory().getId());
    	productDto.setCategoryTypeId(product.getCategoryType().getId());
    	productDto.setCategoryName(product.getCategory().getName());
    	productDto.setCategoryTypeName(product.getCategoryType().getName());
    	productDto.setThumbnail(getProductThumbnail(product.getResources()));
    	return productDto;
    }
    
    public ProductESDto mapProductToESDTO(Product product) {
    	ProductESDto dto = new ProductESDto();
    	dto.setProductId(product.getId().toString());
    	dto.setName(product.getName());
    	dto.setDescription(product.getDescription());
    	dto.setCategoryName(product.getCategory().getDescription());
    	dto.setCategoryTypeName(product.getCategoryType().getDescription());
    	dto.setColor(product.getProductVariants().get(0).getColor());
    	dto.setPrice(product.getPrice());
    	dto.setBrand(product.getBrand());
    	dto.setUrl(product.getResources().get(0).getUrl());
    	return dto;
    }

    private String getProductThumbnail(List<Resources> resources) {
//        return resources.stream().filter(Resources::getIsPrimary).findFirst().orElse(null).getUrl();
    	return resources
    			.stream()
                .filter(res -> StringUtils.isNotBlank(res.getUrl()))
                .findFirst()
                .map(Resources::getUrl)
                .orElse(null);  
    }

    public List<ProductVariantDto> mapProductVariantListToDto(List<ProductVariant> productVariants) {
       return productVariants.stream().map(this::mapProductVariantDto).toList();
    }

    private ProductVariantDto mapProductVariantDto(ProductVariant productVariant) {
    	ProductVariantDto productVariantDto = new ProductVariantDto();
    	productVariantDto.setColor(productVariant.getColor());
    	productVariantDto.setId(productVariant.getId());
    	productVariantDto.setSize(productVariant.getSize());
    	productVariantDto.setStockQuantity(productVariant.getStockQuantity());
        return productVariantDto;
    }

    public List<ProductResourceDto> mapProductResourcesListDto(List<Resources> resources) {
        return resources.stream().map(this::mapResourceToDto).toList();
    }

    private ProductResourceDto mapResourceToDto(Resources resources) {
    	ProductResourceDto productResourceDto = new ProductResourceDto();
    	productResourceDto.setId(resources.getId());
    	productResourceDto.setUrl(resources.getUrl());
    	productResourceDto.setName(resources.getName());
    	productResourceDto.setIsPrimary(resources.getIsPrimary());
    	productResourceDto.setType(resources.getType());
        return productResourceDto;
    }
}
