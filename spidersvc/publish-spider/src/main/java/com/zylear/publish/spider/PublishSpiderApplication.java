package com.zylear.publish.spider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan("com.zylear.publish.spider.*")
@EnableAutoConfiguration(exclude = {
////		DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class,
//		MybatisAutoConfiguration.class,
////		DispatcherServletAutoConfiguration.class, /**如果需要自定义servlet dispatch,需要exclude*/
////		ErrorMvcAutoConfiguration.class,
////		RabbitAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})
public class PublishSpiderApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

	public static void main(String[] args) {
		SpringApplication.run(PublishSpiderApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PublishSpiderApplication.class);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
		configurableEmbeddedServletContainer.setContextPath("/spider");
		configurableEmbeddedServletContainer.setPort(8010);
	}
}
