package com.epam.ziggo.conf;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import com.epam.ziggo.service.UserClient;
import feign.Feign;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Value("${user.provider.url}")
    private String userProviderUrl;

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:config/liquibase/master.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

    @Bean
    public UserClient userClient(){
        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .retryer(new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(3L), 5))
            .target(UserClient.class, userProviderUrl);
    }
}
