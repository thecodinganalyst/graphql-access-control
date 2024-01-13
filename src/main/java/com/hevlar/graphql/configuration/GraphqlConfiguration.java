package com.hevlar.graphql.configuration;

import com.hevlar.graphql.graphql.CustomFieldVisibility;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer(){
        return builder -> builder.fieldVisibility(new CustomFieldVisibility());
    }
}
