package net.engineeringdigest.journalApp.config;

import net.engineeringdigest.journalApp.filter.JWTFilter;
import net.engineeringdigest.journalApp.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableWebSecurity
// @Profile("dev") -- keeps or tells which profile is active i.e. dev or prod
public class SpringSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JWTFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // pattern chaining
        http.authorizeRequests()
                .antMatchers("/journal/v2/**","/user/").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();
//                .and()
//                .httpBasic() -- for basic authentication -- commented as we are using jwt authentication if we want to use basic auth then we add this line
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // adding our jwt filter before usernamepasswordauthenticationfilter for jwt authentication
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception  {
        return super.authenticationManagerBean();
    }
}
