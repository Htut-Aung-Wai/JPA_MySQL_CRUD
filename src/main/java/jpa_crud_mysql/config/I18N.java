package jpa_crud_mysql.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class I18N implements WebMvcConfigurer {

    // Configuring the MessageSource for i18n
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");  // Specifies the base name of the message files (e.g., messages.properties)
        messageSource.setDefaultEncoding("UTF-8"); // Ensure correct encoding
        return messageSource;
    }

    // Configuring the Locale Resolver
   /* @Bean
    public AcceptHeaderLocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(Locale.ENGLISH);  // Default locale set to English
        return resolver; // Resolves locale based on the Accept-Language header
    }*/

   /* // Configuring Locale Change Interceptor
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");  // Allows the user to change locale via a URL parameter (e.g., ?lang=fr)
        return interceptor;
    }

    // Register the LocaleChangeInterceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());  // Add the interceptor to the registry
    }*/
}
