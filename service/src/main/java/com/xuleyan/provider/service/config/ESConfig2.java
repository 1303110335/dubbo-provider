/**
 * bianque.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.xuleyan.provider.service.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuleyan
 * @version ESConfig.java, v 0.1 2020-07-07 8:01 下午
 */
//@Configuration
public class ESConfig2 {

    @Value("${elasticsearch.nodes}")
    private List<String> nodes;

    @Value("${elasticsearch.schema}")
    private String schema;

    @Value("${elasticsearch.max-connect-total}")
    private Integer maxConnectTotal;

    @Value("${elasticsearch.max-connect-per-route}")
    private Integer maxConnectPerRoute;

    @Value("${elasticsearch.connection-request-timeout-millis}")
    private Integer connectionRequestTimeoutMillis;

    @Value("${elasticsearch.socket-timeout-millis}")
    private Integer socketTimeoutMillis;

    @Value("${elasticsearch.connect-timeout-millis}")
    private Integer connectTimeoutMillis;


    @Bean
    public RestHighLevelClient getRestHighLevelClient() {

        List<HttpHost> httpHosts = new ArrayList<>();

        for (String node : nodes) {
            try {
                String[] parts = StringUtils.split(node, ":");
                Assert.notNull(parts,"Must defined");
                Assert.state(parts.length == 2, "Must be defined as 'host:port'");
                httpHosts.add(new HttpHost(parts[0], Integer.parseInt(parts[1]), schema));
            } catch (RuntimeException ex) {
                throw new IllegalStateException(
                        "Invalid ES nodes " + "property '" + node + "'", ex);
            }
        }

        return EsClientBuilder.build(httpHosts)
                .setConnectionRequestTimeoutMillis(connectionRequestTimeoutMillis)
                .setConnectTimeoutMillis(connectTimeoutMillis)
                .setSocketTimeoutMillis(socketTimeoutMillis)
                .setMaxConnectTotal(maxConnectTotal)
                .setMaxConnectPerRoute(maxConnectPerRoute)
                .create();


    }
}