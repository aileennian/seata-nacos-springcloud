package com.syx.nian.demo.ali.account.config.db;


import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.autoconfigure.PageHelperProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ConditionalOnClass({DruidDataSource.class})
@EnableTransactionManagement
@MapperScan(basePackages = {"com.syx.nian.demo.ali.account.dao"})
@EnableConfigurationProperties({MybatisProperties.class, PageHelperProperties.class})
public class BaseDataSourceConfig {
//    public static SqlSessionFactoryBean buildSessionFactory(SqlSessionFactoryBean bean,
//            MybatisProperties mybatisProperties, Interceptor[] mybatisSqlInterceptors)
//            throws IOException {
//
//        Interceptor[] interceptor = getMybatisInterceptor(mybatisSqlInterceptors);
//        bean.setPlugins(interceptor);
//        bean.setVfs(SpringBootVFS.class);
//
//        String mappingLocations =  StringUtils.arrayToDelimitedString(mybatisProperties.getMapperLocations(), ",");
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource[] resources = resolver.getResources(mappingLocations);
//        bean.setMapperLocations(resources);
//
//        bean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());
//
//        org.apache.ibatis.session.Configuration configuration = this.mybatisProperties.getConfiguration();
//        if (configuration == null && !StringUtils.hasText(this.mybatisProperties.getConfigLocation())) {
//            configuration = new org.apache.ibatis.session.Configuration();
//        }
//        return bean;
//    }
//
//
//    protected Interceptor[] getMybatisInterceptor(Interceptor[] mybatisPlugins) {
//        PageInterceptor pageIpnterceptor = new PageInterceptor();
//        pageIpnterceptor.setProperties(pageHelperProperties.getProperties());
//
//        List<Interceptor> interceptorList = new ArrayList<Interceptor>();
//        //interceptorList.add(pageIpnterceptor);
//
//        if (mybatisPlugins != null) {
//            for (Interceptor i : mybatisPlugins) {
//                interceptorList.add(i);
//            }
//        }
//
//        Interceptor[] result = new Interceptor[interceptorList.size()];
//        return  interceptorList.toArray(result);
//    }
}
