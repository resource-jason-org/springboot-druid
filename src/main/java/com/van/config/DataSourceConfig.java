package com.van.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    /**
     *
     *
     * @return
     */
    @Bean(name = "primaryDataSource")
    @Primary
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDatasource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     *
     *
     * @return
     */
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     *
     *
     * @return
     */
    @Bean(name = "tertiaryDataSource")
    @Qualifier("tertiaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.tertiary")
    public DataSource tertiaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     *
     *
     * @return
     */
    @Bean(name = "quaternaryDataSource")
    @Qualifier("quaternaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.quaternary")
    public DataSource quaternaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * 构建 jdbc template
     *
     * @param dataSource
     * @return
     */

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "tertiaryJdbcTemplate")
    public JdbcTemplate tertiaryJdbcTemplate(@Qualifier("tertiaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "quaternaryJdbcTemplate")
    public JdbcTemplate quaternaryJdbcTemplate(@Qualifier("quaternaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
