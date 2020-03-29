package cn.cj.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.beans.PropertyVetoException;

/**
 * @author kjj208
 * @create 2020-03-27 23:20
 */
@Component
@PropertySource(value = {"jdbcConfig.properties"}, ignoreResourceNotFound = true)
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建ComboPooledDataSource
     *
     * @return
     */
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
       /* ds.setUser(username);
        ds.setPassword(password);
        ds.setJdbcUrl(url);
        ds.setDriverClass(driver);*/
        ds.setUser("root");// 用户姓名
        ds.setPassword("kjj208");// 用户密码
        ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/ssm?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8");// MySQL数据库连接url
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        return ds;
    }


    /**
     * 创建SqlSessionFactoryBean
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactory(ComboPooledDataSource dataSource) {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage("cn.cj.domain");
        return factory;
    }

    /**
     * 创建MapperScannerConfigurer
     * 将生成的代理类放到sping容器中
     *
     * @return
     */
    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer createMapperScannerConfigurer() {
        MapperScannerConfigurer mapper = new MapperScannerConfigurer();
        mapper.setBasePackage("cn.cj.dao");
        return mapper;
    }


}




