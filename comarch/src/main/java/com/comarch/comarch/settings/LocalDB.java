package com.comarch.comarch.settings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

@Configuration
public class LocalDB {

    @Bean
    @Primary
    DataSource embeddedPersistentDataSource() {

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:h2:~/test");
        driverManagerDataSource.setUsername("");

        return driverManagerDataSource;
    }
}
