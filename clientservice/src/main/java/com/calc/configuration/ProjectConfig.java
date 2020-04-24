package com.calc.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "project")
@Validated
@Data
public class ProjectConfig {
	
	private FeignConfig feignConfig;
	
	
	@Data
	public static class FeignConfig {

		private ServiceConfig calculationService;
		

		/**
		 * 
		 *This is the common config for Feign client from application.properties
		 *
		 */
		@Data
		public static class ServiceConfig {
			private Integer readTimeout;
			private Integer connectTimeout;
		}
	}

}
