package com.hopever.springexample.web.Config;

import com.hopever.springexample.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.hal.CurieProvider;
import org.springframework.hateoas.hal.DefaultCurieProvider;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Donghui Huo on 2015/12/28.
 */

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

    final static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    /*@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true).defaultContentType(
                MediaType.TEXT_HTML);
    }

   @Bean
    public ViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(jspViewResolver());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }

   @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }*/

    @Bean
    public HttpMessageConverters customConverters() {
        MarshallingHttpMessageConverter xmlConverter =
                new MarshallingHttpMessageConverter();

        XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstreamMarshaller);
        xmlConverter.setUnmarshaller(xstreamMarshaller);
        return new HttpMessageConverters(xmlConverter);
    }

    /*public class UserHttpMessageConverter extends AbstractHttpMessageConverter<User> {

        @Override
        protected boolean supports(Class<?> clazz) {
            if(clazz.getName().contains("User"))
                return true;
            return false;
        }

        @Override
        protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
            return new User("you know");
        }

        @Override
        protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
            user.setName(user.getName()+":finanlly");
        }


    }*/

/*
    @Bean
    public WebBindingInitializer customerBinding() {
        class CustomerBinding extends ConfigurableWebBindingInitializer {

            @Override
            public void initBinder(WebDataBinder binder, WebRequest request) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                binder.registerCustomEditor(Date.class, new CustomDateEditor(
                        dateFormat, false));
            }
        }
        return new CustomerBinding();
    }
*/

    @Bean
    public MessageCodesResolver customerMessageCodesResolver() {

        class customerMessageCodesResolver implements MessageCodesResolver {

            @Override
            public String[] resolveMessageCodes(String errorCode, String objectName) {
                String customErrorCode = "test errorCode custom/" + objectName + "/" + errorCode;
                logger.info(customErrorCode);
                return new String[]{customErrorCode};
            }

            @Override
            public String[] resolveMessageCodes(String errorCode, String objectName, String field, Class<?> fieldType) {
                String customErrorCode = "test errorCode custom/" + objectName + "/" + fieldType.getName() + "/" + field + errorCode;
                logger.info(customErrorCode);
                return new String[]{customErrorCode};
            }
        }
        return new customerMessageCodesResolver();
    }

    //for locale messages themeLeaf
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }

   /* @Bean
    public Converter getConverterTo() {
        final class StringToDate implements Converter<String,Date >  {

            public Date convert(String source) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return dateFormat.parse(source);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }

        }
        return new StringToDate();
    }

    @Bean
    public Converter getConverter() {
        final class DateToString implements Converter<Date, String> {

            public String convert(Date source) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.format(source);
            }

        }
        return new DateToString();
    }*/


    /*@Bean
    public ConversionService conversionService() {

        // Use the DefaultFormattingConversionService but do not register defaults
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        // Register date conversion with a specific global format
        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
        registrar.registerFormatters(conversionService);
        return conversionService;
    }*/

    /*@Override
    public void addFormatters(FormatterRegistry registry) {
        final class DateFormatter implements Formatter<Date> {

            private String pattern;

            public DateFormatter(String pattern) {
                this.pattern = pattern;
            }

            public String print(Date date, Locale locale) {
                if (date == null) {
                    return "";
                }
                return getDateFormat(locale).format(date);
            }

            public Date parse(String formatted, Locale locale) throws ParseException {
                if (formatted.length() == 0) {
                    return null;
                }
                return getDateFormat(locale).parse(formatted);
            }

            protected DateFormat getDateFormat(Locale locale) {
                DateFormat dateFormat = new SimpleDateFormat(this.pattern, locale);
                dateFormat.setLenient(false);
                return dateFormat;
            }

        }
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }*/

    @Override
    public void addFormatters(FormatterRegistry registry) {
        final class UserFormatter implements Formatter<User> {


            public UserFormatter() {
            }

            public String print(User user, Locale locale) {
                if (user == null) {
                    return "";
                }
                return user.getName() + "______" + new SimpleDateFormat("yyyy-MM").format(user.getBirthday());
            }

            public User parse(String formatted, Locale locale) throws ParseException {
                if (formatted.length() == 0) {
                    return null;
                }
                User user = new User();
                String[] strArr = formatted.split("______");
                user.setName(strArr[0]);
                user.setBirthday(new SimpleDateFormat("yyyy-MM").parse(strArr[1]));
                return user;
            }
        }
        registry.addFormatter(new UserFormatter());
    }


    //custom error
    /*@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new MyCustomizer();
    }

// ...

    private static class MyCustomizer implements EmbeddedServletContainerCustomizer {

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
        }

    }
*/
    @Bean
    public CurieProvider curieProvider() {
        return new DefaultCurieProvider("ex", new UriTemplate("http://www.example.com/rels/{rel}"));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //registry.addMapping("/rest/**");
            }
        };
    }

    /*@Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(9000);
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        return factory;
    }*/


}
