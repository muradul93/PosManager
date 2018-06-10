package posmanager.config;


import posmanager.reporting.ExcelView;
import posmanager.reporting.PdfView;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.dialect.springdata.SpringDataDialect;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Locale;

@Configuration
@EnableWebMvc
@Import({DBAConfiguration.class, SecurityConfig.class})
@ComponentScan(basePackages = {"posmanager.controller",
        "posmanager.service",
        "posmanager.formvalidator",
        "posmanager.config",
        "posmanager.restcontroller"})
public class MyApplicationConfig extends WebMvcConfigurerAdapter   {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home1").setViewName("home1");
        registry.addViewController("/403").setViewName("error/403");
        registry.addViewController("/404").setViewName("error/404");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/PosUser").setViewName("SalesMenu/Sales-sub-menu");
        registry.addViewController("/reporting").setViewName("reporting/reporitng-sub-menu");
        registry.addViewController("/setting").setViewName("Setting/Setting-sub-menu");
        registry.addViewController("/inventory").setViewName("Inventory/Inventory-sub-menu");
        registry.addViewController("/accounts").setViewName("Accounts/Accounts-sub-menu");
        registry.addViewController("/secondarySaleMenu").setViewName("secondarySaleMenu/secondary_cell_sub_menu");
        registry.addViewController("/hrEmployee").setViewName("hrMenu/hrSubMenu");
        registry.addViewController("/discountMenu").setViewName("/DiscountMenu/discount_menu");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/vendors/**").addResourceLocations("/vendors/");
        registry.addResourceHandler("/build/**").addResourceLocations("/build/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /****************** CONTENTNEGOTIATION CONFIGURATION *******************/

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ExcelView excelViewResolver() {
        return new ExcelView();
    }

    @Bean
    public PdfView PdfViewResolver() {
        return new PdfView();
    }


    /******************  LOCALIZATION *******************/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean(name ="messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/resources/blogmsg");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    /****************** MULTIPART RESOLVER *******************/

    @Bean(name="multipartResolver")
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setMaxUploadSizePerFile(10240); //10Kb
        /*resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);*/
        return resolver;
    }

    /****************** SIMPLE MAPPING EXCEPTION RESOLVER *******************/

    /*@Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver= new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        resolver.setExceptionMappings(mappings); // None by default
        resolver.setExceptionAttribute("ErrorOccurred"); // Default is "exception"
        resolver.setDefaultErrorView("error/500"); // 500.jsp
        return resolver;
    }*/

    /****************** THYMELEAF VIEWRESOLVE CONFIGURATION *******************/

    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.addDialect(new Java8TimeDialect());
        templateEngine.addDialect(new SpringDataDialect());
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        return thymeleafViewResolver;
    }


}