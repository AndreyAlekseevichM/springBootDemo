package ru.netology.springbootdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootdemo.profile.DevProfile;
import ru.netology.springbootdemo.profile.ProductionProfile;
import ru.netology.springbootdemo.profile.SystemProfile;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "false", matchIfMissing = true)
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
