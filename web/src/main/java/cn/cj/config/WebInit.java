package cn.cj.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author kjj208
 * @create 2020-03-28 18:05
 */
public class WebInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        //扫描springmvc
        AnnotationConfigWebApplicationContext afw = new AnnotationConfigWebApplicationContext();
        afw.register(SpringMVCConfiguration.class);
        //添加dispatchservlet
        ServletRegistration.Dynamic springmvc = servletContext.addServlet("springmvc", new DispatcherServlet(afw));

        //添加映射文件路径
        springmvc.addMapping("/");

        //给springmvc添加启动时机
        springmvc.setLoadOnStartup(1);

        //设置编码过滤器
        servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true));

    }
}
