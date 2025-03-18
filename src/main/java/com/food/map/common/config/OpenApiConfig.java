package com.food.map.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(
		title = "잡코 푸드 서비스",
		description = "잡코 푸드 서비스에 대해 설명하는 문서입니다.",
		version = "1.0"
),
	servers = {
		@Server(url = "https://quick-maudie-foodmap-c9af4ec2.koyeb.app", description = "koyeb Server"),
		@Server(url = "http://localhost:8080", description = "local")
	}
)
@Configuration
public class OpenApiConfig {

}
