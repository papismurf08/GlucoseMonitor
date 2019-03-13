package monitor.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                /*.authorizeRequests()
                    .antMatchers("/", "/home").permitAll()
                    .anyRequest().access("hasRole('ROLE_USER')")*/
                .authorizeRequests()
                    .antMatchers("/create", "/category", "/views")
                        .access("hasRole('ROLE_USER')")
                    .antMatchers("/","/**").permitAll()
                    .anyRequest().authenticated()
                //this last line seems to fix forbidden issue
                .and()
                    .formLogin()
                        .loginPage("/login")

                .and()
                    .logout()
                        .logoutSuccessUrl("/")

                /*.and()
                    .csrf()
                        .ignoringAntMatchers("/h2-console/**")*/

                .and()
                    .headers()
                        .frameOptions()
                            .sameOrigin()
        ;
    }

    @Bean
    public PasswordEncoder encoder() {

        return new StandardPasswordEncoder("53cr3t");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());

    }
}