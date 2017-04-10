package com.leaf.school.config;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leaf.school.dto.session.Session;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.leaf.school.resolver.JsonViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages  = "com.leaf.school")
public class ApplicationContextConfig extends WebMvcConfigurerAdapter{
	
	public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer){
		contentNegotiationConfigurer.favorPathExtension(true).ignoreAcceptHeader(true)
				.useJaf(false).defaultContentType(MediaType.TEXT_HTML)
				.mediaType("html", MediaType.TEXT_HTML)
				.mediaType("xml", MediaType.APPLICATION_XML)
				.mediaType("json", MediaType.APPLICATION_JSON);
	}

	@Bean
	public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager contentNegotiationManager){
		ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
		cnvr.setContentNegotiationManager(contentNegotiationManager);

		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		resolvers.add(getTilesViewResolver());
		//resolvers.add(jsonViewResolver());

		cnvr.setViewResolvers(resolvers);
		return cnvr;

	}

	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}


	@Bean(name = "tilesConfigurer")
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		String[] tilesDefFiles = { "/WEB-INF/**/tiles.xml"};
		configurer.setDefinitions(tilesDefFiles);
		return configurer;
	}

	private ViewResolver getTilesViewResolver() {
		TilesViewResolver resolver = new TilesViewResolver();
		resolver.setContentType("text/html");
		return resolver;
	}

	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session session(){
		return new Session();
	}

	@Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {	
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");		
	
	}


	

}
