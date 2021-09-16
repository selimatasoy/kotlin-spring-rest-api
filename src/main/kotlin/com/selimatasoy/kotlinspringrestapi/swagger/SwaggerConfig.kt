package com.selimatasoy.kotlinspringrestapi.swagger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig : WebMvcConfigurer {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2).select().apis(
            RequestHandlerSelectors.basePackage(
                SwaggerConfig::class.java.getPackage().name.substring(
                    0,
                    SwaggerConfig::class.java.getPackage().name.lastIndexOf(".")
                )
            )
        )
            .paths(PathSelectors.regex("/.*"))
            .build().apiInfo(apiEndPointsInfo())
    }

    private fun apiEndPointsInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("Kotlin Spring Rest API title")
            .description("Kotlin Spring Rest API description")
            .contact(Contact("Contact Name", "https://www.example.com/support", "contact@example.com"))
            .version("1.0")
            .license("No License")
            .licenseUrl("https://customlicenseurl.com")
            .build()
    }
}