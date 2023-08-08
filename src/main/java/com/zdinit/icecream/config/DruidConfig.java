package com.zdinit.icecream.config;


//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *  使用yml配置文件配置，此类废弃
 * Druid数据源配置，更换数据源后不再使用springboot自动配置
 * 后台监控网址 http://localhost:8088/api/druid
 */
//@Configuration
public class DruidConfig {
//
//    /**
//     * 1.将自己配置的duirdDataSource加上@Bean注解添加到IOC容器中
//     * 2.将配置文件里的属性和DruidConfig绑定
//     * 3.为DruidConfig添加功能
//     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.druid")
//    public DataSource druiddDataSource(){
//        return new DruidDataSource();
//    }
//
//    /**
//     * 后台监控功能,代码是固定的.
//     * 这相当于在web.xml注册servlet.
//     * SpringBoot内置了Servlet容器,所以没有web.xml,ServletRegistrationBean是替代注册Servlet的一种方式.
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//
//        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//        HashMap<String,String> initParemeters = new HashMap<>();
//        //增加配置 用户名和用户密码, key固定的为loginUsername和loginPassword
//        initParemeters.put("loginUsername","admin");
//        initParemeters.put("loginPassword","111111");
//        //设置初始化参数
//        bean.setInitParameters(initParemeters);
//        return bean;
//    }
//
//    /**
//     * 注册Filter
//     * FilterRegistrationBean也是替代注册filter的一种方式
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//
//        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
//        bean.setFilter(new WebStatFilter());
//
//        //exclusions:设置哪些请求进行过滤排除掉,从而不进行统计
//        Map<String,String> initParameters = new HashMap<>();
//        initParameters.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
//        bean.setInitParameters(initParameters);
//
//        // /*表示过滤所有请求
//       // bean.setUrlPatterns(Arrays.asList("/*"));
//        bean.addUrlPatterns("/*");
//
//        return bean;
//    }

}
