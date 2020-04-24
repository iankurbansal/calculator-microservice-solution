package com.calc.configuration.feign;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.calc.configuration.ProjectConfig;
import com.calc.configuration.ProjectConfig.FeignConfig.ServiceConfig;

import feign.Request;

@Component
public class CalculationServiceFeignConfig {

	@Autowired
	private ProjectConfig projectConfig;

	@Bean
	public Request.Options options() {
		System.out.println(projectConfig.getFeignConfig().getCalculationService().getConnectTimeout());
		ServiceConfig serviceConfig = projectConfig.getFeignConfig().getCalculationService();
	    return new Request.Options(serviceConfig.getConnectTimeout(),TimeUnit.MILLISECONDS, serviceConfig.getReadTimeout(), TimeUnit.MILLISECONDS,false);
	}
}
