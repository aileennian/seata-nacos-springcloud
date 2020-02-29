package com.syx.nian.demo.ali.account.config.db;


import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;


@Configuration
public class SeataDataSourceConfig {
    public final static String SessionFactory = "sqlSessionFactoryProxy";
    @Autowired
    MybatisProperties mybatisProperties;

    //,destroyMethod = "close", initMethod = "init"
    @Bean("originDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid")
    @Order(5)
    @Primary
    public DataSource buildDruidDataSource() {
        //DruidDataSource datasource = DruidDataSourceBuilder.create().build();
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean("dataSourceProxy")
    @Autowired
    @Order(10)
    public DataSourceProxy buildDataSourceProxy(@Qualifier("originDataSource") DataSource dataSource) {
         DataSourceProxy proxy = new DataSourceProxy(dataSource);
         return proxy;
    }


    @Bean(SessionFactory)
    @Autowired
    @Order(20)
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceProxy")  DataSourceProxy dataSourceProxy) throws Exception {
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("originDataSource")  DataSource dataSourceProxy) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String mappingLocations =  StringUtils.arrayToDelimitedString(mybatisProperties.getMapperLocations(), ",");
        Resource[] mapperXmlResource = resolver.getResources(mappingLocations);
        sqlSessionFactory.setDataSource(dataSourceProxy);
        sqlSessionFactory.setMapperLocations(mapperXmlResource);
        try {
            return sqlSessionFactory.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Bean
    @Autowired
    @Order(20)
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSourceProxy") DataSourceProxy dataSourceProxy) {
        return new DataSourceTransactionManager(dataSourceProxy);
    }

}
