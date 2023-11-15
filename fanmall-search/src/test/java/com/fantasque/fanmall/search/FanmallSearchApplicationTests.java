package com.fantasque.fanmall.search;

import com.alibaba.fastjson.JSON;
import com.fantasque.fanmall.search.config.ElasticsearchConfig;
import com.fantasque.fanmall.search.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FanmallSearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void searchData() throws IOException {
        //1.创建检索请求
        SearchRequest searchRequest = new SearchRequest();
        //指定索引
        searchRequest.indices("product");
        //指定DSL，检索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //构造检索条件
        //searchSourceBuilder.query();
        //searchSourceBuilder.from();
        //searchSourceBuilder.size();
        //searchSourceBuilder.aggregation();
        searchSourceBuilder.query(QueryBuilders.matchQuery("spuName", "华"));

        //构造聚合
        //(1.
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("id").size(10);//聚合名
        searchSourceBuilder.aggregation(ageAgg);
        //(2.
        AvgAggregationBuilder balanceAvg = AggregationBuilders.avg("balanceAvg").field("age");//聚合名
        searchSourceBuilder.aggregation(balanceAvg);

        searchRequest.source(searchSourceBuilder);
        //2.执行检索
        SearchResponse searchResponse = client.search(searchRequest, ElasticsearchConfig.COMMON_OPTIONS);
        //3.分析结果
        System.out.println(searchResponse);
        //Map map = JSON.parseObject(searchResponse.toString(), Map.class);
        //获取所有查到的数据
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        String sourceAsString = searchHits[0].getSourceAsString();
        System.out.println(sourceAsString);
    }

    @Test
    public void test1() throws IOException {
//        System.out.println(client);
        IndexRequest request = new IndexRequest("product").id("20")
                .source("spuName", "华为",
                        "id", 20L);
        try {
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            System.out.println(request.toString());
            IndexResponse response2 = client.index(request, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            if (e.status() == RestStatus.CONFLICT) {
            }
        }
    }

    @Test
    public void fantest() {
        String a = "_500";
        String[] s = a.split("_");
        for (String s1 : s) {
            System.out.println(s1);
        }
        System.out.println(s.length);
    }

    @Test
    public void test2() throws IOException {
        IndexRequest indexRequest = new IndexRequest("product");
        Product product = new Product();
        product.setSpuName("华为");
        product.setId(10L);
        String jsonString = JSON.toJSONString(product);
        indexRequest.id("1");
        indexRequest.source(jsonString, XContentType.JSON);
        IndexResponse response = client.index(indexRequest, ElasticsearchConfig.COMMON_OPTIONS);
        System.out.println(response);
    }

    @Setter
    @Getter
    class User {
        private int age;
        private String username;
        private String gender;
    }

}
