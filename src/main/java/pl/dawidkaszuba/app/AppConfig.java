package pl.dawidkaszuba.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.dawidkaszuba.converter.StringAuthorConverter;
import pl.dawidkaszuba.converter.StringCategoryConverter;
import pl.dawidkaszuba.converter.StringDateConverter;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@ComponentScan("pl.dawidkaszuba")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver; }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("springcms");
        return emfb; }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringAuthorConverter());
        registry.addConverter(stringCategoryConverterConverter());
        registry.addConverter(stringDateConverter());

    }

    @Bean
    public StringAuthorConverter stringAuthorConverter(){
        return new StringAuthorConverter();
    }

    @Bean
    public StringCategoryConverter stringCategoryConverterConverter(){
        return new StringCategoryConverter();
    }

    @Bean
    public StringDateConverter stringDateConverter(){
        return new StringDateConverter();
    }

}