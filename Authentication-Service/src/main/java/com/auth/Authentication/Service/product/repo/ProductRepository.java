package com.auth.Authentication.Service.product.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auth.Authentication.Service.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>, JpaSpecificationExecutor<Product> {

    Product findBySlug(String slug);
    
    @Query(value = "select p.* from products as p Join category_type as cti on cti.id = p.category_type_id where cti.name like %?1%", nativeQuery = true)
    List<Product> findByCategoryTypeName(String typeName);
    
    @Query(value = "Select p.* from products as p Join category_type as cti on cti.id = p.category_type_id where cti.name like %?1% and p.category_id = ?2", nativeQuery = true)
    List<Product> findByCategoryTypeNameAndCategoryId(String typeName, UUID categoryId);

}
