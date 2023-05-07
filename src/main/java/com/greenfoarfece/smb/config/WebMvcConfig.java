package com.greenfoarfece.smb.config;

import com.greenfoarfece.smb.security.CustomUserDetailsService;
import com.greenfoarfece.smb.security.oauth.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity
public class WebMvcConfig extends WebSecurityConfigurerAdapter {

    @Override
	/*public void addViewControllers(ViewControllerRegistry routes) {
		routes.addViewController("/home").setViewName("homepage");
	}*/

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
                    .loginPage("/login")
                    .usernameParameter("userName")
                    .defaultSuccessUrl("/admin/user")
                .and()
                    .oauth2Login()
                    .loginPage("/login")
                    .userInfoEndpoint()
                    .userService(oauth2UserService)
                .and()
                .defaultSuccessUrl("/admin/user")
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
    }

    @Autowired
    private CustomOAuth2UserService oauth2UserService;

}
