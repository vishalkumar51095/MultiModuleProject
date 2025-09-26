package com.nic.MultiModuleProject.config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

@Service
public class DynamicDataSourceFactory {

    public DataSource createDataSource(String url, String username, String password, String driver) {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driver)
                .build();
    }
}
