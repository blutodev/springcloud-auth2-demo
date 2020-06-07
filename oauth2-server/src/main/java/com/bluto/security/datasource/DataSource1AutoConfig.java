package com.bluto.security.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * ${file_name}
 *
 * @author bluto
 * @Description: ${todo}
 * @date 2020/6/7 13:19
 */
@EnableConfigurationProperties(DataSource1Properties.class)
@Configuration
@ConditionalOnClass(DataSource1Properties.class)
@MapperScan(basePackages = DataSource1Properties.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSource1AutoConfig {

    private DataSource1Properties prop;

    @Autowired
    public DataSource1AutoConfig(DataSource1Properties prop){
        this.prop = prop;
    }

    @Bean(name = "ds1")
    public DataSource dataSource1() {
        DruidDataSource fcDataSource = new DruidDataSource();
        fcDataSource.setDriverClassName(prop.getDriverClass());
        fcDataSource.setUrl(prop.getUrl());
        fcDataSource.setUsername(prop.getUsername());
        fcDataSource.setPassword(prop.getPassword());
        fcDataSource.setInitialSize(prop.getInitialSize());
        fcDataSource.setMinIdle(prop.getMinIdle());
        fcDataSource.setMaxActive(prop.getMaxActive());
        fcDataSource.setMaxWait(prop.getMaxWait());
        fcDataSource.setTimeBetweenEvictionRunsMillis(prop.getTimeBetweenEvictionRunsMillis());
        fcDataSource.setMinEvictableIdleTimeMillis(prop.getMinEvictableIdleTimeMillis());
        fcDataSource.setValidationQuery(prop.getValidationQuery());
        fcDataSource.setTestWhileIdle(prop.isTestWhileIdle());
        fcDataSource.setTestOnBorrow(prop.isTestOnBorrow());
        fcDataSource.setTestOnReturn(prop.isTestOnReturn());
        fcDataSource.setPoolPreparedStatements(prop.isPoolPreparedStatements());
        fcDataSource.setMaxPoolPreparedStatementPerConnectionSize(prop.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            fcDataSource.setFilters(prop.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fcDataSource;
    }

    // 配置事物管理
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager fcTransactionManager(@Qualifier("ds1") DataSource ds1) {
        return new DataSourceTransactionManager(ds1);
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory fcSqlSessionFactory(@Qualifier("ds1") DataSource ds1) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds1);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSource1Properties.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
