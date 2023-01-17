package com.yassir.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;





@Configuration
@EnableWebMvc
public class ResourceConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            String path= "file:///C:/Users/Lenovo/Desktop/work/SpringDemo/demo/src/main/resources/static/";
            registry.addResourceHandler("/resources/**").addResourceLocations(path);
            registry.addResourceHandler("/scripts/**").addResourceLocations(path+"scripts/");

        }
    
}
