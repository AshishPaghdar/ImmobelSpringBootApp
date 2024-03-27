package com.immobel.config;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SolrConfig {
    private static final String SOLR_URL = "http://192.168.0.194:8983/solr/";
    private static final String CORE_NAME = "immobel_core";

    @Bean
    public HttpSolrClient solrClient() {
        return new HttpSolrClient.Builder(SOLR_URL + CORE_NAME).build();
    }
}
