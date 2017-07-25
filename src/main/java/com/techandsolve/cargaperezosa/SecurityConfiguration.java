package com.techandsolve.cargaperezosa;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public FilterRegistrationBean securityFilterCross() {
		
		FilterRegistrationBean securityFilter=new FilterRegistrationBean(new CrossOriginFilter());
		securityFilter.setOrder(FilterRegistrationBean.REQUEST_WRAPPER_FILTER_MAX_ORDER+1);
		securityFilter.addInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "POST,GET,PUT,OPTIONS,HEAD,DELETE");
 		securityFilter.addInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Accept,Origin,Content-Type,gsec-user-token");
 		securityFilter.addInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, "false");
		return securityFilter;
	}

}
