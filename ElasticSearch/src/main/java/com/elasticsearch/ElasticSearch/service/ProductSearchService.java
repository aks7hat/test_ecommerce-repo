package com.elasticsearch.ElasticSearch.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elasticsearch.ElasticSearch.dto.ProductDto;
import com.elasticsearch.ElasticSearch.mapper.ProductMapper;
import com.elasticsearch.ElasticSearch.model.Product;
import com.elasticsearch.ElasticSearch.repo.ProductSearchRepository;


@Service
public class ProductSearchService {

	@Autowired
    private ProductSearchRepository repository;
	
    @SuppressWarnings("deprecation")
	@Autowired
    private RestHighLevelClient restHighLevelClient;
	
//    public List<Product> searchByName(String query) throws IOException {
//
//        MultiMatchQueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery(query)
//                .field("name", 1.0f)       
//                .field("brand", 0.8f)  
//                .field("description", 0.5f)
//                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS);
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(multiMatchQuery);
//        searchSourceBuilder.size(6); 
//
//        SearchRequest searchRequest = new SearchRequest("products"); // Index name
//        searchRequest.source(searchSourceBuilder);
//
//        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        
//        List<Product> productList = new ArrayList<>();
//        for (SearchHit hit : searchResponse.getHits().getHits()) {
//        	Product product = ProductMapper.mapToProduct(hit.getSourceAsMap());            
//            productList.add(product);
//        }
//
//        return productList;
//    }
    
    
    public List<Product> searchProducts(String query) throws IOException {

//        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
//                .should(QueryBuilders.matchPhrasePrefixQuery("name", query).boost(2.0f))
//                .should(QueryBuilders.matchPhrasePrefixQuery("brand", query).boost(1.5f))
//                .should(QueryBuilders.matchPhrasePrefixQuery("description", query).boost(1.0f));
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
//                .query(boolQuery)
//                .size(10);
        
//        MultiMatchQueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery(query)
//                .field("name", 3.0f)
//                .field("brand", 2.0f)
//                .field("description", 2.5f)
//                .field("color", 2.5f)
//                .field("categoryName", 2.5f)
//                .field("categoryTypeName", 2.5f)
//                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS)
//                .operator(Operator.OR);
    	
    	String[] tokens = query.toLowerCase().split("\\s+");
    	BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
    	
        boolQuery.should(QueryBuilders.matchPhraseQuery("name", query).boost(5.0f));
        boolQuery.should(QueryBuilders.matchPhraseQuery("description", query).boost(4.0f));
        boolQuery.should(QueryBuilders.matchPhraseQuery("categoryName", query).boost(3.0f));
        boolQuery.should(QueryBuilders.matchPhraseQuery("categoryTypeName", query).boost(3.0f));
        boolQuery.should(QueryBuilders.matchPhraseQuery("brand", query).boost(2.0f));
        boolQuery.should(QueryBuilders.matchPhraseQuery("color", query).boost(2.0f));
        
        for (String token : tokens) {
            boolQuery.should(QueryBuilders.matchQuery("name", token).boost(3.0f).fuzziness(Fuzziness.AUTO));
            boolQuery.should(QueryBuilders.matchQuery("description", token).boost(2.0f).fuzziness(Fuzziness.AUTO));
            boolQuery.should(QueryBuilders.matchQuery("color", token).boost(1.5f).fuzziness(Fuzziness.AUTO));
            boolQuery.should(QueryBuilders.matchQuery("categoryName", token).boost(2.5f).fuzziness(Fuzziness.AUTO));
            boolQuery.should(QueryBuilders.matchQuery("categoryTypeName", token).boost(2.5f).fuzziness(Fuzziness.AUTO));
            boolQuery.should(QueryBuilders.matchQuery("brand", token).boost(1.8f).fuzziness(Fuzziness.AUTO));
        }

//        for (String token : tokens) {
//            boolQuery.should(QueryBuilders.termQuery("name", token));
//            boolQuery.should(QueryBuilders.termQuery("brand", token));
//            boolQuery.should(QueryBuilders.termQuery("description", token));
//            boolQuery.should(QueryBuilders.termQuery("color", token));
//            boolQuery.should(QueryBuilders.termQuery("categoryName", token));
//            boolQuery.should(QueryBuilders.termQuery("categoryTypeName", token));
//        }

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQuery);
        searchSourceBuilder.size(10);

        List<Map<String, Object>> searchResults = search("products", searchSourceBuilder);

        List<Product> products = new ArrayList<>();
        for (Map<String, Object> sourceMap : searchResults) {
            Product product = ProductMapper.mapToProduct(sourceMap);
            products.add(product);
        }

        return products;
    }
    
    public List<Map<String, Object>> search(String indexName, SearchSourceBuilder searchSourceBuilder) throws IOException {
        // Build the search request
        SearchRequest searchRequest = new SearchRequest(indexName);
        searchRequest.source(searchSourceBuilder);

        // Execute the search
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        // Parse the search hits
        List<Map<String, Object>> results = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            results.add(hit.getSourceAsMap());
        }

        return results;
    }
	
//	public List<Product> search(String query){
//		List<Product> products = repository.findByBrandContaining(query);
//		products.addAll(repository.findByNameContaining(query));
//		products.addAll(repository.findByDescriptionContaining(query));
//		return products;
////		return repository.findByNameOrDescription(query, query);
//	}
    
    public void saveProduct(ProductDto productDto) {
    	Product product = ProductMapper.mapProductDtoToProduct(productDto);
        repository.save(product);
    }
}
