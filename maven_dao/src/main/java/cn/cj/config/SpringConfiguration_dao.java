package cn.cj.config;


import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * spring的配置类，相当于bean.xml
 */
@Configuration
@ComponentScan(basePackages = "cn.cj",useDefaultFilters = true,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
@Import({JdbcConfig.class})


public class SpringConfiguration_dao {

}