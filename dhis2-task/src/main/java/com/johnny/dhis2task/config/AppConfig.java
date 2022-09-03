package com.johnny.dhis2task.config;

import lombok.extern.slf4j.Slf4j;
import org.hisp.dhis.Dhis2;
import org.hisp.dhis.Dhis2Config;
import org.hisp.dhis.query.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class AppConfig {

    @Bean
    public Dhis2 dhis2 () {
        Dhis2Config config = new Dhis2Config(
                "http://localhost:8080/johnny-dhis2demo",
                "admin",
                "district" );
        return  new Dhis2(config);
    }

    @Bean
    public Query query () {
        return Query.instance();
    }
}

