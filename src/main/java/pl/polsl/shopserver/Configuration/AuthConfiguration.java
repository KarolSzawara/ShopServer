package pl.polsl.shopserver.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return httpSecurity.build();

    }
}
