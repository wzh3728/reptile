package com.hdxy.esdemo.demo01;

import com.alibaba.fastjson.JSON;
import com.hdxy.esdemo.demo01.pojo.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Date;

@SpringBootTest
class Demo01ApplicationTests {
    @Autowired
    private RestHighLevelClient clent;

    @Test
    void contextLoads() throws IOException {
        CreateIndexRequest demo_01 = new CreateIndexRequest("demo_01");
        CreateIndexResponse createIndexResponse = clent.indices().create(demo_01, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
        System.out.println(clent);
    }

    @Test
    public void addDocumentTest() throws IOException {
        IndexRequest request = new IndexRequest("demo_01");
        request.type("user");
        request.id("1");
        User user = new User("hello", 23, new Date());
        request.source(JSON.toJSONString(user), XContentType.JSON);
        IndexResponse index = clent.index(request, RequestOptions.DEFAULT);
        System.out.println(index);
    }
}
