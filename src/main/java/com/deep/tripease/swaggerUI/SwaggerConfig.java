package com.deep.tripease.swaggerUI;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is the swagger config
 * For generating the documentation
 * Of the api end-point in a project
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Trip Booking Backend Systems API")
                        .description("All api endpoint of trip ease")
                        .version("V.1.0"));
    }

}
