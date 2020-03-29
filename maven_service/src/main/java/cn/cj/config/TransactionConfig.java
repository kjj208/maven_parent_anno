package cn.cj.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author kjj208
 * @create 2020-03-27 23:59
 */

public class TransactionConfig {

    @Bean(name="txManager")
    public DataSourceTransactionManager createTransactionManager(ComboPooledDataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
