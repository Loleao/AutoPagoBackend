package pe.com.AutoPago.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class OpenApiConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "https://autopagoapp-6df05.web.app")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
    @Bean
    public OpenAPI learningPlatformOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API")
                        .description("Application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                                        .externalDocs(new ExternalDocumentation()
                                                .description("Application wiki Documentation")
                                                .url(""));
    }
}
