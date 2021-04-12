package co.longbeom.kotdemo.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(appInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("co.longbeom.kotdemo"))
                .paths(PathSelectors.ant("/**"))
                .build()
    }

    fun appInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("KOTLIN DEMO APIs")
                .description("write by HongBeom Joo")
                .version("1.0.0")
                .build()
    }
}