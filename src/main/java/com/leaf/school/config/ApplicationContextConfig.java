package com.leaf.school.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
		contentNegotiationConfigurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
	}
	
	@Bean
	public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager contentNegotiationManager){
		ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
		cnvr.setContentNegotiationManager(contentNegotiationManager);
		
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		resolvers.add(jsonViewResolver());
		resolvers.add(getViewResolver());
        
        cnvr.setViewResolvers(resolvers);
        return cnvr;
        
	}
	
	@Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }
	
	
	@Bean
	public ViewResolver  getViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();	    
	    viewResolver.setPrefix("/WEB-INF/jsp/");
	    viewResolver.setSuffix(".jsp");	      
	    return viewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/**/tiles.xml"});
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
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
