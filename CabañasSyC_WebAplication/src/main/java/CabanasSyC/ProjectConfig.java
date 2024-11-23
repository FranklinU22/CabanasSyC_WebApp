package CabanasSyC;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class ProjectConfig implements WebMvcConfigurer {

   @Bean
   public LocaleResolver localResolver() {
      SessionLocaleResolver slr = new SessionLocaleResolver();
      slr.setDefaultLocale(Locale.getDefault());
      slr.setLocaleAttributeName("session.current.locale");
      slr.setTimeZoneAttributeName("session.current.timezone");
      return slr;
   }

   @Bean
   public LocaleChangeInterceptor localeChangeInterceptor() {
      LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
      lci.setParamName("lang");
      return lci;
   }

   public void addInterceptors(InterceptorRegistry registro) {
      registro.addInterceptor(this.localeChangeInterceptor());
   }

   public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/").setViewName("index");
      registry.addViewController("/index").setViewName("index");  
      registry.addViewController("/cabins/cabinsList").setViewName("/cabins/cabinsList");
      registry.addViewController("/tours/toursList").setViewName("/tours/toursList");
      registry.addViewController("/contact/contact").setViewName("/contact/contact");
      registry.addViewController("/login").setViewName("login");    
   }
   
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
         .authorizeHttpRequests((request) -> request
         .requestMatchers("/", "/index","/cabins","/contact/**", "/contact/contact","/contact/contact/**", "/cabins/cabinsList", "/tours/toursList", "/error/**","/errores/**", "/js/**","/css/**","/imgs/**")
         .permitAll()
         .anyRequest().authenticated()
         )
         .formLogin((form) -> form
         .loginPage("/login").permitAll())
         .oauth2Login((oauth2) -> oauth2
            .loginPage("/login") 
         )
         .logout((logout) -> logout.permitAll());
      return http.build();
   }

   @Autowired
   private UserDetailsService userDetailsService;
   @Autowired
   public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
      build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
   }
}
