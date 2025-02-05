package com.elasticsearch.ElasticSearch.mapper;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.elasticsearch.ElasticSearch.dto.ProductDto;
import com.elasticsearch.ElasticSearch.model.Category;
import com.elasticsearch.ElasticSearch.model.CategoryType;
import com.elasticsearch.ElasticSearch.model.Product;
import com.elasticsearch.ElasticSearch.model.ProductVariant;
import com.elasticsearch.ElasticSearch.model.Resource;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Product mapToProduct(Map<String, Object> sourceMap) {
        Product product = new Product();

        // Map basic fields
        product.setId((String) sourceMap.get("id"));
        product.setProductId((String) sourceMap.get("productId"));
        product.setName((String) sourceMap.get("name"));
        product.setDescription((String) sourceMap.get("description"));
        product.setPrice(sourceMap.get("price") != null ? new BigDecimal(sourceMap.get("price").toString()) : null);
        product.setBrand((String) sourceMap.get("brand"));
        product.setColor((String) sourceMap.get("color"));
        product.setCategoryName((String) sourceMap.get("categoryName"));
        product.setCategoryTypeName((String) sourceMap.get("categoryTypeName"));
        product.setUrl((String) sourceMap.get("url"));
//        product.setRating(sourceMap.get("rating") != null ? Float.parseFloat(sourceMap.get("rating").toString()) : null);
//        product.setNewArrival(sourceMap.get("isNewArrival") != null && (Boolean) sourceMap.get("isNewArrival"));
//        product.setSlug((String) sourceMap.get("slug"));
//        product.setCreatedAt(sourceMap.get("createdAt") != null ? new Date((Long) sourceMap.get("createdAt")) : null);
//        product.setUpdatedAt(sourceMap.get("updatedAt") != null ? new Date((Long) sourceMap.get("updatedAt")) : null);
//
//        // Map nested fields
//        product.setProductVariants(mapToProductVariants((List<Map<String, Object>>) sourceMap.get("productVariants")));
//        product.setCategory(mapToCategory((Map<String, Object>) sourceMap.get("category")));
//        product.setCategoryType(mapToCategoryType((Map<String, Object>) sourceMap.get("categoryType")));
//        product.setResources(mapToResources((List<Map<String, Object>>) sourceMap.get("resources")));

        return product;
    }

    private static List<ProductVariant> mapToProductVariants(List<Map<String, Object>> variants) {
        List<ProductVariant> productVariants = new ArrayList<>();
        if (variants != null) {
            for (Map<String, Object> variantMap : variants) {
                ProductVariant variant = new ProductVariant();
                variant.setId((String) variantMap.get("id"));
                variant.setColor((String) variantMap.get("color"));
                variant.setSize((String) variantMap.get("size"));
                variant.setStockQuantity(variantMap.get("stockQuantity") != null
                        ? Integer.parseInt(variantMap.get("stockQuantity").toString())
                        : null);
                productVariants.add(variant);
            }
        }
        return productVariants;
    }

    private static Category mapToCategory(Map<String, Object> categoryMap) {
        if (categoryMap == null) {
            return null;
        }
        Category category = new Category();
        category.setId((String) categoryMap.get("id"));
        category.setName((String) categoryMap.get("name"));
        category.setCode((String) categoryMap.get("code"));
        category.setDescription((String) categoryMap.get("description"));
        category.setCategoryTypes(mapToCategoryTypes((List<Map<String, Object>>) categoryMap.get("categoryTypes")));
        return category;
    }

    private static List<CategoryType> mapToCategoryTypes(List<Map<String, Object>> types) {
        List<CategoryType> categoryTypes = new ArrayList<>();
        if (types != null) {
            for (Map<String, Object> typeMap : types) {
                CategoryType type = new CategoryType();
                type.setId((String) typeMap.get("id"));
                type.setName((String) typeMap.get("name"));
                type.setCode((String) typeMap.get("code"));
                type.setDescription((String) typeMap.get("description"));
                categoryTypes.add(type);
            }
        }
        return categoryTypes;
    }

    private static CategoryType mapToCategoryType(Map<String, Object> categoryTypeMap) {
        if (categoryTypeMap == null) {
            return null;
        }
        CategoryType categoryType = new CategoryType();
        categoryType.setId((String) categoryTypeMap.get("id"));
        categoryType.setName((String) categoryTypeMap.get("name"));
        categoryType.setCode((String) categoryTypeMap.get("code"));
        categoryType.setDescription((String) categoryTypeMap.get("description"));
        return categoryType;
    }

    private static List<Resource> mapToResources(List<Map<String, Object>> resourceMaps) {
        List<Resource> resources = new ArrayList<>();
        if (resourceMaps != null) {
            for (Map<String, Object> resourceMap : resourceMaps) {
                Resource resource = new Resource();
                resource.setId((String) resourceMap.get("id"));
                resource.setName((String) resourceMap.get("name"));
                resource.setUrl((String) resourceMap.get("url"));
                resource.setIsPrimary(resourceMap.get("isPrimary") != null && (Boolean) resourceMap.get("isPrimary"));
                resource.setType((String) resourceMap.get("type"));
                resources.add(resource);
            }
        }
        return resources;
    }
    
    public static Product mapProductDtoToProduct(ProductDto productDto) {
    	Product product = new Product();
    	product.setProductId(productDto.getProductId());
    	product.setName(productDto.getName());
    	product.setDescription(productDto.getDescription());
    	product.setCategoryName(productDto.getCategoryName());
    	product.setCategoryTypeName(productDto.getCategoryTypeName());
    	product.setColor(productDto.getColor());
    	product.setPrice(productDto.getPrice());
    	product.setBrand(productDto.getBrand());
    	product.setUrl(productDto.getUrl());
    	return product;
    }
}
