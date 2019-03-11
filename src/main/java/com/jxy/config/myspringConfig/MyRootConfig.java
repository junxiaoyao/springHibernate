package com.jxy.config.myspringConfig;

import com.jxy.config.dataConfig.DataConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Auther: jxy
 * @Date: 2019/3/6 12:25
 * @Description:
 */
@Configuration
@EnableTransactionManagement
@Import(DataConfig.class)
@ComponentScan(basePackages = {"com.jxy.service","com.jxy.repository","com.jxy.config.securityConfig"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class MyRootConfig {
}
