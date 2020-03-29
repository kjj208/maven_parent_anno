package cn.cj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author kjj208
 * @create 2020-03-28 15:10
 */
@Configuration
@Import(SpringConfiguration_service.class)
public class SpringConfiguration {
}
