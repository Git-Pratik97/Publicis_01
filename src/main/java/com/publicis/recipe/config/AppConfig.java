package com.publicis.recipe.config;

//import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(3000); // 3 seconds
        factory.setReadTimeout(5000); // 5 seconds

        return new RestTemplate(factory);
    }


    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("recipes");
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                    .info(new Info()
                            .title("Recipe API")
                            .version("1.0")
                            .description("API documentation for the Recipe Management System"));
    }
}





