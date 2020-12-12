package com.hdxy.esdemo.demo01.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author wzh
 * @Description
 * @create 2020-12-12 11:29
 */
@Configuration
public class ESconfig {
    public RestHighLevelClient restHighLevelClient (){
        return new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost",9200,"http")));
    }
}
