package es.diplock.examples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import es.diplock.examples.security.AuthInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
   @Autowired
    private AuthInterceptor authInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
               .addPathPatterns("/admin/**")
               .excludePathPatterns(
                   "/auth/**",
                   "/css/**", 
                   "/js/**", 
                   "/img/**"
               );
    }
}
