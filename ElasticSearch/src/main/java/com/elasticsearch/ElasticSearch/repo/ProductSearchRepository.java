package com.elasticsearch.ElasticSearch.repo;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.ElasticSearch.model.Product;

@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<Product, String>{

	List<Product> findByNameContaining(String name);
	List<Product> findByDescriptionContaining(String description);
	List<Product> findByBrandContaining(String brand);
	List<Product> findByNameOrDescription(String name, String desc);
}
