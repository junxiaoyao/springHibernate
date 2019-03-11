package com.jxy.config.dataConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataConfig {
    //数据库url
    @Value("${spring.datasource.url}")
    private String dbUrl;
    //用户名
    @Value("${spring.datasource.username}")
    private String username;
    //密码
    @Value("${spring.datasource.password}")
    private String password;
    //驱动
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    //初始化链接数量
    @Value("${spring.datasource.initialSize}")
    private int initialSize;
    //池中保持的最小连接数
    @Value("${spring.datasource.minIdle}")
    private int minIdle;
    //最大连接数
    @Value("${spring.datasource.maxActive}")
    private int maxActive;
    //最大等待可以连接时间
    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    //是否对预处理语句（prepared statement）进行池管理
    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    //同一时间最大分配的预处理语句数量
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Bean     //声明其为Bean实例
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
        }
        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }

    //jdbcTemplate配置
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    //hibernate配置
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan(new String[]{"com.jxy.entity", "com.gwc.learn.spring.entity"});
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("autoCommit ", "true");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("format_sql", "true");
        //properties.setProperty("current_session_context_class","thread");
        // properties.setProperty("current_session_context_class","org.springframework.orm.hibernate4.SpringSessionContext");
        // properties.setProperty("current_session_context_class", "jta");
        sfb.setHibernateProperties(properties);
        return sfb;
    }

    @Bean
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManage = new HibernateTransactionManager(sessionFactory);
        return hibernateTransactionManage;
    }
}