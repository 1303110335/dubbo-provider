package com.xuleyan.provider.service.config;


import com.alijk.bqcommon.search.builder.ElasticSearchClientPool;
import com.alijk.bqcommon.search.conf.ElasticSearchConf;
import com.alijk.bqcommon.search.store.ElasticSearchStore;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * bqhealth-cloud
 *
 * @author xly
 * @date 2019/11/17
 */


@Configuration
public class EsConfig {


    @Value("${es.cluster.address}")
    private String esAddr;
       @Value("${es.user.name}")
    private String userName;
       @Value("${es.password}")
    private String password;



    @Bean(value = {"elasticSearchStore", "esStore"})
    public ElasticSearchStore elasticSearchStore() {
        ElasticSearchStore elasticSearchStore = new ElasticSearchStore();
        ElasticSearchConf esConf = new ElasticSearchConf();
        esConf.setMultiThread(false);
        esConf.setScheme("http");
        esConf.setShards(5);
        esConf.setReplicas(0);
        /* 市一6个节点数 */
        esConf.setDataNodes(6);
        esConf.setConnectTimeout(5000);
        esConf.setSocketTimeout(60000);
        esConf.setConnectRequestTimeout(60000);
        esConf.setMaxTotalConnection(8);
        esConf.setIndexNames("test");
        esConf.setMultiThread(false);

        try {
            esConf.setAddress(esAddr);
            esConf.setUsername(userName);
            esConf.setPassword(password);
            elasticSearchStore.setEsConf(esConf);
            elasticSearchStore.init();
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException("初始化es失败");
        }
        return elasticSearchStore;
    }

    /**
     * 索引是否存在
     *
     * @param index
     * @return
     * @throws IOException
     */
    public boolean indexExist(String index) throws Exception {
        GetIndexRequest request = new GetIndexRequest(index);
        request.local(false);
        request.humanReadable(true);
        request.includeDefaults(false);

        RestHighLevelClient client = null;
        try {
            client = ElasticSearchClientPool.getClient();
            return client.indices().exists(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new Exception("create elastic search index is error", e);
        } finally {
            ElasticSearchClientPool.returnClient(client);
        }


    }

}
