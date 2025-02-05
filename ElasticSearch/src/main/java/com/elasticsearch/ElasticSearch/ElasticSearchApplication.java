package com.elasticsearch.ElasticSearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElasticSearchApplication {
	
	@Value("${rest.client.host.name}")
	private String host_name;
	
	@Value("${rest.client.port.name}")
	private int port_name;
	
	@Value("${rest.client.http.name}")
	private String http_name;

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchApplication.class, args);
	}
	
    @SuppressWarnings("deprecation")
	@Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host_name, port_name, http_name)
                )
        );
    }

}
