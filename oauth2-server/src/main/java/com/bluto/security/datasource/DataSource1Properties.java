package com.bluto.security.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ${file_name}
 *
 * @author bluto
 * @Description: ${todo}
 * @date 2020/6/7 13:00
 */
@ConfigurationProperties(prefix = "db1.druid")
@Data
public class DataSource1Properties {

    static final String PACKAGE = "com.bluto.security.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    private String driverClass;

    private String url;

    private String username;

    private String password;

    private int initialSize;

    private int minIdle;

    private int maxActive;

    private int maxWait;

    private int timeBetweenEvictionRunsMillis;

    private int minEvictableIdleTimeMillis;

    private String validationQuery;

    private boolean testWhileIdle;

    private boolean testOnBorrow;

    private boolean testOnReturn;

    private boolean poolPreparedStatements;

    private int maxPoolPreparedStatementPerConnectionSize;

    private String filters;

    private String connectionProperties;

}
