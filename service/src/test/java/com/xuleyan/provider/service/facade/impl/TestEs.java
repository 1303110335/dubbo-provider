///**
// * bianque.com
// * Copyright (C) 2013-2020 All Rights Reserved.
// */
//package com.xuleyan.provider.service.facade.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.alijk.bqcommon.search.entity.request.EsBaseRequest;
//import com.alijk.bqcommon.search.entity.request.EsScrollRequest;
//import com.alijk.bqcommon.search.entity.response.EsResult;
//import com.alijk.bqcommon.search.store.ElasticSearchStore;
//import com.xuleyan.provider.service.config.ESConfig2;
//import com.xuleyan.provider.service.config.EsConfig;
//import com.xuleyan.provider.service.domain.HealthCloudMainIndexLogVO;
//import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
//import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.action.search.SearchType;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.client.indices.GetIndexRequest;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// *
// * @author xuleyan
// * @version TestEs.java, v 0.1 2020-07-07 8:03 下午
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class TestEs {
//
//    @Autowired
//    private ESConfig2 esConfig2;
//
//    @Autowired
//    private EsConfig esConfig;
//
//    public final static String[] LOG_INDEX_FIELDS=new String[]{"creator","gmtCreate","content","type","request","response","ip"};
//
//
//    @Test
//    public void testBqTest() throws Exception {
//        ElasticSearchStore elasticSearchStore = esConfig.elasticSearchStore();
//        EsScrollRequest esBaseRequest = new EsScrollRequest();
//        esBaseRequest.setPageSize(0);
//        esBaseRequest.setPageNum(10);
//        esBaseRequest.setIndexs(new String[]{"bqhealth_cloud_main_index_log"});
//        esBaseRequest.setIncludeFields(LOG_INDEX_FIELDS);
//        //esBaseRequest.setBuilder(searchSourceBuilder);
//        EsResult<Map<String, Map>> search = elasticSearchStore.searchByScroll(esBaseRequest);
//
////        System.out.println(exist);
//        System.out.println(search.getData());
//    }
//
//    @Test
//    public void testBqTest2() throws Exception {
//        ElasticSearchStore elasticSearchStore = esConfig.elasticSearchStore();
//        EsBaseRequest esBaseRequest = new EsBaseRequest();
//        esBaseRequest.setPageSize(0);
//        esBaseRequest.setPageNum(10);
//        esBaseRequest.setIndexs(new String[]{"bqhealth_cloud_main_index_log"});
//        //esBaseRequest.setIncludeFields(LOG_INDEX_FIELDS);
//        //esBaseRequest.setBuilder(searchSourceBuilder);
//        EsResult<Map<String, Map>> search = elasticSearchStore.search(esBaseRequest);
//
////        System.out.println(exist);
//        System.out.println(search.getData());
//    }
//
//    @Test
//    public void testExist() throws IOException {
//        RestHighLevelClient client = esConfig2.getRestHighLevelClient();
//        GetIndexRequest request = new GetIndexRequest("bqhealth_cloud_main_index_log");
//        request.local(false);
//        request.humanReadable(true);
//        request.includeDefaults(false);
//        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
//        System.out.println(exists);
//    }
//
//    @Test
//    public void test() throws IOException {
////        HttpHost httpHost = new HttpHost("localhost", 9200, "http");
////        EsClientBuilder clientBuilder = EsClientBuilder.build(Arrays.asList(httpHost));
////        RestHighLevelClient client = clientBuilder.create();
//
//        RestHighLevelClient client = esConfig2.getRestHighLevelClient();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
//        //精确查询
////        boolQueryBuilder.must(QueryBuilders.termQuery("creator","xly"));
//        // 模糊查询
////        boolQueryBuilder.must(QueryBuilders.wildcardQuery("creator","xly*"));
//        // 范围查询
////        boolQueryBuilder.must(QueryBuilders.rangeQuery("id").gt(4));
//        // in 查询
////        boolQueryBuilder.must(QueryBuilders.termsQuery("id", "1", "2"));
//
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(boolQueryBuilder);
////        sourceBuilder.sort("field", SortOrder.ASC);
//
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.types("bqhealth_cloud_main_index_log");
//        searchRequest.searchType(SearchType.QUERY_THEN_FETCH);
//        searchRequest.source(sourceBuilder);
//        SearchResponse search = client.search(searchRequest);
//        if (search != null) {
//            SearchHit[] hits = search.getHits().getHits();
//            for (SearchHit hit : hits) {
//                HealthCloudMainIndexLogVO indexLogVO = JSON.parseObject(hit.getSourceAsString(), HealthCloudMainIndexLogVO.class);
//                System.out.println(indexLogVO);
//            }
//        }
//
//    }
//}