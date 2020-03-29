package cn.cj.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;


/**
 * @author kjj208
 * @create 2020-03-28 18:05
 */
@Configuration
@ComponentScan(basePackages = "cn.cj", useDefaultFilters = false,
includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
classes = Controller.class),

@ComponentScan.Filter(type = FilterType.ANNOTATION,
classes = Configuration.class)})
//Sring MVC  注解驱动（映射器跟适配器）
//@EnableWebMvc

public class SpringMVCConfiguration extends WebMvcConfigurationSupport {

    //把根目录下的静态资源放开，不过访问静态资源时，请求路径前要加上“/js/”

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //重写这个方法，映射静态资源文件
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/css/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");

        super.addResourceHandlers(registry);
    }

    //给访问jsp的请求加上前缀（“/WEB-INF/pages/”） 和后缀 (".jsp")

    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/pages/", ".jsp");
    }

    //这里表示，访问/hello3路径后，进入名为hello的视图去

 /*   @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello3").setViewName("hello");
    }*/


    //加了fastjson的依赖后，这里配置引用fastjson，以及设置编码

   /* protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setDefaultCharset(Charset.forName("UTF-8"));

        FastJsonConfig config = new FastJsonConfig();
        config.setCharset(Charset.forName("UTF-8"));

        converter.setFastJsonConfig(config);

        converters.add(converter);
    }*/
}
